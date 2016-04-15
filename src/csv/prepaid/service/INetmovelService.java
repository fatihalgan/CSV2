package csv.prepaid.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.bridge.netmovel.BalanceEnquiryResponse;

import csv.prepaid.netmovel.domain.BundleActivation;
import csv.prepaid.netmovel.domain.BundleName;
import csv.prepaid.netmovel.domain.DuoActivation;
import csv.prepaid.netmovel.domain.ResultCode;
import csv.prepaid.netmovel.domain.SGSNDataUsage;
import csv.prepaid.netmovel.domain.VoiceAddOnActivation;

@Local
public interface INetmovelService {
	public List<BundleActivation> getBundleActivations();
	public List<DuoActivation> getDuoActivations();
	public List<VoiceAddOnActivation> getVoiceAddOnActivations();
	public Date getStartDate();
	public void setStartDate(Date startDate);
	public BundleName getSelectedBundle();
	public List<SGSNDataUsage> getCdrHistory();
	public void setSelectedBundle(BundleName selectedBundle);
	public Integer getContractValue();
	public void setContractValue(Integer contractValue);
	public BalanceEnquiryResponse getCurrentBundleStatus();
	public void findNetmovelBundleActivations();
	public void findNetmovelDuoActivations();
	public void findVoiceAddOnActivations();
	public void findCDRHistory();
	public void checkBalance();
	public void terminateBundle();
	public void extendBundle();
	public void activateBundle();
	public void activateVoiceAddOnBundle();
	public void activateNTDuo();
	public void deactivateNTDuo();
	public ResultCode getOperationResult();
	public boolean isNetDuoAvailable();
	public boolean isNetmovelPrepagoAvailable();
	public boolean isVoiceAddOnAvailable();
	public void remove();
}
