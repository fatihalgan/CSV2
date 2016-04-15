package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.OperatorFrequency;

@Local
public interface IOperatorFrequencyListAction {

	public List<OperatorFrequency> getOperatorFrequencyList();

	public void setOperatorFrequencyList(
			List<OperatorFrequency> operatorFrequencyList);

	public OperatorFrequency getSelectedOperatorFrequency();

	public void setSelectedOperatorFrequency(
			OperatorFrequency selectedOperatorFrequency);

	public void searchOperatorFrequency(OperatorCountry operatorCountry);

	public void editOperatorFrequency(OperatorFrequency operatorFrequency);

	public void newOperatorFrequency();

	public void deleteOperatorFrequency();

	public void saveOperatorFrequency();

	public void remove();
}
