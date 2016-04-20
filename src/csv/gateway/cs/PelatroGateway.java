package csv.gateway.cs;

import java.io.Serializable;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.bridge.pelatro.command.AcceptOfferCommand;
import com.bridge.pelatro.command.CommandFactory;
import com.bridge.pelatro.command.RetrieveOffersCommand;
import com.bridge.pelatro.command.RetrieveOptInOffersCommand;
import com.bridge.pelatro.exception.InvalidOfferException;
import com.bridge.pelatro.exception.MSISDNNotFoundException;
import com.bridge.pelatro.model.OfferBouquet;
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
	
	@In("#{pelatroCommandFactory2}")
	private CommandFactory commandFactory2;
	
	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public CommandFactory getCommandFactory2() {
		return commandFactory2;
	}

	public void setCommandFactory2(CommandFactory commandFactory2) {
		this.commandFactory2 = commandFactory2;
	}

	public RecentSubscriberActivity retrieveRecentActivity(String msisdn) {
		RecentSubscriberActivity resp = null;
		try {
			RetrieveOffersCommand cmd = commandFactory.getRetrieveOffersCommand(msisdn, 1);
			cmd.execute();
			resp = cmd.getRecentSubscriberActivity();
		} catch(MSISDNNotFoundException nfe) {
			throw new RuntimeException("No campaign activity history found for this subscriber..");
		} catch(Exception e) {
			logger.error("Could not get activity history from Campaign Management System: ", e.getMessage());
			throw new RuntimeException("Could not get activity history from Campaign Management System: " + e.getMessage());
		}
		return resp;
	}
	
	public OfferBouquet retrieveOptionalOffers(String msisdn) {
		OfferBouquet resp = null;
		try {
			RetrieveOptInOffersCommand cmd = commandFactory2.getRetrieveOptInOffersCommand(msisdn);
			cmd.execute();
			resp = cmd.getOfferBouquet();
		} catch(MSISDNNotFoundException nfe) {
			throw new RuntimeException("No optional campaign offers found for this subscriber..");
		} catch(Exception e) {
			logger.error("Could not get Optional Offers from Campaign Management System: ", e.getMessage());
			throw new RuntimeException("Could not get Optional Offers from Campaign Management System: " + e.getMessage());
		}
		return resp;
	}
	
	public void acceptOffer(String offerId, String msisdn) {
		try {
			AcceptOfferCommand cmd = commandFactory2.getAcceptOfferCommand(msisdn, offerId);
			cmd.execute();
		} catch(MSISDNNotFoundException nfe) {
			throw new RuntimeException("Subscriber not found in Campaign Management System..");
		} catch(InvalidOfferException ioe) {
			throw new RuntimeException("Invalid offer!!");
		} catch(Exception e) {
			logger.error("Could not activate offer in Campaign Management System: ", e.getMessage());
			throw new RuntimeException("Could not activate offer in Campaign Management System: " + e.getMessage());
		}
	}

}
