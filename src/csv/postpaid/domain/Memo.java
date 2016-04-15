package csv.postpaid.domain;

import java.io.Serializable;
import java.util.Date;

public class Memo implements Serializable {

	private Integer code;
	private String contractCode;
	private String type;
	private String status;
	private String shortDescription;
	private Integer priority;
	private Date deadLine;
	private Date createdOn;
	private String longDescription;
	private String createdBy;
	private String closedBy;
	private Date closedOn;
	private String modifiedBy;
	private Date modifiedOn;
	private String ccUser1;
	private String ccUser2;
	private String ccUser3;
	private Integer followUpType;
	private String followUpUser;
	
	public Memo() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(String closedBy) {
		this.closedBy = closedBy;
	}

	public Date getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(Date closedOn) {
		this.closedOn = closedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getCcUser1() {
		return ccUser1;
	}

	public void setCcUser1(String ccUser1) {
		this.ccUser1 = ccUser1;
	}

	public String getCcUser2() {
		return ccUser2;
	}

	public void setCcUser2(String ccUser2) {
		this.ccUser2 = ccUser2;
	}

	public String getCcUser3() {
		return ccUser3;
	}

	public void setCcUser3(String ccUser3) {
		this.ccUser3 = ccUser3;
	}

	public Integer getFollowUpType() {
		return followUpType;
	}

	public void setFollowUpType(Integer followUpType) {
		this.followUpType = followUpType;
	}

	public String getFollowUpUser() {
		return followUpUser;
	}

	public void setFollowUpUser(String followUpUser) {
		this.followUpUser = followUpUser;
	}
	
	
}
