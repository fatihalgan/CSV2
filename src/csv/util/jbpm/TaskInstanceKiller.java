package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.BUILT_IN;

import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;

@Name("org.jboss.seam.bpm.taskInstanceKiller")
@Scope(ScopeType.STATELESS)
@Install(precedence=BUILT_IN, dependencies="org.jboss.seam.bpm.jbpm")
public class TaskInstanceKiller {

	@Logger
	protected Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In(value="complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	
	@Transactional
	public void killTask(TaskInstance taskInstance) {
		try {
			OpenComplaint openComplaint = (OpenComplaint)taskInstance.getProcessInstance().getContextInstance().getVariable("openComplaint");
			taskInstance.cancel();
			taskInstance.getProcessInstance().end();
			try {
				if(openComplaint != null) {
					openComplaint.setStatus(ComplaintStatus.CANCELLED);
					synchronizeComplaintStatus(openComplaint);
				}
			} catch(Exception e) {
				facesMessages.add("Could not synchronize complaint status: " + e.getMessage());
			}
		} catch(Exception e) {
			logger.error("Could not kill task: " + e.getMessage());
			facesMessages.add("Could not kill task: " + e.getMessage());
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
}
