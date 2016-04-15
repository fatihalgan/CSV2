package csv.prepaid.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.prepaid.domain.history.AbstractAccountEvent;
import csv.prepaid.domain.history.Account;
import csv.prepaid.domain.history.AccountEvent;
import csv.prepaid.domain.history.CashAccountChangeInfo;
import csv.prepaid.domain.history.FaFEntry;
import csv.prepaid.domain.history.LifeCycleChangeInfo;
import csv.prepaid.domain.history.UsageEvent;
import csv.util.persistence.HibernateBaseDao;

@Name("dwsDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DWSDao extends HibernateBaseDao implements IDWSDao {

	@Logger
	private Log log;
	
	@In("dwsHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public Account findAccountByMsisdn(String msisdn) {
		try {
			Query q = session.getNamedQuery("loadDWSAccount").setString(0, msisdn);
			q.setTimeout(300);
			List<Account> accounts = q.list();
			if(accounts.size() > 0) return accounts.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<AccountEvent> findAccountEvents(Long subscriberId, Date startDate, Date endDate) {
		List<AccountEvent> accountEvents = new ArrayList<AccountEvent>();
		try {
			Query q = session.getNamedQuery("loadDWSAccountEvents")
				.setLong(0, subscriberId).setDate(1, startDate).setDate(2, endDate);
			q.setTimeout(500);
			accountEvents = q.list();				
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return accountEvents;
	}
	
	public List<UsageEvent> findUsageEvents(Long accountId, Date startDate, Date endDate) {
		List<UsageEvent> usageEvents = new ArrayList<UsageEvent>();
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(endDate);
			cal.set(Calendar.HOUR, 23);
			endDate = cal.getTime();
			Query q = session.getNamedQuery("loadDWSUsageEvents")
				.setLong(0, accountId).setString(1, formatTimeHourID(startDate, 0)).setString(2, formatTimeHourID(endDate, 1));
			q.setTimeout(500);
			usageEvents = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return usageEvents;
	}
	
	private String formatTimeHourID(Date date, int hourHalf) {
		DateFormat format = new SimpleDateFormat("yyyyMMddHH");
		String strDate = format.format(date);
		strDate = strDate + hourHalf;
		return strDate;
	}
	
	public List<AbstractAccountEvent> retrieveAccountHistory(Long subscriberId, Long accountId, Date startDate, Date endDate) {
		List<AccountEvent> acctevt = findAccountEvents(subscriberId, startDate, endDate);
		List<UsageEvent> usgevt = findUsageEvents(accountId, startDate, endDate);
		List <AbstractAccountEvent> returnVal = new ArrayList<AbstractAccountEvent>();
		returnVal.addAll(acctevt);
		returnVal.addAll(usgevt);
		Collections.sort(returnVal);
		return returnVal;
	}
	
	public List<CashAccountChangeInfo> retrieveCashAccountChanges(Long eventId) {
		List<CashAccountChangeInfo> returnVal = new ArrayList<CashAccountChangeInfo>();
		try {
			Query q = session.getNamedQuery("loadCashAccountChanges")
				.setLong(0, eventId);
			returnVal = q.list();				
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return returnVal;
	}

	@Override
	public List<LifeCycleChangeInfo> retrieveLifeCycleInfoChanges(Long eventId) {
		List<LifeCycleChangeInfo> returnVal = new ArrayList<LifeCycleChangeInfo>();
		try {
			Query q = session.getNamedQuery("loadLifeCycleInfoChanges")
				.setLong(0, eventId).setLong(1, eventId);
			returnVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return returnVal;
	}

	@Override
	public List<FaFEntry> retrieveFaFHistory(Long subscriberId, Date startDate, Date endDate) {
		List<FaFEntry> returnVal = new ArrayList<FaFEntry>();
		try {
			Query q = session.getNamedQuery("loadFaFHistory")
				.setLong(0, subscriberId).setDate(1, startDate).setDate(2, endDate);
			q.setTimeout(300);
			returnVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return returnVal;
	}
}
