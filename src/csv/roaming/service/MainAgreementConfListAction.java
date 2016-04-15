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
import csv.roaming.domain.MainAgreementConf;

@Name("mainAgreementConfListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementConfListAction implements
		IMainAgreementConfListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private MainAgreement selectedMainAgreement;

	private List<MainAgreementConf> mainAgreementConfList;

	private MainAgreementConf selectedMainAgreementConf;

	public List<MainAgreementConf> getMainAgreementConfList() {
		return mainAgreementConfList;
	}

	public void setMainAgreementConfList(
			List<MainAgreementConf> mainAgreementConfList) {
		this.mainAgreementConfList = mainAgreementConfList;
	}

	public MainAgreementConf getSelectedMainAgreementConf() {
		return selectedMainAgreementConf;
	}

	public void setSelectedMainAgreementConf(
			MainAgreementConf selectedMainAgreementConf) {
		this.selectedMainAgreementConf = selectedMainAgreementConf;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component MainAgreementConfListAction..");
	}

	@Observer("mainAgreement.details")
	public void searchMainAgreementConf(MainAgreement mainAgreement) {
		if (mainAgreement != null) {
			selectedMainAgreement = mainAgreement;
		}

		mainAgreementConfList = roamingDao
				.findAllConfigurationsByMainAgreement(selectedMainAgreement);

	}

	public void editMainAgreementConf(MainAgreementConf mainAgreementConf) {
		selectedMainAgreementConf = mainAgreementConf;
		logger.debug("Editing MainAgreementConf: "
				+ mainAgreementConf.getMainAgreementConfId() + ":"
				+ mainAgreementConf.getMainAgreement().getDescription());
	}

	public void newMainAgreementConf() {
		selectedMainAgreementConf = new MainAgreementConf();
	}

	public void deleteMainAgreementConf() {
		try {
			roamingDao.delete(selectedMainAgreementConf);
			roamingDao.flush();
			selectedMainAgreementConf = null;
			mainAgreementConfList = roamingDao
					.findAllConfigurationsByMainAgreement(selectedMainAgreement);

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Main Agreement Conf.!!! "
							+ e.getMessage());
		}
	}

	public void saveMainAgreementConf() {
		if (selectedMainAgreement == null) {
			facesMessages.add("Selected MainAgreement Null", new Object[] {});
			return;

		}
		try {
			selectedMainAgreementConf.setMainAgreement(selectedMainAgreement);
			roamingDao.saveOrUpdate(selectedMainAgreementConf);
			roamingDao.flush();
			selectedMainAgreementConf = null;
			mainAgreementConfList = roamingDao
					.findAllConfigurationsByMainAgreement(selectedMainAgreement);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement Conf.!!! "
							+ e.getMessage());
		}
	}

}
