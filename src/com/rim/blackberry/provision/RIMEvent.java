package com.rim.blackberry.provision;

import java.io.Serializable;
import java.util.Date;

public class RIMEvent implements Serializable {

	private Long id;
	private String msisdn;
	private String imsi;
	private String oldImsi;
	private Date entryDate;
	private String serviceName;
	private String serviceStatus;
	private String newActivation;
	private String simSwap;
	private String newService;
	private String newServiceStatus;
	private Date insertionDate;
	private String action;
	private String resultCode;
	private String resultDescription;
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDescription() {
		return resultDescription;
	}

	public void setResultDescription(String resultDescription) {
		if(resultDescription != null && resultDescription.length() > 255) this.resultDescription = resultDescription.substring(0, 255);
		this.resultDescription = resultDescription;
	}

	public RIMEvent() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getNewActivation() {
		return newActivation;
	}

	public void setNewActivation(String newActivation) {
		this.newActivation = newActivation;
	}

	public String getSimSwap() {
		return simSwap;
	}

	public void setSimSwap(String simSwap) {
		this.simSwap = simSwap;
	}

	public String getNewService() {
		return newService;
	}

	public void setNewService(String newService) {
		this.newService = newService;
	}

	public String getNewServiceStatus() {
		return newServiceStatus;
	}

	public void setNewServiceStatus(String newServiceStatus) {
		this.newServiceStatus = newServiceStatus;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof RIMEvent)) {
			return false;
		}
		RIMEvent other = (RIMEvent) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	
	public String getOldImsi() {
		return oldImsi;
	}

	public void setOldImsi(String oldImsi) {
		this.oldImsi = oldImsi;
	}

	public RIMEventType getEventType() {
		if((simSwap != null) && (simSwap.equals("X"))) return RIMEventType.ModifySIM;
		if((newActivation != null) && (newActivation.equals("X")) && (serviceStatus != null) && (serviceStatus.equals("A"))) return RIMEventType.Activation;
		if((newActivation == null) && (serviceStatus != null) && (serviceStatus.equals("A")) && (newServiceStatus != null) && (newServiceStatus.equals("X"))) return RIMEventType.Resume;
		if((serviceStatus != null) && (serviceStatus.equals("D")) && (newServiceStatus != null) && (newServiceStatus.equals("X"))) return RIMEventType.Deactivation;
		if((serviceStatus != null) && (serviceStatus.equals("S")) && (newServiceStatus != null) && (newServiceStatus.equals("X"))) return RIMEventType.Suspend;
		if(newService != null) return RIMEventType.ModifyService;
		return null;
	}
	
	
}
