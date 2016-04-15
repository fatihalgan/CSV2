package csv.prepaid.service;

import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.simreg.AbstractRegistrar;
import csv.prepaid.domain.simreg.Country;
import csv.prepaid.domain.simreg.DocumentCollector;
import csv.prepaid.domain.simreg.Subscription;

@Local
public interface IPrepaidRegistrarService {

	public Subscription getNewSubscription();
	public void setNewSubscription(Subscription newSubscription);
	public AbstractRegistrar getNewRegistrar();
	public void setNewRegistrar(AbstractRegistrar newRegistrar);
	public boolean validateSubscriptionAlreadyExists();
	public boolean validateSIMCardNetworkStatus();
	public List<DocumentCollector> getDocumentCollectors();
	public List<Country> getCountries();
	public void newSubscription();
	public void newRegistrar();
	public boolean registrarAlreadyExists();
	public boolean registrationLimitExceeded();
	public boolean isNewRegistration();
	public void saveRegistrar();
	public void remove();
}
