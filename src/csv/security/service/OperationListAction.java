package csv.security.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;


import csv.security.dao.ISecurityDao;
import csv.security.domain.Module;
import csv.security.domain.Operation;

@Name("operationListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperationListAction implements IOperationListAction, Serializable {

	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	private List<Module> moduleList = null;
	
	private Module selectedModule = null;
	
	private List<Operation> operationList = null;
	
	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}
	
	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
	public Module getSelectedModule() {
		return selectedModule;
	}

	public void setSelectedModule(Module selectedModule) {
		this.selectedModule = selectedModule;
	}
	
	public void searchOperations() {
		operationList = securityDao.findOperationsByModule(selectedModule.getId());
	}
	
	@Begin(flushMode=FlushModeType.MANUAL, nested=true)
	public void searchModules() {
		moduleList = securityDao.findAllModules();
	}
	
	public void deleteOperation(Operation operation) {
		securityDao.update(operation);
		operation.removeAllPermittedGroups();
		securityDao.delete(operation);
		securityDao.flush();
		searchOperations();
	}
	
	public void resetSearch() {
		operationList = null;
	}
	
	@Remove
	public void remove() {
		
	}
}
