package csv.security.domain;

public enum OperationNames {
	FindCustomerInformation("Find Customer Information"),
	PrepaidAccountHistory("Prepaid Account History"),
	ViewPrepaidRegistration("View Prepaid Registration"),
	PrepaidSIMActivation("Prepaid SIM Activation"),
	PrepaidAdjustmentTakeCredits("Prepaid Adjustment-Take Back Credits"),
	PrepaidAdjustmentGiveCredits("Prepaid Adjustment-Give Credits"),
	RetrieveLoyaltyInfo("Retrieve Loyalty Info"),
	RefillVoucher("Refill Voucher"),
	BlackBerryForPrepaid("BlackBerry For Prepaid"),
	NetmovelPrepago("Netmovel Prepago"),
	NetmovelPrepagoUpdateActivation("Netmovel Prepago - Update Activation"),
	NetmovelDUO("Netmovel DUO"),
	NetmovelDUOUpdateActivation("Netmovel DUO - Update Activation"),
	NetmovelVoiceAddOn("Netmovel Voice Add On"),
	NetmovelVoiceAddOnUpdateActivation("Netmovel Voice Add On - Update Activation"),
	PrepaidSIMSwap("Prepaid SIM Swap"),
	PostpaidFindInvoiceDetail("Postpaid - Find Invoice Detail"),
	PostpaidSendInvoice("Postpaid - Send Invoice"),
	PostpaidCallView("Postpaid - Call History"),
	PostpaidContractEnquiry("Postpaid Contract Enquiry"),
	ViewPUK("View PUK"),
	Login("Login"),
	Logout("Logout"),
	EMAGetStatus("EMA Get Status"),
	EMAChangeStatus("EMA Change Status"),
	RetrieveTomalaStatus("Retrieve Tomala Status"),
	BlockTomala("Block Tomala"),
	UnBlockTomala("Un-Block Tomala"),
	FindIMEI("Find IMEI"),
	SendSMS("Send SMS"),
	FindFailedCalls("Find Failed Calls"),
	FindTomalaTransactions("Find Tomala Transactions"),
	ViewNotepad("View Notepad"),
	AddNote("Add Note"),
	VoiceMailService("Voice Mail Service"),
	SmsManage("Sms Manage"),
	MMS_GPRSSettings("MMS/GPRS Settings"),
	ECDS("ECDS"),
	OperationStore("Operation Store"),
	MINSATChangeLanguage("MINSAT Change Language"),
	MINSATChangeServiceClass("MINSAT Change Service Class"),
	MINSATChangeFamilyandFriendsNumbers("MINSAT Change Family and Friends Numbers"),
	MINSATChangeExpiryDates("MINSAT Change Expiry Dates"),
	MINSATFindVoucherStatus("MINSAT Find Voucher Status"),
	UpdateVoucherState("Update Voucher State"),
	MINSATResetRefillBarringStatus("MINSAT Reset Refill Barring Status"),
	AuditUserActions("Audit User Actions"),
	ResetTelnet_DBConnection("Reset Telnet/DB Connection"),
	DailyAdjustmentReport("Daily Adjustments Report"),
	ViewOpenComplaints("View Open Complaints"),
	KillOpenComplaint("Kill Open Complaint"),
	ManageCorporateClients("Manage Corporate Clients"),
	EditUserDetails("Edit User Details");
	
	private final String text;

    private OperationNames(String text) {
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
