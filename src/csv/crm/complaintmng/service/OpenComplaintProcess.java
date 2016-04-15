package csv.crm.complaintmng.service;


import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.bpm.CreateProcess;
import org.jboss.seam.bpm.BusinessProcess;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.exe.ProcessInstance;

import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintPhase;
import csv.crm.complaintmng.domain.OpenComplaint;

@Name("openComplaintProcess")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class OpenComplaintProcess {

	@Logger
	protected Log logger;
	
	@In
	protected FacesMessages facesMessages;
	
	@Observer("newComplaintOpened")
	public void openCustomerComplaint(Complaint complaint) {
		logger.debug("Opening new personal complaint with id: " + complaint.getId());
		OpenComplaint openComplaint = complaint.openComplaint();
		openComplaint.setPhase(ComplaintPhase.HELP_DESK);
		Contexts.getBusinessProcessContext().set("openComplaint", openComplaint);
		BusinessProcess.instance().createProcess("ComplaintManagement", openComplaint.getComplaintId().toString());
		facesMessages.add("New complaint has been opened with ID: " + complaint.getId());
	}
	
	@Observer("newCorporateComplaintOpened")
	public void openCorporateCustomerComplaint(Complaint complaint) {
		logger.debug("Opening new corporate complaint with id: " + complaint.getId());
		OpenComplaint openComplaint = complaint.openComplaint();
		openComplaint.setPhase(ComplaintPhase.ACCOUNT_MANAGER);
		Contexts.getBusinessProcessContext().set("openComplaint", openComplaint);
		BusinessProcess.instance().createProcess("CorporateComplaintManagement", openComplaint.getComplaintId().toString());
		facesMessages.add("New complaint has been opened with ID: " + complaint.getId());
	}
}
