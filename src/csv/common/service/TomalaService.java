package csv.common.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.dao.ITomalaDao;
import csv.common.domain.CurrentServedCustomer;
import csv.common.domain.TomalaBlacklist;
import csv.common.domain.TomalaBlockingStatus;
import csv.common.domain.TomalaTransaction;
import csv.security.domain.OperationNames;

@Name("tomalaService")
@Stateful
@Scope(ScopeType.CONVERSATION)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TomalaService extends BaseService implements ITomalaService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("tomalaDao")
	private ITomalaDao tomalaDao;
	
	private TomalaBlockingStatus tomalaBlockingStatus;
	
	private TomalaBlacklist blackListInfo;
	
	private List<TomalaTransaction> tomalaTransactions;
	
	private String statusUpdateReason;
	
	public TomalaService() {
		super();
	}
	
	public TomalaBlockingStatus getTomalaBlockingStatus() {
		return tomalaBlockingStatus;
	}
	
	public TomalaBlacklist getBlackListInfo() {
		return blackListInfo;
	}

	public void setBlackListInfo(TomalaBlacklist blackListInfo) {
		this.blackListInfo = blackListInfo;
	}
	
	public List<TomalaTransaction> getTomalaTransactions() {
		return tomalaTransactions;
	}
	
	public String getStatusUpdateReason() {
		return statusUpdateReason;
	}

	public void setStatusUpdateReason(String statusUpdateReason) {
		this.statusUpdateReason = statusUpdateReason;
	}

	@Override
	public void retrieveTomalaBlockingStatus() {
		try {
			this.tomalaBlockingStatus = tomalaDao.findTomalaBlockingStatus(currentCustomer.getMsisdn());
			retrieveBlacklistingDetail();
			logAccess(OperationNames.RetrieveTomalaStatus, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot retrieve Tomala Blocking Status: " + e.getMessage());
		}
	}
	
	@Override
	public void retrieveBlacklistingDetail() {
		try {
			this.blackListInfo = tomalaDao.findBlacklistingInfo(currentCustomer.getMsisdn());
			logAccess(OperationNames.RetrieveTomalaStatus, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot retrieve Tomala Blocking Information Detail: " + e.getMessage());
		}
		
	}
	
	@Override
	public void retrieveTomalaTransactions() {
		try {
			tomalaTransactions = tomalaDao.findTomalaTransactions(currentCustomer.getMsisdn());
			logAccess(OperationNames.FindTomalaTransactions, currentCustomer.getFullMsisdn(), "");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot retrieve Tomala transactions: " + e.getMessage());
		}
	}
	
	public void blockTomala() {
		try {
			if(tomalaBlockingStatus.equals(TomalaBlockingStatus.Blocked)) throw new RuntimeException("Subscriber is already blocked from doing Tomala");
			TomalaBlacklist bl = new TomalaBlacklist();
			bl.setDate(new Date());
			bl.setMsisdn(currentCustomer.getMsisdn());
			bl.setReason(statusUpdateReason);
			bl.setUserName(loggedInUser.getUsername());
			tomalaDao.saveOrUpdate(bl);
			logAccess(OperationNames.BlockTomala, currentCustomer.getFullMsisdn(), statusUpdateReason);
			facesMessages.add(Severity.INFO, "Subscriber is successfully blocked for Tomala..");
			retrieveTomalaBlockingStatus();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot Block Tomala: " + e.getMessage());
		}
	}
	
	public void unblockTomala() {
		try {
			if(tomalaBlockingStatus.equals(TomalaBlockingStatus.Available)) throw new RuntimeException("Subscriber is already unblocked from doing Tomala");
			TomalaBlacklist bl = tomalaDao.findBlacklistingInfo(currentCustomer.getMsisdn());
			tomalaDao.delete(bl);
			tomalaDao.flush();
			logAccess(OperationNames.UnBlockTomala, currentCustomer.getFullMsisdn(), statusUpdateReason);
			tomalaBlockingStatus = TomalaBlockingStatus.Available;
			blackListInfo = null;
			facesMessages.add(Severity.INFO, "Tomala blocking removed successfully..");
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, "Cannot Unblock Tomala: " + e.getMessage());
		}
	}
	
	@Remove
	public void remove() {
		logger.debug("Removing stateful component Tomala Service..");
	}

	

	

}
