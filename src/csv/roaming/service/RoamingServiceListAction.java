package csv.roaming.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.RoamingService;

@Name("roamingServiceListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class RoamingServiceListAction implements IRoamingServiceListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<RoamingService> roamingServiceList;

	private RoamingService selectedRoamingService;

	public List<RoamingService> getRoamingServiceList() {
		return roamingServiceList;
	}

	public void setRoamingServiceList(List<RoamingService> roamingServiceList) {
		this.roamingServiceList = roamingServiceList;
	}

	public RoamingService getSelectedRoamingService() {
		return selectedRoamingService;
	}

	public void setSelectedRoamingService(RoamingService selectedRoamingService) {
		this.selectedRoamingService = selectedRoamingService;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component RoamingServiceListAction..");
	}

	public void searchRoamingService() {
		roamingServiceList = roamingDao.findAllRoamingServices();

	}

	public void editRoamingService(RoamingService roamingService) {
		selectedRoamingService = roamingService;
		logger.debug("Editing Roaming Service: "
				+ roamingService.getRoamingServiceName());
	}

	public void newRoamingService() {
		selectedRoamingService = new RoamingService();
	}

	public void deleteRoamingService() {
		try {
			roamingDao.delete(selectedRoamingService);
			roamingDao.flush();
			roamingServiceList = null;
			selectedRoamingService = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Roaming Service!!! "
							+ e.getMessage());
		}
	}

	public void saveRoamingService() {
		try {
			roamingDao.saveOrUpdate(selectedRoamingService);
			roamingDao.flush();
			roamingServiceList = null;
			selectedRoamingService = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Roaming Service!!! "
							+ e.getMessage());
		}
	}

}
