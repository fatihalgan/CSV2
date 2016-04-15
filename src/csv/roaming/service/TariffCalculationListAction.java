package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.Month;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.TariffCalculationParams;

@Name("tariffCalculationListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class TariffCalculationListAction implements
		ITariffCalculationListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private MainAgreement selectedMainAgreement;

	private List<MainAgreement> mainAgreementList;

	private OperatorCountry selectedOperatorCountry;

	private List<OperatorCountry> operatorCountryList;

	private Month selectedMonth;

	private String year;

	private TariffCalculationParams selectedTariffCalculationParams;

	private List<Currency> currencyList;

	private String ccnc = "";
	private String mccmnc = "";
	private String operatorCode = "";
	private String operatorName = "";

	public void findOperatorCountryListByCriteria() {
		if ((ccnc == null || "".equals(ccnc))
				&& (mccmnc == null || "".equals(mccmnc))
				&& (operatorCode == null || "".equals(operatorCode))
				&& (operatorName == null || "".equals(operatorName))) {
			return;
		}
		operatorCountryList = roamingDao.findAllOperatorCountriesByCriteria(
				ccnc, mccmnc, operatorCode, operatorName);
	}

	public String getMccmnc() {
		return mccmnc;
	}

	public void setMccmnc(String mccmnc) {
		this.mccmnc = mccmnc;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getCcnc() {
		return ccnc;
	}

	public void setCcnc(String ccnc) {
		this.ccnc = ccnc;
	}

	public List<Currency> getCurrencyList() {
		return currencyList;
	}

	public void setCurrencyList(List<Currency> currencyList) {
		this.currencyList = currencyList;
	}

	public OperatorCountry getSelectedOperatorCountry() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		this.selectedOperatorCountry = selectedOperatorCountry;
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

	public void setYear(String year) {
		this.year = year;
	}

	public String getYear() {
		return year;
	}

	public Month getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(Month selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public TariffCalculationParams getSelectedTariffCalculationParams() {
		if (selectedTariffCalculationParams == null) {
			selectedTariffCalculationParams = new TariffCalculationParams();
		}
		return selectedTariffCalculationParams;
	}

	public void setSelectedTariffCalculationParams(
			TariffCalculationParams selectedTariffCalculationParams) {
		this.selectedTariffCalculationParams = selectedTariffCalculationParams;
	}

	public List<MainAgreement> getMainAgreementList() {
		return mainAgreementList;
	}

	public void setMainAgreementList(List<MainAgreement> mainAgreementList) {
		this.mainAgreementList = mainAgreementList;
	}

	public MainAgreement getSelectedMainAgreement() {
		return selectedMainAgreement;
	}

	public void setSelectedMainAgreement(MainAgreement selectedMainAgreement) {
		this.selectedMainAgreement = selectedMainAgreement;
	}

	public void searchTariff() {

		if (selectedOperatorCountry == null) {
			facesMessages.add("First Operator Country must be selected",
					new Object[] {});
			return;
		}
		Date createdDate = createDate();
		if (createdDate == null) {
			facesMessages.add("You have to enter a valid year!!! ");
			return;
		}

		selectedTariffCalculationParams = roamingDao.findActiveTariffCalcParam(
				selectedOperatorCountry, createdDate);

	}

	public void deleteTariffCalculationParam() {
		try {
			roamingDao.delete(selectedTariffCalculationParams);
			roamingDao.flush();
			selectedTariffCalculationParams = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting tariff!!! "
							+ e.getMessage());
		}

	}

	public void saveTariffCalculationParam() {

		if (selectedOperatorCountry == null || year == null
				|| selectedMonth == null) {
			facesMessages.add(
					"Selected Operator Country, Year or Month is Null",
					new Object[] {});
			return;

		}
		try {

			Date createdDate = createDate();
			if (createdDate == null) {
				facesMessages.add("You have to enter a valid year!!! ");
				return;
			}
			selectedTariffCalculationParams
					.setOperatorCountry(selectedOperatorCountry);
			selectedTariffCalculationParams.setValidMonth(createdDate);
			selectedTariffCalculationParams.setActive(true);
			roamingDao.saveOrUpdate(selectedTariffCalculationParams);
			roamingDao.flush();
			selectedTariffCalculationParams = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Error occured while saving tariff: " + e.getMessage());

		}
	}

	private Date createDate() {
		try {
			Integer yearInt = Integer.parseInt(year);
			GregorianCalendar newGregCal = new GregorianCalendar(yearInt,
					selectedMonth.getValue(), 1);
			return new Date(newGregCal.getTimeInMillis());
		} catch (Exception e) {
			return null;
		}

	}

	public void findOperatorCountryList() {
		logger.info("findOperatorCountryList called");
		operatorCountryList = roamingDao
				.findAllOperatorCountriesByMainAgreement(selectedMainAgreement);

	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchMainAgreementList() {
		mainAgreementList = roamingDao.findAllMainAgreements();

		if (mainAgreementList == null) {
			mainAgreementList = new ArrayList<MainAgreement>();
		}
		currencyList = roamingDao.findAllCurrencies();
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component TariffCalculationListAction..");
	}

	public void calculateParams() {

		if (selectedTariffCalculationParams == null
				|| selectedTariffCalculationParams.getCurrencyExchange() == null) {
			return;
		}

		Double exchangeRate = 0D;
		if (selectedTariffCalculationParams.getCurrencyExchange() != 0) {
			exchangeRate = nullToZero(selectedTariffCalculationParams
					.getExchange())
					/ selectedTariffCalculationParams.getCurrencyExchange();
		}
		selectedTariffCalculationParams.setExchangeRate(exchangeRate);

		selectedTariffCalculationParams
				.setWomCallSetupCharge(nullToZero(selectedTariffCalculationParams
						.getCallSetupCharge())
						* exchangeRate);

		selectedTariffCalculationParams
				.setWomNationalVoiceMo(nullToZero(selectedTariffCalculationParams
						.getNationalVoiceMo())
						* exchangeRate);
		selectedTariffCalculationParams
				.setWomBackHomeVoiceMo(nullToZero(selectedTariffCalculationParams
						.getBackHomeVoiceMo())
						* exchangeRate);
		selectedTariffCalculationParams
				.setWomRowVoiceMo(nullToZero(selectedTariffCalculationParams
						.getRowVoiceMo())
						* exchangeRate);
		selectedTariffCalculationParams
				.setWomSattelliteVoiceMo(nullToZero(selectedTariffCalculationParams
						.getSattelliteVoiceMo())
						* exchangeRate);
		selectedTariffCalculationParams
				.setWomVoiceMt(nullToZero(selectedTariffCalculationParams
						.getVoiceMt())
						* exchangeRate);
		selectedTariffCalculationParams
				.setWomSmsMo(nullToZero(selectedTariffCalculationParams
						.getSmsMo())
						* exchangeRate);

		Double womGprsIotUnit = 0D;
		if (nullToZero(selectedTariffCalculationParams
				.getPacketDataMultiplier()) != 0) {
			womGprsIotUnit = nullToZero(selectedTariffCalculationParams
					.getGprsIotUnit())
					/ selectedTariffCalculationParams.getPacketDataMultiplier();
		}

		selectedTariffCalculationParams.setWomGprsIotUnit(womGprsIotUnit);

		Double markupVatMultiplier = (Double) (((nullToZero(selectedTariffCalculationParams
				.getMarkup()) + nullToZero(selectedTariffCalculationParams
				.getVat())) / 100D) + 1);

		selectedTariffCalculationParams
				.setWmCallSetupCharge(markupVatMultiplier
						* nullToZero(selectedTariffCalculationParams
								.getCallSetupCharge()) * exchangeRate);
		selectedTariffCalculationParams
				.setWmNationalVoiceMo(markupVatMultiplier
						* nullToZero(selectedTariffCalculationParams
								.getNationalVoiceMo()) * exchangeRate);
		selectedTariffCalculationParams
				.setWmBackHomeVoiceMo(markupVatMultiplier
						* nullToZero(selectedTariffCalculationParams
								.getBackHomeVoiceMo()) * exchangeRate);
		selectedTariffCalculationParams.setWmRowVoiceMo(markupVatMultiplier
				* nullToZero(selectedTariffCalculationParams.getRowVoiceMo())
				* exchangeRate);
		selectedTariffCalculationParams
				.setWmSattelliteVoiceMo(markupVatMultiplier
						* nullToZero(selectedTariffCalculationParams
								.getSattelliteVoiceMo()) * exchangeRate);
		selectedTariffCalculationParams.setWmVoiceMt(markupVatMultiplier
				* nullToZero(selectedTariffCalculationParams.getVoiceMt())
				* exchangeRate);
		selectedTariffCalculationParams.setWmSmsMo(markupVatMultiplier
				* nullToZero(selectedTariffCalculationParams.getSmsMo())
				* exchangeRate);
		selectedTariffCalculationParams.setWmGprsIotUnit(markupVatMultiplier
				* nullToZero(selectedTariffCalculationParams.getGprsIotUnit())
				* exchangeRate);

	}

	private Double nullToZero(Double value) {
		return (value == null) ? 0 : value;
	}

	private Short nullToZero(Short value) {
		return (value == null) ? 0 : value;
	}
}
