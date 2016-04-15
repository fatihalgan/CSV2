package csv.prepaid.service;

import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import co.mcel.mz.types.common.MsisdnType;

import com.bridge.arete.ema.model.HLRSub;
import com.bridge.arete.ema.serializer.EmaResponse;
import com.bridge.pm.client.ProvisionManagerServiceStub;
import com.bridge.pm.dao.IDBXDBDao;
import com.bridge.pm.dao.IProvisionManagerDao;
import com.bridge.pm.domain.ActiveProvisioning;
import com.bridge.pm.domain.SwapInfo;
import com.bridge.pm.types.CardProfile;
import com.bridge.pm.types.SwapInfoType;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.gateway.hlr.EMAGateway;
import csv.security.domain.OperationNames;
import csv.util.soap.AxisClientConfigurator;

@Name("SIMSwapService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class SIMSwapService extends BaseService implements ISIMSwapService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("provisionManagerDao")
	private IProvisionManagerDao provisionManagerDao;
	
	@In("dbxdbDao")
	private IDBXDBDao dbxdbDao;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisConfigurator;
	
	private ActiveProvisioning activeProvisioning;
	
	private SwapInfo swapInfo;
	
	private boolean subscriberValidated = false;
	
	private Long requestId;
	
	public SIMSwapService() {
		super();
	}
	
	public CurrentServedCustomer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(CurrentServedCustomer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public ActiveProvisioning getActiveProvisioning() {
		return activeProvisioning;
	}
	
	public SwapInfo getSwapInfo() {
		return swapInfo;
	}

	public void setSwapInfo(SwapInfo swapInfo) {
		this.swapInfo = swapInfo;
	}
	
	public boolean isSubscriberValidated() {
		return subscriberValidated;
	}
	
	public Long getRequestId() {
		return requestId;
	}

	public void loadProvisioningInfo() {
		subscriberValidated = false;
		try {
			requestId = null;
			activeProvisioning = provisionManagerDao.findActiveProvisioning(currentCustomer.getFullMsisdn());
			if(activeProvisioning == null) throw new RuntimeException("Subscriber cannot be located in the Provision Manager system..");
			swapInfo = new SwapInfo(currentCustomer.getFullMsisdn(), activeProvisioning.getImsi(), activeProvisioning.getSim(), activeProvisioning.getCardProfile());
			//Check if the subscriber also exists on the HLR
			subscriberValidated = subscriberExistsInEMA(swapInfo);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void requestSimSwap() {
		try {
			//Get the new IMSI which corresponds to new SIM from the BSCS
			String newImsi = dbxdbDao.getImsiForSim(swapInfo.getNewSim());
			//Set the new IMSI in SWAP Info
			swapInfo.setNewImsi(newImsi);
			validateNewImsiForSwap(swapInfo.getNewImsi());
			requestId = sendSimSwapRequest(swapInfo);
			facesMessages.add(Severity.INFO, "SIM Swap request was successfully sent to Provision Manager. The reference number of the request is: " + requestId);
			logAccess(OperationNames.PrepaidSIMSwap, currentCustomer.getFullMsisdn(), "New SIM: " + swapInfo.getNewSim() + ", New IMSI: " + swapInfo.getNewImsi());
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	private boolean subscriberExistsInEMA(SwapInfo swapInfo) {
		try {
			HLRSub hlrSub = emaGateway.getHLRSub(currentCustomer.getFullMsisdn());
			if(!hlrSub.getImsi().equals(swapInfo.getCurrentImsi())) 
				throw new RuntimeException("Subscriber has different IMSI in HLR and Provision Manager systems.."); 
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException("Cannot get Subscriber information from EMA: " + e.getMessage());
		}
		return true;
	}
	
	private void validateNewImsiForSwap(String imsi) {
		try {
			//Check if new imsi is being used by somebody else in HLR
			EmaResponse hlrResp = emaGateway.getHLRImsi(imsi);
			if(hlrResp.getResponseCode() != 13) throw new RuntimeException("New IMSI is already in use in HLR..");
			//Check if new imsi is active in Provision Manager(must not exist in active provisionings)
			List<ActiveProvisioning> provs = provisionManagerDao.findActiveProvisioningsByImsi(imsi);
			if(provs.size() > 0) throw new RuntimeException("New Imsi is already in use by another Subscriber in Provision Manager System..");
			//Check if new imsi is available(reserved) in the BSCS
			dbxdbDao.checkImsi(imsi);
		} catch(Exception e) {
			throw new RuntimeException("Cannot validate new IMSI for network consistency: " + e.getMessage());
		}
	}
	
	private Long sendSimSwapRequest(SwapInfo swapInfo) {
		try {
			ProvisionManagerServiceStub stub = axisConfigurator.getProvisionManagerServiceStub();
			SwapInfoType type = new SwapInfoType();
			type.setCurrentImsi(swapInfo.getCurrentImsi());
			type.setCurrentMsisdn(new MsisdnType());
			type.getCurrentMsisdn().setInternationalPrefix(swapInfo.getCurrentMsisdn().substring(0, 3));
			type.getCurrentMsisdn().setNumber(swapInfo.getCurrentMsisdn().substring(3));
			type.setCurrentSim(swapInfo.getCurrentSim());
			type.setCurrentCardProfile(CardProfile.Factory.fromValue(swapInfo.getCurrentCardProfile()));
			type.setNewImsi(swapInfo.getNewImsi());
			type.setNewMsisdn(type.getCurrentMsisdn());
			type.setNewSim(swapInfo.getNewSim());
			type.setNewCardProfile(CardProfile.Factory.fromValue(swapInfo.getNewCardProfile()));
			return stub.swapSim(type);
		} catch(Exception e) {
			throw new RuntimeException("Sending SIM Swap request to ProvisionManager service failed..");
		}
	}

	@Remove
	public void remove() {
		logger.debug("Destroying stateful component SIMSwapService...");		
	}
}
