package csv.dr.dao;

import java.io.ByteArrayInputStream;
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

import csv.dr.domain.BillImage;
import csv.util.invoices.InvoiceConverter;
import csv.util.persistence.HibernateBaseDao;

@Name("drDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DrDao extends HibernateBaseDao implements IDrDao {

	@Logger
	private Log log;
	
	@In("drHibernateSession")
	private Session session;
	
	@In("#{invoiceConverter}")
	private InvoiceConverter invoiceConverter;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public List<String> createInvoicePdf(long customerId, String period) {
		ByteArrayInputStream bis = null;
		String retVal = "";
		
		List<String> listRetVal = new ArrayList<String>();
		try {
			Query q = session.getNamedQuery("loadBillImage")
				.setLong(0, customerId).setString(1, period);
			List<BillImage> result = q.list();
			for(BillImage bi : result) {
				bis = new ByteArrayInputStream(bi.getBiImage());
				int ohxAct = bi.getOhxAct();
				retVal = "" +customerId + "_" + ohxAct;
				invoiceConverter.processInvNumber(bis, retVal, false);
				listRetVal.add(retVal);
			}
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		} catch(Exception e) {
			log.error(e);
			throw new RuntimeException(e);
		}
		return listRetVal;
	}
	
}
