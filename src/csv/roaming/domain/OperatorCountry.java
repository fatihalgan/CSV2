package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * OperatorRegion generated by hbm2java
 */
public class OperatorCountry implements java.io.Serializable {

	private Long operatorCountryId;
	private Country country;
	private Operator operator;
	private MainAgreement mainAgreement;
	private Set<OperatorContact> operatorContacts = new HashSet<OperatorContact>(
			0);
	private Set<OperatorTariff> operatorTariffs = new HashSet<OperatorTariff>(0);

	private Set<RoamingServiceTariff> roamingServiceTariffs = new HashSet<RoamingServiceTariff>(
			0);
	private Set<OperatorService> operatorServices = new HashSet<OperatorService>(
			0);
	private Set<OperatorAddress> operatorAddresses = new HashSet<OperatorAddress>(
			0);
	private Set<TariffCalculationParams> tariffCalculationParamses = new HashSet<TariffCalculationParams>(
			0);
	private Set<OperatorFrequency> operatorFrequencies = new HashSet<OperatorFrequency>(
			0);
	private Set<MainAgreementSchedule> mainAgreementSchedules = new HashSet<MainAgreementSchedule>(
			0);

	public OperatorCountry() {
	}

	public OperatorCountry(Long operatorCountryId, Country country,
			Operator operator) {
		this.operatorCountryId = operatorCountryId;
		this.country = country;
		this.operator = operator;
	}

	public OperatorCountry(Long operatorCountryId, Country country,
			Operator operator, MainAgreement mainAgreement,
			Set<OperatorContact> operatorContacts,
			Set<OperatorTariff> operatorTariffs,
			Set<RoamingServiceTariff> roamingServiceTariffs,
			Set<OperatorService> operatorServices,
			Set<OperatorAddress> operatorAddresses,
			Set<TariffCalculationParams> tariffCalculationParamses,
			Set<OperatorFrequency> operatorFrequencies,
			Set<MainAgreementSchedule> mainAgreementSchedules) {
		super();
		this.operatorCountryId = operatorCountryId;
		this.country = country;
		this.operator = operator;
		this.mainAgreement = mainAgreement;
		this.operatorContacts = operatorContacts;
		this.operatorTariffs = operatorTariffs;
		this.roamingServiceTariffs = roamingServiceTariffs;
		this.operatorServices = operatorServices;
		this.operatorAddresses = operatorAddresses;
		this.tariffCalculationParamses = tariffCalculationParamses;
		this.operatorFrequencies = operatorFrequencies;
		this.mainAgreementSchedules = mainAgreementSchedules;
	}

	public Long getOperatorCountryId() {
		return operatorCountryId;
	}

	public void setOperatorCountryId(Long operatorCountryId) {
		this.operatorCountryId = operatorCountryId;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Operator getOperator() {
		return this.operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public MainAgreement getMainAgreement() {
		return this.mainAgreement;
	}

	public void setMainAgreement(MainAgreement mainAgreement) {
		this.mainAgreement = mainAgreement;
	}

	public Set<OperatorContact> getOperatorContacts() {
		return this.operatorContacts;
	}

	public void setOperatorContacts(Set<OperatorContact> operatorContacts) {
		this.operatorContacts = operatorContacts;
	}

	public Set<RoamingServiceTariff> getRoamingServiceTariffs() {
		return this.roamingServiceTariffs;
	}

	public void setRoamingServiceTariffs(
			Set<RoamingServiceTariff> roamingServiceTariffs) {
		this.roamingServiceTariffs = roamingServiceTariffs;
	}

	public Set<OperatorService> getOperatorServices() {
		return this.operatorServices;
	}

	public void setOperatorServices(Set<OperatorService> operatorServices) {
		this.operatorServices = operatorServices;
	}

	public Set<OperatorAddress> getOperatorAddresses() {
		return this.operatorAddresses;
	}

	public void setOperatorAddresses(Set<OperatorAddress> operatorAddresses) {
		this.operatorAddresses = operatorAddresses;
	}

	public Set<TariffCalculationParams> getTariffCalculationParamses() {
		return this.tariffCalculationParamses;
	}

	public void setTariffCalculationParamses(
			Set<TariffCalculationParams> tariffCalculationParamses) {
		this.tariffCalculationParamses = tariffCalculationParamses;
	}

	public Set<OperatorFrequency> getOperatorFrequencies() {
		return this.operatorFrequencies;
	}

	public void setOperatorFrequencies(
			Set<OperatorFrequency> operatorFrequencies) {
		this.operatorFrequencies = operatorFrequencies;
	}

	public Set<MainAgreementSchedule> getMainAgreementSchedules() {
		return this.mainAgreementSchedules;
	}

	public void setMainAgreementSchedules(
			Set<MainAgreementSchedule> mainAgreementSchedules) {
		this.mainAgreementSchedules = mainAgreementSchedules;
	}

	public Set<OperatorTariff> getOperatorTariffs() {
		return operatorTariffs;
	}

	public void setOperatorTariffs(Set<OperatorTariff> operatorTariffs) {
		this.operatorTariffs = operatorTariffs;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof OperatorCountry))
			return false;
		OperatorCountry castOther = (OperatorCountry) other;
		return new EqualsBuilder().append(country, castOther.country).append(
				operator, castOther.operator).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(1863761315, -1124594415).append(country)
				.append(operator).toHashCode();
	}

}
