package csv.common.service;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.core.Events;
import org.jboss.seam.international.StatusMessage.Severity;

import com.bridge.arete.ema.model.HLRSub;

import csv.common.domain.CurrentServedCustomer;
import csv.common.domain.EMAOperation;
import csv.gateway.hlr.EMAGateway;
import csv.postpaid.dao.IBSCSDao;
import csv.prepaid.service.ISimRegistrationService;
import csv.security.domain.EMALog;
import csv.security.domain.OperationNames;

@Name("emaService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class EmaService extends BaseService implements IEmaService {

	@In
	private Events events;
	
	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	@In(create=true, value="SimRegistrationService")
	private ISimRegistrationService simRegistrationService;
	
	@In("bscsDao")
	private IBSCSDao bscsDao;
	
	private String hlrSettings;
	
	private String callForwardMsisdn;
	
	private EMAOperation selectedOperation;
	
	private String callForwardPrefix = "258";
	
	private String reason;
	
	public EmaService() {
		super();
	}
	
	public String getHlrSettings() {
		return hlrSettings;
	}
	
	public String getCallForwardMsisdn() {
		return callForwardMsisdn;
	}

	public void setCallForwardMsisdn(String callForwardMsisdn) {
		this.callForwardMsisdn = callForwardMsisdn;
	}

	public EMAOperation getSelectedOperation() {
		return selectedOperation;
	}

	public void setSelectedOperation(EMAOperation selectedOperation) {
		this.selectedOperation = selectedOperation;
	}
	
	public String getCallForwardPrefix() {
		return callForwardPrefix;
	}

	public void setCallForwardPrefix(String callForwardPrefix) {
		this.callForwardPrefix = callForwardPrefix;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void retrieveHLRSettings() {
		try {
			hlrSettings = null;
			HLRSub hlrSub = emaGateway.getHLRSub(currentCustomer.getFullMsisdn());
			hlrSettings = hlrSub.getMessage();
			logAccess(OperationNames.EMAGetStatus, currentCustomer.getFullMsisdn(), "");
			logEMAOperation(hlrSub);
			logger.debug("EMA Output: " + hlrSettings);
		} catch(Exception e) {
			logger.error("Exception in EMA GetHLRSub: ", e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
			hlrSettings = null;
		}
	}
	
	public void modifyHLRSettings() {
		try {
			validateModifyInputs();
			HLRSub hlrSub = new HLRSub(selectedOperation.getValue());
			if(selectedOperation.equals(EMAOperation.ACTIVATE_CALL_FORWARDING)) {
				hlrSub.setCfu("1,1," + (callForwardPrefix.startsWith("258") ? "" : callForwardPrefix) + callForwardMsisdn);
			}
			/**
			if(hlrSub.getOperation() == EMAOperation.ACTIVATE_SIM_CARD.getValue() || 
				hlrSub.getOperation() == EMAOperation.REMOVE_OUTGOING_CALL_BARRING.getValue() || 
				hlrSub.getOperation() == EMAOperation.DEACTIVATE_CALL_BARRING.getValue() ||
				hlrSub.getOperation() == EMAOperation.UNBAR_OUTGOING_SMS.getValue()) {
				boolean subscriberRegistered = false;
				try {
					subscriberRegistered = simRegistrationService.isSubscriberRegistered();
				} catch(Exception e) {
					throw new RuntimeException("Could not verify if the subscriber is registered: " + e.getMessage());
				}
				if(!subscriberRegistered) throw new RuntimeException("Subscriber is not registered. The operation has been rejected..");
			}
			**/
			emaGateway.setHLRSub(currentCustomer.getFullMsisdn(), hlrSub);
			if(hlrSub.getOperation() == EMAOperation.ACTIVATE_SIM_CARD.getValue()) {
				if(hlrSettings.contains("SIM CARD STATUS                             : NOT ACTIVE")) {
					logger.debug("Raising NewSIMCardActivated event for msisdn: " + currentCustomer.getMsisdn());
					events.raiseEvent("NewSIMCardActivated", currentCustomer);
				}
			}
			logAccess(OperationNames.EMAChangeStatus, currentCustomer.getFullMsisdn(), reason);
			logEMAOperation(hlrSub);
			facesMessages.add(Severity.INFO, "HLR Settings have been modified successfully..");
			retrieveHLRSettings();
			reason = null;
			callForwardMsisdn =null;
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "HLR Settings could not be modified: " + e.getMessage());
		}
	}
	
	private void validateModifyInputs() {
		if(bscsDao.subscriberExistsInPostpaid(currentCustomer.getFullMsisdn())) {
			throw new RuntimeException(getMessages().getString("errorEmaPostpaid"));
		}
		if(selectedOperation.equals(EMAOperation.ACTIVATE_CALL_FORWARDING)) {
			if(callForwardPrefix == null || callForwardPrefix.length() == 0) {
				throw new RuntimeException(getMessages().getString("errorEmaPrefix"));
			}
			if(callForwardMsisdn == null || callForwardMsisdn.length() != 9) {
				throw new RuntimeException(getMessages().getString("errorEmaMsisdn"));
			}
		}
	}
	
	private void logEMAOperation(HLRSub hlrSub) {
		EMALog emaLog = EMALog.getEmaLog(loggedInUser, currentCustomer.getFullMsisdn(), hlrSub.getOperation(), hlrSub.getCfu(), hlrSub.getRemark(), reason);
		securityDao.save(emaLog);
	}

	@Remove
	public void remove() {
		logger.debug("Removing stateful component EMAService..");		
	}
	
}

