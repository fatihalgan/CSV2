package csv.roaming.domain;

// Generated Oct 8, 2010 9:42:47 AM by Hibernate Tools 3.3.0.GA

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * MainAgreementSchedule generated by hbm2java
 */
public class MainAgreementSchedule implements java.io.Serializable {

	private Long agreementScheduleId;
	private TadigStatus tadigStatus;
	private IregStatus iregStatus;
	private OperatorCountry operatorCountry;
	private RoamingScheduleType scheduleType;
	private AgreementStatus status;
	private RoamingStatus implementationStatus;
	private RoamingPriority commercialPriority;
	private RoamingPriority technicalPriority;
	private RoamingPriority commitmentLevel;
	private Double generalPriority;
	private Date plannedMonthOfTest;
	private Date scheduledTestDate;
	private Date plannedLaunchDate;
	private Date commercialLaunchDate;
	private RoamingStatus unixImplmStatus;
	private RoamingStatus bscsixImplmStatus;
	private Date implementationDate;
	private Boolean testCardsAvailableBoth;
	private Boolean cardInboundActive;
	private Boolean cardOutboundActive;
	private RoamingStatus signalingGatewayImplm;
	private RoamingQuality internationalRoutesQuality;
	private Date ir24TestStartDate;
	private Date ir24TestEndDate;
	private Date ir24OutboundTestEndDate;
	private String tdmoz01Name;
	private Date tdmoz01DispatchDate;
	private RoamingStatus tdmoz01Status;
	private String tdoperatorName;
	private Date tdoperatorReceptionDate;
	private OperatorFileStatus tdoperatorStatus;
	private String action;
	private Integer iregKpi;
	private Integer testDuration;
	private Integer rolloutDuration;
	private Date policyImplmEndDate;
	private Date cgsnImplmStartDate;
	private Date ir35TestStartDate;
	private Date ir35TestEndDate;
	private Date ir35OutboundTestEndDate;
	private Date gprsRoamingWorking;
	private Date nssImplmDate;
	private RoamingStatus csImplmStatus;
	private String platform;
	private RoamingStatus mmsgwTestStatus;
	private Boolean active;
	private Date passiveDate;
	private MainAgreement mainAgreement;
	private Date signatureDate;
	private Date firstApproachDate;

	// These fields are calculated on request if the fields are not null

	// Date of Launch - Signature Date
	private String implementationDuration;
	// Date of Launch - Planned Test Month
	private String reportTestDuration;

	public MainAgreementSchedule() {
	}

	public MainAgreementSchedule(Long agreementScheduleId,
			OperatorCountry operatorCountry, RoamingScheduleType scheduleType,
			Boolean active) {
		this.agreementScheduleId = agreementScheduleId;
		this.operatorCountry = operatorCountry;
		this.scheduleType = scheduleType;
		this.active = active;
	}

