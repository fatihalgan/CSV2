package csv.prepaid.domain;

public enum LoyaltyTransactionType {

	Gain(1),
	Spend(2);
	
	private int type;
	
	private LoyaltyTransactionType(int type) {
		this.type = type;
	}
	
	public String getLabel() {
		if(type == 1) return "Gain";
		if(type == 2) return "Spend";
		return null;
	}
	
	public int getValue() {
		return type;
	}
	
	public String toString() {
		return String.valueOf(type);
	}
	
	public static LoyaltyTransactionType factory(int type) {
		if(type == 1) return Gain;
		else if(type == 2) return Spend;
		else return null;
	}
}
