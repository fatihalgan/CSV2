package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.BUILT_IN;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.Unwrap;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;

import static org.hibernate.criterion.Order.asc;

import static org.hibernate.criterion.Restrictions.isNull;

@Name("org.jboss.seam.bpm.allTasksInstanceList")
@Scope(ScopeType.APPLICATION)
@Install(precedence=BUILT_IN, dependencies="org.jboss.seam.bpm.jbpm")
public class AllTasksInstanceList {

	@Unwrap
	@Transactional
	public List<TaskInstance> getAllTaskInstanceList() {
		return getTaskInstanceList();
	}
	
	private List<TaskInstance> getTaskInstanceList() {
		Criteria query = ManagedJbpmContext.instance().getSession().
				createCriteria(TaskInstance.class);
		query.add(isNull("end"));
		query.add(Restrictions.eq("isOpen", true));
		query.add(Restrictions.eq("isSuspended", false));
		query.addOrder(asc("processInstance"));
		return query.list();
	}
	
}
