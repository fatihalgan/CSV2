
/**
 * BB4PServiceSkeletonInterface.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package co.mcel.mz.bb4p.server;
    /**
     *  BB4PServiceSkeletonInterface java skeleton interface for the axisService
     */
    public interface BB4PServiceSkeletonInterface {
     
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn
                                        * @param apnId
             * @throws CSVSystemError : 
             * @throws EMAError : 
         */

        
                public boolean registerAPN
                (
                  co.mcel.mz.types.common.MsisdnType msisdn,int apnId
                 )
            throws CSVSystemError,EMAError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param debitAmountRequest1
             * @throws InvalidReservationStatus : 
             * @throws CSVSystemError : 
             * @throws TransactionNotFound : 
         */

        
                public boolean debitAmount
                (
                  java.lang.String debitAmountRequest1
                 )
            throws InvalidReservationStatus,CSVSystemError,TransactionNotFound;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn3
                                        * @param apnId4
             * @throws CSVSystemError : 
             * @throws EMAError : 
         */

        
                public boolean unregisterAPN
                (
                  co.mcel.mz.types.common.MsisdnType msisdn3,int apnId4
                 )
            throws CSVSystemError,EMAError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param cancelReservationRequest6
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */

        
                public boolean cancelReservation
                (
                  java.lang.String cancelReservationRequest6
                 )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param internationalPrefix
                                        * @param number
             * @throws CSVSystemError : 
             * @throws EMAError : 
         */

        
                public java.lang.String getImsi
                (
                  java.lang.String internationalPrefix,java.lang.String number
                 )
            throws CSVSystemError,EMAError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param internationalPrefix9
                                        * @param number10
             * @throws CSVSystemError : 
             * @throws CSError : 
         */

        
                public int getServiceClass
                (
                  java.lang.String internationalPrefix9,java.lang.String number10
                 )
            throws CSVSystemError,CSError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param msisdn12
                                        * @param transactionId
                                        * @param amount
             * @throws CSVSystemError : 
             * @throws CSError : 
         */

        
                public boolean reserveAmount
                (
                  co.mcel.mz.types.common.MsisdnType msisdn12,java.lang.String transactionId,float amount
                 )
            throws CSVSystemError,CSError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param checkStatusRequest14
             * @throws TransactionNotFound : 
             * @throws CSVSystemError : 
         */

        
                public co.mcel.mz.bb4p.CheckStatusResponse_type0 checkStatus
                (
                  java.lang.String checkStatusRequest14
                 )
            throws TransactionNotFound,CSVSystemError;
        
         
        /**
         * Auto generated method signature
         * 
                                        * @param refundRequest16
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */

        
                public boolean refund
                (
                  java.lang.String refundRequest16
                 )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound;
        
         }
    