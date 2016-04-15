package com.bridge.loyalty.prepaid.server;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.seam.Component;
import org.jboss.seam.contexts.Lifecycle;

import com.bridge.loyalty.prepaid.AdjustPointsResponse;
import com.bridge.loyalty.prepaid.AdjustmentType;
import com.bridge.loyalty.prepaid.service.IPrepaidLoyaltyService;

import co.mcel.mz.types.common.MsisdnType;
import csv.prepaid.domain.LoyaltyTransaction;
import csv.prepaid.domain.LoyaltyTransactionType;

public class PrepaidLoyaltyServiceImpl implements PrepaidLoyaltyServiceSkeletonInterface {

	private static final Log logger = LogFactory.getLog(PrepaidLoyaltyServiceImpl.class);
	
	public PrepaidLoyaltyServiceImpl() {
		super();
	}

	@Override
	public AdjustPointsResponse adjustLoyaltyPoints(MsisdnType msisdn, String originTransId,
			BigDecimal relativeAmount, AdjustmentType pointsAdjustmentType)
			throws LoyaltyServiceFault {
		try {
			Lifecycle.beginCall();
			IPrepaidLoyaltyService loyaltyService = (IPrepaidLoyaltyService)Component.getInstance("prepaidLoyaltyService");
			LoyaltyTransactionType transType = null;
			if(pointsAdjustmentType.equals(AdjustmentType.ADD)) transType = LoyaltyTransactionType.Gain;
			else if(pointsAdjustmentType.equals(AdjustmentType.REMOVE)) transType = LoyaltyTransactionType.Spend;
			LoyaltyTransaction transaction = loyaltyService.adjustLoyaltyPoints(msisdn.getNumber(), originTransId, relativeAmount, transType);
			AdjustPointsResponse resp = new AdjustPointsResponse();
			if(transType.equals(LoyaltyTransactionType.Gain)) resp.setAdjustedAmount(relativeAmount);
			else if(transType.equals(LoyaltyTransactionType.Spend)) resp.setAdjustedAmount(relativeAmount.negate());
			BigDecimal remainingPoints = loyaltyService.retrieveLoyaltyPoints(msisdn.getNumber());
			resp.setRemainingPoints(remainingPoints);
			resp.setTransactionId(transaction.getId());
			return resp;
		} catch(Exception e) {
			throw new LoyaltyServiceFault(e.getMessage());
		} finally {
			Lifecycle.endCall();
		}
	}

	@Override
	public BigDecimal queryLoyaltyPoints(MsisdnType msisdn) throws LoyaltyServiceFault {
		try {
			Lifecycle.beginCall();
			IPrepaidLoyaltyService loyaltyService = (IPrepaidLoyaltyService)Component.getInstance("prepaidLoyaltyService");
			BigDecimal points = loyaltyService.retrieveLoyaltyPoints(msisdn.getNumber());
			return points;
		} catch(Exception e) {
			throw new LoyaltyServiceFault(e.getMessage());
		} finally {
			Lifecycle.endCall();
		}
	}
}
