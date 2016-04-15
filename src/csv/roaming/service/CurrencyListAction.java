package csv.roaming.service;

import java.io.Serializable;
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
import csv.roaming.domain.Currency;

@Name("currencyListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CurrencyListAction implements ICurrencyListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Currency> currencyList;

	private Currency selectedCurrency;

	public List<Currency> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<Currency> currencyList) {
		this.currencyList = currencyList;
	}

	public Currency getSelectedCurrency() {
		return selectedCurrency;
	}

	public void setSelectedCurrency(Currency selectedCurrency) {
		this.selectedCurrency = selectedCurrency;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component Currency List Action..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchCurrencies() {
		currencyList = roamingDao.findAllCurrencies();

	}

	public void editCurrency(Currency currency) {
		selectedCurrency = currency;
		logger.debug("Editing Currency: " + currency.getCurrencyName());
	}

	public void newCurrency() {
		selectedCurrency = new Currency();
	}

	public void deleteCurrency() {
		try {
			roamingDao.delete(selectedCurrency);
			roamingDao.flush();
			currencyList = null;
			selectedCurrency = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Currency!!! "
							+ e.getMessage());
		}
	}

	public void saveCurrency() {
		try {
			roamingDao.saveOrUpdate(selectedCurrency);
			roamingDao.flush();
			currencyList = null;
			selectedCurrency = null;

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Currency!!! "
							+ e.getMessage());
		}
	}

}
