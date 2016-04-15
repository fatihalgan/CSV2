package csv.util.jbpm;

import java.util.Comparator;

import org.jbpm.taskmgmt.exe.TaskInstance;

public class TaskInstancePriorityComparator implements Comparator<TaskInstance> {

	@Override
	public int compare(TaskInstance first, TaskInstance second) {
		if(first.getCreate().before(second.getCreate())) return -1;
		if(first.getCreate().equals(second.getCreate())) return 0;
		return 1;
	}

}
