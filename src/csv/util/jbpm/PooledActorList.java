package csv.util.jbpm;

import static org.jboss.seam.annotations.Install.APPLICATION;

import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.annotations.Unwrap;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jbpm.taskmgmt.exe.PooledActor;
import org.jbpm.taskmgmt.exe.TaskInstance;

@Name("pooledActorList")
@Scope(ScopeType.APPLICATION)
@Install(precedence=APPLICATION, dependencies="org.jboss.seam.bpm.jbpm")
public class PooledActorList {

	@Unwrap
	@Transactional
	public List<PooledActor> getPooledActorList() {
		TaskInstance taskInstance = org.jboss.seam.bpm.TaskInstance.instance();
		if(taskInstance == null) return null;
		return getPooledActorList(taskInstance.getId());
	}
	
	private List<PooledActor> getPooledActorList(Long taskInstanceId) {
		List<PooledActor> actors = null;
		actors = ManagedJbpmContext.instance().getSession()
	    .createQuery("Select org.jbpm.taskmgmt.exe.PooledActor pa, ti from org.jbpm.taskmgmt.exe.TaskInstance ti " +
	    		"where pa in elements(ti.pooledActors) and " +
	    		"ti.isOpen = ? and " +
	    		"ti.id = ?")
	    		.setBoolean(0, true).setLong(1, taskInstanceId)
	    .list();
	    return actors;
	}
}
