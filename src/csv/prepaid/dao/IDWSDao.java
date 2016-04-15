package csv.prepaid.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.history.AbstractAccountEvent;
import csv.prepaid.domain.history.Account;
import csv.prepaid.domain.history.CashAccountChangeInfo;
import csv.prepaid.domain.history.FaFEntry;
import csv.prepaid.domain.history.LifeCycleChangeInfo;
import csv.util.persistence.IBaseDao;

@Local
public interface IDWSDao extends IBaseDao {
	public Account findAccountByMsisdn(String msisdn);
	public List<AbstractAccountEvent> retrieveAccountHistory(Long subscriberId, Long accountId, Date startDate, Date endDate);
	public List<CashAccountChangeInfo> retrieveCashAccountChanges(Long eventId);
	public List<LifeCycleChangeInfo> retrieveLifeCycleInfoChanges(Long eventId);
	public List<FaFEntry> retrieveFaFHistory(Long subscriberId, Date startDate, Date endDate);
}
