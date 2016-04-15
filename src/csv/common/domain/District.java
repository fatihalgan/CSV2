package csv.common.domain;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class District implements Serializable {

	private Long id;
	private String name;
	
	private Province owningProvince;
	
	public District() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getOwningProvince() {
		return owningProvince;
	}

	public void setOwningProvince(Province owningProvince) {
		this.owningProvince = owningProvince;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof District))
			return false;
		District castOther = (District) other;
		return new EqualsBuilder().append(name, castOther.name).append(owningProvince, castOther.owningProvince)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1224027199, 1737641165).append(name)
				.append(owningProvince).toHashCode();
	}
	
	
}
