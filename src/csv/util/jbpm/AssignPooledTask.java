package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.APPLICATION;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.bpm.Jbpm;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.core.Events;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.web.Parameters;
import org.jbpm.taskmgmt.exe.TaskInstance;

import csv.crm.complaintmng.domain.ComplaintStatus;
import csv.crm.complaintmng.domain.OpenComplaint;

@Name("assignPooledTask")
@AutoCreate
@Scope(ScopeType.CONVERSATION)
@Install(precedence = APPLICATION, dependencies = "org.jboss.seam.bpm.jbpm")
public class AssignPooledTask {

	@In
	private Events events;
	
	@In
	protected FacesMessages facesMessages;

	private String assignToActor;

	public String getAssignToActor() {
		return assignToActor;
	}

	public void setAssignToActor(String assignToActor) {
		this.assignToActor = assignToActor;
	}

	/**
	 * Assign the TaskInstance with the id passed in the request parameter named
	 * "taskId" to the given actor id.
	 * 
	 * @param actorId
	 *            the jBPM actor id
	 * @return a null outcome only if the task was not found
	 */
	@Transactional
	public String assign(String taskId) {
		if (assignToActor == null)
			return null;
		TaskInstance taskInstance = getTaskInstance(taskId);
		if (taskInstance != null) {
			try {
				String processKey = taskInstance.getProcessInstance().getKey();
				OpenComplaint openComplaint = (OpenComplaint)taskInstance.getVariable("openComplaint");
				if(!processKey.equals(openComplaint.getComplaintId().toString())) throw new RuntimeException("There was a problem assigning the task. Please try again..");
			} catch(Exception e) {
				facesMessages.add(e.getMessage());
				return null;
			}
			if (taskInstance.getActorId() != null) {
				facesMessages
						.add("This task has been taken over by someone else. Please select another task..");
				return null;
			}
			taskInstance.setActorId(assignToActor);
			events.raiseEvent("openComplaintAssigned", taskInstance);
			return "taskAssigned";
		} else {
			return null;
		}
	}

	@Transactional
	public String assignToCurrentActor() {
		Actor actor = Actor.instance();
		if (actor.getId() == null) {
			throw new IllegalStateException("no current actor id defined");
		}
		TaskInstance taskInstance = getTaskInstance();
		if (taskInstance != null) {
			try {
				String processKey = taskInstance.getProcessInstance().getKey();
				OpenComplaint openComplaint = (OpenComplaint)taskInstance.getVariable("openComplaint");
				if(!processKey.equals(openComplaint.getComplaintId().toString())) throw new RuntimeException("There was a problem assigning the task. Please try again..");
			} catch(Exception e) {
				facesMessages.add(e.getMessage());
				return null;
			}
			if (taskInstance.getActorId() != null) {
				facesMessages
						.add("This task has already been assigned to someone else. Please select another task or refresh your page..");
				return null;
			}
			
			taskInstance.setActorId(actor.getId());
			events.raiseEvent("openComplaintAssigned", taskInstance);
			return "taskAssignedToActor";
		} else {
			return null;
		}
	}

	/**
	 * @return the TaskInstance with the id passed in the request parameter
	 *         named "taskId".
	 */
	@Transactional
	public TaskInstance getTaskInstance() {
		String[] values = Parameters.instance().getRequestParameters()
				.get("taskId");
		if (values == null || values.length != 1) {
			return null;
		} else {
			String taskId = values[0];
			return taskId == null ? null : ManagedJbpmContext.instance()
					.getTaskInstanceForUpdate(Long.parseLong(taskId));
		}
	}
	
	@Transactional
	public TaskInstance getTaskInstance(String taskId) {
		return ManagedJbpmContext.instance().getTaskInstanceForUpdate(
				Long.parseLong(taskId));
	}
}
