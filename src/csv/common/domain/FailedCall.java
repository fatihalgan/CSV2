package csv.common.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class FailedCall implements Serializable {

	private int recordType;
	private Integer tsc;
	private String sourceMsisdn;
	private String sequenceNo;
	private String destMsisdn;
	private Date chargingDate;
	private Integer chargeableDuration;
	private String siteName;
	private Integer code;
	private String description;
	
	public FailedCall() {
		super();
	}

	public int getRecordType() {
		return recordType;
	}

	public void setRecordType(int recordType) {
		this.recordType = recordType;
	}

	public Integer getTsc() {
		return tsc;
	}

	public void setTsc(Integer tsc) {
		this.tsc = tsc;
	}

	public String getSourceMsisdn() {
		return sourceMsisdn;
	}

	public void setSourceMsisdn(String sourceMsisdn) {
		this.sourceMsisdn = sourceMsisdn;
	}

	public String getDestMsisdn() {
		return destMsisdn;
	}

	public void setDestMsisdn(String destMsisdn) {
		this.destMsisdn = destMsisdn;
	}

	public Date getChargingDate() {
		return chargingDate;
	}

	public void setChargingDate(Date chargingDate) {
		this.chargingDate = chargingDate;
	}

	public Integer getChargeableDuration() {
		return chargeableDuration;
	}

	public void setChargeableDuration(Integer chargeableDuration) {
		this.chargeableDuration = chargeableDuration;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(String sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof FailedCall))
			return false;
		FailedCall castOther = (FailedCall) other;
		return new EqualsBuilder().append(sequenceNo, castOther.sequenceNo)
				.append(chargingDate,
						castOther.chargingDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1108311253, 827073731).append(sequenceNo)
				.append(chargingDate).toHashCode();
	}

	
}
