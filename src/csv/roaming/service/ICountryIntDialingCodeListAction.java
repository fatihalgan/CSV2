package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Country;
import csv.roaming.domain.CountryIntDialingCode;

@Local
public interface ICountryIntDialingCodeListAction {

	public List<CountryIntDialingCode> getCountryIntDialingCodeList();

	public void setCountryIntDialingCodeList(
			List<CountryIntDialingCode> countryIntDialingCodeList);

	public CountryIntDialingCode getSelectedCountryIntDialingCode();

	public void setSelectedCountryIntDialingCode(
			CountryIntDialingCode selectedCountryIntDialingCode);

	public void searchCountryIntDialingCode(Country country);

	public void editCountryIntDialingCode(
			CountryIntDialingCode countryIntDialingCode);

	public void newCountryIntDialingCode();

	public void deleteCountryIntDialingCode();

	public void saveCountryIntDialingCode();

	public void remove();
}
