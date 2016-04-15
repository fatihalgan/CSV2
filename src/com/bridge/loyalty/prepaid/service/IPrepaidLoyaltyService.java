package com.bridge.loyalty.prepaid.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import csv.prepaid.domain.LoyaltyTransaction;
import csv.prepaid.domain.LoyaltyTransactionType;

@Local
public interface IPrepaidLoyaltyService {

	public BigDecimal retrieveLoyaltyPoints(String msisdn);
	public List<LoyaltyTransaction> retrieveLoyaltyTransactionHistory(String msisdn, Date startDate, Date endDate);
	public LoyaltyTransaction adjustLoyaltyPoints(String msisdn, String originTransId, BigDecimal amount, LoyaltyTransactionType transType);
	
}
