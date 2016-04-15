package csv.prepaid.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import co.mcel.mz.bb4p.service.exception.EmaException;

import csv.common.service.BaseService;
import csv.gateway.hlr.EMAGateway;
import csv.prepaid.dao.ISIMRegistrationDao;
import csv.prepaid.domain.simreg.CallUnbarLog;
import csv.prepaid.domain.simreg.CallUnbarStatus;

@Name("callBarringService")
@Stateless
public class CallBarringService implements ICallBarringService {

	@Logger
	private Log logger;
	
	@In("simRegistrationDao")
	private ISIMRegistrationDao simRegDao;
	
	@In("emaGateway")
	private EMAGateway emaGateway;

	@Override
	public boolean unbarSubscriber(CallUnbarLog callUnbarLog) {
		try {
			callUnbarLog.setUpdateDate(new Date());
			emaGateway.unbarOutgoingServicesForProvisioning("258" + callUnbarLog.getMsisdn());
			callUnbarLog.setStatus(CallUnbarStatus.UnbarCompleted);
			callUnbarLog.setEmaResponse(0);
			simRegDao.update(callUnbarLog);
			return true;
		} catch(EmaException ee) {
			callUnbarLog.setEmaResponse(ee.getResultCode());
			simRegDao.update(callUnbarLog);
		} catch(Exception e) {
			logger.error("Could not unbar MSISDN ", callUnbarLog.getMsisdn() + ": " + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean barSubscriber(CallUnbarLog callUnbarLog) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unbarPendingUnbarRequests() {
		List<CallUnbarLog> requests = simRegDao.findCallUnbarLogsByStatus(CallUnbarStatus.UnbarRequested);
		for(CallUnbarLog request : requests) {
			boolean result = unbarSubscriber(request);
		}
	}
}
