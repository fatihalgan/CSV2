package csv.gateway.hlr;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.core.Events;
import org.jboss.seam.log.Log;

import co.mcel.mz.bb4p.service.exception.EmaException;

import com.bridge.arete.ema.command.AbstractEmaCommand;
import com.bridge.arete.ema.command.CommandFactory;
import com.bridge.arete.ema.command.EmaTokens;
import com.bridge.arete.ema.command.HLRSubCommand;
import com.bridge.arete.ema.model.HLRSub;
import com.bridge.arete.ema.serializer.EmaResponse;
import com.bridge.arete.ema.serializer.EmaResponseAdapter;
import com.bridge.arete.telnet.exception.TelnetException;

import csv.common.domain.EMAOperation;

@Name("emaGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class EMAGateway implements Serializable {

	@Logger
	protected Log logger;
	
	@In("#{emaCommandFactory}")
	private CommandFactory commandFactory;
	
	public EMAGateway() {
		super();
	}

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public HLRSub getHLRSub(String msisdn) {
		try {
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(msisdn,null);
			HLRSub result = EMAResponseAdapter.getHLRSub(cmd.execute());
			logger.debug(result.getMessage());
			return result;
		} catch(TelnetException te) {
			logger.error(te);
			throw new RuntimeException("EMA Communication Error: " + te.getMessage());
		}
	}
	
	public String getImsiForMsisdn(String msisdn) throws EmaException {
		try {
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(msisdn, null);
			EmaResponse response = cmd.execute();
			logger.debug(response.getResponse());
			if(response.getResponseCode() != 0) throw new EmaException(response.getResponseCode());
			return response.getValue(EmaTokens.Imsi.toString());
		} catch(TelnetException te) {
			logger.error(te);
			throw new RuntimeException("EMA Communication Error: " + te.getMessage());
		}
	}
	
	public void setHLRSub(String msisdn, HLRSub hlrSub) {
		try {
			hlrSub.setMsisdn(msisdn);
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(false, hlrSub);
			//if(null != hlrSub.getBaoc() && 0==cmd.execute().getResponseCode()) { 
				//TODO add consecutive command execution to arete...
				//hlrSub.setBaoc(hlrSub.getBaoc().substring(0,4) + "TS20");
				//cmd = commandFactory.getHLRSubCommand(false, hlrSub);
			//}
			
			EmaResponse response = cmd.execute();
			if(response.getResponseCode() != 0) throw new RuntimeException("EMA SetHRLSub operation failed. EMA Response Code: " + response.getResponseCode());
		} catch(TelnetException te) {
			logger.error(te);
			throw new RuntimeException("EMA Communication Error: " + te.getMessage());
		}
	}
	
	public EmaResponse getHLRImsi(String imsi) {
		try {
			HLRSub hlrSub = new HLRSub();
			hlrSub.setImsi(imsi);
			HLRSubCommand cmd = commandFactory.getHLRSubCommand(true, hlrSub);
			EmaResponse response = cmd.execute();
			return response;
		} catch(TelnetException te) {
			logger.error(te);
			throw new RuntimeException("EMA Communication Error: " + te.getMessage());
		}
	}
	
	public void registerBlackbberyAPN(String msisdn) throws EmaException {
		try {
			HLRSub hlrSub = new HLRSub(24);//OpCode for Activate Blackberry
			hlrSub.setMsisdn(msisdn);
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(false, hlrSub);
			EmaResponse resp = cmd.execute();
			if(resp.getResponseCode() == 10437) return; //APN already exists
			if(resp.getResponseCode() != 0) throw new EmaException(resp.getResponseCode());
		} catch(TelnetException te) {
			logger.error(te);
			throw new EmaException(404, "EMA Communication Error: " + te.getMessage());
		}
	}
	
	public void unregisterBlackberryAPN(String msisdn) throws EmaException {
		try {
			HLRSub hlrSub = new HLRSub(25);//OpCode for Deactivate Blackberry;
			hlrSub.setMsisdn(msisdn);
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(false, hlrSub);
			EmaResponse resp = cmd.execute();
			if(resp.getResponseCode() == 14) return; //Subscriber does not exist in HLR anymore
			if(resp.getResponseCode() == 10222) return; //PDPContext already inactive
			if(resp.getResponseCode() != 0) throw new EmaException(resp.getResponseCode());
		} catch(TelnetException te) {
			logger.error(te);
			throw new EmaException(404, "EMA Communication Error: " + te.getMessage());
		}
	}
	
	public void unbarOutgoingServicesForProvisioning(String msisdn) throws EmaException {
		try {
			HLRSub hlrSub = new HLRSub(4);//OpCode for unbarring voice and SMS
			//HLRSub hlrSub = new HLRSub(32);//OpCode for unbarring voice and SMS
			hlrSub.setMsisdn(msisdn);
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(false, hlrSub);
			EmaResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new EmaException(resp.getResponseCode());
		} catch(TelnetException te) {
			logger.error(te);
			throw new EmaException(404, "EMA Communication Error: " + te.getMessage());
		}
	}
	
	public boolean isPrepaidSubscriber(String msisdn) throws EmaException {
		try {
			HLRSub hlrSub = new HLRSub();
			hlrSub.setMsisdn(msisdn);
			AbstractEmaCommand cmd = commandFactory.getHLRSubCommand(true, hlrSub);
			EmaResponse resp = cmd.execute();
			if(resp.getResponseCode() != 0) throw new EmaException(resp.getResponseCode());
			Integer csp = new EmaResponseAdapter().getCsp(resp);
			if(csp != null) return true;
			else return false;
		} catch(TelnetException te) {
			logger.error(te);
			throw new EmaException(404, "EMA Communication Error: " + te.getMessage());
		}
	}
}
