package co.mcel.mz.bb4p.model;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

import co.mcel.mz.bb4p.service.exception.InvalidReservationStatusException;
import co.mcel.mz.reservedcharging.model.ReservationStatus;

public class BB4PReservation implements Serializable {

	private static final long serialVersionUID = 5788318506841920165L;
	private String id;
	private String msisdn;
	private Date reservationDate;
	private Date processedDate;
	private float amount;
	private ReservationStatus status;
	
	public BB4PReservation() {
		super();
	}
	
	public BB4PReservation(String id, String msisdn, float amount) {
		this.id = id;
		this.msisdn = msisdn;
		this.amount = amount;
		this.reservationDate = new Date();
		this.status = ReservationStatus.RESERVED;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof BB4PReservation))
			return false;
		BB4PReservation castOther = (BB4PReservation) other;
		return new EqualsBuilder().append(id, castOther.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(2017873657, 550191505).append(id)
				.toHashCode();
	}
	
	public void cancel() throws InvalidReservationStatusException {
		if(getStatus().equals(ReservationStatus.RESERVED)) {
			setStatus(ReservationStatus.CANCELLED);
			setProcessedDate(new Date());
		} else throw new InvalidReservationStatusException(status);
	}
	
	public void refund() throws InvalidReservationStatusException {
		if(getStatus().equals(ReservationStatus.RESERVED)) {
			setStatus(ReservationStatus.REFUNDED);
			setProcessedDate(new Date());
		} else throw new InvalidReservationStatusException(status);
	}
	
	public void debit() throws InvalidReservationStatusException {
		if(getStatus().equals(ReservationStatus.RESERVED)) {
			setStatus(ReservationStatus.DEBITTED);
			setProcessedDate(new Date());
		} else throw new InvalidReservationStatusException(status);
	}
	
	
}
