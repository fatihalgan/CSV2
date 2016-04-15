package csv.crm.complaintmng.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.bpm.BeginTask;
import org.jboss.seam.annotations.bpm.CreateProcess;
import org.jboss.seam.annotations.bpm.EndTask;
import org.jboss.seam.annotations.bpm.StartTask;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;
import org.richfaces.event.UploadEvent;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintAttachment;
import csv.crm.complaintmng.domain.ComplaintPhase;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;
import csv.crm.complaintmng.domain.OpenComplaintIteration;
import csv.crm.complaintmng.domain.OpenComplaintNextPhase;
import csv.security.domain.Group;
import csv.security.domain.User;
import csv.util.faces.FileAttachmentListener;
import csv.util.jbpm.ProcessInstanceFinder;

@Name("openComplaintAction")
@Scope(ScopeType.CONVERSATION)
@Stateful
@AutoCreate
public class OpenComplaintAction extends BaseService implements IOpenComplaintAction {
	
	@In(value="currentServedCustomer", required=true)
	private CurrentServedCustomer currentCustomer;
	
	@In(value="complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In(scope=ScopeType.PAGE, required=false)
	@Out(scope=ScopeType.PAGE, required=false)
	private OpenComplaint searchOpenComplaint;
	
	@Out(value="currentViewedComplaint", scope=ScopeType.PAGE, required=false)
	private OpenComplaint currentViewedComplaint = null;
	
	@In
	private ProcessInstanceFinder processInstanceFinder;
	
	private List<OpenComplaint> openComplaintList = null;
	
	private Long segmentFilter = null;
	
	@Factory(autoCreate=true, value="searchOpenComplaint")
	public void initSearchOpenComplaint() {
		searchOpenComplaint = new OpenComplaint();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -10);
		searchOpenComplaint.setOpeningDate(cal.getTime());
	}
	
	public OpenComplaint getSearchOpenComplaint() {
		return searchOpenComplaint;
	}

	public void setSearchOpenComplaint(OpenComplaint searchOpenComplaint) {
		this.searchOpenComplaint = searchOpenComplaint;
	}
	
	public Long getSegmentFilter() {
		return segmentFilter;
	}

	public void setSegmentFilter(Long segmentFilter) {
		this.segmentFilter = segmentFilter;
	}

	@Begin(join=true)
	public void retrieveOpenComplaintList() {
		openComplaintList = compDao.findOpenComplaints(searchOpenComplaint.getStatus(), searchOpenComplaint.getCustomerMsisdn(), searchOpenComplaint.getCustomerCode(), searchOpenComplaint.getSubscriptionType(), 
			searchOpenComplaint.getOpeningDate(), searchOpenComplaint.getComplaintId());
		filterSearchBySegment();
		//if(loggedInUser.isCorporate() && loggedInUser.isNonCorporate()) return;
		//else if(loggedInUser.isCorporate()) openComplaintList = filterNonCorporateComplaints(openComplaintList);
		//else if(loggedInUser.isNonCorporate()) openComplaintList = filterCorporateComplaints(openComplaintList);
	}
	
	private void filterSearchBySegment() {
		if(segmentFilter != null) {
			Iterator<OpenComplaint> it = openComplaintList.iterator();
			while(it.hasNext()) {
				OpenComplaint oc = it.next();
				if(!oc.getSegment().getId().equals(segmentFilter)) it.remove();
			}
		}
	}
	
	private List<OpenComplaint> filterCorporateComplaints(List<OpenComplaint> source) {
		ArrayList<OpenComplaint> target = new ArrayList<OpenComplaint>();
		for(OpenComplaint c : source) {
			if(!c.isCorporate()) target.add(c);
		}
		return target;
	}
	
	private List<OpenComplaint> filterNonCorporateComplaints(List<OpenComplaint> source) {
		ArrayList<OpenComplaint> target = new ArrayList<OpenComplaint>();
		for(OpenComplaint c : source) {
			if(c.isCorporate()) target.add(c);
		}
		return target;
	}
	
	
	public OpenComplaint getCurrentViewedComplaint() {
		return currentViewedComplaint;
	}
	
