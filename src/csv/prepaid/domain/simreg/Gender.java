package csv.prepaid.domain.simreg;

public enum Gender {

	Male("M"),
	Female("F");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	public String getLabel() {
		if(gender.equals("M")) return "Male";
		if(gender.equals("F")) return "Female";
		return null;
	}
	
	public String getValue() {
		return gender;
	}
	
	public String toString() {
		return getValue();
	}
	
	public static Gender factory(String gender) {
		if(gender.equals("M")) return Male;
		else if(gender.equals("F")) return Female;
		else return null;
	}
}
