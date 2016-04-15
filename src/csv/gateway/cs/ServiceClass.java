package csv.gateway.cs;

public enum ServiceClass {

	GiroPerMinute(1),
	GiroPerSecond(2),
	TurboGiro(3),
	Duo(4),
	PacoteInitial(5),
	Yoyo(6),
	VPN(7),
	NewGiroPerSecond(8),
	NewPacoteInitial(9),
	FamaV100(10),
	DuoEmpresas(11),
	CabinesGiros(12),
	FAFTest(13),
	NetmovelTurboDUO(14),
	V50(15),
	V80(16),
	V100(17),
	V600(18),
	V2M(19),
	MPLN(20),
	V300(22),
	V150(23),
	NewV2M(24),
	STAE(25),
	EDGE(26),
	TurboG10FaF(28),
	CelltrackCartaoDados(29),
	V100_300_S_De_Borla_Dia(30),
	NetmovelPrepago(31),
	NetmovelPrepagoBundle(34),
	DuoFaF(35),
	V300_Free_Minutes(43),
	V600_Free_Minutes(44),
	V2M_Free_Minutes(45);
	
	private Integer sc;
	
	private ServiceClass(Integer sc) {
		this.sc = sc;
	}
	
	public String getLabel() {
		if(sc == 1) return "Giro Per Minute";
		else if(sc == 2) return "Giro Per Second";
		else if(sc == 3) return "Turbo Giro";
		else if(sc == 4) return "Duo";
		else if(sc == 5) return "Pacote Initial";
		else if(sc == 6) return "Yoyo";
		else if(sc == 7) return "VPN";
		else if(sc == 8) return "New Giro Per Second";
		else if(sc == 9) return "New Pacote Initial";
		else if(sc == 10) return "Fama V100";
		else if(sc == 11) return "Duo Empresas";
		else if(sc == 12) return "Cabines Giros";
		else if(sc == 13) return "FAF Test";
		else if(sc == 14) return "Netmovel Turbo DUO";
		else if(sc == 15) return "V50";
		else if(sc == 16) return "V80";
		else if(sc == 17) return "V100";
		else if(sc == 18) return "V600";
		else if(sc == 19) return "V2M";
		else if(sc == 20) return "MPLN";
		else if(sc == 22) return "Giro De 300(V300)";
		else if(sc == 23) return "V150";
		else if(sc == 24) return "New V2M";
		else if(sc == 25) return "STAE";
		else if(sc == 26) return "EDGE";
		else if(sc == 28) return "TurboG 10 FaF";
		else if(sc == 29) return "Celltrack Cartao Dados";
		else if(sc == 30) return "V100 300 S de Borla/dia";
		else if(sc == 31) return "Netmovel Prepago";
		else if(sc == 34) return "Netmovel Prepago Bundle";
		else if(sc == 35) return "DUO FaF";
		else if(sc == 43) return "V300 Free Minutes";
		else if(sc == 44) return "V600 Free Minutes";
		else if(sc == 45) return "V2M Free Minutes";
		else return "";
	}
	
	public Integer getValue() {
		return sc;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static ServiceClass factory(Integer val) {
		if(val == null) return null;
		ServiceClass[] vals = ServiceClass.values();
		for(ServiceClass i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
	
	public static ServiceClass factory(String val) {
		if(val == null || val.length() == 0) return null;
		try {
			return ServiceClass.factory(Integer.parseInt(val));
		} catch(NumberFormatException ne) {
			return null;
		}
	}
}
