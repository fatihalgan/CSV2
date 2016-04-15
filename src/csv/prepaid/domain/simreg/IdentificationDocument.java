package csv.prepaid.domain.simreg;

import java.io.Serializable;
import java.util.Date;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;

public class IdentificationDocument implements Serializable {

	private IdentityDocType documentType;
	private String documentNo;
	private String issuedBy;
	private Date issueDate;
	private Date expiryDate;
	
	public IdentificationDocument() {
		super();
	}

	public IdentityDocType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(IdentityDocType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other)
			return true;
		if (!(other instanceof IdentificationDocument))
			return false;
		IdentificationDocument castOther = (IdentificationDocument) other;
		return new EqualsBuilder().append(documentType, castOther.documentType)
				.append(documentNo, castOther.documentNo)
				.append(issuedBy, castOther.issuedBy)
				.append(issueDate, castOther.issueDate)
				.append(expiryDate, castOther.expiryDate).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(-2017673465, -1457546051)
				.append(documentType).append(documentNo).append(issuedBy)
				.append(issueDate).append(expiryDate).toHashCode();
	}
	
	
}
