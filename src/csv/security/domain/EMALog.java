package csv.security.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class EMALog implements Serializable {

	private static final long serialVersionUID = -8833357135125865469L;
	
	private Long id;
	private String ipAddress;
	private Date date;
	private Integer operationType;
	private String msisdn;
	private String forwardMsisdn;
	private String remark;
	private String reason;
	
	private User owningUser;
	
	public EMALog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getForwardMsisdn() {
		return forwardMsisdn;
	}

	public void setForwardMsisdn(String forwardMsisdn) {
		this.forwardMsisdn = forwardMsisdn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
		if (!(other instanceof EMALog))
			return false;
		EMALog castOther = (EMALog) other;
		return new EqualsBuilder().append(ipAddress, castOther.ipAddress)
				.append(date, castOther.date).append(msisdn, castOther.msisdn)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(669546997, 2027110207).append(ipAddress)
				.append(date).append(msisdn).toHashCode();
	}
	
	public static EMALog getEmaLog(User loggedInUser, String msisdn, int operationType, String forwardMsisdn, String remark, String reason) {
    	EMALog emaLog = new EMALog();	
    	emaLog.setOwningUser(loggedInUser);
    	emaLog.setDate(new Date());
    	emaLog.setIpAddress(loggedInUser.getClientIPAddress());
    	emaLog.setOperationType(operationType);
    	emaLog.setMsisdn(msisdn);
    	emaLog.setForwardMsisdn(6==operationType?forwardMsisdn.substring(4):"");
    	emaLog.setRemark(remark);
    	emaLog.setReason(reason);
		return  emaLog;
    }
}
