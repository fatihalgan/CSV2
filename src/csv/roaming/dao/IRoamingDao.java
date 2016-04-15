package csv.roaming.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.AgreementKPIObject;
import csv.roaming.domain.AgreementStatus;
import csv.roaming.domain.CommercialReport;
import csv.roaming.domain.ContactTypes;
import csv.roaming.domain.Continent;
import csv.roaming.domain.Country;
import csv.roaming.domain.CountryIntDialingCode;
import csv.roaming.domain.CountryNationalDialingCode;
import csv.roaming.domain.CountryRegion;
import csv.roaming.domain.Currency;
import csv.roaming.domain.IregStatus;
import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementAddress;
import csv.roaming.domain.MainAgreementApproach;
import csv.roaming.domain.MainAgreementConf;
import csv.roaming.domain.MainAgreementContact;
import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.Mccmnc;
import csv.roaming.domain.Operator;
import csv.roaming.domain.OperatorAddress;
import csv.roaming.domain.OperatorContact;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.OperatorFrequency;
import csv.roaming.domain.OperatorPrefix;
import csv.roaming.domain.OperatorService;
import csv.roaming.domain.OperatorTariff;
import csv.roaming.domain.RoamingScheduleType;
import csv.roaming.domain.RoamingService;
import csv.roaming.domain.RoamingServiceTariff;
import csv.roaming.domain.Service;
import csv.roaming.domain.TadigStatus;
import csv.roaming.domain.Tapcode;
import csv.roaming.domain.TariffCalculationParams;
import csv.util.persistence.IBaseDao;

@Local
public interface IRoamingDao extends IBaseDao {

	public List<Country> findAllCountries();

	public List<Continent> findAllContinents();

	public List<CountryIntDialingCode> findAllIntDialingCodeByCountry(
			Country country);

	public List<CountryNationalDialingCode> findAllNationalDialingCodeByCountry(
			Country country);

	public List<Country> findAllCountriesByContinent(Continent continent);

	public List<CountryRegion> findAllCountryRegionsByCountry(Country country);

	public List<AgreementStatus> findAllAgreementStatus();

	public List<ContactTypes> findAllContactTypes();

	public List<IregStatus> findAllIregStatuses();

	public List<MainAgreement> findAllMainAgreements();

	public List<MainAgreementAddress> findAllAddressesByMainAgreement(
			MainAgreement mainAgreement);

	public List<MainAgreementApproach> findAllApproachesByMainAgreement(
			MainAgreement mainAgreement);

	public List<MainAgreementContact> findAllContactsByMainAgreement(
			MainAgreement mainAgreement);

	public List<MainAgreementConf> findAllConfigurationsByMainAgreement(
			MainAgreement mainAgreement);

	public List<MainAgreementSchedule> findAllActiveMainAgreementSchedulesByOperatorCountry(
			OperatorCountry operatorCountry);

	public MainAgreementSchedule findActiveMainAgreementSchedule(
			OperatorCountry operatorCountry, RoamingScheduleType scheduleType);

	public List<Operator> findAllOperators();

	public List<OperatorAddress> findAllAddressesByOperatorCountry(
			OperatorCountry operatorCountry);

	public List<OperatorContact> findAllContactsByOperatorCountry(
			OperatorCountry operatorCountry);

	public List<OperatorFrequency> findAllFrequenciesByOperatorCountry(
			OperatorCountry operatorCountry);

	public List<OperatorPrefix> findAllPrefixesByOperator(Operator operator);

	public List<OperatorCountry> findAllOperatorCountriesByOperator(
			Operator operator);

	public List<OperatorService> findAllOperatorServicesByOperatorCountry(
			OperatorCountry operatorCountry);

	public List<OperatorCountry> findAllOperatorCountries();

	public List<RoamingService> findAllRoamingServices();

	public List<TadigStatus> findAllTadigStatuses();

	public List<TariffCalculationParams> findAllActiveTariffCalculationParams();

	public List<OperatorCountry> findAllOperatorCountriesByCountry(
			Country country);

	public TariffCalculationParams findActiveTariffCalcParam(
			OperatorCountry operatorCountry, Date validMonth);

	public List<TariffCalculationParams> findAllTariffCalcParamsByMonth(
			Date validMonth);

	public List<RoamingServiceTariff> findAllRoamingServiceTariffsByOperatorCountry(
			OperatorCountry operatorCountry);

	public RoamingServiceTariff findRoamingServiceTariff(
			OperatorCountry operatorCountry, RoamingService roamingService);

	public List<Currency> findAllCurrencies();

	public List<Mccmnc> findAllMccmncies();

	public List<Tapcode> findAllTapCodes();

	public List<OperatorCountry> findAllOperatorCountriesByMainAgreement(
			MainAgreement mainAgreement);

	public List<CountryRegion> findAllCountryRegions();

	public List<Country> findAllCountriesByOperator(Operator operator);

	public List<RoamingService> findAllRoamingServicesByOperatorCountry(
			OperatorCountry operatorCountry);

	public boolean updateMainAgreementForOperatorCountry(
			OperatorCountry operatorCountry, MainAgreement newMainAgreement);

	public List<MainAgreementSchedule> findMainAgreementSchedulesByScheduleType(
			RoamingScheduleType scheduleType, Boolean isActive);

	public List<MainAgreementSchedule> findMainAgreementSchedulesByCriteria(
			RoamingScheduleType scheduleType, String statusOperator,
			AgreementStatus status, Boolean isActive);

	public List<Country> findAllCountriesByName(String countryName);

	public List<MainAgreement> findAllMainAgreementsByName(String agreementName);

	public List<Operator> findAllOperatorsByName(String operatorName);

	public List<OperatorCountry> findAllOperatorCountriesByCriteria(
			String ccnc, String mccmnc, String operatorCode, String operatorName);

	public List<Service> findAllServices();

	public List<OperatorTariff> findAllOperatorTariffsByOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<CommercialReport> findCommercialReportList(Long continentId,
			Long countryId);

	public List<AgreementKPIObject> findAgreementKPIList();

	public long findTariffCountByMonth(Date date);

	public int copyTariffs(Date fromDate, String toDate);

	public int deleteAllTariffsByDate(Date date);

}