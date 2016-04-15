package csv.postpaid.domain;

import java.io.Serializable;

public class PaymentArrangement implements Serializable {

	private static final long serialVersionUID = 5070965337303113538L;
	
	private String paymentName;
	private String accountOwner;
	private String accountNo;
	private String bankName;
	private String bankCity;
	private String city;
	private String arrangementMode;
	private String currencyCode;
	
	public PaymentArrangement() {
		super();
	}
	
	public PaymentArrangement(String paymentName, String accountOwner, String accountNo, 
		String bankName, String bankCity, String city, String arrangementMode, String currencyCode) {
		
		this.paymentName = paymentName;
		this.accountOwner = accountOwner;
		this.accountNo = accountNo;
		this.bankName = bankName;
		this.bankCity = bankCity;
		this.city = city;
		this.arrangementMode = arrangementMode;
		this.currencyCode = currencyCode;
	}

	public String getPaymentName() {
		return paymentName;
	}

	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCity() {
		return bankCity;
	}

	public void setBankCity(String bankCity) {
		this.bankCity = bankCity;
	}

	public String getArrangementMode() {
		return arrangementMode;
	}

	public void setArrangementMode(String arrangementMode) {
		this.arrangementMode = arrangementMode;
	}
	
	public boolean isCurrentPaymentArrangementMode() {
		if(getArrangementMode().trim().equals("X")) return true;
		else return false;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
