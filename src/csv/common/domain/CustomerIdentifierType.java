package csv.common.domain;

public enum CustomerIdentifierType {
	
	MSISDN("MSISDN"),
	CustomerCode("CustomerCode");
	
	private String type;
	
	private CustomerIdentifierType(String type) {
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
	
	public static CustomerIdentifierType factory(String type) {
		if(type.equals("MSISDN")) return MSISDN;
		else if(type.equals("CustomerCode")) return CustomerCode;
		else return null;
	}
}
