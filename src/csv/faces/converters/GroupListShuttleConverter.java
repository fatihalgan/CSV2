package csv.faces.converters;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import csv.security.domain.Group;

public class GroupListShuttleConverter implements Converter {

	private List<Group> groups = new ArrayList<Group>();
	
	public GroupListShuttleConverter(List<Group> unselectedGroups, List<Group> selectedGroups) {
		super();
		groups.addAll(unselectedGroups);
		groups.addAll(selectedGroups);	
	}

	public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
		StringTokenizer tok = new StringTokenizer(value, ":");
		Group group = new Group();
		group.setId(Long.parseLong(tok.nextToken()));
		group.setGroupName(tok.nextToken());
		group.setDescription(tok.nextToken());
		for(Group item : this.groups) {
			if(item.equals(group)) return item;
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object object) {
		Group group = (Group)object;
		StringBuffer buf = new StringBuffer();
		buf.append(group.getId() + ":");
		buf.append(group.getGroupName() + ":");
		buf.append(group.getDescription());
		return buf.toString();
	}
}
