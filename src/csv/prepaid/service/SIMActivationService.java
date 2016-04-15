package csv.prepaid.service;

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
import csv.gateway.hlr.EMAGateway;
import csv.postpaid.dao.IBSCSDao;
import csv.prepaid.dao.ISIMRegistrationDao;
import csv.prepaid.domain.simreg.activation.Dealer;
import csv.prepaid.domain.simreg.activation.SIMCardActivation;

@Name("simActivationService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class SIMActivationService extends BaseService implements ISIMActivationService {

	@In("bscsDao")
	private IBSCSDao bscsDao;
	
	@In("simRegistrationDao")
	private ISIMRegistrationDao simRegDao;
	
	@In("emaGateway")
	private EMAGateway emaGateway;
	
	private String msisdn;
	
	private String storageMediumNo;
	
	private String storageMediumNoEnd;
	
	private Dealer selectedDealer;
	
	private List<Dealer> dealerList = new ArrayList<Dealer>();
	
	public SIMActivationService() {
		super();
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getStorageMediumNo() {
		return storageMediumNo;
	}

	public void setStorageMediumNo(String storageMediumNo) {
		this.storageMediumNo = storageMediumNo;
	}
	
	public String getStorageMediumNoEnd() {
		return storageMediumNoEnd;
	}

	public void setStorageMediumNoEnd(String storageMediumNoEnd) {
		this.storageMediumNoEnd = storageMediumNoEnd;
	}

	@Begin(flushMode=FlushModeType.MANUAL, join=true)
	public List<Dealer> getDealerList() {
		return dealerList;
	}
	
	public void retrieveDealers() {
		dealerList = simRegDao.findAllDealers();
	}
	
	public Dealer getSelectedDealer() {
		return selectedDealer;
	}

	public void setSelectedDealer(Dealer selectedDealer) {
		this.selectedDealer = selectedDealer;
	}

	public void retrieveMSISDNFromSIM() {
		try {
			this.msisdn = bscsDao.findMSISDNByStorageMediumNo(storageMediumNo);
			if(msisdn == null) throw new RuntimeException("MSISDN not found on BSCS..");
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	@End(beforeRedirect=false)
	public void unbarSIMCard() {
		try {
			emaGateway.unbarOutgoingServicesForProvisioning(msisdn);
			SIMCardActivation activation = new SIMCardActivation(storageMediumNo, msisdn, loggedInUser.getUsername(), selectedDealer);
			simRegDao.saveOrUpdate(activation);
			simRegDao.flush();
			resetData();
			facesMessages.add(Severity.INFO, "Successfully activated barred outgoing services for the SIM card..");
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void scheduleBalkUnbarSIMCard() {
		try {
			String result = simRegDao.scheduleBalkSIMCardUnbarring(storageMediumNo, storageMediumNoEnd, loggedInUser.getEmail());			
			facesMessages.add(Severity.INFO, result);
			resetData();
		} catch(Exception e) {
			logger.error(e.getMessage());
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	private void resetData() {
		this.storageMediumNo = null;
		this.storageMediumNoEnd = null;
		this.msisdn = null;
		this.selectedDealer = null;
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component SIMActivationService..");		
	}
	
}
