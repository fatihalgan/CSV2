package csv.prepaid.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.bridge.crs.model.SubscriptionHistory;
import com.bridge.pelatro.model.OfferBouquet;
import com.bridge.pelatro.model.RecentSubscriberActivity;

import csv.common.domain.CurrentServedCustomer;
import csv.gateway.cs.Language;
import csv.gateway.cs.ServiceClass;
import csv.prepaid.domain.LoyaltyTransaction;
import csv.prepaid.domain.PrepaidAccount;
import csv.prepaid.domain.history.AbstractAccountEvent;
import csv.prepaid.domain.history.Account;
import csv.security.domain.Adjustment;

@Local
public interface IPrepaidAccountService {

	public void initialize();
	public void retrieveAccountInformation();
	public void retrieveLoyaltyInformation();
	public PrepaidAccount getAccount();
	public Account getDwsAccount();
	public SubscriptionHistory getSubscriptionHistory();
	public RecentSubscriberActivity getRecentSubscriberActivity();
	public OfferBouquet getOfferBouquet();
	public BigDecimal getLoyaltyPoints();
	public List<LoyaltyTransaction> getLoyaltyTransactions();
	public void retrieveAccountHistory();
	public void retrieveCRSAccountHistory();
	public void retrieveRecentSubscriberActivity();
	public void retrieveFaFHistory();
	public void retrieveEventDetails(AbstractAccountEvent event);
	public void retrieveCRSEventDetails(com.bridge.crs.model.AbstractAccountEvent event);
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public Language getNewLanguage();
	public void setNewLanguage(Language newLanguage);
	public ServiceClass getNewServiceClass();
	public void setNewServiceClass(ServiceClass newServiceClass);
	public Date getNewSupervisionPeriod();
	public void setNewSupervisionPeriod(Date newSupervisionPeriod);
	public Date getNewServiceFeePeriod();
	public void setNewServiceFeePeriod(Date newServiceFeePeriod);
	public Adjustment getAdjustment();
	public void setAdjustment(Adjustment adjustment);
	public CurrentServedCustomer getCurrentCustomer();
	public void updateFaFNumbers();
	public void changeEventDescriptionSelection();
	public void changeLanguage();
	public void changeServiceClass();
	public void changeExpiryDates();
	public void resetRefillBarringStatus();
	public void giveCreditsToSubscriber();
	public void takeCreditsFromSubscriber();
	public void attributeCreditsToNewSIMActivation(CurrentServedCustomer customer);
	public void remove();
}
