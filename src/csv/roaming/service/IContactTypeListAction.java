package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.ContactTypes;

@Local
public interface IContactTypeListAction {

	public List<ContactTypes> getContactTypeList();

	public void setContactTypeList(List<ContactTypes> contactTypeList);

	public ContactTypes getSelectedContactType();

	public void setSelectedContactType(ContactTypes selectedContactType);

	public void searchContactTypes();

	public void editContactType(ContactTypes contactTypes);

	public void newContactType();

	public void deleteContactType();

	public void saveContactType();

	public void remove();
}
