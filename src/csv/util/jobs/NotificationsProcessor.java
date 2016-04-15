package csv.util.jobs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.IntervalCron;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.prepaid.service.ICallBarringService;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.GroupType;
import csv.security.domain.User;

@Name("notificationsProcessor")
@Stateful
@Scope(ScopeType.EVENT)
@AutoCreate
public class NotificationsProcessor implements INotificationsProcessor {

	@Logger
	private Log log;
	
	@In
	private Renderer renderer;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In(value="callBarringService", create=true)
	private ICallBarringService callBarringService;
	
	private List<User> expiringUsers = new ArrayList<User>();
	private List<User> alreadyExpiredUsers = new ArrayList<User>();
	
	private List<TaskInstance> openPooledTaskInstances = new ArrayList<TaskInstance>();
	
	private List<User> groupSupervisors = new ArrayList<User>();
	
	private int daysPassedSinceDueDate = 0;
	
	
	public NotificationsProcessor() {
		super();
	}

	public List<User> getExpiringUsers() {
		return expiringUsers;
	}
	
	public List<User> getAlreadyExpiredUsers() {
		return alreadyExpiredUsers;
	}
	
	public List<TaskInstance> getOpenPooledTaskInstances() {
		return openPooledTaskInstances;
	}
	
	public List<User> getGroupSupervisors() {
		return groupSupervisors;
	}
	
	public int getDaysPassedSinceDueDate() {
		return daysPassedSinceDueDate;
	}

