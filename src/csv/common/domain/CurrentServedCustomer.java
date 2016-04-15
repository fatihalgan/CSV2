package csv.common.domain;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Conversational;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.core.Conversation;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.security.domain.User;

@Name("currentServedCustomer")
@Scope(ScopeType.CONVERSATION)
@AutoCreate
public class CurrentServedCustomer implements Serializable {
	
	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@RequestParameter
	private String callerMsisdn = null;
	
	private String customerCode = null;
	
	@In(required=true)
	private User loggedInUser;
	
	private String prefix = "258";
	private String msisdn = null;
	
	private boolean sessionStarted = false;
	
	private CustomerIdentifierType customerIdentifierType = null;
	
	public CurrentServedCustomer() {
		super();
	}
	
	public void initCallerMsisdn() {
		if(callerMsisdn == null) return;
		if(callerMsisdn.length() == 9 && (callerMsisdn.startsWith("82") || callerMsisdn.startsWith("83"))) this.msisdn = callerMsisdn;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getCustomerIdentifier() {
		if(msisdn != null && msisdn.length() != 0) return msisdn;
		if(customerCode != null && customerCode.length() != 0) return customerCode;
		return null;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void newCustomer() {
		if(msisdn == null && msisdn.trim().length() == 0) {
			facesMessages.add(Severity.ERROR, "Please anter an MSISDN to start working with a customer");
			msisdn = null;
			return;
		}
		if(msisdn.length() != 9) {
			facesMessages.add(Severity.ERROR, "MSISDN format was wrong.. Please enter once again.");
			msisdn = null;
			return;
		}
		logger.debug("Accepting New Customer: " + msisdn);
		Conversation.instance().begin(true, false);
		sessionStarted = true;
		customerIdentifierType = CustomerIdentifierType.MSISDN;
	}
	
	public void newCorporateCustomer() {
		newCustomer();
	}
	
	public void newCustomerCode() {
		if(customerCode == null && customerCode.trim().length() == 0) {
			facesMessages.add(Severity.ERROR, "Please anter Customer Code to start working with a Corporate Customer");
			customerCode = null;
			return;
		}
		logger.debug("Accepting New Customer: " + customerCode);
		Conversation.instance().begin(true, false);
		sessionStarted = true;
		customerIdentifierType = CustomerIdentifierType.CustomerCode;
	}
	
	public void newCorporateCustomerCode() {
		newCustomerCode();
	}
	
	public boolean isCustomerValid() {
		if(msisdn != null && msisdn.trim().length() == 9 && sessionStarted) return true;
		if(customerCode != null && customerCode.trim().length() != 0 && sessionStarted) return true;
		return false;
	}
	
	@Conversational
	public void dismissCurrentCustomer() {
		if(isCustomerValid()) logger.debug("Will Dismiss Customer: " + getCustomerIdentifier());
		else {
			Conversation.instance().endBeforeRedirect();
			throw new CustomerSessionExpiredException();
		}
	}
	
	@End(beforeRedirect=false)
	public void endCustomerSession() {
		logger.debug("Dismissing Customer: " + msisdn);
		this.msisdn = null;
		this.customerCode = null;
		this.customerIdentifierType = null;
		sessionStarted = false;
	}
	
	public String getFullMsisdn() {
		if(msisdn != null) return prefix + msisdn;
		return null;
	}

	public CustomerIdentifierType getCustomerIdentifierType() {
		if(isCustomerValid()) return customerIdentifierType;
		else return null;
	}
	
	public boolean getCustomerCodeIdentifier() {
		if(getCustomerIdentifierType() == null) return false;
		if(getCustomerIdentifierType().equals(CustomerIdentifierType.CustomerCode)) return true;
		return false;
	}
	
	public boolean getMsisdnIdentifier() {
		if(getCustomerIdentifierType() == null) return false;
		if(getCustomerIdentifierType().equals(CustomerIdentifierType.MSISDN)) return true;
		return false;
	}
	
}
