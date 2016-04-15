package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import csv.roaming.domain.Country;
import csv.roaming.domain.Operator;
import csv.roaming.domain.OperatorCountry;

@Local
public interface IOperatorRegionListAction {

	public List<Country> getUnselectedCountries();

	public void setUnselectedCountries(List<Country> unselectedCountries);

	public List<Country> getSelectedCountries();

	public void setSelectedCountries(List<Country> selectedCountries);

	public List<OperatorCountry> getOperatorCountryList();

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList);

	public Operator getSelectedOperator();

	public List<OperatorCountry> getOperatorRegionList();

	public void setOperatorRegionList(List<OperatorCountry> operatorRegionList);

	public void setSelectedOperator(Operator selectedOperator);

	public Converter getCountryListShuttleConverter();

	public void searchOperatorCountry(Operator operator);

	public void saveOperatorCountries();

	public void remove();
}
