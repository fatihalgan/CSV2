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
import csv.roaming.domain.TadigStatus;

@Name("tadigStatusListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class TadigStatusListAction implements ITadigStatusListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<TadigStatus> tadigStatusList;

	private TadigStatus selectedTadigStatus;

	public List<TadigStatus> getTadigStatusList() {
		return tadigStatusList;
	}

	public void setTadigStatusList(List<TadigStatus> TadigStatusList) {
		this.tadigStatusList = TadigStatusList;
	}

	public TadigStatus getSelectedTadigStatus() {
		return selectedTadigStatus;
	}

	public void setSelectedTadigStatus(TadigStatus selectedTadigStatus) {
		this.selectedTadigStatus = selectedTadigStatus;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component TadigStatusListAction..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchTadigStatus() {
		tadigStatusList = roamingDao.findAllTadigStatuses();

	}

	public void editTadigStatus(TadigStatus TadigStatus) {
		selectedTadigStatus = TadigStatus;
		logger.debug("Editing TadigStatus: " + TadigStatus.getDescription());
	}

	public void newTadigStatus() {
		selectedTadigStatus = new TadigStatus();
	}

	public void deleteTadigStatus() {
		try {
			roamingDao.delete(selectedTadigStatus);
			roamingDao.flush();
			tadigStatusList = null;
			selectedTadigStatus = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Tadig Status!!! "
							+ e.getMessage());
		}
	}

	public void saveTadigStatus() {
		try {
			roamingDao.saveOrUpdate(selectedTadigStatus);
			roamingDao.flush();
			tadigStatusList = null;
			selectedTadigStatus = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Tadig Status!!! "
							+ e.getMessage());
		}
	}

}
