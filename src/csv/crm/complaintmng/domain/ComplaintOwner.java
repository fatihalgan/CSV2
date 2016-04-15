package csv.crm.complaintmng.domain;

import java.util.Set;
import java.util.TreeSet;

import csv.common.domain.SubscriptionType;

public abstract class ComplaintOwner implements IComplaintOwner {

	protected Long id;
	protected String contactNumber;
	protected String firstName;
	protected String lastName;
	protected String msisdn;
	protected SubscriptionType subscriptionType;
	
	protected Set<Complaint> complaints = new TreeSet<Complaint>();
	
	public ComplaintOwner() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public Set<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(Set<Complaint> complaints) {
		this.complaints = complaints;
	}
	
	public void addComplaint(Complaint c) {
		this.getComplaints().add(c);
		c.setOwner(this);
	}

	@Override
	public String getName() {
		String name = null;
		if(firstName != null) name = firstName;
		if(lastName != null) name += " " + lastName;
		return name;
	}
	
}
