package csv.common.service;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import com.bridge.arete.reflection.model.GenericReflectionModel;
import com.bridge.arete.reflection.serializer.ReflectionResponse;

import csv.common.domain.CurrentServedCustomer;
import csv.common.domain.VoiceMailOperation;
import csv.gateway.voicemail.VoiceMailGateway;
import csv.security.domain.OperationNames;

@Name("voiceMailService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class VoiceMailService extends BaseService implements IVoiceMailService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("voiceMailGateway")
	private VoiceMailGateway voiceMailGateway;
	
	private String voiceMailStatus;
	
	private VoiceMailOperation selectedOperation;
	
	private String reason;
	
	private boolean msisdnFound = false;
	
	private boolean statusQueried = false;
	
	public VoiceMailService() {
		super();
	}
	
	public String getVoiceMailStatus() {
		return voiceMailStatus;
	}
	
	public VoiceMailOperation getSelectedOperation() {
		return selectedOperation;
	}

	public void setSelectedOperation(VoiceMailOperation selectedOperation) {
		this.selectedOperation = selectedOperation;
	}
	
	public boolean isStatusQueried() {
		return statusQueried;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void retrieveStatusFromVMS() {
		try {
			ReflectionResponse response = voiceMailGateway.readSubscriberSettings(currentCustomer.getMsisdn());
			logAccess(OperationNames.VoiceMailService, currentCustomer.getFullMsisdn(), "Read Voice Mail settings");
			if(null == response.getResponseCode() || 0 == response.getResponseCode().intValue()){
				voiceMailStatus = response.getResponse();
				msisdnFound = true;
				statusQueried = true;
				facesMessages.add(Severity.INFO, "Voice mail is active for Subscriber " + currentCustomer.getMsisdn());
			} else {
				msisdnFound = false;
				statusQueried = true;
				voiceMailStatus = null;
				facesMessages.add(Severity.ERROR, "The Subscriber does not exist in the VMS!");
			}
		} catch(Exception e) {
			logger.error(e);
			msisdnFound = false;
			statusQueried = false;
			voiceMailStatus =  null;
			facesMessages.add(Severity.ERROR, "Cannot read voice mail settings for subscriber: " + e.getMessage());
		}
	}
	
	public void runOperation() {		
		try {
			validateOperation();
			GenericReflectionModel model = new GenericReflectionModel(selectedOperation.getValue(), currentCustomer.getMsisdn());
			voiceMailGateway.setSubscriberSettings(model.getType(), currentCustomer.getMsisdn(), model.getArguments());
			msisdnFound = model.getType().equals("C");
			logAccess(OperationNames.VoiceMailService, currentCustomer.getFullMsisdn(), model.getRemark() + " " + reason);
			facesMessages.add(Severity.INFO, model.getSuccessMessage());
			retrieveStatusFromVMS();
			reason = null;
		} catch (Exception e) {			
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot update voice mail settings for subscriber: " + e.getMessage());
		}		
	}
	
	private void validateOperation() {
		if(!statusQueried) throw new RuntimeException("Please Get msisdn Status from VMS first.");
		if(selectedOperation.getValue() < 2) {
			if(msisdnFound) throw new RuntimeException("The Subscriber already exists in the VMS, create operation is not permitted.");
		} else if(selectedOperation.getValue() == 2) {
			if(!msisdnFound) throw new RuntimeException("The Subscriber does not exist in the VMS, delete operation not possible.");
		} else if(selectedOperation.getValue() < 6) {
			if(!msisdnFound) throw new RuntimeException("The Subscriber does not exist in the VMS, modification is not possible.");
		}
		
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component VoiceMail service..");
	}
}
