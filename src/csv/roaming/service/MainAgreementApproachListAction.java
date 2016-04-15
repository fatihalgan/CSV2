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
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementApproach;

@Name("mainAgreementApproachListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementApproachListAction implements
		IMainAgreementApproachListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private MainAgreement selectedMainAgreement;

	private List<MainAgreementApproach> mainAgreementApproachList;

	private MainAgreementApproach selectedMainAgreementApproach;

	public List<MainAgreementApproach> getMainAgreementApproachList() {
		return mainAgreementApproachList;
	}

	public void setMainAgreementApproachList(
			List<MainAgreementApproach> mainAgreementApproachList) {
		this.mainAgreementApproachList = mainAgreementApproachList;
	}

	public MainAgreementApproach getSelectedMainAgreementApproach() {
		return selectedMainAgreementApproach;
	}

	public void setSelectedMainAgreementApproach(
			MainAgreementApproach selectedMainAgreementApproach) {
		this.selectedMainAgreementApproach = selectedMainAgreementApproach;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component MainAgreementApproachListAction..");
	}

	@Observer("mainAgreement.details")
	public void searchMainAgreementApproach(MainAgreement mainAgreement) {
		if (mainAgreement != null) {
			selectedMainAgreement = mainAgreement;
		}

		mainAgreementApproachList = roamingDao
				.findAllApproachesByMainAgreement(selectedMainAgreement);

	}

	public void editMainAgreementApproach(
			MainAgreementApproach mainAgreementApproach) {
		selectedMainAgreementApproach = mainAgreementApproach;
		logger.debug("Editing MainAgreementApproach: "
				+ mainAgreementApproach.getMainAgreementApproachId() + ":"
				+ mainAgreementApproach.getMainAgreement().getDescription());
	}

	public void newMainAgreementApproach() {
		selectedMainAgreementApproach = new MainAgreementApproach();
	}

	public void deleteMainAgreementApproach() {
		try {
			roamingDao.delete(selectedMainAgreementApproach);
			roamingDao.flush();
			selectedMainAgreementApproach = null;
			mainAgreementApproachList = roamingDao
					.findAllApproachesByMainAgreement(selectedMainAgreement);

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Main Agreement Approach!!! "
							+ e.getMessage());
		}
	}

	public void saveMainAgreementApproach() {
		if (selectedMainAgreement == null) {
			facesMessages.add("Selected MainAgreement Null", new Object[] {});
			return;

		}
		try {
			selectedMainAgreementApproach
					.setMainAgreement(selectedMainAgreement);
			roamingDao.saveOrUpdate(selectedMainAgreementApproach);
			roamingDao.flush();
			selectedMainAgreementApproach = null;
			mainAgreementApproachList = roamingDao
					.findAllApproachesByMainAgreement(selectedMainAgreement);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement Approach!!! "
							+ e.getMessage());
		}
	}

}
