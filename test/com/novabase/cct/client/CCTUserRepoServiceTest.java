package com.novabase.cct.client;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.junit.Before;

import com.novabase.cct.types.ErrorInfo;

import junit.framework.TestCase;

public class CCTUserRepoServiceTest extends TestCase {

	CCT_UserRepoServiceStub stub = null;
	public static String CLIENT_REPOSITORY_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF";
	public static String AXIS_CONFIG_PATH = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF/conf/axis2.xml";
	public static String RAMPART_CONFIG = "D:/RHDSWorkspaces/MCel/CSV2/CSV/resources/WEB-INF/clients/cct_user_repo_policy_config.xml";
	
	@Before
	public void setUp() throws Exception {
		ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(CLIENT_REPOSITORY_PATH, AXIS_CONFIG_PATH);
		//stub = new CCT_UserRepoServiceStub(ctx, "http://10.100.51.105/WSmCelCCS2/Service1.svc");
		stub = new CCT_UserRepoServiceStub(ctx, "http://localhost:8081/WSmCelCCS2/Service1.svc");
		//stub = new CCT_UserRepoServiceStub(ctx, "http://localhost:8081/CCT/services/WSmCelCCS2");
		InputStream in = new FileInputStream(RAMPART_CONFIG);
		StAXOMBuilder builder = new StAXOMBuilder(in);
		OMElement configElement = builder.getDocumentElement();
		Policy rampartConfig = PolicyEngine.getPolicy(configElement);
		stub._getServiceClient().getAxisService().getPolicySubject().attachPolicy(rampartConfig);
	}
	
	public void testCreateUser() {
		try {
			ErrorInfo info = stub.agentInsert("db2admin", "db2pass", "falgan@hotmail.com");
			System.out.println(info.getErrorCode() + ": " + info.getErrorDescription());
			assertEquals(info.getErrorCode(), 0);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
