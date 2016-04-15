package csv.prepaid.service;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

import co.mcel.mz.types.common.MsisdnType;

import com.bridge.simreg.wstypes.AuthenticationEntityType;
import com.bridge.simreg.wstypes.OperationResultType;

import csv.common.domain.CurrentServedCustomer;
import csv.common.service.BaseService;
import csv.util.soap.AxisClientConfigurator;

@Name("SimRegistrationService")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class SimRegistrationService extends BaseService implements ISimRegistrationService {

	@In("currentServedCustomer")
	private CurrentServedCustomer currentCustomer;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisConfigurator;
	
	public SimRegistrationService() {
		super();	
	}

	@Override
	public boolean isSubscriberRegistered() {
		try {
			MsisdnType msisdn = new MsisdnType();
			msisdn.setInternationalPrefix(currentCustomer.getPrefix());
			msisdn.setNumber(currentCustomer.getMsisdn());
			OperationResultType responseType = axisConfigurator.getSimRegistrationServiceStub().checkRegistrationStatus(msisdn, getAuthenticationEntityType());
			if(responseType.getReturnCode().intValue() == 0) return true;
			return false;
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	private AuthenticationEntityType getAuthenticationEntityType() {
		AuthenticationEntityType type = new AuthenticationEntityType();
		type.setClientId("PAPERSOFT");
		type.setSaveUser("PAP_USER01");
		type.setPassword("PAP_USER01_PWD");
		return type;
	}

	@Remove
	public void remove() {
		logger.debug("Removing component SimRegistration Service..");				
	}

}
