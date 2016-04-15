package csv.crm.complaintmng.service;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remove;

import csv.crm.complaintmng.domain.CorporateClient;

@Local
public interface ICorporateClientListAction {
	public CorporateClient getSearchCorporateClient();
	public void setSearchCorporateClient(CorporateClient searchCorporateClient);
	public List<CorporateClient> getCorporateClientList();
	public void retrieveAllCorporateClients();
	public void setCorporateClientList(List<CorporateClient> corporateClientList);
	public void initSearchCorporateClient();
	public boolean getSearchWithinMyClients();
	public void setSearchWithinMyClients(boolean searchWithinMyClients);
	public void searchMyCorporateClients();
	public void deleteClient(CorporateClient client);
	public void resetSearch();
	public void remove();
}
