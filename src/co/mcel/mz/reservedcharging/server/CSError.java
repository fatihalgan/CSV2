
/**
 * CSError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package co.mcel.mz.reservedcharging.server;

public class CSError extends java.lang.Exception{
    
    private co.mcel.mz.reservedcharging.CsError faultMessage;

    
        public CSError() {
            super("CSError");
        }

        public CSError(java.lang.String s) {
           super(s);
        }

        public CSError(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public CSError(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(co.mcel.mz.reservedcharging.CsError msg){
       faultMessage = msg;
    }
    
    public co.mcel.mz.reservedcharging.CsError getFaultMessage(){
       return faultMessage;
    }
}
    