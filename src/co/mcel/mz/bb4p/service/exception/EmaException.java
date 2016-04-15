package co.mcel.mz.bb4p.service.exception;

public class EmaException extends Exception {

	private int resultCode;
	
	public EmaException(Integer resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}
	
	public EmaException(Integer resultCode) {
		super();
		this.resultCode = resultCode;
	}

	public int getResultCode() {
		return resultCode;
	}
}
