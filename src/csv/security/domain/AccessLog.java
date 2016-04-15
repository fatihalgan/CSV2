package csv.security.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class AccessLog implements Serializable {

	private Long id;
	private User owningUser;
	private Operation owningOperation;
	private String ipAddress;
	private Date date;
	private String msisdn;
	private String contractId;
	private String customerId;
	private String remark;
	
	public AccessLog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwningUser() {
		return owningUser;
	}

	public void setOwningUser(User owningUser) {
		this.owningUser = owningUser;
	}

	public Operation getOwningOperation() {
		return owningOperation;
	}

	public void setOwningOperation(Operation owningOperation) {
		this.owningOperation = owningOperation;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AccessLog))
			return false;
		AccessLog castOther = (AccessLog) other;
		return new EqualsBuilder().append(owningUser, castOther.owningUser)
				.append(owningOperation, castOther.owningOperation).append(
						date, castOther.date).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-489920899, -100626207).append(owningUser)
				.append(owningOperation).append(date).toHashCode();
	}
	
}
