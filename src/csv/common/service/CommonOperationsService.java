package csv.common.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import csv.common.dao.ICDRLiveDao;
import csv.common.dao.ICommonObjectsDao;
import csv.common.domain.CurrentServedCustomer;
import csv.common.domain.FailedCall;
import csv.common.domain.IMEIRecord;
import csv.common.domain.PUKInfo;
import csv.common.domain.Province;
import csv.postpaid.dao.IBSCSDao;
import csv.security.domain.OperationNames;

@Name("commonOperationsService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CommonOperationsService extends BaseService implements ICommonOperationsService {
	
	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("cdrliveDao")
	private ICDRLiveDao cdrliveDao;
	
	@In("bscsDao")
	private IBSCSDao bscsDao;
	
	@In("commonObjectsDao")
	private ICommonObjectsDao commonObjectsDao;
	
	private Date startDate;
	private Date endDate;
	
	private List<IMEIRecord> imeiRecords = null;
	private List<FailedCall> failedCalls = null;
	
	private PUKInfo pukInfo = null;
	
	public CommonOperationsService() {
		super();
	}
	
	@PostConstruct
	public void initialize() {
		endDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(endDate);
		cal.add(Calendar.DATE, -3);
		startDate = new Date();
		startDate.setTime(cal.getTimeInMillis());
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<IMEIRecord> getImeiRecords() {
		return imeiRecords;
	}

	public void setImeiRecords(List<IMEIRecord> imeiRecords) {
		this.imeiRecords = imeiRecords;
	}
	
	public void setFailedCalls(List<FailedCall> failedCalls) {
		this.failedCalls = failedCalls;
	}
	
	@Override
	public List<FailedCall> getFailedCalls() {
		return failedCalls;
	}
	
	public PUKInfo getPukInfo() {
		return pukInfo;
	}

	public void setPukInfo(PUKInfo pukInfo) {
		this.pukInfo = pukInfo;
	}

	public void retrieveIMEIRecords() {
		try {
			setImeiRecords(cdrliveDao.findIMEIRecordsByMsisdn(currentCustomer.getMsisdn()));
			logAccess(OperationNames.FindIMEI, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(e.getMessage());
		}
	}
	
	public void retrieveFailedCalls() {
		try {
			setFailedCalls(cdrliveDao.findFailedCalls(currentCustomer.getMsisdn(), startDate, endDate));
			if(failedCalls.size() == 0) facesMessages.add("No records found for this subscriber..");
			logAccess(OperationNames.FindFailedCalls, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(e.getMessage());
		}
	}
	
	public void retrievePUKInfo() {
		try {
			setPukInfo(bscsDao.findPUKInfo(currentCustomer.getFullMsisdn()));
			logAccess(OperationNames.ViewPUK, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(e.getMessage());
		}
	}
	
	public List<Province> retrieveProvinces() {
		return commonObjectsDao.getAllProvinces();
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing component CommonOperationsService");
	}

	
}
