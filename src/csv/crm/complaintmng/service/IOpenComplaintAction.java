package csv.crm.complaintmng.service;

import java.util.List;

import javax.ejb.Local;

import org.richfaces.event.UploadEvent;

import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.OpenComplaint;
import csv.crm.complaintmng.domain.OpenComplaintIteration;
import csv.security.domain.Group;
import csv.security.domain.User;

@Local
public interface IOpenComplaintAction {
	public void initSearchOpenComplaint();
	public OpenComplaint getSearchOpenComplaint();
	public void setSearchOpenComplaint(OpenComplaint searchOpenComplaint);
	public Long getSegmentFilter();
	public void setSegmentFilter(Long segmentFilter);
	public List<OpenComplaint> getOpenComplaintList();
	public void setOpenComplaintList(List<OpenComplaint> openComplaintList);
	public OpenComplaint getCurrentViewedComplaint();
	public void retrieveOpenComplaintHistory(OpenComplaint complaint);
	public void retrieveOpenComplaintHistory(Long complaintId);
	public void retrieveOpenComplaintHistory(String complaintId);
	public void retrieveOpenComplaintList();
	public void exportComplaintListToExcel();
	public void cancelOpenComplaint(Long complaintId);
	public void resumeOpenComplaint(Long complaintId);
	public void killOpenComplaint(Long complaintId);
	public void remove();
}
