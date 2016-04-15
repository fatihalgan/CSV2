package csv.postpaid.service;

import java.util.Date;

import javax.ejb.Local;

import csv.postpaid.domain.InvoiceInfo;
import csv.postpaid.domain.PostpaidAccount;

@Local
public interface IPostpaidService {
	public void initialize();
	public void retrieveCurrentCustomerDetails();
	public void retrieveInvoiceInfoByInvoiceNo();
	public void retrieveInvoiceInfoByCustomerDetails();
	public PostpaidAccount getPostpaidAccount();
	public void setPostpaidAccount(PostpaidAccount postpaidAccount);
	public InvoiceInfo getInvoiceInfo();
	public void setInvoiceNo(InvoiceInfo invoiceInfo);
	public void sendInvoiceMail(String invoicePath);
	public String getInvoiceFileName();
	public void setInvoiceFileName(String invoiceFileName);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public void retrieveCallView();
	public void remove();
}
