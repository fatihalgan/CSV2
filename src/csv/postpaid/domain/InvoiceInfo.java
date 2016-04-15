package csv.postpaid.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class InvoiceInfo implements Serializable {

	private static final long serialVersionUID = -5441521369617571243L;
	
	private String invoiceNo;
	private List<String> invoicePathList = new ArrayList<String>();
	private String period;
	
	public InvoiceInfo() {
		super();
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}
	
	public InvoiceInfo(String period) {
		this.period = period;
	}
	
	public List<String> getInvoicePathList() {
		return invoicePathList;
	}

	public void setInvoicePathList(List<String> invoicePathList) {
		this.invoicePathList = invoicePathList;
	}

	public InvoiceInfo(String invoiceNo, String invoicePath) {
		this.invoiceNo = invoiceNo;
		this.invoicePathList.add(processInvoicePath(invoicePath));
	}
	
	public InvoiceInfo(String invoiceNo, String invoicePath, String period) {
		this.invoiceNo = invoiceNo;
		this.invoicePathList.add(processInvoicePath(invoicePath));
		this.period = period;
	}
	
	public InvoiceInfo(String invoiceNo, List<String> invoicePathList, String period) {
		this.invoiceNo = invoiceNo;
		this.invoicePathList = invoicePathList;
		this.period = period;
	}
	
	public void addInvoicePath(String invoicePath) {
		this.invoicePathList.add(processInvoicePath(invoicePath));
	}
		
	private String processInvoicePath(String path) {
		return "/data2/bscsprod" + path.substring(path.indexOf("/WORK"), path.length());
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	public boolean isPeriodAfterFebruary2011() {
		String year = period.substring(0, period.indexOf("/"));
		String month = period.substring(period.indexOf("/") + 1);
		if(Integer.parseInt(year) < 2011) return false;
		if(Integer.parseInt(month) < 03) return false;
		return true;
	}
	
}
