package csv.postpaid.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Document implements Serializable {

	private static final long serialVersionUID = -2597224461328146405L;
	
	private String referenceNo;
	private Date referenceDate;
	private Date dueDate;
	private BigDecimal totalAmount;
	private BigDecimal openAmount;
	private String documentType;

	public Document() {
		super();
	}

	public Document(String referenceNo, Date referenceDate, Date dueDate,
			BigDecimal totalAmount, BigDecimal openAmonut, String documentType) {
		this.referenceNo = referenceNo;
		this.referenceDate = referenceDate;
		this.dueDate = dueDate;
		this.totalAmount = totalAmount;
		this.openAmount = openAmonut;
		this.documentType = documentType;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getReferenceDate() {
		return referenceDate;
	}

	public void setReferenceDate(Date referenceDate) {
		this.referenceDate = referenceDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(BigDecimal openAmount) {
		this.openAmount = openAmount;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

}
