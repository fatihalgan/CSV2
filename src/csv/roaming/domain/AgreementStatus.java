package csv.roaming.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

/**
 * AgreementStatus generated by hbm2java
 */
public class AgreementStatus implements java.io.Serializable {

	private Long statusId;
	private String description;

	public AgreementStatus() {
	}

	public AgreementStatus(Long statusId, String description) {
		this.statusId = statusId;
		this.description = description;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AgreementStatus))
			return false;
		AgreementStatus castOther = (AgreementStatus) other;
		return new EqualsBuilder().append(description, castOther.getDescription())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1725301275, 1761443271).append(description)
				.toHashCode();
	}

}
