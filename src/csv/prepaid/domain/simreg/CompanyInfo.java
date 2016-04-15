package csv.prepaid.domain.simreg;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class CompanyInfo implements Serializable {

	private String companyDocType;
	private String companyDocNo;
	private String province;
	private String district;
	private String place;
	private String neighborHood;
	private String block;
	private String street;
	private Integer no;
	private Integer flat;
	
	public CompanyInfo() {
		super();
	}

	public String getCompanyDocType() {
		return companyDocType;
	}

	public void setCompanyDocType(String companyDocType) {
		this.companyDocType = companyDocType;
	}

	public String getCompanyDocNo() {
		return companyDocNo;
	}

	public void setCompanyDocNo(String companyDocNo) {
		this.companyDocNo = companyDocNo;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getNeighborHood() {
		return neighborHood;
	}

	public void setNeighborHood(String neighborHood) {
		this.neighborHood = neighborHood;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public Integer getFlat() {
		return flat;
	}

	public void setFlat(Integer flat) {
		this.flat = flat;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof CompanyInfo))
			return false;
		CompanyInfo castOther = (CompanyInfo) other;
		return new EqualsBuilder()
				.append(companyDocType, castOther.companyDocType)
				.append(companyDocNo, castOther.companyDocNo)
				.append(province, castOther.province)
				.append(district, castOther.district)
				.append(place, castOther.place)
				.append(neighborHood, castOther.neighborHood)
				.append(block, castOther.block)
				.append(street, castOther.street).append(no, castOther.no)
				.append(flat, castOther.flat).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-2134214113, 1532001395)
				.append(companyDocType).append(companyDocNo).append(province)
				.append(district).append(place).append(neighborHood)
				.append(block).append(street).append(no).append(flat)
				.toHashCode();
	}
	
	
}
