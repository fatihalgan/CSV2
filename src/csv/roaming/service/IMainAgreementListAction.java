package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.MainAgreement;

@Local
public interface IMainAgreementListAction {

	public String getAgreementName();

	public void setAgreementName(String agreementName);

	public List<MainAgreement> getMainAgreementList();

	public void setMainAgreementList(List<MainAgreement> mainAgreementList);

	public MainAgreement getSelectedMainAgreement();

	public void setSelectedMainAgreement(MainAgreement selectedMainAgreement);

	public void searchMainAgreement();

	public void editMainAgreement(MainAgreement mainAgreement);

	public void newMainAgreement();

	public void deleteMainAgreement();

	public void saveMainAgreement();

	public void searchDetails(MainAgreement mainAgreement);

	public void searchMainAgreementsByName();

	public void remove();
}
