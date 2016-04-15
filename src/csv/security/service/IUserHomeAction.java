package csv.security.service;

import java.util.List;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import csv.security.domain.Group;
import csv.security.domain.User;

@Local
public interface IUserHomeAction {

	public void editUser(User editUser);
	public void newUser();
	public void saveUser();
	public void changePassword();
	public void resetPassword();
	public void cancelSave();
	public User getSelectedUser();
	public void setSelectedUser(User selectedUser);
	public List<Group> getUnselectedGroups();
	public void setUnselectedGroups(List<Group> unselectedGroups);
	public List<Group> getSelectedGroups();
	public void setSelectedGroups(List<Group> selectedGroups);
	public Converter getGroupListShuttleConverter();
	public void remove();
}
