package csv.postpaid.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
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

import com.rim.blackberry.provision.RIMEvent;

import csv.common.domain.PUKInfo;
import csv.postpaid.domain.BillingAccount;
import csv.postpaid.domain.CallView;
import csv.postpaid.domain.Contract;
import csv.postpaid.domain.DirectoryNumber;
import csv.postpaid.domain.Document;
import csv.postpaid.domain.GprsUsage;
import csv.postpaid.domain.InvoiceInfo;
import csv.postpaid.domain.LargeAccount;
import csv.postpaid.domain.Memo;
import csv.postpaid.domain.Payment;
import csv.postpaid.domain.PaymentArrangement;
import csv.postpaid.domain.PostpaidAccount;
import csv.postpaid.domain.PromotionPackage;
import csv.postpaid.domain.PromotionPackageHistoryItem;
import csv.postpaid.domain.RatePlanChange;
import csv.postpaid.domain.StatusChange;
import csv.postpaid.domain.StorageMediumChange;
import csv.util.persistence.HibernateBaseDao;

@Name("bscsDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class BSCSDao extends HibernateBaseDao implements IBSCSDao {

	@Logger
	private Log log;
	
	@In("bscsHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public PUKInfo findPUKInfo(String msisdn) {
		try {
			Query q = session.getNamedQuery("loadPUKInfo").setString(0, msisdn);
			q.setTimeout(300);
			List<PUKInfo> puks = q.list();
			if(puks.size() > 0) return puks.get(0);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public boolean subscriberExistsInPostpaid(String msisdn) {
		try {
			Query q = session.createSQLQuery("select count(*) from MSISDN_POSTPAID_VIEW where DN_NUM= ?")
				.setString(0, msisdn);
			q.setTimeout(300);
			List result = q.list();
			Long i = ((BigDecimal)result.get(0)).longValue();
			if(i.longValue() == 0) return false;
			else return true;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return false;
	}
	
	public InvoiceInfo findInvoiceByInvoiceNo(String invoiceNumber) {
		try {
			Query q = session.createSQLQuery("select BI_REFERENCE from SYSADM.BGH_BILL_IMAGE_REF  where  DOC_REFNUM = ? And BI_TYPE IS NOT NULL And BILL_MODE = 'REG'")
				.setString(0, invoiceNumber);
			q.setTimeout(300);
			List result = q.list();
			if(result.size() == 0) throw new RuntimeException("Invoice could not be found..");
			String path = ((String)result.get(0));
			if(path == null) throw new RuntimeException("Invoice could not be found..");
			else return new InvoiceInfo(invoiceNumber, path);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public InvoiceInfo findInvoiceByCustomerAndPeriod(Integer customerId, String period) {
		try {
			Query q = session.createSQLQuery("Select to_char(DOC_GEN_DATE, 'dd/mm/yyyy'), BI_REFERENCE "
				+ "From Sysadm.BGH_BILL_IMAGE_REF, Sysadm.DR_DOCUMENTS "
				+ "Where CUST_ID = ? "
				+ "And TO_CHAR(DR_ASS_DOC_RF_DATE_TIMESTAMP,'yyyy/mm') = ? "
				+ "And DOC_REFNUM = DR_ASS_DOC_NUMBER_EXTERNAL_ID "
				+ "And BI_TYPE IS NOT NULL "
				+ "And BILL_MODE = 'REG'")
				.setInteger(0, customerId).setString(1, period);
			q.setTimeout(300);
			List result = q.list();
			Iterator it = result.iterator();
			InvoiceInfo info = new InvoiceInfo(period);
			while(it.hasNext()) {
				Object[] item = (Object[])it.next();
				String path = (String)item[1];
				info.addInvoicePath(path);
			}
			return info;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public PostpaidAccount findCustomerByMsisdn(String msisdn) {
		try {
			Query q = session.createSQLQuery("select cust.customer_id "
				+ "from customer_all cust, contract_all cont, contr_services_cap serv, directory_number dir "
				+ "where cust.customer_id = cont.customer_id "
				+ "and cont.co_id = serv.co_id "
				+ "and serv.dn_id = dir.dn_id and dir.dn_num = ? "
				+ "and serv.cs_activ_date in ( "
				+ "select max(cs_activ_date) "
				+ "from contr_services_cap serv, directory_number dir "
				+ "where dir.dn_num = ? "
				+ "and dir.dn_id = serv.dn_id)").setString(0, msisdn).setString(1, msisdn);
			q.setTimeout(300);
			List result = q.list();
			if(result.size() == 0) return null;
			Integer customerId = ((BigDecimal)result.get(0)).intValue();
			return findCustomerByCustomerId(customerId);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public String findCustomerCodeFromStorageMedium(String storageMediumNo) {
		try {
			Query q = session.createSQLQuery("Select cu.custcode From storage_medium sm, " +
				"contr_devices cd, contract_all c, customer_all cu " +
				"Where sm.sm_serialnum = cd.cd_sm_num And cd.co_id = c.co_id " +
				"And c.customer_id = cu.customer_id " +
				"And cd.CD_DEACTIV_DATE IS NULL And sm_serialnum = ?").setString(0, storageMediumNo);
			q.setTimeout(300);
			List result = q.list();
			if(result.size() == 0) throw new RuntimeException("Customer code for the given storage medium number could not be found..");
			String customerCode = (String)result.get(0);
			return customerCode;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public String findCustomerCodeFromMSISDN(String msisdn) {
		try {
			Query q = session.createSQLQuery("SELECT cu.custcode FROM CONTR_SERVICES_CAP CSC, " +
				"DIRECTORY_NUMBER DN, customer_all cu, contract_all co " +
				"WHERE DN.DN_ID = CSC.DN_ID AND cu.customer_id = co.customer_id " +
				"AND co.co_id = csc.co_id AND CS_DEACTIV_DATE IS NULL AND DN_NUM = ?").setString(0, msisdn);
			q.setTimeout(300);
			List result = q.list();
			if(result.size() == 0) throw new RuntimeException("Customer code for the given MSISDN could not be found..");
			String customerCode = (String)result.get(0);
			return customerCode;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public List<PostpaidAccount> findCustomersByCustomerCodeAndName(String customerCode, String firstName, String lastName) {
		List<PostpaidAccount> result = null;
		try {
			if(null == customerCode) customerCode = "";
			if(null == firstName) firstName = "";
			if(null == lastName) lastName="";
			Query q = session.getNamedQuery("loadPostpaidAccountByCustomerCodeAndName")
				.setString("customerCode", "%" + customerCode.toLowerCase() + "%")
				.setString("firstName", "%" + firstName.toLowerCase() + "%")
				.setString("lastName", "%"+ lastName.toLowerCase() + "%");
			q.setTimeout(300);
			result = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return result;
	}
	
	public PostpaidAccount findCustomerByInvoiceNo(String invoiceNo) {
		try {
			Query q = session.getNamedQuery("loadPostpaidAccountFromInvoiceNo").setString(0, invoiceNo);
			q.setTimeout(300);
			PostpaidAccount acct = (PostpaidAccount)q.uniqueResult();
			return acct;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public PostpaidAccount findCustomerByCustomerId(Integer customerId) {
		try {
			Query q = session.getNamedQuery("loadPostpaidAccountByCustomerId").setInteger(0, customerId);
			q.setTimeout(300);
			PostpaidAccount acct = (PostpaidAccount)q.uniqueResult();
			return acct;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	public PostpaidAccount findCustomerByCustomerCode(String customerCode) {
		try {
			Query q = session.getNamedQuery("loadPostpaidAccount").setString("customerCode", customerCode.toLowerCase());
			q.setTimeout(300);
			PostpaidAccount acct = (PostpaidAccount)q.uniqueResult();
			if(acct == null) throw new RuntimeException("Could not find any customer with customer code: " + customerCode);
			return acct;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
	
	@Override
	public List<CallView> findCallView(Integer customerId, Date startDate,
			Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, 1);
		endDate = cal.getTime();
		List<CallView> result = null;
		try {
			Query q = session.getNamedQuery("loadCallView").setInteger("customerId", customerId)
			.setDate("startDate", startDate).setDate("endDate", endDate);
			result = q.list();
			Collections.sort(result);
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return result;
	}

	@Override
	public List<LargeAccount> findLargeAccounts(String customerCode) {
		List<LargeAccount> accounts = null;
		try {
			Query q = session.getNamedQuery("loadLargeAccount").setString(0, customerCode);
			accounts = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return accounts;
	}
	
	public List<Contract> findContractsByCustomerCode(String customerCode) {
		List<Contract> contracts = null;
		try {
			Query q = session.getNamedQuery("loadContractsByCustomerCode").setString(0, customerCode);
			contracts = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return contracts;
	}
	
	public List<StatusChange> findContractStatusHistory(long contractId) {
		List<StatusChange> history = null;
		try {
			Query q = session.getNamedQuery("loadContractStatusHistory").setLong(0, contractId);
			history = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return history;
	}
	
	@Override
	public List<RatePlanChange> findRatePlanChanges(long contractId) {
		List<RatePlanChange> history = null;
		try {
			Query q = session.getNamedQuery("loadRatePlanChanges").setLong(0, contractId);
			history = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return history;
	}

	@Override
	public List<StorageMediumChange> findStorageMediumChanges(long contractId) {
		List<StorageMediumChange> history = null;
		try {
			Query q = session.getNamedQuery("loadStorageMediumChanges").setLong(0, contractId);
			history = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return history;
	}
	

	@Override
	public List<DirectoryNumber> findDirectoryNumbersByContract(long contractId) {
		List<DirectoryNumber> dnList = null;
		try {
			Query q = session.getNamedQuery("loadDirectoryNumbers").setLong(0, contractId);
			dnList= q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return dnList;
	}

	@Override
	public List<GprsUsage> findGprsUsage(long contractId, Date startDate,
			Date endDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, 1);
		endDate = cal.getTime();
		List<GprsUsage> usage = new ArrayList<GprsUsage>();
		try {
			Query q = session.getNamedQuery("loadGprsUsages").setLong(0, contractId)
				.setDate(1, startDate).setDate(2, endDate);
			usage = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return usage;
	}
	
	@Override
	public PaymentArrangement findPaymentArrangement(String customerCode) {
		try {
			Query q = session.getNamedQuery("loadPaymentArrangement").setString(0, customerCode);
			PaymentArrangement ar = (PaymentArrangement)q.uniqueResult();
			return ar;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public List<Document> findDocumentsWithBillingAccount(String customerId,
			Long accountId) {
		List<Document> docs = null;
		try {
			Query q = session.getNamedQuery("loadDocumentsWithBillingAccount")
				.setString(0, customerId).setLong(1, accountId).setLong(2, accountId);
			docs = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return docs;
	}

	@Override
	public List<Payment> findPayments(String customerId) {
		List<Payment> payments = null;
		try {
			Query q = session.getNamedQuery("loadPayments").setString(0, customerId);
			payments = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return payments;
	}

	@Override
	public List<BillingAccount> findBillingAccounts(String customerId) {
		List<BillingAccount> accounts = null;
		try {
			Query q = session.getNamedQuery("loadBillingAccounts").setString(0, customerId);
			accounts = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return accounts;
	}

	@Override
	public List<PromotionPackage> findPromotionPackages(String customerId) {
		List<PromotionPackage> packages = null;
		try {
			Query q = session.getNamedQuery("loadPromotionPackages").setString(0, customerId);
			packages = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return packages;
	}

	@Override
	public List<PromotionPackageHistoryItem> findPromotionPackageHistory(
			String customerId, Integer assignSeqNo) {
		List<PromotionPackageHistoryItem> hist = null;
		try {
			Query q = session.getNamedQuery("loadPromotionPackageHistory").setString(0, customerId).setInteger(1, assignSeqNo);
			hist = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return hist;
	}

	@Override
	public List<Memo> findMemos(String customerId) {
		List<Memo> memos = null;
		try {
			Query q = session.getNamedQuery("loadMemos").setString(0, customerId);
			memos = q.list();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return memos;
	}

	@Override
	public String findMSISDNByStorageMediumNo(String storageMediumNo) {
		if(!storageMediumNo.endsWith("F")) storageMediumNo = storageMediumNo + "F";
		try {
			Query q = session.createSQLQuery("select dn_num " +
				"from contr_services_cap csc, directory_number dn, contr_devices cd " +
				"where dn.dn_id = csc.dn_id and cd.co_id = csc.co_id " +
				"and cs_deactiv_date is null and cd_deactiv_date is null " +
				"and main_dirnum = 'X' and cd_sm_num = ?").setString(0, storageMediumNo);
			q.setTimeout(300);
			List result = q.list();
			if(result.size() == 0) throw new RuntimeException("MSISDN for the given Storage Medium could not be found in BSCS..");
			String msisdn = (String)result.get(0);
			return msisdn;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public Long findInvoiceSequenceNumber(Integer customerId, String period) {
		try {
			Query q = session.createSQLQuery("SELECT dr_request_ass_doc_request_id FROM dr_documents " +
				"Where DR_ADDRESSEE_CUSTOMER_ID = ? And DR_ASS_DOC_TYPE_GEN_PURPOSE like 'REG' " +
				"And to_char(DR_ASS_DOC_CR_DATE_TIMESTAMP,'yyyy/mm') = ?").setInteger(0, customerId)
				.setString(1, period);
			q.setTimeout(300);
			List result = q.list();
			if(result.size() == 0) throw new RuntimeException("The invoice sequence number could not be found..");
			BigDecimal sequenceNo = (BigDecimal)result.get(0);
			return sequenceNo.longValue();
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}

	@Override
	public List<RIMEvent> findUnprocessedRIMEvents() {
		try {
			Query q = session.createQuery("from com.rim.blackberry.provision.RIMEvent e where (e.action is null or e.action = 'R') and (e.serviceStatus <> ? or e.serviceStatus is null)")
				.setParameter(0, "O").setMaxResults(20);
			List<RIMEvent> events = q.list();
			return events;
		} catch(HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return null;
	}
}
