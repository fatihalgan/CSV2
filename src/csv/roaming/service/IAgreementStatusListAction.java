package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.AgreementStatus;

@Local
public interface IAgreementStatusListAction {

	public List<AgreementStatus> getAgreementStatusList();

	public void setAgreementStatusList(List<AgreementStatus> agreementStatusList);

	public AgreementStatus getSelectedAgreementStatus();

	public void setSelectedAgreementStatus(
			AgreementStatus selectedAgreementStatus);

	public void searchAgreementStatus();

	public void editAgreementStatus(AgreementStatus agreementStatus);

	public void newAgreementStatus();

	public void deleteAgreementStatus();

	public void saveAgreementStatus();

	public void remove();
}
