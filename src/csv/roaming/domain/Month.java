package csv.roaming.domain;

public enum Month {

	JANUARY("JANUARY", 0), FEBRUARY("FEBRUARY", 1), MARCH("MARCH", 2), APRIL(
			"APRIL", 3), MAY("MAY", 4), JUNE("JUNE", 5), JULY("JULY", 6), AUGUST(
			"AUGUST", 7), SEPTEMBER("SEPTEMBER", 8), OCTOBER("OCTOBER", 9), NOVEMBER(
			"NOVEMBER", 10), DECEMBER("DECEMBER", 11);

	private final String text;
	private final int value;

	private Month(String text, int value) {
		this.text = text;
		this.value = value;
	}

	public String getLabel() {
		return text;
	}

	public int getValue() {
		return value;
	}

	public static Month valueOf(int value) {
		switch (value) {
		case 1:
			return FEBRUARY;
		case 2:
			return MARCH;
		case 3:
			return APRIL;
		case 4:
			return MAY;
		case 5:
			return JUNE;
		case 6:
			return JULY;
		case 7:
			return AUGUST;
		case 8:
			return SEPTEMBER;
		case 9:
			return OCTOBER;
		case 10:
			return NOVEMBER;
		case 11:
			return DECEMBER;
		default:
			return JANUARY;
		}
	}

	@Override
	public String toString() {
		return text;
	}
}
