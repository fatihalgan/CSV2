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
import csv.roaming.domain.Operator;
import csv.roaming.domain.OperatorPrefix;

@Name("operatorPrefixListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorPrefixListAction implements IOperatorPrefixListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private Operator selectedOperator;

	private List<OperatorPrefix> operatorPrefixList;

	private OperatorPrefix selectedOperatorPrefix;

	private boolean intervalFrameShowed = false;

	private int intervalFirst = 0;
	private int intervalLast = 0;

	public boolean isIntervalFrameShowed() {
		return intervalFrameShowed;
	}

	public void setIntervalFrameShowed(boolean intervalFrameShowed) {
		this.intervalFrameShowed = intervalFrameShowed;
	}

	public int getIntervalFirst() {
		return intervalFirst;
	}

	public void setIntervalFirst(int intervalFirst) {
		this.intervalFirst = intervalFirst;
	}

	public int getIntervalLast() {
		return intervalLast;
	}

	public void setIntervalLast(int intervalLast) {
		this.intervalLast = intervalLast;
	}

	public Operator getSelectedOperator() {
		return selectedOperator;
	}

	public void setSelectedOperator(Operator selectedOperator) {
		this.selectedOperator = selectedOperator;
	}

	public List<OperatorPrefix> getOperatorPrefixList() {
		if (operatorPrefixList == null) {
			return new ArrayList<OperatorPrefix>();
		}
		return operatorPrefixList;
	}

	public void setOperatorPrefixList(List<OperatorPrefix> operatorPrefixList) {
		this.operatorPrefixList = operatorPrefixList;
	}

	public OperatorPrefix getSelectedOperatorPrefix() {
		return selectedOperatorPrefix;
	}

	public void setSelectedOperatorPrefix(OperatorPrefix selectedOperatorPrefix) {
		this.selectedOperatorPrefix = selectedOperatorPrefix;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorPrefixListAction..");
	}

	@Observer("operator.details")
	public void searchOperatorPrefix(Operator operator) {
		if (operator != null) {
			selectedOperator = operator;
		}

		operatorPrefixList = roamingDao
				.findAllPrefixesByOperator(selectedOperator);

	}

	public void editOperatorPrefix(OperatorPrefix operatorPrefix) {
		selectedOperatorPrefix = operatorPrefix;
		logger.debug("Editing OperatorPrefix: "
				+ operatorPrefix.getOperator().getOperatorName() + ":"
				+ operatorPrefix.getOperatorPrefixId());
	}

	public void newOperatorPrefix() {
		selectedOperatorPrefix = new OperatorPrefix();
	}

	public void deleteOperatorPrefix() {
		try {

			roamingDao.delete(selectedOperatorPrefix);
			roamingDao.flush();
			operatorPrefixList = null;
			selectedOperatorPrefix = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Operator Prefix!!! "
							+ e.getMessage());
		}
	}

	public void saveOperatorPrefix() {
		if (selectedOperator == null) {
			facesMessages.add("Selected Operator Null", new Object[] {});
			return;

		}
		try {

			selectedOperatorPrefix.setOperator(selectedOperator);
			roamingDao.saveOrUpdate(selectedOperatorPrefix);
			roamingDao.flush();
			operatorPrefixList = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Prefix!!! "
							+ e.getMessage());
		}
	}

	public void showIntervalFrame() {
		intervalFrameShowed = true;
	}

	public void createOperatorPrefixesInterval() {
		if (intervalFirst < 0 || intervalLast < 0
				|| intervalFirst >= intervalLast) {
			facesMessages.add("First and Last Value are not valid");
			return;
		}
		if (selectedOperator == null) {
			facesMessages.add("You have to select an operator first",
					new Object[] {});
			return;

		}

		try {
			for (int i = intervalFirst; i <= intervalLast; i++) {
				OperatorPrefix prefix = new OperatorPrefix();
				prefix.setOperator(selectedOperator);
				prefix.setPrefix("" + i);
				roamingDao.save(prefix);
			}

			roamingDao.flush();

			operatorPrefixList = roamingDao
					.findAllPrefixesByOperator(selectedOperator);
			intervalFrameShowed = false;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Prefixes!!! "
							+ e.getMessage());
		}

	}
}
