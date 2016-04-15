package csv.prepaid.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.prepaid.domain.simreg.activation.AccountAdjustment;
import csv.util.persistence.HibernateBaseDao;

@Name("prepaidDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PrepaidDao extends HibernateBaseDao implements IPrepaidDao {

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
	public List<AccountAdjustment> findSIMActivationAdjustments() {
		List<AccountAdjustment> adjustments = new ArrayList<AccountAdjustment>();
		try {
			adjustments = session.createQuery("from csv.prepaid.domain.simreg.activation.AccountAdjustment")
					.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return adjustments;
	}
}
