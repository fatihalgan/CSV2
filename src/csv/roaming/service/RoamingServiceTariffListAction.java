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
import csv.roaming.domain.CountryRegion;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.RoamingService;
import csv.roaming.domain.RoamingServiceTariff;

@Name("roamingServiceTariffListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class RoamingServiceTariffListAction implements
		IRoamingServiceTariffListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<OperatorCountry> operatorCountryList;
	private OperatorCountry selectedOperatorCountry;

	private List<CountryRegion> countryRegionList;

	private List<RoamingServiceTariff> roamingServiceTariffList;
	private RoamingServiceTariff selectedRoamingServiceTariff;

	private List<RoamingService> roamingServiceList;

	private String ccnc = "";
	private String mccmnc = "";
	private String operatorCode = "";
	private String operatorName = "";

	public String getCcnc() {
		return ccnc;
	}

	public void setCcnc(String ccnc) {
		this.ccnc = ccnc;
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

	public OperatorCountry getSelectedOperatorCountry() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		this.selectedOperatorCountry = selectedOperatorCountry;
	}

	public List<CountryRegion> getCountryRegionList() {
		if (countryRegionList == null) {
			countryRegionList = new ArrayList<CountryRegion>();
		}

		return countryRegionList;
	}

	public void setCountryRegionList(List<CountryRegion> countryRegionList) {
		this.countryRegionList = countryRegionList;
	}

	public List<RoamingServiceTariff> getRoamingServiceTariffList() {
		if (roamingServiceTariffList == null) {
			roamingServiceTariffList = new ArrayList<RoamingServiceTariff>();
		}

		return roamingServiceTariffList;
	}

	public void setRoamingServiceTariffList(
			List<RoamingServiceTariff> roamingServiceTariffList) {
		this.roamingServiceTariffList = roamingServiceTariffList;
	}

	public RoamingServiceTariff getSelectedRoamingServiceTariff() {
		return selectedRoamingServiceTariff;
	}

	public void setSelectedRoamingServiceTariff(
			RoamingServiceTariff selectedRoamingServiceTariff) {
		this.selectedRoamingServiceTariff = selectedRoamingServiceTariff;
	}

	public List<RoamingService> getRoamingServiceList() {
		if (roamingServiceList == null) {
			roamingServiceList = new ArrayList<RoamingService>();
		}
		return roamingServiceList;
	}

	public void setRoamingServiceList(List<RoamingService> roamingServiceList) {
		this.roamingServiceList = roamingServiceList;
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

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchRoamingServiceList() {
		roamingServiceList = roamingDao.findAllRoamingServices();

	}

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

	public void searchRoamingServiceTariffList() {
		logger.info("searchRoamingServiceTariff called");

		if (selectedOperatorCountry == null) {

			facesMessages.add("You must select an operator first!!!");
			return;
		}

		roamingServiceTariffList = roamingDao
				.findAllRoamingServiceTariffsByOperatorCountry(selectedOperatorCountry);

		countryRegionList = roamingDao
				.findAllCountryRegionsByCountry(selectedOperatorCountry
						.getCountry());

	}

	public void newRoamingServiceTariff() {
		selectedRoamingServiceTariff = new RoamingServiceTariff();
	}

	public void editRoamingServiceTariff(
			RoamingServiceTariff roamingServiceTariff) {

		selectedRoamingServiceTariff = roamingServiceTariff;

		logger.debug("Editing Roaming Service Tariff: "
				+ roamingServiceTariff.getOperatorCountry().getOperator()
						.getOperatorName());
	}

	public void saveRoamingServiceTariff() {

		logger.info("saveRoamingServiceTariff called");
		if (selectedOperatorCountry == null) {
			facesMessages.add("You have to select a country first!!!");
			return;
		}
		selectedRoamingServiceTariff
				.setOperatorCountry(selectedOperatorCountry);
		try {
			roamingDao.saveOrUpdate(selectedRoamingServiceTariff);
			roamingDao.flush();
			selectedRoamingServiceTariff = null;
			roamingServiceTariffList = roamingDao
					.findAllRoamingServiceTariffsByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving roaming Service tariff!!! "
							+ e.getMessage());
		}
	}

	public void deleteRoamingServiceTariff() {
		logger.info("deleteRoamingServiceTariff called");
		try {
			roamingDao.delete(selectedRoamingServiceTariff);
			roamingDao.flush();
			selectedRoamingServiceTariff = null;
			roamingServiceTariffList = roamingDao
					.findAllRoamingServiceTariffsByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting roaming Service tariff!!! "
							+ e.getMessage());
		}

	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component RoamingServiceTariffListAction..");
	}

}
