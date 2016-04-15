package csv.prepaid.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class LoyaltyTransaction implements Serializable, Comparable<LoyaltyTransaction> {

	private static final long serialVersionUID = -7504830611424706526L;

	private Long id;
	private String originTransId;
	private Date transDate;
	private Float amount;
	private LoyaltyTransactionType transType;
	private String msisdn;
	private boolean spent;
	private Float remaining;
		
	public LoyaltyTransaction() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginTransId() {
		return originTransId;
	}

	public void setOriginTransId(String originTransId) {
		this.originTransId = originTransId;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public LoyaltyTransactionType getTransType() {
		return transType;
	}

	public void setTransType(LoyaltyTransactionType transType) {
		this.transType = transType;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public boolean isSpent() {
		return spent;
	}

	public void setSpent(boolean spent) {
		this.spent = spent;
	}
	
	public Float getRemaining() {
		return remaining;
	}

	public void setRemaining(Float remaining) {
		this.remaining = remaining;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof LoyaltyTransaction))
			return false;
		LoyaltyTransaction castOther = (LoyaltyTransaction) other;
		return new EqualsBuilder().append(originTransId,
				castOther.originTransId).append(transDate, castOther.transDate)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1744228789, 1104309471)
				.append(originTransId).append(transDate).toHashCode();
	}
	
	@Override
	public int compareTo(LoyaltyTransaction o) {
		return o.getTransDate().compareTo(this.getTransDate());
	}
}
