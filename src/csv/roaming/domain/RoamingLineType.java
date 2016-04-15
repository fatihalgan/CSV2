package csv.roaming.domain;

public enum RoamingLineType {
	PREPAID("Prepaid", 1), POSTPAID("Postpaid", 2);

	private final String text;
	private final int value;

	private RoamingLineType(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public int getValue() {
		return value;
	}

	public static RoamingLineType valueOf(int value) {
		switch (value) {
		case 2:
			return POSTPAID;
		default:
			return PREPAID;
		}
	}

	@Override
	public String toString() {
		return text;
	}
}
