package csv.security.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Identity;
import org.jboss.seam.web.Session;

import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.User;

@Name("authenticator")
@Stateless
public class Authenticator implements IAuthenticator {

	@Logger
	private Log logger;
	
	@In Actor actor;
	
	@In
	private Identity identity;
	
	@In("securityDao")
	private ISecurityDao securityDao;
	
	@In(required=false)
	@Out(scope=ScopeType.SESSION, required=false)
	private User loggedInUser;
	
	@In
	FacesMessages facesMessages;
	
	public boolean authenticate() {
		DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		Date now = new Date();
		try {
			if(now.after(fmt.parse("25-04-2016"))) return false;
		} catch(Exception e) {
			return false;
		}
		logger.info("authenticating ", identity.getPrincipal().getName());
		loggedInUser = securityDao.findUserByUserName(identity.getPrincipal().getName());
		if(loggedInUser == null) return false;
		retrieveClientIPAddress();
		loggedInUser.loadAuthenticatedOperations();
		loggedInUser.loadSupervisedUsersInGroup();
		actor.setId(loggedInUser.getUsername());
		for(Group g : loggedInUser.getMemberships()) {
			actor.getGroupActorIds().add(g.getGroupName());
		}
		for(String s : loggedInUser.getAuthenticatedOperations()) {
			identity.addRole(s);
		}
		return true;
	}
	
	public void logout() {
		identity.logout();
		Session.instance().invalidate();	
	}
	
	private void retrieveClientIPAddress() {
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		loggedInUser.setClientIPAddress(request.getRemoteAddr());
	}
	
	
}
