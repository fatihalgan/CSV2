package csv.common.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.common.domain.FailedCall;
import csv.common.domain.IMEIRecord;
import csv.common.domain.PUKInfo;
import csv.common.domain.Province;

@Local
public interface ICommonOperationsService {

	public void initialize();
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public Date getEndDate();
	public void setEndDate(Date endDate);
	public void retrieveIMEIRecords();
	public void retrieveFailedCalls();
	public void retrievePUKInfo();
	public List<IMEIRecord> getImeiRecords();
	public List<FailedCall> getFailedCalls();
	public PUKInfo getPukInfo();
	public List<Province> retrieveProvinces();
	public void remove();
}
