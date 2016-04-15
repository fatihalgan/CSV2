package csv.prepaid.netmovel.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import csv.gateway.cs.ServiceClass;

public class VoiceAddOnActivation implements Serializable {

	private static final long serialVersionUID = -8279845152195744383L;
	
	private Long id;
	private String msisdn;
	private float mainAccountBalanceBefore;
	private float mainAccountBalanceAfter;
	private float dedicatedAccountBalanceBefore;
	private float dedicatedAccountBalanceAfter;
	private ServiceClass serviceClassBefore;
	private ServiceClass serviceClassAfter;
	private Date requestTimestamp;
	private Date bundleEndDate;
	private int adjustmentFlag;
	private float adjustmentToMainAccount;
	private float adjustmentToDedicatedAccount;
	private Integer finalCSResult = null;
	private ResultCode resultCode = null;
	private OperationCode operationCode;
	private String status;
	private BundleName bundleName;
	
	public VoiceAddOnActivation() {
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

	public float getMainAccountBalanceBefore() {
		return mainAccountBalanceBefore;
	}

	public void setMainAccountBalanceBefore(float mainAccountBalanceBefore) {
		this.mainAccountBalanceBefore = mainAccountBalanceBefore;
	}

	public float getMainAccountBalanceAfter() {
		return mainAccountBalanceAfter;
	}

	public void setMainAccountBalanceAfter(float mainAccountBalanceAfter) {
		this.mainAccountBalanceAfter = mainAccountBalanceAfter;
	}

	public float getDedicatedAccountBalanceBefore() {
		return dedicatedAccountBalanceBefore;
	}

	public void setDedicatedAccountBalanceBefore(float dedicatedAccountBalanceBefore) {
		this.dedicatedAccountBalanceBefore = dedicatedAccountBalanceBefore;
	}

	public float getDedicatedAccountBalanceAfter() {
		return dedicatedAccountBalanceAfter;
	}

	public void setDedicatedAccountBalanceAfter(float dedicatedAccountBalanceAfter) {
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

	public Date getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(Date requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public Date getBundleEndDate() {
		return bundleEndDate;
	}

	public void setBundleEndDate(Date bundleEndDate) {
		this.bundleEndDate = bundleEndDate;
	}

	public int getAdjustmentFlag() {
		return adjustmentFlag;
	}

	public void setAdjustmentFlag(int adjustmentFlag) {
		this.adjustmentFlag = adjustmentFlag;
	}

	public float getAdjustmentToMainAccount() {
		return adjustmentToMainAccount;
	}

	public void setAdjustmentToMainAccount(float adjustmentToMainAccount) {
		this.adjustmentToMainAccount = adjustmentToMainAccount;
	}

	public float getAdjustmentToDedicatedAccount() {
		return adjustmentToDedicatedAccount;
	}

	public void setAdjustmentToDedicatedAccount(float adjustmentToDedicatedAccount) {
		this.adjustmentToDedicatedAccount = adjustmentToDedicatedAccount;
	}

	public Integer getFinalCSResult() {
		return finalCSResult;
	}

	public void setFinalCSResult(Integer finalCSResult) {
		this.finalCSResult = finalCSResult;
	}

	public ResultCode getResultCode() {
		return resultCode;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public OperationCode getOperationCode() {
		return operationCode;
	}

	public void setOperationCode(OperationCode operationCode) {
		this.operationCode = operationCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BundleName getBundleName() {
		return bundleName;
	}

	public void setBundleName(BundleName bundleName) {
		this.bundleName = bundleName;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof VoiceAddOnActivation))
			return false;
		VoiceAddOnActivation castOther = (VoiceAddOnActivation) other;
		return new EqualsBuilder().append(id, castOther.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1434230707, 1009020967).append(id)
				.toHashCode();
	}
	

}
