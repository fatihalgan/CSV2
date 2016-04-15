package csv.vouchers.dao;

import java.util.List;

import javax.ejb.Local;

import csv.util.persistence.IBaseDao;
import csv.vouchers.domain.VoucherAudit;

@Local
public interface IVoucherDao extends IBaseDao {

	public List<VoucherAudit> loadVouhcerHistory(String serialNum);
	
}
