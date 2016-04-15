package csv.security.domain;

import java.util.Date;

import csv.gateway.cs.VoucherStatus;
import csv.vouchers.domain.VoucherAudit;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class VoucherLog implements VoucherAudit {

	private Long id;
	private Date createdTime;
	private String operationType = "U";
	private String serialNumber;
	private VoucherStatus oldState;
	private VoucherStatus newState;
	private String ipAddress;
	private String msisdn;
	private String remark;
	private User owningUser;
	
	
	public VoucherLog() {
		super();
	}
	
	public static VoucherLog getVoucherLog(User loggedInUser, String serialNumber, VoucherStatus oldState, VoucherStatus newState, boolean isRefill, String remark) {
    	VoucherLog voucherLog = new VoucherLog();	
    	voucherLog.setOwningUser(loggedInUser);
    	voucherLog.setCreatedTime(new Date());
    	voucherLog.setIpAddress(loggedInUser.getClientIPAddress());
    	voucherLog.setOperationType(isRefill?"R":"U");
    	voucherLog.setSerialNumber(serialNumber);
    	voucherLog.setOldState(oldState);
    	voucherLog.setNewState(newState);
    	voucherLog.setRemark(remark);
		return  voucherLog;
    }
	
	public static VoucherLog getVoucherLog(User loggedInUser, String serialNumber, VoucherStatus oldState, VoucherStatus newState, boolean isRefill, String msisdn, String remark) {
    	VoucherLog voucherLog = getVoucherLog(loggedInUser, serialNumber, oldState, newState, isRefill, remark);
    	voucherLog.setMsisdn(msisdn);
    	return voucherLog;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public VoucherStatus getOldState() {
		return oldState;
	}

	public void setOldState(VoucherStatus oldState) {
		this.oldState = oldState;
	}

	public VoucherStatus getNewState() {
		return newState;
	}

	public void setNewState(VoucherStatus newState) {
		this.newState = newState;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public User getOwningUser() {
		return owningUser;
	}

	public void setOwningUser(User owningUser) {
		this.owningUser = owningUser;
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

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof VoucherLog))
			return false;
		VoucherLog castOther = (VoucherLog) other;
		return new EqualsBuilder().append(createdTime, castOther.createdTime)
				.append(serialNumber, castOther.serialNumber).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-630897289, -1645420703).append(createdTime)
				.append(serialNumber).toHashCode();
	}

	@Override
	public String getStrOldState() {
		if(oldState == null) return null;
		return getOldState().getLabel();
	}

	@Override
	public String getStrNewState() {
		if(newState == null) return null;
		return getNewState().getLabel();
	}

	@Override
	public String getOperator() {
		return getOwningUser().getUsername();
	}

	@Override
	public Long getTransactionId() {
		return getId();
	}

	
}
