package csv.security.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.security.domain.AccessLog;
import csv.security.domain.Adjustment;
import csv.security.domain.EMALog;
import csv.security.domain.Group;
import csv.security.domain.GroupType;
import csv.security.domain.Module;
import csv.security.domain.Operation;
import csv.security.domain.OperationNames;
import csv.security.domain.SMSLog;
import csv.security.domain.User;
import csv.security.domain.VoucherLog;
import csv.util.persistence.HibernateBaseDao;
import csv.vouchers.domain.VoucherAudit;

@Name("securityDao")
@Stateless
@AutoCreate
public class SecurityDao extends HibernateBaseDao implements ISecurityDao {

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

	public User findUserByUserName(String userName) {
		User user = null;
		try {
			Query q = session.createQuery("from csv.security.domain.User u where u.username = ?").setString(0, userName.trim());
			List<User> users = q.list();
			if(users.size() == 0) return null;
			if(users.size() > 1) throw new RuntimeException("Error: More than one user has the same username in the database...");
			return users.get(0);
		} catch (HibernateException e) {
			handleException(e);
		}
		return user;
	}
	
	public List<User> findUsersByExample(User user) {
		try {
			Criteria crit = getSession().createCriteria(User.class)
				.add(Example.create(user).enableLike(MatchMode.ANYWHERE)
				.excludeProperty("supervisor")
				.excludeProperty("active")
				.excludeZeroes().ignoreCase())
				.addOrder(Order.asc("username"));
				List<User> users = crit.list();
			return users;
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public List<Group> findAllGroups() {
		try {
			Query q = session.createQuery("from csv.security.domain.Group g order by g.groupName");
			return q.list();
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public Group findGroupByName(String groupName) {
		try {
			Query q = session.createQuery("from csv.security.domain.Group g where g.groupName = ?");
			List<Group> groups = q.list();
			if(groups.size() > 0) return groups.get(0);
			else return null;
		} catch(HibernateException he) {
			handleException(he);
		}
		return null;
	}
	
	public List<Operation> findAllOperations() {
		try {
			Query q = session.createQuery("from csv.security.domain.Operation o order by o.operationName");
			return q.list();
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public List<Operation> findOperationsByModule(Long moduleId) {
		try {
			Query q = session.createQuery("from csv.security.domain.Operation o where o.owningModule.id = ?").setLong(0, moduleId);
			return q.list();
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}
	
	public Operation findOperationByName(OperationNames operationName) {
		try {
			Query q = session.createQuery("from csv.security.domain.Operation o where o.operationName = ?")
				.setString(0, operationName.toString());
			return (Operation)q.uniqueResult();
		} catch(HibernateException e) {
			log.error(e);
			handleException(e);
		}
		return null;
	}
	
	public List<Module> findAllModules() {
		try {
			Query q = session.createQuery("from csv.security.domain.Module m order by m.moduleName");
			return q.list();
		} catch(HibernateException e) {
			handleException(e);
		}
		return null;
	}

	@Override
	public List<AccessLog> findAccessLogEvents(String msisdn) {
		try {
			Query q = session.createQuery("from csv.security.domain.AccessLog a where a.msisdn = ? order by a.date desc")
				.setString(0, msisdn);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<AccessLog> findAccessLogEventAfter(OperationNames operationName, String msisdn, Date after) {
		try {
			Query q = session.createQuery("from csv.security.domain.AccessLog a where a.msisdn= ? and a.date > ? and a.owningOperation.operationName = ? order by a.date desc")
				.setString(0, msisdn).setDate(1, after).setString(2, operationName.toString());
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<AccessLog> findAccessLogEventsByUser(String username) {
		try {
			Query q = session.createQuery("from csv.security.domain.AccessLog a where a.owningUser.username = ? order by a.date desc")
				.setString(0, username);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public List<VoucherAudit> findVoucherHistory(String serialNumber) {
		List<VoucherAudit> retVal = new ArrayList<VoucherAudit>();
		try {
			Query q = session.createQuery("from csv.security.domain.VoucherLog v where v.serialNumber = ? order by createdTime desc")
				.setString(0, serialNumber.trim());
			retVal = q.list();
		} catch(HibernateException he) {
			handleException(he);
		}
		return retVal;
	}

	@Override
	public List<User> findExpiringUsers(int beforeDay, boolean isExpired) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, beforeDay);
		try {
			Query q = session.createQuery("from csv.security.domain.User u where u.expirationDate <= :expirationDate and ((0 = :isExpired and u.expirationDate > :today) or (1 = :isExpired and u.expirationDate <= :today))")
				.setDate("expirationDate", cal.getTime()).setInteger("isExpired", isExpired? 1 : 0).setDate("today", new Date());
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<User>();
	}

	@Override
	public List<Adjustment> findAdjustmentsOfDay(Date date) {
		List<Adjustment> adjustments = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_YEAR, 1);
			Query q = session.createQuery("from csv.security.domain.Adjustment a where a.adjustmentDate >= ? and a.adjustmentDate < ? order by a.owningUser.firstName, a.owningUser.lastName, a.msisdn, a.status")
				.setDate(0, date).setDate(1, cal.getTime());
			adjustments = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return adjustments;
	}
	
	public List<EMALog> findEMAOperationsOfDay(Date date) {
		List<EMALog> logs = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DAY_OF_YEAR, 1);
			Query q = session.createQuery("from csv.security.domain.EMALog a where a.date >= ? and a.date < ? and a.operationType <> '-1' order by a.owningUser.firstName, a.owningUser.lastName, a.msisdn")
				.setDate(0, date).setDate(1, cal.getTime());
			logs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return logs;
	}

	@Override
	public List<AccessLog> findAccessLogEventsAtDate(Date date) {
		List<AccessLog> logs = null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		try {
			Query q = session.createQuery("from csv.security.domain.AccessLog a where a.date >= ? and a.date < ?")
				.setDate(0, date).setDate(1, cal.getTime());
			logs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return logs;
	}

	@Override
	public List<AccessLog> findAccessLogEventsOfOperationAfter(OperationNames operation, 
		Date after) {
		List<AccessLog> logs = null;
		try {
			Query q = session.createQuery("from csv.security.domain.AccessLog a where a.owningOperation.operationName = ? and a.date > ? order by a.date")
				.setString(0, operation.toString()).setDate(1, after);
			logs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return logs;
	}

	@Override
	public List<AccessLog> findAccessLogEventsBySubscriber(String msisdn,
		Date after) {
		List<AccessLog> logs = null;
		try {
			Query q = session.createQuery("from csv.security.domain.AccessLog a where a.msisdn = ? and a.date >= ? order by a.date")
				.setParameter(0, msisdn).setDate(1, after);
			logs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return logs;
	}

	@Override
	public List<SMSLog> findSMSHistoryAfter(String msisdn, Date date) {
		List<SMSLog> logs = null;
		try {
			Query q = session.createQuery("from csv.security.domain.SMSLog a where a.msisdn = ? and a.createdTime >= ? order by a.createdTime")
				.setParameter(0, msisdn).setDate(1, date);
			logs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return logs;
	}

	@Override
	public List<User> findAllCorporateAccountManagers() {
		try {
			Query q = session.createQuery("select u from csv.security.domain.User u, " +
				"csv.security.domain.Group g where u in elements(g.usersInGroup) " +
				"and g.groupName = 'Corporate Responsible'");
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<User>();
	}

	@Override
	public List<Group> findGroupByUserGroupType(GroupType type) {
		try {
			Query q = session.createQuery("from csv.security.domain.Group g where groupType = ?")
				.setParameter(0, type);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Group>();
	}
	
	public List<Group> findGroupByUserGroupType(GroupType[] types) {
		List<Group> retVal = new ArrayList<Group>();
		for(GroupType type : types) {
			retVal.addAll(findGroupByUserGroupType(type));
		}
		return retVal;
	}
	
	public List<Group> getRecursiveChildGroups(Group g) {
		List<Group> returnVal = new ArrayList<Group>();
		List<Group> allGroups = findAllGroups();
		for(Group element : allGroups) {
			if(element.isDescendantOf(g)) returnVal.add(element);
		}
		return returnVal;
	}
	
	public List<String> getRecursiveChildGroupNames(Group g) {
		List<String> returnVal = new ArrayList<String>();
		List<Group> groups = getRecursiveChildGroups(g);
		for(Group element : groups) {
			returnVal.add(element.getGroupName());
		}
		return returnVal;
	}
}
