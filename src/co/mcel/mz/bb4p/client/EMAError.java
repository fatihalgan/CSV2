
/**
 * EMAError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package co.mcel.mz.bb4p.client;

public class EMAError extends java.lang.Exception{
    
    private co.mcel.mz.bb4p.EmaError faultMessage;

    
        public EMAError() {
            super("EMAError");
        }

        public EMAError(java.lang.String s) {
           super(s);
        }

        public EMAError(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public EMAError(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(co.mcel.mz.bb4p.EmaError msg){
       faultMessage = msg;
    }
    
    public co.mcel.mz.bb4p.EmaError getFaultMessage(){
       return faultMessage;
    }
}
    