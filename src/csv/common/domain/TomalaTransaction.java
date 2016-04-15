package csv.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class TomalaTransaction implements Serializable {

	private Long id;
	private String sender;
	private String receiver;
	private BigDecimal amount;
	private TomalaResult result;
	private Date date;
	private String smsContent;
	
	public TomalaTransaction() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public TomalaResult getResult() {
		return result;
	}

	public void setResult(TomalaResult result) {
		this.result = result;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getSmsContent() {
		return smsContent;
	}

	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof TomalaTransaction))
			return false;
		TomalaTransaction castOther = (TomalaTransaction) other;
		return new EqualsBuilder().append(id, castOther.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-277414503, 1805582175).append(id)
				.toHashCode();
	}
	
	
}
