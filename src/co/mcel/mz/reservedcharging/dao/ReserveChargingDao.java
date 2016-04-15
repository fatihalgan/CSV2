package co.mcel.mz.reservedcharging.dao;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.util.persistence.HibernateBaseDao;

@Name("reserveChargingDao")
@Stateless
@AutoCreate
public class ReserveChargingDao extends HibernateBaseDao implements IReserveChargingDao {

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
}
