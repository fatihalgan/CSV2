

/**
 * ProvisionManagerService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.bridge.pm.client;

    /*
     *  ProvisionManagerService java interface
     */

    public interface ProvisionManagerService {
          

        /**
          * Auto generated method signature
          * 
                    * @param swapSimRequest
                
         */

         
                     public long swapSim(

                        com.bridge.pm.types.SwapInfoType swapInfo)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param deactivateSimRequest
                
         */

         
                     public long deactivateSim(

                        com.bridge.pm.types.DisconnectInfoType disconnectInfo)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param swapMsisdnRequest
                
         */

         
                     public long swapMsisdn(

                        com.bridge.pm.types.SwapInfoType swapInfo2)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param migratePrepaidToPostpaidRequest
                
         */

         
                     public long migratePrepaidToPostpaid(

                        long requestId,com.bridge.pm.types.HlrInfoType hlrInfo,com.bridge.pm.types.DisconnectInfoType disconnectInfo4,com.bridge.pm.types.AccountInfoType accountInfo)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param activateSimRequest
                
         */

         
                     public long activateSim(

                        com.bridge.pm.types.HlrInfoType hlrInfo6,com.bridge.pm.types.AucInfoType aucInfo)
                        throws java.rmi.RemoteException
             ;

        

        
       //
       }
    