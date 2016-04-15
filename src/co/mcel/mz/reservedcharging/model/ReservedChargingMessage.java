package co.mcel.mz.reservedcharging.model;

import java.io.Serializable;
import java.util.Date;


import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ReservedChargingMessage implements Serializable {

	private static final long serialVersionUID = 2984521688968064673L;
	
	private Long id;
	private String appName;
	private String msisdn;
	private String message;
	private String responseCode;
	private Date timestamp;
	
	public ReservedChargingMessage() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ReservedChargingMessage))
			return false;
		ReservedChargingMessage castOther = (ReservedChargingMessage) other;
		return new EqualsBuilder().append(appName, castOther.appName).append(
				msisdn, castOther.msisdn).append(message, castOther.message)
				.append(timestamp, castOther.timestamp).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(2096874849, 2085483877).append(appName)
				.append(msisdn).append(message).append(timestamp).toHashCode();
	}
}
