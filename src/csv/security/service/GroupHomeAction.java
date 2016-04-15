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
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import csv.common.service.BaseService;
import csv.faces.converters.OperationListShuttleConverter;
import csv.security.domain.Group;
import csv.security.domain.GroupType;
import csv.security.domain.Operation;

@Name("groupHomeAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class GroupHomeAction extends BaseService implements IGroupHomeAction, Serializable {

	@In("csvHibernateSession")
	private Session session;
		
	private Group selectedGroup = null;
	
	private List<Group> supervisorGroups;
	
	private List<Operation> unselectedOperations;
	private List<Operation> selectedOperations;

	public Group getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(Group selectedGroup) {
		this.selectedGroup = selectedGroup;
	}

	public List<Operation> getUnselectedOperations() {
		return unselectedOperations;
	}

	public void setUnselectedOperations(List<Operation> unselectedOperations) {
		this.unselectedOperations = unselectedOperations;
	}

	public List<Operation> getSelectedOperations() {
		return selectedOperations;
	}

	public void setSelectedOperations(List<Operation> selectedOperations) {
		this.selectedOperations = selectedOperations;
	}
	
	public List<Group> getSupervisorGroups() {
		return supervisorGroups;
	}
	
	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public void editGroup(Group editGroup) {
		selectedGroup = editGroup;
		securityDao.attach(selectedGroup);
		securityDao.attachAll(selectedGroup.getPermittedOperations());
		selectedOperations = new ArrayList<Operation>(selectedGroup.getPermittedOperations());
		unselectedOperations = securityDao.findAllOperations();
		unselectedOperations.removeAll(selectedOperations);
		supervisorGroups = securityDao.findAllGroups();
		supervisorGroups.remove(selectedGroup);
	}
	
	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public void newGroup() {
		selectedGroup = new Group();
		selectedOperations = new ArrayList<Operation>();
		unselectedOperations = securityDao.findAllOperations();
		supervisorGroups = securityDao.findAllGroups();
		supervisorGroups.remove(selectedGroup);
	}
	
	@End
	public void saveGroup() {
		securityDao.saveOrUpdate(selectedGroup);
		selectedGroup.updateAuthorizations(selectedOperations);
		securityDao.flush();
		cancelSave();
	}
	
	@End
	public void cancelSave() {
		selectedGroup = null;
		unselectedOperations = null;
		selectedOperations = null;
		supervisorGroups = null;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing Stateful EJB Component GroupHomeAction");
	}
	
	public Converter getOperationListShuttleConverter() {
		return new OperationListShuttleConverter(unselectedOperations, selectedOperations);
	}
	
	
}
