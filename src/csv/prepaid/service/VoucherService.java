package csv.prepaid.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.common.service.IDrService;
import csv.gateway.cs.AIRGateway;
import csv.gateway.cs.MINSATGateway;
import csv.gateway.cs.VSGateway;
import csv.gateway.cs.Voucher;
import csv.gateway.cs.VoucherStatus;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Adjustment;
import csv.security.domain.OperationNames;
import csv.security.domain.VoucherLog;
import csv.vouchers.dao.IVoucherDao;
import csv.vouchers.domain.VoucherAudit;
import csv.vouchers.domain.VoucherAuditTimeComparator;

@Name("voucherService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class VoucherService extends BaseService implements IVoucherService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("minsatGateway")
	private MINSATGateway minsatGateway;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	@In("voucherDao")
	private IVoucherDao voucherDao;
	
	@In("vsGateway")
	private VSGateway vsGateway;
	
	@In("airGateway")
	private AIRGateway airGateway;
	
	@In("drService")
	private IDrService drService;
	
	private Voucher voucher = new Voucher();
	
	private List<VoucherAudit> voucherHistory = new ArrayList<VoucherAudit>();
	
	private VoucherStatus newVoucherState;
	
	private String updateReason;
	
	public VoucherService() {
		super();
	}

	public CurrentServedCustomer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(CurrentServedCustomer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
	}
	
	public List<VoucherAudit> getVoucherHistory() {
		return voucherHistory;
	}
	
	public VoucherStatus getNewVoucherState() {
		return newVoucherState;
	}

	public void setNewVoucherState(VoucherStatus newVoucherState) {
		this.newVoucherState = newVoucherState;
	}
	
	public String getUpdateReason() {
		return updateReason;
	}

	public void setUpdateReason(String updateReason) {
		this.updateReason = updateReason;
	}
	
	
	@Override
	public void findVoucher() {
		try {
			this.voucher = minsatGateway.getVoucher(voucher.getSerialNumber());
			this.voucherHistory = securityDao.findVoucherHistory(voucher.getSerialNumber());
			this.voucherHistory.addAll(voucherDao.loadVouhcerHistory(voucher.getSerialNumber()));
			Collections.sort(voucherHistory, new VoucherAuditTimeComparator());
			logAccess(OperationNames.MINSATFindVoucherStatus, currentCustomer.getFullMsisdn(), voucher.getSerialNumber());
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}

	public void updateVoucherState() {
		try {
			voucher.canChangeState(newVoucherState, getMessages());
			vsGateway.updateVoucherState(voucher.getSerialNumber(), voucher.getStatus(), newVoucherState, " - Update Reason: " + updateReason);
			logAccess(OperationNames.UpdateVoucherState, currentCustomer.getFullMsisdn(), voucher.getSerialNumber() + 
				" - New State: " + newVoucherState.getLabel() + " - Success: TRUE" + updateReason);
			VoucherLog vlog = VoucherLog.getVoucherLog(loggedInUser, voucher.getSerialNumber(), voucher.getStatus(), newVoucherState, false, updateReason);
			securityDao.saveOrUpdate(vlog);
			facesMessages.add(Severity.INFO, "Voucher State successfully changed to " + newVoucherState.getLabel());
			updateReason = null;
			findVoucher();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	public void refillVoucher() {
		try {
			voucher.canChangeState(VoucherStatus.Damaged, getMessages());
			vsGateway.updateVoucherState(voucher.getSerialNumber(), voucher.getStatus(), VoucherStatus.Damaged, "CSV Voucher Refill");
			VoucherLog vlog = VoucherLog.getVoucherLog(loggedInUser, voucher.getSerialNumber(), voucher.getStatus(), newVoucherState, true, currentCustomer.getFullMsisdn(), updateReason);
			securityDao.saveOrUpdate(vlog);
			facesMessages.add(Severity.INFO, "Created voucher log..");
			Adjustment adj = new Adjustment(voucher.getSerialNumber());
			adj.setMsisdn(currentCustomer.getFullMsisdn());
			adj.setReason(updateReason);
			adj.setOwningUser(loggedInUser);
			adj.setMainAccountAdjustment(vsGateway.getNominalVoucherValue(voucher.getVoucherGroup()));
			securityDao.saveOrUpdate(adj);
			facesMessages.add(Severity.INFO, "Created adjustment log..");
			String voucherGroup = airGateway.makeRefill(adj.getId().toString(), adj.getAdjustmentDate(), currentCustomer.getMsisdn(), adj.getMainAccountAdjustment(), adj.getOwningUser().getUsername(), "CSV Voucher Refill");
			adj.setStatus(Adjustment.STATUS_SUCCESSFUL);
			facesMessages.add(Severity.INFO, "Set adjustment log status as successful..");
			logAccess(OperationNames.RefillVoucher, currentCustomer.getFullMsisdn(), voucher.getSerialNumber() + 
				" - New State: " + VoucherStatus.Damaged.getLabel() + " - Success: TRUE" + updateReason);
			facesMessages.add(Severity.INFO, "Created access log..");
			facesMessages.add(Severity.INFO, "Refill Opeation Done successfully.");
			updateReason = null;
			try {
				sendRefillSMS(adj, voucherGroup);
			} catch(Exception e) {
				logger.error("Unable to send notification SMS: ", e.getMessage());
			}
			findVoucher();
		} catch(Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR, e.getMessage());
		}
	}
	
	private void sendRefillSMS(Adjustment adj, String voucherGroup) {
		String message =  "RECARREGAMOS a sua conta com " +
		voucherGroup + ", com todos beneficios e bonus. A vida e melhor quando estamos juntos.";
		drService.createSMSMessage(adj.getMsisdn(), message, adj.getReason());
	}
	
	@Remove
	public void remove() {
		logger.debug("Destroying stateful component VoucherService...");		
	}
}

	
