package csv.security.domain;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Module implements Serializable, Comparable<Module> {

	private Long id;
	private String moduleName;
	private String description;
	
	private Set<Operation> operations = new TreeSet<Operation>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	@Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Module)) {
            return false;
        }
        Module castOther = (Module) other;
        return new EqualsBuilder().append(moduleName, castOther.moduleName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1287211545, -1182830107).append(moduleName).toHashCode();
    }
    
    public void addOperation(Operation operation) {
    	getOperations().add(operation);
    	operation.setOwningModule(this);
    }
	
	public void removeOperation(Operation operation) {
		getOperations().remove(operation);
		operation.setOwningModule(null);
	}

	@Override
	public int compareTo(Module o) {
		return this.moduleName.compareTo(o.moduleName);
	}
}
