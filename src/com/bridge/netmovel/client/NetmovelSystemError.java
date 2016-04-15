
/**
 * NetmovelSystemError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

package com.bridge.netmovel.client;

public class NetmovelSystemError extends java.lang.Exception{
    
    private com.bridge.netmovel.NetmovelSystemError faultMessage;

    
        public NetmovelSystemError() {
            super("NetmovelSystemError");
        }

        public NetmovelSystemError(java.lang.String s) {
           super(s);
        }

        public NetmovelSystemError(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public NetmovelSystemError(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(com.bridge.netmovel.NetmovelSystemError msg){
       faultMessage = msg;
    }
    
    public com.bridge.netmovel.NetmovelSystemError getFaultMessage(){
       return faultMessage;
    }
}
    