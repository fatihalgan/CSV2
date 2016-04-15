package co.mcel.mz.reservedcharging.service;

import java.util.Date;

import javax.ejb.Local;

import co.mcel.mz.reservedcharging.model.ChargingReservation;
import co.mcel.mz.reservedcharging.model.ReservationStatus;
import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;
import co.mcel.mz.reservedcharging.service.exception.InvalidReservationStatusException;
import co.mcel.mz.reservedcharging.service.exception.ReservationNotFoundException;

@Local
public interface IReserveChargingService {

	public ChargingReservation findReservationById(String id, String requesterService) throws ReservationNotFoundException;
	public String getAccountType(String msisdn) throws ChargingSystemException;
	public ReservationStatus checkStatus(String transactionId, String requesterService) throws ReservationNotFoundException;
	public void debitAmount(String transactionID, String requesterService) throws InvalidReservationStatusException, ReservationNotFoundException;
	public void createDirectDebit(String transactionId, String requesterService, String msisdn, float amount, String description);
	public void createReservation(String transactionId, String requesterService, String msisdn, float amount, String description) throws ChargingSystemException;
	public void cancelReservation(String transactionId, String requesterService) throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException;
	public void refundReservation(String transactionId, String requesterService) throws ReservationNotFoundException, InvalidReservationStatusException, ChargingSystemException;
	public void createAudit(String requesterService, String msisdn, String message, String responseCode, Date timestamp);
}
