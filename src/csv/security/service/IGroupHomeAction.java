package csv.security.service;

import java.util.List;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import csv.security.domain.Group;
import csv.security.domain.Operation;

@Local
public interface IGroupHomeAction {

	public void editGroup(Group editGroup);
	public void newGroup();
	public void saveGroup();
	public void cancelSave();
	public Group getSelectedGroup();
	public void setSelectedGroup(Group selectedGroup);
	public List<Operation> getUnselectedOperations();
	public void setUnselectedOperations(List<Operation> unselectedOperations);
	public List<Operation> getSelectedOperations();
	public void setSelectedOperations(List<Operation> selectedOperations);
	public Converter getOperationListShuttleConverter();
	public List<Group> getSupervisorGroups();
	public void remove();
}
