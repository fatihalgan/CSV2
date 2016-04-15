package csv.gateway.cs;

import java.io.Serializable;
import java.util.Date;

public class DedicatedAccount implements Serializable {

	private int id;
	private Float balance;
	private Date expiryDate;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Float getBalance() {
		return balance;
	}
	
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}
	
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
