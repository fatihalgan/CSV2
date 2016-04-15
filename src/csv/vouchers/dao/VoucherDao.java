package csv.vouchers.dao;

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

import csv.util.persistence.HibernateBaseDao;
import csv.vouchers.domain.VoucherAudit;

@Name("voucherDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class VoucherDao extends HibernateBaseDao implements IVoucherDao {

	@Logger
	private Log log;
	
	@In("voucherHibernateSession")
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<VoucherAudit> loadVouhcerHistory(String serialNum) {
		List<VoucherAudit> retVal = new ArrayList<VoucherAudit>();
		try {
			Query q = session.getNamedQuery("loadVoucherHistory").setString("serialNum", serialNum);
			retVal = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return retVal;
	}

}
