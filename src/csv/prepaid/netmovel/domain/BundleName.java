package csv.prepaid.netmovel.domain;

import java.util.ArrayList;

public enum BundleName {

	NTDIA("NTDIA"),
	NTSEMANA("NTSEMANA"),
	NTMES1("NTMES1"),
	NTMES3("NTMES3"),
	NTMES5("NTMES5"),
	NTMES10("NTMES10"),
	DUO500("DUO500"),
	DUO1000("DUO1000"),
	DUO1500("DUO1500"),
	DUO2400("DUO2400"),
	V5MB1("5MB1"),
	V10MB("10MB"),
	V10MB1("10MB1"),
	V30MB("30MB"),
	V30MB1("30MB1"),
	V50MB("50MB"),
	V50MB1("50MB1"),
	V100MB("100MB"),
	V100MB1("100MB1"),
	V250MB1("250MB1"),
	V250MB7("250MB7"),
	V250MB30("250MB30"),
	V500MB7("500MB7"),
	V500MB("500MB"),
	V1GB("1GB"),
	V1GB7("1GB7"),
	V3GB("3GB"),
	V3GB7("3GB7"),
	V5GB("5GB"),
	V10GB30("10GB30");
	
	private String bundleName;
	
	private BundleName(String bundleName) {
		this.bundleName = bundleName;
	}
	
	public String getLabel() {
		return bundleName;
	}
	
	public String getValue() {
		return bundleName;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static BundleName factory(String val) {
		if(val == null) return null;
		BundleName[] vals = BundleName.values();
		for(BundleName i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
	
	public static BundleName[] NetmovelPrepagoValues() {
		ArrayList<BundleName> list = new ArrayList<BundleName>();
		BundleName[] allNames = BundleName.values();
		for(BundleName i : allNames) {
			if(i.getValue().startsWith("NT")) list.add(i);
		}
		return list.toArray(new BundleName[list.size()]);
	}
	
	public static BundleName[] NetDuoValues() {
		ArrayList<BundleName> list = new ArrayList<BundleName>();
		BundleName[] allNames = BundleName.values();
		for(BundleName i : allNames) {
			if(i.getValue().startsWith("DUO")) list.add(i);
		}
		return list.toArray(new BundleName[list.size()]);
	}
	
	public static BundleName[] VoiceAddOnValues() {
		ArrayList<BundleName> list = new ArrayList<BundleName>();
		BundleName[] allNames = BundleName.values();
		for(BundleName i : allNames) {
			if(i.getLabel().startsWith("5") || i.getLabel().startsWith("10") || i.getLabel().startsWith("30") ||
					i.getLabel().startsWith("50") || i.getLabel().startsWith("100") || i.getLabel().startsWith("250")
					|| i.getLabel().startsWith("500") || i.getLabel().startsWith("1GB") || i.getLabel().startsWith("3GB")
					|| i.getLabel().startsWith("5GB") || i.getLabel().startsWith("10GB")) list.add(i);
		}
		return list.toArray(new BundleName[list.size()]);
	}
}
