

/**
 * PrepaidLoyaltyService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.bridge.loyalty.prepaid.client;

    /*
     *  PrepaidLoyaltyService java interface
     */

    public interface PrepaidLoyaltyService {
          

        /**
          * Auto generated method signature
          * 
                    * @param adjustPointsRequest
                
             * @throws com.bridge.loyalty.prepaid.client.LoyaltyServiceFault : 
         */

         
                     public com.bridge.loyalty.prepaid.AdjustPointsResponse adjustLoyaltyPoints(

                        co.mcel.mz.types.common.MsisdnType msisdn,java.lang.String originTransId,java.math.BigDecimal relativeAmount,com.bridge.loyalty.prepaid.AdjustmentType pointsAdjustmentType)
                        throws java.rmi.RemoteException
             
          ,com.bridge.loyalty.prepaid.client.LoyaltyServiceFault;

        

        /**
          * Auto generated method signature
          * 
                    * @param queryPointsRequest
                
             * @throws com.bridge.loyalty.prepaid.client.LoyaltyServiceFault : 
         */

         
                     public java.math.BigDecimal queryLoyaltyPoints(

                        co.mcel.mz.types.common.MsisdnType msisdn0)
                        throws java.rmi.RemoteException
             
          ,com.bridge.loyalty.prepaid.client.LoyaltyServiceFault;

        

        
       //
       }
    