package com.rim.blackberry.provision.service;

import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.async.Asynchronous;
import org.jboss.seam.annotations.async.IntervalCron;
import org.jboss.seam.async.QuartzTriggerHandle;
import org.jboss.seam.log.Log;

import com.rim.blackberry.provision.RIMEvent;
import com.rim.blackberry.provision.RIMEventType;
import com.rim.blackberry.provision.client.ARIProcessingException;
import com.rim.blackberry.provision.client.BlackberryProvisioningServiceStub;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReqEntity;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReqHeader;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionSender;

import csv.postpaid.dao.IBSCSDao;
import csv.util.soap.AxisClientConfigurator;

@Name("rimProvisioningService")
@Stateless
@AutoCreate
public class RIMProvisioningService implements IRIMProvisioningService {

	@Logger
	private Log logger;
	
	@In("bscsDao")
	private IBSCSDao bscsDao;
	
	@In("#{axisClientConfigurator}")
	private AxisClientConfigurator axisConfigurator;
	
	private BlackberryProvisioningServiceStub getBlackberryProvisioningServiceStub() {
		return axisConfigurator.getBlackberryProvisioningServiceStub();
	}
	
	@Asynchronous
	public QuartzTriggerHandle processRIMEvents(@IntervalCron String cron) {
		logger.debug("Starting to process RIM Event notifications...");
		List<RIMEvent> events = bscsDao.findUnprocessedRIMEvents();
		for(RIMEvent event : events) {
			try {
				processRIMEvent(event);
			} catch(Exception e) {
				logger.error("Unable to process RIM event with ID: " + event.getId().toString() + " : " + e.getMessage());
			}
		}
		return null;
	}
	
	public void processRIMEvent(RIMEvent event) {
		String resultCode = null;
		logger.debug("Sending RIM " + event.getEventType().toString() + " notification event for MSISDN: " + event.getMsisdn() + " Event ID: " + event.getId().toString());
		if(event.getEventType().equals(RIMEventType.Activation)) resultCode = notifyRIMActivation(event);
		else if(event.getEventType().equals(RIMEventType.Deactivation)) resultCode = notifyRIMDeactivation(event);
		else if(event.getEventType().equals(RIMEventType.Resume)) resultCode = notifyRIMResumption(event);
		else if(event.getEventType().equals(RIMEventType.Suspend)) resultCode = notifyRIMSuspension(event);
		else if(event.getEventType().equals(RIMEventType.ModifyService)) resultCode = notifyRIMServiceProfileChange(event);
		else if(event.getEventType().equals(RIMEventType.ModifySIM)) resultCode= notifyRIMSIMSwap(event);
		logger.debug("Result for RIM notification event ID " + event.getId() + " is " + event.getResultCode());
	}
	
	public String notifyRIMServiceProfileChange(RIMEvent event) {
		try {
			ProvisionRequest provReq = prepareRequestHeaders("Modify", event.getId().longValue());
			List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
			ProvisionReqEntity entity = new ProvisionReqEntity();
			entity.setName("Subscriber");
			entity.setItems(prepareRequestDataItems(event.getMsisdn(), event.getImsi(), null));
			entity.setSubEntities(prepareSubEntities(event.getServiceName()));
			entities.add(entity);
			provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
			BlackberryProvisioningServiceStub stub = axisConfigurator.getBlackberryProvisioningServiceStub();
			ProvisionReply reply = stub.submitSync(provReq);
			processReply(event, reply);
		} catch(ARIProcessingException ae) {
			event.setResultCode(ae.getFaultMessage().getARIProcessingException().getErrorCode());
			event.setResultDescription(ae.getFaultMessage().getARIProcessingException().getErrorDescription());
			event.setAction("E");
		} catch (RemoteException re) {
			event.setResultCode("404");
			event.setResultDescription("Remote Exception: " + re.getMessage());
			event.setAction("R");
		} 
		bscsDao.update(event);
		return event.getResultCode();
	}
	
