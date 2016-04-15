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
import csv.roaming.domain.CountryIntDialingCode;

@Name("countryIntDialingCodeListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CountryIntDialingCodeListAction implements
		ICountryIntDialingCodeListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private Country selectedCountry;

	private List<CountryIntDialingCode> countryIntDialingCodeList;

	private CountryIntDialingCode selectedCountryIntDialingCode;

	public List<CountryIntDialingCode> getCountryIntDialingCodeList() {
		return countryIntDialingCodeList;
	}

	public void setCountryIntDialingCodeList(
			List<CountryIntDialingCode> countryIntDialingCodeList) {
		this.countryIntDialingCodeList = countryIntDialingCodeList;
	}

	public CountryIntDialingCode getSelectedCountryIntDialingCode() {
		return selectedCountryIntDialingCode;
	}

	public void setSelectedCountryIntDialingCode(
			CountryIntDialingCode selectedCountryIntDialingCode) {
		this.selectedCountryIntDialingCode = selectedCountryIntDialingCode;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component CountryIntDialingCodeListAction..");
	}

	@Observer("countryDetails.update")
	public void searchCountryIntDialingCode(Country country) {
		if (country == null) {
			return;
		}
		selectedCountry = country;
		countryIntDialingCodeList = roamingDao
				.findAllIntDialingCodeByCountry(selectedCountry);

	}

	public void editCountryIntDialingCode(
			CountryIntDialingCode countryIntDialingCode) {
		selectedCountryIntDialingCode = countryIntDialingCode;
		logger.debug("Editing CountryIntDialingCode: "
				+ countryIntDialingCode.getCountry().getCountryName() + ":"
				+ countryIntDialingCode.getCountryIntDialingCodeId());
	}

	public void newCountryIntDialingCode() {
		selectedCountryIntDialingCode = new CountryIntDialingCode();
	}

	public void deleteCountryIntDialingCode() {

		try {
			roamingDao.delete(selectedCountryIntDialingCode);
			roamingDao.flush();
			selectedCountryIntDialingCode = null;
			searchCountryIntDialingCode(selectedCountry);

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Country Int. Dialing Code!!! "
							+ e.getMessage());
		}

	}

	public void saveCountryIntDialingCode() {
		if (selectedCountry == null) {
			facesMessages.add("Selected Country Null", new Object[] {});
			return;

		}

		try {
			selectedCountryIntDialingCode.setCountry(selectedCountry);
			roamingDao.saveOrUpdate(selectedCountryIntDialingCode);
			roamingDao.flush();
			selectedCountryIntDialingCode = null;
			searchCountryIntDialingCode(selectedCountry);

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Country Int. Dialing Code!!! "
							+ e.getMessage());
		}

	}

}
