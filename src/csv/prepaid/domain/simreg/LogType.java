package csv.prepaid.domain.simreg;

import java.text.SimpleDateFormat;

public enum LogType {

	NewRegistration("NEWREGISTRATION"),
	AddFirstCell("ADDFIRSTCELL"),
	AddNextCell("ADDNEXTCELL");
	
	private String type;
	
	private LogType(String type) {
		this.type = type;
	}
	
	public String getLabel() {
		if(type.equals("NEWREGISTRATION")) return "New Registration";
		if(type.equals("ADDFIRSTCELL")) return "Register First Cell";
		if(type.equals("ADDNEXTCELL")) return "Register Additional Cell";
		return null;
	}
		
	public String getValue() {
		return type;
	}
	
	public String toString() {
		return getValue();
	}
	
	public static LogType factory(String type) {
		if(type.equals("NEWREGISTRATION")) return NewRegistration;
		else if(type.equals("ADDFIRSTCELL")) return AddFirstCell;
		else if(type.equals("ADDNEXTCELL")) return AddNextCell;
		else return null;
	}
	
	public String getLogDetail(AbstractRegistrar registrar, Subscription subscription) {
		String retVal = "";
		if(type.equals("NEWREGISTRATION")) {
			retVal = retVal + "DOC=" + registrar.getIdentityDocument().getDocumentNo() + ",";
			retVal = retVal + "NAME=" + registrar.getName() + ",";
			retVal = retVal + "SURNAME=" + registrar.getSurname() + ",";
			SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
			retVal = retVal + "BIRTH_DATE=" + dFormat.format(registrar.getBirthDate()); 
		} else if(type.equals("ADDFIRSTCELL")) {
			retVal = retVal + "CELL=" + subscription.getMsisdn() + ",";
			retVal = retVal + "SIM=" + (subscription.getSim() == null ? "" : subscription.getSim()) + ",";
			retVal = retVal + "IMSI=" + (subscription.getImsi() == null ? "Not Entered" : subscription.getImsi());
		} else if(type.equals("ADDNEXTCELL")) {
			retVal = retVal + "CELL=" + subscription.getMsisdn() + ",";
			retVal = retVal + "SIM=" + (subscription.getSim() == null ? "" : subscription.getSim()) + ",";
			retVal = retVal + "IMSI=" + (subscription.getImsi() == null ? "Not Entered" : subscription.getImsi());
		}
		return retVal;
	}
}
