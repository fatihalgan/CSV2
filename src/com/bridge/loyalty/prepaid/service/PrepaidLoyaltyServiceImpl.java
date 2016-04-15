package com.bridge.loyalty.prepaid.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;

import csv.common.service.IDrService;
import csv.dr.dao.IDrDao;
import csv.dr.domain.SMSMessage;
import csv.prepaid.dao.ILoyaltyDao;
import csv.prepaid.domain.LoyaltyTransaction;
import csv.prepaid.domain.LoyaltyTransactionType;

@Name("prepaidLoyaltyService")
@AutoCreate
@Stateless
public class PrepaidLoyaltyServiceImpl implements IPrepaidLoyaltyService {

	@Logger
	protected Log logger;
	
	@In("loyaltyDao")
	private ILoyaltyDao loyaltyDao;
	
	@In("drDao")
	private IDrDao drDao;
	
	public PrepaidLoyaltyServiceImpl() {
		super();
	}

	public void setLoyaltyDao(ILoyaltyDao loyaltyDao) {
		this.loyaltyDao = loyaltyDao;
	}
	
	@Override
	public BigDecimal retrieveLoyaltyPoints(String msisdn) {
		BigDecimal points = loyaltyDao.findLoyaltyPoints(msisdn);
		return points;
	}

	@Override
	public List<LoyaltyTransaction> retrieveLoyaltyTransactionHistory(String msisdn, Date startDate, Date endDate) {
		List<LoyaltyTransaction> history = loyaltyDao.findLoyaltyHistory(msisdn, startDate, endDate);
		return history;
	}

	@Override
	public LoyaltyTransaction adjustLoyaltyPoints(String msisdn, String originTransId, BigDecimal amount, LoyaltyTransactionType transType) {
		if(transType.equals(LoyaltyTransactionType.Gain)) throw new RuntimeException("Operation not supported yet: LoyaltyTransaction - Give Points");
		Long transId = loyaltyDao.spendLoyaltyPoints(msisdn, amount.intValue(), Long.parseLong(originTransId));
		LoyaltyTransaction transaction = new LoyaltyTransaction();
		transaction.setId(transId);
		transaction.setAmount(amount.floatValue());
		transaction.setOriginTransId(originTransId);
		transaction.setTransDate(new Date());
		transaction.setTransType(LoyaltyTransactionType.Spend);
		transaction.setMsisdn(msisdn);
		sendLoyaltyAdjustmentSMS(msisdn, String.valueOf(amount.floatValue()), String.valueOf(retrieveLoyaltyPoints(msisdn).floatValue()));
		return transaction;
	}
	
	private void sendLoyaltyAdjustmentSMS(String msisdn, String exchangedPoints, String currentPoints) {
		try {
			SMSMessage smsMessage = new SMSMessage(msisdn, "Trocou " + exchangedPoints + " pontos e ficou com saldo de " + currentPoints + " pontos. Se nao reconhece esta transaccao ligue imediatamente para o 133 ou dirija-se a loja mais proxima. mcel");
			drDao.save(smsMessage);
		} catch(Exception e) {
			logger.error("Could not send Loyalty SMS Message: " + e.getMessage());
		}
	}
	
	
}
