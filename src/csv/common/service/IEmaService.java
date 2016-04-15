package csv.common.service;

import javax.ejb.Local;

import csv.common.domain.EMAOperation;

@Local
public interface IEmaService {

	public void retrieveHLRSettings();
	public void modifyHLRSettings();
	public String getHlrSettings();
	public String getCallForwardMsisdn();
	public void setCallForwardMsisdn(String callForwardMsisdn);
	public String getCallForwardPrefix();
	public void setCallForwardPrefix(String callForwardPrefix);
	public EMAOperation getSelectedOperation();
	public void setSelectedOperation(EMAOperation selectedOperation);
	public String getReason();
	public void setReason(String reason);
	public void remove();
}
