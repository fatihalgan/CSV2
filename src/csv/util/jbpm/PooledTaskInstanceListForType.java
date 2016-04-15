package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.APPLICATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.Unwrap;
import org.jboss.seam.annotations.intercept.BypassInterceptors;
import org.jboss.seam.bpm.Actor;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jbpm.taskmgmt.exe.TaskInstance;

@Name("pooledTaskInstanceListForType")
@Scope(ScopeType.APPLICATION)
@Install(precedence = APPLICATION, dependencies = "org.jboss.seam.bpm.jbpm")
public class PooledTaskInstanceListForType {

	@Unwrap
	@Transactional
	public Map<String,List<TaskInstance>> getPooledTaskInstanceList() {
		String actorId = Actor.instance().getId(); 
		if( actorId == null) return null;
		Map<String, List<TaskInstance>> map = new HashMap<String, List<TaskInstance>>();
		List<TaskInstance> allTaskInstances = getAllPooledTaskInstanceList();
	    for(TaskInstance task : allTaskInstances) {
	    	String name = task.getName();
	    	List<TaskInstance> list = map.get(name);
	        if (list == null) {
	            list = new ArrayList<TaskInstance>();
	            map.put(name, list);
	         }
	         list.add(task);
	    }
	    return map;
	}

	
	public List<TaskInstance> getAllPooledTaskInstanceList() {
		Actor actor = Actor.instance();
		String actorId = actor.getId();
		if (actorId == null) return null;
		ArrayList groupIds = new ArrayList(actor.getGroupActorIds());
		groupIds.add(actorId);
		List<TaskInstance> tasks = ManagedJbpmContext.instance().getGroupTaskList(groupIds);
		Collections.sort(tasks, new TaskInstancePriorityComparator());
		return tasks;
	}
}
