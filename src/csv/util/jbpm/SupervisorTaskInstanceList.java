package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.APPLICATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.Unwrap;
import org.jboss.seam.bpm.Actor;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.security.domain.Group;
import csv.security.domain.User;

@Name("supervisorTaskInstanceList")
@Scope(ScopeType.SESSION)
@AutoCreate
@Install(precedence=APPLICATION, dependencies="org.jboss.seam.bpm.jbpm")
public class SupervisorTaskInstanceList {

	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In(required=true)
	private User loggedInUser;
	
	@Unwrap
	@Transactional
	public List<TaskInstance> getTaskInstanceList() {
		List<String> childGroupNames = new ArrayList<String>();
		Set<Group> memberships = loggedInUser.getMemberships();
		for(Group g : memberships) {
			childGroupNames.addAll(g.getAllChildGroupNames());
		}
		if(childGroupNames.size() == 0) {
			if(!loggedInUser.isSupervisor()) return new ArrayList<TaskInstance>();
			Set<String> groups = Actor.instance().getGroupActorIds();
			return getTaskInstanceList(new ArrayList<String>(groups));
		} else return getTaskInstanceList(childGroupNames);
	}

	private List<TaskInstance> getTaskInstanceList(List<String> groupactorIds) {
	    List<TaskInstance> taskInstances = compDao.findPooledTaskInstancesByGroupActors(groupactorIds);
		return taskInstances;
	}
}
