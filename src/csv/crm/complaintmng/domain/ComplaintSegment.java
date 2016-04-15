package csv.crm.complaintmng.domain;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ComplaintSegment implements Serializable {

	private static final long serialVersionUID = -3992157759522131274L;
	
	private Long id;
	private String description;
		
	public ComplaintSegment() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ComplaintSegment))
			return false;
		ComplaintSegment castOther = (ComplaintSegment) other;
		return new EqualsBuilder().append(description, castOther.description)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-314200873, 1330044655).append(description)
				.toHashCode();
	}
	
	
}
