package csv.dr.dao;

import java.util.List;

import javax.ejb.Local;

import csv.util.persistence.IBaseDao;

@Local
public interface IDrDao extends IBaseDao {

	public List<String> createInvoicePdf(long customerId, String period);
}
