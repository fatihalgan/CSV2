
/**
 * PrepaidLoyaltyServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package com.bridge.loyalty.prepaid.server;
    /**
     *  PrepaidLoyaltyServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface PrepaidLoyaltyServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn
                                        * @param originTransId
                                        * @param relativeAmount
                                        * @param pointsAdjustmentType
             * @throws LoyaltyServiceFault : 
         */

        
                public com.bridge.loyalty.prepaid.AdjustPointsResponse adjustLoyaltyPoints
                (
                  co.mcel.mz.types.common.MsisdnType msisdn,java.lang.String originTransId,java.math.BigDecimal relativeAmount,com.bridge.loyalty.prepaid.AdjustmentType pointsAdjustmentType
                 )
            throws LoyaltyServiceFault;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn0
             * @throws LoyaltyServiceFault : 
         */

        
                public java.math.BigDecimal queryLoyaltyPoints
                (
                  co.mcel.mz.types.common.MsisdnType msisdn0
                 )
            throws LoyaltyServiceFault;
        
         }
    