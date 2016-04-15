package csv.common.dao;

import java.util.ArrayList;
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

import csv.common.domain.Province;
import csv.util.persistence.HibernateBaseDao;

@Name("commonObjectsDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CommonObjectsDao extends HibernateBaseDao implements ICommonObjectsDao {

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
	public List<Province> getAllProvinces() {
		try {
			Query q = session.createQuery("from csv.common.domain.Province p");
			List<Province> provinces = q.list();
			return provinces;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Province>();
	}
	
}
