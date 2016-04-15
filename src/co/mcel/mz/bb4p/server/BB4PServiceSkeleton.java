
/**
 * BB4PServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package co.mcel.mz.bb4p.server;
    /**
     *  BB4PServiceSkeleton java skeleton for the axisService
     */
    public class BB4PServiceSkeleton implements BB4PServiceSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn19
                                     * @param apnId20
             * @throws CSVSystemError : 
             * @throws EMAError : 
         */
        
                 public boolean registerAPN
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn19,int apnId20
                  )
            throws CSVSystemError,EMAError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#registerAPN");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param debitAmountRequest24
             * @throws InvalidReservationStatus : 
             * @throws CSVSystemError : 
             * @throws TransactionNotFound : 
         */
        
                 public boolean debitAmount
                  (
                  java.lang.String debitAmountRequest24
                  )
            throws InvalidReservationStatus,CSVSystemError,TransactionNotFound{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#debitAmount");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn28
                                     * @param apnId29
             * @throws CSVSystemError : 
             * @throws EMAError : 
         */
        
                 public boolean unregisterAPN
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn28,int apnId29
                  )
            throws CSVSystemError,EMAError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#unregisterAPN");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param cancelReservationRequest33
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */
        
                 public boolean cancelReservation
                  (
                  java.lang.String cancelReservationRequest33
                  )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#cancelReservation");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param internationalPrefix37
                                     * @param number38
             * @throws CSVSystemError : 
             * @throws EMAError : 
         */
        
                 public java.lang.String getImsi
                  (
                  java.lang.String internationalPrefix37,java.lang.String number38
                  )
            throws CSVSystemError,EMAError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getImsi");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param internationalPrefix42
                                     * @param number43
             * @throws CSVSystemError : 
             * @throws CSError : 
         */
        
                 public int getServiceClass
                  (
                  java.lang.String internationalPrefix42,java.lang.String number43
                  )
            throws CSVSystemError,CSError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getServiceClass");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param msisdn47
                                     * @param transactionId48
                                     * @param amount49
             * @throws CSVSystemError : 
             * @throws CSError : 
         */
        
                 public boolean reserveAmount
                  (
                  co.mcel.mz.types.common.MsisdnType msisdn47,java.lang.String transactionId48,float amount49
                  )
            throws CSVSystemError,CSError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#reserveAmount");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param checkStatusRequest53
             * @throws TransactionNotFound : 
             * @throws CSVSystemError : 
         */
        
                 public co.mcel.mz.bb4p.CheckStatusResponse_type0 checkStatus
                  (
                  java.lang.String checkStatusRequest53
                  )
            throws TransactionNotFound,CSVSystemError{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#checkStatus");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param refundRequest57
             * @throws CSVSystemError : 
             * @throws InvalidReservationStatus : 
             * @throws CSError : 
             * @throws TransactionNotFound : 
         */
        
                 public boolean refund
                  (
                  java.lang.String refundRequest57
                  )
            throws CSVSystemError,InvalidReservationStatus,CSError,TransactionNotFound{
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#refund");
        }
     
    }
    