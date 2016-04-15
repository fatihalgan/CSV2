package csv.prepaid.domain.simreg;

public enum RegistrationStatus {
	NewEntry(0),
	PartiallyApproved(1),
	Registered(2),
	TemporaryRegistered(3);
	
	private Integer status;
	
	private RegistrationStatus(Integer status) {
		this.status = status;
	}
	
	public String getLabel() {
		if(status == 0) return "New Entry";
		if(status == 1) return "Partially Approved";
		if(status == 2) return "Temporary Registered";
		if(status == 3) return "Registered";
		return null;
	}
	
	public Integer getValue() {
		return status;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static RegistrationStatus factory(Integer status) {
		if(status == 0) return NewEntry;
		if(status == 1) return PartiallyApproved;
		if(status == 2) return TemporaryRegistered;
		if(status == 3) return Registered;
		else return null;
	}
}
