package csv.prepaid.domain.simreg;

public enum INCMStatus {
	
	SendToINCM(0),
	ResendToINCM(1),
	DeleteFromINCM(2),
	SentToINCM(3);
	
	private Integer status;
	
	private INCMStatus(Integer status) {
		this.status = status;
	}
	
	public String getLabel() {
		if(status == 0) return "Will be sent to INCM";
		if(status == 1) return "Will be resent to INCM";
		if(status == 2) return "Will be deleted from INCM";
		if(status == 3) return "INCM status completed";
		return null;
	}
	
	public Integer getValue() {
		return status;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static INCMStatus factory(Integer status) {
		if(status == 0) return SendToINCM;
		if(status == 1) return ResendToINCM;
		if(status == 2) return DeleteFromINCM;
		if(status == 3) return SentToINCM;
		return null;
	}
}
