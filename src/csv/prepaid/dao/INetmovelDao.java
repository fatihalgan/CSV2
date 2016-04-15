package csv.prepaid.dao;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import csv.prepaid.netmovel.domain.BundleActivation;
import csv.prepaid.netmovel.domain.DuoActivation;
import csv.prepaid.netmovel.domain.VoiceAddOnActivation;
import csv.util.persistence.IBaseDao;

@Local
public interface INetmovelDao extends IBaseDao{

	public List<BundleActivation> findBundleActivations(String msisdn, Date startDate);
	public List<DuoActivation> findDuoActivations(String msisdn, Date startDate);
	public List<VoiceAddOnActivation> findVoiceAddOnActivations(String msisdn, Date startDate);
}
