package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Currency;

@Local
public interface ICurrencyListAction {

	public List<Currency> getCurrencyList();

	public void setCurrencyList(List<Currency> currencyList);

	public Currency getSelectedCurrency();

	public void setSelectedCurrency(Currency selectedCurrency);

	public void remove();

	public void searchCurrencies();

	public void editCurrency(Currency currency);

	public void newCurrency();

	public void deleteCurrency();

	public void saveCurrency();

}
