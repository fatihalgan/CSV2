package csv.prepaid.netmovel.domain;

public enum OperationCode {

	Activate(201),
	Terminate(202),
	Renew(203),
	Expire(204),
	SubscribeNTDUO(206),
	UnsubscriberNTDUO(207);
	
	private Integer operationCode;
	
	private OperationCode(Integer opCode) {
		this.operationCode = opCode;
	}
	
	public String getLabel() {
		if(operationCode == 201) return "Activation";
		else if(operationCode == 202) return "Deactivation";
		else if(operationCode == 203) return "Renewal";
		else if(operationCode == 204) return "Expiration";
		else if(operationCode == 206) return "Subscribe to NTDUO";
		else if(operationCode == 207) return "Unsubscribe from NTDUO";
		return null;
	}
	
	public Integer getValue() {
		return operationCode;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static OperationCode factory(Integer val) {
		if(val == null) return null;
		OperationCode[] vals = OperationCode.values();
		for(OperationCode i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
	
	public static OperationCode factory(String val) {
		return OperationCode.factory(Integer.parseInt(val));
	}
}
