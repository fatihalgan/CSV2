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
import org.jboss.seam.core.Events;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;

@Name("countryListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CountryListAction implements ICountryListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Country> countryList;

	private Country selectedCountry;

	private String countryName = "";

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public Country getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchCountries() {
		countryName = "";
		countryList = roamingDao.findAllCountries();
	}

	public void searchCountriesByName() {
		countryList = roamingDao.findAllCountriesByName(countryName);
	}

	public List<Continent> returnContinentList() {
		return roamingDao.findAllContinents();
	}

	public void editCountry(Country country) {
		selectedCountry = country;
		logger.debug("Editing Country: " + selectedCountry.getCountryName());
	}

	public void newCountry() {
		selectedCountry = new Country();
	}

	public void deleteCountry() {

		try {
			roamingDao.delete(selectedCountry);
			roamingDao.flush();
			countryList = null;
			selectedCountry = null;

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Country!!! "
							+ e.getMessage());
		}

	}

	public void saveCountry() {

		try {
			roamingDao.saveOrUpdate(selectedCountry);
			roamingDao.flush();
			countryList = null;
			selectedCountry = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages
					.add(Severity.ERROR,
							"Problem occured while saving Country!!! "
									+ e.getMessage());
		}
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component ParameterListAction..");
	}

	public void updateDetails(Country country) {
		Events.instance().raiseEvent("countryDetails.update", country);

	}

	public void calculateTimeDiffs() {
		try {
			Integer timeDiff = Integer.parseInt(selectedCountry.getUtc()) - 2;
			selectedCountry.setUtcTimeDiff(timeDiff);
		} catch (Exception e) {
			logger.error("UTC is not a valid number!!!");
			selectedCountry.setUtcTimeDiff(null);
		}

		try {
			Integer timeDiff = Integer.parseInt(selectedCountry.getUtcEnd()) - 2;
			selectedCountry.setUtcEndTimeDiff(timeDiff);
		} catch (Exception e) {
			logger.error("UTC end is not a valid number!!!");
			selectedCountry.setUtcEndTimeDiff(null);

		}

	}
}
