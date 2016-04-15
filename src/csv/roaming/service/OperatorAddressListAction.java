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
import csv.roaming.domain.OperatorAddress;
import csv.roaming.domain.OperatorCountry;

@Name("operatorAddressListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class OperatorAddressListAction implements IOperatorAddressListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private OperatorCountry selectedOperatorCountry;

	private List<OperatorAddress> operatorAddressList;

	private OperatorAddress selectedOperatorAddress;

	public List<OperatorAddress> getOperatorAddressList() {
		return operatorAddressList;
	}

	public void setOperatorAddressList(List<OperatorAddress> operatorAddressList) {
		this.operatorAddressList = operatorAddressList;
	}

	public OperatorAddress getSelectedOperatorAddress() {
		return selectedOperatorAddress;
	}

	public void setSelectedOperatorAddress(
			OperatorAddress selectedOperatorAddress) {
		this.selectedOperatorAddress = selectedOperatorAddress;
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component OperatorAddressListAction..");
	}

	@Observer("operatorRegion.details")
	public void searchOperatorAddress(OperatorCountry operatorCountry) {

		if (operatorCountry != null) {
			selectedOperatorCountry = operatorCountry;
		}

		operatorAddressList = roamingDao
				.findAllAddressesByOperatorCountry(selectedOperatorCountry);

	}

	public void editOperatorAddress(OperatorAddress operatorAddress) {
		selectedOperatorAddress = operatorAddress;
		logger.debug("Editing OperatorAddress: "
				+ operatorAddress.getOperatorCountry().getOperator()
						.getOperatorName() + ":"
				+ operatorAddress.getOperatorAddressId());
	}

	public void newOperatorAddress() {
		selectedOperatorAddress = new OperatorAddress();
	}

	public void deleteOperatorAddress() {
		try {
			roamingDao.delete(selectedOperatorAddress);
			roamingDao.flush();
			operatorAddressList = roamingDao
					.findAllAddressesByOperatorCountry(selectedOperatorCountry);
			selectedOperatorAddress = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while deleting Operator Address!!! "
							+ e.getMessage());
		}
	}

	public void saveOperatorAddress() {
		if (selectedOperatorCountry == null) {
			facesMessages.add("Selected Operator Region Null", new Object[] {});
			return;

		}
		try {
			selectedOperatorAddress.setOperatorCountry(selectedOperatorCountry);
			roamingDao.saveOrUpdate(selectedOperatorAddress);
			roamingDao.flush();
			operatorAddressList = roamingDao
					.findAllAddressesByOperatorCountry(selectedOperatorCountry);
			selectedOperatorAddress = null;
		} catch (Exception e) {
			logger.error(e);
			facesMessages.add(Severity.ERROR,
					"Problem occured while saving Operator Address!!! "
							+ e.getMessage());
		}
	}

}
