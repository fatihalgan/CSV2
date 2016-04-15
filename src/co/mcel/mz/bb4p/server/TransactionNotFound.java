
/**
 * TransactionNotFound.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package co.mcel.mz.bb4p.server;

public class TransactionNotFound extends java.lang.Exception{
    
    private co.mcel.mz.bb4p.TransactionNotFound faultMessage;

    
        public TransactionNotFound() {
            super("TransactionNotFound");
        }

        public TransactionNotFound(java.lang.String s) {
           super(s);
        }

        public TransactionNotFound(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public TransactionNotFound(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(co.mcel.mz.bb4p.TransactionNotFound msg){
       faultMessage = msg;
    }
    
    public co.mcel.mz.bb4p.TransactionNotFound getFaultMessage(){
       return faultMessage;
    }
}
    