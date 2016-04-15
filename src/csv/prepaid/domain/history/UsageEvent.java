package csv.prepaid.domain.history;

public class UsageEvent extends AbstractAccountEvent {

	private String teleServiceName;
	private String serviceProviderId;
	private Float usageAmount;
	private String calledNumber;
	private String calledCountry;
	private Integer duration;
	private Integer dedicatedAccountId;
	private Float dedicatedAccountBeforeCall;
	private Float dedicatedAccountAfterCall;
	private String trafficDirection;
	private String categoryName;
	private String locationNumber;
	
	
	public UsageEvent() {
		super();
	}

	public String getTeleServiceName() {
		return teleServiceName;
	}

	public void setTeleServiceName(String teleServiceName) {
		this.teleServiceName = teleServiceName;
	}

	public Float getUsageAmount() {
		return usageAmount;
	}

	public void setUsageAmount(Float usageAmount) {
		this.usageAmount = usageAmount;
	}

	public String getCalledNumber() {
		return calledNumber;
	}

	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}

	public String getCalledCountry() {
		return calledCountry;
	}

	public void setCalledCountry(String calledCountry) {
		this.calledCountry = calledCountry;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getDedicatedAccountId() {
		return dedicatedAccountId;
	}

	public void setDedicatedAccountId(Integer dedicatedAccountId) {
		this.dedicatedAccountId = dedicatedAccountId;
	}

	public Float getDedicatedAccountBeforeCall() {
		return dedicatedAccountBeforeCall;
	}

	public void setDedicatedAccountBeforeCall(Float dedicatedAccountBeforeCall) {
		this.dedicatedAccountBeforeCall = dedicatedAccountBeforeCall;
	}

	public Float getDedicatedAccountAfterCall() {
		return dedicatedAccountAfterCall;
	}

	public void setDedicatedAccountAfterCall(Float dedicatedAccountAfterCall) {
		this.dedicatedAccountAfterCall = dedicatedAccountAfterCall;
	}

	public String getTrafficDirection() {
		return trafficDirection;
	}

	public void setTrafficDirection(String trafficDirection) {
		this.trafficDirection = trafficDirection;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getLocationNumber() {
		return locationNumber;
	}

	public void setLocationNumber(String locationNumber) {
		this.locationNumber = locationNumber;
	}

	@Override
	public String getEventDescription() {
		if(teleServiceName.equals("Content"))
			return getServiceProviderDescription();
		else if(teleServiceName.equals("ExtensionTSC6")) return "SMS Roaming";
		else return teleServiceName;
	}

	@Override
	public String getEventType() {
		return "UsageEvent";
	}
	
	public Float getBalanceBefore() {
		return balanceBefore;
	}
	
	public void setBalanceBefore(Float balanceBefore) {
		this.balanceBefore = balanceBefore;
	}
	
	public Float getBalanceAfter() {
		return balanceAfter;
	}
	
	public void setBalanceAfter(Float balanceAfter) {
		this.balanceAfter = balanceAfter;
	}
	
	public String getServiceProviderId() {
		return serviceProviderId;
	}

	public void setServiceProviderId(String serviceProviderId) {
		this.serviceProviderId = serviceProviderId;
	}
	
	public String getCashAccountName() {
		if(dedicatedAccountId == null) return null;
		if(dedicatedAccountId == 1) return "SMS";
		if(dedicatedAccountId == 2) return "MMS";
		if(dedicatedAccountId == 3) return "Netmovel Bundle Account";
		else return "Dedicated Account " + dedicatedAccountId;
	}
	
	private String getServiceProviderDescription() {
		if(serviceProviderId == null) return "GPRS";
		else if(serviceProviderId.equals("5555")) return "RingBackTone";
		else if(serviceProviderId.equals("1000")) return "SMS GW - Content";
		else if(serviceProviderId.equals("3333")) return "MMS";
		else if(serviceProviderId.equals("510")) return "Diameter SMS";
		else if(serviceProviderId.equals("1010")) return "SMS GW - VASP";
		return "Content";
	}
	
	
}
