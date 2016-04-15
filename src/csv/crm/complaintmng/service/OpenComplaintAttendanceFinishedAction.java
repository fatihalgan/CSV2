package csv.crm.complaintmng.service;

import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.bpm.Jbpm;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.bpm.TaskInstance;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintPhase;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;

@Name("openComplaintAttendanceFinished")
@Scope(ScopeType.METHOD)
@AutoCreate
public class OpenComplaintAttendanceFinishedAction {

	@In
	private Renderer renderer;
	
	@Logger
	protected Log logger;
	
	@In(value="complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	public void synchronizeComplaintStatus() {
		try {
			OpenComplaint openComplaint = (OpenComplaint)TaskInstance.instance().getVariable("openComplaint");
			Complaint complaint = (Complaint)compDao.get(Complaint.class, openComplaint.getComplaintId());
			complaint.setStatus(openComplaint.getStatus());
			if(!openComplaint.getStatus().equals(ComplaintStatus.OPEN)) complaint.setClosingDate(new Date());
			compDao.update(complaint);
		} catch(Exception e) {
			logger.error("Error in finishing complaint attendance: " + e.getMessage());
			Jbpm.instance().getJbpmConfiguration().getCurrentJbpmContext().setRollbackOnly();
			throw new RuntimeException(e);
		}
		try {
			renderer.render("/tasks/notification/notify_complaint_closed.xhtml");
		} catch(Exception e) {
			logger.error("Error in notification of complaint conclusion: " + e.getMessage());	
		}
	}
	
	public void complaintReiterated() {
		if(TaskInstance.instance() ==  null) return;
		if(TaskInstance.instance().getVariable("openComplaint") == null) return;
		OpenComplaint openComplaint = (OpenComplaint)TaskInstance.instance().getVariable("openComplaint");
		openComplaint.setPhase(ComplaintPhase.HELP_DESK);
		openComplaint.setStatus(ComplaintStatus.OPEN);
		openComplaint.setAssignedTo(null);
	}
	
	public void corporateComplaintRaised() {
		OpenComplaint openComplaint = (OpenComplaint)TaskInstance.instance().getVariable("openComplaint");
		openComplaint.setPhase(ComplaintPhase.ACCOUNT_MANAGER);
		openComplaint.setStatus(ComplaintStatus.OPEN);
	}
	
}
