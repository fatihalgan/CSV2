package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;

public class RatePlanChange implements Serializable {

	private static final long serialVersionUID = 1920613247907736442L;
	
	private Long contractId;
	private String ratePlan;
	private Date validFrom;
	private String enteredBy;
	
	public RatePlanChange() {
		super();
	}
	
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	public String getRatePlan() {
		return ratePlan;
	}

	public void setRatePlan(String ratePlan) {
		this.ratePlan = ratePlan;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	
}
