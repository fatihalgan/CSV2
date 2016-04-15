package csv.dr.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class SMSMessage implements Serializable {

	private String msisdn;
	private Date creationDate;
	private String messageText;
	private String source;
	private String status;
	private Integer errorCode;
	private Date modifiedDate;
	
	public SMSMessage() {
		super();
	}
	
	public SMSMessage(String msisdn, String text) {
		Date now = new Date();
		this.msisdn = msisdn;
		this.messageText = text;
		this.source = "0INTSMSSND";
		this.creationDate = now;
		this.status = "R";
		this.errorCode = 0;
		this.modifiedDate = now;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof SMSMessage))
			return false;
		SMSMessage castOther = (SMSMessage) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).append(
				creationDate, castOther.creationDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1256734269, -151417437).append(msisdn)
				.append(creationDate).toHashCode();
	}
	
	
}
