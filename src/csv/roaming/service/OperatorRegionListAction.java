package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.convert.Converter;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.faces.converters.CountryListShuttleConverter;
import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.Country;
import csv.roaming.domain.Operator;
import csv.roaming.domain.OperatorCountry;

@Name("operatorRegionListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorRegionListAction implements IOperatorRegionListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private Operator selectedOperator;

	private List<Country> unselectedCountries;

	private List<Country> selectedCountries;

	private List<OperatorCountry> operatorCountryList;

	public List<Country> getUnselectedCountries() {
		if (unselectedCountries == null) {
			unselectedCountries = new ArrayList<Country>();
		}
		return unselectedCountries;
	}

	public void setUnselectedCountries(List<Country> unselectedCountries) {
		this.unselectedCountries = unselectedCountries;
	}

	public List<Country> getSelectedCountries() {
		if (selectedCountries == null) {
			selectedCountries = new ArrayList<Country>();
		}
		return selectedCountries;
	}

	public void setSelectedCountries(List<Country> selectedCountries) {
		this.selectedCountries = selectedCountries;
	}

	public List<OperatorCountry> getOperatorCountryList() {
		if (operatorCountryList == null) {
			operatorCountryList = new ArrayList<OperatorCountry>();
		}

		return operatorCountryList;
	}

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList) {
		this.operatorCountryList = operatorCountryList;
	}

	public Operator getSelectedOperator() {
		return selectedOperator;
	}

	public List<OperatorCountry> getOperatorRegionList() {
		return operatorCountryList;
	}

	public void setOperatorRegionList(List<OperatorCountry> operatorRegionList) {
		this.operatorCountryList = operatorRegionList;
	}

	public void setSelectedOperator(Operator selectedOperator) {
		this.selectedOperator = selectedOperator;
	}

	public Converter getCountryListShuttleConverter() {
		return new CountryListShuttleConverter(getUnselectedCountries(),
				getSelectedCountries());
	}

	@Observer("operator.details")
	public void searchOperatorCountry(Operator operator) {

		if (operator == null) {
			facesMessages.add("You have to select an operator first!!!");
			return;
		}
		selectedOperator = operator;

		List<Country> countries = roamingDao.findAllCountries();

		operatorCountryList = roamingDao
				.findAllOperatorCountriesByOperator(selectedOperator);

		selectedCountries = roamingDao
				.findAllCountriesByOperator(selectedOperator);

		if (countries == null) {
			return;
		}

		countries.removeAll(selectedCountries);
		unselectedCountries = countries;
	}

	public void saveOperatorCountries() {

		if (operatorCountryList == null) {
			operatorCountryList = new ArrayList<OperatorCountry>();
		}
		try {
			for (Iterator iterator = unselectedCountries.iterator(); iterator
					.hasNext();) {
				boolean isIn = false;
				OperatorCountry deletedOperatorCountry = new OperatorCountry();
				Country country = (Country) iterator.next();
				for (Iterator iterator2 = operatorCountryList.iterator(); iterator2
						.hasNext();) {
					OperatorCountry operatorCountry = (OperatorCountry) iterator2
							.next();
					if (operatorCountry.getCountry().getCountryId() == country
							.getCountryId()) {
						roamingDao.delete(operatorCountry);
						deletedOperatorCountry = operatorCountry;
						isIn = true;
					}
				}
				if (isIn) {
					operatorCountryList.remove(deletedOperatorCountry);
				}

			}

			for (Iterator iterator = selectedCountries.iterator(); iterator
					.hasNext();) {
				Country country = (Country) iterator.next();
				boolean isIn = false;

				for (Iterator iterator2 = operatorCountryList.iterator(); iterator2
						.hasNext();) {
					OperatorCountry operatorCountry = (OperatorCountry) iterator2
							.next();
					if (operatorCountry.getCountry().getCountryId() == country
							.getCountryId()) {
						isIn = true;

					}
				}
				if (!isIn) {
					OperatorCountry newOperatorRegion = new OperatorCountry();
					newOperatorRegion.setOperator(selectedOperator);
					newOperatorRegion.setCountry(country);
					operatorCountryList.add(newOperatorRegion);
				}
			}

			for (Iterator iterator = operatorCountryList.iterator(); iterator
					.hasNext();) {
				OperatorCountry operatorRegion = (OperatorCountry) iterator
						.next();
				roamingDao.saveOrUpdate(operatorRegion);

			}
			roamingDao.flush();
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Regions!!! "
							+ e.getMessage());
		}

	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorRegionListAction..");
	}

}
