package csv.crm.complaintmng.service;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import csv.crm.complaintmng.dao.IComplaintManagementDao;
import csv.crm.complaintmng.domain.ComplaintAttachment;

@Name("complaintAttachmentViewer")
@Scope(ScopeType.CONVERSATION)
public class ComplaintAttachmentViewer {

	@Logger
	protected Log logger;
	
	@In
	protected FacesMessages facesMessages;
	
	@In("complaintManagementDao")
	private IComplaintManagementDao compDao;
	
	private List<ComplaintAttachment> attachments;
	
	public List<ComplaintAttachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<ComplaintAttachment> attachments) {
		this.attachments = attachments;
	}
	
	public void retrieveAttachments(Long complaintId) {
		logger.debug("Will download complaint attachments here..");
		attachments = compDao.findComplaintAttachments(complaintId);
		for(ComplaintAttachment a : attachments) {
			try {
				FileOutputStream os = new FileOutputStream(getRealDownloadPath() + a.getId().toString() + a.getFileName());
				os.write(a.getFileData());
				os.flush();
				os.close();
			} catch(IOException ioe) {
				logger.debug("Could not write attachment to: " + getRealDownloadPath() + a.getId().toString() + a.getFileName());
				facesMessages.add(Severity.ERROR, "Could not write attachment: " + ioe.getMessage());
			}
		}
	}
	
	public String getDownloadLocation() {
		return getRequestContextPath() + "/complaint_attachments/";
	}
	
	private String getRealDownloadPath() {
		FacesContext fCtx = FacesContext.getCurrentInstance();
		ServletContext sCtx = (ServletContext)fCtx.getExternalContext().getContext();
		return sCtx.getRealPath("/") + "/complaint_attachments/";
	}
	
	private String getRequestContextPath() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		return ctx.getExternalContext().getRequestContextPath();
	}
}
