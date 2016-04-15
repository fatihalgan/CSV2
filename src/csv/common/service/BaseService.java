package csv.common.service;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.TransactionPropagationType;
import org.jboss.seam.annotations.Transactional;
import org.jboss.seam.bpm.ManagedJbpmContext;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;

import csv.security.dao.ISecurityDao;
import csv.security.domain.AccessLog;
import csv.security.domain.Operation;
import csv.security.domain.OperationNames;
import csv.security.domain.User;

public abstract class BaseService implements Serializable {

	@Logger
	protected Log logger;
	
	@In(required=true)
	protected User loggedInUser;
	
	@In("securityDao")
	protected ISecurityDao securityDao;
	
	@In
	protected FacesMessages facesMessages;
	
	@Resource
	private EJBContext ejbContext;
	
	public void logAccess(OperationNames operationName, String msisdn, String remark) {
		Operation operation = securityDao.findOperationByName(operationName);
		AccessLog accessLog = new AccessLog();
		accessLog.setDate(new Date());
		accessLog.setIpAddress(loggedInUser.getClientIPAddress());
		accessLog.setMsisdn(msisdn);
		accessLog.setOwningOperation(operation);
		accessLog.setOwningUser(loggedInUser);
		accessLog.setRemark(remark);
		securityDao.save(accessLog);
	}
	
	
	public void logAccess(OperationNames operationName, String msisdn, String contractId, String remark) {
		Operation operation = securityDao.findOperationByName(operationName);
		AccessLog accessLog = new AccessLog();
		accessLog.setDate(new Date());
		accessLog.setIpAddress(loggedInUser.getClientIPAddress());
		accessLog.setMsisdn(msisdn);
		accessLog.setContractId(contractId);
		accessLog.setOwningOperation(operation);
		accessLog.setOwningUser(loggedInUser);
		accessLog.setRemark(remark);
		securityDao.save(accessLog);
	}
	
	public void logAccess(OperationNames operationName, String msisdn, String contractId, Integer customerId, String remark) {
		Operation operation = securityDao.findOperationByName(operationName);
		AccessLog accessLog = new AccessLog();
		accessLog.setDate(new Date());
		accessLog.setIpAddress(loggedInUser.getClientIPAddress());
		accessLog.setMsisdn(msisdn);
		accessLog.setContractId(contractId);
		if(customerId != null) accessLog.setCustomerId(customerId.toString());
		else accessLog.setCustomerId("");
		accessLog.setOwningOperation(operation);
		accessLog.setOwningUser(loggedInUser);
		accessLog.setRemark(remark);
		securityDao.save(accessLog);
	}
	
	protected String formatDate(Date date) {
		if(date==null)
			return null;
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		String dayPart = (dayOfMonth<10) ? ("0" + dayOfMonth) : (""+dayOfMonth);
		int month = cal.get(Calendar.MONTH) + 1;
		String monthPart = (month<10) ? ("0" + month) : (""+month);
		int year = cal.get(Calendar.YEAR);
		
		return dayPart + "/" + monthPart + "/" + year;
	}
	
	protected ResourceBundle getMessages() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ResourceBundle bundle = null;
		try {
			bundle = ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(),ctx.getViewRoot().getLocale());
			if(bundle == null) {
				bundle = ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(),new Locale("en"));
			}
		} catch(Exception e) {
			bundle = ResourceBundle.getBundle(ctx.getApplication().getMessageBundle());
		}
		return bundle;
	}
	
	protected String getRealInvoicesPath() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		ExternalContext ectx = ctx.getExternalContext();
		HttpSession session = (HttpSession)ectx.getSession(false);
		return session.getServletContext().getRealPath("invoices");
	}
	
	protected String getRequestContextPath() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		return ctx.getExternalContext().getRequestContextPath();
	}
	
	protected HttpServletResponse getServletResponse() {
        return (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
    }
	
	protected void setResponseContentToExcel() {
    	HttpServletResponse response = getServletResponse();
        response.setContentType("application/vnd.ms-excel");
		response.setHeader("Expires","0");
		response.setHeader("Pragma", "cache");
		response.setHeader("Cache-Control", "cache");
		response.setHeader("Content-disposition","attachment;filename="+System.currentTimeMillis()+".xls");
    }
	
	public List<AccessLog> findEventsAfter(OperationNames opName, String msisdn, Date dateof) {
		return securityDao.findAccessLogEventAfter(opName, msisdn, dateof);
	}
	
	protected void handleApplicationException(Exception e, boolean rollback) {
		facesMessages.add("Error: " + e.getMessage());
		if(rollback) {
			ejbContext.setRollbackOnly();
			ManagedJbpmContext.instance().setRollbackOnly();
		}
		
	}
	
}
