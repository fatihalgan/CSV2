package csv.crm.complaintmng.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.common.domain.District;
import csv.common.domain.Province;
import csv.common.service.ICommonOperationsService;

@Name("complaintLocality")
@AutoCreate
@Scope(ScopeType.CONVERSATION)
public class ComplaintLocality implements Serializable {
	
	@Logger
	private Log logger;
	
	@In
	protected FacesMessages facesMessages;
	
	@In(value="commonOperationsService", create=true)
	private ICommonOperationsService commonOperationsService;
	
	private List<Province> provinces = null;
	
	private Province province;
	private District district;
	
	private Date dateOfOccurence;
	
	public ComplaintLocality() {
		super();
	}
	
	public List<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(List<Province> provinces) {
		this.provinces = provinces;
	}
	
	public List<District> getDistricts() {
		return province.getDistrictsAsList();
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}
	
	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
	
	public Date getDateOfOccurence() {
		return dateOfOccurence;
	}

	public void setDateOfOccurence(Date dateOfOccurence) {
		this.dateOfOccurence = dateOfOccurence;
	}

	@Create
	public void initialize() {
		try {
			provinces = commonOperationsService.retrieveProvinces();
			province = provinces.get(0);
		} catch(Exception e) {
			logger.error("Could not load provinces: ", e.getMessage());
			facesMessages.add(Severity.ERROR, "Error while retrieving list of provinces: " + e.getMessage());
		}
	}
	
}
