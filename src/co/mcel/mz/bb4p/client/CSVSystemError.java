
/**
 * CSVSystemError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package co.mcel.mz.bb4p.client;

public class CSVSystemError extends java.lang.Exception{
    
    private co.mcel.mz.bb4p.CsvSystemError faultMessage;

    
        public CSVSystemError() {
            super("CSVSystemError");
        }

        public CSVSystemError(java.lang.String s) {
           super(s);
        }

        public CSVSystemError(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CSVSystemError(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(co.mcel.mz.bb4p.CsvSystemError msg){
       faultMessage = msg;
    }
    
    public co.mcel.mz.bb4p.CsvSystemError getFaultMessage(){
       return faultMessage;
    }
}
    