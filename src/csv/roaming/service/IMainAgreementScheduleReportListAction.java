package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.RoamingScheduleType;

@Local
public interface IMainAgreementScheduleReportListAction {

	public RoamingScheduleType getSelectedScheduleType();

	public void setSelectedScheduleType(RoamingScheduleType selectedScheduleType);

	public List<MainAgreementSchedule> getScheduleList();

	public void setScheduleList(List<MainAgreementSchedule> scheduleList);

	public void remove();

	public void searchSchedules();
}
