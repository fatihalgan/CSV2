package csv.common.dao;

import java.util.List;

import javax.ejb.Local;

import csv.common.domain.TomalaBlacklist;
import csv.common.domain.TomalaBlockingStatus;
import csv.common.domain.TomalaTransaction;
import csv.util.persistence.IBaseDao;

@Local
public interface ITomalaDao extends IBaseDao {
	public TomalaBlockingStatus findTomalaBlockingStatus(String msisdn);
	public TomalaBlacklist findBlacklistingInfo(String msisdn);
	public List<TomalaTransaction> findTomalaTransactions(String msisdn);
}
