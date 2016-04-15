package csv.prepaid.service;

import java.io.Serializable;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.bpm.BeginTask;
import org.jboss.seam.annotations.bpm.CreateProcess;
import org.jboss.seam.annotations.bpm.EndTask;
import org.jboss.seam.international.StatusMessage.Severity;

import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;
import co.mcel.mz.types.common.MsisdnType;

import com.bridge.arete.ema.model.HLRSub;
import com.bridge.ena.cs3cp6.command.GetBalanceAndDateCommand;
import com.bridge.pm.bpm.PrepaidToPostpaidMigrationRequestState;
import com.bridge.pm.dao.IProvisionManagerDao;
import com.bridge.pm.domain.ActiveProvisioning;
import com.bridge.pm.types.AccountInfoType;
import com.bridge.pm.types.AccountInfoTypeSequence_type0;
import com.bridge.pm.types.CardProfile;
import com.bridge.pm.types.DisconnectInfoType;
import com.bridge.pm.types.HlrInfoType;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.gateway.cs.AIRGateway;
import csv.gateway.hlr.EMAGateway;
import csv.util.soap.AxisClientConfigurator;

@Name("postpaidMigrationService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class PostpaidMigrationService extends BaseService implements IPostpaidMigrationService, Serializable {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("provisionManagerDao")
	private IProvisionManagerDao provisionManagerDao;
	
	private ActiveProvisioning activeProvisioning;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisConfigurator;
	
	@In("airGateway")
	private AIRGateway airGateway;
	
	private boolean subscriberValidated = false;
	
	@In(scope=ScopeType.BUSINESS_PROCESS, required=false)
	@Out(scope=ScopeType.BUSINESS_PROCESS, required=false)
	private PrepaidToPostpaidMigrationRequestState simMigrationState;
	
	public ActiveProvisioning getActiveProvisioning() {
		return activeProvisioning;
	}
	
	public PrepaidToPostpaidMigrationRequestState getSimMigrationState() {
		return simMigrationState;
	}

	public void setSimMigrationState(PrepaidToPostpaidMigrationRequestState simMigrationState) {
		this.simMigrationState = simMigrationState;
	}
	
	public boolean isSubscriberValidated() {
		return subscriberValidated;
	}

	@Begin(join=true, flushMode=FlushModeType.MANUAL)
	public void loadProvisioningInfo() {
		subscriberValidated = false;
		try {
			activeProvisioning = provisionManagerDao.findActiveProvisioning(currentCustomer.getFullMsisdn());
			if(activeProvisioning == null) throw new RuntimeException("Subscriber cannot be located in the Provision Manager system..");
			//Check if the subscriber also exists on the HLR
			subscriberValidated = subscriberExistsInEMA();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	private boolean subscriberExistsInEMA() {
		try {
			HLRSub hlrSub = emaGateway.getHLRSub(currentCustomer.getFullMsisdn());
			if(!hlrSub.getImsi().equals(activeProvisioning.getImsi())) 
				throw new RuntimeException("Subscriber has different IMSI in HLR and Provision Manager systems.."); 
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException("Cannot get Subscriber information from EMA: " + e.getMessage());
		}
		return true;
	}
	
	private AccountInfoType retrieveAccountInfo() throws ChargingSystemException {
		GetBalanceAndDateCommand cmd = (GetBalanceAndDateCommand)airGateway.getBalanceAndDate(simMigrationState.getMsisdn().substring(3));
		if(cmd.isErrorOrFaultResponse()) throw new RuntimeException("Failed to get account details from Charging System. Error Code: " + cmd.getFaultCode() + " - " + cmd.getFaultString());
		AccountInfoType actType = new AccountInfoType();
		MsisdnType msisdnType = new MsisdnType();
		msisdnType.setInternationalPrefix("258");
		msisdnType.setNumber(simMigrationState.getMsisdn().substring(3));
		actType.setMainAccountBalance(cmd.getSubscriberBalance(100f));
		actType.setMsisdn(msisdnType);
		if(cmd.getAccount().getServiceClassOriginal() == null) actType.setOriginServiceClass(cmd.getAccount().getServiceClassCurrent());
		else actType.setOriginServiceClass(cmd.getAccount().getServiceClassOriginal());
		actType.setServiceFeePeriodExpiryDate(cmd.getServiceFeeExpiryDate());
		actType.setSupervisionPeriodExpiryDate(cmd.getSupervisionExpiryDate());
		actType.setAccountInfoTypeSequence_type0(new AccountInfoTypeSequence_type0());
		return actType;
	}
	
	private DisconnectInfoType retrieveDisconnectInfo(AccountInfoType accountInfo) {
		DisconnectInfoType disType = new DisconnectInfoType();
		disType.setMsisdn(accountInfo.getMsisdn());
		disType.setImsi(simMigrationState.getImsi());
		disType.setSim(simMigrationState.getSim());
		CardProfile profile = CardProfile.Factory.fromValue(simMigrationState.getCardProfile());
		disType.setCardProfile(profile);
		return disType;
	}
	
	private HlrInfoType retrieveHLRInfo(AccountInfoType accountInfo) {
		HlrInfoType hlrType = new HlrInfoType();
		hlrType.setBusinessPlan(accountInfo.getOriginServiceClass());
		CardProfile profile = CardProfile.Factory.fromValue(simMigrationState.getCardProfile());
		hlrType.setCardProfile(profile);
		hlrType.setImsi(simMigrationState.getImsi());
		hlrType.setMasterSubscriberNumber(accountInfo.getMsisdn());
		hlrType.setMsisdn(accountInfo.getMsisdn());
		hlrType.setSim(simMigrationState.getSim());
		hlrType.setOrganizationId(1);
		hlrType.setTempBlockingStatus("CLEAR");
		return hlrType;
	}
	
	@CreateProcess(definition="PrepaidToPostpaidMigration", processKey="#{simMigrationState.requestId}")
	public void initiateMigrationProcess() {
		try {
			long requestId = provisionManagerDao.fetchProvisioningRequestId();
			simMigrationState = new PrepaidToPostpaidMigrationRequestState(requestId, activeProvisioning.getMsisdn(), activeProvisioning.getImsi(), activeProvisioning.getSim(), activeProvisioning.getCardProfile());
			facesMessages.add(Severity.INFO, "New Prepaid to Postpaid Migration process has been initiated with process id: " + requestId);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Migration process could not be initiated: " + e.getMessage());
		}
	}
	
	@BeginTask
	public void attendMigrationRequest() {
		
	}
	
	@EndTask(ifOutcome={"Success"})
	public String passRiskAnalysis() {
		try {
			simMigrationState.setPassedRiskAnalysis(true);
			AccountInfoType accInfo = retrieveAccountInfo();
			DisconnectInfoType discInfo = retrieveDisconnectInfo(accInfo);
			HlrInfoType hlrInfo = retrieveHLRInfo(accInfo);
			Long requestId = axisConfigurator.getProvisionManagerServiceStub().migratePrepaidToPostpaid(simMigrationState.getRequestId(), hlrInfo, discInfo, accInfo);
			facesMessages.add(Severity.INFO, "Risk analysis passed. The request to delete the subscriber from prepaid system has been submitted to Provision Manager.");
			facesMessages.add(Severity.INFO, "The ID of the migration request is: " + requestId);
			return "Success";
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Risk analysis result could not be submitted: " + e.getMessage());
			return null;
		}
	}
	
	@EndTask(ifOutcome={"Success"})
	public String rejectRiskAnalysis() {
		try {
			simMigrationState.setPassedRiskAnalysis(false);
			facesMessages.add(Severity.INFO, "Risk analysis did not pass. The migration process has been rejected.");
			return "Success";
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Risk analysis result could not be submitted: " + e.getMessage());
			return null;
		}
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component PostpaidMigrationService..");
	}

}
