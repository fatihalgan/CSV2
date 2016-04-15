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
import csv.roaming.domain.AgreementStatus;

@Name("agreementStatusListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class AgreementStatusListAction implements IAgreementStatusListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<AgreementStatus> agreementStatusList;

	private AgreementStatus selectedAgreementStatus;

	public List<AgreementStatus> getAgreementStatusList() {
		return agreementStatusList;
	}

	public void setAgreementStatusList(List<AgreementStatus> agreementStatusList) {
		this.agreementStatusList = agreementStatusList;
	}

	public AgreementStatus getSelectedAgreementStatus() {
		return selectedAgreementStatus;
	}

	public void setSelectedAgreementStatus(
			AgreementStatus selectedAgreementStatus) {
		this.selectedAgreementStatus = selectedAgreementStatus;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component AgreementStatusListAction..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchAgreementStatus() {
		agreementStatusList = roamingDao.findAllAgreementStatus();

	}

	public void editAgreementStatus(AgreementStatus agreementStatus) {
		selectedAgreementStatus = agreementStatus;
		logger.debug("Editing AgreementStatus: "
				+ agreementStatus.getDescription());
	}

	public void newAgreementStatus() {
		selectedAgreementStatus = new AgreementStatus();
	}

	public void deleteAgreementStatus() {
		try {
			roamingDao.delete(selectedAgreementStatus);
			roamingDao.flush();
			agreementStatusList = null;
			selectedAgreementStatus = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting agreement status!!! "
							+ e.getMessage());
		}
	}

	public void saveAgreementStatus() {

		try {
			roamingDao.saveOrUpdate(selectedAgreementStatus);
			roamingDao.flush();
			agreementStatusList = null;
			selectedAgreementStatus = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving agreement status!!! "
							+ e.getMessage());
		}

	}

}
