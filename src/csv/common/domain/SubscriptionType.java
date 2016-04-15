package csv.common.domain;

public enum SubscriptionType {

	Prepaid("Prepago"),
	Postpaid("Pospago");
	
	private String type;
	
	private SubscriptionType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		return type;
	}
	
	public String getValue() {
		return type;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static SubscriptionType factory(String type) {
		if(type.equals("Prepago")) return Prepaid;
		else if(type.equals("Pospago")) return Postpaid;
		else return null;
	}
}
