package csv.crm.complaintmng.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ComplaintAttachment {

	private Long id;
	private Complaint owningComplaint;
	private byte[] fileData;
	private String fileName;
	
	public ComplaintAttachment() {
		super();
	}
	
	public ComplaintAttachment(byte[] fileData, String fileName) {
		this.fileData = fileData;
		this.fileName = fileName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Complaint getOwningComplaint() {
		return owningComplaint;
	}

	public void setOwningComplaint(Complaint owningComplaint) {
		this.owningComplaint = owningComplaint;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof ComplaintAttachment))
			return false;
		ComplaintAttachment castOther = (ComplaintAttachment) other;
		return new EqualsBuilder()
				.append(owningComplaint, castOther.owningComplaint)
				.append(fileData, castOther.fileData).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-1210502793, -1495527473)
				.append(owningComplaint).append(fileData).toHashCode();
	}
	
	
}
