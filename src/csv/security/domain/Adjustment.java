package csv.security.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import csv.gateway.cs.ServiceClass;
import csv.prepaid.domain.PrepaidAccount;
import csv.util.validator.BaseValidator;
import csv.util.validator.exception.ValidateException;

public class Adjustment implements Serializable {

	public static final String STATUS_NEW = "NOT APPLIED YET";
	public static final String STATUS_SUCCESSFUL = "SUCCESSFUL";
	public static final String STATUS_FAILED = "FAILED";
	
	private Long id;
	private String msisdn;
	private Float mainAccountAdjustment;
	private Integer relativeSupervisionPeriodIncrease;
	private Integer relativeServiceFeeIncrease;
	private Float[] dedicatedAccountAdjustment = new Float[10];
	private String status;
	private String reason;
	private String type = "A";
	private String voucherSerialNumber;
	private Date adjustmentDate;
	private Integer smsAdjustment;
	private Integer mmsAdjustment;
	private Float freeCallsAdjustment;
	
	private Set<DedicatedAccountAdjustment> dedicatedAccountAdjustments = new TreeSet<DedicatedAccountAdjustment>();
	
	private User owningUser;
	
	public Adjustment() {
		relativeServiceFeeIncrease = 0;
		relativeSupervisionPeriodIncrease = 0;
		mainAccountAdjustment = 0f;
		for(int i = 0; i < 10; i++) {
			dedicatedAccountAdjustment[i] = new Float("0");
		}
		type = "A";
		status = STATUS_NEW;
		smsAdjustment = 0;
		mmsAdjustment = 0;
		freeCallsAdjustment = 0f;
	}
	
