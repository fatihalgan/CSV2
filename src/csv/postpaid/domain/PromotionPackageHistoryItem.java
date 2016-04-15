package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;

public class PromotionPackageHistoryItem implements Serializable {

	private static final long serialVersionUID = 4532712165556737000L;
	
	private Integer sequenceNo;
	private String status;
	private Date validFrom;
	
	public PromotionPackageHistoryItem() {
		super();
	}
	
	public Integer getSequenceNo() {
		return sequenceNo;
	}
	
	public void setSequenceNo(Integer sequenceNo) {
		this.sequenceNo = sequenceNo;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Date getValidFrom() {
		return validFrom;
	}
	
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}
	
	
}
