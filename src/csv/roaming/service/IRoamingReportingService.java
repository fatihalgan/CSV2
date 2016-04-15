package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.AgreementStatus;
import csv.roaming.domain.MainAgreementSchedule;
import csv.roaming.domain.Month;
import csv.roaming.domain.RoamingScheduleType;
import csv.roaming.domain.TariffCalculationParams;

@Local
public interface IRoamingReportingService {

	public String getIsActive();

	public void setIsActive(String isActive);

	public String getStatusOperator();

	public void setStatusOperator(String statusOperator);

	public List<AgreementStatus> getStatusList();

	public void setStatusList(List<AgreementStatus> statusList);

	public AgreementStatus getSelectedStatus();

	public void setSelectedStatus(AgreementStatus selectedStatus);

	public RoamingScheduleType getSelectedScheduleType();

	public void setSelectedScheduleType(RoamingScheduleType selectedScheduleType);

	public List<MainAgreementSchedule> getAgreementScheduleList();

	public void setAgreementScheduleList(
			List<MainAgreementSchedule> agreementScheduleList);

	public void retrieveMainAgreementScheduleReport();

	public void remove();

	public void findStatusList();

	public String evaluateSchedule();

	public List<TariffCalculationParams> getTariffCalculationParams();

	public void setTariffCalculationParams(
			List<TariffCalculationParams> tariffCalculationParams);

	public Month getSelectedMonth();

	public void setSelectedMonth(Month selectedMonth);

	public String getYear();

	public void setYear(String year);

	public void retriveTariffParamsReport();
}
