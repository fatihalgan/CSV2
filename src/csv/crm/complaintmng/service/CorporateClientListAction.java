package csv.crm.complaintmng.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.service.BaseService;
import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.CorporateClient;

@Name("corporateClientListAction")
@Stateful
@Scope(ScopeType.EVENT)
@AutoCreate
public class CorporateClientListAction extends BaseService implements ICorporateClientListAction {

	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In(scope=ScopeType.PAGE, required=false)
	@Out(scope=ScopeType.PAGE, required=false)
	private CorporateClient searchCorporateClient = null;
	
	@DataModel(value="corporateClientList", scope=ScopeType.PAGE)
	private List<CorporateClient> corporateClientList = null;
	
	private boolean searchWithinMyClients = true;
	
	@Factory(autoCreate=true, value="searchCorporateClient")
	public void initSearchCorporateClient() {
		searchCorporateClient = new CorporateClient();
	}
	
	public boolean getSearchWithinMyClients() {
		return searchWithinMyClients;
	}

	public void setSearchWithinMyClients(boolean searchWithinMyClients) {
		this.searchWithinMyClients = searchWithinMyClients;
	}

	@Override
	public void searchMyCorporateClients() {
		try {
			Long userId = null;
			if(searchWithinMyClients) userId = loggedInUser.getId();
			corporateClientList = compDao.findCorporateClientsByExample(searchCorporateClient, userId);
			if(corporateClientList.size() == 0) facesMessages.add(Severity.WARN, "No recrords found..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Error in searching Corporate Clients: " + e.getMessage());
		}
	}
	
	public void deleteClient(CorporateClient client) {
		try {
			compDao.attach(client);
			compDao.delete(client);
			facesMessages.add(Severity.INFO, "Successfully Deleted: " + client.getCompanyName());
			corporateClientList.remove(client);
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not delete record: " + e.getMessage());
		}
	}
	
	public void retrieveAllCorporateClients() {
		try {
			corporateClientList = compDao.findAllCorporateClients();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Could not retrieve corporate clients: " + e.getMessage());
		}
	}
	
	public void resetSearch() {
		searchCorporateClient = new CorporateClient();
		corporateClientList = null;
		
	}
	
	public CorporateClient getSearchCorporateClient() {
		return searchCorporateClient;
	}

	public void setSearchCorporateClient(CorporateClient searchCorporateClient) {
		this.searchCorporateClient = searchCorporateClient;
	}

	public List<CorporateClient> getCorporateClientList() {
		return corporateClientList;
	}

	public void setCorporateClientList(List<CorporateClient> corporateClientList) {
		this.corporateClientList = corporateClientList;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component CorporateClientListAction..");
	}
		
}
