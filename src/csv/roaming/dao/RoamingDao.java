package csv.roaming.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

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
import csv.util.persistence.HibernateBaseDao;

@Name("roamingDao")
@Stateless
@AutoCreate
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RoamingDao extends HibernateBaseDao implements IRoamingDao {

	@Logger
	private Log log;

	@In("roamingHibernateSession")
	private Session session;

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public List<Country> findAllCountries() {
		try {
			log.info("find All Countries!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select c from csv.roaming.domain.Country c order by c.countryName asc");

			return (List<Country>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Country>();
	}

	@Override
	public List<Continent> findAllContinents() {
		try {
			log.info("find All Continents!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select c from csv.roaming.domain.Continent c order by c.name asc");
			return (List<Continent>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Continent>();
	}

	@Override
	public void saveOrUpdate(Object entity) {
		super.saveOrUpdate(entity);
	}

	@Override
	public void delete(Object entity) {
		super.delete(entity);
	}

	@Override
	public List<CountryIntDialingCode> findAllIntDialingCodeByCountry(
			Country country) {
		try {
			log
					.info("find International Dialing Code By Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select dc from csv.roaming.domain.CountryIntDialingCode dc where dc.country.countryId = ? order by dc.countryIntDialingCodeId asc")
					.setLong(0, country.getCountryId());
			return (List<CountryIntDialingCode>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CountryIntDialingCode>();
	}

	@Override
	public List<CountryNationalDialingCode> findAllNationalDialingCodeByCountry(
			Country country) {
		try {
			log.info("find National Dialing Code By Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select dc from csv.roaming.domain.CountryNationalDialingCode dc where dc.country.countryId = ? order by dc.countryNationalDialCodeId asc")
					.setLong(0, country.getCountryId());
			return (List<CountryNationalDialingCode>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CountryNationalDialingCode>();
	}

	@Override
	public List<AgreementStatus> findAllAgreementStatus() {
		try {
			log.info("find All Agreement Status!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.AgreementStatus ast order by ast.statusId asc");
			return (List<AgreementStatus>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<AgreementStatus>();
	}

	@Override
	public List<MainAgreementAddress> findAllAddressesByMainAgreement(
			MainAgreement mainAgreement) {
		try {
			log.info("find All Addresses By Main Agreement!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select maa from csv.roaming.domain.MainAgreementAddress maa where maa.mainAgreement.mainAgreementId = ? order by maa.mainAgreementAddressId asc")
					.setLong(0, mainAgreement.getMainAgreementId());
			return (List<MainAgreementAddress>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementAddress>();
	}

	@Override
	public List<MainAgreementApproach> findAllApproachesByMainAgreement(
			MainAgreement mainAgreement) {
		try {
			log.info("find All Approaches By Main Agreement!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select maa from csv.roaming.domain.MainAgreementApproach maa where maa.mainAgreement.mainAgreementId = ? order by maa.mainAgreementApproachId asc")
					.setLong(0, mainAgreement.getMainAgreementId());
			return (List<MainAgreementApproach>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementApproach>();
	}

	@Override
	public List<ContactTypes> findAllContactTypes() {
		try {
			log.info("find All Contact Types!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.ContactTypes ct order by ct.typeId asc");
			return (List<ContactTypes>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<ContactTypes>();
	}

	@Override
	public List<MainAgreementContact> findAllContactsByMainAgreement(
			MainAgreement mainAgreement) {
		try {
			log.info("find All Contacts By Main Agreement!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select mac from csv.roaming.domain.MainAgreementContact mac where mac.mainAgreement.mainAgreementId = ? order by mac.mainAgreementContactId asc")
					.setLong(0, mainAgreement.getMainAgreementId());
			return (List<MainAgreementContact>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementContact>();
	}

	@Override
	public List<IregStatus> findAllIregStatuses() {
		try {
			log.info("find All Ireg Status!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.IregStatus ist order by ist.statusId asc");
			return (List<IregStatus>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<IregStatus>();
	}

	@Override
	public List<MainAgreement> findAllMainAgreements() {
		try {
			log.info("find All Main Agreements!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.MainAgreement ma order by ma.mainAgreementId asc");
			return (List<MainAgreement>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreement>();
	}

	@Override
	public List<Operator> findAllOperators() {
		try {
			log.info("find All Operators!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.Operator op order by op.operatorId asc");
			return (List<Operator>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Operator>();
	}

	@Override
	public List<RoamingService> findAllRoamingServices() {
		try {
			log.info("find All Roaming Services!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.RoamingService rs order by rs.roamingServiceId asc");
			return (List<RoamingService>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<RoamingService>();
	}

	@Override
	public List<TadigStatus> findAllTadigStatuses() {
		try {
			log.info("find All Tadig Statuses!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.TadigStatus ts order by ts.statusId asc");
			return (List<TadigStatus>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<TadigStatus>();
	}

	@Override
	public List<TariffCalculationParams> findAllActiveTariffCalculationParams() {
		try {
			log.info("find All Tariff Calculation Parameters!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("from csv.roaming.domain.TariffCalculationParams tcp where tcp.active=true order by tcp.tariffCalcParamId asc");
			return (List<TariffCalculationParams>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<TariffCalculationParams>();
	}

	@Override
	public List<Country> findAllCountriesByContinent(Continent continent) {
		try {
			log.info("find All Countries by Continent!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"from csv.roaming.domain.Country c where c.continent.continentId =? order by c.countryId asc")
					.setLong(0, continent.getContinentId());
			return (List<Country>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Country>();
	}

	@Override
	public List<OperatorAddress> findAllAddressesByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log.info("find All Addresses By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select oa from csv.roaming.domain.OperatorAddress oa where oa.operatorCountry.operatorCountryId = ? order by oa.operatorAddressId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<OperatorAddress>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorAddress>();
	}

	@Override
	public List<MainAgreementConf> findAllConfigurationsByMainAgreement(
			MainAgreement mainAgreement) {
		try {
			log
					.info("find All Configurations By Main Agreement!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select cnf from csv.roaming.domain.MainAgreementConf cnf where cnf.mainAgreement.mainAgreementId = ? order by cnf.mainAgreementConfId asc")
					.setLong(0, mainAgreement.getMainAgreementId());
			return (List<MainAgreementConf>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementConf>();
	}

	@Override
	public List<OperatorContact> findAllContactsByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log.info("find All Contacts By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select oc from csv.roaming.domain.OperatorContact oc where oc.operatorCountry.operatorCountryId = ? order by oc.operatorContactId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<OperatorContact>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorContact>();
	}

	@Override
	public List<CountryRegion> findAllCountryRegionsByCountry(Country country) {
		try {
			log.info("find All Country Regions By Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select cr from csv.roaming.domain.CountryRegion cr where cr.country.countryId = ? order by cr.country.countryName asc")
					.setLong(0, country.getCountryId());
			return (List<CountryRegion>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CountryRegion>();
	}

	@Override
	public List<Currency> findAllCurrencies() {
		try {
			log.info("find All Currencies!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select c from csv.roaming.domain.Currency c order by c.currencyId asc");
			return (List<Currency>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Currency>();
	}

	@Override
	public List<OperatorFrequency> findAllFrequenciesByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log.info("find All Frequencies By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select ofr from csv.roaming.domain.OperatorFrequency ofr where ofr.operatorCountry.operatorCountryId = ? order by ofr.operatorFrequencyId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<OperatorFrequency>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorFrequency>();
	}

	@Override
	public List<MainAgreementSchedule> findAllActiveMainAgreementSchedulesByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log
					.info("find All Main Agreement Schedule By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"from csv.roaming.domain.MainAgreementSchedule ma where ma.operatorCountry.operatorCountryId=? and ma.active=true order by ma.agreementScheduleId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<MainAgreementSchedule>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementSchedule>();
	}

	@Override
	public List<Mccmnc> findAllMccmncies() {
		try {
			log.info("find All MCCMNC's!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select c from csv.roaming.domain.Mccmnc c order by c.mccmncId asc");
			return (List<Mccmnc>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Mccmnc>();
	}

	@Override
	public List<OperatorCountry> findAllOperatorCountries() {
		try {
			log.info("find All Operator Countries!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select oc from csv.roaming.domain.OperatorCountry oc order by oc.operatorCountryId asc");
			return (List<OperatorCountry>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorCountry>();
	}

	@Override
	public List<OperatorCountry> findAllOperatorCountriesByOperator(
			Operator operator) {
		try {
			log.info("find All Countries By Operator!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select oc from csv.roaming.domain.OperatorCountry oc where oc.operator.operatorId = ? order by oc.operatorCountryId asc")
					.setLong(0, operator.getOperatorId());
			return (List<OperatorCountry>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorCountry>();
	}

	@Override
	public List<OperatorCountry> findAllOperatorCountriesByCountry(
			Country country) {
		try {
			log.info("find All Operators Countries by Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select oc from csv.roaming.domain.OperatorCountry oc where oc.country.countryId =? order by oc.operatorCountryId asc")
					.setLong(0, country.getCountryId());
			return (List<OperatorCountry>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorCountry>();
	}

	@Override
	public List<OperatorService> findAllOperatorServicesByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log
					.info("find All Operator Services By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select os from csv.roaming.domain.OperatorService os where os.operatorCountry.operatorCountryId = ? order by os.operatorServiceId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<OperatorService>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorService>();
	}

	@Override
	public List<OperatorPrefix> findAllPrefixesByOperator(Operator operator) {
		try {
			log.info("find All Prefixes By Operator!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select op from csv.roaming.domain.OperatorPrefix op where op.operator.operatorId = ? order by op.operatorPrefixId asc")
					.setLong(0, operator.getOperatorId());
			return (List<OperatorPrefix>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorPrefix>();
	}

	@Override
	public List<RoamingServiceTariff> findAllRoamingServiceTariffsByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log
					.info("find All RoamingServiceTariffs by Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select rst from csv.roaming.domain.RoamingServiceTariff rst where rst.operatorCountry.operatorCountryId=? order by rst.roamingServiceTariffId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<RoamingServiceTariff>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<RoamingServiceTariff>();
	}

	@Override
	public List<Tapcode> findAllTapCodes() {
		try {
			log.info("find All TapCodes!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select c from csv.roaming.domain.Tapcode c order by c.tapcodeId asc");
			return (List<Tapcode>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Tapcode>();
	}

	@Override
	public MainAgreementSchedule findActiveMainAgreementSchedule(
			OperatorCountry operatorCountry, RoamingScheduleType scheduleType) {
		try {
			log
					.info("find Main Agreement Schedule By Operator Country and Schedule Type!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select mas from csv.roaming.domain.MainAgreementSchedule mas where mas.operatorCountry.operatorCountryId=? and mas.scheduleType=? and mas.active=true order by mas.agreementScheduleId asc")
					.setLong(0, operatorCountry.getOperatorCountryId())
					.setLong(1, scheduleType.getValue());
			return (MainAgreementSchedule) q.uniqueResult();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new MainAgreementSchedule();
	}

	@Override
	public RoamingServiceTariff findRoamingServiceTariff(
			OperatorCountry operatorCountry, RoamingService roamingService) {
		try {
			log
					.info("find RoamingServiceTariff by Operator Country and Roaming Service!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select rst from csv.roaming.domain.RoamingServiceTariff rst where rst.operatorCountry.operatorCountryId=? and rst.roamingService.roamingServiceId=?")
					.setLong(0, operatorCountry.getOperatorCountryId())
					.setLong(1, roamingService.getRoamingServiceId());
			return (RoamingServiceTariff) q.uniqueResult();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new RoamingServiceTariff();
	}

	@Override
	public TariffCalculationParams findActiveTariffCalcParam(
			OperatorCountry operatorCountry, Date validMonth) {
		try {
			log
					.info("find Tariff Calc. Params. by Operator Country and Valid Month!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select cp from csv.roaming.domain.TariffCalculationParams cp where cp.operatorCountry.operatorCountryId =? and cp.validMonth=? and cp.active=true")
					.setLong(0, operatorCountry.getOperatorCountryId())
					.setDate(1, validMonth);
			return (TariffCalculationParams) q.uniqueResult();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new TariffCalculationParams();
	}

	@Override
	public List<TariffCalculationParams> findAllTariffCalcParamsByMonth(
			Date validMonth) {
		try {
			log.info("find Tariff Calc. Params by Valid Month!!!!!!!!!!!!!!!");

			Query q = session
					.createQuery(
							"select cp from csv.roaming.domain.TariffCalculationParams cp where cp.validMonth=? and cp.active=true")
					.setDate(0, validMonth);
			return (List<TariffCalculationParams>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<TariffCalculationParams>();
	}

	@Override
	public List<OperatorCountry> findAllOperatorCountriesByMainAgreement(
			MainAgreement mainAgreement) {
		try {
			log
					.info("find All Operator Countrys by Main Agreement!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select opr from csv.roaming.domain.OperatorCountry opr where opr.mainAgreement.mainAgreementId =? order by opr.operatorCountryId asc")
					.setLong(0, mainAgreement.getMainAgreementId());
			return (List<OperatorCountry>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorCountry>();
	}

	@Override
	public List<CountryRegion> findAllCountryRegions() {
		try {
			log.info("find All Country Regions!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select cr from csv.roaming.domain.CountryRegion cr order by cr.countryRegionName asc");
			return (List<CountryRegion>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CountryRegion>();
	}

	@Override
	public List<Country> findAllCountriesByOperator(Operator operator) {
		try {
			log.info("find All Country Regions by Operator!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select opr.country from csv.roaming.domain.OperatorCountry opr where opr.operator.operatorId =? order by opr.country.countryName asc")
					.setLong(0, operator.getOperatorId());
			return (List<Country>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Country>();
	}

	@Override
	public List<RoamingService> findAllRoamingServicesByOperatorCountry(
			OperatorCountry operatorCountry) {
		try {
			log
					.info("find All Roaming Services By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select ops.roamingService from csv.roaming.domain.OperatorService ops where ops.operatorCountry.operatorCountryId =? order by ops.operatorServiceId asc")
					.setLong(0, operatorCountry.getOperatorCountryId());
			return (List<RoamingService>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<RoamingService>();
	}

	public boolean updateMainAgreementForOperatorCountry(
			OperatorCountry operatorCountry, MainAgreement newMainAgreement) {

		String updateSchedules = "UPDATE MAIN_AGREEMENT_SCHEDULE   SET ACTIVE = 0, PASSIVE_DATE = SYSDATE, MAIN_AGREEMENT_ID = "
				+ (operatorCountry.getMainAgreement() == null ? null
						: operatorCountry.getMainAgreement()
								.getMainAgreementId())
				+ " WHERE ACTIVE=1 AND OPERATOR_COUNTRY_ID = "
				+ operatorCountry.getOperatorCountryId();
		String updateTariffs = "UPDATE TARIFF_CALCULATION_PARAMS   SET ACTIVE = 0, PASSIVE_DATE = SYSDATE, MAIN_AGREEMENT_ID = "
				+ (operatorCountry.getMainAgreement() == null ? null
						: operatorCountry.getMainAgreement()
								.getMainAgreementId())
				+ " WHERE ACTIVE=1 AND OPERATOR_COUNTRY_ID = "
				+ operatorCountry.getOperatorCountryId();
		String updateOperatorCountry = "UPDATE OPERATOR_COUNTRY   SET MAIN_AGREEMENT_ID = "
				+ (newMainAgreement == null ? null : newMainAgreement
						.getMainAgreementId())
				+ " WHERE OPERATOR_REGION_ID = "
				+ operatorCountry.getOperatorCountryId();

		session.beginTransaction();
		try {
			// Update Main Agreement Schedules
			SQLQuery sqlQuery = session.createSQLQuery(updateSchedules);
			sqlQuery.executeUpdate();
			// Update Tariff Calculation Params.
			sqlQuery = session.createSQLQuery(updateTariffs);
			sqlQuery.executeUpdate();
			// Update Operator Region with new Main Agreement
			sqlQuery = session.createSQLQuery(updateOperatorCountry);
			sqlQuery.executeUpdate();

			session.getTransaction().commit();
			return true;

		} catch (Exception e) {
			log
					.error("Error while updating Main Agreement For Operator Country!!!");
			session.getTransaction().rollback();
			return false;
		}

	}

	@Override
	public List<MainAgreementSchedule> findMainAgreementSchedulesByScheduleType(
			RoamingScheduleType scheduleType, Boolean isActive) {
		try {
			log
					.info("find All MainAgreementSchedules By Schedule Type!!!!!!!!!!!!!!!");

			Criteria criteria = session
					.createCriteria(MainAgreementSchedule.class);

			criteria.add(Restrictions.eq("scheduleType", scheduleType));
			if (isActive != null) {
				criteria.add(Restrictions.eq("active", isActive));
			}
			return (List<MainAgreementSchedule>) criteria.list();
			// Query q = session
			// .createQuery(
			// "select mas from csv.roaming.domain.MainAgreementSchedule mas where mas.scheduleType =? and mas.active = ? order by mas.mainAgreementScheduleId asc").
			// .setLong(0, scheduleType.getValue())
			// .setBoolean(1, isActive);
			// return (List<MainAgreementSchedule>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementSchedule>();
	}

	@Override
	public List<MainAgreementSchedule> findMainAgreementSchedulesByCriteria(
			RoamingScheduleType scheduleType, String statusOperator,
			AgreementStatus status, Boolean isActive) {
		try {
			log
					.info("find All MainAgreementSchedules By Criteria!!!!!!!!!!!!!!!");

			Criteria criteria = session
					.createCriteria(MainAgreementSchedule.class);

			if (scheduleType != null) {
				criteria.add(Restrictions.eq("scheduleType", scheduleType));
			}
			if (isActive != null) {
				criteria.add(Restrictions.eq("active", isActive));
			}
			if (status != null && statusOperator != null) {
				if ("IsNot".equals(statusOperator)) {
					criteria.add(Restrictions.ne("status", status));
				} else {
					criteria.add(Restrictions.eq("status", status));

				}
			}
			return (List<MainAgreementSchedule>) criteria.list();
			// Query q = session
			// .createQuery(
			// "select mas from csv.roaming.domain.MainAgreementSchedule mas where mas.scheduleType =? and mas.active = ? order by mas.mainAgreementScheduleId asc").
			// .setLong(0, scheduleType.getValue())
			// .setBoolean(1, isActive);
			// return (List<MainAgreementSchedule>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreementSchedule>();
	}

	@Override
	public List<Country> findAllCountriesByName(String countryName) {
		try {
			log.info("find All Countries By Country Name!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select c from csv.roaming.domain.Country c where upper(c.countryName) like upper(?) order by c.countryId asc")
					.setString(0, "%" + countryName + "%");
			return (List<Country>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Country>();
	}

	@Override
	public List<MainAgreement> findAllMainAgreementsByName(String agreementName) {
		try {
			log
					.info("find All Main Agreements By Agreement Name!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select ma from csv.roaming.domain.MainAgreement ma where upper(ma.description) like upper( ? ) order by ma.mainAgreementId asc")
					.setString(0, "%" + agreementName + "%");
			return (List<MainAgreement>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<MainAgreement>();
	}

	@Override
	public List<Operator> findAllOperatorsByName(String operatorName) {
		try {
			log.info("find All Operators By Operator Name!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select op from csv.roaming.domain.Operator op where upper(op.operatorName) like upper(?) order by op.operatorId asc")
					.setString(0, "%" + operatorName + "%");
			return (List<Operator>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Operator>();
	}

	@Override
	public List<OperatorCountry> findAllOperatorCountriesByCriteria(
			String ccnc, String mccmnc, String operatorCode, String operatorName) {
		try {
			log.info("find All Operator Countries By Criteria!!!!!!!!!!!!!!!");

			Query q = session
					.createQuery(
							"select op from csv.roaming.domain.OperatorCountry op where "
									+ "     (upper(op.operator.ccnc) like upper(?) or op.operator.ccnc is null)"
									+ " and (upper(op.operator.networkCode) like upper(?) or op.operator.networkCode is null) "
									+ " and (upper(op.operator.operatorCode) like upper(?) or op.operator.operatorCode is null) "
									+ " and (upper(op.operator.operatorName) like upper(?) or op.operator.operatorName is null) "
									+ " order by op.operatorCountryId asc")
					.setString(0, "%" + ccnc + "%").setString(1,
							"%" + mccmnc + "%").setString(2,
							"%" + operatorCode + "%").setString(3,
							"%" + operatorName + "%");
			return (List<OperatorCountry>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorCountry>();
	}

	@Override
	public List<OperatorTariff> findAllOperatorTariffsByOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		try {
			log
					.info("find All Operator Tariffs By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select op from csv.roaming.domain.OperatorTariff op where op.operatorCountry.operatorCountryId = ? order by op.operatorTariffId asc")
					.setLong(0, selectedOperatorCountry.getOperatorCountryId());
			return (List<OperatorTariff>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<OperatorTariff>();
	}

	@Override
	public List<Service> findAllServices() {
		try {
			log.info("find All Services!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery("select sr from csv.roaming.domain.Service sr order by sr.serviceName asc");
			return (List<Service>) q.list();

		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<Service>();
	}

	public List<CommercialReport> findCommercialReportList(Long continentId,
			Long countryId) {

		try {
			Query q = session.getNamedQuery("commercialReportQuery")
					.setResultTransformer(
							Transformers.aliasToBean(CommercialReport.class))
					.setBigDecimal(
							"countryId",
							countryId == null ? null
									: new BigDecimal(countryId)).setBigDecimal(
							"continentId",
							continentId == null ? null : new BigDecimal(
									continentId));

			return (List<CommercialReport>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<CommercialReport>();

	}

	public List<AgreementKPIObject> findAgreementKPIList() {

		try {
			Query q = session.getNamedQuery("agreementKPIQuery")
					.setResultTransformer(
							Transformers.aliasToBean(AgreementKPIObject.class));

			return (List<AgreementKPIObject>) q.list();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return new ArrayList<AgreementKPIObject>();

	}

	public long findTariffCountByMonth(Date date) {

		try {
			log.info("find Tariff Count By Date!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"select count(*) from csv.roaming.domain.TariffCalculationParams tp where tp.validMonth = ? order by tp.tariffCalcParamId asc")
					.setDate(0, date);
			return (Long) q.uniqueResult();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return 0;

	}

	public int copyTariffs(Date fromDate, String toDate) {

		try {
			Query q = session.getNamedQuery("transferTariffInsertStatement");
			q.setString(0, toDate);
			q.setDate(1, fromDate);

			return q.executeUpdate();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return 0;
	}

	public int deleteAllTariffsByDate(Date date) {
		try {
			log
					.info("find All Operator Tariffs By Operator Country!!!!!!!!!!!!!!!");
			Query q = session
					.createQuery(
							"delete from csv.roaming.domain.TariffCalculationParams tp where tp.validMonth = ?")
					.setDate(0, date);
			return q.executeUpdate();
		} catch (HibernateException he) {
			log.error(he);
			handleException(he);
		}
		return 0;
	}

}
