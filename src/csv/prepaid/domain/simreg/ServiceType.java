package csv.prepaid.domain.simreg;

public enum ServiceType {

	Voice("Voice"),
	Fax("Servico de fax"),
	Data("Data"),
	ERROR("ERROR");
	
	private String type;
	
	private ServiceType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		return type;
	}
	
	public String getValue() {
		return type;
	}
	
	public String toString() {
		return getValue();
	}
	
	public static ServiceType factory(String type) {
		if(type.equals("Voice")) return Voice;
		if(type.equals("Servico de fax")) return Fax;
		if(type.equals("Data")) return Data;
		if(type.equals("ERROR")) return ERROR;;
		return null;
	}
}
