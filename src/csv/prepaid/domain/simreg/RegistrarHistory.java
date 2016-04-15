package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.Date;

public class RegistrarHistory implements Serializable {

	private Long id;
	private Date changedOn;
	private String changedBy;
	private RegistrarRecordChangeReason changeReason;
	private Country nationality;
	private Long registrarId;
	private String name;
	private String surname;
	private String otherNames;
	private Date birthDate;
	private String birthPlace;
	private Gender gender;
	private String saveUser;
	private Date saveDate;
	private RegistrationStatus status;
	private String documentsComplete;
	private boolean requestMKesh;
	private String typeOfSubs;
	
	private DocumentCollector documentSource;
	private IdentificationDocument identityDocument;
	private Address address;
	private WorkInfo workInfo;
	
	public RegistrarHistory() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getChangedOn() {
		return changedOn;
	}


	public void setChangedOn(Date changedOn) {
		this.changedOn = changedOn;
	}


	public String getChangedBy() {
		return changedBy;
	}


	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}


	public RegistrarRecordChangeReason getChangeReason() {
		return changeReason;
	}


	public void setChangeReason(RegistrarRecordChangeReason changeReason) {
		this.changeReason = changeReason;
	}


	public Long getRegistrarId() {
		return registrarId;
	}


	public void setRegistrarId(Long registrarId) {
		this.registrarId = registrarId;
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


	public boolean isRequestMKesh() {
		return requestMKesh;
	}


	public void setRequestMKesh(boolean requestMKesh) {
		this.requestMKesh = requestMKesh;
	}


	public String getTypeOfSubs() {
		return typeOfSubs;
	}


	public void setTypeOfSubs(String typeOfSubs) {
		this.typeOfSubs = typeOfSubs;
	}


	public DocumentCollector getDocumentSource() {
		return documentSource;
	}


	public void setDocumentSource(DocumentCollector documentSource) {
		this.documentSource = documentSource;
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


	public Country getNationality() {
		return nationality;
	}


	public void setNationality(Country nationality) {
		this.nationality = nationality;
	}
	
	
	
}
