package csv.common.service;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.domain.CurrentServedCustomer;
import csv.gateway.smsc.SMSCGateway;
import csv.security.domain.OperationNames;

@Name("smscService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class SMSCService extends BaseService implements ISMSCService {

	private static final long serialVersionUID = 5267507021885010225L;

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("smscGateway")
	private SMSCGateway smscGateway;
	
	private boolean pendingMessages = false;
	
	public SMSCService() {
		super();
	}
	
	public boolean isPendingMessages() {
		return pendingMessages;
	}

	@Override
	public void queryPendingMessages() {
		try {
			pendingMessages = smscGateway.hasPendingMessages(currentCustomer.getMsisdn());
			if(pendingMessages) facesMessages.add("There are pending messages on the SMSC for the subscriber..");
			else facesMessages.add("There are no pending messages on the SMSC for the subscriber..");
			logAccess(OperationNames.SmsManage, currentCustomer.getFullMsisdn(), "Query Pending Messages");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retryPendingMessages() {
		try {
			boolean success = smscGateway.retryMessages(currentCustomer.getMsisdn());
			if(success) {
				pendingMessages = false;
				facesMessages.add(Severity.INFO, "Pending messages on queue have been re-submitted..");
			} else {
				facesMessages.add(Severity.ERROR, "Pending messages on queue have not been re-submitted..");
				queryPendingMessages();
			}
			logAccess(OperationNames.SmsManage, currentCustomer.getFullMsisdn(), "Retry Pending Messages");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not submit pending messages: " + e.getMessage());
		}
	}
	
	public void cancelPendingMessages() {
		try {
			boolean success = smscGateway.cancelMessages(currentCustomer.getMsisdn());
			if(success) {
				pendingMessages = false;
				facesMessages.add(Severity.INFO, "Pending messages on queue have been deleted..");
			} else {
				facesMessages.add(Severity.ERROR, "Pending messages on queue have not been deleted..");
				queryPendingMessages();
			}
			logAccess(OperationNames.SmsManage, currentCustomer.getFullMsisdn(), "Cancel Pending Messages");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not delete pending messages: " + e.getMessage());
		}
	}

	@Remove
	public void remove() {
		logger.debug("Removing stateful component SMSCService..");		
	}
}
