package csv.gateway.cs;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;
import com.bridge.arete.minsat.command.AbstractMinsatCommand;
import com.bridge.arete.minsat.command.CommandFactory;
import com.bridge.arete.minsat.model.InitialMinsatParameters;
import com.bridge.arete.minsat.model.PaymentProfile;
import com.bridge.arete.minsat.serializer.MinsatResponse;
import com.bridge.arete.telnet.exception.TelnetException;

import csv.prepaid.domain.PrepaidAccount;

@Name("minsatGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class MINSATGateway implements Serializable {

	@Logger
	protected Log logger;
	
	@In("#{minsatCommandFactory}")
	private CommandFactory commandFactory;

	public MINSATGateway() {
		super();
	}
	
	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public PrepaidAccount getAccountInfo(String msisdn) {
		PrepaidAccount account = null;
		try {
			AbstractMinsatCommand cmd = commandFactory.getAccountInformationCommand(insertInternationPrefixIfNeeded(msisdn));
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
			account = MINSATResponseAdapter.getPrepaidAccount(resp);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return account;
	}
	
	public void changeLanguage(String msisdn, Language oldLanguage, Language newLanguage) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getSetLanguageCommand(msisdn, oldLanguage.getValue(), newLanguage.getValue());
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void changeServiceClass(String msisdn, ServiceClass oldServiceClass, ServiceClass newServiceClass) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getSetAccountServiceClassCommand(msisdn, oldServiceClass.getValue(), newServiceClass.getValue());
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void changeExpiryDates(String msisdn, Date oldServiceFeePeriodExpiryDate, Date newServiceFeePeriodExpiryDate,
		Date oldSupervisionPeriodExpiryDate, Date newSupervisionPeriodExpiryDate) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getSetAccountExpiryDateCommand(msisdn, oldServiceFeePeriodExpiryDate, newServiceFeePeriodExpiryDate, oldSupervisionPeriodExpiryDate, newSupervisionPeriodExpiryDate);
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void resetRefillBarringStatus(String msisdn) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getResetRefillBarringCommand(msisdn);
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void makeRefill(String msisdn, Integer transAmount, String paymentProfile) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getSetRefillCommand(msisdn, transAmount, 0, paymentProfile);
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Voucher getVoucher(String serialNumber) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getVoucherDetailCommand(serialNumber);
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
			Voucher voucher = MINSATResponseAdapter.getVoucher(serialNumber, resp);
			return voucher;
		} catch(TelnetException te) {
			throw new RuntimeException(te.getMessage());
		}
	}
	
	public List<PaymentProfile> getPaymentProfiles() {
		try {
			AbstractMinsatCommand cmd = commandFactory.getPaymentProfileListCommand();
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
			return MINSATResponseAdapter.getPaymentProfiles(resp);
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void setSIM(String msisdn, String imsi, String sim, String puk1, String puk2) {
		try {
			AbstractMinsatCommand cmd = commandFactory.getSetSIMCommand(msisdn, imsi, sim, puk1, puk2);
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Map<Integer, String> getCommunities() {
		try {
			AbstractMinsatCommand cmd = commandFactory.getCommunitiesCommand();
			MinsatResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new RuntimeException(resp.getResponse());
			MINSATResponseAdapter.refreshCommunitiesMap(resp);
			return InitialMinsatParameters.getCommunityMap();
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean ping() {
		try {
			AbstractMinsatCommand cmd = commandFactory.getHelpCommand();
			return 0 < cmd.execute().getResponse().length();
		} catch(Exception e) {
			return false;
		}
	}
	
	public void resetConnections(){
		commandFactory.resetConnections();
	}
	
	public void disconnect(){
		commandFactory.disconnect();
	}
	
	private String insertInternationPrefixIfNeeded(String msisdn) {
		if(msisdn.startsWith("258") && msisdn.length() == 12) return msisdn;
		else if(msisdn.length() == 9) return "258" + msisdn;
		else throw new RuntimeException("MSISDN format not recognized by MINSAT Gateway: " + msisdn);
	}
}
