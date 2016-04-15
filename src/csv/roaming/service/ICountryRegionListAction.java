package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Country;
import csv.roaming.domain.CountryRegion;

@Local
public interface ICountryRegionListAction {

	public Country getSelectedCountry();

	public void setSelectedCountry(Country selectedCountry);

	public List<CountryRegion> getCountryRegionList();

	public void setCountryRegionList(List<CountryRegion> countryRegionList);

	public CountryRegion getSelectedCountryRegion();

	public void setSelectedCountryRegion(CountryRegion selectedCountryRegion);

	public void remove();

	public void searchCountryRegions(Country country);

	public void editCountryRegion(CountryRegion countryRegion);

	public void newCountryRegion();

	public void deleteCountryRegion();

	public void saveCountryRegion();
}
