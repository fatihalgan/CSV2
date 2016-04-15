package csv.crm.complaintmng.domain;

public enum ComplaintPhase {

	HELP_DESK("Help Desk"),
	TECHNICAL_DEPARTMENT_SUPPORT("Technical Department Support"),
	OUTBOUND_SUPPORT("Outbound Support"),
	SUPERVISOR_FEEDBACK("Supervisor Feedback"),
	CUSTOMER_FEEDBACK("Customer Feedback"),
	ACCOUNT_MANAGER("Account Manager"),
	CLOSE_WITHOUT_FEEDBACK("Close Without Feedback");
		
	private String phase;
	
	private ComplaintPhase(String phase) {
		this.phase = phase;
	}
	
	public String getLabel() {
		return phase;
	}
	
	public String getValue() {
		return phase;
	}
	
	public String toString() {
		return phase;
	}
	
	public static ComplaintPhase factory(String phase) {
		if(phase.equals("Help Desk")) return HELP_DESK;
		else if(phase.equals("Technical Department Support")) return TECHNICAL_DEPARTMENT_SUPPORT;
		else if(phase.equals("Outbound Support")) return OUTBOUND_SUPPORT;
		else if(phase.equals("Supervisor Feedback")) return SUPERVISOR_FEEDBACK;
		else if(phase.equals("Customer Feedback")) return CUSTOMER_FEEDBACK;
		else if(phase.equals("Account Manager")) return ACCOUNT_MANAGER;
		else if(phase.equals("Close Without Feedback")) return CLOSE_WITHOUT_FEEDBACK;
		else return null;
	}
}
