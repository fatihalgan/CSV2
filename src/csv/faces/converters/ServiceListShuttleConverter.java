package csv.faces.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import csv.roaming.domain.RoamingService;

public class ServiceListShuttleConverter implements Converter {

	private List<RoamingService> roamingServices = new ArrayList<RoamingService>();

	public ServiceListShuttleConverter(
			List<RoamingService> unselectedRoamingServices,
			List<RoamingService> selectedRoamingServices) {
		super();
		roamingServices.addAll(unselectedRoamingServices);
		roamingServices.addAll(selectedRoamingServices);
	}

	public Object getAsObject(FacesContext ctx, UIComponent component,
			String value) {
		StringTokenizer tok = new StringTokenizer(value, ":");
		RoamingService service = new RoamingService();
		service.setRoamingServiceId(Long.parseLong(tok.nextToken()));
		service.setRoamingServiceName(tok.nextToken());
		for (RoamingService item : this.roamingServices) {
			if (item.equals(service))
				return item;
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component,
			Object object) {
		RoamingService service = (RoamingService) object;
		StringBuffer buf = new StringBuffer();
		buf.append(service.getRoamingServiceId() + ":");
		buf.append(service.getRoamingServiceName());
		return buf.toString();
	}
}
