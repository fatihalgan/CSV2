package csv.util.faces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.international.StatusMessage.Severity;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import csv.common.service.BaseService;


@Name("fileAttachmentListener")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class FileAttachmentListener extends BaseService {

	private String fileName = null;
	
	public FileAttachmentListener() {
		super();
	}
	
	private String trimFileName(String fileName) {
		fileName = fileName.trim();
		fileName = fileName.replaceAll(" ", "_");
		return fileName;
	}
	
	public byte[] addAttachment(UploadEvent event) {
		File file = null;
		InputStream reader = null;
		try {
			UploadItem item = event.getUploadItem();
			file = item.getFile();
			byte[]fileData = new byte[item.getFileSize()];
			reader = new FileInputStream(file);
			reader.read(fileData);
			this.fileName = trimFileName(item.getFileName());
			return fileData;
		} catch(IOException ioe) {
			logger.error("Could not read attched file: " + ioe.getMessage());
			facesMessages.add(Severity.ERROR, "Could not attach file: " + ioe.getMessage());
			return null;
		} finally {
			try {
				reader.close();
			} catch(IOException ioe) {
				//Do nothing
			}
		}
	}

	public String getFileName() {
		return fileName;
	}
	

}
