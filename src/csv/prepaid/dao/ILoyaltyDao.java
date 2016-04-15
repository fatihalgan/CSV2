package csv.prepaid.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.LoyaltyTransaction;
import csv.util.persistence.IBaseDao;

@Local
public interface ILoyaltyDao extends IBaseDao {

	public BigDecimal findLoyaltyPoints(String msisdn);
	public List<LoyaltyTransaction> findLoyaltyHistory(String msisdn, Date startDate, Date endDate);
	public Long spendLoyaltyPoints(String msisdn, Integer pointsToSpend, Long originTransId);
}
