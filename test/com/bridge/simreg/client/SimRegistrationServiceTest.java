

/**
 * SimRegistrationServiceTest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
    package com.bridge.simreg.client;

    /*
     *  SimRegistrationServiceTest Junit test case
    */

    public class SimRegistrationServiceTest extends junit.framework.TestCase{

     
        /**
         * Auto generated test method
         */
        public  void testretrieveVerificationData() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.RetrieveVerificationDataRequest retrieveVerificationDataRequest149=
                                                        (com.bridge.simreg.wstypes.RetrieveVerificationDataRequest)getTestObject(com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.class);
                    // TODO : Fill in the retrieveVerificationDataRequest149 here
                
                        assertNotNull(stub.retrieveVerificationData(
                        getVerificationData(retrieveVerificationDataRequest149)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testcreateNewPersonalRegistration() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest createNewPersonalRegistrationRequest155=
                                                        (com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest)getTestObject(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest.class);
                    // TODO : Fill in the createNewPersonalRegistrationRequest155 here
                
                        assertNotNull(stub.createNewPersonalRegistration(
                        getRequestId(createNewPersonalRegistrationRequest155)
                                      ,getRequestTimestamp(createNewPersonalRegistrationRequest155)
                                      ,getCellNumber(createNewPersonalRegistrationRequest155)
                                      ,getIdentityDocument(createNewPersonalRegistrationRequest155)
                                      ,getPersonInfo(createNewPersonalRegistrationRequest155)
                                      ,getAddress(createNewPersonalRegistrationRequest155)
                                      ,getWorkInfo(createNewPersonalRegistrationRequest155)
                                      ,getMKeshQuestion(createNewPersonalRegistrationRequest155)
                                      ,getAuthInfo(createNewPersonalRegistrationRequest155)
                                      ,getLocationCodes(createNewPersonalRegistrationRequest155)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testcreateNewPersonalRegistrationWithImages() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest createNewPersonalRegistrationWithImagesRequest169=
                                                        (com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest)getTestObject(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest.class);
                    // TODO : Fill in the createNewPersonalRegistrationWithImagesRequest169 here
                
                        assertNotNull(stub.createNewPersonalRegistrationWithImages(
                        getCreateNewPersonalRegistrationRequest(createNewPersonalRegistrationWithImagesRequest169)
                                      ,getIdentityDocumentImage(createNewPersonalRegistrationWithImagesRequest169)
                                      ,getRegistrationFormCopy(createNewPersonalRegistrationWithImagesRequest169)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testcheckRegistrationStatus() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.CheckRegistrationStatusRequest checkRegistrationStatusRequest176=
                                                        (com.bridge.simreg.wstypes.CheckRegistrationStatusRequest)getTestObject(com.bridge.simreg.wstypes.CheckRegistrationStatusRequest.class);
                    // TODO : Fill in the checkRegistrationStatusRequest176 here
                
                        assertNotNull(stub.checkRegistrationStatus(
                        getCellNumber(checkRegistrationStatusRequest176)
                                      ,getAuthInfo(checkRegistrationStatusRequest176)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testupdateFormImageOnly() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest updateFormImageOnlyRequest181=
                                                        (com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest)getTestObject(com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest.class);
                    // TODO : Fill in the updateFormImageOnlyRequest181 here
                
                        assertNotNull(stub.updateFormImageOnly(
                        getVerificationData(updateFormImageOnlyRequest181)
                                      ,getRegistrationFormCopy(updateFormImageOnlyRequest181)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testretrieveVerificationDataByDocumentNo() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.RetrieveVerificationDataRequest retrieveVerificationDataRequest186=
                                                        (com.bridge.simreg.wstypes.RetrieveVerificationDataRequest)getTestObject(com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.class);
                    // TODO : Fill in the retrieveVerificationDataRequest186 here
                
                        assertNotNull(stub.retrieveVerificationDataByDocumentNo(
                        getVerificationData(retrieveVerificationDataRequest186)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testupdateIDImageOnly() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest updateIDImageOnlyRequest192=
                                                        (com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest)getTestObject(com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest.class);
                    // TODO : Fill in the updateIDImageOnlyRequest192 here
                
                        assertNotNull(stub.updateIDImageOnly(
                        getVerificationData(updateIDImageOnlyRequest192)
                                      ,getIdentityDocumentImage(updateIDImageOnlyRequest192)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testaddCellToExistingSubscriber() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest addCellToExistingSubscriberRequest197=
                                                        (com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest)getTestObject(com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest.class);
                    // TODO : Fill in the addCellToExistingSubscriberRequest197 here
                
                        assertNotNull(stub.addCellToExistingSubscriber(
                        getRequestId(addCellToExistingSubscriberRequest197)
                                      ,getRequestTimestamp(addCellToExistingSubscriberRequest197)
                                      ,getCellNumber(addCellToExistingSubscriberRequest197)
                                      ,getSubscriberInfoId(addCellToExistingSubscriberRequest197)
                                      ,getAuthInfo(addCellToExistingSubscriberRequest197)
                                      ));
                  



        }
        
        /**
         * Auto generated test method
         */
        public  void testfastActivation() throws java.lang.Exception{

        com.bridge.simreg.client.SimRegistrationServiceStub stub =
                    new com.bridge.simreg.client.SimRegistrationServiceStub();//the default implementation should point to the right endpoint

           com.bridge.simreg.wstypes.FastActivationRequest fastActivationRequest205=
                                                        (com.bridge.simreg.wstypes.FastActivationRequest)getTestObject(com.bridge.simreg.wstypes.FastActivationRequest.class);
                    // TODO : Fill in the fastActivationRequest205 here
                
                        assertNotNull(stub.fastActivation(
                        getFastActivationInfo(fastActivationRequest205)
                                      ));
                  



        }
        
        //Create an ADBBean and provide it as the test object
        public org.apache.axis2.databinding.ADBBean getTestObject(java.lang.Class type) throws java.lang.Exception{
           return (org.apache.axis2.databinding.ADBBean) type.newInstance();
        }

        
        

                            private com.bridge.simreg.wstypes.VerificationDataType getVerificationData(
                            com.bridge.simreg.wstypes.RetrieveVerificationDataRequest wrappedType){
                            
                                    return wrappedType.getRetrieveVerificationDataRequest().getVerificationData();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.RetrieveVerificationDataRequestType getretrieveVerificationData(
                            com.bridge.simreg.wstypes.RetrieveVerificationDataRequest wrappedType){
                                return wrappedType.getRetrieveVerificationDataRequest();
                            }
                            private com.bridge.simreg.wstypes.RetrieveVerificationDataRequest wrapretrieveVerificationData(
                            com.bridge.simreg.wstypes.RetrieveVerificationDataRequestType innerType){
                                com.bridge.simreg.wstypes.RetrieveVerificationDataRequest wrappedElement = new com.bridge.simreg.wstypes.RetrieveVerificationDataRequest();
                                wrappedElement.setRetrieveVerificationDataRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private java.math.BigInteger getRequestId(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getRequestId();
                                
                            }

                         

                            private java.util.Calendar getRequestTimestamp(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getRequestTimestamp();
                                
                            }

                         

                            private co.mcel.mz.types.common.MsisdnType getCellNumber(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getCellNumber();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.IdentityDocType getIdentityDocument(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getIdentityDocument();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.PersonInfoType getPersonInfo(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getPersonInfo();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.AddressType getAddress(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getAddress();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.WorkInfoType getWorkInfo(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getWorkInfo();
                                
                            }

                         

                            private java.math.BigInteger getMKeshQuestion(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getMKeshQuestion();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.AuthenticationEntityType getAuthInfo(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getAuthInfo();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.LocationCodesType getLocationCodes(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationRequest().getLocationCodes();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType getcreateNewPersonalRegistration(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType){
                                return wrappedType.getCreateNewPersonalRegistrationRequest();
                            }
                            private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrapcreateNewPersonalRegistration(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType innerType){
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedElement = new com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest();
                                wrappedElement.setCreateNewPersonalRegistrationRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType getCreateNewPersonalRegistrationRequest(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationWithImagesRequest().getCreateNewPersonalRegistrationRequest();
                                
                            }

                         

                            private javax.activation.DataHandler getIdentityDocumentImage(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationWithImagesRequest().getIdentityDocumentImage();
                                
                            }

                         

                            private javax.activation.DataHandler getRegistrationFormCopy(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrappedType){
                            
                                    return wrappedType.getCreateNewPersonalRegistrationWithImagesRequest().getRegistrationFormCopy();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequestType getcreateNewPersonalRegistrationWithImages(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrappedType){
                                return wrappedType.getCreateNewPersonalRegistrationWithImagesRequest();
                            }
                            private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrapcreateNewPersonalRegistrationWithImages(
                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequestType innerType){
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrappedElement = new com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest();
                                wrappedElement.setCreateNewPersonalRegistrationWithImagesRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private co.mcel.mz.types.common.MsisdnType getCellNumber(
                            com.bridge.simreg.wstypes.CheckRegistrationStatusRequest wrappedType){
                            
                                    return wrappedType.getCheckRegistrationStatusRequest().getCellNumber();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.AuthenticationEntityType getAuthInfo(
                            com.bridge.simreg.wstypes.CheckRegistrationStatusRequest wrappedType){
                            
                                    return wrappedType.getCheckRegistrationStatusRequest().getAuthInfo();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.CheckRegistrationStatusRequestType getcheckRegistrationStatus(
                            com.bridge.simreg.wstypes.CheckRegistrationStatusRequest wrappedType){
                                return wrappedType.getCheckRegistrationStatusRequest();
                            }
                            private com.bridge.simreg.wstypes.CheckRegistrationStatusRequest wrapcheckRegistrationStatus(
                            com.bridge.simreg.wstypes.CheckRegistrationStatusRequestType innerType){
                                com.bridge.simreg.wstypes.CheckRegistrationStatusRequest wrappedElement = new com.bridge.simreg.wstypes.CheckRegistrationStatusRequest();
                                wrappedElement.setCheckRegistrationStatusRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private com.bridge.simreg.wstypes.VerificationDataType getVerificationData(
                            com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest wrappedType){
                            
                                    return wrappedType.getUpdateFormImageOnlyRequest().getVerificationData();
                                
                            }

                         

                            private javax.activation.DataHandler getRegistrationFormCopy(
                            com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest wrappedType){
                            
                                    return wrappedType.getUpdateFormImageOnlyRequest().getRegistrationFormCopy();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.UpdateFormImageOnlyRequestType getupdateFormImageOnly(
                            com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest wrappedType){
                                return wrappedType.getUpdateFormImageOnlyRequest();
                            }
                            private com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest wrapupdateFormImageOnly(
                            com.bridge.simreg.wstypes.UpdateFormImageOnlyRequestType innerType){
                                com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest wrappedElement = new com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest();
                                wrappedElement.setUpdateFormImageOnlyRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private com.bridge.simreg.wstypes.VerificationDataType getVerificationData(
                            com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest wrappedType){
                            
                                    return wrappedType.getUpdateIDImageOnlyRequest().getVerificationData();
                                
                            }

                         

                            private javax.activation.DataHandler getIdentityDocumentImage(
                            com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest wrappedType){
                            
                                    return wrappedType.getUpdateIDImageOnlyRequest().getIdentityDocumentImage();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.UpdateIDImageOnlyRequestType getupdateIDImageOnly(
                            com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest wrappedType){
                                return wrappedType.getUpdateIDImageOnlyRequest();
                            }
                            private com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest wrapupdateIDImageOnly(
                            com.bridge.simreg.wstypes.UpdateIDImageOnlyRequestType innerType){
                                com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest wrappedElement = new com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest();
                                wrappedElement.setUpdateIDImageOnlyRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private java.math.BigInteger getRequestId(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType){
                            
                                    return wrappedType.getAddCellToExistingSubscriberRequest().getRequestId();
                                
                            }

                         

                            private java.util.Calendar getRequestTimestamp(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType){
                            
                                    return wrappedType.getAddCellToExistingSubscriberRequest().getRequestTimestamp();
                                
                            }

                         

                            private co.mcel.mz.types.common.MsisdnType getCellNumber(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType){
                            
                                    return wrappedType.getAddCellToExistingSubscriberRequest().getCellNumber();
                                
                            }

                         

                            private java.math.BigInteger getSubscriberInfoId(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType){
                            
                                    return wrappedType.getAddCellToExistingSubscriberRequest().getSubscriberInfoId();
                                
                            }

                         

                            private com.bridge.simreg.wstypes.AuthenticationEntityType getAuthInfo(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType){
                            
                                    return wrappedType.getAddCellToExistingSubscriberRequest().getAuthInfo();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequestType getaddCellToExistingSubscriber(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType){
                                return wrappedType.getAddCellToExistingSubscriberRequest();
                            }
                            private com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrapaddCellToExistingSubscriber(
                            com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequestType innerType){
                                com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedElement = new com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest();
                                wrappedElement.setAddCellToExistingSubscriberRequest(innerType);
                                return wrappedElement;
                            }
                        

                            private com.bridge.simreg.wstypes.FastActivationInfoType getFastActivationInfo(
                            com.bridge.simreg.wstypes.FastActivationRequest wrappedType){
                            
                                    return wrappedType.getFastActivationRequest().getFastActivationInfo();
                                
                            }

                         
                            private com.bridge.simreg.wstypes.FastActivationRequestType getfastActivation(
                            com.bridge.simreg.wstypes.FastActivationRequest wrappedType){
                                return wrappedType.getFastActivationRequest();
                            }
                            private com.bridge.simreg.wstypes.FastActivationRequest wrapfastActivation(
                            com.bridge.simreg.wstypes.FastActivationRequestType innerType){
                                com.bridge.simreg.wstypes.FastActivationRequest wrappedElement = new com.bridge.simreg.wstypes.FastActivationRequest();
                                wrappedElement.setFastActivationRequest(innerType);
                                return wrappedElement;
                            }
                        

    }
    