package com.bridge.pm.dao;

import java.math.BigDecimal;
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

import com.bridge.pm.domain.ActiveProvisioning;

import csv.util.persistence.HibernateBaseDao;

@Name("provisionManagerDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ProvisionManagerDao extends HibernateBaseDao implements IProvisionManagerDao {

	@Logger
	private Log log;
	
	@In("pmHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public ActiveProvisioning findActiveProvisioning(String msisdn) {
		ActiveProvisioning p = null;
		try {
			Query q = session.createQuery("from com.bridge.pm.domain.ActiveProvisioning p where p.msisdn = ?").setString(0, msisdn);
			List<ActiveProvisioning> provs = q.list();
			if(provs.size() == 0) return null;
			if(provs.size() > 1) throw new RuntimeException("Error: More than one active provisioning record was found for MSISDN " + msisdn + " in the Provision Manager system..");
			p = provs.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return p;
	}

	@Override
	public List<ActiveProvisioning> findActiveProvisioningsByImsi(String imsi) {
		List<ActiveProvisioning> provs = null;
		try {
			Query q = session.createQuery("from com.bridge.pm.domain.ActiveProvisioning p where p.imsi = ?").setString(0, imsi);
			provs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return provs;
	}

	@Override
	public boolean hasActiveProvisioning(String msisdn) {
		ActiveProvisioning p = null;
		try {
			Query q = session.createQuery("from com.bridge.pm.domain.ActiveProvisioning p where p.msisdn = ?").setString(0, msisdn);
			p = (ActiveProvisioning)q.uniqueResult();
			if(p == null) return false;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return true;
	}
	
	public Long fetchProvisioningRequestId() {
		try {
			Query q = session.createSQLQuery("select prov_request_id.nextVal from dual");
			List result = q.list();
			Long i = ((BigDecimal)result.get(0)).longValue();
			return i;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
}
