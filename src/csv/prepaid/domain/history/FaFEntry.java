package csv.prepaid.domain.history;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class FaFEntry implements Serializable {

	private Long accountEventID;
	private Long accountId;
	private String fafNumber;
	private Long subscriberID;
	private Date creationTime;
	
	public FaFEntry() {
		super();
	}

	public Long getAccountEventID() {
		return accountEventID;
	}

	public void setAccountEventID(Long accountEventID) {
		this.accountEventID = accountEventID;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getFafNumber() {
		return fafNumber;
	}

	public void setFafNumber(String fafNumber) {
		this.fafNumber = fafNumber;
	}

	public Long getSubscriberID() {
		return subscriberID;
	}

	public void setSubscriberID(Long subscriberID) {
		this.subscriberID = subscriberID;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof FaFEntry))
			return false;
		FaFEntry castOther = (FaFEntry) other;
		return new EqualsBuilder().append(accountId, castOther.accountId)
				.append(fafNumber, castOther.fafNumber).append(subscriberID,
						castOther.subscriberID).append(creationTime,
						castOther.creationTime).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1988788973, 144272989).append(accountId)
				.append(fafNumber).append(subscriberID).append(creationTime)
				.toHashCode();
	}
	
}
