package csv.security.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class SMSLog implements Serializable {

	private Long id;
	private String msisdn;
	private Date createdTime;
	private String message;
	private String reason;
	
	private User owningUser;
	
	public SMSLog() {
		super();
	}
	
	public SMSLog(String msisdn, Date createdTime, String message, String reason) {
		this.msisdn = msisdn;
		this.createdTime = createdTime;
		this.message = message;
		this.reason = reason;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public User getOwningUser() {
		return owningUser;
	}

	public void setOwningUser(User owningUser) {
		this.owningUser = owningUser;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof SMSLog))
			return false;
		SMSLog castOther = (SMSLog) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).append(
				createdTime, castOther.createdTime).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(313822561, 2048942251).append(msisdn)
				.append(createdTime).toHashCode();
	}
	
	public static SMSLog SMSLog(String msisdn, Date createdTime, String message, String reason, User owningUser) {
		SMSLog smsLog = new SMSLog();
		smsLog.setMsisdn(msisdn);
		smsLog.setCreatedTime(createdTime);
		smsLog.setMessage(message);
		smsLog.setReason(reason);
		smsLog.setOwningUser(owningUser);
		return smsLog;
	}
	
	
}
