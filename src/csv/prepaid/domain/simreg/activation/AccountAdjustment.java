package csv.prepaid.domain.simreg.activation;

import java.io.Serializable;
import java.util.Date;

public class AccountAdjustment implements Serializable, Comparable<AccountAdjustment> {

	private int accountId;
	private Float adjustmentAmount;
	private int expiryDays;
	
	public AccountAdjustment() {
		super();
	}
	
	public AccountAdjustment(int accountId, Float adjustmentAmount, int expiryDays) {
		this.accountId = accountId;
		this.adjustmentAmount = adjustmentAmount;
		this.expiryDays = expiryDays;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Float getAdjustmentAmount() {
		return adjustmentAmount;
	}

	public void setAdjustmentAmount(Float adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}

	public int getExpiryDays() {
		return expiryDays;
	}

	public void setExpiryDays(int expiryDays) {
		this.expiryDays = expiryDays;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountId;
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
		if (!(obj instanceof AccountAdjustment)) {
			return false;
		}
		AccountAdjustment other = (AccountAdjustment) obj;
		if (accountId != other.accountId) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(AccountAdjustment other) {
		if(getAccountId() == other.getAccountId()) return 0;
		if(getAccountId() > other.getAccountId()) return 1;
		return -1;
	}
	
	

}
