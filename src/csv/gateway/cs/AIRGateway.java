package csv.gateway.cs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Observer;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import co.mcel.mz.reservedcharging.service.exception.ChargingSystemException;

import com.bridge.ena.cs.command.AbstractCSCommand;
import com.bridge.ena.cs.value.FAFNumber;
import com.bridge.ena.cs3cp6.command.AbstractCS3CP6Command;
import com.bridge.ena.cs3cp6.command.AbstractRefillCommand;
import com.bridge.ena.cs3cp6.command.CommandFactory;
import com.bridge.ena.cs3cp6.value.DedicatedAccountInformation;
import com.bridge.ena.cs3cp6.value.FAFAction;
import com.bridge.ena.xmlrpc.exception.XmlRpcConnectionException;

import csv.common.domain.CurrentServedCustomer;
import csv.prepaid.domain.simreg.ServiceType;

@Name("airGateway")
@Scope(ScopeType.STATELESS)
@AutoCreate
public class AIRGateway implements Serializable {

	@Logger
	protected Log logger;
	
	@In("#{airAdjustmentCommandFactory}")
	private CommandFactory airAdjustmentCommandFactory;
	
	@In("#{airVoucherRefillCommandFactory}")
	private CommandFactory airVoucherRefillCommandFactory;
	
	@In("#{airNetmovelPrepagoCommandFactory}")
	private CommandFactory airNetmovelPrepagoCommandFactory;
	
	@In("#{airBB4PCommandFactory}")
	private CommandFactory airBB4PCommandFactory;

	public CommandFactory getAirAdjustmentCommandFactory() {
		return airAdjustmentCommandFactory;
	}

	public void setAirAdjustmentCommandFactory(
			CommandFactory airAdjustmentCommandFactory) {
		this.airAdjustmentCommandFactory = airAdjustmentCommandFactory;
	}

	public CommandFactory getAirVoucherRefillCommandFactory() {
		return airVoucherRefillCommandFactory;
	}

	public void setAirVoucherRefillCommandFactory(
			CommandFactory airVoucherRefillCommandFactory) {
		this.airVoucherRefillCommandFactory = airVoucherRefillCommandFactory;
	}

	public CommandFactory getAirNetmovelPrepagoCommandFactory() {
		return airNetmovelPrepagoCommandFactory;
	}

	public void setAirNetmovelPrepagoCommandFactory(
			CommandFactory airNetmovelPrepagoCommandFactory) {
		this.airNetmovelPrepagoCommandFactory = airNetmovelPrepagoCommandFactory;
	}

	public CommandFactory getAirBB4PCommandFactory() {
		return airBB4PCommandFactory;
	}

	public void setAirBB4PCommandFactory(CommandFactory airBB4PCommandFactory) {
		this.airBB4PCommandFactory = airBB4PCommandFactory;
	}
	
	public FaFInfo getFamilyAndFriendsNumbers(String msisdn) throws AIRException {
		AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getFaFListCommand(String.valueOf(System.currentTimeMillis()).substring(5), new Date(), msisdn);
		try {
			cmd.execute();
		} catch(XmlRpcConnectionException xe) {
			throw new RuntimeException("Cannot connect to AIR for getting FaF information");
		} catch(Exception e) {
			logger.error("Error in retrieving FaFInfo from AIR: ", e.getMessage());
			throw new RuntimeException(e);
		}
		if(cmd.isErrorOrFaultResponse()) {
			throw new AIRException(cmd.getFullResultCode(), "AIR GetFaFListCommand Command Error. ");
		}
		List<FAFNumber> fafNumbers = cmd.getFAFInformationList();
		FaFInfo result = new FaFInfo();
		result.setFafNumberList(fafNumbers);
		int lastNationalIndex = 0, lastInternationalIndex = 13;
		for(int i=0; i < 16 && i<fafNumbers.size();i++){
			int indicator = fafNumbers.get(i).getIndicator().intValue(); 
			if(indicator == 1) {
				lastNationalIndex++;
				result.setFAFNumber(lastNationalIndex - 1, fafNumbers.get(i).getMsisdn());
			} else if(indicator == 2) {
				lastInternationalIndex++;
				result.setFAFNumber(lastInternationalIndex - 1, fafNumbers.get(i).getMsisdn());
			}
						
		}
		return result;
	}
	
