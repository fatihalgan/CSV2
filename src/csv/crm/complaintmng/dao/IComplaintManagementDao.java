package csv.crm.complaintmng.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.common.domain.SubscriptionType;
import csv.crm.complaintmng.domain.Complaint;
import csv.crm.complaintmng.domain.ComplaintAttachment;
import csv.crm.complaintmng.domain.ComplaintSegment;
import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.CorporateClient;
import csv.crm.complaintmng.domain.CorporateComplaintOwner;
import csv.crm.complaintmng.domain.OpenComplaint;
import csv.crm.complaintmng.domain.PersonalComplaintOwner;
import csv.util.persistence.IBaseDao;

@Local
public interface IComplaintManagementDao extends IBaseDao {

	public List<ComplaintSegment> findAllComplaintSegments();
	public PersonalComplaintOwner findPersonalComplaintOwnerByMsisdn(String msisdn);
	public CorporateComplaintOwner findCorporateComplaintOwnerByMsisdn(String msisdn);
	public CorporateComplaintOwner findCorporateComplaintOwnerByCustomerCode(String customerCode);
	public List<Complaint> findComplaintsByMsisdn(String msisdn);
	public List<Complaint> findComplaintsByCustomerCode(String customerCode);
	public OpenComplaint findOpenComplaint(Long complaintId);
	public List<OpenComplaint> findOpenComplaints(ComplaintStatus status, String msisdn, String customerCode, SubscriptionType subscriptionType, Date openedBefore,
		Long complaintId);
	public List<CorporateClient> findClientsOfCorporateResponsible(Long userId);
	public List<CorporateClient> findCorporateClientsByExample(CorporateClient example, Long respId);
	public List<CorporateClient> findAllCorporateClients();
	public List<TaskInstance> findPooledTaskInstancesByGroupActors(List<String> groupActorIds);
	public List<TaskInstance> findPooledTaskInstancesByGroupActors(List<String> groupActorIds, Date createdBefore);
	public List<TaskInstance> findUnassignedPooledTaskInstancesByGroupActors(List<String> groupActorIds, Date createdBefore);
	public List<ComplaintAttachment> findComplaintAttachments(Long complaintId);
	public void updateOpenComplaint(OpenComplaint openComplaint);
}
