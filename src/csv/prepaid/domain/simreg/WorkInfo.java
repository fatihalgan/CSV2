package csv.prepaid.domain.simreg;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class WorkInfo implements Serializable {

	private String company;
	private String place;
	private String title;
	
	public WorkInfo() {
		super();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof WorkInfo))
			return false;
		WorkInfo castOther = (WorkInfo) other;
		return new EqualsBuilder().append(company, castOther.company)
				.append(place, castOther.place).append(title, castOther.title)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-2104346109, -511314461).append(company)
				.append(place).append(title).toHashCode();
	}
	
	
	
	
}
