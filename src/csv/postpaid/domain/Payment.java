package csv.postpaid.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Payment implements Serializable {

	private static final long serialVersionUID = -4844944391299833029L;
	
	private String referenceNo;
	private String documentReferenceNo;
	private String paymentType;
	private Date entryDate;
	private Date receiptDate;
	private Date postingDate;
	private BigDecimal amountPaid;
	private String comment;

	public Payment() {
		super();
	}

	public Payment(String referenceNo, String documentReferenceNo,
			String paymentType, Date entryDate, Date receiptDate,
			Date postingDate, BigDecimal amountPaid, String comment) {
		this.referenceNo = referenceNo;
		this.documentReferenceNo = documentReferenceNo;
		this.paymentType = paymentType;
		this.entryDate = entryDate;
		this.receiptDate = receiptDate;
		this.postingDate = postingDate;
		this.amountPaid = amountPaid;
		this.comment = comment;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getDocumentReferenceNo() {
		return documentReferenceNo;
	}

	public void setDocumentReferenceNo(String documentReferenceNo) {
		this.documentReferenceNo = documentReferenceNo;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}

	public Date getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Date receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public BigDecimal getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
