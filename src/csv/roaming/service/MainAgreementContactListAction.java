package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.ContactTypes;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementContact;

@Name("mainAgreementContactListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementContactListAction implements
		IMainAgreementContactListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private MainAgreement selectedMainAgreement;

	private List<MainAgreementContact> mainAgreementContactList;

	private MainAgreementContact selectedMainAgreementContact;

	private List<ContactTypes> contactTypesList;

	public List<ContactTypes> getContactTypesList() {
		if (contactTypesList == null) {
			contactTypesList = new ArrayList<ContactTypes>();
		}
		return contactTypesList;
	}

	public void setContactTypesList(List<ContactTypes> contactTypesList) {
		this.contactTypesList = contactTypesList;
	}

	public MainAgreement getSelectedMainAgreement() {
		return selectedMainAgreement;
	}

	public void setSelectedMainAgreement(MainAgreement selectedMainAgreement) {
		this.selectedMainAgreement = selectedMainAgreement;
	}

	public List<MainAgreementContact> getMainAgreementContactList() {
		if (mainAgreementContactList == null) {
			mainAgreementContactList = new ArrayList<MainAgreementContact>();
		}
		return mainAgreementContactList;
	}

	public void setMainAgreementContactList(
			List<MainAgreementContact> mainAgreementContactList) {
		this.mainAgreementContactList = mainAgreementContactList;
	}

	public MainAgreementContact getSelectedMainAgreementContact() {
		return selectedMainAgreementContact;
	}

	public void setSelectedMainAgreementContact(
			MainAgreementContact selectedMainAgreementContact) {
		this.selectedMainAgreementContact = selectedMainAgreementContact;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component MainAgreementContactListAction..");
	}

	@Observer("mainAgreement.details")
	public void searchMainAgreementContact(MainAgreement mainAgreement) {
		if (mainAgreement != null) {
			selectedMainAgreement = mainAgreement;
		}

		contactTypesList = roamingDao.findAllContactTypes();

		mainAgreementContactList = roamingDao
				.findAllContactsByMainAgreement(selectedMainAgreement);

	}

	public void editMainAgreementContact(
			MainAgreementContact mainAgreementContact) {
		selectedMainAgreementContact = mainAgreementContact;
		logger.debug("Editing MainAgreementContact: "
				+ mainAgreementContact.getMainAgreement().getDescription()
				+ ":" + mainAgreementContact.getMainAgreementContactId());
	}

	public void newMainAgreementContact() {
		selectedMainAgreementContact = new MainAgreementContact();
	}

	public void deleteMainAgreementContact() {
		try {
			roamingDao.delete(selectedMainAgreementContact);
			roamingDao.flush();
			selectedMainAgreementContact = null;
			mainAgreementContactList = roamingDao
					.findAllContactsByMainAgreement(selectedMainAgreement);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Main Agreement Contact!!! "
							+ e.getMessage());
		}
	}

	public void saveMainAgreementContact() {
		if (selectedMainAgreement == null) {
			facesMessages.add("Selected MainAgreement Null", new Object[] {});
			return;

		}
		try {
			selectedMainAgreementContact
					.setMainAgreement(selectedMainAgreement);
			roamingDao.saveOrUpdate(selectedMainAgreementContact);
			roamingDao.flush();
			selectedMainAgreementContact = null;
			mainAgreementContactList = roamingDao
					.findAllContactsByMainAgreement(selectedMainAgreement);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement Contact!!! "
							+ e.getMessage());
		}
	}

	public List<ContactTypes> returnContactTypeList() {
		return roamingDao.findAllContactTypes();
	}
}
