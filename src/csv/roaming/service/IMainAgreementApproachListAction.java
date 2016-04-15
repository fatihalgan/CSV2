package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementApproach;

@Local
public interface IMainAgreementApproachListAction {

	public List<MainAgreementApproach> getMainAgreementApproachList();

	public void setMainAgreementApproachList(
			List<MainAgreementApproach> mainAgreementApproachList);

	public MainAgreementApproach getSelectedMainAgreementApproach();

	public void setSelectedMainAgreementApproach(
			MainAgreementApproach selectedMainAgreementApproach);

	public void searchMainAgreementApproach(MainAgreement mainAgreement);

	public void editMainAgreementApproach(
			MainAgreementApproach mainAgreementApproach);

	public void newMainAgreementApproach();

	public void deleteMainAgreementApproach();

	public void saveMainAgreementApproach();

	public void remove();
}
