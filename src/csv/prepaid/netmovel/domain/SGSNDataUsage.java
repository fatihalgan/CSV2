package csv.prepaid.netmovel.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class SGSNDataUsage implements Serializable {

	private static final long serialVersionUID = -3629344359502565333L;
	
	private String msisdn;
	private Date openingTime;
	private String accessPointName;
	private double uplinkVolume;
	private double downlinkVolume;
	private int duration;
	
	public SGSNDataUsage() {
		super();
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getOpeningTime() {
		return openingTime;
	}

	public void setOpeningTime(Date openingTime) {
		this.openingTime = openingTime;
	}

	public String getAccessPointName() {
		return accessPointName;
	}

	public void setAccessPointName(String accessPointName) {
		this.accessPointName = accessPointName;
	}

	public double getUplinkVolume() {
		return uplinkVolume;
	}

	public void setUplinkVolume(double uplinkVolume) {
		this.uplinkVolume = uplinkVolume;
	}

	public double getDownlinkVolume() {
		return downlinkVolume;
	}
	
	public double getUplinkVolumeMB() {
		return uplinkVolume / (1024 * 1024);
	}
	
	public double getDownlinkVolumeMB() {
		return downlinkVolume / (1024 * 1024);
	}

	public void setDownlinkVolume(double downlinkVolume) {
		this.downlinkVolume = downlinkVolume;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof SGSNDataUsage))
			return false;
		SGSNDataUsage castOther = (SGSNDataUsage) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).append(
				openingTime, castOther.openingTime).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1893638147, 541698609).append(msisdn)
				.append(openingTime).toHashCode();
	}
	
	
	
	
}
