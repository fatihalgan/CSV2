package csv.security.service;

import java.util.List;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import csv.security.domain.Group;
import csv.security.domain.Module;
import csv.security.domain.Operation;

@Local
public interface IOperationHomeAction {

	public void editOperation(Operation editOperation);
	public void newOperation();
	public void saveOperation();
	public void cancelSave();
	public Operation getSelectedOperation();
	public void setSelectedOperation(Operation selectedOperation);
	public Module getSelectedModule();
	public void setSelectedModule(Module selectedModule);
	public List<Module> getModuleList();
	public Converter getGroupListShuttleConverter();
	public List<Group> getUnselectedGroups();
	public List<Group> getSelectedGroups();
	public void setUnselectedGroups(List<Group> unselectedGroups);
	public void setSelectedGroups(List<Group> selectedGroups);
	public void remove();
}
