package csv.roaming.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

/**
 * OperatorAddress generated by hbm2java
 */
public class OperatorAddress implements java.io.Serializable {

	private Long operatorAddressId;
	private OperatorCountry operatorCountry;
	private String address;
	private String city;
	private boolean priority;

	public OperatorAddress() {
	}

	public OperatorAddress(Long operatorAddressId,
			OperatorCountry operatorCountry, String address, String city,
			boolean priority) {
		this.operatorAddressId = operatorAddressId;
		this.operatorCountry = operatorCountry;
		this.address = address;
		this.city = city;
		this.priority = priority;
	}

	public Long getOperatorAddressId() {
		return this.operatorAddressId;
	}

	public void setOperatorAddressId(Long operatorAddressId) {
		this.operatorAddressId = operatorAddressId;
	}

	public OperatorCountry getOperatorCountry() {
		return operatorCountry;
	}

	public void setOperatorCountry(OperatorCountry operatorCountry) {
		this.operatorCountry = operatorCountry;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isPriority() {
		return this.priority;
	}

	public void setPriority(boolean priority) {
		this.priority = priority;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof OperatorAddress))
			return false;
		OperatorAddress castOther = (OperatorAddress) other;
		return new EqualsBuilder().append(operatorCountry,
				castOther.operatorCountry).append(address, castOther.address)
				.append(city, castOther.city).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-408042607, 1911440053).append(
				operatorCountry).append(address).append(city).toHashCode();
	}

}