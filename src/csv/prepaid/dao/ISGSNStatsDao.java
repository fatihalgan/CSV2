package csv.prepaid.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.prepaid.netmovel.domain.SGSNDataUsage;
import csv.util.persistence.IBaseDao;

@Local
public interface ISGSNStatsDao extends IBaseDao{

	public List<SGSNDataUsage> findSGSNDataUsage(String msisdn, Date after);
}
