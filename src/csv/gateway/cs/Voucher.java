package csv.gateway.cs;

import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;

public class Voucher implements Serializable {

	public static final String prefix = "25882";
	
	private String serialNumber;
	private String agent;
	private String batchId;
	private Date timestamp;
	private String currency;
	private String operatorId;
	private String voucherValue;
	private String voucherGroup;
	private VoucherStatus status;
	private String subscriberNumber;
	private Date expiryDate;
	private String activationCode;
	
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getAgent() {
		return agent;
	}
	
	public void setAgent(String agent) {
		this.agent = agent;
	}
	
	public String getBatchId() {
		return batchId;
	}
	
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String getOperatorId() {
		return operatorId;
	}
	
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	
	public String getVoucherValue() {
		return voucherValue;
	}
	
	public void setVoucherValue(String voucherValue) {
		this.voucherValue = voucherValue;
	}
	
	public String getVoucherGroup() {
		return voucherGroup;
	}
	
	public void setVoucherGroup(String voucherGroup) {
		this.voucherGroup = voucherGroup;
	}
	
	public VoucherStatus getStatus() {
		return status;
	}

	public void setStatus(VoucherStatus status) {
		this.status = status;
	}

	public String getSubscriberNumber() {
		return subscriberNumber;
	}
	
	public void setSubscriberNumber(String subscriberNumber) {
		this.subscriberNumber = subscriberNumber;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getActivationCode() {
		return activationCode;
	}
	
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	
	public boolean canChangeState(VoucherStatus newStatus, ResourceBundle messages) {
		if(this.status == null)
			throw new RuntimeException(messages.getString("errorNoVoucherSelected"));
		if(!(this.status.equals(VoucherStatus.Available) || this.status.equals(VoucherStatus.Pending))) {
			throw new RuntimeException(messages.getString("errorVoucherNotAvailable"));
		}
		if(this.status.equals(newStatus)) {
			throw new RuntimeException(messages.getString("errorVoucherStatusSame"));
		}
		if(this.status.equals(VoucherStatus.Pending) && !newStatus.equals(VoucherStatus.Available)) {
			throw new RuntimeException(messages.getString("errorVoucherPending"));
		}
		return true;
	}
	
	public boolean canRefill() {
		if(this.status == null) return false;
		if(this.status.equals(VoucherStatus.Available) || this.status.equals(VoucherStatus.Pending)) return true;
		return false;
	}
	
}
