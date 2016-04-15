package csv.crm.complaintmng.service;

import java.io.Serializable;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.ComplaintSegment;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;

@Name("complaintSegmentHomeAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class ComplaintSegmentHomeAction implements IComplaintSegmentHomeAction, Serializable {

	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	private ComplaintSegment selectedComplaintSegment;
		
	public ComplaintSegment getSelectedComplaintSegment() {
		return selectedComplaintSegment;
	}

	public void setSelectedComplaintSegment(ComplaintSegment selectedComplaintSegment) {
		this.selectedComplaintSegment = selectedComplaintSegment;
	}
	
	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public void editComplaintSegment(ComplaintSegment editSegment) {
		selectedComplaintSegment = editSegment;
		compDao.attach(editSegment);
	}
	
	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public void newComplaintSegment() {
		selectedComplaintSegment = new ComplaintSegment();
	}
	
	@End(beforeRedirect=true)
	public void saveComplaintSegment() {
		try {
			compDao.saveOrUpdate(selectedComplaintSegment);
			compDao.flush();
			cancelSave();
			facesMessages.add(Severity.INFO, "Complaint segment updated successfully..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not update complaint segment: " + e.getMessage());
		}
	}
	
	@End(beforeRedirect=true)
	public void cancelSave() {
		selectedComplaintSegment = null;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing Stateful EJB Component ComplaintSegmentHomeAction");
	}
	
}
