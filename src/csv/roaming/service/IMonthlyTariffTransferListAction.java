package csv.roaming.service;

import javax.ejb.Local;

import csv.roaming.domain.Month;

@Local
public interface IMonthlyTariffTransferListAction {

	public String getCheckString();

	public void setCheckString(String checkString);

	public Month getFromMonth();

	public void setFromMonth(Month fromMonth);

	public String getFromYear();

	public void setFromYear(String fromYear);

	public Month getToMonth();

	public void setToMonth(Month toMonth);

	public String getToYear();

	public void setToYear(String toYear);

	public void transferTariffs();

	public void checkCounts();

	public void remove();
}
