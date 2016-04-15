package csv.crm.complaintmng.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class PersonalComplaintOwner extends ComplaintOwner {

	public PersonalComplaintOwner() {
		super();
	}
	
	public PersonalComplaintOwner(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public PersonalComplaintOwner(String msisdn, String contactNumber) {
		this.msisdn = msisdn;
		this.contactNumber = contactNumber;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PersonalComplaintOwner))
			return false;
		PersonalComplaintOwner castOther = (PersonalComplaintOwner) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1120014397, 1030173039).append(msisdn)
				.toHashCode();
	}

	@Override
	public String getCustomerIdentifier() {
		return getMsisdn();
	}

	@Override
	public String getOwnerType() {
		return "Personal";
	}
}
