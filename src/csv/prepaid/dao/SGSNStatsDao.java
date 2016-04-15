package csv.prepaid.dao;

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

import csv.prepaid.netmovel.domain.SGSNDataUsage;
import csv.util.persistence.HibernateBaseDao;

@Name("sgsnStatsDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SGSNStatsDao extends HibernateBaseDao implements ISGSNStatsDao {

	@Logger
	private Log log;
	
	@In("sgsnStatsHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<SGSNDataUsage> findSGSNDataUsage(String msisdn, Date after) {
		List<SGSNDataUsage> history = null;
		try {
			Query q = session.createQuery("from csv.prepaid.netmovel.domain.SGSNDataUsage u where u.msisdn = ? and u.openingTime >= ?")
				.setString(0, msisdn).setDate(1, after);
			history = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return history;
	}
}
