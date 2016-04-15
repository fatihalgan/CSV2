package csv.prepaid.service;

import javax.ejb.Local;

import com.bridge.pm.domain.ActiveProvisioning;
import com.bridge.pm.domain.SwapInfo;

import csv.common.domain.CurrentServedCustomer;

@Local
public interface ISIMSwapService {

	public CurrentServedCustomer getCurrentCustomer();
	public void setCurrentCustomer(CurrentServedCustomer currentCustomer);
	public ActiveProvisioning getActiveProvisioning();
	public void loadProvisioningInfo();
	public SwapInfo getSwapInfo();
	public void setSwapInfo(SwapInfo swapInfo);
	public boolean isSubscriberValidated();
	public Long getRequestId();
	public void requestSimSwap();
	public void remove();
}
