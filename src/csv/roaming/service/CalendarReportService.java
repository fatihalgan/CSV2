package csv.roaming.service;

import java.io.Serializable;
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
import csv.roaming.domain.AgreementStatus;
import csv.roaming.domain.MainAgreementSchedule;

@Name("calendarReportService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CalendarReportService implements ICalendarReportService,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private int reportType;

	private AgreementStatus BILATERAL;

	private AgreementStatus READY_FOR_TESTING;

	private List<MainAgreementSchedule> agreementScheduleList;

	private String isActive;

	public AgreementStatus getBILATERAL() {
		return this.BILATERAL;
	}

	public void setBILATERAL(AgreementStatus BILATERAL) {
		this.BILATERAL = BILATERAL;
	}

	public AgreementStatus getREADY_FOR_TESTING() {
		return this.READY_FOR_TESTING;
	}

	public void setREADY_FOR_TESTING(AgreementStatus READYFORTESTING) {
		this.READY_FOR_TESTING = READYFORTESTING;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public int getReportType() {
		return reportType;
	}

	public void setReportType(int reportType) {
		this.reportType = reportType;
	}

	public List<MainAgreementSchedule> getAgreementScheduleList() {
		return agreementScheduleList;
	}

	public void setAgreementScheduleList(
			List<MainAgreementSchedule> agreementScheduleList) {
		this.agreementScheduleList = agreementScheduleList;
	}

	private Boolean convertActive() {
		if ("Active".equals(isActive)) {
			return true;
		} else if ("Passive".equals(isActive)) {
			return false;
		}
		return null;
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void findStatusList() {
		List<AgreementStatus> statusList = roamingDao.findAllAgreementStatus();
		// !!!It relies on the description field of Agreement Status object. May
		// need attention!!!
		for (Iterator iterator = statusList.iterator(); iterator.hasNext();) {
			AgreementStatus agreementStatus = (AgreementStatus) iterator.next();
			if ("BILATERAL".equals(agreementStatus.getDescription())) {
				BILATERAL = agreementStatus;
			} else if ("READY_FOR_TESTING".equals(agreementStatus
					.getDescription())) {
				READY_FOR_TESTING = agreementStatus;
			}
		}

	}

	public String evaluateReportType() {
		if (getReportType() == 0) {
			facesMessages.add("You have to select a report type first!!!");
			return null;
		}
		return "" + getReportType();
	}

	public void retrieveCalendarReport() {

		switch (reportType) {
		case 1:// Implementation Calendar
			agreementScheduleList = roamingDao
					.findMainAgreementSchedulesByCriteria(null, "Is",
							this.READY_FOR_TESTING, convertActive());
			break;
		case 2:// Implementation Calendar KPI
			agreementScheduleList = roamingDao
					.findMainAgreementSchedulesByCriteria(null, "Is",
							this.READY_FOR_TESTING, convertActive());
			break;
		case 3:// Negotiation Calendar
			agreementScheduleList = roamingDao
					.findMainAgreementSchedulesByCriteria(null, "IsNot",
							this.BILATERAL, convertActive());
			break;
		case 4:// Negotiation Calendar KPI
			agreementScheduleList = roamingDao
					.findMainAgreementSchedulesByCriteria(null, "IsNot",
							this.BILATERAL, convertActive());
			break;
		case 5:// Commercial Launch Calendar KPI
			agreementScheduleList = roamingDao
					.findMainAgreementSchedulesByCriteria(null, null, null,
							convertActive());
			break;
		default:
			facesMessages.add("You have to select, Report Type first!!!");
			break;
		}

	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component CalendarReportService..");
	}

}
