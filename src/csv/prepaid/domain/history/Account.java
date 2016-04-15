package csv.prepaid.domain.history;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements Serializable {

	private Long id;
	private String msisdn;
	private Long subscriberId;
	private String subscriberType;
	private Date sdpCreationTime;
	private Date sdpRemovalTime;
	private Date allocationEndTime;
	private Date activationDate;
	
	private List<AbstractAccountEvent> eventHistory = new ArrayList<AbstractAccountEvent>();
	
	private List<FaFEntry> fafHistory = new ArrayList<FaFEntry>();
	
	private AbstractAccountEvent currentViewedEvent = null;
	
	private EventDescription selectedEventDescription = EventDescription.All;
	
	public Account() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public Long getSubscriberId() {
		return subscriberId;
	}
	
	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}
	
	public String getSubscriberType() {
		return subscriberType;
	}
	
	public void setSubscriberType(String subscriberType) {
		this.subscriberType = subscriberType;
	}
	
	public Date getSdpCreationTime() {
		return sdpCreationTime;
	}
	
	public void setSdpCreationTime(Date sdpCreationTime) {
		this.sdpCreationTime = sdpCreationTime;
	}
	
	public Date getSdpRemovalTime() {
		return sdpRemovalTime;
	}
	
	public void setSdpRemovalTime(Date sdpRemovalTime) {
		this.sdpRemovalTime = sdpRemovalTime;
	}
	
	public Date getAllocationEndTime() {
		return allocationEndTime;
	}
	
	public void setAllocationEndTime(Date allocationEndTime) {
		this.allocationEndTime = allocationEndTime;
	}
	
	public Date getActivationDate() {
		return activationDate;
	}
	
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public List<AbstractAccountEvent> getEventHistory() {
		return eventHistory;
	}

	public void setEventHistory(List<AbstractAccountEvent> eventHistory) {
		this.eventHistory = eventHistory;
	}
	
	public List<AbstractAccountEvent> getEventHistoryFiltered() {
		if(selectedEventDescription.equals(EventDescription.All)) return eventHistory;
		List<AbstractAccountEvent> events = new ArrayList<AbstractAccountEvent>();
		for(AbstractAccountEvent e : eventHistory) {
			if(e.getEventDescription().equals(selectedEventDescription.toString())) events.add(e);
		}
		return events;
	}
	
	public AbstractAccountEvent getCurrentViewedEvent() {
		return currentViewedEvent;
	}

	public void setCurrentViewedEvent(AbstractAccountEvent currentViewedEvent) {
		this.currentViewedEvent = currentViewedEvent;
	}

	public EventDescription getSelectedEventDescription() {
		return selectedEventDescription;
	}

	public void setSelectedEventDescription(
			EventDescription selectedEventDescription) {
		this.selectedEventDescription = selectedEventDescription;
	}

	public List<FaFEntry> getFafHistory() {
		return fafHistory;
	}

	public void setFafHistory(List<FaFEntry> fafHistory) {
		this.fafHistory = fafHistory;
	}
	
	
}
