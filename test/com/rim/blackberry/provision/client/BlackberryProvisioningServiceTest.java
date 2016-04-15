
/**
 * BlackberryProvisioningServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package com.rim.blackberry.provision.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;

import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReqEntity;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReqHeader;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest;
import com.rim.blackberry.provision.control.ari.comm.soap.ProvisionSender;

/*
 *  BlackberryProvisioningServiceTest Junit test case
 */

public class BlackberryProvisioningServiceTest extends junit.framework.TestCase {

	BlackberryProvisioningServiceStub stub = null;
	private String msisdn = "823086864";
	private String imsi = "643012203411929";
	private String newImsi = "643012202345679";
	private String serviceName = "Enterprise Plus B";
	private String newServiceName = "Prosumer B";
	
	public static String CLIENT_REPOSITORY_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF";
	public static String AXIS_CONFIG_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF/conf/axis2.xml";
	public static String RAMPART_CONFIG = "D:/RHDSWorkspaces/MCel/CSV2/CSV/test/rampart-config.xml";
	
	public void setUp() throws Exception {
		ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(CLIENT_REPOSITORY_PATH, AXIS_CONFIG_PATH);
		stub = new BlackberryProvisioningServiceStub(ctx, "https://mcel.provisioning.blackberry.com/ws-doc-literal/Provisioning");
		//stub = new BlackberryProvisioningServiceStub("https://localhost:443/ws-doc-literal/Provisioning");
	}
	
	public void tearDown() {
		stub = null;
	}
	
	private ProvisionRequest prepareRequestHeaders(String transactionType) {
		ProvisionRequest provReq = new ProvisionRequest();
		provReq.setTransactionId(String.valueOf(System.currentTimeMillis()));
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
	
	private ProvisionReply getStatus(String msisdn, String imsi) throws Exception {
		ProvisionRequest provReq = prepareRequestHeaders("Status");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Subscriber");
		entity.setItems(prepareRequestDataItems(msisdn, imsi, null));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		return reply;
	}
	
	private void printStatus(ProvisionReplyEntity[] reply) {
		System.out.print("Subscriber status is: " );
		System.out.println(reply[0].getResultCode().getStatusDescription());
		for(ProvisionReplyEntity entity : reply) {
			System.out.print("Entity Name: ");
			System.out.println(entity.getName());
			for(ProvisionDataItem item : entity.getItems()) {
				System.out.print("     " + item.getName() + ": ");
				System.out.println(item.getData());
			}
		}
	}
	
	private void assertSuccess(ProvisionReply reply) throws Exception {
		ProvisionReplyEntity[] repEntity = reply.getBody();
		System.out.print("Result: ");
		System.out.println(repEntity[0].getResultCode().getErrorDescription());
		assertTrue(repEntity[0].getResultCode().getErrorCode().equals("0"));	
	}
	
	
	public void testActivateService() throws Exception {
		System.out.println("Test Activate Blackberry Service..");
		try {
		ProvisionRequest provReq = prepareRequestHeaders("Activate");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Subscriber");
		entity.setItems(prepareRequestDataItems(msisdn, imsi, null));
		entity.setSubEntities(prepareSubEntities(serviceName));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		System.out.println(reply.getHeader().getMajorErrCode());
		assertSuccess(reply);
		reply = getStatus(msisdn, imsi);
		printStatus(reply.getBody());
		} catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	public void testSuspendService() throws Exception {
		System.out.println("Test Suspend Blackberry Service..");
		ProvisionRequest provReq = prepareRequestHeaders("Suspend");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Subscriber");
		entity.setItems(prepareRequestDataItems(msisdn, imsi, null));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		assertSuccess(reply);
		reply = getStatus(msisdn, imsi);
		printStatus(reply.getBody());
	}
	**/
	/**
	public void testResumeService() throws Exception {
		System.out.println("Test Resume Blackberry Service..");
		ProvisionRequest provReq = prepareRequestHeaders("Resume");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Subscriber");
		entity.setItems(prepareRequestDataItems(msisdn, imsi, null));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		assertSuccess(reply);
		reply = getStatus(msisdn, imsi);
		printStatus(reply.getBody());
	}
	**/
	
	public void testChangeServiceProfile() throws Exception {
		System.out.println("Test Modify Blackberry Service Profile..");
		ProvisionRequest provReq  = prepareRequestHeaders("Modify");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Subscriber");
		entity.setItems(prepareRequestDataItems(msisdn, imsi, null));
		entity.setSubEntities(prepareSubEntities(serviceName));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		assertSuccess(reply);
		reply = getStatus(msisdn, imsi);
		printStatus(reply.getBody());
	}
	
	/**
	public void testSwapSIM() throws Exception {
		System.out.println("Test Swap SIM..");
		ProvisionRequest provReq = prepareRequestHeaders("Modify");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Suscriber");
		entity.setItems(prepareRequestDataItems(msisdn, newImsi, imsi));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		assertSuccess(reply);
		reply = getStatus(msisdn, newImsi);
		printStatus(reply.getBody());
	}
	**/
	
	
	public void testDeactivateService() throws Exception {
		System.out.println("Test Cancel Blackberry Service..");
		ProvisionRequest provReq = prepareRequestHeaders("Cancel");
		List<ProvisionReqEntity> entities = new ArrayList<ProvisionReqEntity>();
		ProvisionReqEntity entity = new ProvisionReqEntity();
		entity.setName("Subscriber");
		entity.setItems(prepareRequestDataItems(msisdn, imsi, null));
		entities.add(entity);
		provReq.setBody(entities.toArray(new ProvisionReqEntity[entities.size()]));
		ProvisionReply reply = stub.submitSync(provReq);
		assertSuccess(reply);
		reply = getStatus(msisdn, newImsi);
		printStatus(reply.getBody());
	}
	
	
	public void testGetStatus() throws Exception {
		System.out.println("Interrogating subscriber status..");
		ProvisionReply reply = getStatus(msisdn, imsi);
		printStatus(reply.getBody());
	}
	
}
