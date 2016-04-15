package csv.util.jobs;

import java.util.List;

import javax.ejb.Local;

import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.IntervalCron;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.security.domain.User;



@Local
public interface INotificationsProcessor {
	public List<User> getExpiringUsers();
	public List<User> getAlreadyExpiredUsers();
	public List<TaskInstance> getOpenPooledTaskInstances();
	public List<User> getGroupSupervisors();
	public int getDaysPassedSinceDueDate();
	@Asynchronous
	public QuartzTriggerHandle processPasswordExpirationWarnings(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processPasswordExpiredNotifications(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processOpenPooledCustomerComplaintNotifications(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processPendingCallUnbarringRequests(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel1(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel2(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel3(@IntervalCron String cron); 
	//@Asynchronous
	//public QuartzTriggerHandle processDueDatePassedCustomerComplaintNotificationsLevel4(@IntervalCron String cron);
	public void remove();
}
