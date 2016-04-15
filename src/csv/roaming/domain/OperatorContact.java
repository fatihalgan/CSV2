package csv.roaming.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

/**
 * OperatorContact generated by hbm2java
 */
public class OperatorContact implements java.io.Serializable {

	private Long operatorContactId;
	private OperatorCountry operatorCountry;
	private ContactTypes contactTypes;
	private String contactName;
	private String contactSurname;
	private String phone;
	private String fax;
	private String gsm;
	private String email;
	private String contactTitle;

	public OperatorContact() {
	}

	public OperatorContact(Long operatorContactId,
			OperatorCountry operatorCountry) {
		this.operatorContactId = operatorContactId;
		this.operatorCountry = operatorCountry;
	}

	public OperatorContact(Long operatorContactId,
			OperatorCountry operatorCountry, ContactTypes contactTypes,
			String contactName, String contactSurname, String phone,
			String fax, String gsm, String email, String contactTitle) {
		this.operatorContactId = operatorContactId;
		this.operatorCountry = operatorCountry;
		this.contactTypes = contactTypes;
		this.contactName = contactName;
		this.contactSurname = contactSurname;
		this.phone = phone;
		this.fax = fax;
		this.gsm = gsm;
		this.email = email;
		this.contactTitle = contactTitle;
	}

	public Long getOperatorContactId() {
		return this.operatorContactId;
	}

	public void setOperatorContactId(Long operatorContactId) {
		this.operatorContactId = operatorContactId;
	}

	public OperatorCountry getOperatorCountry() {
		return operatorCountry;
	}

	public void setOperatorCountry(OperatorCountry operatorCountry) {
		this.operatorCountry = operatorCountry;
	}

	public ContactTypes getContactTypes() {
		return this.contactTypes;
	}

	public void setContactTypes(ContactTypes contactTypes) {
		this.contactTypes = contactTypes;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactSurname() {
		return this.contactSurname;
	}

	public void setContactSurname(String contactSurname) {
		this.contactSurname = contactSurname;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGsm() {
		return this.gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactTitle() {
		return this.contactTitle;
	}

	public void setContactTitle(String contactTitle) {
		this.contactTitle = contactTitle;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof OperatorContact))
			return false;
		OperatorContact castOther = (OperatorContact) other;
		return new EqualsBuilder().append(operatorCountry,
				castOther.operatorCountry).append(contactTypes,
				castOther.contactTypes).append(contactName,
				castOther.contactName).append(contactSurname,
				castOther.contactSurname).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(337591765, 381662399)
				.append(operatorCountry).append(contactTypes).append(
						contactName).append(contactSurname).toHashCode();
	}

}
