package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Tapcode generated by hbm2java
 */
public class Tapcode implements java.io.Serializable {

	private Long tapcodeId;
	private String tapcode;
	private Set<Operator> operators = new HashSet<Operator>(0);

	public Tapcode() {
	}

	public Tapcode(Long tapcodeId) {
		this.tapcodeId = tapcodeId;
	}

	public Tapcode(Long tapcodeId, String tapcode, Set<Operator> operators) {
		this.tapcodeId = tapcodeId;
		this.tapcode = tapcode;
		this.operators = operators;
	}

	public Long getTapcodeId() {
		return this.tapcodeId;
	}

	public void setTapcodeId(Long tapcodeId) {
		this.tapcodeId = tapcodeId;
	}

	public String getTapcode() {
		return this.tapcode;
	}

	public void setTapcode(String tapcode) {
		this.tapcode = tapcode;
	}

	public Set<Operator> getOperators() {
		return this.operators;
	}

	public void setOperators(Set<Operator> operators) {
		this.operators = operators;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Tapcode))
			return false;
		Tapcode castOther = (Tapcode) other;
		return new EqualsBuilder().append(tapcode, castOther.tapcode)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1793138059, -2133167679).append(tapcode)
				.toHashCode();
	}

}