	private void deleteFafNumbers(String msisdn, FaFInfo fafInfo) throws AIRException {
		List<String> numsToDelete = fafInfo.getFafNumbersToDelete();
		for(String number : numsToDelete) {
			try {
				AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getUpdateFaFListCommand(String.valueOf(System.currentTimeMillis()), new Date(), msisdn, number, FAFAction.DELETE);
				cmd.execute();
				if(cmd.isErrorOrFaultResponse()) throw new AIRException(cmd.getFullResultCode());
			} catch(Exception e) {
				throw new RuntimeException("Could not delete a FaFNumber:" + number);
			}
		}
	}
	
	private void addFafNumbers(String msisdn, FaFInfo fafInfo) {
		List<String> numsToAdd = fafInfo.getFafNumbersToAdd();
		for(String number : numsToAdd) {
			try {
				AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getUpdateFaFListCommand(String.valueOf(System.currentTimeMillis()), new Date(), msisdn, number, FAFAction.ADD);
				cmd.execute();
				if(cmd.isErrorOrFaultResponse()) throw new AIRException(cmd.getFullResultCode());
			} catch(Exception e) {
				throw new RuntimeException("Could not add a FaFNumber:" + number);
			}
		}
	}
	
	public FaFInfo updateFamilyAndFriendsNumbers(String msisdn, FaFInfo fafInfo) throws AIRException {
		deleteFafNumbers(msisdn, fafInfo);
		addFafNumbers(msisdn, fafInfo);
		return getFamilyAndFriendsNumbers(msisdn);		
	}
	
	public void makeAdjustment(String originTransId, Date originTimestamp, String msisdn, Float mainAccAdjustment, 
		String username, String reason, Integer supervisionIncrease, Integer serviceFeeIncrease,
		Integer sms, Integer mms, Float freeCalls) throws AIRException {
		try {
			AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getUpdateBalanceAndDateWithFreeCallsCommand(originTransId, originTimestamp, 
				msisdn, mainAccAdjustment, username, reason, supervisionIncrease, serviceFeeIncrease, sms, mms, freeCalls, 100f);
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) {
				logger.error("Air Adjustment Error: " + cmd.getFullResultCode());
				throw new AIRException(cmd.getFullResultCode(), "Air Adjustment Error..");
			}
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void makeAdjustment(String originTransId, Date originTimestamp, String msisdn, Float mainAccAdjustment, 
		String username, String reason, Integer supervisionIncrease, Integer serviceFeeIncrease,
		Float[] dedicatedAccountAdjustments) throws AIRException {
		List<DedicatedAccountInformation> lstDedicatedAccountAdjustments = new ArrayList<DedicatedAccountInformation>();
		for(int i = 0; i < dedicatedAccountAdjustments.length; i++) {
			if(dedicatedAccountAdjustments[i] != null && dedicatedAccountAdjustments[i].floatValue() != 0) {
				DedicatedAccountInformation di = new DedicatedAccountInformation();
				di.setDedicatedAccountId(i + 1);
				di.setDedicatedAccountValue(dedicatedAccountAdjustments[i]);
				lstDedicatedAccountAdjustments.add(di);
			}
		}
		try {
			AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getGenericUpdateBalanceAndDateCommand(originTransId, originTimestamp, 
				msisdn, mainAccAdjustment, username, reason, supervisionIncrease, serviceFeeIncrease, 100f, lstDedicatedAccountAdjustments);
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) {
				logger.error("Air Adjustment Error: " + cmd.getFullResultCode());
				throw new AIRException(cmd.getFullResultCode(), "Air Adjustment Error..");
			}
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public String makeRefill(String originTransId, Date originTimestamp, String msisdn, Float mainAccAdjustment, String username, String reason) {
		try {
			AbstractRefillCommand cmd = airVoucherRefillCommandFactory.getRefillCommand(originTransId, originTimestamp, msisdn, mainAccAdjustment, username, reason, 100f);
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) {
				logger.error("AIR Refill Command Error: " + cmd.getFullResultCode());
				throw new AIRException(cmd.getFullResultCode(), "AIR Refill Command Error..");
			}
			return cmd.getVoucherGroup();
		} catch(Exception e) {
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		}
	}
	
	public void creditAmountForBB4P(String msisdn, String transactionID, String requesterService, float amount, String eventType) throws ChargingSystemException {
		AbstractCS3CP6Command cmd = null;
		try {
			cmd = airBB4PCommandFactory.getUpdateBalanceAndDateCommand(transactionID, new Date(), msisdn, amount, eventType, "",
				0, 0, 0 ,0, 100f);
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) throw new ChargingSystemException(cmd.getFullResultCode(), getCSErrorMessage(cmd.getFullResultCode()));
		} catch(XmlRpcConnectionException e) {
			logger.error("Cannot connect to AIR: " + e.getMessage());
			throw new ChargingSystemException(404, "Cannot Connect to AIR: " + e.getMessage());
		}
	}
	
