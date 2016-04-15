package csv.util.jbpm;

import static org.hibernate.criterion.Order.asc;
import static org.hibernate.criterion.Order.desc;
import static org.hibernate.criterion.Restrictions.isNotNull;
import static org.hibernate.criterion.Restrictions.isNull;
import static org.jboss.seam.annotations.Install.APPLICATION;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.Install;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jbpm.graph.exe.ProcessInstance;

@Name("org.jboss.seam.bpm.processInstanceFinder")
@Install(precedence = APPLICATION, dependencies = "org.jboss.seam.bpm.jbpm")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class ProcessInstanceFinder {
	
	private String processDefinitionName;
	private String nodeName;
	private Boolean processInstanceEnded = false;
	private Boolean sortDescending = false;
	private String processkey = null;

	@Factory(value = "org.jboss.seam.bpm.processInstanceList", autoCreate = true)
	@Transactional
	public List<ProcessInstance> getProcessInstanceList() {
		Criteria query = ManagedJbpmContext.instance().getSession()
				.createCriteria(ProcessInstance.class);
		if (processInstanceEnded != null) {
			query.add(processInstanceEnded ? isNotNull("end") : isNull("end"));
		}
		
		if(processkey != null) {
			query.add(Restrictions.eq("key", processkey));
		}

		if (processDefinitionName != null) {
			query.createCriteria("processDefinition").add(
					Restrictions.like("name", processDefinitionName, MatchMode.ANYWHERE));
		}
		
		query = query.createCriteria("rootToken");
		if (sortDescending != null) {
			query.addOrder(sortDescending ? desc("nodeEnter")
					: asc("nodeEnter"));
		}
		if (nodeName != null) {
			query.createCriteria("node").add(Restrictions.eq("name", nodeName));
		}
		
		return query.list();
	}
	
	public ProcessInstance getUniqueProcessInstance() {
		List<ProcessInstance> instances = getProcessInstanceList();
		if(instances.size() > 1) throw new RuntimeException("More than one process instance exists for the given criterion..");
		if(instances.size() == 0) throw new RuntimeException("No process instance exists with the given criterion..");
		return instances.get(0);
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getProcessDefinitionName() {
		return processDefinitionName;
	}

	public void setProcessDefinitionName(String processDefinitionName) {
		this.processDefinitionName = processDefinitionName;
	}

	public Boolean isSortDescending() {
		return sortDescending;
	}

	public void setSortDescending(Boolean sortDescending) {
		this.sortDescending = sortDescending;
	}

	public Boolean getProcessInstanceEnded() {
		return processInstanceEnded;
	}

	public void setProcessInstanceEnded(Boolean ended) {
		this.processInstanceEnded = ended;
	}

	public String getProcesskey() {
		return processkey;
	}

	public void setProcesskey(String processkey) {
		this.processkey = processkey;
	}
	
	

}
