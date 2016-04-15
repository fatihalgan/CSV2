package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remove;
import javax.ejb.Stateful;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.OperatorTariff;
import csv.roaming.domain.Service;

@Name("operatorTariffListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorTariffListAction implements IOperatorTariffListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;
	private List<OperatorTariff> operatorTariffList;
	private OperatorTariff selectedOperatorTariff;
	private OperatorCountry selectedOperatorCountry;
	private List<Service> serviceList;

	public List<OperatorTariff> getOperatorTariffList() {
		if (operatorTariffList == null) {
			operatorTariffList = new ArrayList<OperatorTariff>();
		}
		return operatorTariffList;
	}

	public void setOperatorTariffList(List<OperatorTariff> operatorTariffList) {
		this.operatorTariffList = operatorTariffList;
	}

	public OperatorTariff getSelectedOperatorTariff() {
		return selectedOperatorTariff;
	}

	public void setSelectedOperatorTariff(OperatorTariff selectedOperatorTariff) {
		this.selectedOperatorTariff = selectedOperatorTariff;
	}

	public OperatorCountry getSelectedOperatorCountry() {
		return selectedOperatorCountry;
	}

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry) {
		this.selectedOperatorCountry = selectedOperatorCountry;
	}

	public List<Service> getServiceList() {
		if (serviceList == null) {
			serviceList = new ArrayList<Service>();
		}
		return serviceList;
	}

	public void setServiceList(List<Service> serviceList) {
		this.serviceList = serviceList;
	}

	@Observer("operatorRegion.details")
	public void searchOperatorTariffs(OperatorCountry operatorCountry) {
		if (operatorCountry != null) {
			selectedOperatorCountry = operatorCountry;
			selectedOperatorTariff = null;
		}

		operatorTariffList = roamingDao
				.findAllOperatorTariffsByOperatorCountry(selectedOperatorCountry);

		serviceList = roamingDao.findAllServices();

	}

	public void editOperatorTariff(OperatorTariff operatorTariff) {
		selectedOperatorTariff = operatorTariff;
	}

	public void saveOperatorTariff() {
		if (selectedOperatorCountry == null) {
			facesMessages
					.add("Selected Operator Country Null", new Object[] {});
			return;

		}
		try {
			selectedOperatorTariff.setOperatorCountry(selectedOperatorCountry);
			roamingDao.saveOrUpdate(selectedOperatorTariff);
			roamingDao.flush();
			selectedOperatorTariff = null;
			operatorTariffList = roamingDao
					.findAllOperatorTariffsByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Tariff!!! "
							+ e.getMessage());
		}
	}

	public void deleteOperatorTariff() {
		try {
			roamingDao.delete(selectedOperatorTariff);
			roamingDao.flush();
			selectedOperatorTariff = null;
			operatorTariffList = roamingDao
					.findAllOperatorTariffsByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Operator Tariff!!! "
							+ e.getMessage());
		}
	}

	public void newOperatorTariff() {
		selectedOperatorTariff = new OperatorTariff();

	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorTariffListAction..");
	}

}
