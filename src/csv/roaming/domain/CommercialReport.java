package csv.roaming.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class CommercialReport implements java.io.Serializable {

	private String continentName;
	private String countryName;
	private String operatorName;
	private String networkCode;
	private String operatorCode;
	private String ccnc;
	private Integer utcTimeDiff;
	private Integer utcEndTimeDiff;
	private String gsmStatus;
	private String gprsStatus;
	private String threegStatus;
	private String camel12Status;
	private String camel3Status;
	private String mmsStatus;
	private String frequencies;

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getNetworkCode() {
		return networkCode;
	}

	public void setNetworkCode(String networkCode) {
		this.networkCode = networkCode;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getCcnc() {
		return ccnc;
	}

	public void setCcnc(String ccnc) {
		this.ccnc = ccnc;
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

	public String getGsmStatus() {
		return gsmStatus;
	}

	public void setGsmStatus(String gsmStatus) {
		this.gsmStatus = gsmStatus;
	}

	public String getGprsStatus() {
		return gprsStatus;
	}

	public void setGprsStatus(String gprsStatus) {
		this.gprsStatus = gprsStatus;
	}

	public String getThreegStatus() {
		return threegStatus;
	}

	public void setThreegStatus(String threegStatus) {
		this.threegStatus = threegStatus;
	}

	public String getCamel12Status() {
		return camel12Status;
	}

	public void setCamel12Status(String camel12Status) {
		this.camel12Status = camel12Status;
	}

	public String getCamel3Status() {
		return camel3Status;
	}

	public void setCamel3Status(String camel3Status) {
		this.camel3Status = camel3Status;
	}

	public String getMmsStatus() {
		return mmsStatus;
	}

	public void setMmsStatus(String mmsStatus) {
		this.mmsStatus = mmsStatus;
	}

	public String getFrequencies() {
		return frequencies;
	}

	public void setFrequencies(String frequencies) {
		this.frequencies = frequencies;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof CommercialReport))
			return false;
		CommercialReport castOther = (CommercialReport) other;
		return new EqualsBuilder().append(continentName,
				castOther.continentName).append(countryName,
				castOther.countryName).append(operatorName,
				castOther.operatorName).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1878407713, -1201080013).append(
				continentName).append(countryName).append(operatorName)
				.toHashCode();
	}

}
