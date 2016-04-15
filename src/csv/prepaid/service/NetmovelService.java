package csv.prepaid.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import co.mcel.mz.types.common.MsisdnType;

import com.bridge.netmovel.BalanceEnquiryResponse;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.prepaid.dao.INetmovelDao;
import csv.prepaid.dao.ISGSNStatsDao;
import csv.prepaid.netmovel.domain.BundleActivation;
import csv.prepaid.netmovel.domain.BundleName;
import csv.prepaid.netmovel.domain.DuoActivation;
import csv.prepaid.netmovel.domain.ResultCode;
import csv.prepaid.netmovel.domain.SGSNDataUsage;
import csv.prepaid.netmovel.domain.VoiceAddOnActivation;
import csv.security.domain.OperationNames;
import csv.util.soap.AxisClientConfigurator;

@Name("netmovelService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class NetmovelService extends BaseService implements INetmovelService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("netmovelDao")
	private INetmovelDao netmovelDao;
	
	@In("sgsnStatsDao") 
	private ISGSNStatsDao sgsnStatsDao;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisConfigurator;
	
	private List<BundleActivation> bundleActivations = new ArrayList<BundleActivation>();
	
	private List<DuoActivation> duoActivations = new ArrayList<DuoActivation>();
	
	private List<VoiceAddOnActivation> voiceAddOnActivations = new ArrayList<VoiceAddOnActivation>();
	
	private List<SGSNDataUsage> cdrHistory = new ArrayList<SGSNDataUsage>();
	
	private Date startDate;
	
	private BundleName selectedBundle;
	
	private Integer contractValue;
	
	private BalanceEnquiryResponse currentBundleStatus;
	
	private ResultCode operationResult;
	
	public NetmovelService() {
		super();
	}
	
	public List<BundleActivation> getBundleActivations() {
		return bundleActivations;
	}

	public void setBundleActivations(List<BundleActivation> bundleActivations) {
		this.bundleActivations = bundleActivations;
	}
	
	public List<DuoActivation> getDuoActivations() {
		return duoActivations;
	}

	public void setDuoActivations(List<DuoActivation> duoActivations) {
		this.duoActivations = duoActivations;
	}
	
	public List<VoiceAddOnActivation> getVoiceAddOnActivations() {
		return voiceAddOnActivations;
	}

	public void setVoiceAddOnActivations(
			List<VoiceAddOnActivation> voiceAddOnActivations) {
		this.voiceAddOnActivations = voiceAddOnActivations;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public BundleName getSelectedBundle() {
		return selectedBundle;
	}

	public void setSelectedBundle(BundleName selectedBundle) {
		this.selectedBundle = selectedBundle;
	}
	
	public Integer getContractValue() {
		return contractValue;
	}

	public void setContractValue(Integer contractValue) {
		this.contractValue = contractValue;
	}

	public BalanceEnquiryResponse getCurrentBundleStatus() {
		return currentBundleStatus;
	}

	public void setCurrentBundleStatus(BalanceEnquiryResponse currentBundleStatus) {
		this.currentBundleStatus = currentBundleStatus;
	}
	
	public ResultCode getOperationResult() {
		return operationResult;
	}

	public void setOperationResult(ResultCode operationResult) {
		this.operationResult = operationResult;
	}
	
	public List<SGSNDataUsage> getCdrHistory() {
		return cdrHistory;
	}

	@PostConstruct
	public void initialize() {
		startDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, -3);
		startDate.setTime(cal.getTimeInMillis());
	}
	
	@Override
	public void findNetmovelBundleActivations() {
		try {
			bundleActivations = netmovelDao.findBundleActivations(currentCustomer.getMsisdn(), startDate);
			logAccess(OperationNames.NetmovelPrepago, currentCustomer.getFullMsisdn(), "Get Activation History");
			if(bundleActivations.size() == 0) facesMessages.add(Severity.WARN, "No bundle purchases exist since the selected date..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot load bundle activations for this subscriber: " + e.getMessage());
		}
	}
	
	public void findNetmovelDuoActivations() {
		try {
			duoActivations = netmovelDao.findDuoActivations(currentCustomer.getMsisdn(), startDate);
			logAccess(OperationNames.NetmovelDUO, currentCustomer.getFullMsisdn(), "Get Subscription History");
			if(duoActivations.size() == 0) facesMessages.add(Severity.WARN, "No NTDUO subscriptions exist since the selected date..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot load NTDUO subscriptions for this subscriber: " + e.getMessage());
		}
	}
	
	public void findVoiceAddOnActivations() {
		try {
			voiceAddOnActivations = netmovelDao.findVoiceAddOnActivations(currentCustomer.getMsisdn(), startDate);
			logAccess(OperationNames.NetmovelVoiceAddOn, currentCustomer.getFullMsisdn(), "Get Subscription History");
			if(voiceAddOnActivations.size() == 0) facesMessages.add(Severity.WARN, "No Voice Add On subscriptions exist since the selected date..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot load Voice Add On subscriptions for this subscriber: " + e.getMessage());
		}
	}
	
	public void findCDRHistory() {
		try {
			cdrHistory = sgsnStatsDao.findSGSNDataUsage(currentCustomer.getFullMsisdn(), startDate);
			logAccess(OperationNames.NetmovelPrepago, currentCustomer.getFullMsisdn(), "Get CDR History");
			if(cdrHistory.size() == 0) facesMessages.add(Severity.WARN, "No usage record exist since the selected date..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot load usage history for this subscriber: " + e.getMessage());
		}
	}
	
	public void checkBalance() {
		try {
			MsisdnType msisdnType = new MsisdnType();
			msisdnType.setInternationalPrefix(currentCustomer.getPrefix());
			msisdnType.setNumber(currentCustomer.getMsisdn());
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdnType);
			if(currentBundleStatus.getResultCode() != 0) {
				addOperationStatusMessage(ResultCode.factory(currentBundleStatus.getResultCode()));
				currentBundleStatus = null;
			}
			logAccess(OperationNames.NetmovelPrepago, currentCustomer.getFullMsisdn(), "Check Balance");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot Get Balance: " + e.getMessage());
		}
	}
	
	public boolean isNetDuoAvailable() {
		if(currentBundleStatus == null) return true;
		if(currentBundleStatus.getCurrentActiveBundle() == null || currentBundleStatus.getCurrentActiveBundle().length() == 0) return true;
		if(currentBundleStatus.getCurrentActiveBundle().startsWith("DUO")) return true;
		return false;
	}
	
	public boolean isNetmovelPrepagoAvailable() {
		if(currentBundleStatus == null) return true;
		if(currentBundleStatus.getCurrentActiveBundle() == null || currentBundleStatus.getCurrentActiveBundle().length() == 0) return true; 
		if(currentBundleStatus.getCurrentActiveBundle().startsWith("NT")) return true;
		return false;
	}
	
	public boolean isVoiceAddOnAvailable() {
		if(currentBundleStatus == null) return true;
		if(currentBundleStatus.getCurrentActiveBundle() == null || currentBundleStatus.getCurrentActiveBundle().length() == 0) return true; 
		if(currentBundleStatus.getCurrentActiveBundle().startsWith("10") || currentBundleStatus.getCurrentActiveBundle().startsWith("5") ||
				currentBundleStatus.getCurrentActiveBundle().startsWith("30") ||
				currentBundleStatus.getCurrentActiveBundle().startsWith("50") ||
				currentBundleStatus.getCurrentActiveBundle().startsWith("100") ||
				currentBundleStatus.getCurrentActiveBundle().startsWith("250") ||
				currentBundleStatus.getCurrentActiveBundle().startsWith("1") ||
				currentBundleStatus.getCurrentActiveBundle().startsWith("3")) return true;
		return false;
	}
	
	
	
	public void terminateBundle() {
		try {
			MsisdnType msisdnType = new MsisdnType();
			msisdnType.setInternationalPrefix(currentCustomer.getPrefix());
			msisdnType.setNumber(currentCustomer.getMsisdn());
			operationResult = ResultCode.factory(axisConfigurator.getNetmovelServiceStub().stopBundle(msisdnType));
			addOperationStatusMessage(operationResult);
			logAccess(OperationNames.NetmovelPrepagoUpdateActivation, currentCustomer.getFullMsisdn(), "Terminate Bundle");
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdnType);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void extendBundle() {
		try {
			MsisdnType msisdnType = new MsisdnType();
			msisdnType.setInternationalPrefix(currentCustomer.getPrefix());
			msisdnType.setNumber(currentCustomer.getMsisdn());
			operationResult = ResultCode.factory(axisConfigurator.getNetmovelServiceStub().extendBundle(msisdnType));
			addOperationStatusMessage(operationResult);
			logAccess(OperationNames.NetmovelPrepagoUpdateActivation, currentCustomer.getFullMsisdn(), "Extend Bundle");
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdnType);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void activateBundle() {
		try {
			MsisdnType msisdnType = new MsisdnType();
			msisdnType.setInternationalPrefix(currentCustomer.getPrefix());
			msisdnType.setNumber(currentCustomer.getMsisdn());
			operationResult = ResultCode.factory(axisConfigurator.getNetmovelServiceStub().startBundle(msisdnType, selectedBundle.getValue()));
			addOperationStatusMessage(getOperationResult());
			logAccess(OperationNames.NetmovelPrepagoUpdateActivation, currentCustomer.getFullMsisdn(), "Purchase Bundle");
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdnType);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void activateVoiceAddOnBundle() {
		try {
			MsisdnType msisdnType = new MsisdnType();
			msisdnType.setInternationalPrefix(currentCustomer.getPrefix());
			msisdnType.setNumber(currentCustomer.getMsisdn());
			operationResult = ResultCode.factory(axisConfigurator.getNetmovelServiceStub().startVoiceAddOnBundle(msisdnType, selectedBundle.getValue()));
			addOperationStatusMessage(getOperationResult());
			logAccess(OperationNames.NetmovelPrepagoUpdateActivation, currentCustomer.getFullMsisdn(), "Purchase Bundle");
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdnType);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void activateNTDuo() {
		try {
			MsisdnType msisdn = new MsisdnType();
			msisdn.setInternationalPrefix(currentCustomer.getPrefix());
			msisdn.setNumber(currentCustomer.getMsisdn());
			operationResult = ResultCode.factory(axisConfigurator.getNetmovelServiceStub().activateNTDuo(msisdn, contractValue));
			addOperationStatusMessage(getOperationResult());
			logAccess(OperationNames.NetmovelDUOUpdateActivation, currentCustomer.getFullMsisdn(), "Activate NTDUO");
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdn);
			contractValue = null;
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void deactivateNTDuo() {
		try {
			MsisdnType msisdn = new MsisdnType();
			msisdn.setInternationalPrefix(currentCustomer.getPrefix());
			msisdn.setNumber(currentCustomer.getMsisdn());
			operationResult = ResultCode.factory(axisConfigurator.getNetmovelServiceStub().deactivateNTDuo(msisdn));
			addOperationStatusMessage(getOperationResult());
			logAccess(OperationNames.NetmovelDUOUpdateActivation, currentCustomer.getFullMsisdn(), "Deactivate NTDUO");
			currentBundleStatus = axisConfigurator.getNetmovelServiceStub().balanceEnquiry(msisdn);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private void addOperationStatusMessage(ResultCode resultCode) {
		if(resultCode.getValue() == 0) facesMessages.add(Severity.INFO, "Operation completed successfully..");
		else facesMessages.add(Severity.ERROR, resultCode.getLabel());
	}

	@Remove
	public void remove() {
		logger.debug("Removing component Netmovel Service..");		
	}
}
