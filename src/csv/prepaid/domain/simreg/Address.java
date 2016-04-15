package csv.prepaid.domain.simreg;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Address implements Serializable {

	private String street;
	private Integer no;
	private String floor;
	private Integer flat;
	private String block;
	private String nuit;
	private String city;
	private String district;
	private String provincia;
	private String neighborHood;
	private String email;
	
	public Address() {
		super();
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

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public Integer getFlat() {
		return flat;
	}

	public void setFlat(Integer flat) {
		this.flat = flat;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getNuit() {
		return nuit;
	}

	public void setNuit(String nuit) {
		this.nuit = nuit;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getNeighborHood() {
		return neighborHood;
	}

	public void setNeighborHood(String neighborHood) {
		this.neighborHood = neighborHood;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Address))
			return false;
		Address castOther = (Address) other;
		return new EqualsBuilder().append(street, castOther.street)
				.append(no, castOther.no).append(floor, castOther.floor)
				.append(flat, castOther.flat).append(block, castOther.block)
				.append(nuit, castOther.nuit).append(city, castOther.city)
				.append(district, castOther.district)
				.append(provincia, castOther.provincia)
				.append(neighborHood, castOther.neighborHood)
				.append(email, castOther.email).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-742198763, -1383921231).append(street)
				.append(no).append(floor).append(flat).append(block)
				.append(nuit).append(city).append(district).append(provincia)
				.append(neighborHood).append(email).toHashCode();
	}
	
	

}
