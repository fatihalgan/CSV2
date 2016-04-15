package csv.security.service;

import java.util.List;

import javax.ejb.Local;

import csv.security.domain.User;

@Local
public interface IUserListAction {

	public User getSearchUser();
	public void setSearchUser(User searchUser);
	public List<User> getUserList();
	public void setUserList(List<User> userList);
	public void searchUsers();
	public void deleteUser(User user);
	public void resetSearch();
	public void initSearchUser();
}
