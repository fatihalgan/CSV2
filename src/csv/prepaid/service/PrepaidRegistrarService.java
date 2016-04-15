package csv.prepaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.hibernate.criterion.ExistsSubqueryExpression;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import com.bridge.arete.ema.model.HLRSub;

import csv.common.service.BaseService;
import csv.gateway.hlr.EMAGateway;
import csv.prepaid.dao.ISIMRegistrationDao;
import csv.prepaid.domain.simreg.AbstractRegistrar;
import csv.prepaid.domain.simreg.CorporateRegistrar;
import csv.prepaid.domain.simreg.Country;
import csv.prepaid.domain.simreg.DocumentCollector;
import csv.prepaid.domain.simreg.INCMStatus;
import csv.prepaid.domain.simreg.LogType;
import csv.prepaid.domain.simreg.PersonalRegistrar;
import csv.prepaid.domain.simreg.RegistrarType;
import csv.prepaid.domain.simreg.RegistrationStatus;
import csv.prepaid.domain.simreg.ServiceType;
import csv.prepaid.domain.simreg.SubscriberLog;
import csv.prepaid.domain.simreg.Subscription;
import csv.prepaid.domain.simreg.TestemunhaRegistrar;

@Name("prepaidRegistrarService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class PrepaidRegistrarService extends BaseService implements IPrepaidRegistrarService {

	@In("simRegistrationDao")
	private ISIMRegistrationDao simRegistrationDao;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	private Subscription newSubscription;
	private AbstractRegistrar newRegistrar;
	private AbstractRegistrar existingRegistrar;
	private boolean newRegistration = true;
	private List<DocumentCollector> documentCollectors = new ArrayList<DocumentCollector>();
	private List<Country> countries = new ArrayList<Country>();
	
	public Subscription getNewSubscription() {
		return newSubscription;
	}

	public void setNewSubscription(Subscription newSubscription) {
		this.newSubscription = newSubscription;
	}
	
	public AbstractRegistrar getNewRegistrar() {
		return newRegistrar;
	}

	public void setNewRegistrar(AbstractRegistrar newRegistrar) {
		this.newRegistrar = newRegistrar;
	}

	public List<DocumentCollector> getDocumentCollectors() {
		return documentCollectors;
	}
	
	public List<Country> getCountries() {
		return countries;
	}

	public boolean isNewRegistration() {
		return newRegistration;
	}
	
	public void newSubscription() {
		newSubscription = new Subscription();
		newSubscription.setINCMStatus(INCMStatus.SendToINCM);
		newSubscription.setRegistrationDate(new Date());
		newSubscription.setSaveUser(loggedInUser.getUsername());
		newSubscription.setStatus(RegistrationStatus.TemporaryRegistered);
		
	}
	
	public void newRegistrar() {
		existingRegistrar = null;
		newRegistration = true;
		if(documentCollectors.size() == 0)
			documentCollectors = simRegistrationDao.findAllDocumentCollectors();
		if(countries.size() == 0)
			countries = simRegistrationDao.findAllCountries();
		if(newSubscription.getRegistrarType().equals(RegistrarType.PERSONAL))
			newRegistrar = new PersonalRegistrar();
		else if(newSubscription.getRegistrarType().equals(RegistrarType.COMPANY))
			newRegistrar = new CorporateRegistrar();
		else if(newSubscription.getRegistrarType().equals(RegistrarType.TESTEMUNHA)) 
			newRegistrar = new TestemunhaRegistrar();
		newRegistrar.setSaveUser(loggedInUser.getUsername());
		newRegistrar.setStatus(RegistrationStatus.TemporaryRegistered);
		newRegistrar.setSaveDate(new Date());
		newRegistrar.setDocumentsComplete("N");
	}
	
	public boolean validateSubscriptionAlreadyExists() {
		try {
			Subscription existing = simRegistrationDao.findSubscriptionByMsisdn(newSubscription.getMsisdn());
			if(existing != null) {
				facesMessages.add(Severity.ERROR, "This MSISDN is already registered..");
				return true;
			}
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add("Error in validating subscription data: " + e.getMessage());
			return true;
		}
		return false;
	}
	
	public boolean validateSIMCardNetworkStatus() {
		try {
			HLRSub hlrSub = emaGateway.getHLRSub("258" + newSubscription.getMsisdn());
			newSubscription.setImsi(hlrSub.getImsi());
			newSubscription.setSim(simRegistrationDao.findSimByMsisdn("258" + newSubscription.getMsisdn()));
			if(newSubscription.getSim() == null) throw new RuntimeException("Storage Medium number for the SIM card could not be found in BSCS..");
			ServiceType serviceType = simRegistrationDao.findServiceTypeOfCard("258" + newSubscription.getMsisdn());
			if(serviceType == null) serviceType = ServiceType.ERROR;
			newSubscription.setService(serviceType);
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add("Error in validating SIM card data: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean registrarAlreadyExists() {
		try {
			existingRegistrar = simRegistrationDao.findRegistrarUnique(newRegistrar);
			if(existingRegistrar != null) {
				newRegistrar = existingRegistrar;
				newRegistration = false;
				facesMessages.add(Severity.WARN, "This subscriber already exists in the system. You can update the details of the current subscriber if required..");
				return true;
			}
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add("Error in checking if the customer already exists: " + e.getMessage());
		}
		return false;
	}
	
	public boolean registrationLimitExceeded() {
		try {
			if(existingRegistrar != null) {
				if(existingRegistrar.registrationLimitReached()) {
					facesMessages.add(Severity.ERROR, "This subscriber has already exceeded the registration limit..");
					return true;
				}
				else return false;
			} else return false;
		} catch(Exception e) {
			logger.error(e.getMessage());
			logger.error("Failed to check if the subscriber has existing registrations: ", e.getMessage());
		}
		return true;
	}
	
	public void saveRegistrar() {
		newSubscription.setId(simRegistrationDao.fetchNextSubscriptionId(newRegistrar.getRegistrarType()));
		newRegistrar.addSubscription(newSubscription);
		List<SubscriberLog> subscriberLogs = new ArrayList<SubscriberLog>();
		if(newRegistration) {
			newRegistrar.setId(simRegistrationDao.fetchNextRegistrarId(newRegistrar.getRegistrarType()));
			subscriberLogs.add(new SubscriberLog(newSubscription.getMsisdn(), newRegistrar.getId(), LogType.NewRegistration, loggedInUser.getUsername(), newRegistrar));
			subscriberLogs.add(new SubscriberLog(newSubscription.getMsisdn(), newRegistrar.getId(), LogType.AddFirstCell, loggedInUser.getUsername(), newSubscription));
		} else {
			subscriberLogs.add(new SubscriberLog(newSubscription.getMsisdn(), newRegistrar.getId(), LogType.AddNextCell, loggedInUser.getUsername(), newSubscription));
		}
		simRegistrationDao.saveOrUpdate(newRegistrar);
		for(SubscriberLog log : subscriberLogs) {
			simRegistrationDao.save(log);
		}
		simRegistrationDao.flush();
	}

	@Remove
	public void remove() {
		logger.debug("Removing EJB component PrepaidRegistrarService...");
	}
}
