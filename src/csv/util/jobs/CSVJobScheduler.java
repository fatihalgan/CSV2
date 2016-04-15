package csv.util.jobs;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.log.Log;

import com.rim.blackberry.provision.service.IRIMProvisioningService;

import csv.reporting.service.IReportingService;

@Name("jobScheduler")
@Scope(ScopeType.APPLICATION)
@Startup
public class CSVJobScheduler {

	@Logger
	private Log log;
	
	@In("notificationsProcessor")
	private INotificationsProcessor notificationsProcessor;
	
	@In(value="reportingService", create=true)
	private IReportingService reportingService;
	
	@In(value="rimProvisioningService")
	private IRIMProvisioningService rimProvisioningService;
	
	public CSVJobScheduler() {
		super();
	}
	
	@Create
	public void scheduleJobs() {
		
		log.info("Scheduling Password Expiration Warning Job..");
		notificationsProcessor.processPasswordExpirationWarnings("0 35 8 * * ?");
		log.info("Scheduling Password Expired Notification Job..");
		notificationsProcessor.processPasswordExpiredNotifications("0 16 16 * * ?");
		log.info("Scheduling Daily Adjustments Report Job..");
		reportingService.processDailyAdjustmentsReport("0 50 16 * * ?");
		log.info("Scheduling Daily CSV Usage Report Job..");
		reportingService.processDailyCSVUsageReport("0 30 3 * * ?");
		log.info("Scheduling Daily EMA Operations Report Job..");
		reportingService.processDailyEMAOperationsReport("0 30 2 * * ?");
		log.info("Scheduling Open Pooled Customer Complaints Notification Job..");
		notificationsProcessor.processOpenPooledCustomerComplaintNotifications("0 0 */2 * * ?");
		log.info("Scheduling Unbar pending CallUnbarring Requests Job..");
		notificationsProcessor.processPendingCallUnbarringRequests("0 */3 * * * ?");
		//log.info("Scheduling RIM provisioning Job..");
		//rimProvisioningService.processRIMEvents("0 */5 * * * ?");
		log.info("Scheduling Level1 Open Customer Complaints Notification Job..");
		notificationsProcessor.processDueDatePassedCustomerComplaintNotificationsLevel1("0 17 6 */1 * ?");
		log.info("Scheduling Level2 Open Customer Complaints Notification Job..");
		notificationsProcessor.processDueDatePassedCustomerComplaintNotificationsLevel2("0 30 6 */1 * ?");
		log.info("Scheduling Level3 Open Customer Complaints Notification Job..");
		notificationsProcessor.processDueDatePassedCustomerComplaintNotificationsLevel3("0 45 6 */1 * ?");
		
		//log.info("Scheduling Level4 Open Customer Complaints Notification Job..");
		//notificationsProcessor.processDueDatePassedCustomerComplaintNotificationsLevel4("0 50 6 */1 * ?");
	}
	
}
