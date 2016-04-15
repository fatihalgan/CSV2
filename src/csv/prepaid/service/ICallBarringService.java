package csv.prepaid.service;

import javax.ejb.Local;

import csv.prepaid.domain.simreg.CallUnbarLog;

@Local
public interface ICallBarringService {
	public boolean unbarSubscriber(CallUnbarLog callUnbarLog);
	public boolean barSubscriber(CallUnbarLog callUnbarLog);
	public void unbarPendingUnbarRequests();
}
