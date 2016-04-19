package csv.gateway.cs;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.bridge.pelatro.command.CommandFactory;
import com.bridge.pelatro.command.RetrieveOffersCommand;
import com.bridge.pelatro.model.RecentSubscriberActivity;
import com.bridge.pelatro.model.RecentSubscriberActivityResponse;

@Name("pelatroGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class PelatroGateway implements Serializable {

	@Logger
	protected Log logger;
	
	@In("#{pelatroCommandFactory}")
	private CommandFactory commandFactory;
	
	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}

	public RecentSubscriberActivity retrieveRecentActivity(String msisdn) {
		RecentSubscriberActivity resp = null;
		try {
			RetrieveOffersCommand cmd = commandFactory.getRetrieveOffersCommand(msisdn, 1);
			cmd.execute();
			resp = cmd.getRecentSubscriberActivity();
		} catch(Exception e) {
			logger.error("Could not get activity history from Campaign Management System: ", e.getMessage());
			throw new RuntimeException("Could not get activity history from Campaign Management System: " + e.getMessage());
		}
		return resp;
	}

}
