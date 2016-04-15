package co.mcel.mz.reservedcharging.model;

import java.io.Serializable;
import java.util.Date;

import co.mcel.mz.reservedcharging.service.exception.InvalidReservationStatusException;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ChargingReservation implements Serializable {

	private static final long serialVersionUID = 8703302272912946708L;
	
	private ChargingReservationPK id;
	private String msisdn;
	private Date reservationDate;
	private Date processedDate;
	private float amount;
	private String description;
	private ReservationStatus status;
	
	public ChargingReservation() {
		super();
	}
	
	public ChargingReservation(String id, String requesterService, String msisdn, float amount, String description) {
		this.id = new ChargingReservationPK(id, requesterService);
		this.msisdn = msisdn;
		this.amount = amount;
		this.reservationDate = new Date();
		this.description = description;
		this.status = ReservationStatus.RESERVED;
	}
	
	public ChargingReservationPK getId() {
		return id;
	}

	public void setId(ChargingReservationPK id) {
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
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof ChargingReservation))
			return false;
		ChargingReservation castOther = (ChargingReservation) other;
		return new EqualsBuilder().append(id, castOther.id).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-934768951, -1344616567).append(id)
				.toHashCode();
	}

}