	public String notifyRIMSIMSwap(RIMEvent event) {
		try {
			ProvisionRequest provReq = prepareRequestHeaders("Modify", event.getId().longValue());
			List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
			ProvisionReqEntity entity = new ProvisionReqEntity();
			entity.setName("Subscriber");
			entity.setItems(prepareRequestDataItems(event.getMsisdn(), event.getImsi(), event.getOldImsi()));
			entities.add(entity);
			provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
			BlackberryProvisioningServiceStub stub = axisConfigurator.getBlackberryProvisioningServiceStub();
			ProvisionReply reply = stub.submitSync(provReq);
			processReply(event, reply);
		} catch(ARIProcessingException ae) {
			event.setResultCode(ae.getFaultMessage().getARIProcessingException().getErrorCode());
			event.setResultDescription(ae.getFaultMessage().getARIProcessingException().getErrorDescription());
			event.setAction("E");
		} catch (RemoteException re) {
			event.setResultCode("404");
			event.setResultDescription("Remote Exception: " + re.getMessage());
			event.setAction("R");
		} 
		bscsDao.update(event);
		return event.getResultCode();
	}

	public String notifyRIMActivation(RIMEvent event) {
		try {
			ProvisionRequest provReq = prepareRequestHeaders("Activate", event.getId().longValue());
			List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
			ProvisionReqEntity entity = new ProvisionReqEntity();
			entity.setName("Subscriber");
			entity.setItems(prepareRequestDataItems(event.getMsisdn(), event.getImsi(), null));
			entity.setSubEntities(prepareSubEntities(event.getServiceName()));
			entities.add(entity);
			provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
			BlackberryProvisioningServiceStub stub = axisConfigurator.getBlackberryProvisioningServiceStub();
			ProvisionReply reply = stub.submitSync(provReq);
			processReply(event, reply);
		} catch(ARIProcessingException ae) {
			event.setResultCode(ae.getFaultMessage().getARIProcessingException().getErrorCode());
			event.setResultDescription(ae.getFaultMessage().getARIProcessingException().getErrorDescription());
			event.setAction("E");
		} catch (RemoteException re) {
			event.setResultCode("404");
			event.setResultDescription("Remote Exception: " + re.getMessage());
			event.setAction("R");
		} 
		bscsDao.update(event);
		return event.getResultCode();
	}
	
	public String notifyRIMDeactivation(RIMEvent event) {
		try {
			ProvisionRequest provReq = prepareRequestHeaders("Cancel", event.getId().longValue());
			List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
			ProvisionReqEntity entity = new ProvisionReqEntity();
			entity.setName("Subscriber");
			entity.setItems(prepareRequestDataItems(event.getMsisdn(), event.getImsi(), null));
			entities.add(entity);
			provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
			BlackberryProvisioningServiceStub stub = axisConfigurator.getBlackberryProvisioningServiceStub();
			ProvisionReply reply = stub.submitSync(provReq);
			processReply(event, reply);
		} catch(ARIProcessingException ae) {
			event.setResultCode(ae.getFaultMessage().getARIProcessingException().getErrorCode());
			event.setResultDescription(ae.getFaultMessage().getARIProcessingException().getErrorDescription());
			event.setAction("E");
		} catch (RemoteException re) {
			event.setResultCode("404");
			event.setResultDescription("Remote Exception: " + re.getMessage());
			event.setAction("R");
		} 
		bscsDao.update(event);
		return event.getResultCode();
	}
	
	public String notifyRIMResumption(RIMEvent event) {
		try {
			ProvisionRequest provReq = prepareRequestHeaders("Resume", event.getId().longValue());
			List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
			ProvisionReqEntity entity = new ProvisionReqEntity();
			entity.setName("Subscriber");
			entity.setItems(prepareRequestDataItems(event.getMsisdn(), event.getImsi(), null));
			entities.add(entity);
			provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
			BlackberryProvisioningServiceStub stub = axisConfigurator.getBlackberryProvisioningServiceStub();
			ProvisionReply reply = stub.submitSync(provReq);
			processReply(event, reply);
		} catch(ARIProcessingException ae) {
			event.setResultCode(ae.getFaultMessage().getARIProcessingException().getErrorCode());
			event.setResultDescription(ae.getFaultMessage().getARIProcessingException().getErrorDescription());
			event.setAction("E");
		} catch (RemoteException re) {
			event.setResultCode("404");
			event.setResultDescription("Remote Exception: " + re.getMessage());
			event.setAction("R");
		} 
		bscsDao.update(event);
		return event.getResultCode();
	}
	
