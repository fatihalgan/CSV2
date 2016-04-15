package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.RoamingScheduleType;

@Name("mainAgreementScheduleReportListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MainAgreementScheduleReportListAction implements
		IMainAgreementScheduleReportListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private RoamingScheduleType selectedScheduleType;

	private List<MainAgreementSchedule> scheduleList;

	public RoamingScheduleType getSelectedScheduleType() {
		if (selectedScheduleType == null) {
			selectedScheduleType = RoamingScheduleType.GSM;
		}
		return selectedScheduleType;
	}

	public void setSelectedScheduleType(RoamingScheduleType selectedScheduleType) {
		this.selectedScheduleType = selectedScheduleType;
	}

	public List<MainAgreementSchedule> getScheduleList() {
		if (scheduleList == null) {
			scheduleList = new ArrayList<MainAgreementSchedule>();
		}
		return scheduleList;
	}

	public void setScheduleList(List<MainAgreementSchedule> scheduleList) {
		this.scheduleList = scheduleList;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component MainAgreementScheduleReportListAction..");
	}

	public void searchSchedules() {
		// if (selectedScheduleType == null) {
		// facesMessages.add("You have to select a schedule type first!!!");
		// return;
		// }
		selectedScheduleType = RoamingScheduleType.GSM;
		Boolean isActive = null;//
		scheduleList = roamingDao.findMainAgreementSchedulesByScheduleType(
				selectedScheduleType, isActive);

	}
}
