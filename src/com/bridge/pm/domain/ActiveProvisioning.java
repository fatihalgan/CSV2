package com.bridge.pm.domain;

import java.io.Serializable;
import java.util.Date;

public class ActiveProvisioning implements Serializable {

	private static final long serialVersionUID = 3923312823632810909L;
	private Long id;
	private String msisdn;
	private String imsi;
	private String sim;
	private Date activationDate;
	private Integer businessPlan;
	private String sdp;
	private String cardProfile;
		
	public ActiveProvisioning() {
		super();
	}
	
	public ActiveProvisioning(String msisdn, String imsi, String sim, Integer businessPlan, String sdp, String cardProfile) {
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.sim = sim;
		this.activationDate = new Date();
		this.businessPlan = businessPlan;
		this.sdp = sdp;
		this.cardProfile = cardProfile;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	public String getSim() {
		return sim;
	}
	public void setSim(String sim) {
		this.sim = sim;
	}
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	
	public Integer getBusinessPlan() {
		return businessPlan;
	}

	public void setBusinessPlan(Integer businessPlan) {
		this.businessPlan = businessPlan;
	}

	public String getSdp() {
		return sdp;
	}

	public void setSdp(String sdp) {
		this.sdp = sdp;
	}
	
	public String getCardProfile() {
		return cardProfile;
	}

	public void setCardProfile(String cardProfile) {
		this.cardProfile = cardProfile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imsi == null) ? 0 : imsi.hashCode());
		result = prime * result + ((msisdn == null) ? 0 : msisdn.hashCode());
		result = prime * result + ((sim == null) ? 0 : sim.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActiveProvisioning other = (ActiveProvisioning) obj;
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
			return false;
		if (msisdn == null) {
			if (other.msisdn != null)
				return false;
		} else if (!msisdn.equals(other.msisdn))
			return false;
		if (sim == null) {
			if (other.sim != null)
				return false;
		} else if (!sim.equals(other.sim))
			return false;
		return true;
	}
}
