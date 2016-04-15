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
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.AgreementStatus;
import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.Month;
import csv.roaming.domain.RoamingScheduleType;
import csv.roaming.domain.TariffCalculationParams;

@Name("roamingReportingService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class RoamingReportingService implements IRoamingReportingService,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private RoamingScheduleType selectedScheduleType;

	private List<MainAgreementSchedule> agreementScheduleList;

	private String statusOperator;

	private List<AgreementStatus> statusList;

	private AgreementStatus selectedStatus;

	private String isActive;

	private Month selectedMonth;

	private String year;

	private List<TariffCalculationParams> tariffCalculationParams;

	public List<TariffCalculationParams> getTariffCalculationParams() {
		if (tariffCalculationParams == null) {
			return new ArrayList<TariffCalculationParams>();
		}
		return tariffCalculationParams;
	}

	public void setTariffCalculationParams(
			List<TariffCalculationParams> tariffCalculationParams) {
		this.tariffCalculationParams = tariffCalculationParams;
	}

	public Month getSelectedMonth() {
		return selectedMonth;
	}

	public void setSelectedMonth(Month selectedMonth) {
		this.selectedMonth = selectedMonth;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getStatusOperator() {
		return statusOperator;
	}

	public void setStatusOperator(String statusOperator) {
		this.statusOperator = statusOperator;
	}

	public List<AgreementStatus> getStatusList() {
		if (statusList == null) {
			statusList = new ArrayList<AgreementStatus>();
		}
		return statusList;
	}

	public void setStatusList(List<AgreementStatus> statusList) {
		this.statusList = statusList;
	}

	public AgreementStatus getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(AgreementStatus selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public RoamingScheduleType getSelectedScheduleType() {
		return selectedScheduleType;
	}

	public void setSelectedScheduleType(RoamingScheduleType selectedScheduleType) {
		this.selectedScheduleType = selectedScheduleType;
	}

	public List<MainAgreementSchedule> getAgreementScheduleList() {
		if (agreementScheduleList == null) {
			agreementScheduleList = new ArrayList<MainAgreementSchedule>();
		}
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

	public void retriveTariffParamsReport() {
		Date createdDate = createDate();
		if (createdDate == null) {
			facesMessages.add("You have to enter a valid year!!! ");
			return;
		}
		tariffCalculationParams = roamingDao
				.findAllTariffCalcParamsByMonth(createdDate);
	}

	public void retrieveMainAgreementScheduleReport() {

		agreementScheduleList = roamingDao
				.findMainAgreementSchedulesByCriteria(selectedScheduleType,
						statusOperator, selectedStatus, convertActive());
	}

	public String evaluateSchedule() {
		if (getSelectedScheduleType() == null) {
			return "99";
		}
		return "" + getSelectedScheduleType().getValue();
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void findStatusList() {
		statusList = roamingDao.findAllAgreementStatus();
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component RoamingReportingService..");
	}

}
