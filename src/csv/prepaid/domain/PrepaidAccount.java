package csv.prepaid.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.bridge.arete.minsat.model.Accumulator;
import com.bridge.arete.minsat.model.HLRBlockingStatus;
import csv.gateway.cs.DedicatedAccount;
import csv.gateway.cs.FaFInfo;
import csv.gateway.cs.Language;
import csv.gateway.cs.ServiceClass;

public class PrepaidAccount implements Serializable {

	public static final int SMS_DEDICATED_ACCOUNT_NUMBER = 1;
	public static final int MMS_DEDICATED_ACCOUNT_NUMBER = 2;
	public static final int FREE_CALLS_DEDICATED_ACCOUNT_NUMBER = 3;
	
	private Language currentLanguage;
	private ServiceClass originServiceClass;
	private Float mainAccountBalance;
	private ServiceClass currentServiceClass;
	private boolean temporaryBlockedFlag;
	private Date serviceFeeDate;
	private Date supervisionDate;
	private Date activationDate;
	private String status;
	private HLRBlockingStatus hlrBlockingStatus;
	private Date refillUnbarDate;
	
	private List<DedicatedAccount> dedicatedAccounts = new ArrayList<DedicatedAccount>();
	private List<Community> communityList;
	private List<Accumulator> accumulators;
	
	
	private FaFInfo fafInfo;
	
	public PrepaidAccount() {
		super();
	}

	public Language getCurrentLanguage() {
		return currentLanguage;
	}

	public void setCurrentLanguage(Language currentLanguage) {
		this.currentLanguage = currentLanguage;
	}

	public ServiceClass getOriginServiceClass() {
		return originServiceClass;
	}

	public void setOriginServiceClass(ServiceClass originServiceClass) {
		this.originServiceClass = originServiceClass;
	}

	public Float getMainAccountBalance() {
		return mainAccountBalance;
	}

	public void setMainAccountBalance(Float mainAccountBalance) {
		this.mainAccountBalance = mainAccountBalance;
	}

	public ServiceClass getCurrentServiceClass() {
		return currentServiceClass;
	}

	public void setCurrentServiceClass(ServiceClass currentServiceClass) {
		this.currentServiceClass = currentServiceClass;
	}

	public boolean isTemporaryBlockedFlag() {
		return temporaryBlockedFlag;
	}

	public void setTemporaryBlockedFlag(boolean temporaryBlockedFlag) {
		this.temporaryBlockedFlag = temporaryBlockedFlag;
	}

	public Date getServiceFeeDate() {
		return serviceFeeDate;
	}

	public void setServiceFeeDate(Date serviceFeeDate) {
		this.serviceFeeDate = serviceFeeDate;
	}

	public Date getSupervisionDate() {
		return supervisionDate;
	}

	public void setSupervisionDate(Date supervisionDate) {
		this.supervisionDate = supervisionDate;
	}

	public Date getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public HLRBlockingStatus getHlrBlockingStatus() {
		return hlrBlockingStatus;
	}

	public void setHlrBlockingStatus(HLRBlockingStatus hlrBlockingStatus) {
		this.hlrBlockingStatus = hlrBlockingStatus;
	}

	public Date getRefillUnbarDate() {
		return refillUnbarDate;
	}

	public void setRefillUnbarDate(Date refillUnbarDate) {
		this.refillUnbarDate = refillUnbarDate;
	}

	public List<DedicatedAccount> getDedicatedAccounts() {
		return dedicatedAccounts;
	}

	public void setDedicatedAccounts(List<DedicatedAccount> dedicatedAccounts) {
		this.dedicatedAccounts = dedicatedAccounts;
	}

	public List<Community> getCommunityList() {
		return communityList;
	}

	public void setCommunityList(List<Community> communityList) {
		this.communityList = communityList;
	}

	public FaFInfo getFafInfo() {
		return fafInfo;
	}

	public void setFafInfo(FaFInfo fafInfo) {
		this.fafInfo = fafInfo;
	}
	
	public boolean canChangeServiceClass(ServiceClass newServiceClass, ResourceBundle messages) {
		if(newServiceClass.equals(ServiceClass.Duo)) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			if(getServiceFeeDate() == null || cal.getTime().after(getServiceFeeDate())){
				throw new RuntimeException(messages.getString("errorChangeServiceClassDuo"));
			}
		}
		if(currentServiceClass.equals(ServiceClass.NetmovelTurboDUO) || currentServiceClass.equals(ServiceClass.NetmovelPrepago)
				|| currentServiceClass.equals(ServiceClass.NetmovelPrepagoBundle)) {
			throw new RuntimeException("You are not allowed to change the service class of a Netmovel subscriber manually..");
		}
		return true;
	}
	
	public ServiceClass getRealServiceClass() {
		if(getOriginServiceClass() != null) {
			//This means that subscriber is on a temporary service class
			return getOriginServiceClass();
		}
		return getCurrentServiceClass();
	}
	
	public boolean canChangeExpiryDates(Date newSupervisionDate, Date newServiceFeeDate, ResourceBundle messages) {
		if(newSupervisionDate == null || newServiceFeeDate == null) {
			throw new RuntimeException(messages.getString("errorExpiryDates"));
		}		
		//if old dates are null, it means that this subscriber number is in the "Installed" state, not active yet.
		if(serviceFeeDate != null && supervisionDate != null) {
			if(supervisionDate.equals(newSupervisionDate) &&
			   serviceFeeDate.equals(newServiceFeeDate)) {
				throw new RuntimeException(messages.getString("errorExpiryDates"));
			}
		}
		return true;
	}
	
	public DedicatedAccount getSMSAccount() {
		for(DedicatedAccount acc : getDedicatedAccounts()) {
			if(acc.getId() == SMS_DEDICATED_ACCOUNT_NUMBER) return acc;
		}
		return null;
	}
	
	public DedicatedAccount getMMSAccount() {
		for(DedicatedAccount acc : getDedicatedAccounts()) {
			if(acc.getId() == MMS_DEDICATED_ACCOUNT_NUMBER) return acc;
		}
		return null;
	}
	
	public DedicatedAccount getFreeCallsAccount() {
		for(DedicatedAccount acc : getDedicatedAccounts()) {
			if(acc.getId() == FREE_CALLS_DEDICATED_ACCOUNT_NUMBER) return acc;
		}
		return null;
	}
	
	public DedicatedAccount getDedicatedAccount(int dedicatedAccountNo) {
		for(DedicatedAccount acc : getDedicatedAccounts()) {
			if(acc.getId() == dedicatedAccountNo) return acc;
		}
		return null;
	}

	public List<Accumulator> getAccumulators() {
		return accumulators;
	}

	public void setAccumulators(List<Accumulator> accumulators) {
		this.accumulators = accumulators;
	}
	
	public Date getDefaultNewServiceFeeExpiryDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 35);
		return cal.getTime();
	}
	
	public Date getDefaultNewSupervisionExpiryDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 30);
		return cal.getTime();
	}
	
	
}

