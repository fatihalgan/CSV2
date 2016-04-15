package csv.reporting.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.document.DocumentData;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.common.domain.CurrentServedCustomer;
import csv.security.dao.ISecurityDao;
import csv.security.domain.AccessLog;
import csv.security.domain.Adjustment;
import csv.security.domain.EMALog;
import csv.security.domain.Group;
import csv.security.domain.OperationNames;
import csv.security.domain.SMSLog;
import csv.security.domain.User;

@Name("reportingService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class ReportingService implements IReportingService {

	@Logger
	protected Log logger;
	
	@In(required=false)
	protected User loggedInUser;
	
	@In("securityDao")
	protected ISecurityDao securityDao;
	
	@In
	protected FacesMessages facesMessages;
	
	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In
	private Renderer renderer;
	
	private List<AccessLog> userAuditHistory = new ArrayList<AccessLog>();
	
	private Map<User, List<Adjustment>> dailyAdjustments = new HashMap<User, List<Adjustment>>();
	
	private Map<Group, Map<User,List<AccessLog>>> accessLogMap = new TreeMap<Group, Map<User,List<AccessLog>>>();
	
	private List<EMALog> emaOperations;
	
	private Map<User, List<AccessLog>> postpaidCallViewMap = new HashMap<User, List<AccessLog>>();
	
	private Map<User, List<AccessLog>> postpaidInvoiceViewMap = new HashMap<User, List<AccessLog>>();
	
	private List<AccessLog> operationsLog = new ArrayList<AccessLog>();
	
	private List<SMSLog> smsLog = new ArrayList<SMSLog>();
	
	private Date startDate;
	
	private DocumentData reportFileData;
	
	public ReportingService() {
		super();
	}
	
	@PostConstruct
	public void initialize() {
		Date endDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, -1);
		startDate = new Date();
		startDate.setTime(cal.getTimeInMillis());
	}
	
	public List<AccessLog> getUserAuditHistory() {
		return userAuditHistory;
	}
	
	public Map<User, List<Adjustment>> getDailyAdjustments() {
		return dailyAdjustments;
	}
	
	public Map<Group, Map<User, List<AccessLog>>> getAccessLogMap() {
		return accessLogMap;
	}
	
	public List<EMALog> getEmaOperations() {
		return emaOperations;
	}
	
	public Map<User, List<AccessLog>> getPostpaidCallViewMap() {
		return postpaidCallViewMap;
	}
	
	public Map<User, List<AccessLog>> getPostpaidInvoiceViewMap() {
		return postpaidInvoiceViewMap;
	}
	
	public List<AccessLog> getOperationsLog() {
		return operationsLog;
	}
	
	public List<SMSLog> getSmsLog() {
		return smsLog;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public DocumentData getReportFileData() {
		return reportFileData;
	}

	public void retrieveUserAuditHistory(User selectedUser) {
		try {
			userAuditHistory = securityDao.findAccessLogEventsByUser(selectedUser.getUsername());
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve audit history of user " + selectedUser.getUsername() + ": " + e.getMessage());
		}
	}
	
	private void loadDailyAdjustmentsData() throws Exception {
		List<Adjustment> adjustmentsDoneAtThatDate = securityDao.findAdjustmentsOfDay(startDate);
		for(Adjustment adjustment : adjustmentsDoneAtThatDate) {
			User currentUser = adjustment.getOwningUser();
			if(dailyAdjustments.get(currentUser) == null) {
				dailyAdjustments.put(currentUser, new ArrayList<Adjustment>());
			}
			List<Adjustment> currentUserAdjustments = dailyAdjustments.get(currentUser);
			currentUserAdjustments.add(adjustment);
		}
	}
	
	private void loadCSVUsageData() throws Exception {
		List<AccessLog> accessLogEntries = securityDao.findAccessLogEventsAtDate(startDate);
    	for(AccessLog log : accessLogEntries) {
    		User user = log.getOwningUser();
    		for(Group group : user.getMemberships()) {
    			Map<User, List<AccessLog>> groupAccessLog = getGroupAccessLogMap(group);
    			List<AccessLog> userAccessLog = getUserAccessLogs(groupAccessLog, user);
    			userAccessLog.add(log);
    		}
    	}
	}
	
	private void loadEMAOperaitonsData() throws Exception {
		emaOperations = securityDao.findEMAOperationsOfDay(startDate);
	}
	
	private Map<User, List<AccessLog>> getGroupAccessLogMap(Group group) {
		if(!accessLogMap.containsKey(group)) {
			accessLogMap.put(group, new TreeMap<User, List<AccessLog>>());
		}
		return accessLogMap.get(group);
	}
	
	private List<AccessLog> getUserAccessLogs(Map<User, List<AccessLog>> accessLogs, User user) {
		if(!accessLogs.containsKey(user)) {
			accessLogs.put(user, new ArrayList<AccessLog>());
		}
		return accessLogs.get(user);
	}
	
	public void retrieveDailyAdjustments() {
		try {
			loadDailyAdjustmentsData();
	        facesMessages.add(Severity.INFO, "Report produced successfully..");
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve adjustment history: " + e.getMessage());
		}
	}
	
	public void retrieveDailyCSVUsage() {
		try {
			loadCSVUsageData();
			facesMessages.add(Severity.INFO, "Report produced successfully..");
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve CSV Usage history: " + e.getMessage());
		}
	}
	
	public void retrieveDailyEMAOperations() {
		try {
			loadEMAOperaitonsData();
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve EMA Operations history: " + e.getMessage());
		}
	}
	
	public void retrievePostpaidCallViewOperations() {
		try {
			List<AccessLog> callsView = securityDao.findAccessLogEventsOfOperationAfter(OperationNames.PostpaidCallView, startDate); 
			for(AccessLog entry : callsView) {
				User currentUser = entry.getOwningUser();
				if(postpaidCallViewMap.get(currentUser) == null) {
					postpaidCallViewMap.put(currentUser, new ArrayList<AccessLog>());
				}
				List<AccessLog> currentUserCallViews = postpaidCallViewMap.get(currentUser);
				currentUserCallViews.add(entry);	
			}
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve Postpaid Call View Operations history: " + e.getMessage());
		}
	}
	
	public void retrievePostpaidInvoiceViewOperations() {
		try {
			List<AccessLog> invoicesView = securityDao.findAccessLogEventsOfOperationAfter(OperationNames.PostpaidFindInvoiceDetail, startDate); 
			for(AccessLog entry : invoicesView) {
				User currentUser = entry.getOwningUser();
				if(postpaidInvoiceViewMap.get(currentUser) == null) {
					postpaidInvoiceViewMap.put(currentUser, new ArrayList<AccessLog>());
				}
				List<AccessLog> currentUserInvoiceViews = postpaidInvoiceViewMap.get(currentUser);
				currentUserInvoiceViews.add(entry);	
			}
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve Postpaid Invoice View Operations history: " + e.getMessage());
		}
	}
	
	public void retrieveOperationsLog() {
		try {
			if(currentCustomer.getFullMsisdn() == null) {
				facesMessages.add(Severity.ERROR, "Please first start a new Customer Session to get this report..");
				return;
			}
			operationsLog = securityDao.findAccessLogEventsBySubscriber(currentCustomer.getFullMsisdn(), startDate);
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve Operations history of subscriber: " + e.getMessage());
		}
	}
	
	public void retrieveSMSLog() {
		try {
			if(currentCustomer.getFullMsisdn() == null) {
				facesMessages.add(Severity.ERROR, "Please first start a new Customer Session to get this report..");
				return;
			}
			smsLog = securityDao.findSMSHistoryAfter(currentCustomer.getFullMsisdn(), startDate);
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Could not retrieve history of subscriber: " + e.getMessage());
		}
	}
	
	@Override
	public QuartzTriggerHandle processDailyAdjustmentsReport(String cron) {
		try {
			loadDailyAdjustmentsData();
			renderer.render("/reports/mail_daily_adjustments.xhtml");
		} catch(Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	@Override
	public QuartzTriggerHandle processDailyCSVUsageReport(String cron) {
		try {
			loadCSVUsageData();
			renderer.render("/reports/mail_daily_csv_usage.xhtml");
		} catch(Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	public QuartzTriggerHandle processDailyEMAOperationsReport(String cron) {
		try {
			loadEMAOperaitonsData();
			renderer.render("/reports/mail_daily_ema_operations.xhtml");
		} catch(Exception e) {
			logger.error(e);
		}
		return null;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component Reporting Service..");
	}

	
}
