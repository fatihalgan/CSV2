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
import csv.roaming.domain.CountryNationalDialingCode;

@Name("countryNationalDialingCodeListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CountryNationalDialingCodeListAction implements
		ICountryNationalDialingCodeListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private Country selectedCountry;

	private List<CountryNationalDialingCode> countryNationalDialingCodeList;

	private CountryNationalDialingCode selectedCountryNationalDialingCode;

	public List<CountryNationalDialingCode> getCountryNationalDialingCodeList() {
		return countryNationalDialingCodeList;
	}

	public void setCountryNationalDialingCodeList(
			List<CountryNationalDialingCode> countryNationalDialingCodeList) {
		this.countryNationalDialingCodeList = countryNationalDialingCodeList;
	}

	public CountryNationalDialingCode getSelectedCountryNationalDialingCode() {
		return selectedCountryNationalDialingCode;
	}

	public void setSelectedCountryNationalDialingCode(
			CountryNationalDialingCode selectedCountryNationalDialingCode) {
		this.selectedCountryNationalDialingCode = selectedCountryNationalDialingCode;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component CountryNationalDialingCodeListAction..");
	}

	@Observer("countryDetails.update")
	public void searchCountryNationalDialingCode(Country country) {

		if (country == null) {
			return;
		}
		selectedCountry = country;

		countryNationalDialingCodeList = roamingDao
				.findAllNationalDialingCodeByCountry(selectedCountry);

	}

	public void editCountryNationalDialingCode(
			CountryNationalDialingCode countryNationalDialingCode) {
		selectedCountryNationalDialingCode = countryNationalDialingCode;
		logger.debug("Editing CountryNationalDialingCode: "
				+ countryNationalDialingCode.getCountry().getCountryName()
				+ ":"
				+ countryNationalDialingCode.getCountryNationalDialCodeId());
	}

	public void newCountryNationalDialingCode() {
		selectedCountryNationalDialingCode = new CountryNationalDialingCode();
	}

	public void deleteCountryNationalDialingCode() {

		try {
			roamingDao.delete(selectedCountryNationalDialingCode);
			roamingDao.flush();
			selectedCountryNationalDialingCode = null;
			searchCountryNationalDialingCode(selectedCountry);

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Country Nat. Dialing Code!!! "
							+ e.getMessage());
		}

	}

	public void saveCountryNationalDialingCode() {
		if (selectedCountry == null) {
			facesMessages.add("You have to select a country first!!!",
					new Object[] {});
			return;

		}

		try {
			selectedCountryNationalDialingCode.setCountry(selectedCountry);
			roamingDao.saveOrUpdate(selectedCountryNationalDialingCode);
			roamingDao.flush();
			selectedCountryNationalDialingCode = null;
			searchCountryNationalDialingCode(selectedCountry);

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Country Nat. Dialing Code!!! "
							+ e.getMessage());
		}

	}

}
