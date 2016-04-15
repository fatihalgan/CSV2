package csv.security.domain;

public enum GroupType {

	REGULAR("Regular"),
	OUTBOUND_SUPPORT("Outbound Support"),
	TECH_OUTBOUND_SUPPORT("Technical Outbound Support"),
	DEPARTMENT_LEADER("Department Leader"),
	CTO("CTO"),
	CMO("CMO"),
	CEO("CEO"),
	CFO("CFO"),
	DIRECTOR("Director"),
	HELP_DESK("Help Desk");
	
	private String type;
	
	private GroupType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		return type;
	}
	
	public String getValue() {
		return type;
	}
	
	public String toString() {
		return type;
	}
	
	public static GroupType factory(String type) {
		if(type.equals("Regular")) return REGULAR;
		else if(type.equals("Outbound Support")) return OUTBOUND_SUPPORT;
		else if(type.equals("Technical Outbound Support")) return TECH_OUTBOUND_SUPPORT;
		else if(type.equals("Department Leader")) return DEPARTMENT_LEADER;
		else if(type.equals("Director")) return DIRECTOR;
		else if(type.equals("Help Desk")) return HELP_DESK;
		else if(type.equals("CTO")) return CTO;
		else if(type.equals("CMO")) return CMO;
		else if(type.equals("CEO")) return CEO;
		else if(type.equals("CFO")) return CFO;
		else return null;
	}
}
