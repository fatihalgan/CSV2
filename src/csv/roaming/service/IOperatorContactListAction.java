package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.ContactTypes;
import csv.roaming.domain.OperatorContact;
import csv.roaming.domain.OperatorCountry;

@Local
public interface IOperatorContactListAction {

	public List<OperatorContact> getOperatorContactList();

	public void setOperatorContactList(List<OperatorContact> operatorContactList);

	public OperatorContact getSelectedOperatorContact();

	public void setSelectedOperatorContact(
			OperatorContact selectedOperatorContact);

	public void searchOperatorContact(OperatorCountry operatorCountry);

	public void editOperatorContact(OperatorContact operatorContact);

	public void newOperatorContact();

	public void deleteOperatorContact();

	public void saveOperatorContact();

	public List<ContactTypes> returnContactTypeList();

	public void remove();
}
