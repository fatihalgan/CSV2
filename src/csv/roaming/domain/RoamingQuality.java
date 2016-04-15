package csv.roaming.domain;

public enum RoamingQuality {
	BAD("Bad", "B"), NORMAL("Normal", "N"), GOOD("Good", "G");
	private final String text;
	private final String value;

	private RoamingQuality(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public static RoamingQuality fromString(String value) {
		if (NORMAL.getValue().equals(value)) {
			return NORMAL;
		} else if (GOOD.getValue().equals(value)) {
			return GOOD;
		} else {
			return BAD;
		}
	}

	@Override
	public String toString() {
		return text;
	}
}
