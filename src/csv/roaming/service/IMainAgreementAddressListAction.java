package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementAddress;

@Local
public interface IMainAgreementAddressListAction {

	public List<MainAgreementAddress> getMainAgreementAddressList();

	public void setMainAgreementAddressList(
			List<MainAgreementAddress> mainAgreementAddressList);

	public MainAgreementAddress getSelectedMainAgreementAddress();

	public void setSelectedMainAgreementAddress(
			MainAgreementAddress selectedMainAgreementAddress);

	public void searchMainAgreementAddress(MainAgreement mainAgreement);

	public void editMainAgreementAddress(
			MainAgreementAddress mainAgreementAddress);

	public void newMainAgreementAddress();

	public void deleteMainAgreementAddress();

	public void saveMainAgreementAddress();

	public void remove();
}
