package csv.crm.complaintmng.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.core.Events;
import org.jboss.seam.international.StatusMessage.Severity;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import csv.common.domain.CurrentServedCustomer;
import csv.common.domain.CustomerIdentifierType;
import csv.common.domain.Province;
import csv.common.domain.SubscriptionType;
import csv.common.service.BaseService;
import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.ComplaintAttachment;
import csv.crm.complaintmng.domain.ComplaintLocality;
import csv.crm.complaintmng.domain.ComplaintOwner;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.CorporateClient;
import csv.crm.complaintmng.domain.CorporateComplaintOwner;
import csv.crm.complaintmng.domain.PersonalComplaintOwner;
import csv.util.faces.FileAttachmentListener;

@Name("complaintManagementService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class ComplaintManagementService extends BaseService implements IComplaintManagementService {

	@In
	private Events events;
	
	@In(value="currentServedCustomer", required=false)
	private CurrentServedCustomer currentCustomer;
	
	@In(value="complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In(value="complaintLocality")
	private ComplaintLocality complaintLocality;
	
	@In("fileAttachmentListener")
	private FileAttachmentListener fileAttachmentListener;
	
	private Complaint newComplaint = new Complaint();
	
	private ComplaintOwner complaintOwner;
	
	private List<Complaint> complaintHistory = new ArrayList<Complaint>();
	
	private Complaint currentViewedComplaint = null;
	
	public ComplaintManagementService() {
		super();
	}
	
	public Complaint getNewComplaint() {
		return newComplaint;
	}

	public void setNewComplaint(Complaint newComplaint) {
		this.newComplaint = newComplaint;
	}
	
	public ComplaintOwner getComplaintOwner() {
		return complaintOwner;
	}

	public void setComplaintOwner(ComplaintOwner complaintOwner) {
		this.complaintOwner = complaintOwner;
	}
	
	public List<Complaint> getComplaintHistory() {
		return complaintHistory;
	}

	public void setComplaintHistory(List<Complaint> complaintHistory) {
		this.complaintHistory = complaintHistory;
	}
	
	public Complaint getCurrentViewedComplaint() {
		return currentViewedComplaint;
	}
	
	public void loadComplaintOwner() {
		try {
			complaintOwner = compDao.findPersonalComplaintOwnerByMsisdn(currentCustomer.getMsisdn());
			if(complaintOwner == null) {
				complaintOwner = new PersonalComplaintOwner(currentCustomer.getMsisdn(), currentCustomer.getMsisdn());
			}
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Error while trying to load complaint owner: " + e.getMessage());
		}
	}
	
	public void loadCorporateComplaintOwner() {
		try {
			if(currentCustomer.getCustomerIdentifierType().equals(CustomerIdentifierType.MSISDN)) {
				complaintOwner = compDao.findCorporateComplaintOwnerByMsisdn(currentCustomer.getMsisdn());
			} else if(currentCustomer.getCustomerIdentifierType().equals(CustomerIdentifierType.CustomerCode)) {
				complaintOwner = compDao.findCorporateComplaintOwnerByCustomerCode(currentCustomer.getCustomerCode());
			}
			if(complaintOwner == null && currentCustomer.getCustomerIdentifierType().equals(CustomerIdentifierType.MSISDN)) complaintOwner = new CorporateComplaintOwner(currentCustomer.getMsisdn());
			else if(complaintOwner == null) complaintOwner = new CorporateComplaintOwner();
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Error while trying to load complaint owner: " + e.getMessage());
		}
	}
	
	public void loadComplaintHistory() {
		try {
			if(currentCustomer.getCustomerIdentifierType().equals(CustomerIdentifierType.MSISDN))
				complaintHistory = compDao.findComplaintsByMsisdn(currentCustomer.getMsisdn());
			else if(currentCustomer.getCustomerIdentifierType().equals(CustomerIdentifierType.CustomerCode)) 
				complaintHistory = compDao.findComplaintsByCustomerCode(currentCustomer.getCustomerCode());
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Complaint history for the MSISDN cannot be retrieved: " + e.getMessage());
		}
	}
	
	public void rememberInitialComplaintEntry() {
		logger.debug("Saving the complaint entry to conversation scope for the customer session..");
	}
	
	
	
	public void saveComplaint() {
		try {
			compDao.saveOrUpdate(complaintOwner);
			newComplaint.setCreator(loggedInUser);
			newComplaint.setOwner(complaintOwner);
			newComplaint.setDateOfOccurence(complaintLocality.getDateOfOccurence());
			newComplaint.setLocation(complaintLocality.getDistrict());
			if(!newComplaint.getStatus().equals(ComplaintStatus.OPEN)) newComplaint.setClosingDate(new Date());
			complaintOwner.addComplaint(newComplaint);
		}  catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Could not save complaint entry: " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	public void updateCompanyInfo() {
		if(currentCustomer.getCustomerIdentifierType().equals(CustomerIdentifierType.CustomerCode)) {
			if(complaintOwner instanceof CorporateComplaintOwner) {
				currentCustomer.setCustomerCode(((CorporateComplaintOwner)complaintOwner).getCompany().getCustomerCode());
				CorporateClient company = ((CorporateComplaintOwner)complaintOwner).getCompany();
				loadCorporateComplaintOwner();
				((CorporateComplaintOwner) complaintOwner).setCompany(company);
			}	
		}
	}
	
	public void saveComplaintEndCustomerSession() {
		try {
			saveComplaint();
			compDao.flush();
			if(newComplaint.getStatus().equals(ComplaintStatus.OPEN)) {
				events.raiseEvent(newComplaint.getComplaintRaisedEventName(), newComplaint);
			}
			facesMessages.add(Severity.INFO, "Customer Complaint has been saved with ID: " + newComplaint.getId());
			currentCustomer.endCustomerSession();
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not end Customer Session: " + e.getMessage());
		}
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component ComplaintManagementService..");		
	}

	@Override
	public void retrieveComplaintDetails(Complaint complaint) {
		this.currentViewedComplaint = complaint;		
	}
	
	@Override
	public void attachmentAdded(UploadEvent event) {
		try {
			byte[] attachment = fileAttachmentListener.addAttachment(event);
			String fileName = fileAttachmentListener.getFileName();
			if(fileName.lastIndexOf("\\") > -1) fileName = fileName.substring(fileName.lastIndexOf("\\"));
			newComplaint.addComplaintAttachment(new ComplaintAttachment(attachment, fileName));
		} catch(Exception e) {
			logger.error("Could not read attched file: " + e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not attach file: " + e.getMessage());
		} 
	}

	
}
