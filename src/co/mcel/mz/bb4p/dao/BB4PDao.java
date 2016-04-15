package co.mcel.mz.bb4p.dao;

import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import co.mcel.mz.bb4p.model.BB4PReservation;

import csv.util.persistence.HibernateBaseDao;

@Name("bb4pDao")
@Stateless
@AutoCreate
public class BB4PDao extends HibernateBaseDao implements IBB4PDao {

	@Logger
	private Log log;
	
	@In("csvHibernateSession")
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
	public List<BB4PReservation> getReservations(String msisdn) {
		try {
			Query q = session.createQuery("from co.mcel.mz.bb4p.model.BB4PReservation r where r.msisdn = ? order by r.reservationDate desc")
				.setString(0, msisdn);
			return q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
}