	public String notifyRIMSuspension(RIMEvent event) {
		try {
			ProvisionRequest provReq = prepareRequestHeaders("Suspend", event.getId().longValue());
			List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
			ProvisionReqEntity entity = new ProvisionReqEntity();
			entity.setName("Subscriber");
			entity.setItems(prepareRequestDataItems(event.getMsisdn(), event.getImsi(), null));
			entities.add(entity);
			provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
			BlackberryProvisioningServiceStub stub = axisConfigurator.getBlackberryProvisioningServiceStub();
			ProvisionReply reply = stub.submitSync(provReq);
			processReply(event, reply);
		} catch(ARIProcessingException ae) {
			event.setResultCode(ae.getFaultMessage().getARIProcessingException().getErrorCode());
			event.setResultDescription(ae.getFaultMessage().getARIProcessingException().getErrorDescription());
			event.setAction("E");
		} catch (RemoteException re) {
			event.setResultCode("404");
			event.setResultDescription("Remote Exception: " + re.getMessage());
			event.setAction("R");
		} 
		bscsDao.update(event);
		return event.getResultCode();
	}
	
	private ProvisionRequest prepareRequestHeaders(String transactionType, Long transactionId) {
		ProvisionRequest provReq = new ProvisionRequest();
		provReq.setTransactionId(transactionId.toString());
		provReq.setTransactionType(transactionType);
		provReq.setVersion("1.2");
		provReq.setProductType("BlackBerry");
		ProvisionSender sender = new ProvisionSender();
		sender.setId("mCel");
		sender.setName("mCel");
		sender.setLoginId("fatih");
		sender.setPassword("Password12");
		ProvisionReqHeader header = new ProvisionReqHeader();
		header.setSender(sender);
		header.setTimeFormat("CCYY-MM-DDThh:mm:ssTZD");
		DateFormat dfmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		header.setTimeStamp(dfmt.format(new Date()));
		provReq.setHeader(header);
		return provReq;
	}
	
	private ProvisionDataItem[] prepareRequestDataItems(String msisdn, String imsi, String oldImsi) {
		List<ProvisionDataItem> items = new ArrayList<ProvisionDataItem>();
		ProvisionDataItem item = new ProvisionDataItem();
		item.setName("IMSI");
		item.setData(imsi);
		items.add(item);
		item = new ProvisionDataItem();
		item.setName("MSISDN");
		item.setData(msisdn);
		items.add(item);
		if(oldImsi != null) {
			item = new ProvisionDataItem();
			item.setName("OldBillingId");
			item.setData(oldImsi);
			items.add(item);
		}
		return items.toArray(new ProvisionDataItem[items.size()]);		
	}
	
	private ProvisionReqEntity[] prepareSubEntities(String serviceName) {
		ProvisionReqEntity subEntity = new ProvisionReqEntity();
		subEntity.setName("Service");
		ProvisionDataItem item = new ProvisionDataItem();
		item.setName("ServiceName");
		item.setData(serviceName);
		subEntity.addItems(item);
		return new ProvisionReqEntity[] {subEntity};
	}
	
	private void processReply(RIMEvent event, ProvisionReply reply) {
		try {	
			ProvisionReplyEntity[] repEntity = reply.getBody();
			if(repEntity[0].getResultCode() != null) {
				event.setResultCode(repEntity[0].getResultCode().getErrorCode());
				event.setResultDescription(repEntity[0].getResultCode().getErrorDescription());
			} else if(reply.getHeader().getResultCodes() != null) {
				event.setResultCode(reply.getHeader().getResultCodes()[0].getErrorCode());
				event.setResultDescription(reply.getHeader().getResultCodes()[0].getErrorDescription());
			} else if(repEntity[0].getSubEntities().length > 0) {
				event.setResultCode(repEntity[0].getSubEntities()[0].getResultCode().getErrorCode());
				event.setResultDescription(repEntity[0].getSubEntities()[0].getResultCode().getErrorDescription());
			}
			if(event.getResultCode().equals("0")) event.setAction("OK");
			else event.setAction("E");
		} catch(Exception e) {
			logger.debug("Error in processing reply for RIM event ID: " + event.getId().toString());
			e.printStackTrace();
		}
	}
	
	
}
