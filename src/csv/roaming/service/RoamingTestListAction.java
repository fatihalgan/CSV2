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
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

import csv.roaming.dao.IRoamingDao;
import csv.roaming.domain.Continent;

@Name("roamingTestListAction")
@Stateful
@Scope(ScopeType.CONVERSATION)
public class RoamingTestListAction implements IRoamingTestListAction,
		Serializable {
	@Logger
	private Log logger;

	@In
	FacesMessages facesMessages;

	@In("roamingDao")
	private IRoamingDao roamingDao;

	private List<Continent> continentList = new ArrayList<Continent>();

	public List<Continent> getContinentList() {
		return continentList;
	}

	public void setContinentList(List<Continent> continentList) {
		this.continentList = continentList;
	}

	@Begin(flushMode = FlushModeType.MANUAL, nested = true)
	public void searchContinentList() {
		continentList = roamingDao.findAllContinents();
	}

	public void clearContinentList() {
		continentList = new ArrayList<Continent>();
	}

	@Remove
	public void remove() {
		logger.debug("Removing Stateful Component roamingTestListAction..");
	}

}
