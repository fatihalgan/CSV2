package csv.postpaid.domain;

import java.io.Serializable;

public class DirectoryNumber implements Serializable {

	private static final long serialVersionUID = 4116669727033745333L;
	
	private String service;
	private String profile;
	private String resourceType;
	private String resourceNo;
	private String numberingPlan;
	private String mainDirectoryNumber;
	
	public DirectoryNumber() {
		super();
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceNo() {
		return resourceNo;
	}

	public void setResourceNo(String resourceNo) {
		this.resourceNo = resourceNo;
	}

	public String getNumberingPlan() {
		return numberingPlan;
	}

	public void setNumberingPlan(String numberingPlan) {
		this.numberingPlan = numberingPlan;
	}

	public String getMainDirectoryNumber() {
		return mainDirectoryNumber;
	}

	public void setMainDirectoryNumber(String mainDirectoryNumber) {
		this.mainDirectoryNumber = mainDirectoryNumber;
	}
}
