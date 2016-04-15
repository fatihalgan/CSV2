package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.faces.convert.Converter;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.faces.converters.ServiceListShuttleConverter;
import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.OperatorService;
import csv.roaming.domain.RoamingService;

@Name("operatorServiceListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorServiceListAction implements IOperatorServiceListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private OperatorCountry selectedOperatorCountry;

	private List<RoamingService> unselectedServices;

	private List<RoamingService> selectedServices;

	private List<OperatorService> operatorServiceList;

	public OperatorCountry getSelectedOperatorCountry() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		this.selectedOperatorCountry = selectedOperatorCountry;
	}

	public List<RoamingService> getUnselectedServices() {
		if (unselectedServices == null) {
			return new ArrayList<RoamingService>();
		}
		return unselectedServices;
	}

	public void setUnselectedServices(List<RoamingService> unselectedServices) {
		this.unselectedServices = unselectedServices;
	}

	public List<RoamingService> getSelectedServices() {
		if (selectedServices == null) {
			return new ArrayList<RoamingService>();
		}
		return selectedServices;
	}

	public void setSelectedServices(List<RoamingService> selectedServices) {
		this.selectedServices = selectedServices;
	}

	public List<OperatorService> getOperatorServiceList() {
		return operatorServiceList;
	}

	public void setOperatorServiceList(List<OperatorService> operatorServiceList) {
		this.operatorServiceList = operatorServiceList;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorServiceListAction..");
	}

	@Observer("operatorRegion.details")
	public void searchOperatorService(OperatorCountry operatorCountry) {

		logger
				.info("Searching OperatorService for Operator Region!!!!!!!!!!!!!");
		selectedOperatorCountry = operatorCountry;
		if (selectedOperatorCountry == null) {
			facesMessages.add("You have to select an Operator Region first");
			return;
		}
		selectedOperatorCountry = operatorCountry;

		List<RoamingService> roamingServices = roamingDao
				.findAllRoamingServices();

		selectedServices = roamingDao
				.findAllRoamingServicesByOperatorCountry(selectedOperatorCountry);

		operatorServiceList = roamingDao
				.findAllOperatorServicesByOperatorCountry(selectedOperatorCountry);

		if (roamingServices == null) {
			return;
		}

		roamingServices.removeAll(selectedServices);
		unselectedServices = roamingServices;
	}

	public void saveOperatorServices() {

		if (operatorServiceList == null) {
			operatorServiceList = new ArrayList<OperatorService>();
		}
		try {
			for (Iterator iterator = unselectedServices.iterator(); iterator
					.hasNext();) {
				boolean isIn = false;
				OperatorService deletedOperatorService = new OperatorService();
				RoamingService roamingService = (RoamingService) iterator
						.next();
				for (Iterator iterator2 = operatorServiceList.iterator(); iterator2
						.hasNext();) {
					OperatorService operatorService = (OperatorService) iterator2
							.next();
					if (operatorService.getRoamingService()
							.getRoamingServiceId() == roamingService
							.getRoamingServiceId()) {
						roamingDao.delete(operatorService);
						deletedOperatorService = operatorService;
						isIn = true;
					}
				}
				if (isIn) {
					operatorServiceList.remove(deletedOperatorService);
				}

			}

			for (Iterator iterator = selectedServices.iterator(); iterator
					.hasNext();) {
				RoamingService roamingService = (RoamingService) iterator
						.next();
				boolean isIn = false;

				for (Iterator iterator2 = operatorServiceList.iterator(); iterator2
						.hasNext();) {
					OperatorService operatorService = (OperatorService) iterator2
							.next();
					if (operatorService.getRoamingService()
							.getRoamingServiceId() == roamingService
							.getRoamingServiceId()) {
						isIn = true;

					}
				}
				if (!isIn) {
					OperatorService newOperatorService = new OperatorService();
					newOperatorService
							.setOperatorCountry(selectedOperatorCountry);
					newOperatorService.setRoamingService(roamingService);
					operatorServiceList.add(newOperatorService);
				}
			}

			for (Iterator iterator = operatorServiceList.iterator(); iterator
					.hasNext();) {
				OperatorService operatorService = (OperatorService) iterator
						.next();
				roamingDao.saveOrUpdate(operatorService);

			}
			roamingDao.flush();
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Services!!! "
							+ e.getMessage());
		}

	}

	public Converter getServiceListShuttleConverter() {
		return new ServiceListShuttleConverter(getUnselectedServices(),
				getSelectedServices());
	}

}
