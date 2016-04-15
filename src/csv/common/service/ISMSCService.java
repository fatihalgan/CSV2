package csv.common.service;

import javax.ejb.Local;

@Local
public interface ISMSCService {
	public boolean isPendingMessages();
	public void queryPendingMessages();
	public void retryPendingMessages();
	public void cancelPendingMessages();
	public void remove();
}
