package csv.faces.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import csv.roaming.domain.Country;

public class CountryListShuttleConverter implements Converter {

	private List<Country> countries = new ArrayList<Country>();

	public CountryListShuttleConverter(List<Country> unselectedCountries,
			List<Country> selectedCountries) {
		super();
		countries.addAll(unselectedCountries);
		countries.addAll(selectedCountries);
	}

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		StringTokenizer tok = new StringTokenizer(value, ":");
		Country country = new Country();
		country.setCountryId(Long.parseLong(tok.nextToken()));
		country.setCountryName(tok.nextToken());
		for (Country item : this.countries) {
			if (item.equals(country))
				return item;
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object object) {

		Country country = (Country) object;
		StringBuffer buf = new StringBuffer();
		buf.append(country.getCountryId() + ":");
		buf.append(country.getCountryName());
		return buf.toString();
	}
}
