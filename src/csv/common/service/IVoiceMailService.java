package csv.common.service;

import javax.ejb.Local;

import csv.common.domain.VoiceMailOperation;

@Local
public interface IVoiceMailService {
	public void retrieveStatusFromVMS();
	public boolean isStatusQueried();
	public VoiceMailOperation getSelectedOperation();
	public void setSelectedOperation(VoiceMailOperation selectedOperation);
	public void runOperation();
	public String getVoiceMailStatus();
	public String getReason();
	public void setReason(String reason);
	public void remove();
}
