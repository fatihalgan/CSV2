package co.mcel.mz.reservedcharging.service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.hibernate.HibernateException;
import org.hibernate.exception.ConstraintViolationException;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import co.mcel.mz.bb4p.service.exception.EmaException;
import co.mcel.mz.reservedcharging.dao.IReserveChargingDao;
import co.mcel.mz.reservedcharging.model.ChargingReservation;
import co.mcel.mz.reservedcharging.model.ChargingReservationPK;
import co.mcel.mz.reservedcharging.model.ReservationStatus;
import co.mcel.mz.reservedcharging.model.ReservedChargingMessage;
import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;
import co.mcel.mz.reservedcharging.service.exception.InvalidReservationStatusException;
import co.mcel.mz.reservedcharging.service.exception.ReservationNotFoundException;

import com.bridge.ena.cs.command.AbstractCSCommand;
import com.bridge.ena.cs3cp6.command.AbstractCS3CP6Command;

import csv.gateway.cs.AIRGateway;
import csv.gateway.hlr.EMAGateway;

@Name("reserveChargingService")
@Stateless
public class ReserveChargingService implements IReserveChargingService {

	@Logger
	protected Log logger;
	
	@In("reserveChargingDao")
	private IReserveChargingDao reserveChargingDao;
	
	@In("airGateway")
	private AIRGateway airGateway;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	private float decimalDenominator = 100;
	
	public ReserveChargingService() {
		super();
	}
	
	public void setAirGateway(AIRGateway airGateway) {
		this.airGateway = airGateway;
	}
	
	public void setReserveChargingDao(IReserveChargingDao reserveChargingDao) {
		this.reserveChargingDao = reserveChargingDao;
	}
	
	private String checkPrefix(String msisdn){
		if(null==msisdn)
			return "";
		if(msisdn.length()==12 && (msisdn.startsWith("25882") || msisdn.startsWith("25883")))
			return msisdn.substring(3);
		return msisdn;
	}

	private void creditAmount(String msisdn, String transactionID, String requesterService, float amount, String eventType) throws ChargingSystemException {
		try {
			airGateway.creditAmountForReservedCharging(msisdn, transactionID, requesterService, amount, eventType);
			createAudit(requesterService, "258" + msisdn, eventType, "0", new Date());
		} catch(ChargingSystemException e) {
			createAudit(requesterService, "258" + msisdn, eventType, String.valueOf(e.getResultCode()), new Date());
			throw e;
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void createAudit(String requesterService, String msisdn, String message, String responseCode, Date timestamp) {
		try {
			ReservedChargingMessage msg = new ReservedChargingMessage();
			msg.setAppName(requesterService);
			msg.setMsisdn(msisdn);
			msg.setMessage(message);
			msg.setResponseCode(responseCode);
			msg.setTimestamp(timestamp);
			reserveChargingDao.save(msg);
		} catch(Exception e) {
			logger.error("Could not audit BB4P message: " + e.getMessage());
		}
	}
	
	@Override
	public String getAccountType(String msisdn) throws ChargingSystemException {
		try {
			if(emaGateway.isPrepaidSubscriber(msisdn))
				return "PREPAID";
			else return "POSTPAID";
		} catch(EmaException e) {
			throw new ChargingSystemException(e.getResultCode(), "");
		}
	}
	
	@Override
	public ChargingReservation findReservationById(String id, String requesterService) throws ReservationNotFoundException {
		ChargingReservation reservation = (ChargingReservation)reserveChargingDao.get(ChargingReservation.class, new ChargingReservationPK(id, requesterService));
		if(reservation == null) throw new ReservationNotFoundException(id);
		return reservation;
	}

	@Override
	public void cancelReservation(String transactionId, String requesterService) 
		throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException {
		AbstractCSCommand cmd = null;
		ChargingReservation reservation = findReservationById(transactionId, requesterService);
		creditAmount(reservation.getMsisdn(), reservation.getId().getId(), reservation.getId().getRequesterService(), reservation.getAmount(), "Cancel Reservation: " + reservation.getId().getId());
		reservation.cancel();
		reserveChargingDao.update(reservation);
	}

	@Override
	public ReservationStatus checkStatus(String transactionId, String requesterService) throws ReservationNotFoundException {
		ChargingReservation reservation = findReservationById(transactionId, requesterService);
		return reservation.getStatus();
	}

	@Override
	public void createReservation(String transactionId, String requesterService, String msisdn, float amount, String description) throws ChargingSystemException {
		AbstractCSCommand cmd = null;
		ChargingReservation reservation = new ChargingReservation(transactionId, requesterService, checkPrefix(msisdn), amount, description);
		reserveChargingDao.save(reservation);
		try {
			creditAmount(reservation.getMsisdn(), transactionId, requesterService, -amount, "Create Reservation: " + transactionId);
		} catch(ConstraintViolationException ce) {
			throw new ChargingSystemException(199, "Duplicate Reservation");
		}
	}
	
	@Override
	public void createDirectDebit(String transactionId, String requesterService, String msisdn, float amount, String description) {
		ChargingReservation reservation = new ChargingReservation(transactionId, requesterService, msisdn, amount, description);
		reservation.setStatus(ReservationStatus.DIRECT);
		reserveChargingDao.save(reservation);
	}	

	@Override
	public void debitAmount(String transactionID, String requesterService) 
		throws InvalidReservationStatusException, ReservationNotFoundException {
		ChargingReservation reservation = findReservationById(transactionID, requesterService);
		reservation.debit();
		reserveChargingDao.update(reservation);
	}

	@Override
	public void refundReservation(String transactionId, String requesterService) 
		throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException {
		ChargingReservation reservation = findReservationById(transactionId, requesterService);
		creditAmount(reservation.getMsisdn(), transactionId, requesterService, reservation.getAmount(), "Refund To Customer: " + transactionId);
		reservation.refund();
		reserveChargingDao.update(reservation);
	}	
	
}
