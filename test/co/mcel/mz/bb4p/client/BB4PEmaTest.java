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

import junit.framework.TestCase;

public class BB4PEmaTest extends TestCase {

	private MsisdnType msisdnType;
	public static String CLIENT_REPOSITORY_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF";
	public static String AXIS_CONFIG_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF/conf/axis2.xml";
	public static String RAMPART_CONFIG = "D:/RHDSWorkspaces/MCel/CSV2/CSV/test/rampart-config.xml";
	
	co.mcel.mz.bb4p.client.BB4PServiceStub stub = null;
	
	@Before
	public void setUp() throws Exception {
		ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(CLIENT_REPOSITORY_PATH, AXIS_CONFIG_PATH);
		//stub = new co.mcel.mz.bb4p.client.BB4PServiceStub("http://localhost:8080/CSV/services/BB4PService");
		stub = new co.mcel.mz.bb4p.client.BB4PServiceStub(ctx, "http://192.168.1.82:8080/CSV/services/BB4PService");
		InputStream in = new FileInputStream(RAMPART_CONFIG);
		StAXOMBuilder builder = new StAXOMBuilder(in);
		OMElement configElement = builder.getDocumentElement();
		Policy rampartConfig = PolicyEngine.getPolicy(configElement);
		stub._getServiceClient().getAxisService().getPolicySubject().attachPolicy(rampartConfig);
		msisdnType = new MsisdnType();
		msisdnType.setInternationalPrefix("258");
		msisdnType.setNumber("820851042");
		
	}
	

	public void testregisterAPN() throws java.lang.Exception {
		boolean result = stub.registerAPN(msisdnType, 15);
		assertTrue(result);
	}
	
	
	/**
	public void testunregisterAPN() throws java.lang.Exception {
		boolean result = stub.unregisterAPN(msisdnType, 15);
		System.out.println(result);
		assertTrue(result);
	}
	**/
	
	/**
	public void testgetImsi() throws java.lang.Exception {
		try {
			String result = stub.getImsi(msisdnType.getInternationalPrefix(), msisdnType.getNumber());
			System.out.println(result);
			assertNotNull(result);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	**/
	
	
}
