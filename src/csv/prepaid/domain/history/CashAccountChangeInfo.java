package csv.prepaid.domain.history;

import java.io.Serializable;

public class CashAccountChangeInfo implements Serializable, Comparable<CashAccountChangeInfo> {

	private Long accountEventId;
	private Integer cashAccountId;
	private Float amount;
	private Float balanceBefore;
	private Float balanceAfter;
	
	public CashAccountChangeInfo() {
		super();
	}

	public Integer getCashAccountId() {
		return cashAccountId;
	}

	
	public Long getAccountEventId() {
		return accountEventId;
	}

	public void setAccountEventId(Long accountEventId) {
		this.accountEventId = accountEventId;
	}

	public void setCashAccountId(Integer cashAccountId) {
		this.cashAccountId = cashAccountId;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Float getBalanceBefore() {
		return balanceBefore;
	}

	public void setBalanceBefore(Float balanceBefore) {
		this.balanceBefore = balanceBefore;
	}

	public Float getBalanceAfter() {
		return balanceAfter;
	}

	public void setBalanceAfter(Float balanceAfter) {
		this.balanceAfter = balanceAfter;
	}
	
	public String getCashAccountName() {
		if(cashAccountId == 0) return "Main Account";
		if(cashAccountId == 1) return "SMS";
		if(cashAccountId == 2) return "MMS";
		if(cashAccountId == 8) return "Data(MB)";
		else return "Dedicated Account " + cashAccountId;
	}

	@Override
	public int compareTo(CashAccountChangeInfo o) {
		return this.cashAccountId.compareTo(o.cashAccountId);
	}
	
	
}
