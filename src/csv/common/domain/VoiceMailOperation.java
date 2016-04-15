package csv.common.domain;

public enum VoiceMailOperation {

	ActivateWHC(0),
	ActivateWHCNFY(1),
	Deactivate(2),
	ModifyWHC(3),
	ModifyWHCNFY(4),
	ResetPIN(5);
	
	private Integer operation;
	
	private VoiceMailOperation(Integer operation) {
		this.operation = operation;
	}
	
	public String getLabel() {
		switch (operation) {
		case 0: return "Activate The Voice Mail Service - WHC";
		case 1: return "Activate The Voice Mail Service - WHC & NFY";
		case 2: return "Deactivate The Voice Mail Service";
		case 3: return "Modify The Voice Mail Service - WHC";
		case 4: return "Modify The Voice Mail Service - WHC & NFY";
		case 5: return "Modify The Voice Mail Service - Reset PIN";
		default: return "Unknown Operation";
		}
	}
	
	public Integer getValue() {
		return operation;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static VoiceMailOperation factory(Integer val) {
		if(val == null) return null;
		VoiceMailOperation[] vals = VoiceMailOperation.values();
		for(VoiceMailOperation i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
}
