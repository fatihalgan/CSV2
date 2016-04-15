package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.OperatorAddress;
import csv.roaming.domain.OperatorCountry;

@Local
public interface IOperatorAddressListAction {

	public List<OperatorAddress> getOperatorAddressList();

	public void setOperatorAddressList(List<OperatorAddress> operatorAddressList);

	public OperatorAddress getSelectedOperatorAddress();

	public void setSelectedOperatorAddress(
			OperatorAddress selectedOperatorAddress);

	public void searchOperatorAddress(OperatorCountry operatorCountry);

	public void editOperatorAddress(OperatorAddress operatorAddress);

	public void newOperatorAddress();

	public void deleteOperatorAddress();

	public void saveOperatorAddress();

	public void remove();
}
