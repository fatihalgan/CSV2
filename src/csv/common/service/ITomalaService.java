package csv.common.service;

import java.util.List;

import javax.ejb.Local;

import csv.common.domain.TomalaBlacklist;
import csv.common.domain.TomalaBlockingStatus;
import csv.common.domain.TomalaTransaction;

@Local
public interface ITomalaService {

	public void retrieveTomalaBlockingStatus();
	public void retrieveBlacklistingDetail();
	public TomalaBlockingStatus getTomalaBlockingStatus();
	public TomalaBlacklist getBlackListInfo();
	public void setBlackListInfo(TomalaBlacklist blackListInfo);
	public List<TomalaTransaction> getTomalaTransactions();
	public void retrieveTomalaTransactions();
	public String getStatusUpdateReason();
	public void setStatusUpdateReason(String statusUpdateReason);
	public void blockTomala();
	public void unblockTomala();
	public void remove();
}
