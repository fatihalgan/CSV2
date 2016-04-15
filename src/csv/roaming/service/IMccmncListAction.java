package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Mccmnc;

@Local
public interface IMccmncListAction {

	public List<Mccmnc> getMccmncList();

	public void setMccmncList(List<Mccmnc> mccmncList);

	public Mccmnc getSelectedMccmnc();

	public void setSelectedMccmnc(Mccmnc selectedMccmnc);

	public void remove();

	public void searchMccmncs();

	public void editMccmnc(Mccmnc mccmnc);

	public void newMccmnc();

	public void deleteMccmnc();

	public void saveMccmnc();
}
