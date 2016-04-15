package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.APPLICATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.Unwrap;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.dao.IComplaintManagementDao;

@Name("groupTaskInstanceList")
@Scope(ScopeType.APPLICATION)
@Install(precedence=APPLICATION, dependencies="org.jboss.seam.bpm.jbpm")
public class GroupTaskInstanceList {
	
	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@Unwrap
	@Transactional
	public List<TaskInstance> getTaskInstanceList() {
		Set<String> groups = Actor.instance().getGroupActorIds();
		return getTaskInstanceList(new ArrayList<String>(groups));
	}

	private List<TaskInstance> getTaskInstanceList(List<String> groupactorIds) {
	    List<TaskInstance> taskInstances = compDao.findPooledTaskInstancesByGroupActors(groupactorIds);
		return taskInstances;
	}
}
