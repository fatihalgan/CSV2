package csv.postpaid.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.dr.dao.IDrDao;
import csv.postpaid.dao.IBSCSDao;
import csv.postpaid.domain.BillingAccount;
import csv.postpaid.domain.CallView;
import csv.postpaid.domain.InvoiceInfo;
import csv.postpaid.domain.PostpaidAccount;
import csv.security.domain.OperationNames;
import csv.util.bscs.ftp.BSCSFTPHelper;

@Name("postpaidService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class PostpaidService extends BaseService implements IPostpaidService {

	private static final long serialVersionUID = -5239719749906840298L;

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("bscsDao")
	private IBSCSDao bscsDao;
	
	@In("drDao")
	private IDrDao drDao;
	
	@In("#{bscsFTPHelper}")
	private BSCSFTPHelper bscsFTPHelper;
	
	@In
	private Renderer renderer;
	
	private PostpaidAccount postpaidAccount = null;
	
	private InvoiceInfo invoiceInfo = new InvoiceInfo();
	
	private String invoiceFileName = null;
	
	private Date startDate;
	private Date endDate;
		
	public PostpaidService() {
		super();
	}
	
	@PostConstruct
	public void initialize() {
		endDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, -3);
		startDate = new Date();
		startDate.setTime(cal.getTimeInMillis());
	}

	public PostpaidAccount getPostpaidAccount() {
		return postpaidAccount;
	}

	public void setPostpaidAccount(PostpaidAccount postpaidAccount) {
		this.postpaidAccount = postpaidAccount;
	}

	@Override
	public InvoiceInfo getInvoiceInfo() {
		return this.invoiceInfo;
	}
	
	public void setInvoiceNo(InvoiceInfo invoiceInfo) {
		this.invoiceInfo = invoiceInfo;
	}
	
	public String getInvoiceFileName() {
		return invoiceFileName;
	}

	public void setInvoiceFileName(String invoiceFileName) {
		this.invoiceFileName = invoiceFileName;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	@Begin(join=true)
	public void retrieveCurrentCustomerDetails() {
		try {
			if(currentCustomer != null) postpaidAccount = bscsDao.findCustomerByMsisdn(currentCustomer.getFullMsisdn());
			if(postpaidAccount == null) postpaidAccount = new PostpaidAccount();
		} catch(Exception e) {
			postpaidAccount = new PostpaidAccount();
			facesMessages.add(Severity.ERROR, "Customer Details for the current MSISDN could not be found: " + e.getMessage());
		}
	}

	@Override
	public void retrieveInvoiceInfoByInvoiceNo() {
		try {
			invoiceInfo = bscsDao.findInvoiceByInvoiceNo(invoiceInfo.getInvoiceNo());
			prepareInvoicePath();
			postpaidAccount = bscsDao.findCustomerByInvoiceNo(invoiceInfo.getInvoiceNo());
			logAccess(OperationNames.PostpaidFindInvoiceDetail, currentCustomer.getFullMsisdn(), postpaidAccount.getCustomerCode(), postpaidAccount.getCustomerId(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not find Invoice Detials or Customer Details: " + e.getMessage());
		}
	}
	
	@Override
	public void retrieveInvoiceInfoByCustomerDetails() {
		try {
			postpaidAccount = bscsDao.findCustomerByCustomerCode(postpaidAccount.getCustomerCode().trim());
			invoiceInfo = bscsDao.findInvoiceByCustomerAndPeriod(postpaidAccount.getCustomerId(), invoiceInfo.getPeriod());
			prepareInvoicePath();
			logAccess(OperationNames.PostpaidFindInvoiceDetail, currentCustomer.getFullMsisdn(), postpaidAccount.getCustomerCode(), postpaidAccount.getCustomerId(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not find Invoice Detials or Customer Details: " + e.getMessage());
		}
	}
	
	public void prepareInvoicePath() {
		if(invoiceInfo.getInvoicePathList().isEmpty()) {
			List<String> sourcePathList = drDao.createInvoicePdf(postpaidAccount.getCustomerId(), invoiceInfo.getPeriod());
			List<String> destPathList = new ArrayList<String>();
			for(String path : sourcePathList) {
				if(path != null && !"".equals(path)) {
					path = getRequestContextPath() + "/invoices/" + path +".pdf";
					destPathList.add(path);
				}
			}
			invoiceInfo.setInvoicePathList(destPathList);
		} else { 
			String invoicePath = bscsFTPHelper.getInvoiceFromBSCS(invoiceInfo.getInvoicePathList().get(0), getRealInvoicesPath());
			if (invoicePath != null && !invoicePath.equals("")) {
				int lastSlashPosition = invoicePath.lastIndexOf("/");
				String fileName = invoicePath.substring(lastSlashPosition + 1);
				invoicePath = getRequestContextPath() + "\\invoices\\" +fileName;
				List<String> pathList = new ArrayList<String>();
				pathList.add(invoicePath);
				invoiceInfo.setInvoicePathList(pathList);
			} else {
				invoiceInfo.setInvoicePathList(new ArrayList<String>());
			}
		}
	}

	@Override
	public void sendInvoiceMail(String invoicePath) {
		try {
			logger.debug("Will send invoice to subscriber: " + invoicePath);
			int lastSlashPos = invoicePath.lastIndexOf("\\");
			String fileName = invoicePath.substring(lastSlashPos + 1);
			logger.debug("File name is: " + fileName);
			invoiceFileName = fileName;
			renderer.render("/postpaid/invoice/send_mail.xhtml");
			facesMessages.add(Severity.INFO, "Invoice sent to subscriber successfully");
			logAccess(OperationNames.PostpaidSendInvoice, currentCustomer.getFullMsisdn(), postpaidAccount.getCustomerCode(), postpaidAccount.getCustomerId(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not send invoice: " + e.getMessage());
		}
	}

	@Override
	public void retrieveCallView() {
		try {
			if(postpaidAccount == null) retrieveCurrentCustomerDetails();
			if(postpaidAccount.getCustomerId() == null) throw new RuntimeException("Could not find the customer information in BSCS..");
			List<CallView> history = bscsDao.findCallView(postpaidAccount.getCustomerId(), startDate, endDate);
			postpaidAccount.setCallHistory(history);
			facesMessages.add(Severity.INFO, "Call history retrieved successfully..");
			if(postpaidAccount.getCallHistory().size() == 0) facesMessages.add(Severity.WARN, "No records found in the system for this search criteria..");
			logAccess(OperationNames.PostpaidCallView, currentCustomer.getFullMsisdn(), postpaidAccount.getCustomerCode(), postpaidAccount.getCustomerId(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not retrieve call history: " + e.getMessage());
		}
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component PostpaidService..");		
	}
}
