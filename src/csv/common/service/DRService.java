package csv.common.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.domain.CurrentServedCustomer;
import csv.dr.dao.IDrDao;
import csv.dr.domain.SMSMessage;
import csv.security.dao.ISecurityDao;
import csv.security.domain.OperationNames;
import csv.security.domain.SMSLog;

@Name("drService")
@Stateless
@AutoCreate
public class DRService extends BaseService implements IDrService {

	@In(required=false, value="currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("drDao")
	private IDrDao drDao;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	@In(create=true)
	@Out(scope=ScopeType.PAGE, required=false)
	private List<String> smsRecipientList;
	
	@In(required=false, value="smsRecipient")
	@Out(required=false, scope=ScopeType.EVENT)
	private String smsRecipient = null;
	
	@In(required=false)
	@Out(scope=ScopeType.EVENT, required=false)
	private String smsContent;
	
	@In(required=false)
	@Out(scope=ScopeType.EVENT, required=false)
	private String reason;
	
	@Factory(value="smsRecipientList")
	public List<String> initSMSRecipientList() {
		this.smsRecipientList = new ArrayList<String>();
		if(currentCustomer != null) {
			addSMSRecipient(currentCustomer.getMsisdn());
		}
		return this.smsRecipientList;
	}
	
	public DRService() {
		super();
	}
	
	public List<String> getSmsRecipientList() {
		return smsRecipientList;
	}
	
	public void setSmsRecipientList(List<String> smsRecipientList) {
		this.smsRecipientList = smsRecipientList;
	}

	public String getSmsRecipient() {
		return smsRecipient;
	}

	public void setSmsRecipient(String smsRecipient) {
		this.smsRecipient = smsRecipient;
	}
	
	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void addSMSRecipient() {
		addSMSRecipient(smsRecipient);
		smsRecipient = null;
	}

	private void addSMSRecipient(String msisdn) {
		if(msisdn== null || msisdn.length() == 0) return;
		String recipient = new String(msisdn);
		if(!smsRecipientList.contains(recipient.trim())) smsRecipientList.add(recipient.trim());
	}
	
	public void removeSMSRecipient(String msisdn) {
		smsRecipientList.remove(msisdn.trim());
	}
	
	public void sendSMS() {
		try {
			for(String s : smsRecipientList) {
				createSMSMessage("258" + s, smsContent, reason);
			}
			facesMessages.add(Severity.INFO, "Operation completed successfully...");
			smsRecipientList = new ArrayList<String>();
			smsRecipient = "";
			reason = "";
			smsContent = "";
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Error in sending SMS: " + e.getMessage());
		}
	}

	@Override
	public void createSMSMessage(String msisdn, String text, String reason) {
		SMSMessage msg = new SMSMessage(msisdn, text);
		drDao.save(msg);
		logAccess(OperationNames.SendSMS, msisdn, text);
		SMSLog smslog = SMSLog.SMSLog(msisdn, msg.getCreationDate(), text, reason, loggedInUser);
		logger.debug("Will send SMS message to MSISDN " + msisdn + ": " + text);
		securityDao.save(smslog);
	}

	@Override
	public void removeAllRecipients() {
		smsRecipientList = new ArrayList<String>();
	}
	
	
}
