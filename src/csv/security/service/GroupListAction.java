package csv.security.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

import csv.crm.complaintmng.domain.ComplaintSegment;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.GroupType;

@Name("groupListAction")
@Stateless
@AutoCreate
public class GroupListAction implements IGroupListAction, Serializable {

	@Logger
	private Log logger;
	
	@In
	FacesMessages facesMessages;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	@DataModel(scope=ScopeType.PAGE)
	private List<Group> groupList = null;
	
	@DataModelSelection
	private Group selectedGroup = null;
	
	public Group getSelectedGroup() {
		return selectedGroup;
	}

	public void setSelectedGroup(Group selectedGroup) {
		this.selectedGroup = selectedGroup;
	}
		
	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}
	
	public void searchGroups() {
		groupList = securityDao.findAllGroups();
	}
	
	public void resetSearch() {
		groupList = null;
	}
	
	public void deleteGroup() {
		securityDao.update(selectedGroup);
		selectedGroup.removeAllPermittedOperations();
		securityDao.delete(selectedGroup);
		searchGroups();
	}
	
}
