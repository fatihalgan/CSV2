package csv.roaming.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.ContactTypes;

@Name("contactTypeListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class ContactTypeListAction implements IContactTypeListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<ContactTypes> contactTypeList;

	private ContactTypes selectedContactType;

	public List<ContactTypes> getContactTypeList() {
		return contactTypeList;
	}

	public void setContactTypeList(List<ContactTypes> contactTypeList) {
		this.contactTypeList = contactTypeList;
	}

	public ContactTypes getSelectedContactType() {
		return selectedContactType;
	}

	public void setSelectedContactType(ContactTypes selectedContactType) {
		this.selectedContactType = selectedContactType;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component ContactTypeListAction..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchContactTypes() {
		contactTypeList = roamingDao.findAllContactTypes();

	}

	public void editContactType(ContactTypes contactTypes) {
		selectedContactType = contactTypes;
		logger.debug("Editing Contact Type: "
				+ selectedContactType.getDescription());
	}

	public void newContactType() {
		selectedContactType = new ContactTypes();
	}

	public void deleteContactType() {

		try {
			roamingDao.delete(selectedContactType);
			roamingDao.flush();
			contactTypeList = null;
			selectedContactType = null;

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting contact type!!! "
							+ e.getMessage());
		}
	}

	public void saveContactType() {

		try {
			roamingDao.saveOrUpdate(selectedContactType);
			roamingDao.flush();
			contactTypeList = null;
			selectedContactType = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving contact type!!! "
							+ e.getMessage());
		}
	}

}
