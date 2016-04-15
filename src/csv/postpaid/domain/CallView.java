package csv.postpaid.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CallView implements Serializable, Comparable<CallView> {

	private static final long serialVersionUID = -4041286138307530789L;
	
	private String service;
	private Date dateCall;
	private String duration;
	private String calledNumber;
	private BigDecimal charge;
	private String zone;
	
	public CallView() {
		super();
	}
	
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public Date getDateCall() {
		return dateCall;
	}
	public void setDateCall(Date dateCall) {
		this.dateCall = dateCall;
	}

	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getCalledNumber() {
		return calledNumber;
	}
	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}
	public BigDecimal getcharge() {
		return charge;
	}
	public void setcharge(BigDecimal charge) {
		this.charge = charge;
	}

	@Override
	public int compareTo(CallView o) {
		return o.getDateCall().compareTo(this.getDateCall());
	}

}
