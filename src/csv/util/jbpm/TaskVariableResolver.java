package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.BUILT_IN;

import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.Jbpm;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;
import org.jbpm.context.exe.VariableInstance;
import org.jbpm.context.exe.variableinstance.HibernateLongInstance;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;

@Name("org.jboss.seam.bpm.taskVariableResolver")
@Scope(ScopeType.METHOD)
@AutoCreate
@Install(precedence=BUILT_IN, dependencies="org.jboss.seam.bpm.jbpm")
public class TaskVariableResolver {

	@Logger
	protected Log logger;
	
	@In
	private Renderer renderer;
	
	@Transactional
	public void correctVariableAssignment(TaskInstance taskInstance) {
		String processKey = taskInstance.getProcessInstance().getKey();
		logger.debug("Process Key of task is: " + processKey);
		logger.debug("Process ID of task is: ", taskInstance.getProcessInstance());
		OpenComplaint complaint = null;
		if(taskInstance.getVariable("openComplaint") != null) {
			complaint = (OpenComplaint)taskInstance.getVariable("openComplaint");
			logger.debug("Task Variable('openComplaint') of task is: " + complaint.getComplaintId().toString());
		} else {
			logger.debug("Task Variable('openComplaint') of task is null. Will try to resolve all variables..");
		}
		
		Map variableMap = taskInstance.getVariables();
		logVariableMap(variableMap);
		
		if(taskInstance.getProcessInstance().getContextInstance().getVariable("openComplaint") != null) {
			complaint = (OpenComplaint)taskInstance.getProcessInstance().getContextInstance().getVariable("openComplaint");
			logger.debug("Process Variable('openComplaint') of task is: " + complaint.getComplaintId().toString());
		} else {
			logger.debug("Process Variable('openComplaint') of task is null."); 
		}
		
		variableMap = taskInstance.getProcessInstance().getContextInstance().getVariables();
		logVariableMap(variableMap);
		taskInstance.end();
		taskInstance.getProcessInstance().end();
	}
	
	
	
	@Transactional
	public void checkTaskVariableConsistency() {
		try {
			TaskInstance taskInstance = org.jboss.seam.bpm.TaskInstance.instance();
			ProcessInstance processInstance = taskInstance.getProcessInstance();
			String processKey = processInstance.getKey();
			OpenComplaint comp = (OpenComplaint)taskInstance.getVariable("openComplaint");
			if(!processKey.equals(comp.getComplaintId().toString())) {
				Jbpm.instance().getJbpmConfiguration().getCurrentJbpmContext().setRollbackOnly();
				renderer.render("/tasks/notification/broken_process_consistency_warning.xhtml");
				throw new RuntimeException("Process variable consistency is broken. Process key does not match Task Instance variable: ProcessKey = " + processKey + " - " + " Task Instance Variable = " + comp.getComplaintId().toString());
			} else {
				logger.debug("Process key Task Instance variable consistency checking passed: Process Key = " + processKey);
			}
		} catch(Exception e) {
			throw new RuntimeException("Error during checking process variable consistency: " + e.getMessage());
		}
	}
	
	
	
	private void logVariableMap(Map vMap) {
		Set<String> keys = vMap.keySet();
		for(String key : keys) {
			OpenComplaint complaint = (OpenComplaint)vMap.get(key);
			logger.debug("Variable value for key " + key + " is: " + complaint.getComplaintId().toString());
			
		}
	}
	
	private void logVariablesForComplaint(String key) {
		Criteria query = ManagedJbpmContext.instance().getSession()
				.createCriteria(HibernateLongInstance.class);
		
	}
}
