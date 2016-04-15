

/**
 * ReserveChargingService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package co.mcel.mz.reservedcharging.client;

    /*
     *  ReserveChargingService java interface
     */

    public interface ReserveChargingService {
          

        /**
          * Auto generated method signature
          * 
                    * @param cancelReservationRequest
                
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
             * @throws co.mcel.mz.reservedcharging.client.InvalidReservationStatus : 
             * @throws co.mcel.mz.reservedcharging.client.CSError : 
             * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
         */

         
                     public boolean cancelReservation(

                        java.lang.String transactionId,java.lang.String requesterService)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.CSVSystemError
          ,co.mcel.mz.reservedcharging.client.InvalidReservationStatus
          ,co.mcel.mz.reservedcharging.client.CSError
          ,co.mcel.mz.reservedcharging.client.TransactionNotFound;

        

        /**
          * Auto generated method signature
          * 
                    * @param directDebitRequest
                
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
         */

         
                     public boolean directDebit(

                        co.mcel.mz.types.common.MsisdnType msisdn,java.lang.String transactionId1,java.lang.String requesterService2,float amount,java.lang.String description)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.CSVSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param refundRequest
                
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
             * @throws co.mcel.mz.reservedcharging.client.InvalidReservationStatus : 
             * @throws co.mcel.mz.reservedcharging.client.CSError : 
             * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
         */

         
                     public boolean refund(

                        java.lang.String transactionId4,java.lang.String requesterService5)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.CSVSystemError
          ,co.mcel.mz.reservedcharging.client.InvalidReservationStatus
          ,co.mcel.mz.reservedcharging.client.CSError
          ,co.mcel.mz.reservedcharging.client.TransactionNotFound;

        

        /**
          * Auto generated method signature
          * 
                    * @param reserveAmountRequest
                
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
             * @throws co.mcel.mz.reservedcharging.client.CSError : 
         */

         
                     public boolean reserveAmount(

                        co.mcel.mz.types.common.MsisdnType msisdn7,java.lang.String transactionId8,java.lang.String requesterService9,float amount10,java.lang.String description11)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.CSVSystemError
          ,co.mcel.mz.reservedcharging.client.CSError;

        

        /**
          * Auto generated method signature
          * 
                    * @param getAccountTypeRequest
                
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
             * @throws co.mcel.mz.reservedcharging.client.CSError : 
         */

         
                     public co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0 getAccountType(

                        co.mcel.mz.types.common.MsisdnType msisdn13)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.CSVSystemError
          ,co.mcel.mz.reservedcharging.client.CSError;

        

        /**
          * Auto generated method signature
          * 
                    * @param checkStatusRequest
                
             * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
         */

         
                     public co.mcel.mz.reservedcharging.CheckStatusResponse_type0 checkStatus(

                        java.lang.String transactionId15,java.lang.String requesterService16)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.TransactionNotFound
          ,co.mcel.mz.reservedcharging.client.CSVSystemError;

        

        /**
          * Auto generated method signature
          * 
                    * @param debitAmountRequest
                
             * @throws co.mcel.mz.reservedcharging.client.InvalidReservationStatus : 
             * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
             * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
         */

         
                     public boolean debitAmount(

                        java.lang.String transactionId18,java.lang.String requesterService19)
                        throws java.rmi.RemoteException
             
          ,co.mcel.mz.reservedcharging.client.InvalidReservationStatus
          ,co.mcel.mz.reservedcharging.client.CSVSystemError
          ,co.mcel.mz.reservedcharging.client.TransactionNotFound;

        

        
       //
       }
    