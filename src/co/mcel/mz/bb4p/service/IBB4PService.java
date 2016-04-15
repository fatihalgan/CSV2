package co.mcel.mz.bb4p.service;

import java.util.Date;

import javax.ejb.Local;

import co.mcel.mz.bb4p.model.BB4PReservation;
import co.mcel.mz.bb4p.service.exception.EmaException;
import co.mcel.mz.bb4p.service.exception.InvalidReservationStatusException;
import co.mcel.mz.bb4p.service.exception.ReservationNotFoundException;
import co.mcel.mz.reservedcharging.model.ReservationStatus;
import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;

@Local
public interface IBB4PService {
	public BB4PReservation findReservationById(String id) throws ReservationNotFoundException;
	public ReservationStatus checkStatus(String transactionId) throws ReservationNotFoundException;
	public void debitAmount(String transactionID) throws InvalidReservationStatusException, ReservationNotFoundException;
	public void createReservation(String transactionId, String msisdn, float amount) throws ChargingSystemException;
	public void cancelReservation(String transactionId) throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException;
	public Integer getServiceClass(String msisdn) throws ChargingSystemException;
	public void refundReservation(String transactionId) throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException;
	public void registerAPN(String msisdn) throws EmaException;
	public void unRegisterAPN(String msisdn) throws EmaException;
	public String getImsi(String prefix, String msisdn) throws EmaException;
	public void createAudit(String msisdn, String message, String responseCode, Date timestamp);
}
