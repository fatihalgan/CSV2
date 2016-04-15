
/**
 * ReserveChargingServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package co.mcel.mz.reservedcharging.server;
    /**
     *  ReserveChargingServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface ReserveChargingServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                        * @param transactionId
                                        * @param requesterService
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */

        
                public boolean cancelReservation
                (
                  java.lang.String transactionId,java.lang.String requesterService
                 )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn
                                        * @param transactionId1
                                        * @param requesterService2
                                        * @param amount
                                        * @param description
             * @throws CSVSystemError : 
         */

        
                public boolean directDebit
                (
                  co.mcel.mz.types.common.MsisdnType msisdn,java.lang.String transactionId1,java.lang.String requesterService2,float amount,java.lang.String description
                 )
            throws CSVSystemError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param transactionId4
                                        * @param requesterService5
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */

        
                public boolean refund
                (
                  java.lang.String transactionId4,java.lang.String requesterService5
                 )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn7
                                        * @param transactionId8
                                        * @param requesterService9
                                        * @param amount10
                                        * @param description11
             * @throws CSVSystemError : 
             * @throws CSError : 
         */

        
                public boolean reserveAmount
                (
                  co.mcel.mz.types.common.MsisdnType msisdn7,java.lang.String transactionId8,java.lang.String requesterService9,float amount10,java.lang.String description11
                 )
            throws CSVSystemError,CSError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn13
             * @throws CSVSystemError : 
             * @throws CSError : 
         */

        
                public co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0 getAccountType
                (
                  co.mcel.mz.types.common.MsisdnType msisdn13
                 )
            throws CSVSystemError,CSError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param transactionId15
                                        * @param requesterService16
             * @throws TransactionNotFound : 
             * @throws CSVSystemError : 
         */

        
                public co.mcel.mz.reservedcharging.CheckStatusResponse_type0 checkStatus
                (
                  java.lang.String transactionId15,java.lang.String requesterService16
                 )
            throws TransactionNotFound,CSVSystemError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param transactionId18
                                        * @param requesterService19
             * @throws InvalidReservationStatus : 
             * @throws CSVSystemError : 
             * @throws TransactionNotFound : 
         */

        
                public boolean debitAmount
                (
                  java.lang.String transactionId18,java.lang.String requesterService19
                 )
            throws InvalidReservationStatus,CSVSystemError,TransactionNotFound;
        
         }
    