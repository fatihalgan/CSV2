package com.bridge.pm.domain;

public class BSCSValidationException extends RuntimeException {

	private static final long serialVersionUID = -7798334675532791691L;
	private Integer returnCode;
		
	public BSCSValidationException(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public BSCSValidationException(String message) {
		super(message);
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}
	
	@Override
	public String getMessage() {
		return "BSCS Validation Error: " + BSCSValidationErrors.factory(returnCode).getLabel() + " - Error Code: " + returnCode;
	}
}
