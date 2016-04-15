package csv.prepaid.domain.history;

import java.io.Serializable;

public class LifeCycleChangeInfo implements Serializable, Comparable<LifeCycleChangeInfo> {

	private Long accountEventId;
	private String eventName;
	private String eventValueBefore;
	private String eventValueAfter;
	
	public LifeCycleChangeInfo() {
		super();
	}

	public Long getAccountEventId() {
		return accountEventId;
	}

	public void setAccountEventId(Long accountEventId) {
		this.accountEventId = accountEventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventValueBefore() {
		return eventValueBefore;
	}

	public void setEventValueBefore(String eventValueBefore) {
		this.eventValueBefore = eventValueBefore;
	}

	public String getEventValueAfter() {
		return eventValueAfter;
	}

	public void setEventValueAfter(String eventValueAfter) {
		this.eventValueAfter = eventValueAfter;
	}

	@Override
	public int compareTo(LifeCycleChangeInfo o) {
		return this.eventName.compareTo(o.eventName);
	}
	
	
}
