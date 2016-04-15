package csv.postpaid.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class LargeAccount implements IPostpaidAccount, Serializable {

	private static final long serialVersionUID = 8609287008124793349L;
	
	private String customerCode;
	private String name;
	private String status;
	private String contractResponsible;
	private String paymentResponsible;
	private String streetNo;
	private String street;
	private String city;
	
	public LargeAccount() {
		super();
	}
	
	public String getCustomerCode() {
		return customerCode;
	}
	
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getContractResponsible() {
		return contractResponsible;
	}
	
	public void setContractResponsible(String contractResponsible) {
		this.contractResponsible = contractResponsible;
	}
	
	public String getPaymentResponsible() {
		return paymentResponsible;
	}
	
	public void setPaymentResponsible(String paymentResponsible) {
		this.paymentResponsible = paymentResponsible;
	}
	
	public String getFullAddress() {
		String retVal = "";
		if(streetNo != null) retVal = retVal + streetNo;
		if(street != null) retVal = retVal + " " + street;
		if(city != null) retVal = retVal + " " + city;
		return retVal;
	}
	
	public String getStreetNo() {
		return streetNo;
	}
	
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof LargeAccount))
			return false;
		LargeAccount castOther = (LargeAccount) other;
		return new EqualsBuilder().append(customerCode, castOther.customerCode)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-332817585, 200913073).append(customerCode)
				.toHashCode();
	}

	@Override
	public boolean isLargeAccount() {
		return true;
	}
	
}
