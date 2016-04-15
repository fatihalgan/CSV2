package com.bridge.pm.bpm;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import com.bridge.pm.domain.SIMMigrationType;

public abstract class SIMMigrationRequestState implements Serializable {

	protected Long requestId;
	protected String msisdn;
	protected String imsi;
	protected String sim;
	protected String cardProfile;
	
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public SIMMigrationRequestState() {
		super();
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}
	
	public String getCardProfile() {
		return cardProfile;
	}

	public void setCardProfile(String cardProfile) {
		this.cardProfile = cardProfile;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof SIMMigrationRequestState))
			return false;
		SIMMigrationRequestState castOther = (SIMMigrationRequestState) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn)
				.append(imsi, castOther.imsi).append(sim, castOther.sim)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1269853391, 1838491817).append(msisdn)
				.append(imsi).append(sim).toHashCode();
	}
	
	public abstract SIMMigrationType getMigrationType();
	
}
