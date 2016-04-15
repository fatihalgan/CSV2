package com.bridge.pm.bpm;

import com.bridge.pm.domain.SIMMigrationType;


public class PrepaidToPostpaidMigrationRequestState extends SIMMigrationRequestState {

	private boolean passedRiskAnalysis;
	
	public PrepaidToPostpaidMigrationRequestState() {
		super();
	}
	
	public PrepaidToPostpaidMigrationRequestState(Long requestId, String msisdn, String imsi, String sim, String cardProfile) {
		this.requestId = requestId;
		this.msisdn = msisdn;
		this.imsi = imsi;
		this.sim = sim;
		this.cardProfile = cardProfile;
	}

	public boolean isPassedRiskAnalysis() {
		return passedRiskAnalysis;
	}

	public void setPassedRiskAnalysis(boolean passedRiskAnalysis) {
		this.passedRiskAnalysis = passedRiskAnalysis;
	}

	@Override
	public SIMMigrationType getMigrationType() {
		return SIMMigrationType.PrepaidToPostpaid;
	}
	
	
}
