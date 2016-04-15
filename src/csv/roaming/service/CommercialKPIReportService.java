package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.AgreementKPIObject;
import csv.roaming.domain.CommercialReport;
import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;

@Name("commercialKPIReportService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CommercialKPIReportService implements ICommercialKPIReportService,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<CommercialReport> commercialReportList;

	private List<Country> countryList;
	private Country selectedCountry;

	private List<Continent> continentList;
	private Continent selectedContinent;

	private List<AgreementKPIObject> agreementKPIObjects;

	private List<AgreementKPIObject> agreementKPIList;

	public void retrieveCommercialReport() {

		commercialReportList = roamingDao.findCommercialReportList(
				selectedContinent == null ? null : selectedContinent
						.getContinentId(), selectedCountry == null ? null
						: selectedCountry.getCountryId());

	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void findContinentList() {

		continentList = roamingDao.findAllContinents();
		selectedContinent = null;

		countryList = new ArrayList<Country>();
		selectedCountry = null;

	}

	public void findCountryList() {

		selectedCountry = null;

		if (selectedContinent == null) {
			countryList = new ArrayList<Country>();
			return;
		}

		countryList = roamingDao.findAllCountriesByContinent(selectedContinent);
	}

	public void retrieveAgreementKPIReport() {

		agreementKPIObjects = roamingDao.findAgreementKPIList();
		processReport();
	}

	private void processReport() {

		AgreementKPIObject bilateral = new AgreementKPIObject("BILATERAL");
		AgreementKPIObject unilateralInbound = new AgreementKPIObject(
				"UNILATERAL_INBOUND");
		AgreementKPIObject unilateralOutbound = new AgreementKPIObject(
				"UNILATERAL_OUTBOUND");

		AgreementKPIObject numberOfCountries = new AgreementKPIObject(
				"COUNTRY_COUNT");

		AgreementKPIObject readyForTest = new AgreementKPIObject(
				"READY_FOR_TESTING");
		AgreementKPIObject inTest = new AgreementKPIObject("TESTING");

		AgreementKPIObject negotiation = new AgreementKPIObject("NEGOTIATION");

		for (Iterator iterator = agreementKPIObjects.iterator(); iterator
				.hasNext();) {

			AgreementKPIObject agreementKPIObject = (AgreementKPIObject) iterator
					.next();

			if ("BILATERAL".equals(agreementKPIObject.getStatus())) {
				bilateral = agreementKPIObject;
			} else if ("UNILATERAL_INBOUND".equals(agreementKPIObject
					.getStatus())) {
				unilateralInbound = agreementKPIObject;

			} else if ("UNILATERAL_OUTBOUND".equals(agreementKPIObject
					.getStatus())) {
				unilateralOutbound = agreementKPIObject;

			} else if ("NEGOTIATION".equals(agreementKPIObject.getStatus())) {
				negotiation = agreementKPIObject;
			} else if ("READY_FOR_TESTING".equals(agreementKPIObject
					.getStatus())) {
				readyForTest = agreementKPIObject;
			} else if ("TESTING".equals(agreementKPIObject.getStatus())) {
				inTest = agreementKPIObject;
			} else if ("COUNTRY_COUNT".equals(agreementKPIObject.getStatus())) {
				numberOfCountries = agreementKPIObject;
				numberOfCountries.setStatus("# of Countries");
			}
		}

		agreementKPIList = new ArrayList<AgreementKPIObject>();
		agreementKPIList.add(bilateral);
		agreementKPIList.add(unilateralInbound);
		agreementKPIList.add(unilateralOutbound);
		agreementKPIList.add(numberOfCountries);

		AgreementKPIObject commercial = new AgreementKPIObject("Commercial");

		commercial.setGsm(bilateral.getGsm() + unilateralInbound.getGsm()
				+ unilateralOutbound.getGsm());
		commercial.setGprs(bilateral.getGprs() + unilateralInbound.getGprs()
				+ unilateralOutbound.getGprs());
		commercial.setCamel(bilateral.getCamel() + unilateralInbound.getCamel()
				+ unilateralOutbound.getCamel());
		commercial.setMmsiw(bilateral.getMmsiw() + unilateralInbound.getMmsiw()
				+ unilateralOutbound.getMmsiw());
		commercial.setNrtrde(bilateral.getNrtrde()
				+ unilateralInbound.getNrtrde()
				+ unilateralOutbound.getNrtrde());
		commercial.setThreeg(bilateral.getThreeg()
				+ unilateralInbound.getThreeg()
				+ unilateralOutbound.getThreeg());

		agreementKPIList.add(commercial);

		agreementKPIList.add(readyForTest);
		agreementKPIList.add(inTest);

		AgreementKPIObject signed = new AgreementKPIObject("Signed");

		signed.setGsm(commercial.getGsm() + readyForTest.getGsm()
				+ inTest.getGsm());
		signed.setGprs(bilateral.getGprs() + readyForTest.getGprs()
				+ inTest.getGprs());
		signed.setCamel(bilateral.getCamel() + readyForTest.getCamel()
				+ inTest.getCamel());
		signed.setMmsiw(bilateral.getMmsiw() + readyForTest.getMmsiw()
				+ inTest.getMmsiw());
		signed.setNrtrde(bilateral.getNrtrde() + readyForTest.getNrtrde()
				+ inTest.getNrtrde());
		signed.setThreeg(bilateral.getThreeg() + readyForTest.getThreeg()
				+ inTest.getThreeg());

		agreementKPIList.add(signed);

		agreementKPIList.add(negotiation);

		AgreementKPIObject total = new AgreementKPIObject("Total #");

		total.setGsm(signed.getGsm() + negotiation.getGsm());
		total.setGprs(signed.getGprs() + negotiation.getGprs());
		total.setCamel(signed.getCamel() + negotiation.getCamel());
		total.setMmsiw(signed.getMmsiw() + negotiation.getMmsiw());
		total.setNrtrde(signed.getNrtrde() + negotiation.getNrtrde());
		total.setThreeg(signed.getThreeg() + negotiation.getThreeg());

		agreementKPIList.add(total);

	}

	public List<CommercialReport> getCommercialReportList() {
		return commercialReportList;
	}

	public void setCommercialReportList(
			List<CommercialReport> commercialReportList) {
		this.commercialReportList = commercialReportList;
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

	public List<Continent> getContinentList() {
		return continentList;
	}

	public void setContinentList(List<Continent> continentList) {
		this.continentList = continentList;
	}

	public Continent getSelectedContinent() {
		return selectedContinent;
	}

	public void setSelectedContinent(Continent selectedContinent) {
		this.selectedContinent = selectedContinent;
	}

	public List<AgreementKPIObject> getAgreementKPIObjects() {
		return agreementKPIObjects;
	}

	public void setAgreementKPIObjects(
			List<AgreementKPIObject> agreementKPIObjects) {
		this.agreementKPIObjects = agreementKPIObjects;
	}

	public List<AgreementKPIObject> getAgreementKPIList() {
		return agreementKPIList;
	}

	public void setAgreementKPIList(List<AgreementKPIObject> agreementKPIList) {
		this.agreementKPIList = agreementKPIList;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component CommercialKPIReportService..");
	}

}
