package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * MainAgreementApproach generated by hbm2java
 */
public class MainAgreementApproach implements java.io.Serializable {

	private Long mainAgreementApproachId;
	private MainAgreement mainAgreement;
	private String approach;
	private Long priority;
	private Date firstApproachDate;

	public MainAgreementApproach() {
	}

	public MainAgreementApproach(Long mainAgreementApproachId,
			MainAgreement mainAgreement, String approach) {
		this.mainAgreementApproachId = mainAgreementApproachId;
		this.mainAgreement = mainAgreement;
		this.approach = approach;
	}

	public MainAgreementApproach(Long mainAgreementApproachId,
			MainAgreement mainAgreement, String approach, Long priority,
			Date firstApproachDate) {
		this.mainAgreementApproachId = mainAgreementApproachId;
		this.mainAgreement = mainAgreement;
		this.approach = approach;
		this.priority = priority;
		this.firstApproachDate = firstApproachDate;
	}

	public Long getMainAgreementApproachId() {
		return this.mainAgreementApproachId;
	}

	public void setMainAgreementApproachId(Long mainAgreementApproachId) {
		this.mainAgreementApproachId = mainAgreementApproachId;
	}

	public MainAgreement getMainAgreement() {
		return this.mainAgreement;
	}

	public void setMainAgreement(MainAgreement mainAgreement) {
		this.mainAgreement = mainAgreement;
	}

	public String getApproach() {
		return this.approach;
	}

	public void setApproach(String approach) {
		this.approach = approach;
	}

	public Long getPriority() {
		return this.priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Date getFirstApproachDate() {
		return this.firstApproachDate;
	}

	public void setFirstApproachDate(Date firstApproachDate) {
		this.firstApproachDate = firstApproachDate;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof MainAgreementApproach))
			return false;
		MainAgreementApproach castOther = (MainAgreementApproach) other;
		return new EqualsBuilder().append(mainAgreement,
				castOther.mainAgreement).append(approach, castOther.approach)
				.append(firstApproachDate, castOther.firstApproachDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(70454089, -489130533).append(mainAgreement)
				.append(approach).append(firstApproachDate).toHashCode();
	}

}
