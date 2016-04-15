package csv.roaming.domain;

public enum RoamingServiceType {
	GSM("Gsm", 1), GPRS("Gprs", 4);

	private final String text;
	private final int value;

	private RoamingServiceType(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public int getValue() {
		return value;
	}

	public static RoamingServiceType valueOf(int value) {
		switch (value) {
		case 4:
			return GPRS;
		default:
			return GSM;
		}
	}

	@Override
	public String toString() {
		return text;
	}
}
