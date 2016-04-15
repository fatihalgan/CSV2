package csv.prepaid.domain.simreg.activation;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class SIMCardActivation implements Serializable {

	private Long id = null;
	private String storageMediumNo;
	private String msisdn;
	private Date activationDate;
	private String activatedBy;
	private Dealer vendor;
	
	public SIMCardActivation() {
		super();
	}
	
	public SIMCardActivation(String storageMediumNo, String msisdn, String activatedBy, Dealer vendor) {
		this.storageMediumNo = storageMediumNo;
		this.msisdn = msisdn;
		this.activationDate = new Date();
		this.activatedBy = activatedBy;
		setVendor(vendor);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStorageMediumNo() {
		return storageMediumNo;
	}

	public void setStorageMediumNo(String storageMediumNo) {
		this.storageMediumNo = storageMediumNo;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public Dealer getVendor() {
		return vendor;
	}

	public void setVendor(Dealer vendor) {
		this.vendor = vendor;
	}
	
	public String getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(String activatedBy) {
		this.activatedBy = activatedBy;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof SIMCardActivation))
			return false;
		SIMCardActivation castOther = (SIMCardActivation) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).append(
				activationDate, castOther.activationDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1179913639, 692992899).append(msisdn)
				.append(activationDate).toHashCode();
	}
	
	
}
