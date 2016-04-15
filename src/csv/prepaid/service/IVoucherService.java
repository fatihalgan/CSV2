package csv.prepaid.service;

import java.util.List;

import javax.ejb.Local;

import csv.common.domain.CurrentServedCustomer;
import csv.gateway.cs.Voucher;
import csv.gateway.cs.VoucherStatus;
import csv.security.domain.VoucherLog;
import csv.vouchers.domain.VoucherAudit;

@Local
public interface IVoucherService {

	public CurrentServedCustomer getCurrentCustomer();
	public void setCurrentCustomer(CurrentServedCustomer currentCustomer);
	public Voucher getVoucher();
	public void setVoucher(Voucher voucher);
	public List<VoucherAudit> getVoucherHistory();
	public void findVoucher();
	public VoucherStatus getNewVoucherState();
	public void setNewVoucherState(VoucherStatus newVoucherState);
	public String getUpdateReason();
	public void setUpdateReason(String updateReason);
	public void updateVoucherState();
	public void refillVoucher();
	public void remove();
}
