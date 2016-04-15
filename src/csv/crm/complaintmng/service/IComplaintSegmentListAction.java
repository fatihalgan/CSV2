package csv.crm.complaintmng.service;

import java.util.List;

import javax.ejb.Local;

import csv.crm.complaintmng.domain.ComplaintSegment;

@Local
public interface IComplaintSegmentListAction {
	public List<ComplaintSegment> getComplaintSegmentList();
	public void setComplaintSegmentList(List<ComplaintSegment> complaintSegmentList);
	public void retrieveComplaintSegments();
	public void deleteComplaintSegment(ComplaintSegment segment);
}
