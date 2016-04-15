package csv.security.service;

import java.util.List;

import javax.ejb.Local;

import csv.security.domain.AccessLog;

@Local
public interface IAuditService {
	public void retrieveAccessLogEventsOfLoggedInUser();
	public void changeMyPassword();
	public String getNewPassword();
	public void setNewPassword(String newPassword);
	public String getConfirmPassword();
	public void setConfirmPassword(String confirmPassword);
	public List<AccessLog> getAuditLog();
}
