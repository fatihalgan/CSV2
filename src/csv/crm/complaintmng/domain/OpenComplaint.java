package csv.crm.complaintmng.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import csv.common.domain.SubscriptionType;

public class OpenComplaint implements Serializable {

	private static final long serialVersionUID = 1516262019494312614L;
	
	private Long complaintId;
	private String description;
	private String enteredBy;
	private Date openingDate;
	private String assignedTo;
	private String assignedToUser;
	private String customerMsisdn;
	private String customerCode;
	private String customerContactNumber;
	private String customerName;
	private String companyName;
	private ComplaintStatus status;
	private ComplaintPhase phase;
	private SubscriptionType subscriptionType;
	private String province;
	private String district;
	private String destinationNumber;
	private Date dateOfOccurence;
	private String displayInfo;
	private String attendanceRemark;
	
	private ComplaintSegment segment;
	
	
	private List<OpenComplaintIteration> iterations = new ArrayList<OpenComplaintIteration>();
	
	public OpenComplaint() {
		super();
	}

	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public String getCustomerMsisdn() {
		return customerMsisdn;
	}

	public void setCustomerMsisdn(String customerMsisdn) {
		this.customerMsisdn = customerMsisdn;
	}

	public String getCustomerContactNumber() {
		return customerContactNumber;
	}

	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public ComplaintStatus getStatus() {
		return status;
	}

	public void setStatus(ComplaintStatus status) {
		this.status = status;
	}
	
	public ComplaintPhase getPhase() {
		return phase;
	}

	public void setPhase(ComplaintPhase phase) {
		this.phase = phase;
	}
	
	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
	public String getAssignedToUser() {
		return assignedToUser;
	}

	public void setAssignedToUser(String assignedToUser) {
		this.assignedToUser = assignedToUser;
	}

	public SubscriptionType getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(SubscriptionType subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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
	
	public String getAttendanceRemark() {
		return attendanceRemark;
	}

	public void setAttendanceRemark(String attendanceRemark) {
		this.attendanceRemark = attendanceRemark;
	}
	
	public ComplaintSegment getSegment() {
		return segment;
	}

	public void setSegment(ComplaintSegment segment) {
		this.segment = segment;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof OpenComplaint))
			return false;
		OpenComplaint castOther = (OpenComplaint) other;
		return new EqualsBuilder().append(
				enteredBy, castOther.enteredBy).append(openingDate,
				castOther.openingDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(661498167, -811329329)
				.append(enteredBy).append(openingDate).toHashCode();
	}

	public List<OpenComplaintIteration> getIterations() {
		return iterations;
	}

	public void setIterations(List<OpenComplaintIteration> iterations) {
		this.iterations = iterations;
	}
	
	public void addComplaintIteration(OpenComplaintIteration iteration) {
		iterations.add(iteration);
		iteration.setOwningComplaint(this);
	}
	
	public void addComplaintIteration(String userEmail, String comment) {
		OpenComplaintIteration iteration = new OpenComplaintIteration();
		iteration.setEnteredBy(userEmail);
		iteration.setEnteredOn(new Date());
		iteration.setComment(comment);
		iteration.setOwningComplaint(this);
		iterations.add(iteration);
		setAttendanceRemark(null);
	}
	
	public OpenComplaintIteration getCurrentIteration() {
		if(getIterations().size() == 0) return null;
		return getIterations().get(getIterations().size() - 1);
	}
	
	public boolean isFinalized() {
		if(status.equals(ComplaintStatus.OPEN)) return false;
		if(status.equals(ComplaintStatus.DECLINED)) return true;
		if(status.equals(ComplaintStatus.RESOLVED)) return true;
		return false;
	}
	
	public boolean isCustomerFeedback() {
		if(phase.equals(ComplaintPhase.CUSTOMER_FEEDBACK)) return true;
		return false;
	}
	
	public boolean isOutboundSupport() {
		if(phase.equals(ComplaintPhase.OUTBOUND_SUPPORT)) return true;
		return false;
	}
	
	public boolean isSupervisorFeedback() {
		if(phase.equals(ComplaintPhase.SUPERVISOR_FEEDBACK)) return true;
		return false;
	}
	
	public boolean isHelpDesk() {
		if(phase.equals(ComplaintPhase.HELP_DESK)) return true;
		return false;
	}
	
	public boolean isAccountManager() {
		if(phase.equals(ComplaintPhase.ACCOUNT_MANAGER)) return true;
		return false;
	}
	
	public boolean isTechnicalDepartmentSupport() {
		if(phase.equals(ComplaintPhase.TECHNICAL_DEPARTMENT_SUPPORT)) return true;
		return false;
	}
	
	public boolean isCloseWithoutFeedback() {
		if(phase.equals(ComplaintPhase.CLOSE_WITHOUT_FEEDBACK)) return true;
		return false;
	}
	
	public String getHelpDeskGroupName() {
		if(customerCode != null && companyName != null) return "Postpaid Help Desk";
		else if(subscriptionType.equals(SubscriptionType.Postpaid)) return "Postpaid Help Desk";
		else if(subscriptionType.equals(SubscriptionType.Prepaid)) return "CC Agents Help Desk";
		return null;
	}
	
	public String getSupervisorGroupName() {
		if(customerCode != null && companyName != null) return "Business Support Supervisor";
		else if(subscriptionType.equals(SubscriptionType.Postpaid)) return "Business Support Supervisor";
		else if(subscriptionType.equals(SubscriptionType.Prepaid)) return "Customer Care Department Leader";
		return null;
	}
	
	public String getCustomerFeedbackGroupName() {
		return "CC Customer Feedback";
	}
	
	public boolean isCorporate() {
		if(companyName == null) return false;
		else return true;
	}
}
