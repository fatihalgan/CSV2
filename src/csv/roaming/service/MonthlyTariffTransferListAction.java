package csv.roaming.service;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

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
import csv.roaming.domain.Month;

@Name("monthlyTariffTransferListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MonthlyTariffTransferListAction implements
		IMonthlyTariffTransferListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private Month fromMonth;

	private String fromYear;

	private Month toMonth;

	private String toYear;

	private String checkString;

	public String getCheckString() {
		return checkString;
	}

	public void setCheckString(String checkString) {
		this.checkString = checkString;
	}

	public Month getFromMonth() {
		return fromMonth;
	}

	public void setFromMonth(Month fromMonth) {
		this.fromMonth = fromMonth;
	}

	public String getFromYear() {
		return fromYear;
	}

	public void setFromYear(String fromYear) {
		this.fromYear = fromYear;
	}

	public Month getToMonth() {
		return toMonth;
	}

	public void setToMonth(Month toMonth) {
		this.toMonth = toMonth;
	}

	public String getToYear() {
		return toYear;
	}

	public void setToYear(String toYear) {
		this.toYear = toYear;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component AgreementStatusListAction..");
	}

	public void checkCounts() {

		Date from = createDate(fromMonth, fromYear);
		Date to = createDate(toMonth, toYear);

		if (from == null || to == null || !controlDates()) {
			checkString = "The dates must be valid and different!!!";
			return;
		}

		long fromCount = roamingDao.findTariffCountByMonth(from);
		long toCount = roamingDao.findTariffCountByMonth(to);

		if (fromCount == 0) {
			checkString = "The from month/year does not contain any tariff information!!!";
			return;
		}

		if (toCount > 0) {
			checkString = "Existing " + toCount
					+ " tariff records will be deleted from " + toYear + "/"
					+ toMonth.getLabel() + " and " + fromCount
					+ " tariff would be copied!!!";
		} else {
			checkString = fromCount + " tariff would be copied to " + toYear
					+ "/" + toMonth.getLabel() + "!!!";
		}

	}

	public void transferTariffs() {

		Date from = createDate(fromMonth, fromYear);
		Date to = createDate(toMonth, toYear);
		String toString = createStringDate(to);

		if (from == null || to == null || !controlDates()) {
			facesMessages.add("The dates must be valid and different");
			return;
		}

		long fromCount = roamingDao.findTariffCountByMonth(from);
		long toCount = roamingDao.findTariffCountByMonth(to);

		if (fromCount == 0) {
			facesMessages
					.add("The from month/year does not contain any tariff information!!!");
			return;
		}

		if (toCount > 0) {
			roamingDao.deleteAllTariffsByDate(to);
		}

		int copiedTariffs = roamingDao.copyTariffs(from, toString);

		if (copiedTariffs == 0) {
			facesMessages.add("Tariff Calculation is not succesful!!!");
			return;
		}

		facesMessages.add(copiedTariffs + " Tariffs Copied succesfully to :"
				+ toYear + "/" + toMonth.getLabel());
	}

	private String createStringDate(Date date) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		return df.format(date);

	}

	private boolean controlDates() {

		if (fromMonth.getValue() == toMonth.getValue()
				&& fromYear.equals(toYear)) {
			return false;
		}
		return true;
	}

	private Date createDate(Month month, String year) {
		try {
			Integer yearInt = Integer.parseInt(year);

			GregorianCalendar newGregCal = new GregorianCalendar(yearInt, month
					.getValue(), 1);
			return new Date(newGregCal.getTimeInMillis());
		} catch (Exception e) {
			return null;
		}

	}

}
