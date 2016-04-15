package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class Subscription implements Serializable {

	protected Long id;
	protected String msisdn;
	protected String sim;
	protected String imsi;
	protected Date registrationDate;
	protected RegistrationStatus status;
	protected RegistrarType registrarType;
	protected ServiceType service;
	protected INCMStatus incmStatus;
	protected String saveUser;
		
	protected AbstractRegistrar registeredTo;
	
	public Subscription() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public RegistrationStatus getStatus() {
		return status;
	}

	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}
	
	public AbstractRegistrar getRegisteredTo() {
		return registeredTo;
	}

	public void setRegisteredTo(AbstractRegistrar registeredTo) {
		this.registeredTo = registeredTo;
		if(this.registrarType == null) this.registrarType = registeredTo.getRegistrarType();
		else if(!this.registrarType.equals(registeredTo.getRegistrarType())) this.registrarType = registeredTo.getRegistrarType();
	}
	
	public RegistrarType getRegistrarType() {
		return registrarType;
	}

	public void setRegistrarType(RegistrarType registrarType) {
		this.registrarType = registrarType;
	}
	
	public ServiceType getService() {
		return service;
	}

	public void setService(ServiceType service) {
		this.service = service;
	}
	
	public INCMStatus getINCMStatus() {
		return incmStatus;
	}

	public void setINCMStatus(INCMStatus incmStatus) {
		this.incmStatus = incmStatus;
	}
	
	public String getSaveUser() {
		return saveUser;
	}

	public void setSaveUser(String saveUser) {
		this.saveUser = saveUser;
	}
	
	public String getSim() {
		return sim;
	}

	public void setSim(String sim) {
		this.sim = sim;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public static Subscription addNewSubscription(Subscription mainSubscription)  {
		Subscription subscription = new Subscription();
		subscription.setINCMStatus(INCMStatus.SendToINCM);
		subscription.setRegistrationDate(new Date());
		subscription.setStatus(RegistrationStatus.TemporaryRegistered);
		mainSubscription.getRegisteredTo().addSubscription(subscription);
		return subscription;
	}
	
	public SubscriptionHistory retrieveUnregisterLog() {
		SubscriptionHistory history = new SubscriptionHistory();
		history.setMsisdn(getMsisdn());
		history.setRegisteredToId(getRegisteredTo().getId());
		history.setStatus(getStatus());
		history.setUnregisterDate(new Date());
		return history;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof Subscription))
			return false;
		Subscription castOther = (Subscription) other;
		return new EqualsBuilder().append(msisdn, castOther.msisdn).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(2053598295, 1447456691).append(msisdn)
				.toHashCode();
	}
	
	
}
