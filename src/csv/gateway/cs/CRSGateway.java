package csv.gateway.cs;

import java.io.Serializable;
import java.util.Date;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import com.bridge.crs.command.CommandFactory;
import com.bridge.crs.command.RetrieveSubscriptionHistoryCommand;
import com.bridge.crs.command.RetrieveTransactionDetailsCommand;
import com.bridge.crs.model.SubscriptionHistory;
import com.bridge.crs.model.TransactionDetails;
@Name("crsGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class CRSGateway implements Serializable {

	@Logger
	protected Log logger;
	
	@In("#{crsCommandFactory}")
	private CommandFactory commandFactory;

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public SubscriptionHistory retrieveSubscriptionHistory(String msisdn, Date startDate, Date endDate) {
		SubscriptionHistory history = null;
		try {
			RetrieveSubscriptionHistoryCommand cmd = commandFactory.getRetrieveSubscriptionHistoryCommand(msisdn, startDate, endDate);
			cmd.execute();
			history = cmd.getSubscriptionHistory();
		} catch(Exception e) {
			logger.error("Could not get account history from CRS: ", e.getMessage());
			throw new RuntimeException("Could not get account history from CRS: " + e.getMessage());
		}
		return history;
	}
	
	public TransactionDetails retrieveTransactionDetails(String transactionId) {
		TransactionDetails tr = null;
		try {
			RetrieveTransactionDetailsCommand cmd = commandFactory.getRetrieveTransactionDetailsCommand(transactionId);
			cmd.execute();
			tr = cmd.getTransactionDetails();
		} catch(Exception e) {
			logger.error("Could not get event details from CRS: ", e.getMessage());
			throw new RuntimeException("Could not get event details for event id: " + transactionId + " from CRS: " + e.getMessage());
		}
		return tr;
	}
	
	
}
