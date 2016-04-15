package csv.prepaid.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.prepaid.dao.ISIMRegistrationDao;
import csv.prepaid.domain.simreg.Subscription;
import csv.prepaid.domain.simreg.SubscriptionHistory;


@Name("prepaidCustomerService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class PrepaidCustomerService extends BaseService implements IPrepaidCustomerService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("simRegistrationDao")
	private ISIMRegistrationDao simRegistrationDao;
	
	private Subscription currentSubscription;
	
	private List<SubscriptionHistory> subscriptionHistory = new ArrayList<SubscriptionHistory>();
	
	public CurrentServedCustomer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(CurrentServedCustomer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public Subscription getCurrentSubscription() {
		return currentSubscription;
	}
	
	public List<SubscriptionHistory> getSubscriptionHistory() {
		return subscriptionHistory;
	}
	
	public void retrieveCurrentSubscription() {
		try {
			currentSubscription = simRegistrationDao.findSubscriptionByMsisdn(currentCustomer.getMsisdn());
			if(currentSubscription == null) facesMessages.add(Severity.ERROR, "Subscriber registration has not been done yet..");
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add("Error in retrieving Subscriber registration: " + e.getMessage());
		}
	}
	
	public void retrieveSubscriptionHistory() {
		try {
			subscriptionHistory = simRegistrationDao.findSubscriptionHistory(currentCustomer.getMsisdn());
			if(subscriptionHistory.size() == 0) facesMessages.add(Severity.WARN, "No past registrations of this MSISDN exists yet..");
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add("Error in retrieving Subscription history of MSISDN: " + e.getMessage());
		}
	}
	
	public void removeCellFromRegistrar(String msisdn) {
		try {
			
		} catch(Exception e) {
			logger.error("Could not unregister number: ", e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not unregister number: " + e.getMessage());
		}
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing EJB component PrepaidCustomerService...");
	}
}
