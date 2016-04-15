package csv.crm.complaintmng.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.common.service.IDrService;
import csv.crm.complaintmng.domain.OpenComplaint;
import csv.dr.dao.IDrDao;
import csv.security.dao.ISecurityDao;
import csv.security.domain.Group;
import csv.security.domain.User;
import csv.util.jbpm.ProcessKeyResolver;

@Name("openComplaintTaskAssigned")
@Scope(ScopeType.METHOD)
@AutoCreate
public class OpenComplaintTaskAssignedAction {
	
	@Logger
	protected Log logger;
	
	@In
	private Renderer renderer;
	
	@In(value="securityDao")
	private ISecurityDao securityDao;
	
	@In
	private ProcessKeyResolver processKeyResolver;
	
	@In("drDao")
	private IDrDao drDao;
	
	@In(value="drService")
	private IDrService drService;
	
	@In(required=true)
	protected User loggedInUser;
	
	@Out(scope=ScopeType.EVENT, required=false)
	private String groupSupervisorEmail;
	
	@Transactional
	public void notifyTaskAssigned() {
		try {
			TaskInstance taskInstance = org.jboss.seam.bpm.TaskInstance.instance();
			if(taskInstance.getActorId() != null) {
				//if this is a self assignment do not alert
				OpenComplaint openComplaint = (OpenComplaint)taskInstance.getVariable("openComplaint");
				openComplaint.setAssignedToUser(taskInstance.getActorId());
				if(loggedInUser.getUsername().equals(taskInstance.getActorId())) return;
				renderer.render("/tasks/notification/notify_complaint_task.xhtml");
				String msisdn = resolvePhoneNo(taskInstance.getActorId());
				if(msisdn != null && msisdn.length() != 0) {
					msisdn = "258" + msisdn; 
					drService.createSMSMessage(msisdn, "You have a new customer complaint to be attended. The complaint number is " + processKeyResolver.getProcessKey() + ".", "CSV Task Assignment");
					drDao.flush();
				}
			}
		} catch(Exception e) {
			logger.error(e);
		}
	}
	
	
	public void notifyTaskInPool() {
		try {
			TaskInstance taskInstance = org.jboss.seam.bpm.TaskInstance.instance();
			Set<PooledActor> pooledActors = taskInstance.getPooledActors();
			if(pooledActors != null && pooledActors.size() > 0) {
				List<User> users = new ArrayList<User>();
				for(PooledActor actor : pooledActors) {
					Group g = securityDao.findGroupByName(actor.getActorId());
					users.addAll(g.getGroupSupervisors());
				}
				for(User user : users) {
					if(loggedInUser.getUsername().equals(user.getUsername())) continue;
					String msisdn = resolvePhoneNo(user.getUsername());
					if(msisdn != null && msisdn.length() != 0) msisdn = "258" + msisdn;
					drService.createSMSMessage(msisdn, "You have a new customer complaint waiting in the pool for assignment. The complaint number is " + org.jboss.seam.bpm.TaskInstance.instance().getProcessInstance().getKey() + ".", "CSV Task Assignment");
					drDao.flush();
					groupSupervisorEmail = user.getEmail();
					renderer.render("/tasks/notification/notify_pooled_complaint_task.xhtml");
				}
			}
		} catch(Exception e) {
			logger.error(e);
		}
	}
	
	public String resolveMailAddress(String actorId) {
		User user = securityDao.findUserByUserName(actorId);
		return user.getEmail(); 
	}
	
	public String resolvePhoneNo(String actorId) {
		User user = securityDao.findUserByUserName(actorId);
		return user.getMsisdn(); 
	}
	
	
}

	