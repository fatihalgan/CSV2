package csv.crm.complaintmng.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import csv.common.domain.CustomerIdentifierType;

public class CorporateComplaintOwner extends ComplaintOwner {
	
	private CorporateClient company = new CorporateClient();
	
	public CorporateComplaintOwner() {
		super();
	}
	
	public CorporateComplaintOwner(String msisdn) {
		super();
		this.msisdn = msisdn;
	}
	
	public CorporateComplaintOwner(CorporateClient company) {
		this.company = company;
	}

	public CorporateClient getCompany() {
		return company;
	}

	public void setCompany(CorporateClient company) {
		this.company = company;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof CorporateComplaintOwner))
			return false;
		CorporateComplaintOwner castOther = (CorporateComplaintOwner) other;
		return new EqualsBuilder().append(company, castOther.company)
			.append(msisdn, castOther.msisdn).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1205526123, -1546179329)
				.append(company).append(msisdn).toHashCode();
	}

	@Override
	public String getOwnerType() {
		return "Corporate";
	}

	@Override
	public String getCustomerIdentifier() {
		if(msisdn != null) return msisdn;
		else return getCompany().getCustomerCode();
	}
}
