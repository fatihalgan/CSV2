package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;

import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.OperatorTariff;
import csv.roaming.domain.Service;

@Local
public interface IOperatorTariffListAction {
	public List<OperatorTariff> getOperatorTariffList();

	public void setOperatorTariffList(List<OperatorTariff> operatorTariffList);

	public OperatorTariff getSelectedOperatorTariff();

	public void setSelectedOperatorTariff(OperatorTariff selectedOperatorTariff);

	public OperatorCountry getSelectedOperatorCountry();

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<Service> getServiceList();

	public void setServiceList(List<Service> serviceList);

	public void searchOperatorTariffs(OperatorCountry operatorCountry);

	public void editOperatorTariff(OperatorTariff operatorTariff);

	public void saveOperatorTariff();

	public void deleteOperatorTariff();

	public void newOperatorTariff();

	public void remove();
}
