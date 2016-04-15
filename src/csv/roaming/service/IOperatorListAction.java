package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Operator;

@Local
public interface IOperatorListAction {

	public String getOperatorName();

	public void setOperatorName(String operatorName);

	public List<Operator> getOperatorList();

	public void setOperatorList(List<Operator> operatorList);

	public Operator getSelectedOperator();

	public void setSelectedOperator(Operator selectedOperator);

	public void searchOperator();

	public void editOperator(Operator operator);

	public void newOperator();

	public void deleteOperator();

	public void saveOperator();

	public void searchOperatorsByName();

	public void remove();

	public void searchDetails(Operator operator);

}
