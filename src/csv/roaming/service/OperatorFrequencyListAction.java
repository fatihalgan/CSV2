package csv.roaming.service;

import java.io.Serializable;
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
import csv.roaming.domain.OperatorFrequency;

@Name("operatorFrequencyListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorFrequencyListAction implements
		IOperatorFrequencyListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private OperatorCountry selectedOperatorCountry;

	private List<OperatorFrequency> operatorFrequencyList;

	private OperatorFrequency selectedOperatorFrequency;

	public List<OperatorFrequency> getOperatorFrequencyList() {
		return operatorFrequencyList;
	}

	public void setOperatorFrequencyList(
			List<OperatorFrequency> operatorFrequencyList) {
		this.operatorFrequencyList = operatorFrequencyList;
	}

	public OperatorFrequency getSelectedOperatorFrequency() {
		return selectedOperatorFrequency;
	}

	public void setSelectedOperatorFrequency(
			OperatorFrequency selectedOperatorFrequency) {
		this.selectedOperatorFrequency = selectedOperatorFrequency;
	}

	@Remove
	public void remove() {
		logger
				.debug("Removing Stateful Component OperatorFrequencyListAction..");
	}

	@Observer("operatorRegion.details")
	public void searchOperatorFrequency(OperatorCountry operatorRegion) {
		if (operatorRegion != null) {
			selectedOperatorCountry = operatorRegion;
		}

		operatorFrequencyList = roamingDao
				.findAllFrequenciesByOperatorCountry(selectedOperatorCountry);

	}

	public void editOperatorFrequency(OperatorFrequency operatorFrequency) {
		selectedOperatorFrequency = operatorFrequency;
		logger.debug("Editing OperatorFrequency: "
				+ operatorFrequency.getOperatorCountry().getOperator()
						.getOperatorName() + ":"
				+ operatorFrequency.getOperatorFrequencyId());
	}

	public void newOperatorFrequency() {
		selectedOperatorFrequency = new OperatorFrequency();
	}

	public void deleteOperatorFrequency() {
		try {
			roamingDao.delete(selectedOperatorFrequency);
			roamingDao.flush();
			selectedOperatorFrequency = null;
			operatorFrequencyList = roamingDao
					.findAllFrequenciesByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Operator Frequency!!! "
							+ e.getMessage());
		}
	}

	public void saveOperatorFrequency() {
		if (selectedOperatorCountry == null) {
			facesMessages.add("Selected Operator Region Null", new Object[] {});
			return;

		}
		try {
			selectedOperatorFrequency
					.setOperatorCountry(selectedOperatorCountry);
			roamingDao.saveOrUpdate(selectedOperatorFrequency);
			roamingDao.flush();
			selectedOperatorFrequency = null;
			operatorFrequencyList = roamingDao
					.findAllFrequenciesByOperatorCountry(selectedOperatorCountry);
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Frequency!!! "
							+ e.getMessage());
		}
	}

}
