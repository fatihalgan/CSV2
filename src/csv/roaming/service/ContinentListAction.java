package csv.roaming.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.FlushModeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.Continent;

@Name("continentListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class ContinentListAction implements IContinentListAction, Serializable {

	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Continent> continentList;

	private Continent selectedContinent;

	public Continent getSelectedContinent() {
		return selectedContinent;
	}

	public void setSelectedContinent(Continent selectedContinent) {
		this.selectedContinent = selectedContinent;
	}

	public void setContinentList(List<Continent> continentList) {
		this.continentList = continentList;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component ParameterListAction..");
	}

	public List<Continent> getContinentList() {
		return continentList;
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchContinents() {
		continentList = roamingDao.findAllContinents();

	}

	public void editContinent(Continent continent) {
		selectedContinent = continent;
		logger.debug("Editing Continent: " + selectedContinent.getName());
	}

	public void newContinent() {
		selectedContinent = new Continent();
	}

	public void deleteContinent() {

		try {
			roamingDao.delete(selectedContinent);
			roamingDao.flush();
			continentList = null;
			selectedContinent = null;

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting continent!!! "
							+ e.getMessage());
		}
	}

	public void saveContinent() {
		try {
			roamingDao.saveOrUpdate(selectedContinent);
			roamingDao.flush();
			selectedContinent = null;
			continentList = null;

		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving continent!!! "
							+ e.getMessage());
		}

	}

}
