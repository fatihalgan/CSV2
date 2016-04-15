
/**
 * ReserveChargingServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package co.mcel.mz.reservedcharging.server;
    /**
     *  ReserveChargingServiceSkeleton java skeleton for the axisService
     */
    public class ReserveChargingServiceSkeleton implements ReserveChargingServiceSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param transactionId22
                                     * @param requesterService23
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */
        
                 public boolean cancelReservation
                  (
                  java.lang.String transactionId22,java.lang.String requesterService23
                  )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#cancelReservation");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn27
                                     * @param transactionId28
                                     * @param requesterService29
                                     * @param amount30
                                     * @param description31
             * @throws CSVSystemError : 
         */
        
                 public boolean directDebit
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn27,java.lang.String transactionId28,java.lang.String requesterService29,float amount30,java.lang.String description31
                  )
            throws CSVSystemError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#directDebit");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param transactionId35
                                     * @param requesterService36
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */
        
                 public boolean refund
                  (
                  java.lang.String transactionId35,java.lang.String requesterService36
                  )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#refund");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn40
                                     * @param transactionId41
                                     * @param requesterService42
                                     * @param amount43
                                     * @param description44
             * @throws CSVSystemError : 
             * @throws CSError : 
         */
        
                 public boolean reserveAmount
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn40,java.lang.String transactionId41,java.lang.String requesterService42,float amount43,java.lang.String description44
                  )
            throws CSVSystemError,CSError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#reserveAmount");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn48
             * @throws CSVSystemError : 
             * @throws CSError : 
         */
        
                 public co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0 getAccountType
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn48
                  )
            throws CSVSystemError,CSError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getAccountType");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param transactionId52
                                     * @param requesterService53
             * @throws TransactionNotFound : 
             * @throws CSVSystemError : 
         */
        
                 public co.mcel.mz.reservedcharging.CheckStatusResponse_type0 checkStatus
                  (
                  java.lang.String transactionId52,java.lang.String requesterService53
                  )
            throws TransactionNotFound,CSVSystemError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#checkStatus");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param transactionId57
                                     * @param requesterService58
             * @throws InvalidReservationStatus : 
             * @throws CSVSystemError : 
             * @throws TransactionNotFound : 
         */
        
                 public boolean debitAmount
                  (
                  java.lang.String transactionId57,java.lang.String requesterService58
                  )
            throws InvalidReservationStatus,CSVSystemError,TransactionNotFound{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#debitAmount");
        }
     
    }
    