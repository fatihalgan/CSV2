package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.MainAgreement;
import csv.roaming.domain.MainAgreementConf;

@Local
public interface IMainAgreementConfListAction {

	public List<MainAgreementConf> getMainAgreementConfList();

	public void setMainAgreementConfList(
			List<MainAgreementConf> mainAgreementConfList);

	public MainAgreementConf getSelectedMainAgreementConf();

	public void setSelectedMainAgreementConf(
			MainAgreementConf selectedMainAgreementConf);

	public void searchMainAgreementConf(MainAgreement mainAgreement);

	public void editMainAgreementConf(MainAgreementConf mainAgreementConf);

	public void newMainAgreementConf();

	public void deleteMainAgreementConf();

	public void saveMainAgreementConf();

	public void remove();
}
