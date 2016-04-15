package csv.gateway.bb4p;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;

import com.bridge.likya.bbfp.command.ActivateAccountCommand;
import com.bridge.likya.bbfp.command.CommandFactory;
import com.bridge.likya.bbfp.command.DeactivateAccountCommand;
import com.bridge.likya.bbfp.command.GetAccountInfoCommand;
import com.bridge.likya.bbfp.command.LoginCommand;
import com.bridge.likya.bbfp.command.RefundReservationCommand;
import com.bridge.likya.bbfp.command.SuspendAccountCommand;
import com.bridge.likya.bbfp.command.TicketHistoryCommand;
import com.bridge.likya.bbfp.exceptions.AuthenticationFailureException;
import com.bridge.likya.bbfp.model.AccountInfo;
import com.bridge.likya.bbfp.model.AccountStatus;
import com.bridge.likya.bbfp.model.DetailedCDR;
import com.bridge.likya.bbfp.model.DurationType;

public class BB4PGateway implements Serializable {

	@Logger
	protected Log logger;
	
	@In("#{bb4pCommandFactory}")
	private CommandFactory commandFactory;

	private String username;
	private String password;
	
	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private void login() {
		LoginCommand cmd = commandFactory.getLoginCommand(username, password);
		try {
			cmd.execute();
		} catch(AuthenticationFailureException e) {
			throw new RuntimeException("Authentication faled on BB4P system: " + e.getMessage());
		} catch(Exception e) {
			throw new RuntimeException("Cannot login to BB4P system: " + e.getMessage());
		}
	}
	
	public AccountInfo getAccountInfo(String msisdn) {
		AccountInfo accountInfo = null;
		GetAccountInfoCommand cmd = commandFactory.getAccountInfoCommand(msisdn);
		try {
			login();
			cmd.execute();
			accountInfo = cmd.getAccountInfo();
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return accountInfo;
	}
	
	public List<DetailedCDR> getTicketsHistory(String msisdn, Date startDate, Date endDate) {
		TicketHistoryCommand cmd = commandFactory.getTicketHistoryCommand(msisdn, startDate, endDate);
		try {
			login();
			cmd.execute();
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return cmd.getHistory();
	}
	
	public void activateAccount(String msisdn, float volume, String comOffer, DurationType durationType, int duration) {
		ActivateAccountCommand cmd = commandFactory.getActivateAccountCommand(msisdn, "*", duration, durationType, volume, comOffer, "*");
		GetAccountInfoCommand accountInfoCmd = commandFactory.getAccountInfoCommand(msisdn);
		try {
			login();
			accountInfoCmd.execute();
			AccountInfo accountInfo = accountInfoCmd.getAccountInfo();
			if(accountInfo.getStatus().equals(AccountStatus.REGISTERING)) throw new RuntimeException("Account is already in REGISTERING state and being activated by the system");
			cmd.execute();
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void deactivateAccount(String msisdn) {
		DeactivateAccountCommand cmd = commandFactory.getDeactivateAccountCommand(msisdn);
		try {
			login();
			cmd.execute();
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void suspendAccount(String msisdn) {
		SuspendAccountCommand cmd = commandFactory.getSuspendAccountCommand(msisdn);
		try {
			login();
			cmd.execute();			
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void refundReservation(String msisdn, String transactionId) {
		RefundReservationCommand cmd = commandFactory.getRefundReservationCommand(msisdn, transactionId);
		try {
			login();
			cmd.execute();
		} catch(Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}
