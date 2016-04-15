package com.bridge.pm.domain;

public enum BSCSValidationErrors {

	MsisdnInUse(11001),
	MsisdnNotInUse(11002),
	ImsiAndSimNotAvailable(11003),
	MsisdnNotavailable(11004),
	SimNotAvailable(11005),
	ImsiNotAvailable(11006),
	InternalError(11007);
	
	private Integer errorCode;
	
	private BSCSValidationErrors(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public Integer getValue() {
		return errorCode;
	}
	
	public String getLabel() {
		if(errorCode == 11001) return "MSISDN already in use in BSCS"; 
		else if(errorCode == 11002) return "MSISDN is not in use in BSCS";
		else if(errorCode == 11003) return "IMSI and SIM are not available in BSCS";
		else if(errorCode == 11004) return "MSISDN not available in BSCS";
		else if(errorCode == 11005) return "SIM not available in BSCS";
		else if(errorCode == 11006) return "IMSI not available in BSCS";
		else if(errorCode == 11007) return "Internal BSCS error";
		else return "";
	}
	
	public static BSCSValidationErrors factory(Integer val) {
		if(val == null) return null;
		BSCSValidationErrors[] vals = BSCSValidationErrors.values();
		for(BSCSValidationErrors i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
}
