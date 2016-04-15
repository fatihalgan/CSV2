package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.Operator;
import csv.roaming.domain.OperatorPrefix;

@Local
public interface IOperatorPrefixListAction {

	public Operator getSelectedOperator();

	public void setSelectedOperator(Operator selectedOperator);

	public List<OperatorPrefix> getOperatorPrefixList();

	public void setOperatorPrefixList(List<OperatorPrefix> operatorPrefixList);

	public OperatorPrefix getSelectedOperatorPrefix();

	public void setSelectedOperatorPrefix(OperatorPrefix selectedOperatorPrefix);

	public void remove();

	public void searchOperatorPrefix(Operator operator);

	public void editOperatorPrefix(OperatorPrefix operatorPrefix);

	public void newOperatorPrefix();

	public void deleteOperatorPrefix();

	public void saveOperatorPrefix();

	public boolean isIntervalFrameShowed();

	public void setIntervalFrameShowed(boolean intervalFrameShowed);

	public int getIntervalFirst();

	public void setIntervalFirst(int intervalFirst);

	public int getIntervalLast();

	public void setIntervalLast(int intervalLast);

	public void showIntervalFrame();

	public void createOperatorPrefixesInterval();
}
