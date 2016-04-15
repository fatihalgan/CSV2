package csv.roaming.domain;

public enum RoamingScheduleType {

	GSM("GSM", 1), GPRS("GPRS", 2), THREEG("3G", 3), CAMEL12("CAMEL1,CAMEL2", 4), CAMEL3(
			"CAMEL3", 5), MMSI("MMSI", 6);

	private final String text;
	private final int value;

	private RoamingScheduleType(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public int getValue() {
		return value;
	}

	public static RoamingScheduleType valueOf(int value) {

		if (value == GPRS.value) {
			return GPRS;
		} else if (value == THREEG.value) {
			return THREEG;
		} else if (value == CAMEL12.value) {
			return CAMEL12;
		} else if (value == CAMEL3.value) {
			return CAMEL3;
		} else if (value == MMSI.value) {
			return MMSI;
		} else {
			return GSM;
		}

	}

	@Override
	public String toString() {
		return text;
	}
}
