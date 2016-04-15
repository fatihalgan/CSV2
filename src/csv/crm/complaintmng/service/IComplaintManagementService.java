package csv.crm.complaintmng.service;

import java.util.List;

import javax.ejb.Local;

import org.richfaces.event.UploadEvent;

import csv.common.domain.Province;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintOwner;
import csv.crm.complaintmng.domain.ComplaintSegment;

@Local
public interface IComplaintManagementService {

	public Complaint getNewComplaint();
	public void setNewComplaint(Complaint newComplaint);
	public ComplaintOwner getComplaintOwner();
	public void setComplaintOwner(ComplaintOwner complaintOwner);
	public List<Complaint> getComplaintHistory();
	public Complaint getCurrentViewedComplaint();
	public void loadComplaintOwner();
	public void loadCorporateComplaintOwner();
	public void updateCompanyInfo();
	public void loadComplaintHistory();
	public void retrieveComplaintDetails(Complaint complaint);
	public void rememberInitialComplaintEntry();
	public void saveComplaint();
	public void saveComplaintEndCustomerSession();
	public void attachmentAdded(UploadEvent event);
	public void remove();
}

