package csv.security.service;

import java.util.List;

import javax.ejb.Local;

import csv.security.domain.Module;
import csv.security.domain.Operation;

@Local
public interface IOperationListAction {

	public List<Operation> getOperationList();
	public void setOperationList(List<Operation> operationList);
	public List<Module> getModuleList();
	public void setModuleList(List<Module> moduleList);
	public Module getSelectedModule();
	public void setSelectedModule(Module selectedModule);
	public void searchOperations();
	public void searchModules();
	public void deleteOperation(Operation operation);
	public void resetSearch();
	public void remove();
}
