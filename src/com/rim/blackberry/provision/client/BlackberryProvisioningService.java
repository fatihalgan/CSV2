

/**
 * BlackberryProvisioningService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.rim.blackberry.provision.client;

    /*
     *  BlackberryProvisioningService java interface
     */

    public interface BlackberryProvisioningService {
          

        /**
          * Auto generated method signature
          * 
                    * @param submitSync
                
             * @throws com.rim.blackberry.provision.client.ARIProcessingException : 
         */

         
                     public com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply submitSync(

                        com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest req)
                        throws java.rmi.RemoteException
             
          ,com.rim.blackberry.provision.client.ARIProcessingException;

        

        /**
          * Auto generated method signature
          * 
                    * @param echoTest
                
             * @throws com.rim.blackberry.provision.client.ARIProcessingException : 
         */

         
                     public com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply echoTest(

                        com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest req0)
                        throws java.rmi.RemoteException
             
          ,com.rim.blackberry.provision.client.ARIProcessingException;

        

        
       //
       }
    