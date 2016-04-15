package csv.vouchers.domain;

import java.util.Date;

import csv.gateway.cs.VoucherStatus;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class VoucherDBAudit implements VoucherAudit {

	private Long transactionId;
	private Date createdTime;
	private String serialNumber;
	private String strOldState;
	private String strNewState;
	private String msisdn;
	private String operator;
	
	public VoucherDBAudit() {
		super();
	}

	public Long getTransactionId() {
		return transactionId;
	}
	
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getStrOldState() {
		return strOldState;
	}

	public void setStrOldState(String strOldState) {
		this.strOldState = strOldState;
	}

	public String getStrNewState() {
		return strNewState;
	}

	public void setStrNewState(String strNewState) {
		this.strNewState = strNewState;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof VoucherDBAudit))
			return false;
		VoucherDBAudit castOther = (VoucherDBAudit) other;
		return new EqualsBuilder().append(createdTime, castOther.createdTime)
				.append(serialNumber, castOther.serialNumber).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1227388791, 1803524479).append(createdTime)
				.append(serialNumber).toHashCode();
	}

	@Override
	public String getOperationType() {
		return "U";
	}

	@Override
	public String getRemark() {
		return null;
	}
	
	
}
