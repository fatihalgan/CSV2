package csv.roaming.domain;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Service implements java.io.Serializable {
	private Long serviceId;
	private String serviceName;
	private RoamingLineType lineType;
	private RoamingServiceType serviceType;
	private Set<OperatorTariff> operatorTariffs = new HashSet<OperatorTariff>(0);

	public Service() {
		super();
	}

	public Service(Long serviceId, String serviceName,
			RoamingLineType lineType, RoamingServiceType serviceType,
			Set<OperatorTariff> operatorTariffs) {
		super();
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		this.lineType = lineType;
		this.serviceType = serviceType;
		this.operatorTariffs = operatorTariffs;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public RoamingLineType getLineType() {
		return lineType;
	}

	public void setLineType(RoamingLineType lineType) {
		this.lineType = lineType;
	}

	public RoamingServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(RoamingServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Set<OperatorTariff> getOperatorTariffs() {
		return operatorTariffs;
	}

	public void setOperatorTariffs(Set<OperatorTariff> operatorTariffs) {
		this.operatorTariffs = operatorTariffs;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Service))
			return false;
		Service castOther = (Service) other;
		return new EqualsBuilder().append(serviceName, castOther.serviceName)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1006652465, -1763332965).append(serviceName)
				.toHashCode();
	}

}
