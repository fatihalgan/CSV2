package csv.prepaid.domain.simreg;

public enum RegistrarRecordChangeReason {

	EDITED("EDITED"),
	DELETED_BY_USER("DELETEDBYUSER");
	
	private String reason;
	
	private RegistrarRecordChangeReason(String reason) {
		this.reason = reason;
	}
	
	public String getLabel() {
		if(reason.equals("EDITED")) return "Edited";
		if(reason.equals("DELETEDBYUSER")) return "Deleted By User";
		return null;
	}
	
	public String getValue() {
		return reason;
	}
	
	public String toString() {
		return getValue();
	}
	
	public static RegistrarRecordChangeReason factory(String type) {
		if(type.equals("EDITED")) return EDITED;
		if(type.equals("DELETEDBYUSER")) return DELETED_BY_USER;
		return null;
	}
}
