package csv.gateway.voicemail;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.bridge.arete.reflection.serializer.ReflectionResponse;
import com.bridge.arete.telnet.exception.TelnetException;
import com.bridge.arete.voicemail.command.AbstractVoiceMailCommand;

@Name("voiceMailGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class VoiceMailGateway implements Serializable {

	private static final int MSISDN_NOT_FOUND_ERROR_CODE = 100503;
	
	@Logger
	protected Log logger;
	
	@In("#{voiceCommandFactory}")
	private com.bridge.arete.voicemail.command.CommandFactory voiceMailCommandFactory;

	public com.bridge.arete.voicemail.command.CommandFactory getVoiceMailCommandFactory() {
		return voiceMailCommandFactory;
	}

	public void setVoiceMailCommandFactory(
			com.bridge.arete.voicemail.command.CommandFactory voiceMailCommandFactory) {
		this.voiceMailCommandFactory = voiceMailCommandFactory;
	}
	
	public VoiceMailGateway() {
		super();
	}
	
	public ReflectionResponse readSubscriberSettings(String msisdn) {
		try {
			ReflectionResponse resp;
			AbstractVoiceMailCommand cmd = voiceMailCommandFactory.getGenericVoiceMailCommand("R", msisdn,"");
			resp = cmd.execute();
			if(null != resp.getResponseCode() && 0 != resp.getResponseCode().intValue()){
				if(MSISDN_NOT_FOUND_ERROR_CODE != resp.getResponseCode().intValue())
					throw new RuntimeException("ERROR from Voice Mail Service readSubscriberSettings. RetCode="+resp.getResponseCode());
			}
			return resp;
		} catch(TelnetException te)  {
			logger.error("Telnet Exception on VoiceMail Gateway: ", te.getMessage());
			throw new RuntimeException("Connection error while communicating with VoiceMail server:  " + te.getMessage());
		}
	}
	
	public void setSubscriberSettings(String type, String msisdn, String arguments) throws TelnetException {
		ReflectionResponse resp;
		AbstractVoiceMailCommand cmd = voiceMailCommandFactory.getGenericVoiceMailCommand(type, msisdn, arguments);
		resp = cmd.execute();
		if(null == resp.getResponseCode() || 0 != resp.getResponseCode().intValue()){
			throw new RuntimeException("ERROR from Reflection Service setSubscriberSettings. RetCode="+resp.getResponseCode());
		}
	}
	
	public void resetVoiceMailConnections(){
		voiceMailCommandFactory.resetConnections();
	}
	
	public boolean pingVoiceMail() throws TelnetException{
		return voiceMailCommandFactory.getHelpCommand().execute().getResponse().length()>0;
	}
	
	public void disconnect() {
		voiceMailCommandFactory.disconnect();
	}
}
