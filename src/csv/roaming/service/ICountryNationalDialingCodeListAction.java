package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Country;
import csv.roaming.domain.CountryNationalDialingCode;

@Local
public interface ICountryNationalDialingCodeListAction {

	public List<CountryNationalDialingCode> getCountryNationalDialingCodeList();

	public void setCountryNationalDialingCodeList(
			List<CountryNationalDialingCode> countryNationalDialingCodeList);

	public CountryNationalDialingCode getSelectedCountryNationalDialingCode();

	public void setSelectedCountryNationalDialingCode(
			CountryNationalDialingCode selectedCountryNationalDialingCode);

	public void searchCountryNationalDialingCode(Country country);

	public void editCountryNationalDialingCode(
			CountryNationalDialingCode countryNationalDialingCode);

	public void newCountryNationalDialingCode();

	public void deleteCountryNationalDialingCode();

	public void saveCountryNationalDialingCode();

	public void remove();
}
