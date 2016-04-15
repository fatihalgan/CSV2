package csv.security.service;

import java.util.List;

import javax.ejb.Local;

import csv.security.domain.Module;

@Local
public interface IModuleListAction {

	public List<Module> getModuleList();
	public void setModuleList(List<Module> moduleList);
	public Module getSelectedModule();
	public void setSelectedModule(Module selectedModule);
	public void searchModules();
	public void editModule(Module module);
	public void newModule();
	public void deleteModule();
	public void saveModule();
	public void remove();
}
