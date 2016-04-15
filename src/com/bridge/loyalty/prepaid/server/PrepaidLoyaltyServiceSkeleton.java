
/**
 * PrepaidLoyaltyServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package com.bridge.loyalty.prepaid.server;
    /**
     *  PrepaidLoyaltyServiceSkeleton java skeleton for the axisService
     */
    public class PrepaidLoyaltyServiceSkeleton implements PrepaidLoyaltyServiceSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn2
                                     * @param originTransId3
                                     * @param relativeAmount4
                                     * @param pointsAdjustmentType5
             * @throws LoyaltyServiceFault : 
         */
        
                 public com.bridge.loyalty.prepaid.AdjustPointsResponse adjustLoyaltyPoints
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn2,java.lang.String originTransId3,java.math.BigDecimal relativeAmount4,com.bridge.loyalty.prepaid.AdjustmentType pointsAdjustmentType5
                  )
            throws LoyaltyServiceFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#adjustLoyaltyPoints");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn11
             * @throws LoyaltyServiceFault : 
         */
        
                 public java.math.BigDecimal queryLoyaltyPoints
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn11
                  )
            throws LoyaltyServiceFault{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#queryLoyaltyPoints");
        }
     
    }
    