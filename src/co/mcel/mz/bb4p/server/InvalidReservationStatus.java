
/**
 * InvalidReservationStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package co.mcel.mz.bb4p.server;

public class InvalidReservationStatus extends java.lang.Exception{
    
    private co.mcel.mz.bb4p.InvalidReservationStatus faultMessage;

    
        public InvalidReservationStatus() {
            super("InvalidReservationStatus");
        }

        public InvalidReservationStatus(java.lang.String s) {
           super(s);
        }

        public InvalidReservationStatus(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public InvalidReservationStatus(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(co.mcel.mz.bb4p.InvalidReservationStatus msg){
       faultMessage = msg;
    }
    
    public co.mcel.mz.bb4p.InvalidReservationStatus getFaultMessage(){
       return faultMessage;
    }
}
    