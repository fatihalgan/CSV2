package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.AgreementStatus;
import csv.roaming.domain.IregStatus;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.RoamingScheduleType;
import csv.roaming.domain.TadigStatus;

@Local
public interface IMainAgreementScheduleListAction {

	public void findOperatorCountryListByCriteria();

	public String getMccmnc();

	public void setMccmnc(String mccmnc);

	public String getOperatorCode();

	public void setOperatorCode(String operatorCode);

	public String getOperatorName();

	public void setOperatorName(String operatorName);

	public String getCcnc();

	public void setCcnc(String ccnc);

	public List<AgreementStatus> getAgreementStatusList();

	public void setAgreementStatusList(List<AgreementStatus> agreementStatusList);

	public OperatorCountry getSelectedOperatorCountry();

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<OperatorCountry> getOperatorCountryList();

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList);

	public List<IregStatus> getIregStatusList();

	public void setIregStatusList(List<IregStatus> iregStatusList);

	public List<TadigStatus> getTadigStatusList();

	public void setTadigStatusList(List<TadigStatus> tadigStatusList);

	public List<MainAgreementSchedule> getMainAgreementScheduleList();

	public void setMainAgreementScheduleList(
			List<MainAgreementSchedule> mainAgreementScheduleList);

	public MainAgreementSchedule getSelectedMainAgreementSchedule();

	public void setSelectedMainAgreementSchedule(
			MainAgreementSchedule selectedMainAgreementSchedule);

	public List<MainAgreement> getMainAgreementList();

	public void setMainAgreementList(List<MainAgreement> mainAgreementList);

	public MainAgreement getSelectedMainAgreement();

	public void setSelectedMainAgreement(MainAgreement selectedMainAgreement);

	public RoamingScheduleType getSelectedScheduleType();

	public void setSelectedScheduleType(RoamingScheduleType selectedScheduleType);

	public void changeScheduleTypeSelection();

	public void searchMainAgreementSchedule();

	public void findOperatorCountryList();

	public void saveMainAgreementSchedule();

	public void deleteMainAgreementSchedule();

	public void searchMainAgreementList();

	public boolean isRendered(String list);

	public void calculatePriority();

	public void calculateDurations();

	public void remove();

}
