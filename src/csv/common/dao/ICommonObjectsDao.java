package csv.common.dao;

import java.util.List;

import javax.ejb.Local;

import csv.common.domain.Province;
import csv.util.persistence.IBaseDao;

@Local
public interface ICommonObjectsDao extends IBaseDao {

	public List<Province> getAllProvinces();
	
}
