package csv.crm.complaintmng.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import csv.common.domain.District;
import csv.common.domain.Province;
import csv.security.domain.User;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Complaint implements Serializable, Comparable<Complaint> {

	private static final long serialVersionUID = 2216055896753259623L;
	
	private Long id;
	private ComplaintSegment segment;
	private String description;
	private User creator;
	private Date openingDate;
	private Date closingDate;
	private ComplaintStatus status;
	private String destinationNumber;
	private District location;
	private Date dateOfOccurence;
	private String displayInfo;
	
	private IComplaintOwner owner;
	
	private Set<ComplaintAttachment> attachments = new HashSet<ComplaintAttachment>();
	
	public Complaint() {
		super();
		setOpeningDate(new Date());
		setClosingDate(null);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ComplaintSegment getSegment() {
		return segment;
	}

	public void setSegment(ComplaintSegment segment) {
		this.segment = segment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
	
	private void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public IComplaintOwner getOwner() {
		return owner;
	}

	public void setOwner(IComplaintOwner owner) {
		this.owner = owner;
	}
	
	public ComplaintStatus getStatus() {
		return status;
	}
	
	public District getLocation() {
		return location;
	}

	public void setLocation(District location) {
		this.location = location;
	}
	
	public String getDestinationNumber() {
		return destinationNumber;
	}

	public void setDestinationNumber(String destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

	public Date getDateOfOccurence() {
		return dateOfOccurence;
	}

	public void setDateOfOccurence(Date dateOfOccurence) {
		this.dateOfOccurence = dateOfOccurence;
	}

	public String getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(String displayInfo) {
		this.displayInfo = displayInfo;
	}
	
	public void setStatus(ComplaintStatus status) {
		this.status = status;
	}
	
	public Set<ComplaintAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<ComplaintAttachment> attachments) {
		this.attachments = attachments;
	}
	
	public void addComplaintAttachment(ComplaintAttachment attachment) {
		this.attachments.add(attachment);
		attachment.setOwningComplaint(this);
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Complaint))
			return false;
		Complaint castOther = (Complaint) other;
		return new EqualsBuilder().append(creator, castOther.creator).append(
				openingDate, castOther.openingDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1593492501, -1687642971).append(creator)
				.append(openingDate).toHashCode();
	}

	@Override
	public int compareTo(Complaint o) {
		return o.openingDate.compareTo(this.openingDate);
	}
	
	public OpenComplaint openComplaint() {
		OpenComplaint comp = new OpenComplaint();
		comp.setComplaintId(getId());
		comp.setCustomerContactNumber(getOwner().getContactNumber());
		comp.setCustomerMsisdn(getOwner().getCustomerIdentifier());
		comp.setCustomerName(getOwner().getName());
		comp.setDescription(getDescription());
		comp.setEnteredBy(getCreator().getEmail());
		comp.setOpeningDate(getOpeningDate());
		comp.setStatus(ComplaintStatus.OPEN);
		comp.setSubscriptionType(getOwner().getSubscriptionType());
		comp.setProvince(getLocation().getOwningProvince().getName());
		comp.setDateOfOccurence(getDateOfOccurence());
		comp.setDestinationNumber(getDestinationNumber());
		comp.setDisplayInfo(getDisplayInfo());
		comp.setDistrict(getLocation().getName());
		comp.setSegment(getSegment());
		if(getOwner().getOwnerType().equals("Corporate")) {
			comp.setCompanyName(((CorporateComplaintOwner)getOwner()).getCompany().getCompanyName());
			comp.setCustomerCode(((CorporateComplaintOwner)getOwner()).getCompany().getCustomerCode());
		}
		return comp;
	}
	
	public String getComplaintRaisedEventName() {
		if(owner instanceof PersonalComplaintOwner) return "newComplaintOpened";
		else if(owner instanceof CorporateComplaintOwner) return "newCorporateComplaintOpened";
		return null;
	}
}
