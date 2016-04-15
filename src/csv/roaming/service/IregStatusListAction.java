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
import csv.roaming.domain.IregStatus;

@Name("iregStatusListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class IregStatusListAction implements IIregStatusListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<IregStatus> iregStatusList;

	private IregStatus selectedIregStatus;

	public List<IregStatus> getIregStatusList() {
		return iregStatusList;
	}

	public void setIregStatusList(List<IregStatus> iregStatusList) {
		this.iregStatusList = iregStatusList;
	}

	public IregStatus getSelectedIregStatus() {
		return selectedIregStatus;
	}

	public void setSelectedIregStatus(IregStatus selectedIregStatus) {
		this.selectedIregStatus = selectedIregStatus;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component IregStatusListAction..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchIregStatus() {
		iregStatusList = roamingDao.findAllIregStatuses();

	}

	public void editIregStatus(IregStatus iregStatus) {
		selectedIregStatus = iregStatus;
		logger.debug("Editing IregStatus: " + iregStatus.getDescription());
	}

	public void newIregStatus() {
		selectedIregStatus = new IregStatus();
	}

	public void deleteIregStatus() {
		try {
			roamingDao.delete(selectedIregStatus);
			roamingDao.flush();
			iregStatusList = null;
			selectedIregStatus = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Ireg Status!!! "
							+ e.getMessage());
		}
	}

	public void saveIregStatus() {
		try {
			roamingDao.saveOrUpdate(selectedIregStatus);
			roamingDao.flush();
			iregStatusList = null;
			selectedIregStatus = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Ireg Status!!! "
							+ e.getMessage());
		}
	}

}
