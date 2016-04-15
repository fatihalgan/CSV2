package csv.common.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class IMEIRecord implements Serializable {

	private String imei;
	private Date firstCDRDate;
	private Date lastCDRDate;
	
	public IMEIRecord() {
		super();
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public Date getFirstCDRDate() {
		return firstCDRDate;
	}

	public void setFirstCDRDate(Date firstCDRDate) {
		this.firstCDRDate = firstCDRDate;
	}

	public Date getLastCDRDate() {
		return lastCDRDate;
	}

	public void setLastCDRDate(Date lastCDRDate) {
		this.lastCDRDate = lastCDRDate;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof IMEIRecord))
			return false;
		IMEIRecord castOther = (IMEIRecord) other;
		return new EqualsBuilder().append(imei, castOther.imei).append(
				firstCDRDate, castOther.firstCDRDate).append(lastCDRDate,
				castOther.lastCDRDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1636367287, 1089292839).append(imei)
				.append(firstCDRDate).append(lastCDRDate).toHashCode();
	}
	
	
}
