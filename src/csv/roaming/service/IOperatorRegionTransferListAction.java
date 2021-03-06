package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.OperatorCountry;

@Local
public interface IOperatorRegionTransferListAction {

	public List<Continent> getContinentList();

	public void setContinentList(List<Continent> continentList);

	public Continent getSelectedContinent();

	public void setSelectedContinent(Continent selectedContinent);

	public List<Country> getCountryList();

	public void setCountryList(List<Country> countryList);

	public Country getSelectedCountry();

	public void setSelectedCountry(Country selectedCountry);

	public OperatorCountry getSelectedOperatorCountry();

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<OperatorCountry> getOperatorCountryList();

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList);

	public OperatorCountry getSelectedOperatorRegion();

	public void setSelectedOperatorRegion(OperatorCountry selectedOperatorRegion);

	public List<OperatorCountry> getOperatorRegionList();

	public void setOperatorRegionList(List<OperatorCountry> operatorRegionList);

	public MainAgreement getNewMainAgreement();

	public void setNewMainAgreement(MainAgreement newMainAgreement);

	public List<MainAgreement> getMainAgreementList();

	public void setMainAgreementList(List<MainAgreement> mainAgreementList);

	public void findContinentList();

	public void findCountryList();

	public void findOperatorCountryList();

	public void searchMainAgreement();

	public void updateMainAgreement();

	public void remove();
}
