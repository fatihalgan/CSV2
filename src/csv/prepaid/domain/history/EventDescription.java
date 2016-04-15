package csv.prepaid.domain.history;

public enum EventDescription {

	All("All"),
	Voice("Voice"),
	SMS("SMS"),
	YOYOBonus("YOYO Bonus"),
	AnniversaryBonus("Anniversary Bonus"),
	Tomala("Tomala"),
	IncomingCallBonus("Incoming Call Bonus"),
	DUOAdjustment("DUO Adjustment"),
	MINSATAdjustment("MINSAT Adjustment"),
	AccountActivation("Account Activation"),
	Refill("Refill"),
	TariffChange("Tariff Change"),
	IVRCall("IVR Call"),
	BatchAdjustment("Batch Adjustment"),
	AdjustmentfromCSV("Adjustment from CSV"),
	VoucherRefillFromCSV("Voucher Refill From CSV"),
	TUMRecharge("TUM Recharge"),
	Netmovel("Netmovel"),
	NetGiro("NetGiro"),
	BB4PReservation("BB4P Reservation"),
	MINSATEvent("MINSAT Event"),
	SDPEvent("SDP Event"),
	Adjustment(" Adjustment"),
	UnknownEvent("Unknown Event"),
	VoucherRefillError("Voucher Refill Error"),
	Unrecognized("Unrecognized"),
	UnknownType("Unknown type"),
	Error("Error"),
	//Others("Others"),
	;
	
	private final String text;		
	
	private EventDescription(String text){
		this.text = text;
	}
	
	public String getLabel() {
		return text;
	}
	
	@Override
	public String toString() {
		return text;
	}
	
}
