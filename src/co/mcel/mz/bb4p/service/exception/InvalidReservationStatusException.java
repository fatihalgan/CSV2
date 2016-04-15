package co.mcel.mz.bb4p.service.exception;

import co.mcel.mz.reservedcharging.model.ReservationStatus;

public class InvalidReservationStatusException extends Exception {

	private ReservationStatus currentStatus;
	
	public InvalidReservationStatusException(ReservationStatus currentStatus) {
		this.currentStatus = currentStatus;
	}
	
	public ReservationStatus getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(ReservationStatus currentStatus) {
		this.currentStatus = currentStatus;
	}

	@Override
	public String getMessage() {
		return "Reservation was already processed. Current reservation status is: " + currentStatus.name();
	}
}
