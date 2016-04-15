package csv.prepaid.domain.simreg;

public enum IdentityDocType {
	
	BI("01"),
	PASSPORT("02"),
	CARTAO_ELEITOR("03"),
	BIRTH_CERT("04"),
	DRIV_LICEN("05"),
	DIRE("06"),
	ANTIGO_COMBAT("07"),
	DESMOBILIZADO("08"),
	MARRIAGE_CERT("09"),
	REFUGIADO("10");
	
	private String type;
	
	private IdentityDocType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		if(type.equals("01")) return "BI";
		if(type.equals("02")) return "Passaporte";
		if(type.equals("03")) return "Cartao de Eleitor";
		if(type.equals("04")) return "Certidao de Nascimento";
		if(type.equals("05")) return "Carta de Conducao";
		if(type.equals("06")) return "Dire";
		if(type.equals("07")) return "Cartao de Antigo Combatente";
		if(type.equals("08")) return "Cartao de Desmobilizado";
		if(type.equals("09")) return "Certidao de Casamento";
		if(type.equals("10")) return "Identificacao de Refugiado";
		return null;
	}
	
	public String getValue() {
		return type;
	}
	
	public String toString() {
		return getValue();
	}
	
	public static IdentityDocType factory(String type) {
		if(type.equals("01")) return BI;
		if(type.equals("02")) return PASSPORT;
		if(type.equals("03")) return CARTAO_ELEITOR;
		if(type.equals("04")) return BIRTH_CERT;
		if(type.equals("05")) return DRIV_LICEN;
		if(type.equals("06")) return DIRE;
		if(type.equals("07")) return ANTIGO_COMBAT;
		if(type.equals("08")) return DESMOBILIZADO;
		if(type.equals("09")) return MARRIAGE_CERT;
		if(type.equals("10")) return REFUGIADO;
		return null;
	}
	
}
