package co.mcel.mz.reservedcharging.client;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.junit.Before;

import co.mcel.mz.reservedcharging.CheckStatusResponse_type0;
import co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0;
import co.mcel.mz.types.common.MsisdnType;
import junit.framework.TestCase;

public class ReserveChargingServiceTest extends TestCase {

	private MsisdnType msisdnType;
	private String reservationId = "1255691111825483564";
	ReserveChargingServiceStub stub = null;
	public static String CLIENT_REPOSITORY_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF";
	public static String AXIS_CONFIG_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF/conf/axis2.xml";
	public static String RAMPART_CONFIG = "D:/RHDSWorkspaces/MCel/CSV2/CSV/test/rampart-config.xml";
	
	@Before
	public void setUp() throws Exception {
		msisdnType = new MsisdnType();
		msisdnType.setInternationalPrefix("258");
		msisdnType.setNumber("821311476");
		ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(CLIENT_REPOSITORY_PATH, AXIS_CONFIG_PATH);
		stub = new co.mcel.mz.reservedcharging.client.ReserveChargingServiceStub(ctx, "http://localhost:8081/CSV/services/ReservedChargingService.ReservedChargingServiceHttpSoap11Endpoint");
		//stub = new co.mcel.mz.reservedcharging.client.ReserveChargingServiceStub(ctx, "http://localhost:8081/CSV/services/ReservedChargingService");
		//stub = new co.mcel.mz.reservedcharging.client.ReserveChargingServiceStub(ctx, "http://192.168.1.82:8080/CSV/services/ReservedChargingService");
		//InputStream in = new FileInputStream(RAMPART_CONFIG);
		//StAXOMBuilder builder = new StAXOMBuilder(in);
		//OMElement configElement = builder.getDocumentElement();
		//Policy rampartConfig = PolicyEngine.getPolicy(configElement);
		//stub._getServiceClient().getAxisService().getPolicySubject().attachPolicy(rampartConfig);
	}
	
	/**
	public void testReserveAmount() throws java.lang.Exception {
		boolean result = stub.reserveAmount(msisdnType, "1248708520829696726", "Bollywood", 5.0f, "Test");
		assertTrue(result);
	}
	
	
	public void testdebitAmount() throws java.lang.Exception {
		boolean result = stub.debitAmount(String.valueOf(System.currentTimeMillis()), "Bollywood");
		assertTrue(result);
	}
	
	public void testDirectDebit() throws java.lang.Exception {
		try {
			boolean result = stub.directDebit(msisdnType, "5875412369", "gameloft_mcel", 10f, "Gameloft Games");
			assertTrue(result);
		} catch(CSVSystemError e) {
			System.out.println(e.getFaultMessage().getCsvSystemError().toString());
		}
	}
	
	public void testcancelReservation() throws java.lang.Exception {
		String cancellingReservationId = String.valueOf(Long.parseLong(reservationId) + 1);
		stub.reserveAmount(msisdnType, cancellingReservationId, "Bollywood", 10f, "Test");
		boolean result = stub.cancelReservation(cancellingReservationId, "Bollywood");
		assertTrue(result);
	}
	
	public void testrefund() throws java.lang.Exception {
		String refundingReservationId = String.valueOf(Long.parseLong(reservationId + 2));
		stub.reserveAmount(msisdnType, refundingReservationId, "Bollywood", 10f, "Test");
		boolean result = stub.refund(refundingReservationId, "Bollywood");
		assertTrue(result);
	}
	**/
	public void testGetAccountType() throws java.lang.Exception {
		GetAccountTypeResponse_type0 resp = stub.getAccountType(msisdnType);
		System.out.println(resp.toString());
	}
	
	/**
	public void testCheckStatus() throws Exception {
		CheckStatusResponse_type0 resp = stub.checkStatus("123456", "ems");
		System.out.println(resp.getValue());
	}
	**/
	
}
