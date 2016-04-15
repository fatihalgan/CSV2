package csv.common.service;

import java.util.List;

import javax.ejb.Local;

@Local
public interface IDrService {

	public List<String> initSMSRecipientList();
	public List<String> getSmsRecipientList();
	public void setSmsRecipientList(List<String> smsRecipientList);
	public String getSmsRecipient();
	public void setSmsRecipient(String smsRecipient);
	public String getSmsContent();
	public void setSmsContent(String smsContent);
	public String getReason();
	public void setReason(String reason);
	public void addSMSRecipient();
	public void removeAllRecipients();
	public void removeSMSRecipient(String msisdn);
	public void sendSMS();
	public void createSMSMessage(String msisdn, String text, String reason);
}
