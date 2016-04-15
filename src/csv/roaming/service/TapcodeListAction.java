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
import csv.roaming.domain.Tapcode;

@Name("tapcodeListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class TapcodeListAction implements ITapcodeListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Tapcode> tapcodeList;

	private Tapcode selectedTapcode;

	public List<Tapcode> getTapcodeList() {
		return tapcodeList;
	}

	public void setTapcodeList(List<Tapcode> tapcodeList) {
		this.tapcodeList = tapcodeList;
	}

	public Tapcode getSelectedTapcode() {
		return selectedTapcode;
	}

	public void setSelectedTapcode(Tapcode selectedTapcode) {
		this.selectedTapcode = selectedTapcode;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component Tapcode List Action..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchTapcodes() {
		logger.debug("Searching Tapcode list!!!!!!!!!!!!!");
		tapcodeList = roamingDao.findAllTapCodes();

	}

	public void editTapcode(Tapcode tapcode) {
		selectedTapcode = tapcode;
		logger.debug("Editing Tapcode: " + tapcode.getTapcode());
	}

	public void newTapcode() {
		selectedTapcode = new Tapcode();
	}

	public void deleteTapcode() {
		try {
			roamingDao.delete(selectedTapcode);
			roamingDao.flush();
			tapcodeList = null;
			selectedTapcode = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Tapcode!!! "
							+ e.getMessage());
		}
	}

	public void saveTapcode() {
		try {
			roamingDao.saveOrUpdate(selectedTapcode);
			roamingDao.flush();
			tapcodeList = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages
					.add(Severity.ERROR,
							"Problem occured while saving Tapcode!!! "
									+ e.getMessage());
		}
	}

}
