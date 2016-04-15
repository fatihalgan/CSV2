package csv.gateway.smsc;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.bridge.arete.smsc.command.CancelMessagesCommand;
import com.bridge.arete.smsc.command.CommandFactory;
import com.bridge.arete.smsc.command.QueryMessageQueueCommand;
import com.bridge.arete.smsc.command.RetryMessagesCommand;
import com.bridge.arete.smsc.serializer.SMSCResponse;


@Name("smscGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class SMSCGateway implements Serializable {

	private static final long serialVersionUID = -3861234482865266601L;

	@Logger
	protected Log logger;
	
	@In("#{smscCommandFactory}")
	private CommandFactory commandFactory;
	
	public SMSCGateway() {
		super();
	}

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public boolean hasPendingMessages(String msisdn) {
		try {
			for(int i = 1; i < 3; i++) {
				QueryMessageQueueCommand cmd = commandFactory.getQueryMessageQueueCommand(msisdn, i);
				SMSCResponse resp = cmd.execute();
				if(resp.isQueryResultNotEmpty()) return true;
			}
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException("Could not retrieve pending SMS info from SMSC: " + e.getMessage());
		}
		return false;
	}
	
	public boolean retryMessages(String msisdn) {
		boolean retrySuccess = true;
		try {
			for(int i = 1; i < 3; i++) {
				RetryMessagesCommand cmd = commandFactory.getRetryMessagesCommand(msisdn, i);
				SMSCResponse resp = cmd.execute();
				if(!resp.isRetrySuccess()) retrySuccess = false;
			}
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException("Could not retrieve pending SMS info from SMSC: " + e.getMessage());
		}
		return retrySuccess;
	}
	
	public boolean cancelMessages(String msisdn) {
		boolean cancelSuccess = true;
		try {
			for(int i = 1; i < 3; i++) {
				CancelMessagesCommand cmd = commandFactory.getCancelMessagesCommand(msisdn, i);
				SMSCResponse resp = cmd.execute();
				if(!resp.isCancelSuccess()) cancelSuccess = false;
			}
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException("Could not retrieve pending SMS info from SMSC: " + e.getMessage());
		}
		return cancelSuccess;
	}
}
