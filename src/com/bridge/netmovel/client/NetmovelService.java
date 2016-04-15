

/**
 * NetmovelService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.bridge.netmovel.client;

    /*
     *  NetmovelService java interface
     */

    public interface NetmovelService {
          

        /**
          * Auto generated method signature
          * 
                    * @param startBundleRequest
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public int startBundle(

                        co.mcel.mz.types.common.MsisdnType msisdn,java.lang.String bundleId)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param startVoiceAddOnBundleRequest
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public int startVoiceAddOnBundle(

                        co.mcel.mz.types.common.MsisdnType msisdn0,java.lang.String bundleId1)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param bundleRequest
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public int deactivateNTDuo(

                        co.mcel.mz.types.common.MsisdnType msisdn4)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param bundleRequest7
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public int stopBundle(

                        co.mcel.mz.types.common.MsisdnType msisdn8)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param balanceEnquiryRequest
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public com.bridge.netmovel.BalanceEnquiryResponse balanceEnquiry(

                        co.mcel.mz.types.common.MsisdnType msisdn11)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param bundleRequest13
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public int extendBundle(

                        co.mcel.mz.types.common.MsisdnType msisdn14)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param voucherTopUpRequest
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public com.bridge.netmovel.VoucherTopUpResponse refillVoucher(

                        co.mcel.mz.types.common.MsisdnType msisdn17,java.lang.String activationCode)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param activateDuoRequest
                
             * @throws com.bridge.netmovel.client.NetmovelSystemError : 
         */

         
                     public int activateNTDuo(

                        co.mcel.mz.types.common.MsisdnType msisdn20,int contractValue)
                        throws java.rmi.RemoteException
             
          ,com.bridge.netmovel.client.NetmovelSystemError;

        

        
       //
       }
    