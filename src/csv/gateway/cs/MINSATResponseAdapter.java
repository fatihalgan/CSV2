package csv.gateway.cs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.bridge.arete.minsat.command.MinsatTokens;
import com.bridge.arete.minsat.model.Accumulator;
import com.bridge.arete.minsat.model.HLRBlockingStatus;
import com.bridge.arete.minsat.model.InitialMinsatParameters;
import com.bridge.arete.minsat.model.PaymentProfile;
import com.bridge.arete.minsat.serializer.MinsatResponse;
import com.bridge.arete.minsat.util.DateHelper;
import csv.prepaid.domain.Community;
import csv.prepaid.domain.PrepaidAccount;

public class MINSATResponseAdapter {

	public static ServiceClass getOriginServiceClass(MinsatResponse response) {
		String sc = response.getValue(MinsatTokens.OrigServiceClass.toString());
		String scName = response.getValue(MinsatTokens.OrigServiceClassDescription.toString());		 
		return ServiceClass.factory(sc);
	}
	
	public static String getStatus(MinsatResponse resp){
		return resp.getValue(MinsatTokens.Status.toString());		
	}
	
	public static Language getLanguage(MinsatResponse resp){
		String language = resp.getValue(MinsatTokens.Language.toString());
		return Language.factory(language);
	}
	
