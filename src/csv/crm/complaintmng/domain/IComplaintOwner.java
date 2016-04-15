package csv.crm.complaintmng.domain;

import csv.common.domain.SubscriptionType;

public interface IComplaintOwner {

	public Long getId();
	public void setId(Long id);
	public String getCustomerIdentifier();
	public SubscriptionType getSubscriptionType();
	public void setSubscriptionType(SubscriptionType subscriptionType);
	public String getContactNumber();
	public void setContactNumber(String contactNumber);
	public String getName();
	public String getOwnerType();
	
}
