package csv.roaming.domain;

public enum RoamingPriority {
	ZERO(0), ONE(1), TWO(2), THREE(3);
	private final int value;

	private RoamingPriority(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static RoamingPriority valueOf(int value) {

		switch (value) {
		case 1:
			return ONE;
		case 2:
			return TWO;
		case 3:
			return THREE;
		default:
			return ZERO;
		}

	}

	@Override
	public String toString() {
		return "" + value;
	}
}
