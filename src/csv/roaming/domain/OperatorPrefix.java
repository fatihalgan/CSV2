package csv.roaming.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

/**
 * OperatorPrefix generated by hbm2java
 */
public class OperatorPrefix implements java.io.Serializable {

	private Long operatorPrefixId;
	private Operator operator;
	private String prefix;

	public OperatorPrefix() {
	}

	public OperatorPrefix(Long operatorPrefixId, Operator operator,
			String prefix) {
		this.operatorPrefixId = operatorPrefixId;
		this.operator = operator;
		this.prefix = prefix;
	}

	public Long getOperatorPrefixId() {
		return this.operatorPrefixId;
	}

	public void setOperatorPrefixId(Long operatorPrefixId) {
		this.operatorPrefixId = operatorPrefixId;
	}

	public Operator getOperator() {
		return this.operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof OperatorPrefix))
			return false;
		OperatorPrefix castOther = (OperatorPrefix) other;
		return new EqualsBuilder().append(operator, castOther.getOperator())
				.append(prefix, castOther.prefix).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1697633121, -1095761355).append(operator)
				.append(prefix).toHashCode();
	}

}
