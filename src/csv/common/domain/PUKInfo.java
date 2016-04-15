package csv.common.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class PUKInfo implements Serializable {

	private String msisdn;
	private Long storageMediumId;
	private Long customerId;
	private String customerCode;
	private Long contractId;
	private String status;
    private Date  validFrom;
    private String  billCycle;    
    private String puk;
    private String puk2;
    
    public PUKInfo() {
    	super();
    }

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Long getStorageMediumId() {
		return storageMediumId;
	}

	public void setStorageMediumId(Long storageMediumId) {
		this.storageMediumId = storageMediumId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
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

	public String getBillCycle() {
		return billCycle;
	}

	public void setBillCycle(String billCycle) {
		this.billCycle = billCycle;
	}

	public String getPuk() {
		return puk;
	}

	public void setPuk(String puk) {
		this.puk = puk;
	}

	public String getPuk2() {
		return puk2;
	}

	public void setPuk2(String puk2) {
		this.puk2 = puk2;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof PUKInfo))
			return false;
		PUKInfo castOther = (PUKInfo) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1217242779, 1482793083).append(msisdn)
				.toHashCode();
	}
    
    
}