	public MainAgreementSchedule(Long agreementScheduleId,
			TadigStatus tadigStatus, IregStatus iregStatus,
			OperatorCountry operatorCountry, RoamingScheduleType scheduleType,
			AgreementStatus status, RoamingStatus implementationStatus,
			RoamingPriority commercialPriority,
			RoamingPriority technicalPriority, RoamingPriority commitmentLevel,
			Double generalPriority, Date plannedMonthOfTest,
			Date scheduledTestDate, Date plannedLaunchDate,
			Date commercialLaunchDate, RoamingStatus unixImplmStatus,
			RoamingStatus bscsixImplmStatus, Date implementationDate,
			Boolean testCardsAvailableBoth, Boolean cardInboundActive,
			Boolean cardOutboundActive, RoamingStatus signalingGatewayImplm,
			RoamingQuality internationalRoutesQuality, Date ir24TestStartDate,
			Date ir24TestEndDate, Date ir24OutboundTestEndDate,
			String tdmoz01Name, Date tdmoz01DispatchDate,
			RoamingStatus tdmoz01Status, String tdoperatorName,
			Date tdoperatorReceptionDate, OperatorFileStatus tdoperatorStatus,
			String action, Integer iregKpi, Integer testDuration,
			Integer rolloutDuration, Date policyImplmEndDate,
			Date cgsnImplmStartDate, Date ir35TestStartDate,
			Date ir35TestEndDate, Date ir35OutboundTestEndDate,
			Date gprsRoamingWorking, Date nssImplmDate,
			RoamingStatus csImplmStatus, String platform,
			RoamingStatus mmsgwTestStatus, Boolean active, Date passiveDate) {
		this.agreementScheduleId = agreementScheduleId;
		this.tadigStatus = tadigStatus;
		this.iregStatus = iregStatus;
		this.operatorCountry = operatorCountry;
		this.scheduleType = scheduleType;
		this.status = status;
		this.implementationStatus = implementationStatus;
		this.commercialPriority = commercialPriority;
		this.technicalPriority = technicalPriority;
		this.commitmentLevel = commitmentLevel;
		this.generalPriority = generalPriority;
		this.plannedMonthOfTest = plannedMonthOfTest;
		this.scheduledTestDate = scheduledTestDate;
		this.plannedLaunchDate = plannedLaunchDate;
		this.commercialLaunchDate = commercialLaunchDate;
		this.unixImplmStatus = unixImplmStatus;
		this.bscsixImplmStatus = bscsixImplmStatus;
		this.implementationDate = implementationDate;
		this.testCardsAvailableBoth = testCardsAvailableBoth;
		this.cardInboundActive = cardInboundActive;
		this.cardOutboundActive = cardOutboundActive;
		this.signalingGatewayImplm = signalingGatewayImplm;
		this.internationalRoutesQuality = internationalRoutesQuality;
		this.ir24TestStartDate = ir24TestStartDate;
		this.ir24TestEndDate = ir24TestEndDate;
		this.ir24OutboundTestEndDate = ir24OutboundTestEndDate;
		this.tdmoz01Name = tdmoz01Name;
		this.tdmoz01DispatchDate = tdmoz01DispatchDate;
		this.tdmoz01Status = tdmoz01Status;
		this.tdoperatorName = tdoperatorName;
		this.tdoperatorReceptionDate = tdoperatorReceptionDate;
		this.tdoperatorStatus = tdoperatorStatus;
		this.action = action;
		this.iregKpi = iregKpi;
		this.testDuration = testDuration;
		this.rolloutDuration = rolloutDuration;
		this.policyImplmEndDate = policyImplmEndDate;
		this.cgsnImplmStartDate = cgsnImplmStartDate;
		this.ir35TestStartDate = ir35TestStartDate;
		this.ir35TestEndDate = ir35TestEndDate;
		this.ir35OutboundTestEndDate = ir35OutboundTestEndDate;
		this.gprsRoamingWorking = gprsRoamingWorking;
		this.nssImplmDate = nssImplmDate;
		this.csImplmStatus = csImplmStatus;
		this.platform = platform;
		this.mmsgwTestStatus = mmsgwTestStatus;
		this.active = active;
		this.passiveDate = passiveDate;
	}

	public Long getAgreementScheduleId() {
		return this.agreementScheduleId;
	}

	public void setAgreementScheduleId(Long agreementScheduleId) {
		this.agreementScheduleId = agreementScheduleId;
	}

	public TadigStatus getTadigStatus() {
		return this.tadigStatus;
	}

	public void setTadigStatus(TadigStatus tadigStatus) {
		this.tadigStatus = tadigStatus;
	}

	public IregStatus getIregStatus() {
		return this.iregStatus;
	}

	public void setIregStatus(IregStatus iregStatus) {
		this.iregStatus = iregStatus;
	}

	public OperatorCountry getOperatorCountry() {
		return operatorCountry;
	}

	public void setOperatorCountry(OperatorCountry operatorCountry) {
		this.operatorCountry = operatorCountry;
	}

	public Double getGeneralPriority() {
		return this.generalPriority;
	}

	public void setGeneralPriority(Double generalPriority) {
		this.generalPriority = generalPriority;
	}

	public Date getPlannedMonthOfTest() {
		return this.plannedMonthOfTest;
	}

	public void setPlannedMonthOfTest(Date plannedMonthOfTest) {
		this.plannedMonthOfTest = plannedMonthOfTest;
	}

	public Date getScheduledTestDate() {
		return this.scheduledTestDate;
	}

	public void setScheduledTestDate(Date scheduledTestDate) {
		this.scheduledTestDate = scheduledTestDate;
	}

	public Date getPlannedLaunchDate() {
		return this.plannedLaunchDate;
	}

	public void setPlannedLaunchDate(Date plannedLaunchDate) {
		this.plannedLaunchDate = plannedLaunchDate;
	}

	public Date getCommercialLaunchDate() {
		return this.commercialLaunchDate;
	}

	public void setCommercialLaunchDate(Date commercialLaunchDate) {
		this.commercialLaunchDate = commercialLaunchDate;
	}

	public Date getImplementationDate() {
		return this.implementationDate;
	}

	public void setImplementationDate(Date implementationDate) {
		this.implementationDate = implementationDate;
	}

	public Date getIr24TestStartDate() {
		return this.ir24TestStartDate;
	}

	public void setIr24TestStartDate(Date ir24TestStartDate) {
		this.ir24TestStartDate = ir24TestStartDate;
	}

	public Date getIr24TestEndDate() {
		return this.ir24TestEndDate;
	}

	public void setIr24TestEndDate(Date ir24TestEndDate) {
		this.ir24TestEndDate = ir24TestEndDate;
	}

