package csv.postpaid.domain;

import java.io.Serializable;

public class ContractSearchCriteria implements Serializable {

	private static final long serialVersionUID = -943598156540766188L;
	
	private String customerCode;
	private String firstName;
	private String lastName;
	private String msisdn;
	private String storageMediumNo;
	
	public ContractSearchCriteria() {
		super();
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
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

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getStorageMediumNo() {
		return storageMediumNo;
	}

	public void setStorageMediumNo(String storageMediumNo) {
		this.storageMediumNo = storageMediumNo;
	}
	
	public boolean validate() {
		if(customerCode == null) customerCode = "";
		if(msisdn == null) msisdn = "";
		if(firstName == null) firstName = "";
		if(lastName == null) lastName = "";
		if(storageMediumNo == null) storageMediumNo = "";
		if(customerCode.length() == 0 && msisdn.length() == 0 && 
			firstName.length() == 0 && lastName.length() == 0 &&
			storageMediumNo.length() == 0)
			throw new RuntimeException("No search criteria found..");
		return true;
	}
	
}
