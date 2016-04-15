package co.mcel.mz.reservedcharging.model;

import java.io.Serializable;

public class ChargingReservationPK implements Serializable {
	
	private static final long serialVersionUID = -727533137358500694L;
	private String id;
	private String requesterService;
	
	public ChargingReservationPK() {
		super();
	}
	
	public ChargingReservationPK(String id, String requesterService) {
		this.id = id;
		this.requesterService = requesterService;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRequesterService() {
		return requesterService;
	}
	public void setRequesterService(String requesterService) {
		this.requesterService = requesterService;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((requesterService == null) ? 0 : requesterService.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChargingReservationPK other = (ChargingReservationPK) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (requesterService == null) {
			if (other.requesterService != null)
				return false;
		} else if (!requesterService.equals(other.requesterService))
			return false;
		return true;
	}
	
}
