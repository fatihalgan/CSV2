package csv.prepaid.service;

import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.simreg.Subscription;
import csv.prepaid.domain.simreg.SubscriptionHistory;


@Local
public interface IPrepaidCustomerService {
	public void retrieveCurrentSubscription();
	public void retrieveSubscriptionHistory();
	public Subscription getCurrentSubscription();
	public void removeCellFromRegistrar(String msisdn);
	public List<SubscriptionHistory> getSubscriptionHistory();
	public void remove();
}