	public List<OpenComplaint> getOpenComplaintList() {
		return openComplaintList;
	}

	public void setOpenComplaintList(List<OpenComplaint> openComplaintList) {
		this.openComplaintList = openComplaintList;
	}

	
	public void cancelOpenComplaint(Long complaintId) {
		try {
			processInstanceFinder.setProcessDefinitionName("ComplaintManagement");
			processInstanceFinder.setProcessInstanceEnded(false);
			processInstanceFinder.setProcesskey(complaintId.toString());
			ProcessInstance instance = processInstanceFinder.getUniqueProcessInstance();
			instance.suspend();
			OpenComplaint comp = compDao.findOpenComplaint(complaintId);
			comp.setStatus(ComplaintStatus.SUSPENDED);
			openComplaintList.remove(comp);
			synchronizeComplaintStatus(comp);
		} catch(Exception e) {
			facesMessages.add("Could not cancel the open complaint: " + e.getMessage());
		}
	}
	
	public void resumeOpenComplaint(Long complaintId) {
		try {
			processInstanceFinder.setProcessDefinitionName("ComplaintManagement");
			processInstanceFinder.setProcessInstanceEnded(false);
			processInstanceFinder.setProcesskey(complaintId.toString());
			ProcessInstance instance = processInstanceFinder.getUniqueProcessInstance();
			instance.resume();
			OpenComplaint comp = compDao.findOpenComplaint(complaintId);
			comp.setStatus(ComplaintStatus.OPEN);
			synchronizeComplaintStatus(comp);
			openComplaintList.remove(comp);
		} catch(Exception e) {
			facesMessages.add("Could not resume the open complaint: " + e.getMessage());
		}
	}
	
	public void killOpenComplaint(Long complaintId) {
		try {
			processInstanceFinder.setProcessDefinitionName("ComplaintManagement");
			processInstanceFinder.setProcessInstanceEnded(false);
			processInstanceFinder.setProcesskey(complaintId.toString());
			ProcessInstance instance = processInstanceFinder.getUniqueProcessInstance();
			instance.end();
			terminateOpenTasks(instance);
			OpenComplaint complaint = compDao.findOpenComplaint(complaintId);
			complaint.setStatus(ComplaintStatus.CANCELLED);
			synchronizeComplaintStatus(complaint);
			openComplaintList.remove(complaint);
		} catch(Exception e) {
			facesMessages.add("Could not kill the open complaint: " + e.getMessage());
		}
	}
	
	private void terminateOpenTasks(ProcessInstance processInstance) {
		Object[] tasks = processInstance.getTaskMgmtInstance().getTaskInstances().toArray();
		for(Object o : tasks) {
			TaskInstance task = (TaskInstance)o;
			if(task.isOpen()) task.cancel();
		}
	}
	
	private void synchronizeComplaintStatus(OpenComplaint openComplaint) {
		try {
			Complaint complaint = (Complaint)compDao.get(Complaint.class, openComplaint.getComplaintId());
			complaint.setStatus(openComplaint.getStatus());
			if(!openComplaint.getStatus().equals(ComplaintStatus.OPEN)) complaint.setClosingDate(new Date());
			compDao.update(complaint);
		} catch(Exception e) {
			facesMessages.add("Could not synchronize Complaint status: " + e.getMessage());
		}
	}
	
	public void retrieveOpenComplaintHistory(OpenComplaint complaint) {
		this.currentViewedComplaint = complaint;
	}
	
	public void retrieveOpenComplaintHistory(Long complaintId) {
		this.currentViewedComplaint = compDao.findOpenComplaint(complaintId);
	}
	
	public void retrieveOpenComplaintHistory(String complaintId) {
		retrieveOpenComplaintHistory(Long.parseLong(complaintId));
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component OpenComplaintAction..");
	}

	@Override
	public void exportComplaintListToExcel() {
		 facesMessages.add(Severity.INFO, "Please check your downloaded files if the report does not appear..");		
	}
}
