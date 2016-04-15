package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.BUILT_IN;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;
import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.graph.exe.ProcessInstance;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.domain.OpenComplaint;

@Name("org.jboss.seam.bpm.processVariableResolver")
@Scope(ScopeType.METHOD)
@AutoCreate
@Install(precedence=BUILT_IN, dependencies="org.jboss.seam.bpm.jbpm")
public class ProcessVariableResolver {

	@Logger
	protected Log logger;
	
	@In
	private Renderer renderer;
	
	@Transactional
	public void checkProcessVariableConsistency() {
		try {
			ProcessInstance processInstance = ExecutionContext.currentExecutionContext().getProcessInstance();
			String processKey = processInstance.getKey();
			OpenComplaint comp = (OpenComplaint)processInstance.getContextInstance().getVariable("openComplaint");
			if(!processKey.equals(comp.getComplaintId().toString())) {
				ManagedJbpmContext.instance().setRollbackOnly();
				renderer.render("/tasks/notification/broken_process_consistency_warning.xhtml");
				throw new RuntimeException("Process variable consistency is broken. Process key does not match process instance variable in JBPM: ProcessKey = " + processKey + " - " + " Process Instance Variable = " + comp.getComplaintId().toString());
			}
		} catch(Exception e) {
			throw new RuntimeException("Error during checking process variable consistency: " + e.getMessage());
		}
	}
	
}
