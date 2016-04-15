package csv.prepaid.netmovel.domain;

public enum ResultCode {

	Success(0),
	PostpaidNotAllowed(15),
	InsufficientBalance(23),
	CSError(30),
	MultipleActivationsFound(31),
	InconsistentStatusWithCS(32),
	FinalLogNotWritten(33),
	SystemError(34),
	EMAError(40),
	InconsistentStatusWithEMA(42);
	
	private Integer resultCode;
	
	private ResultCode(Integer resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getLabel() {
		if(resultCode == 0) return "Success";
		else if(resultCode == 15) return "Subscriber's service class is not allowed to use this service";
		else if(resultCode == 23) return "Insufficient Balance";
		else if(resultCode == 30) return "Charging System Error";
		else if(resultCode == 31) return "Multiple Activations Found";
		else if(resultCode == 32) return "Inconsistent Active Status With CS";
		else if(resultCode == 33) return "Final Log Nor Written";
		else if(resultCode == 34) return "System Error";
		else if(resultCode == 40) return "EMA Error";
		else if(resultCode == 42) return "Inconsistent Active Status With EMA";
		else return "";
	}
	
	public Integer getValue() {
		return resultCode;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static ResultCode factory(Integer val) {
		if(val == null) return null;
		ResultCode[] vals = ResultCode.values();
		for(ResultCode i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
	
	public static ResultCode factory(String val) {
		return ResultCode.factory(Integer.parseInt(val));
	}
}
