package csv.roaming.domain;

public enum RoamingStatus {

	NOT_STARTED("Not Started", "N"), ONGOING("Ongoing", "O"), COMPLETED(
			"Completed", "C");
	private final String text;
	private final String value;

	private RoamingStatus(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public static RoamingStatus fromString(String value) {
		if (ONGOING.getValue().equals(value)) {
			return ONGOING;
		} else if (COMPLETED.getValue().equals(value)) {
			return COMPLETED;
		} else {
			return NOT_STARTED;
		}
	}

	@Override
	public String toString() {
		return text;
	}
}
