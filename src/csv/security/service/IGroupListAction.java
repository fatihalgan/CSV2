package csv.security.service;

import java.util.List;

import javax.ejb.Local;

import csv.security.domain.Group;

@Local
public interface IGroupListAction {

	public void searchGroups();
	public void resetSearch();
	public void deleteGroup();
	public List<Group> getGroupList();
	public void setGroupList(List<Group> groupList);
	public Group getSelectedGroup();
	public void setSelectedGroup(Group selectedGroup);
	
}
