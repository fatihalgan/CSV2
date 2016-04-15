package csv.roaming.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

/**
 * CountryNationalDialingCode generated by hbm2java
 */
public class CountryNationalDialingCode implements java.io.Serializable {

	private Long countryNationalDialCodeId;
	private Country country;
	private String dialingCode;

	public CountryNationalDialingCode() {
	}

	public CountryNationalDialingCode(Long countryNationalDialCodeId,
			Country country, String dialingCode) {
		this.countryNationalDialCodeId = countryNationalDialCodeId;
		this.country = country;
		this.dialingCode = dialingCode;
	}

	public Long getCountryNationalDialCodeId() {
		return this.countryNationalDialCodeId;
	}

	public void setCountryNationalDialCodeId(Long countryNationalDialCodeId) {
		this.countryNationalDialCodeId = countryNationalDialCodeId;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getDialingCode() {
		return this.dialingCode;
	}

	public void setDialingCode(String dialingCode) {
		this.dialingCode = dialingCode;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof CountryNationalDialingCode))
			return false;
		CountryNationalDialingCode castOther = (CountryNationalDialingCode) other;
		return new EqualsBuilder().append(country, castOther.country).append(
				dialingCode, castOther.dialingCode).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(968614819, -1131000301).append(country)
				.append(dialingCode).toHashCode();
	}

}
