package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Continent;

@Local
public interface IRoamingTestListAction {

	public List<Continent> getContinentList();

	public void setContinentList(List<Continent> continentList);

	public void searchContinentList();

	public void clearContinentList();

	public void remove();
}
