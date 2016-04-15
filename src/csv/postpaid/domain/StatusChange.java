package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;

public class StatusChange implements Serializable {

	private static final long serialVersionUID = -2904633689009583094L;
	
	private Long contractId;
	private String status;
	private String pendingStatus;
	private String reason;
	private Date validFrom;
	private Date enteredOn;
	private String enteredBy;
	
	public StatusChange() {
		super();
	}
	
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPendingStatus() {
		return pendingStatus;
	}

	public void setPendingStatus(String pendingStatus) {
		this.pendingStatus = pendingStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getEnteredOn() {
		return enteredOn;
	}

	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	
	
}
