package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
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
import csv.roaming.domain.IregStatus;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.RoamingScheduleType;
import csv.roaming.domain.TadigStatus;

@Name("mainAgreementScheduleListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementScheduleListAction implements
		IMainAgreementScheduleListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private MainAgreement selectedMainAgreement;
	private List<MainAgreement> mainAgreementList;

	private RoamingScheduleType selectedScheduleType;

	private List<MainAgreementSchedule> mainAgreementScheduleList;
	private MainAgreementSchedule selectedMainAgreementSchedule;

	private OperatorCountry selectedOperatorCountry;
	private List<OperatorCountry> operatorCountryList;

	private List<IregStatus> iregStatusList;
	private List<TadigStatus> tadigStatusList;
	private List<AgreementStatus> agreementStatusList;

	private String ccnc = "";
	private String mccmnc = "";
	private String operatorCode = "";
	private String operatorName = "";

	public void findOperatorCountryListByCriteria() {
		if ((ccnc == null || "".equals(ccnc))
				&& (mccmnc == null || "".equals(mccmnc))
				&& (operatorCode == null || "".equals(operatorCode))
				&& (operatorName == null || "".equals(operatorName))) {
			return;
		}
		operatorCountryList = roamingDao.findAllOperatorCountriesByCriteria(
				ccnc, mccmnc, operatorCode, operatorName);
	}

	public String getMccmnc() {
		return mccmnc;
	}

	public void setMccmnc(String mccmnc) {
		this.mccmnc = mccmnc;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCcnc() {
		return ccnc;
	}

	public void setCcnc(String ccnc) {
		this.ccnc = ccnc;
	}

	public List<AgreementStatus> getAgreementStatusList() {
		if (agreementStatusList == null) {
			agreementStatusList = new ArrayList<AgreementStatus>();
		}
		return agreementStatusList;
	}

	public void setAgreementStatusList(List<AgreementStatus> agreementStatusList) {
		this.agreementStatusList = agreementStatusList;
	}

	public OperatorCountry getSelectedOperatorCountry() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		this.selectedOperatorCountry = selectedOperatorCountry;
	}

	public List<OperatorCountry> getOperatorCountryList() {
		if (operatorCountryList == null) {
			operatorCountryList = new ArrayList<OperatorCountry>();
		}
		return operatorCountryList;
	}

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList) {
		this.operatorCountryList = operatorCountryList;
	}

	public List<IregStatus> getIregStatusList() {
		if (iregStatusList == null) {
			iregStatusList = new ArrayList<IregStatus>();
		}
		return iregStatusList;
	}

	public void setIregStatusList(List<IregStatus> iregStatusList) {
		this.iregStatusList = iregStatusList;
	}

	public List<TadigStatus> getTadigStatusList() {
		if (tadigStatusList == null) {
			tadigStatusList = new ArrayList<TadigStatus>();
		}
		return tadigStatusList;
	}

	public void setTadigStatusList(List<TadigStatus> tadigStatusList) {
		this.tadigStatusList = tadigStatusList;
	}

	public List<MainAgreementSchedule> getMainAgreementScheduleList() {
		return mainAgreementScheduleList;
	}

	public void setMainAgreementScheduleList(
			List<MainAgreementSchedule> mainAgreementScheduleList) {
		this.mainAgreementScheduleList = mainAgreementScheduleList;
	}

	public MainAgreementSchedule getSelectedMainAgreementSchedule() {
		if (selectedMainAgreementSchedule == null) {
			selectedMainAgreementSchedule = new MainAgreementSchedule();
		}
		return selectedMainAgreementSchedule;
	}

	public void setSelectedMainAgreementSchedule(
			MainAgreementSchedule selectedMainAgreementSchedule) {
		this.selectedMainAgreementSchedule = selectedMainAgreementSchedule;
	}

	public List<MainAgreement> getMainAgreementList() {
		if (mainAgreementList == null) {
			mainAgreementList = new ArrayList<MainAgreement>();
		}
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

	public RoamingScheduleType getSelectedScheduleType() {
		if (selectedScheduleType == null) {
			selectedScheduleType = RoamingScheduleType.GSM;
		}
		return selectedScheduleType;
	}

	public void setSelectedScheduleType(RoamingScheduleType selectedScheduleType) {
		this.selectedScheduleType = selectedScheduleType;
	}

	public void changeScheduleTypeSelection() {
		logger.info("changeScheduleTypeSelection called");
	}

	public void searchMainAgreementSchedule() {

		if (selectedOperatorCountry == null) {
			facesMessages.add("You must select Operator!!!");
			return;
		}
		try {
			mainAgreementScheduleList = roamingDao
					.findAllActiveMainAgreementSchedulesByOperatorCountry(selectedOperatorCountry);

			selectedMainAgreementSchedule = roamingDao
					.findActiveMainAgreementSchedule(selectedOperatorCountry,
							selectedScheduleType);
			if (selectedMainAgreementSchedule == null) {
				facesMessages
						.add("No data entered for these schedule type, if you want to create new schedule please fill the form and press save button.");
			}
			logger.info("searchMainAgreementSchedule called");
		} catch (Exception e) {
			facesMessages.add("Exception Occured :" + e.getMessage());
		}
	}

	public void findOperatorCountryList() {
		logger.info("findOperatorCountryList called");
		operatorCountryList = roamingDao
				.findAllOperatorCountriesByMainAgreement(selectedMainAgreement);
	}

	public void saveMainAgreementSchedule() {
		try {

			getSelectedMainAgreementSchedule().setScheduleType(
					selectedScheduleType);
			getSelectedMainAgreementSchedule().setOperatorCountry(
					selectedOperatorCountry);
			getSelectedMainAgreementSchedule().setActive(true);
			calculateDurations();
			roamingDao.saveOrUpdate(getSelectedMainAgreementSchedule());
			roamingDao.flush();
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Main Agreement Schedule!!! "
							+ e.getMessage());
		}
	}

	public void deleteMainAgreementSchedule() {
		try {
			roamingDao.delete(getSelectedMainAgreementSchedule());
			roamingDao.flush();
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Main Agreement Schedule!!! "
							+ e.getMessage());
		}
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchMainAgreementList() {
		mainAgreementList = roamingDao.findAllMainAgreements();
		iregStatusList = roamingDao.findAllIregStatuses();
		tadigStatusList = roamingDao.findAllTadigStatuses();
		agreementStatusList = roamingDao.findAllAgreementStatus();

	}

	public boolean isRendered(String list) {
		String selectedScheduleTypeStr = "" + selectedScheduleType.getValue();
		return list.contains(selectedScheduleTypeStr);
	}

	public void calculatePriority() {
		if (selectedMainAgreementSchedule == null) {
			return;
		}
		Double priority = ((double) (selectedMainAgreementSchedule
				.getCommercialPriority().getValue()
				+ selectedMainAgreementSchedule.getTechnicalPriority()
						.getValue() + selectedMainAgreementSchedule
				.getCommitmentLevel().getValue()) / 3D);
		selectedMainAgreementSchedule.setGeneralPriority(priority);
	}

	public void calculateDurations() {

		if (selectedMainAgreementSchedule == null) {
			return;
		}

		int rolloutDuration = 0;

		long MILLSECS_PER_DAY = 86400000;

		if (selectedMainAgreementSchedule.getCommercialLaunchDate() != null
				&& selectedMainAgreementSchedule.getSignatureDate() != null) {
			rolloutDuration = (int) ((selectedMainAgreementSchedule
					.getCommercialLaunchDate().getTime() - selectedMainAgreementSchedule
					.getSignatureDate().getTime()) / MILLSECS_PER_DAY);
		}

		int testDuration = 0;

		if (selectedMainAgreementSchedule.getCommercialLaunchDate() != null
				&& selectedMainAgreementSchedule.getPlannedMonthOfTest() != null) {

			testDuration = (int) ((selectedMainAgreementSchedule
					.getCommercialLaunchDate().getTime() - selectedMainAgreementSchedule
					.getPlannedMonthOfTest().getTime()) / MILLSECS_PER_DAY);
		}

		selectedMainAgreementSchedule.setTestDuration(testDuration);
		selectedMainAgreementSchedule.setRolloutDuration(rolloutDuration);

	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component MainAgreementAddressListAction..");
	}

}
