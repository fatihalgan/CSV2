package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class GprsUsage implements Serializable {
	
	private Long contractId;
	private Integer downlinkVolume;
	private Integer uplinkVolume;
	private Integer totalVolume;
	private Date	entryDate;
	private Integer downlinkVolumeUmCode;
	private Integer uplinkVolumeUmCode;
	private Integer totalVolumeUmCode;
	
	private static  HashMap<Integer,String>umCodeHash = null;
	
	static{ //select * from mpsumtab
		umCodeHash = new HashMap<Integer,String>();
		umCodeHash.put(1, "Seconds");
		umCodeHash.put(2, "Bytes");
		umCodeHash.put(3, "per Msg");
		umCodeHash.put(4, "per Event");
		umCodeHash.put(6, "Money");
		umCodeHash.put(7, "Rating Clicks");
		umCodeHash.put(8, "Minutes");
		umCodeHash.put(9, "Hours");
		umCodeHash.put(10, "Kilo Bytes");
		umCodeHash.put(11, "Mega Bytes");
		umCodeHash.put(12, "Giga Bytes");
	}
	
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public Integer getTotalVolume() {
		return totalVolume;
	}
	
	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}
	
	public Date getEntryDate() {
		return entryDate;
	}
	
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	public Integer getDownlinkVolume() {
		return downlinkVolume;
	}
	
	public void setDownlinkVolume(Integer downlinkVolume) {
		this.downlinkVolume = downlinkVolume;
	}
	
	public Integer getUplinkVolume() {
		return uplinkVolume;
	}
	
	public void setUplinkVolume(Integer uplinkVolume) {
		this.uplinkVolume = uplinkVolume;
	}
	
	public void setDownlinkVolumeUmCode(Integer downlinkVolumeUmCode) {
		this.downlinkVolumeUmCode = downlinkVolumeUmCode;
	}
	
	public void setUplinkVolumeUmCode(Integer uplinkVolumeUmCode) {
		this.uplinkVolumeUmCode = uplinkVolumeUmCode;
	}
	
	public void setTotalVolumeUmCode(Integer totalVolumeUmCode) {
		this.totalVolumeUmCode = totalVolumeUmCode;
	}
	
	public Integer getDownlinkVolumeUmCode() {
		return downlinkVolumeUmCode;
	}

	public Integer getUplinkVolumeUmCode() {
		return uplinkVolumeUmCode;
	}

	public Integer getTotalVolumeUmCode() {
		return totalVolumeUmCode;
	}

	public String getDownlinkVolumeUmCodeDes() {
		return umCodeHash.get(downlinkVolumeUmCode);
	}
	
	public String getUplinkVolumeUmCodeDes() {
		return umCodeHash.get(uplinkVolumeUmCode);
	}
	
	public String getTotalVolumeUmCodeDes() {
		return umCodeHash.get(totalVolumeUmCode);
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof GprsUsage))
			return false;
		GprsUsage castOther = (GprsUsage) other;
		return new EqualsBuilder().append(contractId, castOther.contractId)
				.append(entryDate, castOther.entryDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1840703883, 169428653).append(contractId)
				.append(entryDate).toHashCode();
	}
	
	

}
