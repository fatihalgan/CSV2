package csv.common.domain;

public enum TomalaBlockingStatus {

	Available("Available"),
	Blocked("Blocked");
	
	private String status;
	
	private TomalaBlockingStatus(String status) {
		this.status = status;
	}
	
	public String getLabel() {
		return status;
	}
	
	public String getValue() {
		return status;
	}
	
	public String toString() {
		return getLabel();
	}
	
}
