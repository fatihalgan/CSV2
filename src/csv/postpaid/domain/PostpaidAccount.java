package csv.postpaid.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PostpaidAccount implements IPostpaidAccount, Serializable {

	private static final long serialVersionUID = -7106637172791652708L;
	
	protected String title;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String city;
	protected String country;
	protected Date dateofBirth;
	protected String street;
	protected String streetNo;
	protected String zip;
	protected String line1;
	protected String line2;
	protected Integer customerId;
	protected String csType;
	protected Date activationDate;
	protected Date sentDate;
	protected String prgCode;
	protected String prgName;
	protected String csReason;
	protected Float currentBalance;
	protected Float totalOpenAmount;
	protected Float previousBalance;
	protected Date lbcDate;
	protected Float unbilledAmount;
	protected String customerCode;
	
	
	protected List<Contract> contracts = new ArrayList<Contract>();
	protected PaymentArrangement paymentArrangement = null;
	protected BillingInfo billingInfo = null;
	
	protected List<CallView> callHistory = new ArrayList<CallView>();
	
	protected List<Document> documents = new ArrayList<Document>();
	protected List<Payment> payments = new ArrayList<Payment>();
	protected List<BillingAccount> billingAccounts = new ArrayList<BillingAccount>();
	protected List<PromotionPackage> promotionPackages = new ArrayList<PromotionPackage>();
	protected List<Memo> memos = new ArrayList<Memo>();
		
	public PostpaidAccount() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCsType() {
		return csType;
	}

	public void setCsType(String csType) {
		this.csType = csType;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getPrgCode() {
		return prgCode;
	}

	public void setPrgCode(String prgCode) {
		this.prgCode = prgCode;
	}

	public String getPrgName() {
		return prgName;
	}

	public void setPrgName(String prgName) {
		this.prgName = prgName;
	}

	public String getCsReason() {
		return csReason;
	}

	public void setCsReason(String csReason) {
		this.csReason = csReason;
	}

	public Float getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Float currentBalance) {
		this.currentBalance = currentBalance;
	}

	public Date getLbcDate() {
		return lbcDate;
	}

	public void setLbcDate(Date lbcDate) {
		this.lbcDate = lbcDate;
	}
	
	public List<Contract> getContractsAsList() {
		if(getContracts() == null) return new ArrayList<Contract>();
		return new ArrayList<Contract>(getContracts());
	}

	public Float getTotalOpenAmount() {
		return totalOpenAmount;
	}

	public void setTotalOpenAmount(Float totalOpenAmount) {
		this.totalOpenAmount = totalOpenAmount;
	}

	public Float getPreviousBalance() {
		return previousBalance;
	}

	public void setPreviousBalance(Float previousBalance) {
		this.previousBalance = previousBalance;
	}

	public Float getUnbilledAmount() {
		return unbilledAmount;
	}

	public void setUnbilledAmount(Float unbilledAmount) {
		this.unbilledAmount = unbilledAmount;
	}

	public PaymentArrangement getPaymentArrangement() {
		return paymentArrangement;
	}

	public void setPaymentArrangement(PaymentArrangement paymentArrangement) {
		this.paymentArrangement = paymentArrangement;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}

	public List<CallView> getCallHistory() {
		return callHistory;
	}

	public void setCallHistory(List<CallView> callHistory) {
		this.callHistory = callHistory;
	}

	@Override
	public String getName() {
		return getFullName();
	}

	@Override
	public boolean isLargeAccount() {
		return false;
	}

	@Override
	public String getFullAddress() {
		String retVal = "";
		if(line1 != null) retVal = retVal +line1;
		if(line2 != null) retVal = retVal + " " + line2;
		if(streetNo != null) retVal = retVal + " " + streetNo;
		if(street != null) retVal = retVal + " " + street;
		if(city != null) retVal = retVal + " " + city;
		if(country != null) retVal = retVal + " " + country;
		if(zip != null) retVal = retVal + " " + zip;
		return retVal;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public List<BillingAccount> getBillingAccounts() {
		return billingAccounts;
	}

	public void setBillingAccounts(List<BillingAccount> billingAccounts) {
		this.billingAccounts = billingAccounts;
	}

	public List<PromotionPackage> getPromotionPackages() {
		return promotionPackages;
	}

	public void setPromotionPackages(List<PromotionPackage> promotionPackages) {
		this.promotionPackages = promotionPackages;
	}

	public List<Memo> getMemos() {
		return memos;
	}

	public void setMemos(List<Memo> memos) {
		this.memos = memos;
	}
	
}
