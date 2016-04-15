package csv.common.domain;

public enum EMAOperation {

	SUSPEND_LINE_INCOMING_CALLS(0),
	SUSPEND_LINE_OUTGOING_CALLS(1),
	REMOVE_INCOMING_CALL_BARRING(2),
	REMOVE_OUTGOING_CALL_BARRING(3),
	ACTIVATE_SIM_CARD(4),
	//ACTIVATE_CALL_BARRING(4),
	DEACTIVATE_CALL_BARRING(5),
	ACTIVATE_CALL_FORWARDING(6),
	DEACTIVATE_CALL_FORWARDING(7),
	ACTIVATE_CONFERENCE_CALL(8),
	DEACTIVATE_CONFERENCE_CALL(9),
	ACTIVATE_CLIP(10),
	DEACTIVATE_CLIP(11),
	ACTIVATE_CLIR(12),
	DEACTIVATE_CLIR(13),
	BAR_ROAMING(14),
	UNBAR_ROAMING(15),
	BAR_OUTGOING_SMS(16),
	UNBAR_OUTGOING_SMS(17),
	BAR_INCOMING_SMS(18),
	UNBAR_INCOMING_SMS(19),
	ACTIVATE_3G(20),
	DEACTIVATE_3G(21),
	ACTIVATE_GPRS(22),
	ACTIVATE_PREPAID_MMS(23);
	//ACTIVATE_CALL_BARRING_FOR_DATACARD(31),
	//DEACTIVATE_CALL_BARRING_FOR_DATACARD(32);
	
	private Integer operation;
	
	private EMAOperation(Integer operation) {
		this.operation = operation;
	}
	
	public String getLabel() {
		switch (operation) {
		case 0: return "STOLEN Phone    : SUSPEND Line [INCOMING CALLS]";
		case 1: return "STOLEN Phone    : SUSPEND Line [OUTGOING CALLS]";
		case 2: return "Reactivate Line : [REMOVE INCOMING CALL BARRING]";
		case 3: return "Reactivate Line : [REMOVE OUTGOING CALL BARRING]";
		case 4: return "Activate SIM CARD";
		//case 4: return "Activate CALL BARRING";
		case 5: return "Deactivate CALL BARRING";
		case 6: return "Activate CALL FORWARDING";
		case 7: return "Deactivate CALL FORWARDING";
		case 8: return "Activation of Conference call";
		case 9: return "Deactivation of Conference call";
		case 10: return "Activation of CLIP";
		case 11: return "Deactivation of CLIP";
		case 12: return "Activation of CLIR";
		case 13: return "Deactivation of CLIR";
		case 14: return "Barring of roaming";
		case 15: return "UnBarring of roaming";
		case 16: return "Activate OUTGOING SMS BARRING";
		case 17: return "Deactivate OUTGOING SMS BARRING";
		case 18: return "Activate INCOMING SMS BARRING";
		case 19: return "Deactivate INCOMING SMS BARRING";
		case 20: return "Activate 3G";
		case 21: return "Deactivate 3G";
		case 22: return "Activation of GPRS";
		case 23: return "Activation of MMS [Prepaid]";
		case 31: return "Activation of Barring For Data Card";
		case 32: return "Deactivation of Barring For Data Card";
		default: return "";
			
		}
	}
	
	public Integer getValue() {
		return operation;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static EMAOperation factory(Integer val) {
		if(val == null) return null;
		EMAOperation[] vals = EMAOperation.values();
		for(EMAOperation i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
}
