package csv.crm.complaintmng.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import csv.security.domain.User;

public class CorporateClient implements Serializable {

	private String customerCode;
	private String companyName;
	private String contactNumber;
	private String contactPerson;
	
	private User corporateResponsible;
	
	public CorporateClient() {
		super();
	}
	
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public User getCorporateResponsible() {
		return corporateResponsible;
	}

	public void setCorporateResponsible(User corporateResponsible) {
		this.corporateResponsible = corporateResponsible;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof CorporateClient))
			return false;
		CorporateClient castOther = (CorporateClient) other;
		return new EqualsBuilder().append(customerCode, castOther.customerCode)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-2127062787, -1236554149).append(
				customerCode).toHashCode();
	}
	
}
