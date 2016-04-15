package com.bridge.pm.domain;

public enum SIMMigrationType {

	PrepaidToPostpaid("Prepaid To Postpaid"),
	PostpaidToPrepaid("Postpaid To Prepaid");
	
	private String type;
	
	private SIMMigrationType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		return type;
	}
	
	public String toString() {
		return type;
	}
}
