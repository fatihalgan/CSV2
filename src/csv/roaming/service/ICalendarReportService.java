package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.AgreementStatus;
import csv.roaming.domain.MainAgreementSchedule;

@Local
public interface ICalendarReportService {
	public AgreementStatus getBILATERAL();

	public void setBILATERAL(AgreementStatus BILATERAL);

	public AgreementStatus getREADY_FOR_TESTING();

	public void setREADY_FOR_TESTING(AgreementStatus READYFORTESTING);

	public String getIsActive();

	public void setIsActive(String isActive);

	public int getReportType();

	public void setReportType(int reportType);

	public List<MainAgreementSchedule> getAgreementScheduleList();

	public void setAgreementScheduleList(
			List<MainAgreementSchedule> agreementScheduleList);

	public void findStatusList();

	public String evaluateReportType();

	public void retrieveCalendarReport();

	public void remove();
}
