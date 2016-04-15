package csv.security.domain;

import java.io.Serializable;

public class DedicatedAccountAdjustment implements Serializable, Comparable<DedicatedAccountAdjustment> {

	private int dedicatedAccountID;
	private float adjustmentValue;
	
	public DedicatedAccountAdjustment() {
		super();
	}

	public int getDedicatedAccountID() {
		return dedicatedAccountID;
	}

	public void setDedicatedAccountID(int dedicatedAccountID) {
		this.dedicatedAccountID = dedicatedAccountID;
	}

	public float getAdjustmentValue() {
		return adjustmentValue;
	}

	public void setAdjustmentValue(float adjustmentValue) {
		this.adjustmentValue = adjustmentValue;
	}

	@Override
	public int compareTo(DedicatedAccountAdjustment o) {
		return new Integer(this.dedicatedAccountID).compareTo(o.getDedicatedAccountID());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(adjustmentValue);
		result = prime * result + dedicatedAccountID;
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
		if (!(obj instanceof DedicatedAccountAdjustment)) {
			return false;
		}
		DedicatedAccountAdjustment other = (DedicatedAccountAdjustment) obj;
		if (Float.floatToIntBits(adjustmentValue) != Float
				.floatToIntBits(other.adjustmentValue)) {
			return false;
		}
		if (dedicatedAccountID != other.dedicatedAccountID) {
			return false;
		}
		return true;
	}
	
	
	
	
}
