package csv.roaming.domain;

public enum OperatorFileStatus {

	RECEIVED("Received", "R"), PENDING("Pending", "P");

	private final String text;
	private final String value;

	private OperatorFileStatus(String text, String value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public static OperatorFileStatus fromString(String value) {
		if (RECEIVED.getValue().equals(value)) {
			return RECEIVED;
		} else {
			return PENDING;
		}
	}

	@Override
	public String toString() {
		return text;
	}
}
