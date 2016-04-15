package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Tapcode;

@Local
public interface ITapcodeListAction {

	public List<Tapcode> getTapcodeList();

	public void setTapcodeList(List<Tapcode> tapcodeList);

	public Tapcode getSelectedTapcode();

	public void setSelectedTapcode(Tapcode selectedTapcode);

	public void remove();

	public void searchTapcodes();

	public void editTapcode(Tapcode tapcode);

	public void newTapcode();

	public void deleteTapcode();

	public void saveTapcode();

}