	public Date getIr24OutboundTestEndDate() {
		return this.ir24OutboundTestEndDate;
	}

	public void setIr24OutboundTestEndDate(Date ir24OutboundTestEndDate) {
		this.ir24OutboundTestEndDate = ir24OutboundTestEndDate;
	}

	public String getTdmoz01Name() {
		return this.tdmoz01Name;
	}

	public void setTdmoz01Name(String tdmoz01Name) {
		this.tdmoz01Name = tdmoz01Name;
	}

	public Date getTdmoz01DispatchDate() {
		return this.tdmoz01DispatchDate;
	}

	public void setTdmoz01DispatchDate(Date tdmoz01DispatchDate) {
		this.tdmoz01DispatchDate = tdmoz01DispatchDate;
	}

	public String getTdoperatorName() {
		return this.tdoperatorName;
	}

	public void setTdoperatorName(String tdoperatorName) {
		this.tdoperatorName = tdoperatorName;
	}

	public Date getTdoperatorReceptionDate() {
		return this.tdoperatorReceptionDate;
	}

	public void setTdoperatorReceptionDate(Date tdoperatorReceptionDate) {
		this.tdoperatorReceptionDate = tdoperatorReceptionDate;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Integer getIregKpi() {
		return this.iregKpi;
	}

	public void setIregKpi(Integer iregKpi) {
		this.iregKpi = iregKpi;
	}

	public Integer getTestDuration() {
		return this.testDuration;
	}

	public void setTestDuration(Integer testDuration) {
		this.testDuration = testDuration;
	}

	public Integer getRolloutDuration() {
		return this.rolloutDuration;
	}

	public void setRolloutDuration(Integer rolloutDuration) {
		this.rolloutDuration = rolloutDuration;
	}

	public Date getPolicyImplmEndDate() {
		return this.policyImplmEndDate;
	}

	public void setPolicyImplmEndDate(Date policyImplmEndDate) {
		this.policyImplmEndDate = policyImplmEndDate;
	}

	public Date getCgsnImplmStartDate() {
		return this.cgsnImplmStartDate;
	}

	public void setCgsnImplmStartDate(Date cgsnImplmStartDate) {
		this.cgsnImplmStartDate = cgsnImplmStartDate;
	}

	public Date getIr35TestStartDate() {
		return this.ir35TestStartDate;
	}

	public void setIr35TestStartDate(Date ir35TestStartDate) {
		this.ir35TestStartDate = ir35TestStartDate;
	}

	public Date getIr35TestEndDate() {
		return this.ir35TestEndDate;
	}

	public void setIr35TestEndDate(Date ir35TestEndDate) {
		this.ir35TestEndDate = ir35TestEndDate;
	}

	public Date getIr35OutboundTestEndDate() {
		return this.ir35OutboundTestEndDate;
	}

	public void setIr35OutboundTestEndDate(Date ir35OutboundTestEndDate) {
		this.ir35OutboundTestEndDate = ir35OutboundTestEndDate;
	}

	public Date getGprsRoamingWorking() {
		return this.gprsRoamingWorking;
	}

	public void setGprsRoamingWorking(Date gprsRoamingWorking) {
		this.gprsRoamingWorking = gprsRoamingWorking;
	}

	public Date getNssImplmDate() {
		return this.nssImplmDate;
	}

	public void setNssImplmDate(Date nssImplmDate) {
		this.nssImplmDate = nssImplmDate;
	}

	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public RoamingScheduleType getScheduleType() {
		return scheduleType;
	}

	public void setScheduleType(RoamingScheduleType scheduleType) {
		this.scheduleType = scheduleType;
	}

	public AgreementStatus getStatus() {
		return status;
	}

	public void setStatus(AgreementStatus status) {
		this.status = status;
	}

	public RoamingStatus getImplementationStatus() {
		return implementationStatus;
	}

	public void setImplementationStatus(RoamingStatus implementationStatus) {
		this.implementationStatus = implementationStatus;
	}

	public RoamingPriority getCommercialPriority() {
		return commercialPriority;
	}

	public void setCommercialPriority(RoamingPriority commercialPriority) {
		this.commercialPriority = commercialPriority;
	}

	public RoamingPriority getTechnicalPriority() {
		return technicalPriority;
	}

	public void setTechnicalPriority(RoamingPriority technicalPriority) {
		this.technicalPriority = technicalPriority;
	}

	public RoamingPriority getCommitmentLevel() {
		return commitmentLevel;
	}

	public void setCommitmentLevel(RoamingPriority commitmentLevel) {
		this.commitmentLevel = commitmentLevel;
	}

	public RoamingStatus getUnixImplmStatus() {
		return unixImplmStatus;
	}

	public void setUnixImplmStatus(RoamingStatus unixImplmStatus) {
		this.unixImplmStatus = unixImplmStatus;
	}

	public RoamingStatus getBscsixImplmStatus() {
		return bscsixImplmStatus;
	}

	public void setBscsixImplmStatus(RoamingStatus bscsixImplmStatus) {
		this.bscsixImplmStatus = bscsixImplmStatus;
	}

	public Boolean getTestCardsAvailableBoth() {
		return testCardsAvailableBoth;
	}

	public void setTestCardsAvailableBoth(Boolean testCardsAvailableBoth) {
		this.testCardsAvailableBoth = testCardsAvailableBoth;
	}

	public Boolean getCardInboundActive() {
		return cardInboundActive;
	}

	public void setCardInboundActive(Boolean cardInboundActive) {
		this.cardInboundActive = cardInboundActive;
	}

	public Boolean getCardOutboundActive() {
		return cardOutboundActive;
	}

	public void setCardOutboundActive(Boolean cardOutboundActive) {
		this.cardOutboundActive = cardOutboundActive;
	}

	public RoamingStatus getSignalingGatewayImplm() {
		return signalingGatewayImplm;
	}

	public void setSignalingGatewayImplm(RoamingStatus signalingGatewayImplm) {
		this.signalingGatewayImplm = signalingGatewayImplm;
	}

	public RoamingQuality getInternationalRoutesQuality() {
		return internationalRoutesQuality;
	}

	public void setInternationalRoutesQuality(
			RoamingQuality internationalRoutesQuality) {
		this.internationalRoutesQuality = internationalRoutesQuality;
	}

	public RoamingStatus getTdmoz01Status() {
		return tdmoz01Status;
	}

	public void setTdmoz01Status(RoamingStatus tdmoz01Status) {
		this.tdmoz01Status = tdmoz01Status;
	}

	public OperatorFileStatus getTdoperatorStatus() {
		return tdoperatorStatus;
	}

	public void setTdoperatorStatus(OperatorFileStatus tdoperatorStatus) {
		this.tdoperatorStatus = tdoperatorStatus;
	}

	public RoamingStatus getCsImplmStatus() {
		return csImplmStatus;
	}

	public void setCsImplmStatus(RoamingStatus csImplmStatus) {
		this.csImplmStatus = csImplmStatus;
	}

	public RoamingStatus getMmsgwTestStatus() {
		return mmsgwTestStatus;
	}

	public void setMmsgwTestStatus(RoamingStatus mmsgwTestStatus) {
		this.mmsgwTestStatus = mmsgwTestStatus;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Date getPassiveDate() {
		return passiveDate;
	}

	public void setPassiveDate(Date passiveDate) {
		this.passiveDate = passiveDate;
	}

	public MainAgreement getMainAgreement() {
		return mainAgreement;
	}

	public void setMainAgreement(MainAgreement mainAgreement) {
		this.mainAgreement = mainAgreement;
	}

	public Date getFirstApproachDate() {
		return firstApproachDate;
	}

	public void setFirstApproachDate(Date firstApproachDate) {
		this.firstApproachDate = firstApproachDate;
	}

	public Date getSignatureDate() {
		return signatureDate;
	}

	public void setSignatureDate(Date signatureDate) {
		this.signatureDate = signatureDate;
	}

	public String getImplementationDuration() {
		implementationDuration = calculateDuration(signatureDate,
				commercialLaunchDate);
		return implementationDuration;
	}

	public void setImplementationDuration(String implementationDuration) {
		this.implementationDuration = implementationDuration;
	}

	public String getReportTestDuration() {
		reportTestDuration = calculateDuration(plannedMonthOfTest,
				commercialLaunchDate);
		return reportTestDuration;
	}

	private String calculateDuration(Date firstDate, Date lastDate) {

		if (lastDate == null || firstDate == null) {
			return null;
		}

		long deltaDays = (lastDate.getTime() - firstDate.getTime())
				/ (1000 * 60 * 60 * 24);

		if (deltaDays > 30) {

			return (int) (deltaDays / 30)
					+ " Month(s) "
					+ (deltaDays % 30 == 0 ? "" : "and " + (deltaDays % 30)
							+ " days");

		} else {
			return deltaDays + " days";
		}
	}

	public void setReportTestDuration(String reportTestDuration) {
		this.reportTestDuration = reportTestDuration;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof MainAgreementSchedule))
			return false;
		MainAgreementSchedule castOther = (MainAgreementSchedule) other;
		return new EqualsBuilder().append(operatorCountry,
				castOther.operatorCountry).append(scheduleType,
				castOther.scheduleType).append(active, castOther.active)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1138253903, -1249245163).append(
				operatorCountry).append(scheduleType).append(active)
				.toHashCode();
	}

}
