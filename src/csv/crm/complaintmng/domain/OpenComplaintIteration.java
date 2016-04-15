package csv.crm.complaintmng.domain;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class OpenComplaintIteration implements Serializable {
	
	private static final long serialVersionUID = -4902290474851107043L;
	
	private String enteredBy;
	private Date enteredOn;
	private String comment;
		
	private OpenComplaint owningComplaint;
	
	public OpenComplaintIteration() {
		super();
	}
	
	public OpenComplaintIteration(String enteredBy) {
		this.enteredBy = enteredBy;
		this.enteredOn = new Date();
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public Date getEnteredOn() {
		return enteredOn;
	}

	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public OpenComplaint getOwningComplaint() {
		return owningComplaint;
	}

	public void setOwningComplaint(OpenComplaint owningComplaint) {
		this.owningComplaint = owningComplaint;
	}
	
	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof OpenComplaintIteration))
			return false;
		OpenComplaintIteration castOther = (OpenComplaintIteration) other;
		return new EqualsBuilder().append(enteredBy, castOther.enteredBy)
				.append(enteredOn, castOther.enteredOn).append(owningComplaint,
						castOther.owningComplaint).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-935645371, -1744650617).append(enteredBy)
				.append(enteredOn).append(owningComplaint).toHashCode();
	}
	
}
