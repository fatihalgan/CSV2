package csv.crm.complaintmng.service;

import java.util.List;

import javax.ejb.Local;

import csv.crm.complaintmng.domain.CorporateClient;
import csv.security.domain.User;

@Local
public interface ICorporateClientHomeAction {

	public CorporateClient getSelectedClient();
	public void setSelectedClient(CorporateClient selectedClient);
	public List<User> getCorporateResponsibles();
	public void newClient();
	public void editClient(CorporateClient client);
	public void saveClient();
	public void cancel();
	public void remove();
}
