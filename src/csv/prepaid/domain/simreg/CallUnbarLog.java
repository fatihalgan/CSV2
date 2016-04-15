package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class CallUnbarLog implements Serializable {

	private Long id;
	private String saveUser;
	private Date saveDate;
	private String msisdn;
	private Date updateDate;
	private CallUnbarStatus status;
	private Integer emaResponse;
	
	public CallUnbarLog() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSaveUser() {
		return saveUser;
	}

	public void setSaveUser(String saveUser) {
		this.saveUser = saveUser;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public CallUnbarStatus getStatus() {
		return status;
	}

	public void setStatus(CallUnbarStatus status) {
		this.status = status;
	}
	
	public Integer getEmaResponse() {
		return emaResponse;
	}

	public void setEmaResponse(Integer emaResponse) {
		this.emaResponse = emaResponse;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof CallUnbarLog))
			return false;
		CallUnbarLog castOther = (CallUnbarLog) other;
		return new EqualsBuilder().append(id, castOther.id)
				.append(status, castOther.status).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(309206061, 46854663).append(id)
				.append(status).toHashCode();
	}
	
	
}
