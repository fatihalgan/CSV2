package csv.common.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.common.domain.FailedCall;
import csv.common.domain.IMEIRecord;
import csv.util.persistence.IBaseDao;

@Local
public interface ICDRLiveDao extends IBaseDao {
	public List<IMEIRecord> findIMEIRecordsByMsisdn(String msisdn);
	public List<FailedCall> findFailedCalls(String msisdn, Date startDate, Date endDate);
}
