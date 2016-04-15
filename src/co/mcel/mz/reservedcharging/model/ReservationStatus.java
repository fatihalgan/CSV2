package co.mcel.mz.reservedcharging.model;

public enum ReservationStatus {

	RESERVED(0),
	DEBITTED(1),
	CANCELLED(2),
	REFUNDED(3),
	DIRECT(4);
	
	private int status;
	
	private ReservationStatus(int status) {
		this.status = status;
	}
	
	public String getLabel() {
		if(status == 0) return "Reserved";
		else if(status == 1) return "Debitted";
		else if(status == 2) return "Cancelled";
		else if(status == 3) return "Refunded";
		else if(status == 4) return "Direct";
		return "";
	}
	
	public int getValue() {
		return status;
	}
	
	public static ReservationStatus factory(int val) {
		ReservationStatus[] vals = ReservationStatus.values();
		for(ReservationStatus i : vals) {
			if(i.getValue() == val) return i;
		}
		return null;
	}
	
}
