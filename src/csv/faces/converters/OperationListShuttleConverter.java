package csv.faces.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import csv.security.domain.Operation;

public class OperationListShuttleConverter implements Converter {

	private List<Operation> operations = new ArrayList<Operation>();
	
	public OperationListShuttleConverter(List<Operation> unselectedOperations, List<Operation> selectedOperations) {
		super();
		operations.addAll(unselectedOperations);
		operations.addAll(selectedOperations);	
	}

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		StringTokenizer tok = new StringTokenizer(value, ":");
		Operation operation = new Operation();
		operation.setId(Long.parseLong(tok.nextToken()));
		operation.setOperationName(tok.nextToken());
		operation.setDescription(tok.nextToken());
		for(Operation item : this.operations) {
			if(item.equals(operation)) return item;
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object object) {
		Operation operation = (Operation)object;
		StringBuffer buf = new StringBuffer();
		buf.append(operation.getId() + ":");
		buf.append(operation.getOperationName() + ":");
		buf.append(operation.getDescription());
		return buf.toString();
	}
}
