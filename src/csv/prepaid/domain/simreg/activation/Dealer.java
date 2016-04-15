package csv.prepaid.domain.simreg.activation;

import java.io.Serializable;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Dealer implements Serializable {

	protected Long id;
	protected String dealerName;
	
	public Dealer() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDealerName() {
		return dealerName;
	}
	
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Dealer))
			return false;
		Dealer castOther = (Dealer) other;
		return new EqualsBuilder().append(dealerName, castOther.dealerName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(469453449, -1617385171).append(dealerName)
				.toHashCode();
	}

}
