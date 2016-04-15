package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.BUILT_IN;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.domain.ComplaintSegment;
import csv.crm.complaintmng.domain.OpenComplaint;

@Name("org.jboss.seam.bpm.filterableTaskInstanceList")
@Scope(ScopeType.PAGE)
@AutoCreate
@Install(precedence=BUILT_IN, dependencies="org.jboss.seam.bpm.jbpm")
public class FilterableTaskInstanceList {
	
	@Logger
	protected Log logger;
	
	@In
	protected FacesMessages facesMessages;

	private String msisdn;
	
	private Date openingDate;
	
	private Date postingDate;
	
	private Long filteredSegment;
	
	private List<TaskInstance> pooledTasks = new ArrayList<TaskInstance>();
	
	private List<TaskInstance> myAssignedTasks = new ArrayList<TaskInstance>() ;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}
	
	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}
	
	public Long getFilteredSegment() {
		return filteredSegment;
	}

	public void setFilteredSegment(Long filteredSegment) {
		this.filteredSegment = filteredSegment;
	}

	private void filter(List<TaskInstance> tasks) {
		Iterator<TaskInstance> it = tasks.iterator();
		while(it.hasNext()) {
			TaskInstance task = (TaskInstance)it.next();
			if(task.getVariable("openComplaint") == null) continue;
			OpenComplaint complaint = (OpenComplaint)task.getVariable("openComplaint");
			if((msisdn != null) && (msisdn.trim().length() > 0)) {
				if(!complaint.getCustomerMsisdn().trim().equals(msisdn.trim())) {
					it.remove();
					continue;
				}
			}
			if(openingDate != null) {
				if(!complaint.getOpeningDate().after(openingDate)) {
					it.remove();
					continue;
				}
			}
			if(postingDate != null) {
				if(!task.getCreate().after(postingDate)) {
					it.remove();
					continue;
				}
			}
			
			if(filteredSegment != null) {
				if(!complaint.getSegment().getId().equals(filteredSegment)) {
					it.remove();
					continue;
				}
			}
			logger.debug("Will include complaint for Customer: " + complaint.getCustomerMsisdn() + " / " + complaint.getCustomerCode());
		}
		
	}
	
	public void refreshTaskList() {
		if(msisdn != null && msisdn.trim().length() != 0) {
			if(msisdn.trim().length() != 9) facesMessages.add("Error: MSISDN is not valid..");
		}
		pooledTasks = new ArrayList<TaskInstance>();
		myAssignedTasks = new ArrayList<TaskInstance>();
	}
	
	@Transactional
	public List<TaskInstance> getTaskInstanceList() {
		try {
			if(myAssignedTasks.isEmpty()) {
				myAssignedTasks = getTaskInstanceList(Actor.instance().getId());
				filter(myAssignedTasks);
			}
		} catch(Exception e) {
			logger.error("Error while getting MyAssignedTasks: ", e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
		return myAssignedTasks;
	}
	
	@Transactional
	public List<TaskInstance> getPooledTaskInstanceList() {
		try {
			if(pooledTasks.isEmpty()) {
				Actor actor = Actor.instance();
				String actorId = actor.getId();
				if ( actorId == null ) return null;
				ArrayList groupIds = new ArrayList( actor.getGroupActorIds() );
				groupIds.add(actorId);
				pooledTasks =  ManagedJbpmContext.instance().getGroupTaskList(groupIds);
				filter(pooledTasks);
			}
		} catch(Exception e) {
			logger.error("Error while getting PooledTasks: ", e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
		return pooledTasks;
	}
	
	@Observer("openComplaintAssigned")
	public void resetTaskLists() {
		pooledTasks = new ArrayList<TaskInstance>();
		myAssignedTasks = new ArrayList<TaskInstance>();
	}
	
	public void resetPooledTaskList() {
		pooledTasks = new ArrayList<TaskInstance>();
	}
	
	public void resetMyAssignedTaskList() {
		myAssignedTasks = new ArrayList<TaskInstance>();
	}
	
	private List<TaskInstance> getTaskInstanceList(String actorId) {
		if ( actorId == null ) return null;
	    return ManagedJbpmContext.instance().getTaskList(actorId);
	}
	   
}
