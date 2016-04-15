package csv.prepaid.service;

import java.util.List;

import javax.ejb.Local;

import csv.prepaid.domain.simreg.activation.Dealer;

@Local
public interface ISIMActivationService {

	public void retrieveMSISDNFromSIM();
	public void unbarSIMCard();
	public void retrieveDealers();
	public List<Dealer> getDealerList();
	public String getStorageMediumNo();
	public void setStorageMediumNo(String storageMediumNo);
	public String getStorageMediumNoEnd() ;
	public void setStorageMediumNoEnd(String storageMediumNoEnd);
	public void scheduleBalkUnbarSIMCard();
	public String getMsisdn();
	public Dealer getSelectedDealer();
	public void setSelectedDealer(Dealer selectedDealer);
	public void remove();
}
