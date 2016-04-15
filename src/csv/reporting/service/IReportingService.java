package csv.reporting.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.IntervalCron;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.document.DocumentData;

import csv.security.domain.AccessLog;
import csv.security.domain.Adjustment;
import csv.security.domain.EMALog;
import csv.security.domain.Group;
import csv.security.domain.SMSLog;
import csv.security.domain.User;

@Local
public interface IReportingService {

	public void initialize();
	public List<AccessLog> getUserAuditHistory();
	public void retrieveUserAuditHistory(User selectedUser);
	public void retrieveDailyAdjustments();
	public void retrieveDailyCSVUsage();
	public void retrieveDailyEMAOperations();
	public void retrievePostpaidCallViewOperations();
	public void retrievePostpaidInvoiceViewOperations();
	public void retrieveOperationsLog();
	public void retrieveSMSLog();
	@Asynchronous
	public QuartzTriggerHandle processDailyAdjustmentsReport(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processDailyCSVUsageReport(@IntervalCron String cron);
	@Asynchronous
	public QuartzTriggerHandle processDailyEMAOperationsReport(@IntervalCron String cron);
	public Map<User, List<Adjustment>> getDailyAdjustments();
	public Map<Group, Map<User, List<AccessLog>>> getAccessLogMap();
	public Map<User, List<AccessLog>> getPostpaidCallViewMap();
	public Map<User, List<AccessLog>> getPostpaidInvoiceViewMap();
	public List<EMALog> getEmaOperations();
	public List<AccessLog> getOperationsLog();
	public List<SMSLog> getSmsLog();
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public DocumentData getReportFileData();
	public void remove();
}
