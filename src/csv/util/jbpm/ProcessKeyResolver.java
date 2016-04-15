package csv.util.jbpm;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jbpm.graph.exe.Token;
import org.jbpm.taskmgmt.exe.TaskInstance;

@Name("processKeyResolver")
@AutoCreate
@Scope(ScopeType.METHOD)
public class ProcessKeyResolver {

	public String getProcessKey() {
		TaskInstance taskInstance = org.jboss.seam.bpm.TaskInstance.instance();
		if(taskInstance.getProcessInstance().getKey() != null) return taskInstance.getProcessInstance().getKey();
		String key = null;
		do {
			Token token = taskInstance.getProcessInstance().getSuperProcessToken();
			key = token.getProcessInstance().getKey();
		} while(key == null);
		return key;
	}
}
