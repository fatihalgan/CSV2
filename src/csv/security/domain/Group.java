package csv.security.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Group implements Serializable, Comparable<Group> {

	private static final long serialVersionUID = -724212030083878657L;

	private Long id;
	private String groupName;
	private String description;
	private GroupType groupType;
	
	private Set<User> usersInGroup = new TreeSet<User>();
	private Set<Operation> permittedOperations = new TreeSet<Operation>();
	
	private Set<Group> childGroups = new TreeSet<Group>();
	private Group parentGroup = null;
	
	public Group() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Group)) {
            return false;
        }
        Group castOther = (Group) other;
        return new EqualsBuilder().append(groupName, castOther.groupName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1987211545, -1382830207).append(groupName).toHashCode();
    }

	public Set<User> getUsersInGroup() {
		return usersInGroup;
	}

	public void setUsersInGroup(Set<User> usersInGroup) {
		this.usersInGroup = usersInGroup;
	}
	
	public Set<Operation> getPermittedOperations() {
		return permittedOperations;
	}

	public void setPermittedOperations(Set<Operation> permittedOperations) {
		this.permittedOperations = permittedOperations;
	}

	public void addUser(User user) {
		getUsersInGroup().add(user);
		user.getMemberships().add(this);
	}
	
	public void removeUser(User user) {
		getUsersInGroup().remove(user);
		user.getMemberships().remove(this);
	}
	
	public void addPermittedOperation(Operation operation) {
		getPermittedOperations().add(operation);
		operation.getPermittedGroups().add(this);
	}
	
	public void removePermittedOperation(Operation operation) {
		getPermittedOperations().remove(operation);
		operation.getPermittedGroups().remove(this);
	}
	
	public void removeAllPermittedOperations() {
		for(Operation operation : getPermittedOperations().toArray(new Operation[getPermittedOperations().size()])) {
			operation.removePermittedGroup(this);
			removePermittedOperation(operation);
		}
	}
	
	public void updateAuthorizations(List<Operation> operations) {
		for(Operation operation : getPermittedOperations().toArray(new Operation[getPermittedOperations().size()])) {
			if(!operations.contains(operation)) removePermittedOperation(operation);
		}
		
		for(Operation operation: operations) {
			if(!getPermittedOperations().contains(operation)) addPermittedOperation(operation);
		}
	}
	
	public boolean canChangeFafInfoWithoutLimit() {
		if(getGroupName().equals("System Admins") || getGroupName().equals("CC Supervisors") ||
			getGroupName().equals("CC Agents Help Desk") || getGroupName().equals("Postpaid Help Desk")) return true;
		return false;
	}
	
	public boolean canMakeAdjustmentsOnAllDedicatedAccounts() {
		if(getGroupName().equals("System Admins") || getGroupName().equals("CC Supervisors") ||
			getGroupName().equals("CC Agents Help Desk") || getGroupName().equals("Postpaid Help Desk")) return true;
		return false;
	}
	
	public boolean isHelpDesk() {
		if(getGroupName().equals("CC Agents Help Desk") || getGroupName().equals("Postpaid Help Desk")) return true;
		else return false;
	}
	
	public boolean isCustomerCareAgentOrShop() {
		if(getGroupName().trim().equals("CC Agents 111") || getGroupName().trim().equals("CCAgents 131")
				|| getGroupName().trim().equals("Shop Assistants") || getGroupName().trim().equals("Shop Supervisors")
				|| getGroupName().trim().equals("Shop Supervisor - 2nd in Charge")) return true;
		return false;
	}
	
	public boolean isCorporate() {
		if(getGroupName().equals("Corporate Responsible") || getGroupName().equals("Postpaid Help Desk") || getGroupName().equals("Business Support Supervisor") || getGroupName().equals("System Admins")) return true;
		else return false;
	}
	
	public Group getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(Group parentGroup) {
		this.parentGroup = parentGroup;
	}
	
	public Set<Group> getChildGroups() {
		return childGroups;
	}

	public void setChildGroups(Set<Group> childGroups) {
		this.childGroups = childGroups;
	}
	
	public List<Group> getAllChildGroups() {
		List<Group> children = new ArrayList<Group>();
		children.addAll(getChildGroups());
		for(Group g : getChildGroups()) {
			children.addAll(g.getAllChildGroups());
		}
		return children;
	}
	
	public List<String> getAllChildGroupNames() {
		List<String> returnVal = new ArrayList<String>();
		List<Group> children = getAllChildGroups();
		for(Group g : children) {
			returnVal.add(g.getGroupName());
		}
		return returnVal;
	}
	
	public Group getParentDepartmentLeader() {
		if(getParentGroup() == null) return null;
		if(getParentGroup().getGroupType().equals(GroupType.DEPARTMENT_LEADER)) return getParentGroup();
		else return getParentGroup().getParentDepartmentLeader();
	}
	
	public List<String> getAllSiblingGroupNamesUnderDepartmentLeader() {
		Group departmentLeader = getParentDepartmentLeader();
		if(departmentLeader == null) return new ArrayList<String>();
		return departmentLeader.getAllChildGroupNames();
	}
	
	public List<Group> getAllSiblingGroupsUnderDepartmentLeader() {
		Group departmentLeader = getParentDepartmentLeader();
		if(departmentLeader == null) return new ArrayList<Group>();
		return departmentLeader.getAllChildGroups();
	}
	
	public GroupType getGroupType() {
		return groupType;
	}

	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}

	public void addChildGroup(Group child) {
		getChildGroups().add(child);
		child.setParentGroup(this);
	}
	
	public void removeChildGroup(Group child) {
		getChildGroups().remove(child);
		child.setParentGroup(null);
	}
	
	public List<User> getGroupSupervisors() {
		List<User> retVal = new ArrayList<User>();
		for(User user : getUsersInGroup()) {
			if(user.isSupervisor()) retVal.add(user);
		}
		return retVal;
	}
	
	public boolean isDescendantOf(Group g) {
		if(getParentGroup() == null) return false;
		if(getParentGroup().equals(g)) return true;
		else return getParentGroup().isDescendantOf(g);
	}
	
	@Override
	public int compareTo(Group o) {
		return this.groupName.compareTo(o.groupName);
	}

	
}