	@Asynchronous
	public QuartzTriggerHandle processPasswordExpirationWarnings(@IntervalCron String cron) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			expiringUsers = securityDao.findExpiringUsers(5, false);
			log.debug("Will send password expiration warnings to " + expiringUsers.size() + " users..");
			renderer.render("/jobs/password_expiring.xhtml");
			expiringUsers = new ArrayList<User>();
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	@Asynchronous
	public QuartzTriggerHandle processPasswordExpiredNotifications(@IntervalCron String cron) {
		try {
			alreadyExpiredUsers = securityDao.findExpiringUsers(0, true);
			log.debug("Will send password expired notifications for " + alreadyExpiredUsers.size() + " users..");
			renderer.render("/jobs/password_expired.xhtml");
			alreadyExpiredUsers = new ArrayList<User>();
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	@Asynchronous
	public QuartzTriggerHandle processOpenPooledCustomerComplaintNotifications(@IntervalCron String cron) {
		try {
			log.info("Executing processOpenPooledCustomerComplaintNotifications..");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.HOUR_OF_DAY, -2);
			Date createTime = cal.getTime();
			List<Group> allGroups = securityDao.findAllGroups();
			for(Group g : allGroups) {
				try {
					String groupActorId = g.getGroupName();
					openPooledTaskInstances = compDao.findUnassignedPooledTaskInstancesByGroupActors(Arrays.asList(groupActorId), createTime);
					log.info("Found " + openPooledTaskInstances.size() + " unassigned Task Instances for notification to group supervisors..");
					if(openPooledTaskInstances.size() == 0) continue; 
					groupSupervisors = g.getGroupSupervisors();
					log.debug("Will send unassigned pooled task notifications for " + groupSupervisors.size() + " users..");
					renderer.render("/jobs/unassigned_pooledtask_warning.xhtml");
				} catch(Exception e) {
					log.error(e);
				}
			}
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	@Asynchronous
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel1(@IntervalCron String cron) {
		try {
			log.info("Executing processDueDatePassedCustomerComplaintNotifications Level 1..");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH, -1);
			Date createTime = cal.getTime();
			daysPassedSinceDueDate = 1;
			List<Group> allGroups = securityDao.findGroupByUserGroupType(GroupType.DEPARTMENT_LEADER);
			for(Group g : allGroups) {
				try {
					groupSupervisors = new ArrayList<User>();
					User[] users = g.getUsersInGroup().toArray(new User[g.getUsersInGroup().size()]);
					groupSupervisors.addAll(Arrays.asList(users));
					List<String> groupActors = securityDao.getRecursiveChildGroupNames(g);
					openPooledTaskInstances = compDao.findPooledTaskInstancesByGroupActors(groupActors, createTime);
					log.info("Found " + openPooledTaskInstances.size() + " open Task Instances for escalation..");
					if(openPooledTaskInstances.size() == 0) continue;
					log.debug("Will send level 1 escalation notifications for " + g.getGroupName());
					renderer.render("/jobs/open_complaints_escalation_warning.xhtml");
				} catch(Exception e) {
					log.error(e);
				}
			}
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel2(@IntervalCron String cron) {
		try {
			log.info("Executing processDueDatePassedCustomerComplaintNotifications Level 2..");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH, -2);
			Date createTime = cal.getTime();
			daysPassedSinceDueDate = 2;
			List<Group> allGroups = securityDao.findGroupByUserGroupType(GroupType.DIRECTOR);
			for(Group g : allGroups) {
				try {
					groupSupervisors = new ArrayList<User>();
					User[] users = g.getUsersInGroup().toArray(new User[g.getUsersInGroup().size()]);
					groupSupervisors.addAll(Arrays.asList(users));
					List<String> groupActors = securityDao.getRecursiveChildGroupNames(g);
					openPooledTaskInstances = compDao.findPooledTaskInstancesByGroupActors(groupActors, createTime);
					log.info("Found " + openPooledTaskInstances.size() + " open Task Instances for escalation..");
					if(openPooledTaskInstances.size() == 0) continue;
					log.debug("Will send level 2 escalation notifications for " + g.getGroupName());
					renderer.render("/jobs/open_complaints_escalation_warning.xhtml");
				} catch(Exception e) {
					log.error(e);
				}
			}
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel3(@IntervalCron String cron) {
		try {
			log.info("Executing processDueDatePassedCustomerComplaintNotifications Level 3..");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH, -3);
			Date createTime = cal.getTime();
			daysPassedSinceDueDate = 3;
			List<Group> allGroups = securityDao.findGroupByUserGroupType(new GroupType[] {GroupType.CMO, GroupType.CTO, GroupType.CFO});
			for(Group g : allGroups) {
				try {
					groupSupervisors = new ArrayList<User>();
					User[] users = g.getUsersInGroup().toArray(new User[g.getUsersInGroup().size()]);
					groupSupervisors.addAll(Arrays.asList(users));
					List<String> groupActors = securityDao.getRecursiveChildGroupNames(g);
					openPooledTaskInstances = compDao.findPooledTaskInstancesByGroupActors(groupActors, createTime);
					log.info("Found " + openPooledTaskInstances.size() + " open Task Instances for escalation..");
					if(openPooledTaskInstances.size() == 0) continue;
					log.debug("Will send level 3 escalation notifications for " + g.getGroupName());
					renderer.render("/jobs/open_complaints_escalation_warning.xhtml");
				} catch(Exception e) {
					log.error(e);
				}
			}
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	/**
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel4(@IntervalCron String cron) {
		try {
			log.info("Executing processDueDatePassedCustomerComplaintNotifications Level 4..");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(Calendar.DAY_OF_MONTH, -4);
			Date createTime = cal.getTime();
			daysPassedSinceDueDate = 4;
			List<Group> allGroups = securityDao.findGroupByUserGroupType(new GroupType[] {GroupType.CEO});
			for(Group g : allGroups) {
				try {
					groupSupervisors = new ArrayList<User>();
					User[] users = g.getUsersInGroup().toArray(new User[g.getUsersInGroup().size()]);
					groupSupervisors.addAll(Arrays.asList(users));
					List<String> groupActors = securityDao.getRecursiveChildGroupNames(g);
					openPooledTaskInstances = compDao.findPooledTaskInstancesByGroupActors(groupActors, createTime);
					log.info("Found " + openPooledTaskInstances.size() + " open Task Instances for escalation..");
					if(openPooledTaskInstances.size() == 0) continue;
					log.debug("Will send level 4 escalation notifications for " + g.getGroupName());
					renderer.render("/jobs/open_complaints_escalation_warning.xhtml");
				} catch(Exception e) {
					log.error(e);
				}
			}
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	**/
	
	
	@Asynchronous
	public QuartzTriggerHandle processPendingCallUnbarringRequests(@IntervalCron String cron) {
		try {
			callBarringService.unbarPendingUnbarRequests();
		} catch(Exception e) {
			log.error(e);
		}
		return null;
	}
	
	
	@Remove
	public void remove() {
		log.debug("Removing stateful component Notifications processor..");
	}
}
