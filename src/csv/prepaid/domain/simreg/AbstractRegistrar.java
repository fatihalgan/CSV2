package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public abstract class AbstractRegistrar implements Serializable {

	protected Long id;
	protected String name;
	protected String surname;
	protected String otherNames;
	protected Date birthDate;
	protected String birthPlace;
	protected Gender gender;
	protected Country nationality;
	protected IdentificationDocument identityDocument = new IdentificationDocument();
	protected Address address = new Address();
	protected WorkInfo workInfo = new WorkInfo();
	protected DocumentCollector documentSource;
	protected String saveUser;
	protected Date saveDate;
	protected RegistrationStatus status;
	protected String documentsComplete;
	protected boolean requestMKesh;
	
	private Set<Subscription> currentSubscriptions = new HashSet<Subscription>();
	
	public AbstractRegistrar() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Country getNationality() {
		return nationality;
	}

	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public IdentificationDocument getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(IdentificationDocument identityDocument) {
		this.identityDocument = identityDocument;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public WorkInfo getWorkInfo() {
		return workInfo;
	}

	public void setWorkInfo(WorkInfo workInfo) {
		this.workInfo = workInfo;
	}
	
	public DocumentCollector getDocumentSource() {
		return documentSource;
	}

	public void setDocumentSource(DocumentCollector documentSource) {
		this.documentSource = documentSource;
	}

	public Set<Subscription> getCurrentSubscriptions() {
		return currentSubscriptions;
	}

	public void setCurrentSubscriptions(Set<Subscription> currentSubscriptions) {
		this.currentSubscriptions = currentSubscriptions;
	}
	
	public RegistrationStatus getStatus() {
		return status;
	}

	public void setStatus(RegistrationStatus status) {
		this.status = status;
	}
	
	public String getDocumentsComplete() {
		return documentsComplete;
	}

	public void setDocumentsComplete(String documentsComplete) {
		this.documentsComplete = documentsComplete;
	}

	public void addSubscription(Subscription subscription) {
		if(registrationLimitReached()) {
			throw new RuntimeException("This subscriber has reached the limit of maximum SIM card registrations..");
		}
		this.getCurrentSubscriptions().add(subscription);
		subscription.setRegisteredTo(this);
	}
	
	public void removeSubscription(Subscription subscription) {
		this.getCurrentSubscriptions().remove(subscription);
		subscription.setRegisteredTo(null);
	}
	
	public Subscription retrieveSubscription(String msisdn) {
		for(Subscription subscription : currentSubscriptions) {
			if(subscription.getMsisdn().equals(msisdn)) return subscription;
		}
		return null;
	}
	
	public List<Subscription> getCurrentSubscriptionList() {
		return new ArrayList<Subscription>(currentSubscriptions);
	}
	
	public String getSaveUser() {
		return saveUser;
	}

	public void setSaveUser(String saveUser) {
		this.saveUser = saveUser;
	}

	public Date getSaveDate() {
		return saveDate;
	}

	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
	
	public boolean isRequestMKesh() {
		return requestMKesh;
	}

	public void setRequestMKesh(boolean requestMKesh) {
		this.requestMKesh = requestMKesh;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof AbstractRegistrar))
			return false;
		AbstractRegistrar castOther = (AbstractRegistrar) other;
		return new EqualsBuilder().append(identityDocument,
				castOther.identityDocument).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-785368661, 1456632507).append(
				identityDocument).toHashCode();
	}
	
	public abstract RegistrarType getRegistrarType();
	
	public abstract boolean registrationLimitReached();
	
	
}
