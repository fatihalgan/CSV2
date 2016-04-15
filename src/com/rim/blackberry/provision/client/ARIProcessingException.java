
/**
 * ARIProcessingException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package com.rim.blackberry.provision.client;

public class ARIProcessingException extends java.lang.Exception{
    
    private com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE faultMessage;

    
        public ARIProcessingException() {
            super("ARIProcessingException");
        }

        public ARIProcessingException(java.lang.String s) {
           super(s);
        }

        public ARIProcessingException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public ARIProcessingException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE msg){
       faultMessage = msg;
    }
    
    public com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE getFaultMessage(){
       return faultMessage;
    }
}
    