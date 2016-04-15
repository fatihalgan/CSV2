package csv.prepaid.service;

import javax.ejb.Local;

import com.bridge.pm.bpm.PrepaidToPostpaidMigrationRequestState;
import com.bridge.pm.domain.ActiveProvisioning;

@Local
public interface IPostpaidMigrationService {
	public PrepaidToPostpaidMigrationRequestState getSimMigrationState();
	public void setSimMigrationState(PrepaidToPostpaidMigrationRequestState simMigrationState);
	public boolean isSubscriberValidated();
	public void loadProvisioningInfo();
	public ActiveProvisioning getActiveProvisioning();
	public void initiateMigrationProcess();
	public void attendMigrationRequest();
	public String passRiskAnalysis();
	public String rejectRiskAnalysis() ;
	public void remove();
}
