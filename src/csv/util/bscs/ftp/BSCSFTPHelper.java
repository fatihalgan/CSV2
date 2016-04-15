package csv.util.bscs.ftp;

import java.io.IOException;
import java.net.UnknownHostException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPConnectionClosedException;

public class BSCSFTPHelper {
	
	private static final Log log = LogFactory.getLog(BSCSFTPHelper.class);
	private String serverName;
	private String ftpUserName;
	private String ftpPassword;
	private String serverName2;
	private String ftpUserName2;
	private String ftpPassword2;
		
	public BSCSFTPHelper() {
		super();
	}
	
	public BSCSFTPHelper(String serverName, String ftpUserName, String ftpPassword, String serverName2, String ftpUserName2, String ftpPassword2) {
		this.serverName = serverName;
		this.ftpUserName = ftpUserName;
		this.ftpPassword = ftpPassword;
		this.serverName2 = serverName2;
		this.ftpUserName2 = ftpUserName2;
		this.ftpPassword2 = ftpPassword2;
	}

	private void disconnect(JakartaFtpWrapper bscsFTPConnection) {
		log.debug("disconnecting bscs ftp connection");
		try {
			if(bscsFTPConnection!=null && bscsFTPConnection.isConnected()) {
				bscsFTPConnection.logout();
				log.debug("BSCS ftp connection logout successful");
			}
		} catch (IOException e) {
			log.error("IOException trying to logout BSCS ftp connection", e);
		}		
		
		try {
			if(bscsFTPConnection!=null && bscsFTPConnection.isConnected()) {
				bscsFTPConnection.disconnect();
				log.debug("BSCS ftp connection disconnect successful");
			}
		} catch (IOException e) {
			log.error("IOException trying to disconnect BSCS ftp connection", e);
		}	
	}
	
	private boolean connect(JakartaFtpWrapper bscsFTPConnection, String serverName, String ftpUserName, String ftpPassword) {
		try {
			if (bscsFTPConnection.connectAndLogin(serverName, ftpUserName, ftpPassword)) {
				log.debug("FTP connection to BSCS successful");
				return true;
			} else {
				log.error("error trying to setup BSCS ftp connection");
				return false;
			}
		} catch (UnknownHostException e) {
			log.error("UnknownHostException trying to setup BSCS ftp connection", e);
			return false;
		} catch (FTPConnectionClosedException e) {
			log.error("FTPConnectionClosedException trying to setup BSCS ftp connection", e);
			return false;
		} catch (IOException e) {
			log.error("IOException trying to setup BSCS ftp connection", e);
			return false;
		}
	}
	
	public synchronized String getInvoiceFromBSCS (String bscsPath, String saveDirectory) {
		boolean status = false;
		String fileName;
		int pathIndexStart = 0;
		int lastSlashPosition = bscsPath.lastIndexOf("/");
		fileName = bscsPath.substring(lastSlashPosition + 1);
		//bscsPath = bscsPath.substring(0, lastSlashPosition);		
		status = downloadFile("/facturas" + bscsPath, fileName, saveDirectory, serverName, ftpUserName, ftpPassword);
		if(status) return saveDirectory + "/" + fileName;
		return null;
	}
	
	private boolean downloadFile(String bscsPath, String fileName, String saveDirectory, String serverName, String ftpUserName, String ftpPassword) {
		boolean status = true;
		JakartaFtpWrapper bscsFTPConnection = new JakartaFtpWrapper();
		try {
			status = connect(bscsFTPConnection, serverName, ftpUserName, ftpPassword);
			if(!status) throw new IOException("Cannot connect to " + serverName + " via FTP");
			
			bscsFTPConnection.binary();
			boolean downloadOK = bscsFTPConnection.downloadFile(bscsPath, saveDirectory + "\\" + fileName);
			if(!downloadOK) {
				log.error("ftp connection to BSCS was not successful");
				return false;
			} else {
				log.debug("file downloaded successfully");
				return true;
			}
		} catch(IOException e) {
			log.error("Cannot connect to " + serverName + " via FTP");
			return  false;
		} finally {
			disconnect(bscsFTPConnection);
		}
	}

}
