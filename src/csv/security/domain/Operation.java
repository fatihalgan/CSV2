package csv.security.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Operation implements Serializable, Comparable<Operation> {

	private Long id;
	private String operationName;
	private String description;
	private Set<Group> permittedGroups = new TreeSet<Group>();
	private Module owningModule;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOperationName() {
		return operationName;
	}
	
	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Set<Group> getPermittedGroups() {
		return permittedGroups;
	}
	
	public void setPermittedGroups(Set<Group> permittedGroups) {
		this.permittedGroups = permittedGroups;
	}
	
	public void addPermittedGroup(Group group) {
		this.getPermittedGroups().add(group);
		group.getPermittedOperations().add(this);
	}
	
	public void removePermittedGroup(Group group) {
		this.getPermittedGroups().remove(group);
		group.getPermittedOperations().remove(this);
	}
	
	public void removeAllPermittedGroups() {
		for(Group g : getPermittedGroups().toArray(new Group[getPermittedGroups().size()])) {
			g.removePermittedOperation(this);
			removePermittedGroup(g);
		}
	}
	
	@Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Operation)) {
            return false;
        }
        Operation castOther = (Operation) other;
        return new EqualsBuilder().append(operationName, castOther.operationName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1887211545, -1182830207).append(operationName).toHashCode();
    }
    
    public void updatePermittedGroups(List<Group> groups) {
    	for(Group group : getPermittedGroups().toArray(new Group[getPermittedGroups().size()])) {
    		if(!groups.contains(group)) removePermittedGroup(group);
    	}
    	
    	for(Group group : groups) {
    		if(!getPermittedGroups().contains(group)) addPermittedGroup(group);
    	}
    }

	public Module getOwningModule() {
		return owningModule;
	}

	public void setOwningModule(Module owningModule) {
		this.owningModule = owningModule;
	}

	@Override
	public int compareTo(Operation o) {
		return this.operationName.compareTo(o.operationName);
	}
    
}
