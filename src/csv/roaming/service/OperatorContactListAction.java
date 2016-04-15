package csv.roaming.service;

import java.io.Serializable;
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
import csv.roaming.domain.OperatorContact;
import csv.roaming.domain.OperatorCountry;

@Name("operatorContactListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorContactListAction implements IOperatorContactListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private OperatorCountry selectedOperatorCountry;

	private List<OperatorContact> operatorContactList;

	private OperatorContact selectedOperatorContact;

	public List<OperatorContact> getOperatorContactList() {
		return operatorContactList;
	}

	public void setOperatorContactList(List<OperatorContact> operatorContactList) {
		this.operatorContactList = operatorContactList;
	}

	public OperatorContact getSelectedOperatorContact() {
		return selectedOperatorContact;
	}

	public void setSelectedOperatorContact(
			OperatorContact selectedOperatorContact) {
		this.selectedOperatorContact = selectedOperatorContact;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorContactListAction..");
	}

	@Observer("operatorRegion.details")
	public void searchOperatorContact(OperatorCountry operatorCountry) {
		if (operatorCountry != null) {
			selectedOperatorCountry = operatorCountry;
		}

		operatorContactList = roamingDao
				.findAllContactsByOperatorCountry(selectedOperatorCountry);

	}

	public void editOperatorContact(OperatorContact operatorContact) {
		selectedOperatorContact = operatorContact;
		logger.debug("Editing OperatorContact: "
				+ operatorContact.getOperatorCountry().getOperator()
						.getOperatorName() + ":"
				+ operatorContact.getOperatorContactId());
	}

	public void newOperatorContact() {
		selectedOperatorContact = new OperatorContact();
	}

	public void deleteOperatorContact() {
		try {
			roamingDao.delete(selectedOperatorContact);
			roamingDao.flush();
			selectedOperatorContact = null;
			operatorContactList = roamingDao
					.findAllContactsByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Operator Contact!!! "
							+ e.getMessage());
		}
	}

	public void saveOperatorContact() {
		if (selectedOperatorCountry == null) {
			facesMessages.add("Selected Operator Null", new Object[] {});
			return;

		}
		try {
			selectedOperatorContact.setOperatorCountry(selectedOperatorCountry);
			roamingDao.saveOrUpdate(selectedOperatorContact);
			roamingDao.flush();
			selectedOperatorContact = null;
			operatorContactList = roamingDao
					.findAllContactsByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Contact!!! "
							+ e.getMessage());
		}
	}

	public List<ContactTypes> returnContactTypeList() {
		return roamingDao.findAllContactTypes();
	}
}
