package csv.gateway.cs;

public class AIRException extends Exception {

	private int resultCode;
	
	public AIRException(Integer resultCode, String message) {
		super(message);
		this.resultCode = resultCode;
	}
	
	public AIRException(Integer resultCode) {
		super();
		this.resultCode = resultCode;
	}

	public int getResultCode() {
		return resultCode;
	}
	
	@Override
	public String getMessage() {
		return super.getMessage() + ".. Charging System Error Code: " + resultCode;
	}
}
