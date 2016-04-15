package csv.security.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class User implements Serializable, Comparable<User> {
	
	private static final long serialVersionUID = -8586962077233218649L;

	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean active = true;
	private String msisdn;
	private String telephone;
	private String ext;
	private String email;
	private Date expirationDate;
	private boolean supervisor;
	private String clientIPAddress;
	private Locale locale = new Locale("en");
	
	private Set<Group> memberships = new TreeSet<Group>();
	
	private Set<String> authenticatedOperations  = new HashSet<String>();
	
	private Set<User> supervisedUsersInGroup = new TreeSet<User>();
	
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getClientIPAddress() {
		return clientIPAddress;
	}

	public void setClientIPAddress(String clientIPAddress) {
		this.clientIPAddress = clientIPAddress;
	}
	
	public boolean isSupervisor() {
		return supervisor;
	}

	public void setSupervisor(boolean supervisor) {
		this.supervisor = supervisor;
	}
	
	public Set<User> getSupervisedUsersInGroup() {
		return supervisedUsersInGroup;
	}

	@Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User castOther = (User) other;
        return new EqualsBuilder().append(username, castOther.username).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(-1987210545, -1382830007).append(username).toHashCode();
    }

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public Set<Group> getMemberships() {
		return memberships;
	}
	
	public List<Group> getMembershipList() {
		return new ArrayList<Group>(getMemberships());
	}
	
	public void setMemberships(Set<Group> memberships) {
		this.memberships = memberships;
	}
	
	public Group getMembershipOfType(GroupType type) {
		Set<Group> memberships = getMemberships();
		for(Group g : memberships) {
			if(g.getGroupType().equals(type)) return g;
		}
		return null;
	}
	
	public void addMembership(Group group) {
		this.getMemberships().add(group);
		group.getUsersInGroup().add(this);
	}
	
	public void removeMembership(Group group) {
		this.getMemberships().remove(group);
		group.getUsersInGroup().remove(this);
	}
	
	public void removeAllMemberships() {
		for(Group group : getMemberships().toArray(new Group[getMemberships().size()])) {
			group.removeUser(this);
			removeMembership(group);
		}
	}
	
	public void updateMemberships(List<Group> groups) {
		for(Group group : getMemberships().toArray(new Group[getMemberships().size()])) {
			if(!groups.contains(group)) removeMembership(group);
		}
		for(Group group : groups) {
			if(!getMemberships().contains(group)) addMembership(group);
		}
	}
	
	public void loadAuthenticatedOperations() {
		for(Group g : getMemberships()) {
			for(Operation o : g.getPermittedOperations()) {
				authenticatedOperations.add(o.getOperationName());
				authenticatedOperations.add(o.getOwningModule().getModuleName());
			}
		}
	}
	
	public void loadSupervisedUsersInGroup() {
		if(!isSupervisor()) return;
		for(Group g : getMemberships()) {
			supervisedUsersInGroup.addAll(g.getUsersInGroup());
		}
		supervisedUsersInGroup.remove(this);
	}
	
	public boolean hasPermissionFor(String operationName) {
		return authenticatedOperations.contains(operationName);
	}

	@Override
	public int compareTo(User o) {
		return this.username.compareTo(o.username);
	}

	public Set<String> getAuthenticatedOperations() {
		return authenticatedOperations;
	}
	
	public void resetExpirationDate() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getExpirationDate());
		cal.add(Calendar.MONTH, 1);
		setExpirationDate(cal.getTime());
	}
	
	public boolean canChangeFafInfoWithoutLimit() {
		for(Group g : getMemberships()) {
			if(g.canChangeFafInfoWithoutLimit()) return true;
		}
		return false;
	}
	
	public void generatePassword() {
		String pwd = "";
		Random random = new Random(System.currentTimeMillis());
		for(int i = 0; i < 7; i++) {			
			int randomInt = random.nextInt(26) + 65;
			pwd += (char) randomInt;
		}
		this.password = pwd;
		resetExpirationDate();
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String getExpirationDateFormatted() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(expirationDate);
	}
	
	public String getRemainingDaysToExpiration(){
		return String.valueOf((expirationDate.getTime() - new Date().getTime())/86400000L);
	}
	
	public boolean getCanMakeAdjustmentsOnAllDedicatedAccounts() {
		for(Group g : getMemberships()) {
			if(g.canMakeAdjustmentsOnAllDedicatedAccounts()) return true;
		}
		return false;
	}
	
	public boolean isMemberOf(String groupName) {
		for(Group g : getMemberships()) {
			if(g.getGroupName().equals(groupName)) return true;
		}
		return false;
	}
	
	public boolean isHelpDeskMember() {
		for(Group g : getMemberships()) {
			if(g.isHelpDesk()) return true;
			
		}
		return false;
	}
	
	public boolean isCorporate() {
		for(Group g : getMemberships()) {
			if(g.isCorporate()) return true;
		}
		return false;
	}
	
	public boolean isNonCorporate() {
		for(Group g : getMemberships()) {
			if(!g.isCorporate() || g.getGroupName().equals("System Admins")) return true;
		}
		return false;
	}
	
	public boolean isPostpaidCCAgent() {
		return isMemberOf("CC Agents 111");
	}
	
	public boolean isCustomerCareAgentOrShop() {
		for(Group g : getMembershipList()) {
			if(g.isCustomerCareAgentOrShop()) return true;
		}
		return false;
	}
}
