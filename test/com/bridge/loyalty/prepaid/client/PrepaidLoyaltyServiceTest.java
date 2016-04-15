/**
 * PrepaidLoyaltyServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package com.bridge.loyalty.prepaid.client;

import java.math.BigDecimal;

import org.junit.Before;

import com.bridge.loyalty.prepaid.AdjustPointsRequest;
import com.bridge.loyalty.prepaid.AdjustPointsResponse;
import com.bridge.loyalty.prepaid.AdjustmentType;

import co.mcel.mz.types.common.MsisdnType;

/*
 *  PrepaidLoyaltyServiceTest Junit test case
 */

public class PrepaidLoyaltyServiceTest extends junit.framework.TestCase {

	private MsisdnType msisdnType;

	PrepaidLoyaltyServiceStub stub = null;

	@Before
	public void setUp() throws Exception {
		msisdnType = new MsisdnType();
		msisdnType.setInternationalPrefix("258");
		msisdnType.setNumber("820436635");
		stub = new PrepaidLoyaltyServiceStub(
				"http://localhost:9090/CSV/services/PrepaidLoyaltyService");
	}

	/**
	 * Auto generated test method
	 */
	public void testadjustLoyaltyPoints() throws java.lang.Exception {
		AdjustPointsRequest request = new AdjustPointsRequest();
		request.setMsisdn(msisdnType);
		request.setOriginTransId(String.valueOf(System.currentTimeMillis()));
		request.setPointsAdjustmentType(AdjustmentType.REMOVE);
		request.setRelativeAmount(new BigDecimal(5));
		System.out.print("Origin Transaction ID for points adjustment is: " + request.getOriginTransId());
		AdjustPointsResponse resp = stub.adjustLoyaltyPoints(request.getMsisdn(), request.getOriginTransId(), request.getRelativeAmount(), request.getPointsAdjustmentType());
		assertNotNull(resp);
		assertNotNull(resp.getTransactionId());
		assertEquals(resp.getAdjustedAmount().abs(), request.getRelativeAmount());
		System.out.println("Transaction ID for the operation is: " + resp.getTransactionId());
		System.out.println("Remaining Points in account is: " + resp.getRemainingPoints().toPlainString());
	}

	/**
	 * Auto generated test method
	 */
	public void testqueryLoyaltyPoints() throws java.lang.Exception {
		BigDecimal resp = stub.queryLoyaltyPoints(msisdnType);
		assertNotNull(resp);
		System.out.println("TotalCurrent total loyalty points are: "
				+ resp.toPlainString());
	}
}
