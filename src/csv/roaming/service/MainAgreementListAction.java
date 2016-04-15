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
import org.jboss.seam.core.Events;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.MainAgreement;

@Name("mainAgreementListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementListAction implements IMainAgreementListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<MainAgreement> mainAgreementList;

	private MainAgreement selectedMainAgreement;

	private String agreementName = "";

	public String getAgreementName() {
		return agreementName;
	}

	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}

	public List<MainAgreement> getMainAgreementList() {
		return mainAgreementList;
	}

	public void setMainAgreementList(List<MainAgreement> mainAgreementList) {
		this.mainAgreementList = mainAgreementList;
	}

	public MainAgreement getSelectedMainAgreement() {
		return selectedMainAgreement;
	}

	public void setSelectedMainAgreement(MainAgreement selectedMainAgreement) {
		this.selectedMainAgreement = selectedMainAgreement;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component MainAgreementListAction..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchMainAgreement() {
		agreementName = "";
		mainAgreementList = roamingDao.findAllMainAgreements();

	}

	public void searchMainAgreementsByName() {
		mainAgreementList = roamingDao
				.findAllMainAgreementsByName(agreementName);
	}

	public void editMainAgreement(MainAgreement mainAgreement) {
		selectedMainAgreement = mainAgreement;
		logger.debug("Editing Main Agreement: "
				+ mainAgreement.getDescription());
	}

	public void newMainAgreement() {
		selectedMainAgreement = new MainAgreement();
	}

	public void deleteMainAgreement() {
		try {
			roamingDao.delete(selectedMainAgreement);
			roamingDao.flush();
			mainAgreementList = null;
			selectedMainAgreement = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Main Agreement!!! "
							+ e.getMessage());
		}
	}

	public void saveMainAgreement() {
		try {
			roamingDao.saveOrUpdate(selectedMainAgreement);
			roamingDao.flush();
			mainAgreementList = null;
			selectedMainAgreement = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement!!! "
							+ e.getMessage());
		}
	}

	public void searchDetails(MainAgreement mainAgreement) {
		if (mainAgreement == null) {
			facesMessages.add("You have to select a Main Agreement first!!!");
			return;
		}
		Events.instance().raiseEvent("mainAgreement.details", mainAgreement);
	}

}
