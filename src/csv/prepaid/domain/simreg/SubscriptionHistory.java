package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class SubscriptionHistory implements Serializable {

	protected Long requestId;
	protected String msisdn;
	protected RegistrarType registrarType;
	protected String unregisterReason;
	protected Date unregisterDate;
	protected String unregisteredBy;
	protected RegistrationStatus status;
	protected INCMStatus INCMStatus;
	protected ServiceType service;
	protected Long registeredToId;
	
	public SubscriptionHistory() {
		super();
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getUnregisterReason() {
		return unregisterReason;
	}

	public void setUnregisterReason(String unregisterReason) {
		this.unregisterReason = unregisterReason;
	}

	public Date getUnregisterDate() {
		return unregisterDate;
	}

	public void setUnregisterDate(Date unregisterDate) {
		this.unregisterDate = unregisterDate;
	}

	public String getUnregisteredBy() {
		return unregisteredBy;
	}

	public void setUnregisteredBy(String unregisteredBy) {
		this.unregisteredBy = unregisteredBy;
	}

	public RegistrationStatus getStatus() {
		return status;
	}

	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}

	public Long getRegisteredToId() {
		return registeredToId;
	}

	public void setRegisteredToId(Long registeredToId) {
		this.registeredToId = registeredToId;
	}
	
	public RegistrarType getRegistrarType() {
		return registrarType;
	}

	public void setRegistrarType(RegistrarType registrarType) {
		this.registrarType = registrarType;
	}
	
	public INCMStatus getINCMStatus() {
		return INCMStatus;
	}

	public void setINCMStatus(INCMStatus INCMStatus) {
		this.INCMStatus = INCMStatus;
	}
	
	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof SubscriptionHistory))
			return false;
		SubscriptionHistory castOther = (SubscriptionHistory) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).append(
				unregisterDate, castOther.unregisterDate).append(registeredToId,
				castOther.registeredToId).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1411636693, 810000321).append(msisdn)
				.append(unregisterDate).append(registeredToId).toHashCode();
	}
		
}
