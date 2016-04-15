package csv.postpaid.domain;

import java.io.Serializable;

public class BillingInfo implements Serializable {

	private static final long serialVersionUID = -6730290813662429715L;
	
	private String customerGroup;
	private String costCenter;
	private String contractResponsible;
	private String paymentResponsible;
	
	public BillingInfo() {
		super();
	}
	
	public BillingInfo(String customerGroup, String costCenter, String contractResponsible,
		String paymentResponsible) {
		this.customerGroup = customerGroup;
		this.costCenter = costCenter;
		this.contractResponsible = contractResponsible;
		this.paymentResponsible = paymentResponsible;
	}

	public String getCustomerGroup() {
		return customerGroup;
	}

	public void setCustomerGroup(String customerGroup) {
		this.customerGroup = customerGroup;
	}

	public String getCostCenter() {
		return costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}

	public String getContractResponsible() {
		return contractResponsible;
	}

	public void setContractResponsible(String contractResponsible) {
		this.contractResponsible = contractResponsible;
	}

	public String getPaymentResponsible() {
		return paymentResponsible;
	}

	public void setPaymentResponsible(String paymentResponsible) {
		this.paymentResponsible = paymentResponsible;
	}
	
}
