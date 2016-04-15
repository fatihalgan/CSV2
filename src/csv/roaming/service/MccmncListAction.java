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
import csv.roaming.domain.Mccmnc;

@Name("mccmncListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class MccmncListAction implements IMccmncListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Mccmnc> mccmncList;

	private Mccmnc selectedMccmnc;

	public List<Mccmnc> getMccmncList() {
		return mccmncList;
	}

	public void setMccmncList(List<Mccmnc> mccmncList) {
		this.mccmncList = mccmncList;
	}

	public Mccmnc getSelectedMccmnc() {
		return selectedMccmnc;
	}

	public void setSelectedMccmnc(Mccmnc selectedMccmnc) {
		this.selectedMccmnc = selectedMccmnc;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component Mccmnc List Action..");
	}
	
	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchMccmncs() {
		System.out.println("Searching Mccmnc List!!!!!!!!!!!!!");
		mccmncList = roamingDao.findAllMccmncies();

	}

	public void editMccmnc(Mccmnc mccmnc) {
		selectedMccmnc = mccmnc;
		logger.debug("Editing Mccmnc: " + mccmnc.getMccmnc());
	}

	public void newMccmnc() {
		selectedMccmnc = new Mccmnc();
	}

	public void deleteMccmnc() {
		try {
			roamingDao.delete(selectedMccmnc);
			roamingDao.flush();
			mccmncList = null;
			selectedMccmnc = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting MCCMNC!!! "
							+ e.getMessage());
		}
	}

	public void saveMccmnc() {
		try {
			roamingDao.saveOrUpdate(selectedMccmnc);
			roamingDao.flush();
			mccmncList = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving MCCMNC!!! " + e.getMessage());
		}
	}

}
