package csv.gateway.cs;

public enum VoucherStatus {

	Available(0),
	Used(1),
	Damaged(2),
	Stolen(3),
	Pending(4),
	Unavailable(5),
	Unknown(6);
	
	private Integer status;
	
	private VoucherStatus(Integer status) {
		this.status = status;
	}
	
	public String getLabel() {
		if(status == 0) return "Available";
		else if(status == 1) return "Used";
		else if(status == 2) return "Damaged";
		else if(status == 3) return "Stolen/Missing";
		else if(status == 4) return "Pending";
		else if(status == 5) return "Unavailable";
		else if(status == 6) return "Unknown";
		return "";
	}
	
	public Integer getValue() {
		return status;
	}
	
	public static VoucherStatus factory(Integer val) {
		if(val == null) return null;
		VoucherStatus[] vals = VoucherStatus.values();
		for(VoucherStatus i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
	
	public static VoucherStatus factory(String val) {
		return VoucherStatus.factory(Integer.parseInt(val));
	}
	
	
}
