

/**
 * CCT_UserRepoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.novabase.cct.client;

    /*
     *  CCT_UserRepoService java interface
     */

    public interface CCT_UserRepoService {
          

        /**
          * Auto generated method signature
          * 
                    * @param agentInsert
                
         */

         
                     public com.novabase.cct.types.ErrorInfo agentInsert(

                        java.lang.String username,java.lang.String password,java.lang.String email)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param agentInsertWithSiteId
                
         */

         
                     public com.novabase.cct.types.ErrorInfo agentInsertWithSiteId(

                        java.lang.String username0,java.lang.String password1,java.lang.String email2,int siteId)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param userUpdatePassword
                
         */

         
                     public com.novabase.cct.types.ErrorInfo userUpdatePassword(

                        java.lang.String username3,java.lang.String password4)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param agentDelete
                
         */

         
                     public com.novabase.cct.types.ErrorInfo agentDelete(

                        java.lang.String username5)
                        throws java.rmi.RemoteException
             ;

        

        
       //
       }
    