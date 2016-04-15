package csv.prepaid.dao;

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

import csv.prepaid.netmovel.domain.BundleActivation;
import csv.prepaid.netmovel.domain.DuoActivation;
import csv.prepaid.netmovel.domain.VoiceAddOnActivation;
import csv.util.persistence.HibernateBaseDao;

@Name("netmovelDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class NetmovelDao extends HibernateBaseDao implements INetmovelDao {

	@Logger
	private Log log;
	
	@In("netmovelHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<BundleActivation> findBundleActivations(String msisdn, Date startDate) {
		List<BundleActivation> returnVal = new ArrayList<BundleActivation>();
		try {
			Query q = session.createQuery("from csv.prepaid.netmovel.domain.BundleActivation a where a.msisdn = ? and a.requestTimestamp >= ? order by a.requestTimestamp desc")
			.setString(0, msisdn).setDate(1, startDate);
			q.setTimeout(300);
			returnVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return returnVal;
	}
	
	public List<DuoActivation> findDuoActivations(String msisdn, Date startDate) {
		List<DuoActivation> returnVal = new ArrayList<DuoActivation>();
		try {
			Query q = session.createQuery("from csv.prepaid.netmovel.domain.DuoActivation a where a.msisdn = ? and a.requestTimestamp >= ? order by a.requestTimestamp desc")
			.setString(0, msisdn).setDate(1, startDate);
			q.setTimeout(300);
			returnVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return returnVal;
	}
	
	public List<VoiceAddOnActivation> findVoiceAddOnActivations(String msisdn, Date startDate) {
		List<VoiceAddOnActivation> returnVal = new ArrayList<VoiceAddOnActivation>();
		try {
			Query q = session.createQuery("from csv.prepaid.netmovel.domain.VoiceAddOnActivation a where a.msisdn = ? and a.requestTimestamp >= ? order by a.requestTimestamp desc")
			.setString(0, msisdn).setDate(1, startDate);
			q.setTimeout(300);
			returnVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return returnVal;
	}
	
	
}
