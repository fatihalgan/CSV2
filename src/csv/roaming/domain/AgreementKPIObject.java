package csv.roaming.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class AgreementKPIObject implements java.io.Serializable {

	private String status;
	private int gsm;
	private int gprs;
	private int mmsiw;
	private int camel;
	private int threeg;
	private int nrtrde;

	public AgreementKPIObject() {
		super();
	}

	public AgreementKPIObject(String status) {
		super();
		this.status = status;

	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGsm() {
		return gsm;
	}

	public void setGsm(int gsm) {
		this.gsm = gsm;
	}

	public int getGprs() {
		return gprs;
	}

	public void setGprs(int gprs) {
		this.gprs = gprs;
	}

	public int getMmsiw() {
		return mmsiw;
	}

	public void setMmsiw(int mmsiw) {
		this.mmsiw = mmsiw;
	}

	public int getCamel() {
		return camel;
	}

	public void setCamel(int camel) {
		this.camel = camel;
	}

	public int getThreeg() {
		return threeg;
	}

	public void setThreeg(int threeg) {
		this.threeg = threeg;
	}

	public int getNrtrde() {
		return nrtrde;
	}

	public void setNrtrde(int nrtrde) {
		this.nrtrde = nrtrde;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof AgreementKPIObject))
			return false;
		AgreementKPIObject castOther = (AgreementKPIObject) other;
		return new EqualsBuilder().append(status, castOther.status).append(gsm,
				castOther.gsm).append(gprs, castOther.gprs).append(mmsiw,
				castOther.mmsiw).append(camel, castOther.camel).append(threeg,
				castOther.threeg).append(nrtrde, castOther.nrtrde).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(221657105, -112643437).append(status)
				.append(gsm).append(gprs).append(mmsiw).append(camel).append(
						threeg).append(nrtrde).toHashCode();
	}

}
