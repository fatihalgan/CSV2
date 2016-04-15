package csv.prepaid.domain.simreg;

public enum CallUnbarStatus {

	UnbarRequested(0),
	UnbarCompleted(1);
	
	private Integer status;
	
	private CallUnbarStatus(Integer status) {
		this.status = status;
	}
	
	public String getLabel() {
		if(status == 0) return "Call Unbarring Requested";
		if(status == 1) return "Call Unbarring Done";
		return null;
	}
	
	public Integer getValue() {
		return status;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static CallUnbarStatus factory(Integer status) {
		if(status == 0) return UnbarRequested;
		if(status == 1) return UnbarCompleted;
		return null;
	}
}
