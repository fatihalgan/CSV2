package csv.roaming.service;

import java.util.List;

import javax.ejb.Local;
import javax.faces.convert.Converter;

import csv.roaming.domain.OperatorCountry;
import csv.roaming.domain.OperatorService;
import csv.roaming.domain.RoamingService;

@Local
public interface IOperatorServiceListAction {

	public OperatorCountry getSelectedOperatorCountry();

	public void setSelectedOperatorCountry(
			OperatorCountry selectedOperatorCountry);

	public List<RoamingService> getUnselectedServices();

	public void setUnselectedServices(List<RoamingService> unselectedServices);

	public List<RoamingService> getSelectedServices();

	public void setSelectedServices(List<RoamingService> selectedServices);

	public List<OperatorService> getOperatorServiceList();

	public void setOperatorServiceList(List<OperatorService> operatorServiceList);

	public void remove();

	public void searchOperatorService(OperatorCountry operatorRegion);

	public void saveOperatorServices();

	public Converter getServiceListShuttleConverter();

}
