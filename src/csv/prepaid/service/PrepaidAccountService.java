package csv.prepaid.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.swing.event.TreeSelectionEvent;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import com.bridge.crs.model.SubscriptionHistory;
import com.bridge.crs.model.TransactionDetails;
import com.bridge.ena.cs.command.AbstractCSCommand;
import com.bridge.loyalty.prepaid.service.IPrepaidLoyaltyService;
import com.bridge.pelatro.model.OfferBouquet;
import com.bridge.pelatro.model.RecentSubscriberActivity;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.common.service.IDrService;
import csv.gateway.cs.AIRGateway;
import csv.gateway.cs.CRSGateway;
import csv.gateway.cs.Language;
import csv.gateway.cs.MINSATGateway;
import csv.gateway.cs.PelatroGateway;
import csv.gateway.cs.ServiceClass;
import csv.prepaid.dao.IDWSDao;
import csv.prepaid.dao.ILoyaltyDao;
import csv.prepaid.dao.IPrepaidDao;
import csv.prepaid.domain.LoyaltyTransaction;
import csv.prepaid.domain.PrepaidAccount;
import csv.prepaid.domain.history.AbstractAccountEvent;
import csv.prepaid.domain.history.Account;
import csv.prepaid.domain.history.AccountEvent;
import csv.prepaid.domain.history.FaFEntry;
import csv.prepaid.domain.history.UsageEvent;
import csv.prepaid.domain.simreg.activation.AccountAdjustment;
import csv.prepaid.domain.simreg.activation.SIMActivationAdjustment;
import csv.security.domain.AccessLog;
import csv.security.domain.Adjustment;
import csv.security.domain.OperationNames;

