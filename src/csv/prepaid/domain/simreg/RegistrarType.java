package csv.prepaid.domain.simreg;

public enum RegistrarType {

	PERSONAL("PERSONAL"),
	COMPANY("COMPANY"),
	TESTEMUNHA("TESTEMUNHA");
	
	private String type;
	
	private RegistrarType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		if(type.equals("PERSONAL")) return "PERSONAL";
		if(type.equals("COMPANY")) return "COMPANY";
		if(type.equals("TESTEMUNHA")) return "TESTEMUNHA";
		return null;
	}
	
	public String getValue() {
		return type;
	}
	
	public String toString() {
		return getValue();
	}
	
	public static RegistrarType factory(String type) {
		if(type.equals("PERSONAL")) return PERSONAL;
		if(type.equals("COMPANY")) return COMPANY;
		if(type.equals("TESTEMUNHA")) return TESTEMUNHA;
		return null; 
	}
}
