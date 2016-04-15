package csv.crm.complaintmng.service;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.CorporateClient;
import csv.crm.complaintmng.domain.OpenComplaint;
import csv.security.domain.User;

@Name("corporateResponsibleResolver")
public class CorporateResponsibleResolver {

	@In(value="complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	@In(scope=ScopeType.BUSINESS_PROCESS, required=true)
	private OpenComplaint openComplaint;
	
	@In(value="loggedInUser")
	protected User loggedInUser;
	
	public String resolveCorporateResponsible() {
		CorporateClient client = (CorporateClient)compDao.load(CorporateClient.class, openComplaint.getCustomerCode());
		return client.getCorporateResponsible().getUsername();
	}
	
	public boolean getInitiatorIsCorporateResponsible() {
		String corporateResponsible = resolveCorporateResponsible();
		if(loggedInUser == null) return false;
		if(loggedInUser.getUsername().equals(corporateResponsible)) return true;
		return false;
	}
	
}
