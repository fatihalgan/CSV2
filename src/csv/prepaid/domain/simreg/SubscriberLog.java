package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class SubscriberLog implements Serializable {

	private Long registrarId;
	private String msisdn;
	private LogType logType;
	private Date logDate;
	private String user;
	private String detail;
	
	public SubscriberLog() {
		super();
	}
	
	public SubscriberLog(String msisdn, Long registrarId, LogType logType, String user, AbstractRegistrar registrar) {
		this.registrarId = registrarId;
		this.msisdn = msisdn;
		this.logDate = new Date();
		this.user = user;
		this.logType = logType;
		this.detail = logType.getLogDetail(registrar, null);
	}
	
	public SubscriberLog(String msisdn, Long registrarId, LogType logType, String user, Subscription subscription) {
		this.registrarId = registrarId;
		this.msisdn = msisdn;
		this.logDate = new Date();
		this.user = user;
		this.logType = logType;
		this.detail = logType.getLogDetail(null, subscription);
	}
	
	public Long getRegistrarId() {
		return registrarId;
	}
	
	public void setRegistrarId(Long registrarId) {
		this.registrarId = registrarId;
	}
	
	public String getMsisdn() {
		return msisdn;
	}
	
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public LogType getLogType() {
		return logType;
	}
	
	public void setLogType(LogType logType) {
		this.logType = logType;
	}
	
	public Date getLogDate() {
		return logDate;
	}
	
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof SubscriberLog))
			return false;
		SubscriberLog castOther = (SubscriberLog) other;
		return new EqualsBuilder().append(registrarId, castOther.registrarId)
				.append(msisdn, castOther.msisdn)
				.append(logType, castOther.logType).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(547584525, 504835127).append(registrarId)
				.append(msisdn).append(logType).toHashCode();
	}
	
	
	
}
