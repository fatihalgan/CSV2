package csv.common.dao;

import java.util.ArrayList;
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

import csv.common.domain.FailedCall;
import csv.common.domain.IMEIRecord;
import csv.util.persistence.HibernateBaseDao;

@Name("cdrliveDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CDRLiveDao extends HibernateBaseDao implements ICDRLiveDao {

	@Logger
	private Log log;
	
	@In("cdrliveHibernateSession")
	private Session session;
	
	@Override
	public Session getSession() {
		return session;
	}

	@Override
	public void setSession(Session session) {
		this.session = session;
	}
	

	@Override
	public List<IMEIRecord> findIMEIRecordsByMsisdn(String msisdn) {
		try {
			Query q = session.createQuery("from csv.common.domain.IMEIRecord r where msisdn = ? order by r.lastCDRDate desc")
				.setString(0, msisdn);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<IMEIRecord>();
	}

	@Override
	public List<FailedCall> findFailedCalls(String msisdn, Date startDate, Date endDate) {
		try {
			Query q = session.getNamedQuery("loadFailedCalls")
				.setString(0, msisdn).setString(1, msisdn).setDate(2, startDate).setDate(3, endDate);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<FailedCall>();
	}

}
