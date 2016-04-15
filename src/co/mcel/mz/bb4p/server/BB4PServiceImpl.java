package co.mcel.mz.bb4p.server;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Lifecycle;

import co.mcel.mz.bb4p.CheckStatusResponse_type0;
import co.mcel.mz.bb4p.CsError;
import co.mcel.mz.bb4p.EmaError;
import co.mcel.mz.bb4p.service.IBB4PService;
import co.mcel.mz.bb4p.service.exception.EmaException;
import co.mcel.mz.bb4p.service.exception.InvalidReservationStatusException;
import co.mcel.mz.bb4p.service.exception.ReservationNotFoundException;
import co.mcel.mz.reservedcharging.model.ReservationStatus;
import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;
import co.mcel.mz.types.common.CSErrorType;
import co.mcel.mz.types.common.EMAErrorType;
import co.mcel.mz.types.common.MsisdnType;

public class BB4PServiceImpl implements BB4PServiceSkeletonInterface {

	private static final Log logger = LogFactory.getLog(BB4PServiceImpl.class);
	
	public BB4PServiceImpl() {
		super();
	}
	
	@Override
	public boolean cancelReservation(String cancelReservationRequest6)
		throws CSVSystemError, InvalidReservationStatus, CSError, TransactionNotFound {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			service.cancelReservation(cancelReservationRequest6);
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
	public CheckStatusResponse_type0 checkStatus(String checkStatusRequest14)
			throws TransactionNotFound, CSVSystemError {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			ReservationStatus status = service.checkStatus(checkStatusRequest14);
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
	public boolean debitAmount(String debitAmountRequest1)
			throws InvalidReservationStatus, CSVSystemError,
			TransactionNotFound {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			service.debitAmount(debitAmountRequest1);
			return true;
		} catch(InvalidReservationStatusException ie) {
			throw processInvalidReservationStatus(ie);
		} catch(ReservationNotFoundException ie) {
			throw processTransactionNotFound(ie);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public String getImsi(String internationalPrefix, String number)
			throws CSVSystemError, EMAError {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			String imsi = service.getImsi(internationalPrefix, number);
			return imsi;
		} catch(EmaException em) {
			throw processEmaError(em);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public int getServiceClass(String internationalPrefix9, String number10)
			throws CSVSystemError, CSError {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			Integer sc = service.getServiceClass(number10);
			return sc;
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
	public boolean refund(String refundRequest16) throws CSVSystemError,
			InvalidReservationStatus, CSError, TransactionNotFound {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			service.refundReservation(refundRequest16);
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
	public boolean registerAPN(MsisdnType msisdn, int anpId)
		throws CSVSystemError, EMAError {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			service.registerAPN(msisdn.getInternationalPrefix() + msisdn.getNumber());
			return true;
		} catch(EmaException em) {
			logger.error(em.getMessage() + em.getResultCode());
			throw processEmaError(em);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public boolean reserveAmount(MsisdnType msisdn12, String transactionId,
			float amount) throws CSVSystemError, CSError {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			service.createReservation(transactionId, msisdn12.getNumber(), amount);
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
	public boolean unregisterAPN(MsisdnType msisdn3, int apnId4)
			throws CSVSystemError, EMAError {
		try {
			Lifecycle.beginCall();
			IBB4PService service = (IBB4PService)Component.getInstance("bb4pService");
			service.unRegisterAPN(msisdn3.getInternationalPrefix() + msisdn3.getNumber());
			return true;
		} catch(EmaException em) {
			logger.error(em.getMessage() + em.getResultCode());
			throw processEmaError(em);
		} catch(Exception e) {
			logger.error("System Error: " + e.getMessage());
			throw processCSVSystemError(e);
		} finally {
			Lifecycle.endCall();
		}
	}
	
	private EMAError processEmaError(EmaException ex) {
		EMAErrorType emaErrorType = new EMAErrorType();
		emaErrorType.setErrorCode(ex.getResultCode());
		if(ex.getMessage() != null)emaErrorType.setMessage(ex.getMessage());
		else emaErrorType.setMessage(String.valueOf(ex.getResultCode()));
		EmaError error = new EmaError();
		error.setEmaError(emaErrorType);
		EMAError exception = new EMAError();
		exception.setFaultMessage(error);
		return exception;
	}
	
	private CSError processCSError(co.mcel.mz.reservedcharging.service.exception.ChargingSystemException ce) {
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
		co.mcel.mz.bb4p.InvalidReservationStatus ex = new co.mcel.mz.bb4p.InvalidReservationStatus();
		ex.setInvalidReservationStatus(e.getCurrentStatus().name());
		status.setFaultMessage(ex);
		return status;
	}

	private TransactionNotFound processTransactionNotFound(ReservationNotFoundException e) {
		TransactionNotFound status = new TransactionNotFound();
		co.mcel.mz.bb4p.TransactionNotFound ex = new co.mcel.mz.bb4p.TransactionNotFound();
		ex.setTransactionNotFound(e.getReservationId());
		status.setFaultMessage(ex);
		return status;
	}
	
	private CSVSystemError processCSVSystemError(Exception e) {
		CSVSystemError status = new CSVSystemError();
		co.mcel.mz.bb4p.CsvSystemError ex = new co.mcel.mz.bb4p.CsvSystemError();
		ex.setCsvSystemError(e.getMessage());
		status.setFaultMessage(ex);
		return status;
	}

}
