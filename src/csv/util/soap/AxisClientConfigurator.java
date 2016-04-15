package csv.util.soap;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import com.bridge.netmovel.client.NetmovelServiceStub;
import com.bridge.pm.client.ProvisionManagerServiceStub;
import com.bridge.simreg.client.SimRegistrationServiceStub;
import com.novabase.cct.client.CCT_UserRepoServiceStub;
import com.rim.blackberry.provision.client.BlackberryProvisioningServiceStub;

public class AxisClientConfigurator implements ServletContextAware, InitializingBean {

	private ServletContext servletContext;
	private String clientRepositoryPath;
	private String axisConfigPath;
	private String netmovelServiceEndpointAddress;
	private String provisionManagerServiceEndpointAddress;
	private String blackberryProvisioningServiceEndpointAddress;
	private String cctUserRepoServiceEndpointAddress;
	private String simRegServiceEndpointAddress;
	private String cctUserRepoServiceSecurityPolicyConfigFile;
	private ConfigurationContext configContext;
	private NetmovelServiceStub netmovelServiceStub;
	private ProvisionManagerServiceStub provisionManagerServiceStub;
	private SimRegistrationServiceStub simRegistrationServiceStub;
	private CCT_UserRepoServiceStub cctUserRepoServiceStub;
	private BlackberryProvisioningServiceStub bbpServiceStub;
	
	
	public AxisClientConfigurator() {
		super();
	}
	
	public NetmovelServiceStub getNetmovelServiceStub() {
		try {
			if(netmovelServiceStub == null) netmovelServiceStub = new NetmovelServiceStub(configContext, netmovelServiceEndpointAddress);
		} catch(AxisFault e) {
			throw new RuntimeException(e);
		}
		return netmovelServiceStub;
	}
	
	
	public ProvisionManagerServiceStub getProvisionManagerServiceStub() {
		try {
			if(provisionManagerServiceStub == null) provisionManagerServiceStub = new ProvisionManagerServiceStub(provisionManagerServiceEndpointAddress);
		} catch(AxisFault e) {
			throw new RuntimeException(e);
		}
		return provisionManagerServiceStub;
	}
	
	public BlackberryProvisioningServiceStub getBlackberryProvisioningServiceStub() {
		try {
			if(bbpServiceStub == null) bbpServiceStub = new BlackberryProvisioningServiceStub(blackberryProvisioningServiceEndpointAddress);
		} catch(AxisFault e) {
			throw new RuntimeException(e);
		}
		return bbpServiceStub;
	}
	
	public SimRegistrationServiceStub getSimRegistrationServiceStub() {
		try {
			if(simRegistrationServiceStub == null) simRegistrationServiceStub = new SimRegistrationServiceStub(simRegServiceEndpointAddress);
		} catch(AxisFault e) {
			throw new RuntimeException(e);
		}
		return simRegistrationServiceStub;
	}
	
	public CCT_UserRepoServiceStub getCCT_UserRepoServiceStub() {
		try {
			if(cctUserRepoServiceStub == null) cctUserRepoServiceStub = new CCT_UserRepoServiceStub(configContext, cctUserRepoServiceEndpointAddress);
			InputStream in = new FileInputStream(servletContext.getRealPath(cctUserRepoServiceSecurityPolicyConfigFile));
			StAXOMBuilder builder = new StAXOMBuilder(in);
			OMElement configElement = builder.getDocumentElement();
			Policy rampartConfig = PolicyEngine.getPolicy(configElement);
			cctUserRepoServiceStub._getServiceClient().getAxisService().getPolicySubject().attachPolicy(rampartConfig);
		} catch(AxisFault e) {
			throw new RuntimeException(e);
		} catch(Exception e) {
			throw new RuntimeException("Could not load the security policy file for CCT_UserRepoService: " + e.getMessage());
		}
		return cctUserRepoServiceStub;
	}

	@Override
	public void setServletContext(ServletContext ctx) {
		this.servletContext = ctx;		
	}
	
	public void setNetmovelServiceEndpointAddress(String netmovelServiceEndpointAddress) {
		this.netmovelServiceEndpointAddress = netmovelServiceEndpointAddress;
	}
	
	public void setProvisionManagerServiceEndpointAddress(String provisionManagerServiceEndpointAddress) {
		this.provisionManagerServiceEndpointAddress = provisionManagerServiceEndpointAddress;
	}
	
	public void setCctUserRepoServiceEndpointAddress(String cctUserRepoServiceEndpointAddress) {
		this.cctUserRepoServiceEndpointAddress = cctUserRepoServiceEndpointAddress;
	}
	
	public void setSimRegServiceEndpointAddress(String simRegServiceEndpointAddress) {
		this.simRegServiceEndpointAddress = simRegServiceEndpointAddress;
	}
	
	public String getBlackberryProvisioningServiceEndpointAddress() {
		return blackberryProvisioningServiceEndpointAddress;
	}

	public void setBlackberryProvisioningServiceEndpointAddress(String blackberryProvisioningServiceEndpointAddress) {
		this.blackberryProvisioningServiceEndpointAddress = blackberryProvisioningServiceEndpointAddress;
	}

	public void setClientRepositoryPath(String clientRepositoryPath) {
		this.clientRepositoryPath = clientRepositoryPath;
	}

	public void setAxisConfigPath(String axisConfigPath) {
		this.axisConfigPath = axisConfigPath;
	}
	
	public void setCctUserRepoServiceSecurityPolicyConfigFile(String cctUserRepoServiceSecurityPolicyConfigFile) {
		this.cctUserRepoServiceSecurityPolicyConfigFile = cctUserRepoServiceSecurityPolicyConfigFile;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		String realClientRepoPath = servletContext.getRealPath(clientRepositoryPath);
		String realAxisConfigPath = servletContext.getRealPath(axisConfigPath);
		configContext = ConfigurationContextFactory.createConfigurationContextFromFileSystem(realClientRepoPath, realAxisConfigPath); 
	}
}
