package csv.prepaid.service;

import javax.ejb.Local;

@Local
public interface ISimRegistrationService {
	
	public boolean isSubscriberRegistered();
	public void remove();
}
