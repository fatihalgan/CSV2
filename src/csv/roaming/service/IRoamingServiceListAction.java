package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.RoamingService;

@Local
public interface IRoamingServiceListAction {

	public List<RoamingService> getRoamingServiceList();

	public void setRoamingServiceList(List<RoamingService> roamingServiceList);

	public RoamingService getSelectedRoamingService();

	public void setSelectedRoamingService(RoamingService selectedRoamingService);

	public void searchRoamingService();

	public void editRoamingService(RoamingService roamingService);

	public void newRoamingService();

	public void deleteRoamingService();

	public void saveRoamingService();
	
	public void remove();
}
