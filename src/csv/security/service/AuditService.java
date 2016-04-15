package csv.security.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessage.Severity;
import csv.common.service.BaseService;
import csv.security.domain.AccessLog;
import csv.security.domain.User;

@Name("auditService")
@Stateless
@AutoCreate
public class AuditService extends BaseService implements IAuditService, Serializable {

	private static final long serialVersionUID = 6126656090350602931L;
	
	@In(scope=ScopeType.EVENT, required=false)
	private String newPassword;
	
	@In(scope=ScopeType.EVENT, required=false)
	private String confirmPassword;
	
	@DataModel(scope=ScopeType.PAGE)
	private List<AccessLog> auditLog = new ArrayList<AccessLog>();
	
	public AuditService() {
		super();
	}
	
	public List<AccessLog> getAuditLog() {
		return auditLog;
	}
	
	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void retrieveAccessLogEventsOfLoggedInUser() {
		try {
			auditLog = securityDao.findAccessLogEventsByUser(loggedInUser.getUsername());
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void changeMyPassword() {
		try {
			if(!(newPassword.equals(confirmPassword) && newPassword.length() > 0)) {
				facesMessages.add(Severity.ERROR, "New password and confirmation are not equal.. Please enter again.");
				return;
			}
			User user = securityDao.findUserByUserName(loggedInUser.getUsername());
			user.setPassword(newPassword);
			user.resetExpirationDate();
			securityDao.saveOrUpdate(user);
			loggedInUser = user;
			facesMessages.add(Severity.INFO, "Your password has been changed successfully..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not change password: " + e.getMessage());
		}
	}
}
