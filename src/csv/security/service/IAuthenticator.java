package csv.security.service;

import javax.ejb.Local;

@Local
public interface IAuthenticator {

	public boolean authenticate();
	public void logout();
	
}
