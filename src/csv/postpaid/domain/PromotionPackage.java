package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;

public class PromotionPackage implements Serializable {

	private static final long serialVersionUID = 5747254748324591927L;
	
	private Integer sequenceNo;
	private String status;
	private Date validFrom;
	
	public PromotionPackage() {
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
