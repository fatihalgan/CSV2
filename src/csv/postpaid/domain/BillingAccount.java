package csv.postpaid.domain;

import java.io.Serializable;

public class BillingAccount implements Serializable {

	private static final long serialVersionUID = -1648924060072795348L;
	
	private Long accountId;
	private String accountName;
	
	public BillingAccount() {
		super();
	}
	
	public Long getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	
	@Override
	public String toString(){
		return "accountId="+accountId+"\n"+
				"accountName="+accountName;
	}

}
