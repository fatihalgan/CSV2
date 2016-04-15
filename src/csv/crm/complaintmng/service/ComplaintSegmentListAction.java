package csv.crm.complaintmng.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.ComplaintSegment;

@Name("complaintSegmentListAction")
@Stateless
@AutoCreate
public class ComplaintSegmentListAction implements IComplaintSegmentListAction, Serializable {

	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@Out(value="complaintSegmentList", required=true)
	private List<ComplaintSegment> complaintSegmentList = null;
	
	public void retrieveComplaintSegments() {
		complaintSegmentList = compDao.findAllComplaintSegments();
	}
	
	public List<ComplaintSegment> getComplaintSegmentList() {
		return complaintSegmentList;
	}

	public void setComplaintSegmentList(List<ComplaintSegment> complaintSegmentList) {
		this.complaintSegmentList = complaintSegmentList;
	}

	public void deleteComplaintSegment(ComplaintSegment segment) {
		compDao.update(segment);
		compDao.delete(segment);
		complaintSegmentList.remove(segment);
	}
}
