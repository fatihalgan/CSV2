package csv.crm.complaintmng.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.ws.security.message.token.Timestamp;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.TransactionPropagationType;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.log.Log;
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
import csv.util.persistence.HibernateBaseDao;

@Name("complaintManagementDao")
@Stateless
@AutoCreate
@Transactional(TransactionPropagationType.REQUIRED)
public class ComplaintManagementDao extends HibernateBaseDao implements IComplaintManagementDao {

	@Logger
	private Log log;
	
	@In("csvHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<ComplaintSegment> findAllComplaintSegments() {
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.ComplaintSegment s order by s.id");
			List<ComplaintSegment> segments = q.list();
			return segments;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public PersonalComplaintOwner findPersonalComplaintOwnerByMsisdn(String msisdn) {
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.PersonalComplaintOwner o where o.msisdn = ?")
				.setString(0, msisdn);
			List<PersonalComplaintOwner> owners = q.list();
			if(owners.size() == 0) return null;
			return owners.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public CorporateComplaintOwner findCorporateComplaintOwnerByMsisdn(String msisdn) {
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.CorporateComplaintOwner o where o.msisdn = ?")
				.setString(0, msisdn);
			List<CorporateComplaintOwner> owners = q.list();
			if(owners.size() == 0) return null;
			return owners.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public CorporateComplaintOwner findCorporateComplaintOwnerByCustomerCode(String customerCode) {
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.CorporateComplaintOwner o where o.company.customerCode = ?")
				.setString(0, customerCode);
			List<CorporateComplaintOwner> owners = q.list();
			if(owners.size() == 0) return null;
			return owners.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<Complaint> findComplaintsByMsisdn(String msisdn) {
		List<Complaint> complaints = new ArrayList<Complaint>();
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.Complaint c where c.owner.msisdn = ? order by openingDate desc")
				.setString(0, msisdn);
			complaints = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return complaints;
	}
	
	public List<Complaint> findComplaintsByCustomerCode(String customerCode) {
		List<Complaint> complaints = new ArrayList<Complaint>();
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.Complaint c where c.owner.class = " +
				"csv.crm.complaintmng.domain.CorporateComplaintOwner and c.owner.company.customerCode = ? order by openingDate desc")
				.setString(0, customerCode);
			complaints = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return complaints;
	}
	
	@Override
	public OpenComplaint findOpenComplaint(Long complaintId) {
		OpenComplaint comp = (OpenComplaint)ManagedJbpmContext.instance().getSession().get(OpenComplaint.class, complaintId);
		return comp;
	}
	
	public List<OpenComplaint> findOpenComplaints(ComplaintStatus status, String msisdn, String customerCode, SubscriptionType subscriptionType, 
		Date openedAfter, Long complaintId) {
		Criteria cr = ManagedJbpmContext.instance().getSession().createCriteria(OpenComplaint.class);
		if(status != null) cr.add(Restrictions.eq("status", status));
		if(subscriptionType != null) cr.add(Restrictions.eq("subscriptionType", subscriptionType));
		if(msisdn != null && msisdn.length() > 0) cr.add(Restrictions.eq("customerMsisdn", msisdn));
		if(customerCode != null && customerCode.length() > 0) cr.add(Restrictions.eq("customerCode", customerCode));
		if(complaintId != null) cr.add(Restrictions.eq("complaintId", complaintId));
		cr.add(Restrictions.ge("openingDate", openedAfter));
		cr.addOrder(Order.asc("openingDate"));
		return cr.list();
	}
	
	@Override
	public List<CorporateClient> findClientsOfCorporateResponsible(Long userId) {
		List<CorporateClient> retVal = new ArrayList<CorporateClient>();
		try {
			Query q = session.createQuery("from csv.crm.complaintmng.domain.CorporateClient c " +
				"where c.corporateResponsible.id = ? order by c.companyName asc");
			retVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return retVal;
	}
	
	public List<CorporateClient> findCorporateClientsByExample(CorporateClient example, Long respId) {
		try {
			Criteria crit = getSession().createCriteria(CorporateClient.class)
				.add(Example.create(example).enableLike(MatchMode.START)
				.excludeZeroes())
				.addOrder(Order.asc("companyName"));
			if(respId != null) crit.createCriteria("corporateResponsible").add(
				Restrictions.eq("id", respId));
			List<CorporateClient> clients = crit.list();
			return clients;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CorporateClient>();
	}
	
	public List<CorporateClient> findAllCorporateClients() {
		try {
			Query q = getSession().createQuery("from csv.crm.complaintmng.domain.CorporateClient c order by c.companyName asc");
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public List<TaskInstance> findPooledTaskInstancesByGroupActors(List<String> groupActorIds) {
		List<TaskInstance> taskInstances = null;
		try {
			String queryStr = "Select ti from org.jbpm.taskmgmt.exe.TaskInstance ti, org.jbpm.taskmgmt.exe.PooledActor pa " +
			"where ti in elements(pa.taskInstances) and " +
			"ti.isOpen = :open and ti.processInstance.isSuspended = :suspended and pa.actorId in (:actorIds) order by ti.priority asc";
		    taskInstances = ManagedJbpmContext.instance().getSession()
		    .createQuery(queryStr).setBoolean("open", true).setBoolean("suspended", false).setParameterList("actorIds", groupActorIds)
		    .list();
		    return taskInstances;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<TaskInstance>();
	}
	
	@Override
	public List<TaskInstance> findPooledTaskInstancesByGroupActors(List<String> groupActorIds, Date createdBefore) {
		List<TaskInstance> taskInstances = null;
		try {
			String queryStr = "Select ti from org.jbpm.taskmgmt.exe.TaskInstance ti, org.jbpm.taskmgmt.exe.PooledActor pa " +
			"where ti in elements(pa.taskInstances) and " +
			"ti.isOpen = :open and ti.processInstance.isSuspended = :suspended and ti.isCancelled = :cancelled and pa.actorId in (:actorIds) " +
			"and ti.processInstance.start < :createTime order by ti.priority asc";
		    taskInstances = ManagedJbpmContext.instance().getSession()
		    .createQuery(queryStr).setBoolean("open", true).setBoolean("suspended", false)
		    .setBoolean("cancelled", false)
		    .setTimestamp("createTime", new java.sql.Timestamp(createdBefore.getTime()))
		    .setParameterList("actorIds", groupActorIds)
		    .list();
		    return taskInstances;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<TaskInstance>();
	}

	@Override
	public List<TaskInstance> findUnassignedPooledTaskInstancesByGroupActors(List<String> groupActorIds, Date createdBefore) {
		List<TaskInstance> taskInstances = null;
		try {
			String queryStr = "Select ti from org.jbpm.taskmgmt.exe.TaskInstance ti, org.jbpm.taskmgmt.exe.PooledActor pa " +
			"where ti in elements(pa.taskInstances) and " +
			"ti.isOpen = :open and ti.isSuspended = :suspended and ti.isCancelled = :cancelled and ti.actorId is null and pa.actorId in (:actorIds) " +
			"and ti.create < :createTime " +
			"order by ti.priority asc";
		    taskInstances = ManagedJbpmContext.instance().getSession()
		    .createQuery(queryStr).setBoolean("open", true).setBoolean("suspended", false).setBoolean("cancelled", false)
		    .setParameterList("actorIds", groupActorIds)
		    .setTimestamp("createTime", new java.sql.Timestamp(createdBefore.getTime()))
		    .list();
		    return taskInstances;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<TaskInstance>();
	}

	@Override
	public List<ComplaintAttachment> findComplaintAttachments(Long complaintId) {
		List<ComplaintAttachment> attachments = null;
		try {
			Query q = getSession().createQuery("from csv.crm.complaintmng.domain.ComplaintAttachment c where " +
				"c.owningComplaint.id = ?").setLong(0, complaintId);
			attachments = q.list();
			return attachments;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<ComplaintAttachment>();
	}

	@Override
	public void updateOpenComplaint(OpenComplaint openComplaint) {
		try {
			ManagedJbpmContext.instance().getSession().update(openComplaint);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		
	}

	
}
