package csv.crm.complaintmng.domain;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;

@Name("openComplaintNextPhase")
@AutoCreate
@Scope(ScopeType.CONVERSATION)
public class OpenComplaintNextPhase implements Serializable {

	private ComplaintPhase nextPhase;
	
	@Create
	public void initialize() {
		nextPhase = ComplaintPhase.SUPERVISOR_FEEDBACK;
	}

	public ComplaintPhase getNextPhase() {
		return nextPhase;
	}

	public void setNextPhase(ComplaintPhase nextPhase) {
		this.nextPhase = nextPhase;
	}
	
}
