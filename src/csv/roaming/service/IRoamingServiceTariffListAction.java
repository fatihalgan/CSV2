package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.CountryRegion;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.RoamingService;
import csv.roaming.domain.RoamingServiceTariff;

@Local
public interface IRoamingServiceTariffListAction {

	public String getCcnc();

	public void setCcnc(String ccnc);

	public List<OperatorCountry> getOperatorCountryList();

	public void setOperatorCountryList(List<OperatorCountry> operatorCountryList);

	public OperatorCountry getSelectedOperatorCountry();

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<CountryRegion> getCountryRegionList();

	public void setCountryRegionList(List<CountryRegion> countryRegionList);

	public List<RoamingServiceTariff> getRoamingServiceTariffList();

	public void setRoamingServiceTariffList(
			List<RoamingServiceTariff> roamingServiceTariffList);

	public RoamingServiceTariff getSelectedRoamingServiceTariff();

	public void setSelectedRoamingServiceTariff(
			RoamingServiceTariff selectedRoamingServiceTariff);

	public List<RoamingService> getRoamingServiceList();

	public void setRoamingServiceList(List<RoamingService> roamingServiceList);

	public String getMccmnc();

	public void setMccmnc(String mccmnc);

	public String getOperatorCode();

	public void setOperatorCode(String operatorCode);

	public String getOperatorName();

	public void setOperatorName(String operatorName);

	public void findOperatorCountryListByCriteria();

	public void searchRoamingServiceTariffList();

	public void newRoamingServiceTariff();

	public void editRoamingServiceTariff(
			RoamingServiceTariff roamingServiceTariff);

	public void saveRoamingServiceTariff();

	public void deleteRoamingServiceTariff();

	public void remove();

	public void searchRoamingServiceList();
}
