package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.ContactTypes;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementContact;

@Local
public interface IMainAgreementContactListAction {

	public List<ContactTypes> getContactTypesList();

	public void setContactTypesList(List<ContactTypes> contactTypesList);

	public List<MainAgreementContact> getMainAgreementContactList();

	public void setMainAgreementContactList(
			List<MainAgreementContact> mainAgreementContactList);

	public MainAgreementContact getSelectedMainAgreementContact();

	public void setSelectedMainAgreementContact(
			MainAgreementContact selectedMainAgreementContact);

	public void searchMainAgreementContact(MainAgreement mainAgreement);

	public void editMainAgreementContact(
			MainAgreementContact mainAgreementContact);

	public void newMainAgreementContact();

	public void deleteMainAgreementContact();

	public void saveMainAgreementContact();

	public List<ContactTypes> returnContactTypeList();

	public void remove();
}
