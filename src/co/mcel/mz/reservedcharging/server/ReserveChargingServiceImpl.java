package co.mcel.mz.reservedcharging.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Lifecycle;

import com.bridge.ena.cs.command.AbstractCSCommand;
import co.mcel.mz.reservedcharging.CheckStatusResponse_type0;
import co.mcel.mz.reservedcharging.CsError;
import co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0;
import co.mcel.mz.reservedcharging.model.ReservationStatus;
import co.mcel.mz.reservedcharging.service.IReserveChargingService;
import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;
import co.mcel.mz.reservedcharging.service.exception.InvalidReservationStatusException;
import co.mcel.mz.reservedcharging.service.exception.ReservationNotFoundException;
import co.mcel.mz.types.common.CSErrorType;
import co.mcel.mz.types.common.MsisdnType;

public class ReserveChargingServiceImpl implements ReserveChargingServiceSkeletonInterface {

	private static final Log logger = LogFactory.getLog(ReserveChargingServiceImpl.class);
	
	public ReserveChargingServiceImpl() {
		super();
	}
	
	@Override
	public boolean cancelReservation(String transactionId, String requesterService) 
		throws CSVSystemError, InvalidReservationStatus, CSError, TransactionNotFound {
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			reserveChargingService.cancelReservation(transactionId, requesterService);
			return true;
		} catch(InvalidReservationStatusException ie) {
			throw processInvalidReservationStatus(ie);
		} catch(ReservationNotFoundException ie) {
			throw processTransactionNotFound(ie);
		} catch(ChargingSystemException ce) {
			logger.error(ce.getMessage() + ce.getResultCode());
			throw processCSError(ce);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public CheckStatusResponse_type0 checkStatus(String transactionId, String requesterService) throws TransactionNotFound, CSVSystemError {
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			ReservationStatus status = reserveChargingService.checkStatus(transactionId, requesterService);
			if(status.equals(ReservationStatus.CANCELLED)) return CheckStatusResponse_type0.CANCELLED;
			if(status.equals(ReservationStatus.DEBITTED)) return CheckStatusResponse_type0.DEBITTED;
			if(status.equals(ReservationStatus.REFUNDED)) return CheckStatusResponse_type0.REFUNDED;
			if(status.equals(ReservationStatus.RESERVED)) return CheckStatusResponse_type0.RESERVED;
			else throw processCSVSystemError(new Exception("Invalid Status in Transaction.."));
		 } catch(ReservationNotFoundException e) {
			 throw processTransactionNotFound(e);
		 } catch(Exception e) { 
			 logger.error("System Error: " + e.getMessage());
			 throw processCSVSystemError(e);
		 } finally {
			 Lifecycle.endCall();
		 }
	}

	@Override
	public boolean debitAmount(String transactionId10, String requesterService11)
		throws InvalidReservationStatus, CSVSystemError, TransactionNotFound {
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			reserveChargingService.debitAmount(transactionId10, requesterService11);
			return true;
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public boolean refund(String transactionId1, String requesterService2)
		throws CSVSystemError, InvalidReservationStatus, CSError, TransactionNotFound {
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			reserveChargingService.refundReservation(transactionId1, requesterService2);
			return true;
		} catch(InvalidReservationStatusException e) {
			throw processInvalidReservationStatus(e);
		} catch(ReservationNotFoundException e) {
			throw processTransactionNotFound(e);
		} catch(ChargingSystemException ce) {
			logger.error(ce.getMessage() + ce.getResultCode());
			throw processCSError(ce);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public boolean reserveAmount(MsisdnType msisdn, String transactionId4,
		String requesterService5, float amount, String description) throws CSVSystemError, CSError {
		AbstractCSCommand cmd = null;
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			reserveChargingService.createReservation(transactionId4, requesterService5, msisdn.getNumber(), amount, description);
			return true;
		} catch(ChargingSystemException ce) {
			logger.error(ce.getMessage() + ce.getResultCode());
			throw processCSError(ce);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}
	
	@Override
	public boolean directDebit(MsisdnType msisdn, String transactionId1, String requesterService2, float amount, String description)
		throws CSVSystemError {
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			reserveChargingService.createDirectDebit(transactionId1, requesterService2, msisdn.getNumber(), amount, description);
			return true;
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}
	
	@Override
	public GetAccountTypeResponse_type0 getAccountType(MsisdnType msisdn13)
		throws CSError, CSVSystemError {
		try {
			Lifecycle.beginCall();
			IReserveChargingService reserveChargingService = (IReserveChargingService)Component.getInstance("reserveChargingService");
			String type = reserveChargingService.getAccountType(msisdn13.getInternationalPrefix() + msisdn13.getNumber());
			if(type.equals(GetAccountTypeResponse_type0._PREPAID)) return GetAccountTypeResponse_type0.PREPAID;
			else if(type.equals(GetAccountTypeResponse_type0._POSTPAID)) return GetAccountTypeResponse_type0.POSTPAID;
			return null;
		} catch(ChargingSystemException ce) {
			logger.error(ce.getMessage() + ce.getResultCode());
			throw processCSError(ce);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}
	
	private CSError processCSError(ChargingSystemException ce) {
		CSErrorType csErrorType = new CSErrorType();
		csErrorType.setErrorCode(ce.getResultCode());
		csErrorType.setMessage(ce.getMessage());
		CsError error = new CsError();
		error.setCsError(csErrorType);
		CSError exception = new CSError();
		exception.setFaultMessage(error);
		return exception;
	}
	
	private InvalidReservationStatus processInvalidReservationStatus(InvalidReservationStatusException e) {
		InvalidReservationStatus status = new InvalidReservationStatus();
		co.mcel.mz.reservedcharging.InvalidReservationStatus ex = new co.mcel.mz.reservedcharging.InvalidReservationStatus();
		ex.setInvalidReservationStatus(e.getCurrentStatus().name());
		status.setFaultMessage(ex);
		return status;
	}

	private TransactionNotFound processTransactionNotFound(ReservationNotFoundException e) {
		TransactionNotFound status = new TransactionNotFound();
		co.mcel.mz.reservedcharging.TransactionNotFound ex = new co.mcel.mz.reservedcharging.TransactionNotFound();
		ex.setTransactionNotFound(e.getReservationId());
		status.setFaultMessage(ex);
		return status;
	}
	
	private CSVSystemError processCSVSystemError(Exception e) {
		CSVSystemError status = new CSVSystemError();
		co.mcel.mz.reservedcharging.CsvSystemError ex = new co.mcel.mz.reservedcharging.CsvSystemError();
		ex.setCsvSystemError(e.getMessage());
		status.setFaultMessage(ex);
		return status;
	}
	
	
	
}
