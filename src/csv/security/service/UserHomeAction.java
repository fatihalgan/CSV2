package csv.security.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.convert.Converter;

import org.hibernate.Session;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.service.BaseService;
import csv.faces.converters.GroupListShuttleConverter;
import csv.security.domain.Group;
import csv.security.domain.User;
import csv.util.soap.AxisClientConfigurator;

@Name("userHomeAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class UserHomeAction extends BaseService implements IUserHomeAction, Serializable {

	@In("csvHibernateSession")
	private Session session;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisClientConfigurator;
	
	@In
	private Renderer renderer;
	
	private User selectedUser = null;
	
	private List<Group> unselectedGroups;
	private List<Group> selectedGroups;
	
	public void setAxisClientConfigurator(AxisClientConfigurator axisClientConfigurator) {
		this.axisClientConfigurator = axisClientConfigurator;
	}
	
	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}

	public List<Group> getUnselectedGroups() {
		return unselectedGroups;
	}

	public void setUnselectedGroups(List<Group> unselectedGroups) {
		this.unselectedGroups = unselectedGroups;
	}

	public List<Group> getSelectedGroups() {
		return selectedGroups;
	}

	public void setSelectedGroups(List<Group> selectedGroups) {
		this.selectedGroups = selectedGroups;
	}

	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public void editUser(User editUser) {
		selectedUser = editUser;
		securityDao.attach(selectedUser);
		securityDao.attachAll(selectedUser.getMemberships());
		selectedGroups = new ArrayList<Group>(selectedUser.getMemberships());
		unselectedGroups = securityDao.findAllGroups();
		unselectedGroups.removeAll(selectedGroups);
	}
	
	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public void newUser() {
		selectedUser = new User();
		selectedGroups = new ArrayList<Group>();
		unselectedGroups = securityDao.findAllGroups();
	}
	
	@End
	public void saveUser() {
		try {
			//if(selectedUser.getId() == null) axisClientConfigurator.getCCT_UserRepoServiceStub().agentInsert(selectedUser.getUsername(), selectedUser.getPassword(), selectedUser.getEmail());
			securityDao.saveOrUpdate(selectedUser);		
			selectedUser.updateMemberships(selectedGroups);
			securityDao.flush();
			cancelSave();
			facesMessages.add(Severity.INFO, "User info updated successfully..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot update user info: " + e.getMessage());
		}
	}
	
	@End
	public void changePassword() {
		try {
			//axisClientConfigurator.getCCT_UserRepoServiceStub().userUpdatePassword(selectedUser.getUsername(), selectedUser.getPassword());
			selectedUser.resetExpirationDate();
			securityDao.update(selectedUser);
			securityDao.flush();
			sendPasswordResetMail();
			cancelSave();
			facesMessages.add(Severity.INFO, "Password has been changed..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not change password: " + e.getMessage());
		}
	}
	
	@End
	public void resetPassword() {
		try {
			selectedUser.generatePassword();
			//axisClientConfigurator.getCCT_UserRepoServiceStub().userUpdatePassword(selectedUser.getUsername(), selectedUser.getPassword());
			securityDao.update(selectedUser);
			securityDao.flush();
			sendPasswordResetMail();
			cancelSave();
			facesMessages.add(Severity.INFO, "Password has been reset and sent to user via e-mail..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not reset password: " + e.getMessage());
		}
	}
	
	private void sendPasswordResetMail() {
		try {
			logger.debug("Will send new password to user: " + selectedUser.getUsername());
			renderer.render("/sysadm/send_password_mail.xhtml");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not send password reset email: " + e.getMessage());
		}
	}
	
	@End
	public void cancelSave() {
		selectedUser = null;
		unselectedGroups = null;
		selectedGroups = null;
	}
	
	public Converter getGroupListShuttleConverter() {
		return new GroupListShuttleConverter(unselectedGroups, selectedGroups);
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component UserHomeAction..");
	}
	
}
