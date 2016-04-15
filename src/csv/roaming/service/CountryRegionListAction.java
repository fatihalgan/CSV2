package csv.roaming.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.Country;
import csv.roaming.domain.CountryRegion;

@Name("countryRegionListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CountryRegionListAction implements ICountryRegionListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<CountryRegion> countryRegionList;

	private CountryRegion selectedCountryRegion;

	private Country selectedCountry;

	public Country getSelectedCountry() {
		return selectedCountry;
	}

	public void setSelectedCountry(Country selectedCountry) {
		this.selectedCountry = selectedCountry;
	}

	public List<CountryRegion> getCountryRegionList() {
		return countryRegionList;
	}

	public void setCountryRegionList(List<CountryRegion> countryRegionList) {
		this.countryRegionList = countryRegionList;
	}

	public CountryRegion getSelectedCountryRegion() {
		return selectedCountryRegion;
	}

	public void setSelectedCountryRegion(CountryRegion selectedCountryRegion) {
		this.selectedCountryRegion = selectedCountryRegion;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component CountryRegionListAction..");
	}

	@Observer("countryDetails.update")
	public void searchCountryRegions(Country country) {
		if (country == null) {
			return;
		}
		selectedCountry = country;

		countryRegionList = roamingDao
				.findAllCountryRegionsByCountry(selectedCountry);

	}

	public void editCountryRegion(CountryRegion countryRegion) {
		selectedCountryRegion = countryRegion;
		logger.debug("Editing Country Region: "
				+ selectedCountryRegion.getCountryRegionName());
	}

	public void newCountryRegion() {
		selectedCountryRegion = new CountryRegion();
	}

	public void deleteCountryRegion() {
		try {
			roamingDao.delete(selectedCountryRegion);
			roamingDao.flush();
			countryRegionList = null;
			selectedCountryRegion = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Country Region!!! "
							+ e.getMessage());
		}
	}

	public void saveCountryRegion() {
		if (selectedCountry == null) {
			facesMessages.add("You have to select a Country first!!!");
		}
		try {
			selectedCountryRegion.setCountry(selectedCountry);
			roamingDao.saveOrUpdate(selectedCountryRegion);
			roamingDao.flush();
			countryRegionList = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Country Region!!! "
							+ e.getMessage());
		}
	}

}
