package csv.prepaid.domain.history;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractAccountEvent implements Serializable, Comparable<AbstractAccountEvent> {

	protected Long eventId;
	protected Date originTimestamp;
	private Date utcTimestamp;
	protected Float balanceBefore;
	protected Float balanceAfter;
	
	
	public Long getEventId() {
		return eventId;
	}
	
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public Date getOriginTimestamp() {
		return originTimestamp;
	}
	
	public void setOriginTimestamp(Date originTimestamp) {
		this.originTimestamp = originTimestamp;
	}
	
	public Date getUtcTimestamp() {
		return utcTimestamp;
	}

	public void setUtcTimestamp(Date utcTimestamp) {
		this.utcTimestamp = utcTimestamp;
	}
		
	public abstract Float getBalanceBefore();
	public abstract Float getBalanceAfter();
	public abstract String getEventType();
	public abstract String getEventDescription();
	public abstract Float getUsageAmount();
	
	public int compareTo(AbstractAccountEvent evt) {
		int val = this.getUtcTimestamp().compareTo(evt.getUtcTimestamp());
		//Order events in descending
		if(val != 0) return -val;
		return val;
	}
}
