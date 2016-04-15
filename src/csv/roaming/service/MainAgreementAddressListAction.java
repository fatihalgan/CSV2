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
import csv.roaming.domain.MainAgreementAddress;

@Name("mainAgreementAddressListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementAddressListAction implements
		IMainAgreementAddressListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private MainAgreement selectedMainAgreement;

	private List<MainAgreementAddress> mainAgreementAddressList;

	private MainAgreementAddress selectedMainAgreementAddress;

	public List<MainAgreementAddress> getMainAgreementAddressList() {
		return mainAgreementAddressList;
	}

	public void setMainAgreementAddressList(
			List<MainAgreementAddress> mainAgreementAddressList) {
		this.mainAgreementAddressList = mainAgreementAddressList;
	}

	public MainAgreementAddress getSelectedMainAgreementAddress() {
		return selectedMainAgreementAddress;
	}

	public void setSelectedMainAgreementAddress(
			MainAgreementAddress selectedMainAgreementAddress) {
		this.selectedMainAgreementAddress = selectedMainAgreementAddress;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component MainAgreementAddressListAction..");
	}

	@Observer("mainAgreement.details")
	public void searchMainAgreementAddress(MainAgreement mainAgreement) {
		if (mainAgreement != null) {
			selectedMainAgreement = mainAgreement;
		}

		mainAgreementAddressList = roamingDao
				.findAllAddressesByMainAgreement(selectedMainAgreement);

	}

	public void editMainAgreementAddress(
			MainAgreementAddress mainAgreementAddress) {
		selectedMainAgreementAddress = mainAgreementAddress;
		logger.debug("Editing MainAgreementAddress: "
				+ mainAgreementAddress.getMainAgreementAddressId() + ":"
				+ mainAgreementAddress.getMainAgreement().getDescription());
	}

	public void newMainAgreementAddress() {
		selectedMainAgreementAddress = new MainAgreementAddress();
	}

	public void deleteMainAgreementAddress() {
		try {
			roamingDao.delete(selectedMainAgreementAddress);
			roamingDao.flush();
			selectedMainAgreementAddress = null;
			mainAgreementAddressList = roamingDao
					.findAllAddressesByMainAgreement(selectedMainAgreement);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement Address!!! "
							+ e.getMessage());
		}
	}

	public void saveMainAgreementAddress() {
		if (selectedMainAgreement == null) {
			facesMessages.add("Selected MainAgreement Null", new Object[] {});
			return;

		}
		try {
			selectedMainAgreementAddress
					.setMainAgreement(selectedMainAgreement);
			roamingDao.saveOrUpdate(selectedMainAgreementAddress);
			roamingDao.flush();
			selectedMainAgreementAddress = null;
			mainAgreementAddressList = roamingDao
					.findAllAddressesByMainAgreement(selectedMainAgreement);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement Address!!! "
							+ e.getMessage());
		}
	}

}
