

/**
 * SimRegistrationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */

    package com.bridge.simreg.client;

    /*
     *  SimRegistrationService java interface
     */

    public interface SimRegistrationService {
          

        /**
          * Auto generated method signature
          * 
                    * @param retrieveVerificationDataRequest
                
         */

         
                     public com.bridge.simreg.wstypes.RetrieveVerificationDataResponseType retrieveVerificationData(

                        com.bridge.simreg.wstypes.VerificationDataType verificationData)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param createNewPersonalRegistrationRequest
                
         */

         
                     public com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponseType createNewPersonalRegistration(

                        java.math.BigInteger requestId,java.util.Calendar requestTimestamp,co.mcel.mz.types.common.MsisdnType cellNumber,com.bridge.simreg.wstypes.IdentityDocType identityDocument,com.bridge.simreg.wstypes.PersonInfoType personInfo,com.bridge.simreg.wstypes.AddressType address,com.bridge.simreg.wstypes.WorkInfoType workInfo,java.math.BigInteger mKeshQuestion,com.bridge.simreg.wstypes.AuthenticationEntityType authInfo,com.bridge.simreg.wstypes.LocationCodesType locationCodes)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param createNewPersonalRegistrationWithImagesRequest
                
         */

         
                     public com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponseType createNewPersonalRegistrationWithImages(

                        com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType createNewPersonalRegistrationRequest3,javax.activation.DataHandler identityDocumentImage,javax.activation.DataHandler registrationFormCopy)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param checkRegistrationStatusRequest
                
         */

         
                     public com.bridge.simreg.wstypes.OperationResultType checkRegistrationStatus(

                        co.mcel.mz.types.common.MsisdnType cellNumber7,com.bridge.simreg.wstypes.AuthenticationEntityType authInfo8)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param updateFormImageOnlyRequest
                
         */

         
                     public com.bridge.simreg.wstypes.OperationResultType updateFormImageOnly(

                        com.bridge.simreg.wstypes.VerificationDataType verificationData10,javax.activation.DataHandler registrationFormCopy11)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param retrieveVerificationDataRequest13
                
         */

         
                     public com.bridge.simreg.wstypes.RetrieveVerificationDataResponseType retrieveVerificationDataByDocumentNo(

                        com.bridge.simreg.wstypes.VerificationDataType verificationData14)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param updateIDImageOnlyRequest
                
         */

         
                     public com.bridge.simreg.wstypes.OperationResultType updateIDImageOnly(

                        com.bridge.simreg.wstypes.VerificationDataType verificationData19,javax.activation.DataHandler identityDocumentImage20)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param addCellToExistingSubscriberRequest
                
         */

         
                     public com.bridge.simreg.wstypes.OperationResultType addCellToExistingSubscriber(

                        java.math.BigInteger requestId22,java.util.Calendar requestTimestamp23,co.mcel.mz.types.common.MsisdnType cellNumber24,java.math.BigInteger subscriberInfoId25,com.bridge.simreg.wstypes.AuthenticationEntityType authInfo26)
                        throws java.rmi.RemoteException
             ;

        

        /**
          * Auto generated method signature
          * 
                    * @param fastActivationRequest
                
         */

         
                     public com.bridge.simreg.wstypes.OperationResultType fastActivation(

                        com.bridge.simreg.wstypes.FastActivationInfoType fastActivationInfo)
                        throws java.rmi.RemoteException
             ;

        

        
       //
       }
    