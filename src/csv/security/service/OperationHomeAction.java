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
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.common.service.BaseService;
import csv.faces.converters.GroupListShuttleConverter;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.Module;
import csv.security.domain.Operation;

@Name("operationHomeAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperationHomeAction extends BaseService implements IOperationHomeAction, Serializable {

	@In("csvHibernateSession")
	private Session session;
	
	private Operation selectedOperation;
	private Module selectedModule = null;
	
	private List<Group> unselectedGroups;
	private List<Group> selectedGroups;
	List<Module> moduleList = null;
	
	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}
	
	public Operation getSelectedOperation() {
		return selectedOperation;
	}
	
	public void setSelectedOperation(Operation selectedOperation) {
		this.selectedOperation = selectedOperation;
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
	
	public Module getSelectedModule() {
		return selectedModule;
	}

	public void setSelectedModule(Module selectedModule) {
		this.selectedModule = selectedModule;
	}

	@Begin(flushMode = FlushModeType.MANUAL, join=true)
	public void editOperation(Operation editOperation) {
		moduleList = securityDao.findAllModules();
		selectedOperation = editOperation;
		securityDao.attach(selectedOperation);
		selectedModule = selectedOperation.getOwningModule();
		selectedGroups = new ArrayList<Group>(selectedOperation.getPermittedGroups());
		unselectedGroups = securityDao.findAllGroups();
		unselectedGroups.removeAll(selectedGroups);
	}
	
	@Begin(flushMode = FlushModeType.MANUAL, join=true)
	public void newOperation() {
		moduleList = securityDao.findAllModules();
		selectedOperation = new Operation();
		selectedGroups = new ArrayList<Group>();
		unselectedGroups = securityDao.findAllGroups();
	}
	
	@End(beforeRedirect=true)
	public void saveOperation() {
		try {
			selectedOperation.setOwningModule(selectedModule);
			selectedOperation.updatePermittedGroups(selectedGroups);
			securityDao.saveOrUpdate(selectedOperation);
			securityDao.flush();
			cancelSave();
			facesMessages.add(Severity.INFO, "Operation updated successfully..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not update operation: " + e.getMessage());
		}
	}
	
	@End(beforeRedirect=true)
	public void cancelSave() {
		selectedOperation = null;
		unselectedGroups = null;
		selectedGroups = null;
		moduleList = null;
		selectedModule = null;
	}
	
	public Converter getGroupListShuttleConverter() {
		return new GroupListShuttleConverter(unselectedGroups, selectedGroups);
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component OperationHomeAction..");
	}
}
