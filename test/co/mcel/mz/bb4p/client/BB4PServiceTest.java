
/**
 * BB4PServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.4.1  Built on : Aug 13, 2008 (05:03:35 LKT)
 */
package co.mcel.mz.bb4p.client;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.junit.Before;

import co.mcel.mz.types.common.MsisdnType;

/*
 *  BB4PServiceTest Junit test case
 */

public class BB4PServiceTest extends junit.framework.TestCase {

	private MsisdnType msisdnType;
	private String reservationId = "1279872136828223880";
	co.mcel.mz.bb4p.client.BB4PServiceStub stub = null;
	public static String CLIENT_REPOSITORY_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF";
	public static String AXIS_CONFIG_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF/conf/axis2.xml";
	public static String RAMPART_CONFIG = "D:/RHDSWorkspaces/MCel/CSV2/CSV/test/rampart-config.xml";
	
	@Before
	public void setUp() throws Exception {
		msisdnType = new MsisdnType();
		msisdnType.setInternationalPrefix("258");
		msisdnType.setNumber("826307248");
		ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(CLIENT_REPOSITORY_PATH, AXIS_CONFIG_PATH);
		stub = new co.mcel.mz.bb4p.client.BB4PServiceStub(ctx, "http://localhost:9090/CSV/services/BB4PService");
		//stub = new co.mcel.mz.bb4p.client.BB4PServiceStub(ctx, "http://192.168.1.82:8080/CSV/services/BB4PService");
		InputStream in = new FileInputStream(RAMPART_CONFIG);
		StAXOMBuilder builder = new StAXOMBuilder(in);
		OMElement configElement = builder.getDocumentElement();
		Policy rampartConfig = PolicyEngine.getPolicy(configElement);
		stub._getServiceClient().getAxisService().getPolicySubject().attachPolicy(rampartConfig);
	}
	
	/**
	public void testdebitAmount() throws java.lang.Exception {
		boolean result = stub.debitAmount(String.valueOf(System.currentTimeMillis()));
		assertTrue(result);
	}
	**/
	
	
	public void testReserveAmount() throws java.lang.Exception {
		try {
			String transId = String.valueOf(System.currentTimeMillis());
			System.out.println("Trans ID: " + reservationId);
			boolean result = stub.reserveAmount(msisdnType, transId, 180.0f);
			assertTrue(result);
		} catch(CSError error) {
			error.printStackTrace();
			fail();
		} catch(Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	/**
	public void testReserverAmount2() throws Exception {
		boolean result = stub.reserveAmount(msisdnType, String.valueOf(System.currentTimeMillis()), 0.0f);
		assertTrue(result);
	}
	
	/**
	public void testcancelReservation() throws java.lang.Exception {
		String cancellingReservationId = String.valueOf(Long.parseLong(reservationId) + 1);
		stub.reserveAmount(msisdnType, cancellingReservationId, 10f);
		boolean result = stub.cancelReservation(cancellingReservationId);
		assertTrue(result);
	}
	
	**/

	/**
	public void testrefund() throws java.lang.Exception {
		String refundingReservationId = String.valueOf(Long.parseLong("1357554047287"));
		//stub.reserveAmount(msisdnType, refundingReservationId, 10f);
		boolean result = stub.refund(refundingReservationId);
		assertTrue(result);
	}
	**/
	
	/**
	public void testgetServiceClass() throws java.lang.Exception {
		int result = stub.getServiceClass(msisdnType.getInternationalPrefix(), msisdnType.getNumber());
		assertFalse(result == 0);
	}
	**/
	
	/**
	public void testCheckStatus() throws Exception {
		CheckStatusResponse_type0 resp = stub.checkStatus("1267802988160");
		System.out.println(resp.getValue());
	}
	**/
	
}
