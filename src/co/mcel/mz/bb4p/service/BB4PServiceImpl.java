package co.mcel.mz.bb4p.service;

import java.util.Date;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import com.bridge.ena.cs.command.AbstractCSCommand;
import co.mcel.mz.bb4p.dao.IBB4PDao;
import co.mcel.mz.bb4p.model.BB4PReservation;
import co.mcel.mz.bb4p.service.exception.EmaException;
import co.mcel.mz.bb4p.service.exception.InvalidReservationStatusException;
import co.mcel.mz.bb4p.service.exception.ReservationNotFoundException;
import co.mcel.mz.reservedcharging.model.ReservationStatus;
import co.mcel.mz.reservedcharging.model.ReservedChargingMessage;
import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;
import csv.gateway.cs.AIRGateway;
import csv.gateway.hlr.EMAGateway;

@Name("bb4pService")
@Stateless
public class BB4PServiceImpl implements IBB4PService {

	@Logger
	protected Log logger;
	
	@In("bb4pDao")
	private IBB4PDao bb4pDao;
	
	@In("airGateway")
	private AIRGateway airGateway;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	public BB4PServiceImpl() {
		super();
	}

	public void setBb4pDao(IBB4PDao bb4pDao) {
		this.bb4pDao = bb4pDao;
	}

	public void setAirGateway(AIRGateway airGateway) {
		this.airGateway = airGateway;
	}

	public void setEmaGateway(EMAGateway emaGateway) {
		this.emaGateway = emaGateway;
	}
	
	private String checkPrefix(String msisdn){
		if(null==msisdn)
			return "";
		if(msisdn.length()==12 && (msisdn.startsWith("25882") || msisdn.startsWith("25883")))
			return msisdn.substring(3);
		return msisdn;
	}
	
	@Override
	public BB4PReservation findReservationById(String id) throws ReservationNotFoundException {
		BB4PReservation reservation = (BB4PReservation)bb4pDao.get(BB4PReservation.class, id);
		if(reservation == null) throw new ReservationNotFoundException(id);
		return reservation;
	}
	
	@Override
	public ReservationStatus checkStatus(String transactionId) throws ReservationNotFoundException {
		BB4PReservation reservation = findReservationById(transactionId);
		return reservation.getStatus();
	}
	
	@Override
	public Integer getServiceClass(String msisdn) throws ChargingSystemException {
		AbstractCSCommand cmd = airGateway.getBalanceAndDate(checkPrefix(msisdn));
		return cmd.getServiceClassCurrent();
	}

	private void creditAmount(String msisdn, String transactionID, String requesterService, float amount, String eventType) throws ChargingSystemException {
		try {
			airGateway.creditAmountForBB4P(msisdn, transactionID, requesterService, amount, eventType);
			createAudit("258" + msisdn, eventType, "0", new Date());
		} catch(ChargingSystemException e) {
			createAudit("258" + msisdn, eventType, String.valueOf(e.getResultCode()), new Date());
			throw e;
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void createAudit(String msisdn, String message, String responseCode, Date timestamp) {
		try {
			ReservedChargingMessage msg = new ReservedChargingMessage();
			msg.setAppName("BB4P");
			msg.setMsisdn(msisdn);
			msg.setMessage(message);
			msg.setResponseCode(responseCode);
			msg.setTimestamp(timestamp);
			bb4pDao.save(msg);
		} catch(Exception e) {
			logger.error("Could not audit BB4P message: " + e.getMessage());
		}
	}

	
	@Override
	public  void debitAmount(String transactionID) throws InvalidReservationStatusException, ReservationNotFoundException {
		BB4PReservation reservation =  findReservationById(transactionID);
		reservation.debit();
		bb4pDao.update(reservation);
	}

	@Override
	public void cancelReservation(String transactionId) throws ReservationNotFoundException, 
		InvalidReservationStatusException, ChargingSystemException {
		BB4PReservation reservation = findReservationById(transactionId);
		creditAmount(reservation.getMsisdn(), reservation.getId(), "BB4P", reservation.getAmount(), "Cancel Reservation: " + reservation.getId());
		reservation.cancel();
		bb4pDao.update(reservation);
	}
	
	@Override
	public void createReservation(String transactionId, String msisdn, float amount) throws ChargingSystemException {
		BB4PReservation reservation = new BB4PReservation(transactionId, checkPrefix(msisdn), amount);
		creditAmount(reservation.getMsisdn(), transactionId, "BB4P", -amount, "Create Reservation: " + transactionId);
		bb4pDao.save(reservation);
	}

	@Override
	public void refundReservation(String transactionId) 
		throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException {
		BB4PReservation reservation = findReservationById(transactionId);
		creditAmount(reservation.getMsisdn(), transactionId, "BB4P", reservation.getAmount(), "Refund To Customer: " + transactionId);
		reservation.refund();
		bb4pDao.update(reservation);			
	}
	
	public String getImsi(String prefix, String msisdn) throws EmaException {
		return emaGateway.getImsiForMsisdn(prefix + msisdn); 
	}
	
	public void registerAPN(String msisdn) throws EmaException {
		try {
			emaGateway.registerBlackbberyAPN(msisdn);
			createAudit(msisdn, "Register BB4P APN", "0", new Date());
		} catch(EmaException e) {
			createAudit(msisdn, "Register BB4P APN", String.valueOf(e.getResultCode()), new Date());
			throw e;
		}
	}
	
	public void unRegisterAPN(String msisdn) throws EmaException {
		try {
			emaGateway.unregisterBlackberryAPN(msisdn);
			createAudit(msisdn, "Unregister BB4P APN", "0", new Date());
		} catch(EmaException e) {
			createAudit(msisdn, "Unregister BB4P APN", String.valueOf(e.getResultCode()), new Date());
			throw e;
		}
	}
	
	
}
