
/**
 * LoyaltyServiceFault.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package com.bridge.loyalty.prepaid.server;

public class LoyaltyServiceFault extends java.lang.Exception{
    
    private com.bridge.loyalty.prepaid.LoyaltyServiceError faultMessage;

    
        public LoyaltyServiceFault() {
            super("LoyaltyServiceFault");
        }

        public LoyaltyServiceFault(java.lang.String s) {
           super(s);
        }

        public LoyaltyServiceFault(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public LoyaltyServiceFault(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.bridge.loyalty.prepaid.LoyaltyServiceError msg){
       faultMessage = msg;
    }
    
    public com.bridge.loyalty.prepaid.LoyaltyServiceError getFaultMessage(){
       return faultMessage;
    }
}
    