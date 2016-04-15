package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;

public class StorageMediumChange implements Serializable {

	private static final long serialVersionUID = -3570659605215484769L;
	
	private Long contractId;
	private String status;
	private String pendingStatus;
	private String storageMediumNo;
	private String portNo;
	private Date validFrom;
	private Date enteredOn;
	private String enteredBy;
	
	public StorageMediumChange() {
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

	public String getStorageMediumNo() {
		return storageMediumNo;
	}

	public void setStorageMediumNo(String storageMediumNo) {
		this.storageMediumNo = storageMediumNo;
	}

	public String getPortNo() {
		return portNo;
	}

	public void setPortNo(String portNo) {
		this.portNo = portNo;
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
