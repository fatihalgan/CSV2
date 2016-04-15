package csv.prepaid.netmovel.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import csv.gateway.cs.ServiceClass;

public class BundleActivation implements Serializable {

	private Long id;
	private String msisdn;
	private Float mainAccountBalanceBefore;
	private Float mainAccountBalanceAfter;
	private Float dedicatedAccountBalanceBefore;
	private Float dedicatedAccountBalanceAfter;
	private ServiceClass serviceClassBefore;
	private ServiceClass serviceClassAfter;
	private BundleName bundleName;
	private Date requestTimestamp;
	private Date bundleExpirationDate;
	private String status;
	private OperationCode operationCode;
	private ResultCode resultCode;
	
	public BundleActivation() {
		super();
	}

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

	public Float getMainAccountBalanceBefore() {
		return mainAccountBalanceBefore;
	}

	public void setMainAccountBalanceBefore(Float mainAccountBalanceBefore) {
		this.mainAccountBalanceBefore = mainAccountBalanceBefore;
	}

	public Float getMainAccountBalanceAfter() {
		return mainAccountBalanceAfter;
	}

	public void setMainAccountBalanceAfter(Float mainAccountBalanceAfter) {
		this.mainAccountBalanceAfter = mainAccountBalanceAfter;
	}

	public Float getDedicatedAccountBalanceBefore() {
		return dedicatedAccountBalanceBefore;
	}

	public void setDedicatedAccountBalanceBefore(Float dedicatedAccountBalanceBefore) {
		this.dedicatedAccountBalanceBefore = dedicatedAccountBalanceBefore;
	}

	public Float getDedicatedAccountBalanceAfter() {
		return dedicatedAccountBalanceAfter;
	}

	public void setDedicatedAccountBalanceAfter(Float dedicatedAccountBalanceAfter) {
		this.dedicatedAccountBalanceAfter = dedicatedAccountBalanceAfter;
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

	public BundleName getBundleName() {
		return bundleName;
	}

	public void setBundleName(BundleName bundleName) {
		this.bundleName = bundleName;
	}

	public Date getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public Date getBundleExpirationDate() {
		return bundleExpirationDate;
	}

	public void setBundleExpirationDate(Date bundleExpirationDate) {
		this.bundleExpirationDate = bundleExpirationDate;
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

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof BundleActivation))
			return false;
		BundleActivation castOther = (BundleActivation) other;
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
