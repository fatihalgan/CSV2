package csv.common.dao;

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

import csv.common.domain.TomalaBlacklist;
import csv.common.domain.TomalaBlockingStatus;
import csv.common.domain.TomalaTransaction;
import csv.util.persistence.HibernateBaseDao;

@Name("tomalaDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TomalaDao extends HibernateBaseDao implements ITomalaDao {

	@Logger
	private Log log;
	
	@In("tomalaHibernateSession")
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;		
	}

	@Override
	public TomalaBlockingStatus findTomalaBlockingStatus(String msisdn) {
		try {
			Query q = session.createQuery("from csv.common.domain.TomalaBlacklist b where b.msisdn = ?")
				.setString(0, msisdn);
			List<TomalaBlacklist> bl = q.list();
			if(bl.size() == 0) return TomalaBlockingStatus.Available;
			else return TomalaBlockingStatus.Blocked;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public TomalaBlacklist findBlacklistingInfo(String msisdn) {
		try {
			Query q = session.createQuery("from csv.common.domain.TomalaBlacklist b where b.msisdn = ?")
				.setString(0, msisdn);
			List<TomalaBlacklist> bl = q.list();
			if(bl.size() == 0) return null;
			else return bl.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<TomalaTransaction> findTomalaTransactions(String msisdn) {
		try {
			Query q = session.createQuery("from csv.common.domain.TomalaTransaction t where t.sender = ? or t.receiver = ? order by date desc")
				.setString(0, msisdn).setString(1, msisdn);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
}
