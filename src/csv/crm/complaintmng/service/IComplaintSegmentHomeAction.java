package csv.crm.complaintmng.service;

import javax.ejb.Local;

import csv.crm.complaintmng.domain.ComplaintSegment;

@Local
public interface IComplaintSegmentHomeAction {

	public ComplaintSegment getSelectedComplaintSegment();
	public void setSelectedComplaintSegment(ComplaintSegment selectedComplaintSegment);
	public void editComplaintSegment(ComplaintSegment editSegment);
	public void newComplaintSegment();
	public void saveComplaintSegment();
	public void cancelSave();
	public void remove();
}
