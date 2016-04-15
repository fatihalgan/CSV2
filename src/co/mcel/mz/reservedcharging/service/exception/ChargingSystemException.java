package co.mcel.mz.reservedcharging.service.exception;

public class ChargingSystemException extends Exception {

	private int resultCode;
		
	public ChargingSystemException(Integer resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}

	public int getResultCode() {
		return resultCode;
	}
}
