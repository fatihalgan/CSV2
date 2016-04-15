

/**
 * BB4PService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package co.mcel.mz.bb4p.client;

    /*
     *  BB4PService java interface
     */

    public interface BB4PService {
          

        /**
          * Auto generated method signature
          * 
                    * @param registerAPNRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.EMAError : 
         */

         
                     public boolean registerAPN(

                        co.mcel.mz.types.common.MsisdnType msisdn,int apnId)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.EMAError;

        

        /**
          * Auto generated method signature
          * 
                    * @param debitAmountRequest
                
             * @throws co.mcel.mz.bb4p.client.InvalidReservationStatus : 
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
         */

         
                     public boolean debitAmount(

                        java.lang.String debitAmountRequest1)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.InvalidReservationStatus
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.TransactionNotFound;

        

        /**
          * Auto generated method signature
          * 
                    * @param unregisterAPNRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.EMAError : 
         */

         
                     public boolean unregisterAPN(

                        co.mcel.mz.types.common.MsisdnType msisdn3,int apnId4)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.EMAError;

        

        /**
          * Auto generated method signature
          * 
                    * @param cancelReservationRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.InvalidReservationStatus : 
             * @throws co.mcel.mz.bb4p.client.CSError : 
             * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
         */

         
                     public boolean cancelReservation(

                        java.lang.String cancelReservationRequest6)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.InvalidReservationStatus
          ,co.mcel.mz.bb4p.client.CSError
          ,co.mcel.mz.bb4p.client.TransactionNotFound;

        

        /**
          * Auto generated method signature
          * 
                    * @param getImsiRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.EMAError : 
         */

         
                     public java.lang.String getImsi(

                        java.lang.String internationalPrefix,java.lang.String number)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.EMAError;

        

        /**
          * Auto generated method signature
          * 
                    * @param getServiceClassRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.CSError : 
         */

         
                     public int getServiceClass(

                        java.lang.String internationalPrefix9,java.lang.String number10)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.CSError;

        

        /**
          * Auto generated method signature
          * 
                    * @param reserveAmountRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.CSError : 
         */

         
                     public boolean reserveAmount(

                        co.mcel.mz.types.common.MsisdnType msisdn12,java.lang.String transactionId,float amount)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.CSError;

        

        /**
          * Auto generated method signature
          * 
                    * @param checkStatusRequest
                
             * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
         */

         
                     public co.mcel.mz.bb4p.CheckStatusResponse_type0 checkStatus(

                        java.lang.String checkStatusRequest14)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.TransactionNotFound
          ,co.mcel.mz.bb4p.client.CSVSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param refundRequest
                
             * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
             * @throws co.mcel.mz.bb4p.client.InvalidReservationStatus : 
             * @throws co.mcel.mz.bb4p.client.CSError : 
             * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
         */

         
                     public boolean refund(

                        java.lang.String refundRequest16)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.bb4p.client.CSVSystemError
          ,co.mcel.mz.bb4p.client.InvalidReservationStatus
          ,co.mcel.mz.bb4p.client.CSError
          ,co.mcel.mz.bb4p.client.TransactionNotFound;

        

        
       //
       }
    