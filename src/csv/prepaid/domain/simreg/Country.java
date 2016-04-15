package csv.prepaid.domain.simreg;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Country implements Serializable {

	protected String countryName;
	
	public Country() {
		super();
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Country))
			return false;
		Country castOther = (Country) other;
		return new EqualsBuilder().append(countryName, castOther.countryName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(811769831, 911045975).append(countryName)
				.toHashCode();
	}
	
}
