package csv.roaming.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class OperatorTariff implements java.io.Serializable {

	private Long operatorTariffId;
	private Service service;
	private OperatorCountry operatorCountry;
	private Double price;

	public OperatorTariff() {
		super();
	}

	public OperatorTariff(Long operatorTariffId, Service service,
			OperatorCountry operatorCountry, Double price) {
		super();
		this.operatorTariffId = operatorTariffId;
		this.service = service;
		this.operatorCountry = operatorCountry;
		this.price = price;
	}

	public Long getOperatorTariffId() {
		return operatorTariffId;
	}

	public void setOperatorTariffId(Long operatorTariffId) {
		this.operatorTariffId = operatorTariffId;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public OperatorCountry getOperatorCountry() {
		return operatorCountry;
	}

	public void setOperatorCountry(OperatorCountry operatorCountry) {
		this.operatorCountry = operatorCountry;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof OperatorTariff))
			return false;
		OperatorTariff castOther = (OperatorTariff) other;
		return new EqualsBuilder().append(service, castOther.service).append(
				operatorCountry, castOther.operatorCountry).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-439341925, 1913952613).append(service)
				.append(operatorCountry).toHashCode();
	}

}
