package co.mcel.mz.bb4p.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import com.bridge.likya.bbfp.model.AccountInfo;
import com.bridge.likya.bbfp.model.DetailedCDR;

import co.mcel.mz.bb4p.dao.IBB4PDao;
import co.mcel.mz.bb4p.model.BB4PActivation;
import co.mcel.mz.bb4p.model.BB4PReservation;
import co.mcel.mz.reservedcharging.model.ReservationStatus;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.gateway.bb4p.BB4PGateway;
import csv.security.domain.OperationNames;

@Name("bb4pCustomerCareService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class BB4PCustomerCareService extends BaseService implements IBB4PCustomerCareService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("bb4pDao")
	private IBB4PDao bb4pDao;
	
	@In("bb4pGateway")
	private BB4PGateway bb4pGateway;
	
	private AccountInfo accountInfo;
	
	private List<DetailedCDR> ticketsHistory = new ArrayList<DetailedCDR>();
	
	private BB4PActivation newActivation = new BB4PActivation();
	
	private List<BB4PReservation> pendingReservations = new ArrayList<BB4PReservation>();
	
	private Date startDate;
	
	private Date endDate;
	
	private String reason;
	
	public BB4PCustomerCareService() {
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
	
	public AccountInfo getAccountInfo() {
		return accountInfo;
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
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	public List<DetailedCDR> getTicketsHistory() {
		return ticketsHistory;
	}
	
	public BB4PActivation getNewActivation() {
		return newActivation;
	}

	public void setNewActivation(BB4PActivation newActivation) {
		this.newActivation = newActivation;
	}
	
	public List<BB4PReservation> getPendingReservations() {
		return pendingReservations;
	}

	@Override
	public void activateAccount() {
		try {
			bb4pGateway.activateAccount(currentCustomer.getFullMsisdn(), newActivation.getVolume(), newActivation.getCommercialOffer().toString(), newActivation.getDurationType(), newActivation.getDuration());
			logAccess(OperationNames.BlackBerryForPrepaid, currentCustomer.getFullMsisdn(), "Activation Reason: " + reason);
			facesMessages.add(Severity.INFO, "Account Activated Successfully..");
			retrieveAccountInfo();
			newActivation = new BB4PActivation();
			reason =null;
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Activation was not successful: " + e.getMessage());
		}
	}

	@Override
	public void deactivateAccount() {
		try {
			bb4pGateway.deactivateAccount(currentCustomer.getFullMsisdn());
			logAccess(OperationNames.BlackBerryForPrepaid, currentCustomer.getFullMsisdn(), "Deactivate Reason: " + reason);
			retrieveAccountInfo();
			reason = null;
			facesMessages.add(Severity.INFO, "Account suspended successfully..");
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Could not suspend account: " + e.getMessage());
		}
		
	}

	@Override
	public void refundReservation(BB4PReservation reservation) {
		try {
			bb4pGateway.refundReservation(currentCustomer.getFullMsisdn(), reservation.getId());
			logAccess(OperationNames.BlackBerryForPrepaid, currentCustomer.getFullMsisdn(), "Refund");
			facesMessages.add(Severity.INFO, "Reservation refunded successfully..");
			retrieveAccountInfo();
			retrievePendingReservations();
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Could not refund reservation: " + e.getMessage());
		}
		
	}

	@Override
	public void retrieveAccountInfo() {
		try {
			accountInfo = null;
			accountInfo = bb4pGateway.getAccountInfo(currentCustomer.getFullMsisdn());
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Cannot retrieve account info: " + e.getMessage());
		}
	}

	@Override
	public void retrieveTicketsHistory() {
		try {
			ticketsHistory = bb4pGateway.getTicketsHistory(currentCustomer.getFullMsisdn(), startDate, endDate);
			if(ticketsHistory.size() == 0) facesMessages.add(Severity.INFO, "No history records found..");
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Account history could not be retrieved: " + e.getMessage());
		}
	}

	@Override
	public void retrievePendingReservations() {
		try {
			pendingReservations = bb4pDao.getReservations(currentCustomer.getMsisdn());
			for(BB4PReservation r : pendingReservations.toArray(new BB4PReservation[pendingReservations.size()])) {
				if (!r.getStatus().equals(ReservationStatus.RESERVED)) {
					pendingReservations.remove(r);
				}
			}
			if(pendingReservations.size() == 0) facesMessages.add(Severity.INFO, "No pending reservations found..");
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Pending reservations could not be retrieved: " + e.getMessage());
		}
	}

	@Override
	public void suspendAccount() {
		try {
			bb4pGateway.suspendAccount(currentCustomer.getFullMsisdn());
			logAccess(OperationNames.BlackBerryForPrepaid, currentCustomer.getFullMsisdn(), "Suspend Reason: " + reason);
			retrieveAccountInfo();
			reason = null;
			facesMessages.add(Severity.INFO, "Account suspended successfully..");
		} catch(Exception e) {
			facesMessages.add(Severity.ERROR, "Could not suspend account: " + e.getMessage());
		}
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component BB4PCustomerCareService..");		
	}	
}
