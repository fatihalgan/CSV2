package csv.prepaid.dao;

import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.simreg.AbstractRegistrar;
import csv.prepaid.domain.simreg.CallUnbarLog;
import csv.prepaid.domain.simreg.CallUnbarStatus;
import csv.prepaid.domain.simreg.Country;
import csv.prepaid.domain.simreg.DocumentCollector;
import csv.prepaid.domain.simreg.RegistrarType;
import csv.prepaid.domain.simreg.ServiceType;
import csv.prepaid.domain.simreg.Subscription;
import csv.prepaid.domain.simreg.SubscriptionHistory;
import csv.prepaid.domain.simreg.activation.Dealer;
import csv.util.persistence.IBaseDao;

@Local
public interface ISIMRegistrationDao extends IBaseDao {

	public Subscription findSubscriptionByMsisdn(String msisdn);
	public List<SubscriptionHistory> findSubscriptionHistory(String msisdn);
	public List<Dealer> findAllDealers();
	public List<DocumentCollector> findAllDocumentCollectors();
	public List<Country> findAllCountries();
	public Long fetchNextSubscriptionId(RegistrarType registrarType);
	public Long fetchNextRegistrarId(RegistrarType registrarType);
	public AbstractRegistrar findRegistrarUnique(AbstractRegistrar registrar);
	public String findSimByMsisdn(String msisdn);
	public ServiceType findServiceTypeOfCard(String msisdn);
	public List<CallUnbarLog> findCallUnbarLogsByStatus(CallUnbarStatus status);
	public String scheduleBalkSIMCardUnbarring(final String startSIM, final String endSIM, final String email);
}
