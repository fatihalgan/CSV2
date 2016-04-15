package csv.util.invoices;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class PCalendar extends GregorianCalendar {
	public PCalendar() {
		super();
	}

	public String getDate(String delimiter) {
		String year, month, day;

		year = java.lang.String.valueOf(get(Calendar.YEAR));
		if (get(Calendar.MONTH) + 1 < 10)
			month = "0" + java.lang.String.valueOf(get(Calendar.MONTH) + 1);
		else
			month = java.lang.String.valueOf(get(Calendar.MONTH) + 1);
		if (get(Calendar.DAY_OF_MONTH) < 10)
			day = "0" + java.lang.String.valueOf(get(Calendar.DAY_OF_MONTH));
		else
			day = java.lang.String.valueOf(get(Calendar.DAY_OF_MONTH));

		return year + delimiter + month + delimiter + day;
	}

	public String getPeriod(String delimiter) {
		String month = java.lang.String.valueOf(get(Calendar.MONTH) + 1);
		String year = java.lang.String.valueOf(get(Calendar.YEAR));
		if (month.length() == 1)
			return year + delimiter + "0" + month;
		else
			return year + delimiter + month;
	}

	public String getPeriod() {
		return getPeriod("/");
	}

	public String getMonth() {
		String retString = "";
		int month = get(Calendar.MONTH);
		switch (month) {
		case 0:
			retString = "Janeiro";
			break;
		case 1:
			retString = "Fevereiro";
			break;
		case 2:
			retString = "Marco";
			break;
		case 3:
			retString = "Abril";
			break;
		case 4:
			retString = "Maio";
			break;
		case 5:
			retString = "Junho";
			break;
		case 6:
			retString = "Julho";
			break;
		case 7:
			retString = "Agosto";
			break;
		case 8:
			retString = "Setembro";
			break;
		case 9:
			retString = "Outubro";
			break;
		case 10:
			retString = "Novembro";
			break;
		case 11:
			retString = "Dezembro";
			break;

		}
		return retString;
	}

	public String getYear() {
		return (java.lang.String.valueOf(get(Calendar.YEAR)));
	}
}
