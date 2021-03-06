package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * TadigStatus generated by hbm2java
 */
public class TadigStatus implements java.io.Serializable {

	private Long statusId;
	private String description;
	private Set<MainAgreementSchedule> mainAgreementSchedules = new HashSet<MainAgreementSchedule>(
			0);

	public TadigStatus() {
	}

	public TadigStatus(Long statusId, String description) {
		this.statusId = statusId;
		this.description = description;
	}

	public TadigStatus(Long statusId, String description,
			Set<MainAgreementSchedule> mainAgreementSchedules) {
		this.statusId = statusId;
		this.description = description;
		this.mainAgreementSchedules = mainAgreementSchedules;
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

	public Set<MainAgreementSchedule> getMainAgreementSchedules() {
		return this.mainAgreementSchedules;
	}

	public void setMainAgreementSchedules(
			Set<MainAgreementSchedule> mainAgreementSchedules) {
		this.mainAgreementSchedules = mainAgreementSchedules;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof TadigStatus))
			return false;
		TadigStatus castOther = (TadigStatus) other;
		return new EqualsBuilder().append(description, castOther.description)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(794299821, 1815533499).append(description)
				.toHashCode();
	}

}
