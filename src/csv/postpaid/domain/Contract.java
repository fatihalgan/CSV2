package csv.postpaid.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract implements Serializable {

	private static final long serialVersionUID = 5050552133535607017L;
	
	private Long id;
	private String contractCode;
	private String directoryNumber;
	private String contractStatus;
	private Date activationDate;
	private String ratePlan;
	private String customerName;
	private String customerCity;
	private String customerCountry;
	private String customerStreet;
	private String customerStreetNo;
	private String storageMediumNo;
	private String statusReason;
	
	
	
	private Integer customerId;
	
	protected List<DirectoryNumber> directoryNumbers = new ArrayList<DirectoryNumber>();
	protected List<GprsUsage> gprsUsages = new ArrayList<GprsUsage>();
	protected List<StatusChange> statusHistory = new ArrayList<StatusChange>();
	protected List<StorageMediumChange> storageMediumHistory = new ArrayList<StorageMediumChange>();
	protected List<RatePlanChange> ratePlanHistory = new ArrayList<RatePlanChange>();
	
	public Contract() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getDirectoryNumber() {
		return directoryNumber;
	}

	public void setDirectoryNumber(String directoryNumber) {
		this.directoryNumber = directoryNumber;
	}

	public String getContractStatus() {
		return contractStatus;
	}

	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getRatePlan() {
		return ratePlan;
	}

	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}

	public String getStorageMediumNo() {
		return storageMediumNo;
	}

	public void setStorageMediumNo(String storageMediumNo) {
		this.storageMediumNo = storageMediumNo;
	}

	public String getStatusReason() {
		return statusReason;
	}

	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public List<DirectoryNumber> getDirectoryNumbers() {
		return directoryNumbers;
	}

	public void setDirectoryNumbers(List<DirectoryNumber> directoryNumbers) {
		this.directoryNumbers = directoryNumbers;
	}
	
	public List<DirectoryNumber> getDirectoryNumbersAsList() {
		if(getDirectoryNumbers() == null) return new ArrayList<DirectoryNumber>();
		return new ArrayList<DirectoryNumber>(getDirectoryNumbers());
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity = customerCity;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getCustomerStreet() {
		return customerStreet;
	}

	public void setCustomerStreet(String customerStreet) {
		this.customerStreet = customerStreet;
	}

	public String getCustomerStreetNo() {
		return customerStreetNo;
	}

	public void setCustomerStreetNo(String customerStreetNo) {
		this.customerStreetNo = customerStreetNo;
	}
	
	public List<GprsUsage> getGprsUsages() {
		return gprsUsages;
	}

	public void setGprsUsages(List<GprsUsage> gprsUsages) {
		this.gprsUsages = gprsUsages;
	}

	public String getCustomerInfo() {
		String returnVal = "";
		if(customerName != null && customerName.trim().length() > 0) returnVal += customerName;
		if(customerCity != null && customerCity.trim().length() > 0) returnVal = returnVal + " " + customerCity;
		if(customerCountry != null && customerCountry.trim().length() > 0) returnVal = returnVal + " " + customerCountry;
		if(customerStreet != null && customerStreet.trim().length() > 0) returnVal = returnVal + " " + customerStreet;
		if(customerStreetNo != null && customerStreetNo.trim().length() > 0) returnVal = returnVal + " " + customerStreetNo;
		return returnVal;
	}

	public List<StatusChange> getStatusHistory() {
		return statusHistory;
	}

	public void setStatusHistory(List<StatusChange> statusHistory) {
		this.statusHistory = statusHistory;
	}

	public List<StorageMediumChange> getStorageMediumHistory() {
		return storageMediumHistory;
	}

	public void setStorageMediumHistory(
			List<StorageMediumChange> storageMediumHistory) {
		this.storageMediumHistory = storageMediumHistory;
	}

	public List<RatePlanChange> getRatePlanHistory() {
		return ratePlanHistory;
	}

	public void setRatePlanHistory(List<RatePlanChange> ratePlanHistory) {
		this.ratePlanHistory = ratePlanHistory;
	}
}
