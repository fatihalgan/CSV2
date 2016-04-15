package csv.gateway.cs;

public enum Language {

	Portuguese(1),
	English(2);
	
	private Integer language;
	
	private Language(Integer language) {
		this.language = language;
	}
	
	public String getLabel() {
		if(language == 1) return "Portuguese";
		else if(language == 2) return "English";
		return "";
	}
	
	public Integer getValue() {
		return language;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static Language factory(Integer val) {
		if(val == null) return null;
		Language[] vals = Language.values();
		for(Language i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
	
	public static Language factory(String val) {
		if(val.trim().equals("Portuguese")) return Language.Portuguese;
		else if(val.trim().equals("English")) return Language.English;
		else return null;
	}
}
