package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.IregStatus;

@Local
public interface IIregStatusListAction {

	public List<IregStatus> getIregStatusList();

	public void setIregStatusList(List<IregStatus> IregStatusList);

	public IregStatus getSelectedIregStatus();

	public void setSelectedIregStatus(IregStatus selectedIregStatus);

	public void searchIregStatus();

	public void editIregStatus(IregStatus IregStatus);

	public void newIregStatus();

	public void deleteIregStatus();

	public void saveIregStatus();

	public void remove();

}
