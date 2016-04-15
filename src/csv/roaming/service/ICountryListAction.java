package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;

@Local
public interface ICountryListAction {

	public String getCountryName();

	public void setCountryName(String countryName);

	public List<Country> getCountryList();

	public void setCountryList(List<Country> countryList);

	public Country getSelectedCountry();

	public void setSelectedCountry(Country selectedCountry);

	public void searchCountries();

	public List<Continent> returnContinentList();

	public void editCountry(Country country);

	public void newCountry();

	public void deleteCountry();

	public void saveCountry();

	public void remove();

	public void updateDetails(Country country);

	public void searchCountriesByName();

	public void calculateTimeDiffs();

}
