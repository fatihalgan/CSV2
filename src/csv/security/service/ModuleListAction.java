package csv.security.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

import csv.security.dao.ISecurityDao;
import csv.security.domain.Module;

@Name("moduleListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class ModuleListAction implements IModuleListAction, Serializable {

	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	private List<Module> moduleList;
	
	private Module selectedModule;
	
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
	
	@Begin(flushMode=FlushModeType.MANUAL, nested=true)
	public void searchModules() {
		if(moduleList == null)
			moduleList = securityDao.findAllModules();
	}
	
	public void editModule(Module module) {
		selectedModule = module;
		logger.debug("Editing Module: " + selectedModule.getModuleName());
	}
	
	public void newModule() {
		selectedModule = new Module();
	}
	
	@End
	public void deleteModule() {
		securityDao.delete(selectedModule);
		securityDao.flush();
		moduleList = null;
		selectedModule = null;
	}
	
	@End
	public void saveModule() {
		securityDao.saveOrUpdate(selectedModule);
		securityDao.flush();
		moduleList = null;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component ModuleListAction..");
	}

}