	public static Float getMainAccountBalance(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.AccountBalance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount1Balance(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.DedicatedAccount1Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount2Balance(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.DedicatedAccount2Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount3Balance(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.DedicatedAccount3Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount4Balance(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.DedicatedAccount4Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount5Balance(MinsatResponse resp) {
		String value = resp.getValue(MinsatTokens.DedicatedAccount5Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount6Balance(MinsatResponse resp) {
		String value = resp.getValue(MinsatTokens.DedicatedAccount6Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount7Balance(MinsatResponse resp) {
		String value = resp.getValue(MinsatTokens.DedicatedAccount7Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount8Balance(MinsatResponse resp) {
		String value = resp.getValue(MinsatTokens.DedicatedAccount8Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount9Balance(MinsatResponse resp) {
		String value = resp.getValue(MinsatTokens.DedicatedAccount9Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static Float getDedicatedAccount10Balance(MinsatResponse resp) {
		String value = resp.getValue(MinsatTokens.DedicatedAccount10Balance.toString());
		if(null==value || "".equals(value))return 0f;
		return new Float(value);
	}
	
	public static ServiceClass getCurrentServiceClass(MinsatResponse resp) {
		String sc = resp.getValue(MinsatTokens.ServiceClass.toString());
		String scName = resp.getValue(MinsatTokens.ServiceClassDescription.toString());		 
		return ServiceClass.factory(sc);
	}
	
	public static Integer getTempBlockingStatus(MinsatResponse resp){
		 String value = resp.getValue(MinsatTokens.TempBlockingStatus.toString());
		 if(null==value || "".equals(value))return 0;
		 return new Integer(value);
	}
	
	public static Date getServiceFeePeriodExpiryDate(MinsatResponse resp){
		 String value = resp.getValue(MinsatTokens.ServiceFeePeriodExpiryDate.toString());
		 if(null==value || "".equals(value))return null;
		 return DateHelper.convertToDate(value);
	}
	
	public static Date getSupervisionPeriodExpiryDate(MinsatResponse resp){
		 String value = resp.getValue(MinsatTokens.SupervisionPeriodExpiryDate.toString());
		 if(null==value || "".equals(value))return null;
		 return DateHelper.convertToDate(value);
	}
	
	public static Date getActivationDate(MinsatResponse resp){
		 String value = resp.getValue(MinsatTokens.ActivationDate.toString());
		 if(null==value || "".equals(value))return null;
		 return DateHelper.convertToDate(value);
	}
	
	public static HLRBlockingStatus getHLRBlockingStatus(MinsatResponse resp){
		return new HLRBlockingStatus(resp.getValue(MinsatTokens.HLRBlockingStatus.toString()));	
	}
	
	public static Date getRefillUnbarDateTime(MinsatResponse resp) {
		 String value = resp.getValue(MinsatTokens.RefillUnbarDateTime.toString());
		 if(null==value || "".equals(value))return null;
		 return DateHelper.convertToDate(value);
	}
	
	public static DedicatedAccount getDedicatedAccount(MinsatResponse response, int dedicatedAccountID) {
		DedicatedAccount account = new DedicatedAccount();
		account.setId(dedicatedAccountID);
		switch (dedicatedAccountID) {
		case 1:
			account.setBalance(getDedicatedAccount1Balance(response));
			break;
		case 2:
			account.setBalance(getDedicatedAccount2Balance(response));
			break;
		case 3:
			account.setBalance(getDedicatedAccount3Balance(response));
			break;
		case 4:
			account.setBalance(getDedicatedAccount4Balance(response));
			break;
		case 5:
			account.setBalance(getDedicatedAccount5Balance(response));
			break;
		case 6:
			account.setBalance(getDedicatedAccount6Balance(response));
			break;
		case 7:
			account.setBalance(getDedicatedAccount7Balance(response));
			break;
		case 8:
			account.setBalance(getDedicatedAccount8Balance(response));
			break;
		case 9:
			account.setBalance(getDedicatedAccount9Balance(response));
			break;
		case 10:
			account.setBalance(getDedicatedAccount10Balance(response));
			break;
		default:
			account.setBalance(0f);
			break;
		}
		//TODO: set expiry date, etc..
		return account;
	}
	
	public static List<DedicatedAccount> getDedicatedAccounts(MinsatResponse response) {
		List<DedicatedAccount> dedicatedAccounts = new ArrayList<DedicatedAccount>();
		for(int i = 0; i < 10; i++) {
			dedicatedAccounts.add(getDedicatedAccount(response, i+1));
		}
		return dedicatedAccounts;
	}
	
	public static List<Community> getCommunityList(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.CommunityList.toString());
		if(null==value || "".equals(value)) return null;
		ArrayList<Community> communityList = new ArrayList<Community>();
		StringTokenizer stringTokenizer = new StringTokenizer(value, " ");
		while(stringTokenizer.hasMoreTokens()){
			Integer id = new Integer(stringTokenizer.nextToken());
			communityList.add(new Community(id, InitialMinsatParameters.getCommunityMap().get(id)));
		}
		return communityList;
	}
	
	public static void refreshCommunitiesMap(MinsatResponse resp){
		StringTokenizer stringTokenizer = new StringTokenizer(resp.getData(), MinsatTokens.NewLineToken.toString());
		Map<Integer,String> result = new HashMap<Integer,String>();
		while(stringTokenizer.hasMoreTokens()){
			String token = stringTokenizer.nextToken();
			int index = token.indexOf(MinsatTokens.TabToken.toString());
			// TODO Here is hard coded because of Benjamim request.
			Integer code = new Integer(token.substring(index+1)); 
			result.put(code, 1==code.intValue()?"Malta M":token.substring(0,index).trim());
		}
		InitialMinsatParameters.setCommunityMap(result);
	}
	
	public static PrepaidAccount getPrepaidAccount(MinsatResponse response) {
		PrepaidAccount account = new PrepaidAccount();
		account.setActivationDate(getActivationDate(response));
		account.setCurrentLanguage(getLanguage(response));
		account.setCurrentServiceClass(getCurrentServiceClass(response));
		account.setDedicatedAccounts(getDedicatedAccounts(response));
		account.setHlrBlockingStatus(getHLRBlockingStatus(response));
		account.setMainAccountBalance(getMainAccountBalance(response));
		account.setOriginServiceClass(getOriginServiceClass(response));
		account.setRefillUnbarDate(getRefillUnbarDateTime(response));
		account.setServiceFeeDate(getServiceFeePeriodExpiryDate(response));
		account.setStatus(getStatus(response));
		account.setSupervisionDate(getSupervisionPeriodExpiryDate(response));
		account.setTemporaryBlockedFlag(getTempBlockingStatus(response) == 1);
		account.setCommunityList(getCommunityList(response));
		account.setAccumulators(getAccumulators(response));
		return account;
	}
	
	public static String getAgent(MinsatResponse resp){
		return resp.getValue(MinsatTokens.Agent.toString());	
	}
	
	public static Date getVoucherExpiryDate(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.VoucherExpiryDate.toString());
		if(null==value || "".equals(value))return null;
		return DateHelper.convertToTimeStamp(value);	
	}
	
	public static VoucherStatus getVoucherStatus(MinsatResponse resp){
		return VoucherStatus.factory(resp.getValue(MinsatTokens.VoucherStatus.toString()));	
	}
	
	public static String getVoucherValue(MinsatResponse resp){
		return resp.getValue(MinsatTokens.VoucherValue.toString());		
	}
	
	public static String getVoucherGroup(MinsatResponse resp){
		return resp.getValue(MinsatTokens.VoucherGroup.toString());		
	}
	
	public static String getOperatorID(MinsatResponse resp){
		return resp.getValue(MinsatTokens.OperatorID.toString());		
	}
	
	public static String getBatchID(MinsatResponse resp){
		return resp.getValue(MinsatTokens.BatchID.toString());		
	}
	
	public static Date getTimeStamp(MinsatResponse resp){
		String value = resp.getValue(MinsatTokens.TimeStamp.toString());
		if(null==value || "".equals(value))return null;
		return DateHelper.convertToTimeStamp(value);	
	}
	
	public static String getCurrency(MinsatResponse resp){
		return resp.getValue(MinsatTokens.Currency.toString());		
	}
	
	public static String getSubscriberNumber(MinsatResponse resp){
		return resp.getValue(MinsatTokens.SubscriberNumber.toString());	
	}
	
	public static Voucher getVoucher(String serialNumber, MinsatResponse response) {
		Voucher voucher = new Voucher();
		voucher.setAgent(getAgent(response));
		voucher.setBatchId(getBatchID(response));
		voucher.setCurrency(getCurrency(response));
		voucher.setExpiryDate(getVoucherExpiryDate(response));
		voucher.setOperatorId(getOperatorID(response));
		voucher.setSerialNumber(serialNumber);
		voucher.setStatus(getVoucherStatus(response));
		voucher.setSubscriberNumber(getSubscriberNumber(response));
		voucher.setTimestamp(getTimeStamp(response));
		voucher.setVoucherGroup(getVoucherGroup(response));
		voucher.setVoucherValue(getVoucherValue(response));
		return voucher;
	}
	
	public static List<PaymentProfile> getPaymentProfiles(MinsatResponse resp){
		StringTokenizer stringTokenizer = new StringTokenizer(resp.getData(), MinsatTokens.NewLineToken.toString());
		List<PaymentProfile> result = new ArrayList<PaymentProfile>();
		while(stringTokenizer.hasMoreTokens()){
			String token = stringTokenizer.nextToken();
			PaymentProfile pp = new PaymentProfile();
			int index = token.indexOf(MinsatTokens.TabToken.toString());
			pp.setProfileID(token.substring(0,index));
			pp.setVoucherGroup(token.substring(index+1));
			result.add(pp);
		}
		return result;
	}
	
	public static List<Accumulator> getAccumulators(MinsatResponse resp) {
		List<Accumulator> accumulators = new ArrayList<Accumulator>();
		if(resp.getValue(MinsatTokens.Accumulator1ID.toString()) != null) {
			Accumulator accumulator = new Accumulator();
			accumulator.setId(resp.getIntValue(MinsatTokens.Accumulator1ID.toString()));
			String date = resp.getValue(MinsatTokens.Accumulator1ResetDate.toString());
			if(null == date || "".equals(date)) accumulator.setResetDate(null);
			else accumulator.setResetDate(DateHelper.convertToDate(date));	
			accumulator.setDescription(resp.getValue(MinsatTokens.Accumulator1Description.toString()));
			date = resp.getValue(MinsatTokens.Accumulator1StartDate.toString());
			if(null == date || "".equals(date)) accumulator.setStartDate(null);
			else accumulator.setStartDate(DateHelper.convertToDate(date));
			accumulator.setValue(resp.getValue(MinsatTokens.Accumulator1Value.toString()));
			accumulators.add(accumulator);
		}
		if(resp.getValue(MinsatTokens.Accumulator2ID.toString()) != null) {
			Accumulator accumulator = new Accumulator();
			accumulator.setId(resp.getIntValue(MinsatTokens.Accumulator2ID.toString()));
			String date = resp.getValue(MinsatTokens.Accumulator2ResetDate.toString());
			if(null == date || "".equals(date)) accumulator.setResetDate(null);
			else accumulator.setResetDate(DateHelper.convertToDate(date));	
			accumulator.setDescription(resp.getValue(MinsatTokens.Accumulator2Description.toString()));
			date = resp.getValue(MinsatTokens.Accumulator2StartDate.toString());
			if(null == date || "".equals(date)) accumulator.setStartDate(null);
			else accumulator.setStartDate(DateHelper.convertToDate(date));
			accumulator.setValue(resp.getValue(MinsatTokens.Accumulator2Value.toString()));
			accumulators.add(accumulator);
		}
		if(resp.getValue(MinsatTokens.Accumulator3ID.toString()) != null) {
			Accumulator accumulator = new Accumulator();
			accumulator.setId(resp.getIntValue(MinsatTokens.Accumulator3ID.toString()));
			String date = resp.getValue(MinsatTokens.Accumulator3ResetDate.toString());
			if(null == date || "".equals(date)) accumulator.setResetDate(null);
			else accumulator.setResetDate(DateHelper.convertToDate(date));	
			accumulator.setDescription(resp.getValue(MinsatTokens.Accumulator3Description.toString()));
			date = resp.getValue(MinsatTokens.Accumulator3StartDate.toString());
			if(null == date || "".equals(date)) accumulator.setStartDate(null);
			else accumulator.setStartDate(DateHelper.convertToDate(date));
			accumulator.setValue(resp.getValue(MinsatTokens.Accumulator3Value.toString()));
			accumulators.add(accumulator);
		}
		if(resp.getValue(MinsatTokens.Accumulator4ID.toString()) != null) {
			Accumulator accumulator = new Accumulator();
			accumulator.setId(resp.getIntValue(MinsatTokens.Accumulator4ID.toString()));
			String date = resp.getValue(MinsatTokens.Accumulator4ResetDate.toString());
			if(null == date || "".equals(date)) accumulator.setResetDate(null);
			else accumulator.setResetDate(DateHelper.convertToDate(date));	
			accumulator.setDescription(resp.getValue(MinsatTokens.Accumulator4Description.toString()));
			date = resp.getValue(MinsatTokens.Accumulator4StartDate.toString());
			if(null == date || "".equals(date)) accumulator.setStartDate(null);
			else accumulator.setStartDate(DateHelper.convertToDate(date));
			accumulator.setValue(resp.getValue(MinsatTokens.Accumulator4Value.toString()));
			accumulators.add(accumulator);
		}
		if(resp.getValue(MinsatTokens.Accumulator5ID.toString()) != null) {
			Accumulator accumulator = new Accumulator();
			accumulator.setId(resp.getIntValue(MinsatTokens.Accumulator5ID.toString()));
			String date = resp.getValue(MinsatTokens.Accumulator5ResetDate.toString());
			if(null == date || "".equals(date)) accumulator.setResetDate(null);
			else accumulator.setResetDate(DateHelper.convertToDate(date));	
			accumulator.setDescription(resp.getValue(MinsatTokens.Accumulator5Description.toString()));
			date = resp.getValue(MinsatTokens.Accumulator5StartDate.toString());
			if(null == date || "".equals(date)) accumulator.setStartDate(null);
			else accumulator.setStartDate(DateHelper.convertToDate(date));
			accumulator.setValue(resp.getValue(MinsatTokens.Accumulator5Value.toString()));
			accumulators.add(accumulator);
		}
		return accumulators;
	}
}
