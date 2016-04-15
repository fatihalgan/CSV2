package csv.prepaid.domain.simreg.activation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.bridge.ena.cs.command.AbstractCSCommand;
import com.bridge.ena.cs3cp6.command.CommandFactory;
import com.bridge.ena.cs3cp6.command.GenericUpdateBalanceAndDateCommand;
import com.bridge.ena.cs3cp6.value.DedicatedAccountInformation;

public class SIMActivationAdjustment implements Serializable {

	private Set<AccountAdjustment> accountAdjustments = new TreeSet<AccountAdjustment>();
	
	public SIMActivationAdjustment() {
		super();
	}

	public Set<AccountAdjustment> getAccountAdjustments() {
		return accountAdjustments;
	}

	public void setAccountAdjustments(Set<AccountAdjustment> accountAdjustments) {
		this.accountAdjustments = accountAdjustments;
	}
	
	public void addAccountAdjustment(AccountAdjustment adj) {
		getAccountAdjustments().add(adj);
	}
	
	public void removeAccountAdjustment(AccountAdjustment adj) {
		getAccountAdjustments().remove(adj);
	}
	
	public AbstractCSCommand getCSCommand(CommandFactory cmdFactory, String msisdn) {
		String originTransId = String.valueOf(System.currentTimeMillis());
		AccountAdjustment mainAccountAdjustment = getMainAccountAdjustment();
		Float mainAccAdjustmentAmount = 0f;
		if(mainAccountAdjustment != null) mainAccAdjustmentAmount = mainAccountAdjustment.getAdjustmentAmount();
		List<DedicatedAccountInformation> dai = prepareDedicatedAccountAdjustments();
		GenericUpdateBalanceAndDateCommand cmd = cmdFactory.getGenericUpdateBalanceAndDateCommand(originTransId, new Date(), msisdn, mainAccAdjustmentAmount, "SIM Card Activation", "", 0, 0, 100f, dai);
		return cmd;
	}
	
	private AccountAdjustment getMainAccountAdjustment() {
		for(AccountAdjustment adj : accountAdjustments) {
			if(adj.getAccountId() == 0) return adj;
		}
		return null;
	}
	
	private List<DedicatedAccountInformation> prepareDedicatedAccountAdjustments() {
		List<DedicatedAccountInformation> dedicatedAccounts = new ArrayList<DedicatedAccountInformation>();
		for(AccountAdjustment adj : accountAdjustments) {
			if(adj.getAccountId() == 0) continue;
			DedicatedAccountInformation dai = new DedicatedAccountInformation();
			dai.setDedicatedAccountId(adj.getAccountId());
			dai.setDedicatedAccountValue(adj.getAdjustmentAmount());
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, adj.getExpiryDays());
			Date newExpiryDate = cal.getTime();
			dai.setExpiryDate(newExpiryDate);
			dedicatedAccounts.add(dai);
		}
		return dedicatedAccounts;
	}

}
