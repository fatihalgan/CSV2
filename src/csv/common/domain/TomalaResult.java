package csv.common.domain;

public enum TomalaResult {
	
	Successful(0),
	IncorrectFormat(1),
	ServiceFailure(2),
	SenderIsNotGiro(3),
	RequestBelowMinValue(5),
	RequestAboveMaxValue(6),
	InsufficientCredit(7),
	DailyRequestLimitExceeded(8),
	RecipientIsNotGiro(9),
	TomalaToSelfNotAllowed(15),
	DailyAmountLimitExceeded(17),
	SenderInBlacklist(18),
	SpoofingTomalaRequest(19),
	RecipientInactive(20),
	RequestAmountLimitExceeded(21),
	RecipientTemporarilyBlocked(22),
	SwapError(-100);

	private Integer result;
	
	private TomalaResult(Integer result) {
		this.result = result;
	}
	
	public String getLabel() {
		switch (result) {
		case 0: return "Successful";
		case 1: return "Incorrect format";
		case 2: return "Service failure";
		case 3: return "Sender is not a Giro subscriber";
		case 5: return "Request below minumum value";
		case 6: return "Request greater than maximum value";
		case 7: return "Insufficient credit";
		case 8: return "Exceeded maximum daily swaps limit of 5";
		case 9: return "Recipient is not a Giro customer";
		case 15: return "Self credit not allowed";
		case 17: return "Postpaid period total of 1 500 MT exceeded";
		case 18: return "Sender is in Blacklist";
		case 19: return "Cannot make Tomala more than once within 1 minute";
		case 20: return "Recipient is inactive";
		case 21: return "Request greater than 1000 (Old currency)";
		case 22: return "Recipient temporarily blocked";
		case -100: return "Tomala Error - Credits were taken from sender, but could not be delivered to receiver";
		default: return "Unknown status, or not yet processed";
		}
	}
	
	public Integer getValue() {
		return result;
	}
	
	public String toString() {
		return getLabel();
	}
	
	public static TomalaResult factory(Integer val) {
		if(val == null) return null;
		TomalaResult[] vals = TomalaResult.values();
		for(TomalaResult i : vals) {
			if(i.getValue().equals(val)) return i;
		}
		return null;
	}
}