@Name("prepaidAccountService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class PrepaidAccountService extends BaseService implements IPrepaidAccountService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("minsatGateway")
	private MINSATGateway minsatGateway;
	
	@In("airGateway")
	private AIRGateway airGateway;
	
	@In("crsGateway")
	private CRSGateway crsGateway;
	
	@In("pelatroGateway")
	private PelatroGateway pelatroGateway;
	
	@In("dwsDao")
	private IDWSDao dwsDao;
	
	@In("prepaidDao")
	private IPrepaidDao prepaidDao;
	
	@In("prepaidLoyaltyService")
	private IPrepaidLoyaltyService loyaltyService;
	
	@In("drService")
	private IDrService drService;
	
	private PrepaidAccount account;
	
	private Account dwsAccount;
	
	private SubscriptionHistory subscriptionHistory = new SubscriptionHistory();
	
	private RecentSubscriberActivity recentSubscriberActivity = new RecentSubscriberActivity();
	
	private OfferBouquet offerBouquet = null;
	
	private BigDecimal loyaltyPoints = null;
	
	private List<LoyaltyTransaction> loyaltyTransactions = null;
	
	private Date startDate;
	private Date endDate;
	
	private Language newLanguage;
	private ServiceClass newServiceClass;
	private Date newSupervisionPeriod;
	private Date newServiceFeePeriod;
	private Adjustment adjustment = new Adjustment();
	
	public PrepaidAccountService() {
		super();
	}
	
	@PostConstruct
	public void initialize() {
		endDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, -3);
		startDate = new Date();
		startDate.setTime(cal.getTimeInMillis());
	}
	
	public CurrentServedCustomer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(CurrentServedCustomer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public PrepaidAccount getAccount() {
		return account;
	}

	public void setAccount(PrepaidAccount account) {
		this.account = account;
	}
	
	public Account getDwsAccount() {
		return dwsAccount;
	}

	public void setDwsAccount(Account dwsAccount) {
		this.dwsAccount = dwsAccount;
	}
	
	public SubscriptionHistory getSubscriptionHistory() {
		return subscriptionHistory;
	}

	public void setSubscriptionHistory(SubscriptionHistory subscriptionHistory) {
		this.subscriptionHistory = subscriptionHistory;
	}
	
	public RecentSubscriberActivity getRecentSubscriberActivity() {
		return recentSubscriberActivity;
	}
	
	public OfferBouquet getOfferBouquet() {
		return offerBouquet;
	}

	public BigDecimal getLoyaltyPoints() {
		return loyaltyPoints;
	}
	
	@Override
	public List<LoyaltyTransaction> getLoyaltyTransactions() {
		return loyaltyTransactions;
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Language getNewLanguage() {
		return newLanguage;
	}

	public void setNewLanguage(Language newLanguage) {
		this.newLanguage = newLanguage;
	}

	public ServiceClass getNewServiceClass() {
		return newServiceClass;
	}

	public void setNewServiceClass(ServiceClass newServiceClass) {
		this.newServiceClass = newServiceClass;
	}

	public Date getNewSupervisionPeriod() {
		return newSupervisionPeriod;
	}

	public void setNewSupervisionPeriod(Date newSupervisionPeriod) {
		this.newSupervisionPeriod = newSupervisionPeriod;
	}

	public Date getNewServiceFeePeriod() {
		return newServiceFeePeriod;
	}

	public void setNewServiceFeePeriod(Date newServiceFeePeriod) {
		this.newServiceFeePeriod = newServiceFeePeriod;
	}
	
	public Adjustment getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Adjustment adjustment) {
		this.adjustment = adjustment;
	}

	public void retrieveAccountInformation() {
		try {
			account = minsatGateway.getAccountInfo(currentCustomer.getMsisdn());
			account.setFafInfo(airGateway.getFamilyAndFriendsNumbers(currentCustomer.getMsisdn()));
			//dwsAccount = dwsDao.findAccountByMsisdn(currentCustomer.getPrefix() + currentCustomer.getMsisdn());
			//Notify after the account info is loaded for updates..
			newLanguage = account.getCurrentLanguage();
			newServiceClass = account.getRealServiceClass();
			newSupervisionPeriod = account.getSupervisionDate();
			newServiceFeePeriod = account.getServiceFeeDate();
			logAccess(OperationNames.FindCustomerInformation, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Error in retrieving Account Information: " + e.getMessage());
		}
	}
	
	public void updateFaFNumbers() {
		try {
			Calendar now = Calendar.getInstance();
			now.add(Calendar.MONTH, -1);
			List<AccessLog> fafAccessLogEntries = findEventsAfter(OperationNames.MINSATChangeFamilyandFriendsNumbers, currentCustomer.getFullMsisdn(), now.getTime());
			if(!fafAccessLogEntries.isEmpty()) {
				if(loggedInUser.canChangeFafInfoWithoutLimit()) {
					facesMessages.add(Severity.WARN, getMessages().getString("warningFaF1Month"));
				} else {
					facesMessages.add(Severity.ERROR, getMessages().getString("errorFaF1Month"));
					return;
				}
			}
			account.setFafInfo(airGateway.updateFamilyAndFriendsNumbers(currentCustomer.getMsisdn(), account.getFafInfo()));
			logAccess(OperationNames.MINSATChangeFamilyandFriendsNumbers, currentCustomer.getFullMsisdn(), account.getFafInfo().toString());
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retrieveAccountHistory() {
		try {
			List<AbstractAccountEvent> eventHistory = dwsDao.retrieveAccountHistory(dwsAccount.getSubscriberId(), dwsAccount.getId(), startDate, endDate);
			dwsAccount.setEventHistory(eventHistory);
			if(dwsAccount.getEventHistory().size() == 0) facesMessages.add(Severity.WARN, "No history records found in DWS for the selected period..");
			logAccess(OperationNames.PrepaidAccountHistory, currentCustomer.getFullMsisdn(), formatDate(startDate) + "-" + formatDate(endDate));
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retrieveCRSAccountHistory() {
		try {
			subscriptionHistory = crsGateway.retrieveSubscriptionHistory(currentCustomer.getPrefix() + currentCustomer.getMsisdn(), startDate, endDate);
			if(subscriptionHistory.getEventHistoryFiltered().size() == 0) facesMessages.add(Severity.WARN, "No history records found in CRS for the selected period..");
			logAccess(OperationNames.PrepaidAccountHistory, currentCustomer.getFullMsisdn(), formatDate(startDate) + "-" + formatDate(endDate));
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retrieveRecentSubscriberActivity() {
		try {
			recentSubscriberActivity = pelatroGateway.retrieveRecentActivity(currentCustomer.getFullMsisdn());
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
		try {		
			offerBouquet = pelatroGateway.retrieveOptionalOffers(currentCustomer.getFullMsisdn());
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void acceptCampaignOffer(String offerId) {
		try {
			pelatroGateway.acceptOffer(offerId, currentCustomer.getFullMsisdn());
			facesMessages.add(Severity.INFO, "Offer was accepted successfully...");
			retrieveRecentSubscriberActivity();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retrieveFaFHistory() {
		try {
			List<FaFEntry> history = dwsDao.retrieveFaFHistory(dwsAccount.getSubscriberId(), startDate, endDate);
			dwsAccount.setFafHistory(history);
			if(dwsAccount.getFafHistory().size() == 0) facesMessages.add(Severity.WARN, "No FaF history records found between selected dates..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void retrieveEventDetails(AbstractAccountEvent event) {
		dwsAccount.setCurrentViewedEvent(event);
		if(dwsAccount.getCurrentViewedEvent() instanceof AccountEvent) {
			AccountEvent evt = (AccountEvent)dwsAccount.getCurrentViewedEvent();
			evt.setCashAccountChanges(dwsDao.retrieveCashAccountChanges(event.getEventId()));
			evt.setLifeCycleChanges(dwsDao.retrieveLifeCycleInfoChanges(event.getEventId()));
		} 
	}
	
	public void retrieveCRSEventDetails(com.bridge.crs.model.AbstractAccountEvent event) {
		subscriptionHistory.setCurrentViewedEvent(event);
		TransactionDetails tr = crsGateway.retrieveTransactionDetails(event.getTransactionId());
		event.setTransactionDetails(tr);
	}
	
	public void changeLanguage() {
		try {
			minsatGateway.changeLanguage(currentCustomer.getFullMsisdn(), account.getCurrentLanguage(), newLanguage);
			logAccess(OperationNames.MINSATChangeLanguage, currentCustomer.getFullMsisdn(), account.getCurrentLanguage().getLabel() + " - " + newLanguage.getLabel());
			account.setCurrentLanguage(newLanguage);
			facesMessages.add(Severity.INFO, "Subscriber language has been changed successfully");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	} 
	
	public void changeServiceClass() {
		try {
			if(!loggedInUser.isMemberOf("System Admins")) account.canChangeServiceClass(newServiceClass, getMessages());
			minsatGateway.changeServiceClass(currentCustomer.getFullMsisdn(), account.getRealServiceClass(), newServiceClass);
			logAccess(OperationNames.MINSATChangeServiceClass, currentCustomer.getFullMsisdn(), account.getRealServiceClass().getLabel() + " - " + newServiceClass);
			account.setCurrentServiceClass(newServiceClass);
			account.setOriginServiceClass(null);
			facesMessages.add(Severity.INFO, "Subscribers ServiceClass has been changed successfully.");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void changeExpiryDates() {
		try {
			account.canChangeExpiryDates(newSupervisionPeriod, newServiceFeePeriod, getMessages());
			minsatGateway.changeExpiryDates(currentCustomer.getFullMsisdn(), account.getServiceFeeDate(), newServiceFeePeriod, account.getSupervisionDate(), newSupervisionPeriod);
			logAccess(OperationNames.MINSATChangeExpiryDates, currentCustomer.getFullMsisdn(), 
				"Supervision: " + account.getSupervisionDate().toLocaleString() + " --> " + newSupervisionPeriod.toLocaleString() +
				", Service Fee: " + account.getServiceFeeDate().toLocaleString() + " --> " + newServiceFeePeriod.toLocaleString());
			facesMessages.add(Severity.INFO, "Expiry Dates has been changed successfully.");
			account.setServiceFeeDate(newServiceFeePeriod);
			account.setSupervisionDate(newSupervisionPeriod);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		} finally {
			newServiceFeePeriod = account.getServiceFeeDate();
			newSupervisionPeriod = account.getSupervisionDate();
		}
	}
	
	public void resetRefillBarringStatus() {
		try {
			minsatGateway.resetRefillBarringStatus(currentCustomer.getFullMsisdn());
			logAccess(OperationNames.MINSATResetRefillBarringStatus, currentCustomer.getFullMsisdn(), "");
			account.setRefillUnbarDate(null);
			facesMessages.add(Severity.INFO, "Refill Barring has been successfully reset.");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void giveCreditsToSubscriber() {
		try {
			adjustment.valid(account, getMessages());
			adjustment.setOwningUser(loggedInUser);
			adjustment.setMsisdn(currentCustomer.getFullMsisdn());
			adjustment.setAdjustmentDate(new Date());
			securityDao.saveOrUpdate(adjustment);
			airGateway.makeAdjustment(adjustment.getId().toString(), adjustment.getAdjustmentDate(), currentCustomer.getMsisdn(), 
					adjustment.getMainAccountAdjustment(), loggedInUser.getUsername(), "CSV Adjustment",
					adjustment.getRelativeSupervisionPeriodIncrease(), adjustment.getRelativeServiceFeeIncrease(), 
					adjustment.getRealDedicatedAccountAdjustment(true));
			adjustment.setStatus(Adjustment.STATUS_SUCCESSFUL);
			logAccess(OperationNames.PrepaidAdjustmentGiveCredits, currentCustomer.getFullMsisdn(), "Reason: " + adjustment.getReason() + " " +
					"[Main Account:" + adjustment.getMainAccountAdjustment().toString() + ", " + 
					"Free SMS:" + adjustment.getDedicatedAccountAdjustment()[0] + ", " +
					"Free MMS:" + adjustment.getDedicatedAccountAdjustment()[1] + ", " +
					"Adjustment ID:" + adjustment.getId() + "]");
			facesMessages.add(Severity.INFO, "Give Credits To Subscriber operation was successful. " +
					"Main Account:" + adjustment.getMainAccountAdjustment().toString() + ", " + 
					"Free SMS:" + adjustment.getDedicatedAccountAdjustment()[0] + ", " +
					"Free MMS:" + adjustment.getDedicatedAccountAdjustment()[1]);
			try {
				sendAdjustmentSMS(adjustment);
			} catch(Exception e) {
				logger.error("Could not send adjustment notification SMS: ", e.getMessage());
			}
			adjustment.refreshAccountValues(true, true, account);
			adjustment = new Adjustment();
		} catch(Exception e) {
			adjustment.setStatus(Adjustment.STATUS_FAILED);
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void takeCreditsFromSubscriber() {
		try {
			adjustment.valid(account, getMessages());
			adjustment.setOwningUser(loggedInUser);
			adjustment.setMsisdn(currentCustomer.getFullMsisdn());
			adjustment.setAdjustmentDate(new Date());
			securityDao.saveOrUpdate(adjustment);
			airGateway.makeAdjustment(adjustment.getId().toString(), adjustment.getAdjustmentDate(), currentCustomer.getMsisdn(), 
					-adjustment.getMainAccountAdjustment(), loggedInUser.getUsername(), "CSV Adjustment",
					adjustment.getRelativeSupervisionPeriodIncrease(), adjustment.getRelativeServiceFeeIncrease(), 
					adjustment.getRealDedicatedAccountAdjustment(false));
			adjustment.setStatus(Adjustment.STATUS_SUCCESSFUL);
			logAccess(OperationNames.PrepaidAdjustmentTakeCredits, currentCustomer.getFullMsisdn(), "Reason: " + adjustment.getReason() + " " +
					"[Main Account:" + adjustment.getMainAccountAdjustment().toString() + ", " + 
					"Free SMS:" + adjustment.getDedicatedAccountAdjustment()[0] + ", " +
					"Free MMS:" + adjustment.getDedicatedAccountAdjustment()[1] + ", " +
					"Adjustment ID:" + adjustment.getId() + "]");
			facesMessages.add(Severity.INFO, "Take Credits from Subscriber operation was successful. " +
					"Main Account:" + adjustment.getMainAccountAdjustment().toString() + ", " + 
					"Free SMS:" + adjustment.getDedicatedAccountAdjustment()[0] + ", " +
					"Free MMS:" + adjustment.getDedicatedAccountAdjustment()[1]);
			adjustment.refreshAccountValues(true, false, account);
			adjustment = new Adjustment();
		} catch(Exception e) {
			adjustment.setStatus(Adjustment.STATUS_FAILED);
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	private void sendAdjustmentSMS(Adjustment adjustment) {
		String message =  "Caro Cliente, acabamos de repor o seu credito em " +
		adjustment.getMainAccountAdjustment() +" MT, " +
		adjustment.getDedicatedAccountAdjustment()[0]  +" SMS, " +
		adjustment.getDedicatedAccountAdjustment()[1] +" MMS." +  " Pode fazer chamadas ate ";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = simpleDateFormat.format(account.getSupervisionDate());
		message += strDate + ". Obrigado, mcel.";
		drService.createSMSMessage(adjustment.getMsisdn(), message, adjustment.getReason());
	}
	
	public void changeEventDescriptionSelection() {
		logger.debug("Event Description Selection: " + subscriptionHistory.getSelectedEventDescription());
	}
	
	public void retrieveLoyaltyInformation() {
		try {
			loyaltyPoints = loyaltyService.retrieveLoyaltyPoints(currentCustomer.getMsisdn());
			loyaltyTransactions = loyaltyService.retrieveLoyaltyTransactionHistory(currentCustomer.getMsisdn(), startDate, endDate);
			logAccess(OperationNames.RetrieveLoyaltyInfo, currentCustomer.getFullMsisdn(), "");
			if(loyaltyTransactions.size() == 0) facesMessages.add(Severity.WARN, "No loyalty points was used or gained within the selected date interval..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	@Observer("NewSIMCardActivated")
	public void attributeCreditsToNewSIMActivation(CurrentServedCustomer customer) {
		try {
			logger.debug("NewSIMCardActivated event received for msisdn: " + customer.getMsisdn());
			if(account == null) {
				retrieveAccountInformation();
			}
			if(account.getStatus().equals("Installed")) {
				minsatGateway.changeExpiryDates(currentCustomer.getFullMsisdn(), account.getServiceFeeDate(), account.getDefaultNewServiceFeeExpiryDate(), account.getSupervisionDate(), account.getDefaultNewSupervisionExpiryDate());
			}
			//SIMActivationAdjustment simActivationAdjustment = new SIMActivationAdjustment();
			//List<AccountAdjustment> accountAdjustments = prepaidDao.findSIMActivationAdjustments();
			//if(accountAdjustments == null || accountAdjustments.size() == 0) {
				//facesMessages.add(Severity.WARN, "No account adjustment was configured for new sim card activation. No extra Airtime will be given..");
				//return;
			//}
			//simActivationAdjustment.setAccountAdjustments(new TreeSet<AccountAdjustment>(accountAdjustments));
			//AbstractCSCommand cmd = simActivationAdjustment.getCSCommand(airGateway.getAirAdjustmentCommandFactory(), currentCustomer.getMsisdn());
			//airGateway.executeAirCommand(cmd);
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Airtime for sim card activation could not be given. Error reason is: " + e.getMessage());
		}
		retrieveAccountInformation();
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateless EJB component PrepaidAccountService");
	}

}
