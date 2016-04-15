package csv.util.jbpm;

import org.jboss.seam.Component;
import org.jboss.seam.contexts.Lifecycle;
import org.jbpm.mail.AddressResolver;
import org.jbpm.svc.Service;
import org.jbpm.svc.ServiceFactory;

import csv.security.dao.ISecurityDao;
import csv.security.domain.User;

public class IdentityMailAddressResolver  implements AddressResolver, ServiceFactory, Service {

	public Object resolveAddress(String actorId) {
		try {
			Lifecycle.beginCall();
			ISecurityDao securityDao = (ISecurityDao)Component.getInstance("securityDao");
			User user = securityDao.findUserByUserName(actorId);
			return user.getEmail();
		} catch(Exception e) {
			throw new RuntimeException(e);
		} 
	}

	public Service openService() {
	    return this;
	}
	
	public void close() { }

}
