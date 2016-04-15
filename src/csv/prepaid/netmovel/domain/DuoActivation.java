package csv.prepaid.netmovel.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import csv.gateway.cs.ServiceClass;

public class DuoActivation implements Serializable {

	private Long id;
	private String msisdn;
	private ServiceClass serviceClassBefore;
	private ServiceClass serviceClassAfter;
	private Date requestTimestamp;
	private BundleName contractName;
	private String status;
	private Date activationDate;
	private Date deactivationDate;
	private OperationCode operationCode;
	private ResultCode resultCode;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public ServiceClass getServiceClassBefore() {
		return serviceClassBefore;
	}
	
	public void setServiceClassBefore(ServiceClass serviceClassBefore) {
		this.serviceClassBefore = serviceClassBefore;
	}
	
	public ServiceClass getServiceClassAfter() {
		return serviceClassAfter;
	}
	
	public void setServiceClassAfter(ServiceClass serviceClassAfter) {
		this.serviceClassAfter = serviceClassAfter;
	}
	
	public Date getRequestTimestamp() {
		return requestTimestamp;
	}
	
	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}
	
	public BundleName getContractName() {
		return contractName;
	}
	
	public void setContractName(BundleName contractName) {
		this.contractName = contractName;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public OperationCode getOperationCode() {
		return operationCode;
	}
	
	public void setOperationCode(OperationCode operationCode) {
		this.operationCode = operationCode;
	}
	
	public ResultCode getResultCode() {
		return resultCode;
	}
	
	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}
	
	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Date getDeactivationDate() {
		return deactivationDate;
	}

	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof DuoActivation))
			return false;
		DuoActivation castOther = (DuoActivation) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).append(
				requestTimestamp, castOther.requestTimestamp).append(
				operationCode, castOther.operationCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(msisdn).append(requestTimestamp)
				.append(operationCode).toHashCode();
	}
	
}
