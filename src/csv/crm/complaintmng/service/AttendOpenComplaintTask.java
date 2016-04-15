package csv.crm.complaintmng.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.bpm.BeginTask;
import org.jboss.seam.annotations.bpm.EndTask;
import org.jboss.seam.bpm.BusinessProcess;
import org.jboss.seam.bpm.Jbpm;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.bpm.TaskInstance;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;
import org.jboss.seam.web.Parameters;
import org.richfaces.event.UploadEvent;

import csv.common.domain.CurrentServedCustomer;
import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintAttachment;
import csv.crm.complaintmng.domain.ComplaintPhase;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;
import csv.crm.complaintmng.domain.OpenComplaintIteration;
import csv.crm.complaintmng.domain.OpenComplaintNextPhase;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.User;
import csv.util.faces.FileAttachmentListener;

@Name("attendOpenComplaintTask")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class AttendOpenComplaintTask {
	
	@In(required=true)
	protected User loggedInUser;

	@In(value="currentServedCustomer", required=true)
	private CurrentServedCustomer currentCustomer;
	
	@In("fileAttachmentListener")
	private FileAttachmentListener fileAttachmentListener;
	
	private Group assignedTo = null;
	
	private User assignedToUser = null;
	
	private List<User> groupUsers = new ArrayList<User>();
	
	@In(value="complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In("securityDao")
	protected ISecurityDao securityDao;
	
	@In(value="openComplaintNextPhase")
	private OpenComplaintNextPhase openComplaintNextPhase;
	
	private OpenComplaintIteration currentOpenComplaintIteration = new OpenComplaintIteration();
	
	@In
	protected FacesMessages facesMessages;
	
	@Logger
	protected Log logger;
	
	
	public AttendOpenComplaintTask() {
		super();
	}
	
	public Group getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Group assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public User getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUser(User assignedToUser) {
		this.assignedToUser = assignedToUser;
	}
	
	public void retrieveGroupUsers() {
		securityDao.attach(assignedTo);
		groupUsers = new ArrayList<User>( assignedTo.getUsersInGroup());
	}
	
	public List<User> getGroupUsers() {
		return groupUsers;
	}
	
	public OpenComplaintIteration getCurrentOpenComplaintIteration() {
		return currentOpenComplaintIteration;
	}

	public void setCurrentOpenComplaintIteration(
			OpenComplaintIteration currentOpenComplaintIteration) {
		this.currentOpenComplaintIteration = currentOpenComplaintIteration;
	}
	
	public boolean isInitialComplaintEntry() {
		if(TaskInstance.instance() == null) return true;
		if(TaskInstance.instance().getVariable("openComplaint") == null) return true;
		if(currentOpenComplaintIteration == null) return true;
		return false;
	}
	
	public void attendCustomerComplaint() {
		try {
			BusinessProcess.instance().resumeTask(getTaskId());
			OpenComplaint openComplaint = (OpenComplaint)TaskInstance.instance().getVariable("openComplaint");
			if(openComplaint.getCustomerMsisdn() != null) {
				currentCustomer.setMsisdn(openComplaint.getCustomerMsisdn());
				currentCustomer.newCustomer();
			} else if(openComplaint.getCustomerCode() != null) {
				currentCustomer.setCustomerCode(openComplaint.getCustomerCode());
				currentCustomer.newCustomerCode();
			}
		} catch(Exception e) {
			logger.error("Failed to start Task: " + e.getMessage());
			facesMessages.add(e.getMessage());
		}
	}
	
	public String endAttendOpenComplaint() {
		try {
			logger.debug("Ending Complaint Attendance Task..");
			OpenComplaint openComplaint = (OpenComplaint)TaskInstance.instance().getVariable("openComplaint");
			if(!openComplaint.isFinalized()) {
				 checkForCustomerFeedbackAvailable(openComplaint);
			}
			if(!openComplaint.isFinalized())openComplaint.setPhase(openComplaintNextPhase.getNextPhase());
			openComplaint.addComplaintIteration(loggedInUser.getEmail(), currentOpenComplaintIteration.getComment());
			if(openComplaint.getPhase().equals(ComplaintPhase.OUTBOUND_SUPPORT) && openComplaint.getStatus().equals(ComplaintStatus.OPEN)) {
				openComplaint.setAssignedTo(assignedTo.getGroupName());
				if(assignedToUser != null) openComplaint.setAssignedToUser(assignedToUser.getUsername());
				else openComplaint.setAssignedToUser("");
			} else {
				openComplaint.setAssignedToUser("");
			}
			logger.debug("Dismissing Customer: " + currentCustomer.getMsisdn());
			BusinessProcess.instance().endTask(null);
			currentCustomer.endCustomerSession();
			return "attendanceComplete";
		} catch(Exception e) {
			logger.error("Failed to end Task: " + e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
			return null;
		}
		
	}
	
	private void checkForCustomerFeedbackAvailable(OpenComplaint openComplaint) {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		Date cfAvailable = null;
		try {
			cfAvailable = df.parse("21.12.2012");
		} catch(Exception e) {
			throw new RuntimeException("Error in parsing Customer Feedback availability Date. Please report to Bridge Consulting..");
		}
		if(openComplaintNextPhase.getNextPhase().equals(ComplaintPhase.CUSTOMER_FEEDBACK)) {
			if(openComplaint.getOpeningDate().before(cfAvailable)) {
				throw new RuntimeException("You cannot send this complaint to Customer Feedback. Please Close or Delegate it yourself..");
			}
		}
	}
	
	@Transactional
	public Long getTaskId() {
		Long retVal = null;
		String[] values = Parameters.instance().getRequestParameters()
				.get("taskId");
		if (values == null || values.length != 1) {
			return null;
		} else {
			String taskId = values[0];
			retVal = new Long(taskId);
		}
		return retVal;
	}
	
	
	public void attachmentAdded(UploadEvent event) {
		try {
			OpenComplaint openComplaint = (OpenComplaint)TaskInstance.instance().getVariable("openComplaint");
			Complaint complaint = (Complaint)compDao.load(Complaint.class, openComplaint.getComplaintId());
			byte[] fileData = fileAttachmentListener.addAttachment(event);
			complaint.addComplaintAttachment(new ComplaintAttachment(fileData, fileAttachmentListener.getFileName()));
			compDao.update(complaint);
		} catch(Exception e) {
			logger.error("Could not read attched file: " + e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not attach file: " + e.getMessage());
		} 
	}
	
	
	
	public void addStatusRemark(OpenComplaint openComplaint) {
		compDao.updateOpenComplaint(openComplaint);
	}
	
	
}
