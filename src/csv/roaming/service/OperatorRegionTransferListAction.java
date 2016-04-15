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
import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.OperatorCountry;

@Name("operatorRegionTransferListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorRegionTransferListAction implements
		IOperatorRegionTransferListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Continent> continentList;

	private Continent selectedContinent;

	private List<Country> countryList;

	private Country selectedCountry;

	private OperatorCountry selectedOperatorCountry;

	private List<OperatorCountry> operatorCountryList;

	private MainAgreement newMainAgreement;

	private List<MainAgreement> mainAgreementList;

	public List<Continent> getContinentList() {
		if (continentList == null) {
			continentList = new ArrayList<Continent>();
		}
		return continentList;
	}

	public void setContinentList(List<Continent> continentList) {
		this.continentList = continentList;
	}

	public Continent getSelectedContinent() {
		return selectedContinent;
	}

	public void setSelectedContinent(Continent selectedContinent) {
		this.selectedContinent = selectedContinent;
	}

	public List<Country> getCountryList() {
		if (countryList == null) {
			countryList = new ArrayList<Country>();
		}
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public Country getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public OperatorCountry getSelectedOperatorCountry() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		this.selectedOperatorCountry = selectedOperatorCountry;
	}

	public List<OperatorCountry> getOperatorCountryList() {
		return operatorCountryList;
	}

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList) {
		if (operatorCountryList == null) {
			operatorCountryList = new ArrayList<OperatorCountry>();
		}
		this.operatorCountryList = operatorCountryList;
	}

	public OperatorCountry getSelectedOperatorRegion() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorRegion(OperatorCountry selectedOperatorRegion) {
		this.selectedOperatorCountry = selectedOperatorRegion;
	}

	public List<OperatorCountry> getOperatorRegionList() {
		if (operatorCountryList == null) {
			operatorCountryList = new ArrayList<OperatorCountry>();
		}
		return operatorCountryList;
	}

	public void setOperatorRegionList(List<OperatorCountry> operatorRegionList) {
		this.operatorCountryList = operatorRegionList;
	}

	public MainAgreement getNewMainAgreement() {
		return newMainAgreement;
	}

	public void setNewMainAgreement(MainAgreement newMainAgreement) {
		this.newMainAgreement = newMainAgreement;
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

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void findContinentList() {

		continentList = roamingDao.findAllContinents();
		selectedContinent = null;

		countryList = new ArrayList<Country>();
		selectedCountry = null;

		operatorCountryList = new ArrayList<OperatorCountry>();
		selectedOperatorCountry = null;

		mainAgreementList = roamingDao.findAllMainAgreements();
		newMainAgreement = null;
	}

	public void findCountryList() {
		if (selectedContinent == null) {
			countryList = new ArrayList<Country>();
			selectedCountry = null;
			operatorCountryList = new ArrayList<OperatorCountry>();
			selectedOperatorCountry = null;
			return;
		}

		selectedCountry = null;

		operatorCountryList = new ArrayList<OperatorCountry>();
		selectedOperatorCountry = null;

		countryList = roamingDao.findAllCountriesByContinent(selectedContinent);
	}

	public void findOperatorCountryList() {
		logger.info("Find Operator Country Called");

		if (selectedCountry == null) {
			operatorCountryList = new ArrayList<OperatorCountry>();
			selectedOperatorCountry = null;
			facesMessages.add("You have to select Country first!!!");
			return;
		}

		selectedOperatorCountry = null;

		operatorCountryList = roamingDao
				.findAllOperatorCountriesByCountry(selectedCountry);
	}

	public void searchMainAgreement() {
		if (selectedOperatorCountry == null) {
			facesMessages.add("You have to select an Operator first!!!");
			return;
		}
	}

	public void updateMainAgreement() {
		if ((newMainAgreement == null && selectedOperatorCountry
				.getMainAgreement() == null)
				|| (newMainAgreement != null && newMainAgreement
						.equals(selectedOperatorCountry.getMainAgreement()))) {
			facesMessages.add("Nothing to update");
			return;
		}

		if (roamingDao.updateMainAgreementForOperatorCountry(
				selectedOperatorCountry, newMainAgreement)) {
			facesMessages
					.add("Operator's Main Agreement information updated successfully!!!");
			roamingDao.flush();
		} else {
			facesMessages
					.add(Severity.ERROR,
							"Problem occured while updating Operator Region's Main Agreement!!! ");
		}

	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component OperatorRegionTransferListAction..");
	}

}