	public Adjustment(String voucherSerialNumber) {
		this();
		this.voucherSerialNumber = voucherSerialNumber;
		this.adjustmentDate = new Date();
		type = "R";
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

	public Float getMainAccountAdjustment() {
		return mainAccountAdjustment;
	}

	public void setMainAccountAdjustment(Float mainAccountAdjustment) {
		this.mainAccountAdjustment = mainAccountAdjustment;
	}

	public Integer getRelativeSupervisionPeriodIncrease() {
		return relativeSupervisionPeriodIncrease;
	}

	public void setRelativeSupervisionPeriodIncrease(
			Integer relativeSupervisionPeriodIncrease) {
		this.relativeSupervisionPeriodIncrease = relativeSupervisionPeriodIncrease;
	}

	public Integer getRelativeServiceFeeIncrease() {
		return relativeServiceFeeIncrease;
	}

	public void setRelativeServiceFeeIncrease(Integer relativeServiceFeeIncrease) {
		this.relativeServiceFeeIncrease = relativeServiceFeeIncrease;
	}
	
	public Float[] getRealDedicatedAccountAdjustment(boolean give) {
		if(give) return dedicatedAccountAdjustment;
		else {
			Float[] val = new Float[dedicatedAccountAdjustment.length];
			for(int i = 0; i < dedicatedAccountAdjustment.length; i++) {
				val[i] = -dedicatedAccountAdjustment[i];
			}
			return val;
		}
	}
	
	public Float[] getDedicatedAccountAdjustment() {
		return dedicatedAccountAdjustment;
	}
	
	public void setDedicatedAccountAdjustment(Float[] dedicatedAccountAdjustment) {
		this.dedicatedAccountAdjustment = dedicatedAccountAdjustment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVoucherSerialNumber() {
		return voucherSerialNumber;
	}

	public void setVoucherSerialNumber(String voucherSerialNumber) {
		this.voucherSerialNumber = voucherSerialNumber;
	}

	public Date getAdjustmentDate() {
		return adjustmentDate;
	}

	public void setAdjustmentDate(Date adjustmentDate) {
		this.adjustmentDate = adjustmentDate;
	}

	public User getOwningUser() {
		return owningUser;
	}

	public void setOwningUser(User owningUser) {
		this.owningUser = owningUser;
	}
	
	public Set<DedicatedAccountAdjustment> getDedicatedAccountAdjustments() {
		return dedicatedAccountAdjustments;
	}

	private void setDedicatedAccountAdjustments(
			Set<DedicatedAccountAdjustment> dedicatedAccountAdjustments) {
		this.dedicatedAccountAdjustments = dedicatedAccountAdjustments;
	}

	public boolean isNegativeDedicatedAccountAdjustment() {
		for(Float val : dedicatedAccountAdjustment) {
			if(val != null && val.floatValue() < 0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean valid(PrepaidAccount account, ResourceBundle messages) throws ValidateException {
		if(mainAccountAdjustment < 0 || isNegativeDedicatedAccountAdjustment()) {
			throw new RuntimeException(messages.getString("errorAdjustmentNegative"));
		}		
		if(reason == null || reason.equals("")) {
			throw new RuntimeException(messages.getString("errorReasonForAdjustment"));
		}
		reason = BaseValidator.checkText(reason,255);
		//If the service class is null impose no restrictions. 
		if(account.getCurrentServiceClass() == null) return true;
		if(account.getCurrentServiceClass().equals(ServiceClass.Duo)) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			if(cal.getTime().after(account.getServiceFeeDate())){
				throw new RuntimeException(messages.getString("errorAdjustmentDuo"));
			}
		}
		return true;
	}
	
	public void refreshAccountValues(boolean success, boolean give, PrepaidAccount account) {
		if(success) {
			if(give) {
				account.setMainAccountBalance(account.getMainAccountBalance() + mainAccountAdjustment);
				for(int i = 0; i < dedicatedAccountAdjustment.length; i++) {
					account.getDedicatedAccount(i + 1).setBalance(account.getDedicatedAccount(i + 1).getBalance() + dedicatedAccountAdjustment[i]);
				}
				if(dedicatedAccountAdjustment[0] != null) this.smsAdjustment = dedicatedAccountAdjustment[0].intValue();
				if(dedicatedAccountAdjustment[1] != null) this.mmsAdjustment = dedicatedAccountAdjustment[1].intValue();
				if(dedicatedAccountAdjustment[2] != null) this.freeCallsAdjustment = dedicatedAccountAdjustment[2];
				for(int i = 0; i < dedicatedAccountAdjustment.length; i++) {
					if(dedicatedAccountAdjustment[i] != null && dedicatedAccountAdjustment[i] != 0) {
						DedicatedAccountAdjustment adj = new DedicatedAccountAdjustment();
						adj.setDedicatedAccountID(i + 1);
						adj.setAdjustmentValue(dedicatedAccountAdjustment[i]);
						dedicatedAccountAdjustments.add(adj);
					}
				}
			} else {
				account.setMainAccountBalance(account.getMainAccountBalance() - mainAccountAdjustment);
				for(int i = 0; i < dedicatedAccountAdjustment.length; i++) {
					account.getDedicatedAccount(i + 1).setBalance(account.getDedicatedAccount(i + 1).getBalance() - dedicatedAccountAdjustment[i]);
				}
				if(dedicatedAccountAdjustment[0] != null) this.smsAdjustment = -dedicatedAccountAdjustment[0].intValue();
				if(dedicatedAccountAdjustment[1] != null) this.mmsAdjustment = -dedicatedAccountAdjustment[1].intValue();
				if(dedicatedAccountAdjustment[2] != null) this.freeCallsAdjustment = -dedicatedAccountAdjustment[2];
				for(int i = 0; i < dedicatedAccountAdjustment.length; i++) {
					if(dedicatedAccountAdjustment[i] != null && dedicatedAccountAdjustment[i] != 0) {
						DedicatedAccountAdjustment adj = new DedicatedAccountAdjustment();
						adj.setDedicatedAccountID(i + 1);
						adj.setAdjustmentValue(-dedicatedAccountAdjustment[i]);
						dedicatedAccountAdjustments.add(adj);
					}
				}
			}
			
		}
	}
	
	public Integer getSmsAdjustment() {
		return smsAdjustment;
	}
	
	public Integer getMmsAdjustment() {
		return mmsAdjustment;
	}
	
	public Float getFreeCallsAdjustment() {
		return freeCallsAdjustment;
	}

	private void setSmsAdjustment(Integer smsAdjustment) {
		this.smsAdjustment = smsAdjustment;
	}

	private void setMmsAdjustment(Integer mmsAdjustment) {
		this.mmsAdjustment = mmsAdjustment;
	}

	private void setFreeCallsAdjustment(Float freeCallsAdjustment) {
		this.freeCallsAdjustment = freeCallsAdjustment;
	}
	
}
