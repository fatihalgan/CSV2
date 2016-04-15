package csv.crm.complaintmng.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.End;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.service.BaseService;
import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.CorporateClient;
import csv.security.dao.ISecurityDao;
import csv.security.domain.User;

@Name("corporateClientHomeAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class CorporateClientHomeAction extends BaseService implements ICorporateClientHomeAction {

	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	private CorporateClient selectedClient;
	
	private List<User> corporateResponsibles = new ArrayList<User>();
		
	public CorporateClientHomeAction() {
		super();
	}
	
	public CorporateClient getSelectedClient() {
		return selectedClient;
	}
	
	public void setSelectedClient(CorporateClient selectedClient) {
		this.selectedClient = selectedClient;
	}
	
	public List<User> getCorporateResponsibles() {
		return corporateResponsibles;
	}

	@Begin(join=true, flushMode=FlushModeType.MANUAL)
	public void newClient() {
		selectedClient = new CorporateClient();
		corporateResponsibles = securityDao.findAllCorporateAccountManagers();
		selectedClient.setCorporateResponsible(loggedInUser);
	}
	
	@Begin(join=true, flushMode=FlushModeType.MANUAL)
	public void editClient(CorporateClient client) {
		selectedClient = client;
		corporateResponsibles = securityDao.findAllCorporateAccountManagers();
	}
	
	@End(beforeRedirect=true)
	public void saveClient() {
		try {
			compDao.saveOrUpdate(selectedClient);
			compDao.flush();
			facesMessages.add(Severity.INFO, "Corporate client saved successfully: " + selectedClient.getCompanyName());
			selectedClient = null;
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, "Corporate client could not be saved: " + e.getMessage());
		}
	}
	
	@End(beforeRedirect=false)
	public void cancel() {
		selectedClient = null;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component CorporateClientHomeAction..");
	}

}
