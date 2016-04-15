package csv.crm.complaintmng.domain;

public enum ComplaintStatus {

	OPEN("Open"), 
	RESOLVED("Resolved"), 
	DECLINED("Declined"),
	CANCELLED("Cancelled"),
	SUSPENDED("Suspended");
			
	private String status;
	
	private ComplaintStatus(String status) {
		this.status = status;
	}
	
	public String getLabel() {
		return status;
	}
	
	public String getValue() {
		return status;
	}
	
	public String toString() {
		return status;
	}
	
	public static ComplaintStatus factory(String status) {
		if(status.equals("Open")) return OPEN;
		else if(status.equals("Resolved")) return RESOLVED;
		else if(status.equals("Declined")) return DECLINED;
		else if(status.equals("Cancelled")) return CANCELLED;
		else if(status.equals("Suspended")) return SUSPENDED;
		else return null;
	}
}
