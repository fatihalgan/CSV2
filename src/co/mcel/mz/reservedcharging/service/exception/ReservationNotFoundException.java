package co.mcel.mz.reservedcharging.service.exception;

public class ReservationNotFoundException extends Exception {

	private String reservationId;
	
	public ReservationNotFoundException(String reservationID) {
		this.reservationId = reservationID;
	}
	
	@Override
	public String getMessage() {
		return "Reservation Not Found: " + reservationId;
	}

	public String getReservationId() {
		return reservationId;
	}

	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}
	
}
