package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Operator generated by hbm2java
 */
public class Operator implements java.io.Serializable {

	private Long operatorId;
	private Mccmnc mccmnc;
	private Tapcode tapcode;
	private String operatorName;
	private String networkName;
	private String displayName;
	private String networkCode;
	private String operatorCode;
	private String ccnc;
	private String tadig;

	private Set<OperatorCountry> operatorCountries = new HashSet<OperatorCountry>(
			0);

	private Set<OperatorPrefix> operatorPrefixes = new HashSet<OperatorPrefix>(
			0);

	public Operator() {
	}

	public Operator(Long operatorId, String operatorName) {
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}

	public Operator(Long operatorId, Mccmnc mccmnc, Tapcode tapcode,
			String operatorName, String networkName, String displayName,
			String networkCode, String operatorCode,
			Set<OperatorCountry> operatorCountries,
			Set<OperatorPrefix> operatorPrefixes) {
		this.operatorId = operatorId;
		this.mccmnc = mccmnc;
		this.tapcode = tapcode;
		this.operatorName = operatorName;
		this.networkName = networkName;
		this.displayName = displayName;
		this.networkCode = networkCode;
		this.operatorCode = operatorCode;
		this.operatorCountries = operatorCountries;
		this.operatorPrefixes = operatorPrefixes;
	}

	public Long getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public Mccmnc getMccmnc() {
		return this.mccmnc;
	}

	public void setMccmnc(Mccmnc mccmnc) {
		this.mccmnc = mccmnc;
	}

	public Tapcode getTapcode() {
		return this.tapcode;
	}

	public void setTapcode(Tapcode tapcode) {
		this.tapcode = tapcode;
	}

	public String getOperatorName() {
		return this.operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getNetworkName() {
		return this.networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getNetworkCode() {
		return this.networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getOperatorCode() {
		return this.operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public Set<OperatorCountry> getOperatorCountries() {
		return operatorCountries;
	}

	public void setOperatorCountries(Set<OperatorCountry> operatorCountries) {
		this.operatorCountries = operatorCountries;
	}

	public String getCcnc() {
		return ccnc;
	}

	public void setCcnc(String ccnc) {
		this.ccnc = ccnc;
	}

	public String getTadig() {
		return tadig;
	}

	public void setTadig(String tadig) {
		this.tadig = tadig;
	}

	public Set<OperatorPrefix> getOperatorPrefixes() {
		return operatorPrefixes;
	}

	public void setOperatorPrefixes(Set<OperatorPrefix> operatorPrefixes) {
		this.operatorPrefixes = operatorPrefixes;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Operator))
			return false;
		Operator castOther = (Operator) other;
		return new EqualsBuilder().append(operatorName, castOther.operatorName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1326325669, -1568164075).append(
				operatorName).toHashCode();
	}

}
