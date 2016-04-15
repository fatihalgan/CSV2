package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Currency;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.Month;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.TariffCalculationParams;

@Local
public interface ITariffCalculationListAction {

	public void findOperatorCountryListByCriteria();

	public String getMccmnc();

	public void setMccmnc(String mccmnc);

	public String getOperatorCode();

	public void setOperatorCode(String operatorCode);

	public String getOperatorName();

	public void setOperatorName(String operatorName);

	public String getCcnc();

	public void setCcnc(String ccnc);

	public List<Currency> getCurrencyList();

	public void setCurrencyList(List<Currency> currencyList);

	public OperatorCountry getSelectedOperatorCountry();

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<OperatorCountry> getOperatorCountryList();

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList);

	public void setYear(String year);

	public String getYear();

	public Month getSelectedMonth();

	public void setSelectedMonth(Month selectedMonth);

	public TariffCalculationParams getSelectedTariffCalculationParams();

	public void setSelectedTariffCalculationParams(
			TariffCalculationParams selectedTariffCalculationParams);

	public List<MainAgreement> getMainAgreementList();

	public void setMainAgreementList(List<MainAgreement> mainAgreementList);

	public MainAgreement getSelectedMainAgreement();

	public void setSelectedMainAgreement(MainAgreement selectedMainAgreement);

	public void searchTariff();

	public void deleteTariffCalculationParam();

	public void saveTariffCalculationParam();

	public void findOperatorCountryList();

	public void searchMainAgreementList();

	public void remove();

	public void calculateParams();
}
