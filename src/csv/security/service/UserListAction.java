package csv.security.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;
import csv.security.dao.ISecurityDao;
import csv.security.domain.User;
import csv.util.soap.AxisClientConfigurator;

@Name("userListAction")
@Stateless
public class UserListAction implements IUserListAction, Serializable {
	
	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisClientConfigurator;
	
	@In(scope=ScopeType.PAGE, required=false)
	@Out(scope=ScopeType.PAGE, required=false)
	private User searchUser = null;
	
	@DataModel(scope=ScopeType.PAGE)
	private List<User> userList = null;
	
	@Factory(autoCreate=true, value="searchUser")
	public void initSearchUser() {
		searchUser = new User();
	}
	
	public void setAxisClientConfigurator(AxisClientConfigurator axisClientConfigurator) {
		this.axisClientConfigurator = axisClientConfigurator;
	}

	public User getSearchUser() {
		return searchUser;
	}

	public void setSearchUser(User searchUser) {
		this.searchUser = searchUser;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public void searchUsers() {
		userList = securityDao.findUsersByExample(searchUser);
	}
	
	public void deleteUser(User user) {
		try {
			//axisClientConfigurator.getCCT_UserRepoServiceStub().agentDelete(user.getUsername());
			securityDao.update(user);
			user.removeAllMemberships();
			securityDao.delete(user);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
		searchUsers();
	}
	
	public void resetSearch() {
		searchUser = new User();
		userList = null;
	}
}
