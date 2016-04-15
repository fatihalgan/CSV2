package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.AgreementKPIObject;
import csv.roaming.domain.CommercialReport;
import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;

@Local
public interface ICommercialKPIReportService {

	public void retrieveCommercialReport();

	public void retrieveAgreementKPIReport();

	public List<CommercialReport> getCommercialReportList();

	public void setCommercialReportList(
			List<CommercialReport> commercialReportList);

	public List<Country> getCountryList();

	public void setCountryList(List<Country> countryList);

	public Country getSelectedCountry();

	public void setSelectedCountry(Country selectedCountry);

	public List<Continent> getContinentList();

	public void setContinentList(List<Continent> continentList);

	public Continent getSelectedContinent();

	public void setSelectedContinent(Continent selectedContinent);

	public List<AgreementKPIObject> getAgreementKPIObjects();

	public void setAgreementKPIObjects(
			List<AgreementKPIObject> agreementKPIObjects);

	public List<AgreementKPIObject> getAgreementKPIList();

	public void setAgreementKPIList(List<AgreementKPIObject> agreementKPIList);

	public void remove();

	public void findContinentList();

	public void findCountryList();
}