	public void creditAmountForReservedCharging(String msisdn, String transactionID, String requesterService, float amount, String eventType) throws ChargingSystemException {
		try {
			AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getUpdateBalanceAndDateCommand(transactionID, new Date(), msisdn, amount, eventType, requesterService,
				0, 0, 0 ,0, 100f);
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) throw new ChargingSystemException(cmd.getFullResultCode(), getCSErrorMessage(cmd.getFullResultCode()));
		} catch(XmlRpcConnectionException e) {
			logger.error("Cannot connect to AIR: " + e.getMessage());
			throw new ChargingSystemException(404, "Cannot Connect to AIR: " + e.getMessage());
		}
	}
	
	public AbstractCS3CP6Command getBalanceAndDate(String msisdn) throws ChargingSystemException {
		try {
			AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getBalanceAndDateCommand(msisdn, new Date(), String.valueOf(System.currentTimeMillis()), 100f);
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) throw new ChargingSystemException(cmd.getFullResultCode(), getCSErrorMessage(cmd.getFullResultCode()));
			return cmd;
		} catch(XmlRpcConnectionException e) {
			logger.error("Cannot connect to AIR: " + e.getMessage());
			throw new RuntimeException("Cannot Connect to AIR: " + e.getMessage());
		}
	}
	
	public AbstractCS3CP6Command getAccountDetails(String msisdn) {
		try {
			AbstractCS3CP6Command cmd = airAdjustmentCommandFactory.getAccountDetailsCommand(String.valueOf(System.currentTimeMillis()), new Date(), msisdn, 100f);
			cmd.execute();
			return cmd;
		} catch(XmlRpcConnectionException e) {
			logger.error("Cannot connect to AIR: " + e.getMessage());
			throw new RuntimeException("Cannot Connect to AIR: " + e.getMessage());
		}
	}
	
	public void executeAirCommand(AbstractCSCommand cmd) {
		try {
			cmd.execute();
			if(cmd.isErrorOrFaultResponse()) throw new RuntimeException("Could not execute command to AIR, returnCode: " + cmd.getFullResultCode());
		} catch(XmlRpcConnectionException e) {
			logger.error("Cannot connect to AIR: " + e.getMessage());
			throw new RuntimeException("Cannot Connect to AIR: " + e.getMessage());
		}
	}
	
	public ServiceType getServiceType(String msisdn) {
		AbstractCS3CP6Command cmd = getAccountDetails(msisdn);
		if(cmd.isErrorOrFaultResponse()) return null;
		if((cmd.getServiceClassCurrent() == 31) || (cmd.getServiceClassCurrent() == 34)) return ServiceType.Data;
		else return ServiceType.Voice;
	}
	
	private String getCSErrorMessage(Integer resultCode) {
		switch (resultCode) {
		case 102: return "Subscriber Not Found";
		case 104: return "Account temporarily blocked";
		case 124: return "Below minimum balance";
		case 125: return "CS unavailable";
		case 126: return "Account not active";
		default: return "Other CS Error";
		}
	}
}
