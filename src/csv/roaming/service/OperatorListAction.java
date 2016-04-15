package csv.roaming.service;

import java.io.Serializable;
import java.util.ArrayList;
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
import org.jboss.seam.core.Events;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.Operator;

@Name("operatorListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorListAction implements IOperatorListAction, Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Operator> operatorList;

	private Operator selectedOperator;

	private String operatorName = "";

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public List<Operator> getOperatorList() {
		if (operatorList == null) {
			operatorList = new ArrayList<Operator>();
		}
		return operatorList;
	}

	public void setOperatorList(List<Operator> operatorList) {
		this.operatorList = operatorList;
	}

	public Operator getSelectedOperator() {
		return selectedOperator;
	}

	public void setSelectedOperator(Operator selectedOperator) {
		this.selectedOperator = selectedOperator;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorListAction..");
	}

	@Begin(flushMode = FlushModeType.MANUAL, join = true)
	public void searchOperator() {
		operatorList = roamingDao.findAllOperators();
	}

	public void searchOperatorsByName() {
		operatorList = roamingDao.findAllOperatorsByName(operatorName);

	}

	public void editOperator(Operator operator) {
		selectedOperator = operator;
		logger.debug("Editing Operator: " + operator.getOperatorName());
	}

	public void newOperator() {
		selectedOperator = new Operator();
	}

	public void deleteOperator() {
		try {
			roamingDao.delete(selectedOperator);
			roamingDao.flush();
			operatorList = null;
			selectedOperator = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Operator!!! "
							+ e.getMessage());
		}
	}

	public void saveOperator() {
		try {
			roamingDao.saveOrUpdate(selectedOperator);
			roamingDao.flush();
			operatorList = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator!!! "
							+ e.getMessage());
		}
	}

	public void searchDetails(Operator operator) {
		if (operator == null) {
			facesMessages.add("You have to select an operator first!!!");
			return;
		}
		Events.instance().raiseEvent("operator.details", operator);

	}

}
