package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Continent;

@Local
public interface IContinentListAction {

	public List<Continent> getContinentList();

	public void setContinentList(List<Continent> continentList);

	public Continent getSelectedContinent();

	public void setSelectedContinent(Continent selectedContinent);

	public void searchContinents();

	public void editContinent(Continent continent);

	public void newContinent();

	public void deleteContinent();

	public void saveContinent();

	public void remove();
}
