package csv.prepaid.domain.history;

import java.util.ArrayList;
import java.util.List;

public class AccountEvent extends AbstractAccountEvent {

	private String originDrId;
	private String originNodeId;
	private String originTransactionId;
	
	private List<CashAccountChangeInfo> cashAccountChanges = new ArrayList<CashAccountChangeInfo>();
	private List<LifeCycleChangeInfo> lifeCycleChanges = new ArrayList<LifeCycleChangeInfo>();
	
	public AccountEvent() {
		super();
	}

	public String getOriginDrId() {
		return originDrId;
	}

	public void setOriginDrId(String originDrId) {
		this.originDrId = originDrId;
	}

	public String getOriginNodeId() {
		return originNodeId;
	}

	public void setOriginNodeId(String originNodeId) {
		this.originNodeId = originNodeId;
	}

	public String getOriginTransactionId() {
		return originTransactionId;
	}

	public void setOriginTransactionId(String originTransactionId) {
		this.originTransactionId = originTransactionId;
	}
	
	public List<CashAccountChangeInfo> getCashAccountChanges() {
		return cashAccountChanges;
	}

	public void setCashAccountChanges(List<CashAccountChangeInfo> cashAccountChanges) {
		this.cashAccountChanges = cashAccountChanges;
	}
	
	public List<LifeCycleChangeInfo> getLifeCycleChanges() {
		return lifeCycleChanges;
	}

	public void setLifeCycleChanges(List<LifeCycleChangeInfo> lifeCycleChanges) {
		this.lifeCycleChanges = lifeCycleChanges;
	}

	@Override
	public String getEventDescription() {
		try {
		if(originNodeId.equals("EXT_SAE_YOYO") || originNodeId.equals("EXT_MCEL_YOYO_BONUS") || originNodeId.equals("EXT_SAEYOYO") || originNodeId.equals("EXT_MCELYOYOBONUS"))
            return EventDescription.YOYOBonus.toString();
		else if(originNodeId.startsWith("EXT_SAE_ANNI") || originNodeId.startsWith("EXT_SAEANNI"))
            return EventDescription.AnniversaryBonus.toString();
		else if(originNodeId.equals("EXT_MCELAPP1") || originNodeId.startsWith("EXT_TOMALA") || originNodeId.startsWith("EXT_SAE_TOM") || originNodeId.startsWith("EXT_SAETOM"))
            return EventDescription.Tomala.toString();
		else if(originNodeId.equals("EXT_MCELAPP_BIC") || originNodeId.equals("EXT_MCELAPPBIC"))
            return EventDescription.IncomingCallBonus.toString();
		else if(originNodeId.equals("EXT_MCELAPP_DUO") || originNodeId.equals("EXT_MCELAPPDUO"))
            return EventDescription.DUOAdjustment.toString();
		else if(originNodeId.equals("ADM_minsat"))                        
            return EventDescription.MINSATAdjustment.toString();
		else if(originNodeId.startsWith("UGW_")) {
        	//TODO: How to know is it a refill or activation without loading details
			return EventDescription.Refill.toString();
        } else if(originNodeId.equals("EXT_SAE_TARF") || originNodeId.equals("EXT_SAETARF"))
            return EventDescription.TariffChange.toString();
        else if(originNodeId.startsWith("IVR"))
            return EventDescription.IVRCall.toString();
        else if(originNodeId.startsWith("AIR_air"))
            return EventDescription.BatchAdjustment.toString(); 
        else if(originNodeId.equals("EXT_MCEL_CSV_ADJUSTMENT") || originNodeId.equals("EXT_MCELCSVADJUSTMENT"))        	
            return EventDescription.AdjustmentfromCSV.toString();
        else if(originNodeId.equals("EXT_CSV_VOUCHER_REFILL") || originNodeId.equals("EXT_CSVVOUCHERREFILL"))
        	return EventDescription.VoucherRefillFromCSV.toString(); 
        else if(originNodeId.startsWith("EXT_MCELTUMAPP01")) {                        
            return EventDescription.TUMRecharge.toString();
        } else if(originNodeId.equals("EXT_GPRSRecharge")) {
        	return EventDescription.Netmovel.toString();
        } else if(originNodeId.equals("EXT_BB4P")) {
        	return EventDescription.BB4PReservation.toString();
        } else if(originNodeId.equals("EXT_VoiceAddOnData")) {
        	return EventDescription.NetGiro.toString();
        } 
        else return originNodeId;
		} catch(Exception e) {
			return EventDescription.UnknownType.toString();
		}
	}

	@Override
	public String getEventType() {
		return "AccountEvent";
	}
	
	public Float getUsageAmount() {
		if(getBalanceBefore() != null  && getBalanceAfter() != null)
			return getBalanceBefore() - getBalanceAfter();
		else return null;
	}

	@Override
	public Float getBalanceAfter() {
		if(this.balanceAfter != null) return this.balanceAfter;
		CashAccountChangeInfo c = getMainAccountChangeInfo();
		if(c != null) c.getBalanceAfter();
		return null;
	}
	
	public void setBalanceAfter(Float balanceAfter) {
		this.balanceAfter = balanceAfter;
	}
	
	@Override
	public Float getBalanceBefore() {
		if(this.balanceBefore != null) return this.balanceBefore;
		CashAccountChangeInfo c = getMainAccountChangeInfo();
		if(c != null) c.getBalanceBefore();
		return null;
	}
	
	public void setBalanceBefore(Float balanceBefore) {
		this.balanceBefore = balanceBefore;
	}
	
	private CashAccountChangeInfo getMainAccountChangeInfo() {
		for(CashAccountChangeInfo c : cashAccountChanges) {
			if(c.getCashAccountId() == 0) return c;
		}
		return null;
	}
}
