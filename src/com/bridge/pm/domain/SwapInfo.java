package com.bridge.pm.domain;

import java.io.Serializable;

public class SwapInfo implements Serializable {

	public static final String CARD_PROFILE_MKESH = "mKesh";
	public static final String CARD_PROFILE_MCEL = "mCel";
	
	private Long requestId;
	private String currentMsisdn;
	private String newMsisdn;
	private String currentImsi;
	private String newImsi;
	private String currentSim;
	private String newSim;
	private String currentCardProfile  = CARD_PROFILE_MCEL;
	private String newCardProfile  = CARD_PROFILE_MCEL;
	
	public SwapInfo(String currentMsisdn, String currentImsi, String currentSim, String currentCardProfile) {
		this.currentMsisdn = currentMsisdn;
		this.currentImsi = currentImsi;
		this.currentSim = currentSim;
		if(currentCardProfile != null) this.currentCardProfile = currentCardProfile;
	}
	
		
	public String getCurrentMsisdn() {
		return currentMsisdn;
	}
	
	public void setCurrentMsisdn(String currentMsisdn) {
		this.currentMsisdn = currentMsisdn;
	}
	
	public String getNewMsisdn() {
		return newMsisdn;
	}
	
	public void setNewMsisdn(String newMsisdn) {
		this.newMsisdn = newMsisdn;
	}
	
	public String getCurrentImsi() {
		return currentImsi;
	}
	
	public void setCurrentImsi(String currentImsi) {
		this.currentImsi = currentImsi;
	}
	
	public String getNewImsi() {
		return newImsi;
	}
	
	public void setNewImsi(String newImsi) {
		this.newImsi = newImsi;
	}
	
	public String getCurrentSim() {
		return currentSim;
	}
	
	public void setCurrentSim(String currentSim) {
		this.currentSim = currentSim;
	}
	
	public String getNewSim() {
		return newSim;
	}
	
	public void setNewSim(String newSim) {
		this.newSim = newSim;
	}
	
	public Long getRequestId() {
		return requestId;
	}
	
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	
	public String getCurrentCardProfile() {
		return currentCardProfile;
	}

	public void setCurrentCardProfile(String currentCardProfile) {
		this.currentCardProfile = currentCardProfile;
	}

	public String getNewCardProfile() {
		return newCardProfile;
	}

	public void setNewCardProfile(String newCardProfile) {
		this.newCardProfile = newCardProfile;
	}

	public String toString() {
		return new String("SwapInfo: " + "Current MSISDN: " + currentMsisdn + ", New MSISDN: " + newMsisdn + ", Current SIM: " + currentSim 
			+ ", New SIM: " + newSim + ", Current IMSI: " + currentImsi + ", New IMSI: " + newImsi);
	}
}
