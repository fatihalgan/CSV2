package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Country generated by hbm2java
 */
public class Country implements java.io.Serializable {

	private Long countryId;
	private Continent continent;
	private String countryName;
	private String utc;
	private Boolean daylightSave;
	private String utcEnd;
	private Integer utcTimeDiff;
	private Integer utcEndTimeDiff;

	private Set<CountryRegion> countryRegions = new HashSet<CountryRegion>(0);
	private Set<OperatorCountry> operatorCountries = new HashSet<OperatorCountry>(
			0);
	private Set<CountryNationalDialingCode> countryNationalDialingCodes = new HashSet<CountryNationalDialingCode>(
			0);
	private Set<CountryIntDialingCode> countryIntDialingCodes = new HashSet<CountryIntDialingCode>(
			0);

	public Country() {
	}

	public Country(Long countryId, Continent continent, String countryName) {
		this.countryId = countryId;
		this.continent = continent;
		this.countryName = countryName;
	}

	public Country(Long countryId, Continent continent, String countryName,
			String utc, Boolean daylightSave, String utcEnd,
			Set<CountryRegion> countryRegions,
			Set<CountryNationalDialingCode> countryNationalDialingCodes,
			Set<CountryIntDialingCode> countryIntDialingCodes) {
		this.countryId = countryId;
		this.continent = continent;
		this.countryName = countryName;
		this.utc = utc;
		this.daylightSave = daylightSave;
		this.utcEnd = utcEnd;
		this.countryRegions = countryRegions;
		this.countryNationalDialingCodes = countryNationalDialingCodes;
		this.countryIntDialingCodes = countryIntDialingCodes;
	}

	public Long getCountryId() {
		return this.countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public Continent getContinent() {
		return this.continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getUtc() {
		return this.utc;
	}

	public void setUtc(String utc) {
		this.utc = utc;
	}

	public Boolean getDaylightSave() {
		return this.daylightSave;
	}

	public void setDaylightSave(Boolean daylightSave) {
		this.daylightSave = daylightSave;
	}

	public String getUtcEnd() {
		return this.utcEnd;
	}

	public void setUtcEnd(String utcEnd) {
		this.utcEnd = utcEnd;
	}

	public Set<CountryRegion> getCountryRegions() {
		return this.countryRegions;
	}

	public void setCountryRegions(Set<CountryRegion> countryRegions) {
		this.countryRegions = countryRegions;
	}

	public Set<CountryNationalDialingCode> getCountryNationalDialingCodes() {
		return this.countryNationalDialingCodes;
	}

	public void setCountryNationalDialingCodes(
			Set<CountryNationalDialingCode> countryNationalDialingCodes) {
		this.countryNationalDialingCodes = countryNationalDialingCodes;
	}

	public Set<CountryIntDialingCode> getCountryIntDialingCodes() {
		return this.countryIntDialingCodes;
	}

	public void setCountryIntDialingCodes(
			Set<CountryIntDialingCode> countryIntDialingCodes) {
		this.countryIntDialingCodes = countryIntDialingCodes;
	}

	public Set<OperatorCountry> getOperatorCountries() {
		return operatorCountries;
	}

	public void setOperatorCountries(Set<OperatorCountry> operatorCountries) {
		this.operatorCountries = operatorCountries;
	}

	public Integer getUtcTimeDiff() {
		return utcTimeDiff;
	}

	public void setUtcTimeDiff(Integer utcTimeDiff) {
		this.utcTimeDiff = utcTimeDiff;
	}

	public Integer getUtcEndTimeDiff() {
		return utcEndTimeDiff;
	}

	public void setUtcEndTimeDiff(Integer utcEndTimeDiff) {
		this.utcEndTimeDiff = utcEndTimeDiff;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Country))
			return false;
		Country castOther = (Country) other;
		return new EqualsBuilder().append(countryName,
				castOther.getCountryName()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1068110653, -1983429095)
				.append(countryName).toHashCode();
	}

}
