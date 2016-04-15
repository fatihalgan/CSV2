package csv.common.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class TomalaBlacklist implements Serializable {

	private String msisdn;
	private Long customerId;
	private String custCode;
	private String userName;
	private Date date;
	private String reason;
	
	public TomalaBlacklist() {
		super();
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof TomalaBlacklist))
			return false;
		TomalaBlacklist castOther = (TomalaBlacklist) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1214027099, 1738641175).append(msisdn)
				.toHashCode();
	}
	
	
}
