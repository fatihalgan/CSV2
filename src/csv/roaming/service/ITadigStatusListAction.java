package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.TadigStatus;

@Local
public interface ITadigStatusListAction {

	public List<TadigStatus> getTadigStatusList();

	public void setTadigStatusList(List<TadigStatus> tadigStatusList);

	public TadigStatus getSelectedTadigStatus();

	public void setSelectedTadigStatus(TadigStatus selectedTadigStatus);

	public void searchTadigStatus();

	public void editTadigStatus(TadigStatus tadigStatus);

	public void newTadigStatus();

	public void deleteTadigStatus();

	public void saveTadigStatus();

	public void remove();
}
