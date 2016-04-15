package csv.prepaid.dao;

import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.simreg.activation.AccountAdjustment;
import csv.prepaid.domain.simreg.activation.SIMCardActivation;
import csv.util.persistence.IBaseDao;

@Local
public interface IPrepaidDao extends IBaseDao {

	public List<AccountAdjustment> findSIMActivationAdjustments(); 
	
}
