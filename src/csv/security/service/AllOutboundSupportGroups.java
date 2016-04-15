package csv.security.service;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Unwrap;

import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.GroupType;

@Name("allOutboundSupportGroups")
@Scope(ScopeType.SESSION)
@AutoCreate
public class AllOutboundSupportGroups {

	@In("securityDao")
	private ISecurityDao securityDao;
	
	@Unwrap
	public List<Group> retrieveOutboundSupportGroupList() {
		return securityDao.findGroupByUserGroupType(GroupType.OUTBOUND_SUPPORT);	
	}
}
