
/**
 * SimRegistrationServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package com.bridge.simreg.client;

        

        /*
        *  SimRegistrationServiceStub java implementation
        */

        
        public class SimRegistrationServiceStub extends org.apache.axis2.client.Stub
        implements SimRegistrationService{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("SimRegistrationService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[9];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "retrieveVerificationData"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "createNewPersonalRegistration"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "createNewPersonalRegistrationWithImages"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "checkRegistrationStatus"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "updateFormImageOnly"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "retrieveVerificationDataByDocumentNo"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "updateIDImageOnly"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "addCellToExistingSubscriber"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[7]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/simreg", "fastActivation"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[8]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         


    }

    /**
      *Constructor that takes in a configContext
      */

    public SimRegistrationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public SimRegistrationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
    
    }

    /**
     * Default Constructor
     */
    public SimRegistrationServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:8080/SIMRegistrationService/services/SimRegistrationService" );
                
    }

    /**
     * Default Constructor
     */
    public SimRegistrationServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:8080/SIMRegistrationService/services/SimRegistrationService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public SimRegistrationServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#retrieveVerificationData
                     * @param retrieveVerificationDataRequest29
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.RetrieveVerificationDataResponseType retrieveVerificationData(

                            com.bridge.simreg.wstypes.VerificationDataType verificationData30)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/retrieveVerificationData");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.RetrieveVerificationDataRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    verificationData30,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "retrieveVerificationData")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getretrieveVerificationData((com.bridge.simreg.wstypes.RetrieveVerificationDataResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#createNewPersonalRegistration
                     * @param createNewPersonalRegistrationRequest35
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponseType createNewPersonalRegistration(

                            java.math.BigInteger requestId36,java.util.Calendar requestTimestamp37,co.mcel.mz.types.common.MsisdnType cellNumber38,com.bridge.simreg.wstypes.IdentityDocType identityDocument39,com.bridge.simreg.wstypes.PersonInfoType personInfo40,com.bridge.simreg.wstypes.AddressType address41,com.bridge.simreg.wstypes.WorkInfoType workInfo42,java.math.BigInteger mKeshQuestion43,com.bridge.simreg.wstypes.AuthenticationEntityType authInfo44,com.bridge.simreg.wstypes.LocationCodesType locationCodes45)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/createNewPersonalRegistration");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    requestId36,
                                                    requestTimestamp37,
                                                    cellNumber38,
                                                    identityDocument39,
                                                    personInfo40,
                                                    address41,
                                                    workInfo42,
                                                    mKeshQuestion43,
                                                    authInfo44,
                                                    locationCodes45,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "createNewPersonalRegistration")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getcreateNewPersonalRegistration((com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#createNewPersonalRegistrationWithImages
                     * @param createNewPersonalRegistrationWithImagesRequest49
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponseType createNewPersonalRegistrationWithImages(

                            com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType createNewPersonalRegistrationRequest50,javax.activation.DataHandler identityDocumentImage51,javax.activation.DataHandler registrationFormCopy52)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/createNewPersonalRegistrationWithImages");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    createNewPersonalRegistrationRequest50,
                                                    identityDocumentImage51,
                                                    registrationFormCopy52,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "createNewPersonalRegistrationWithImages")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getcreateNewPersonalRegistrationWithImages((com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#checkRegistrationStatus
                     * @param checkRegistrationStatusRequest56
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.OperationResultType checkRegistrationStatus(

                            co.mcel.mz.types.common.MsisdnType cellNumber57,com.bridge.simreg.wstypes.AuthenticationEntityType authInfo58)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/checkRegistrationStatus");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.CheckRegistrationStatusRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cellNumber57,
                                                    authInfo58,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "checkRegistrationStatus")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.CheckRegistrationStatusResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getCheckRegistrationStatusResponseOperationResult((com.bridge.simreg.wstypes.CheckRegistrationStatusResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#updateFormImageOnly
                     * @param updateFormImageOnlyRequest61
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.OperationResultType updateFormImageOnly(

                            com.bridge.simreg.wstypes.VerificationDataType verificationData62,javax.activation.DataHandler registrationFormCopy63)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/updateFormImageOnly");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    verificationData62,
                                                    registrationFormCopy63,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "updateFormImageOnly")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getUpdateFormImageOnlyResponseOperationResult((com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#retrieveVerificationDataByDocumentNo
                     * @param retrieveVerificationDataRequest66
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.RetrieveVerificationDataResponseType retrieveVerificationDataByDocumentNo(

                            com.bridge.simreg.wstypes.VerificationDataType verificationData67)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/retrieveVerificationDataByDocumentNo");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.RetrieveVerificationDataRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    verificationData67,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "retrieveVerificationDataByDocumentNo")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getretrieveVerificationDataByDocumentNo((com.bridge.simreg.wstypes.RetrieveVerificationDataResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#updateIDImageOnly
                     * @param updateIDImageOnlyRequest72
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.OperationResultType updateIDImageOnly(

                            com.bridge.simreg.wstypes.VerificationDataType verificationData73,javax.activation.DataHandler identityDocumentImage74)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/updateIDImageOnly");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    verificationData73,
                                                    identityDocumentImage74,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "updateIDImageOnly")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getUpdateIDImageOnlyResponseOperationResult((com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#addCellToExistingSubscriber
                     * @param addCellToExistingSubscriberRequest77
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.OperationResultType addCellToExistingSubscriber(

                            java.math.BigInteger requestId78,java.util.Calendar requestTimestamp79,co.mcel.mz.types.common.MsisdnType cellNumber80,java.math.BigInteger subscriberInfoId81,com.bridge.simreg.wstypes.AuthenticationEntityType authInfo82)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/addCellToExistingSubscriber");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    requestId78,
                                                    requestTimestamp79,
                                                    cellNumber80,
                                                    subscriberInfoId81,
                                                    authInfo82,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "addCellToExistingSubscriber")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getAddCellToExistingSubscriberResponseOperationResult((com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.simreg.client.SimRegistrationService#fastActivation
                     * @param fastActivationRequest85
                    
                     */

                    

                            public  com.bridge.simreg.wstypes.OperationResultType fastActivation(

                            com.bridge.simreg.wstypes.FastActivationInfoType fastActivationInfo86)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/simreg/fastActivation");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.simreg.wstypes.FastActivationRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    fastActivationInfo86,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                    "fastActivation")));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             com.bridge.simreg.wstypes.FastActivationResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getFastActivationResponseOperationResult((com.bridge.simreg.wstypes.FastActivationResponse)object);
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(faultElt.getQName())){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(faultElt.getQName());
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.Exception ex=
                                (java.lang.Exception) exceptionClass.newInstance();
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(faultElt.getQName());
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
            }
        }
            


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://localhost:8080/SIMRegistrationService/services/SimRegistrationService
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.RetrieveVerificationDataRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.RetrieveVerificationDataResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.CheckRegistrationStatusRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.CheckRegistrationStatusRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.CheckRegistrationStatusResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.CheckRegistrationStatusResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.FastActivationRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.FastActivationRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.simreg.wstypes.FastActivationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.simreg.wstypes.FastActivationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.bridge.simreg.wstypes.VerificationDataType param1,
                                    com.bridge.simreg.wstypes.RetrieveVerificationDataRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.RetrieveVerificationDataRequest wrappedType = new com.bridge.simreg.wstypes.RetrieveVerificationDataRequest();

                                 com.bridge.simreg.wstypes.RetrieveVerificationDataRequestType wrappedComplexType = new com.bridge.simreg.wstypes.RetrieveVerificationDataRequestType();
                                          
                                              wrappedComplexType.setVerificationData(param1);
                                         
                                         wrappedType.setRetrieveVerificationDataRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.VerificationDataType getRetrieveVerificationDataResponseVerificationData(
                                com.bridge.simreg.wstypes.RetrieveVerificationDataResponse wrappedType){
                                
                                        return wrappedType.getRetrieveVerificationDataResponse().getVerificationData();
                                    
                                }
                             

                                
                                private java.math.BigInteger getRetrieveVerificationDataResponseSubscriberInfoId(
                                com.bridge.simreg.wstypes.RetrieveVerificationDataResponse wrappedType){
                                
                                        return wrappedType.getRetrieveVerificationDataResponse().getSubscriberInfoId();
                                    
                                }
                             

                                
                                private com.bridge.simreg.wstypes.OperationResultType getRetrieveVerificationDataResponseOperationResult(
                                com.bridge.simreg.wstypes.RetrieveVerificationDataResponse wrappedType){
                                
                                        return wrappedType.getRetrieveVerificationDataResponse().getOperationResult();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.RetrieveVerificationDataResponseType getretrieveVerificationData(
                                com.bridge.simreg.wstypes.RetrieveVerificationDataResponse wrappedType){
                                    return wrappedType.getRetrieveVerificationDataResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.math.BigInteger param1,
                                    java.util.Calendar param2,
                                    co.mcel.mz.types.common.MsisdnType param3,
                                    com.bridge.simreg.wstypes.IdentityDocType param4,
                                    com.bridge.simreg.wstypes.PersonInfoType param5,
                                    com.bridge.simreg.wstypes.AddressType param6,
                                    com.bridge.simreg.wstypes.WorkInfoType param7,
                                    java.math.BigInteger param8,
                                    com.bridge.simreg.wstypes.AuthenticationEntityType param9,
                                    com.bridge.simreg.wstypes.LocationCodesType param10,
                                    com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest wrappedType = new com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest();

                                 com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType wrappedComplexType = new com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType();
                                          
                                              wrappedComplexType.setRequestId(param1);
                                         
                                              wrappedComplexType.setRequestTimestamp(param2);
                                         
                                              wrappedComplexType.setCellNumber(param3);
                                         
                                              wrappedComplexType.setIdentityDocument(param4);
                                         
                                              wrappedComplexType.setPersonInfo(param5);
                                         
                                              wrappedComplexType.setAddress(param6);
                                         
                                              wrappedComplexType.setWorkInfo(param7);
                                         
                                              wrappedComplexType.setMKeshQuestion(param8);
                                         
                                              wrappedComplexType.setAuthInfo(param9);
                                         
                                              wrappedComplexType.setLocationCodes(param10);
                                         
                                         wrappedType.setCreateNewPersonalRegistrationRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.OperationResultType getCreateNewPersonalRegistrationResponseOperationResult(
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse wrappedType){
                                
                                        return wrappedType.getCreateNewPersonalRegistrationResponse().getOperationResult();
                                    
                                }
                             

                                
                                private java.math.BigInteger getCreateNewPersonalRegistrationResponseSubscriberInfoId(
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse wrappedType){
                                
                                        return wrappedType.getCreateNewPersonalRegistrationResponse().getSubscriberInfoId();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponseType getcreateNewPersonalRegistration(
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse wrappedType){
                                    return wrappedType.getCreateNewPersonalRegistrationResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequestType param1,
                                    javax.activation.DataHandler param2,
                                    javax.activation.DataHandler param3,
                                    com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest wrappedType = new com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest();

                                 com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequestType wrappedComplexType = new com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequestType();
                                          
                                              wrappedComplexType.setCreateNewPersonalRegistrationRequest(param1);
                                         
                                              wrappedComplexType.setIdentityDocumentImage(param2);
                                         
                                              wrappedComplexType.setRegistrationFormCopy(param3);
                                         
                                         wrappedType.setCreateNewPersonalRegistrationWithImagesRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                private com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponseType getcreateNewPersonalRegistrationWithImages(
                                com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse wrappedType){
                                    return wrappedType.getCreateNewPersonalRegistrationResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    com.bridge.simreg.wstypes.AuthenticationEntityType param2,
                                    com.bridge.simreg.wstypes.CheckRegistrationStatusRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.CheckRegistrationStatusRequest wrappedType = new com.bridge.simreg.wstypes.CheckRegistrationStatusRequest();

                                 com.bridge.simreg.wstypes.CheckRegistrationStatusRequestType wrappedComplexType = new com.bridge.simreg.wstypes.CheckRegistrationStatusRequestType();
                                          
                                              wrappedComplexType.setCellNumber(param1);
                                         
                                              wrappedComplexType.setAuthInfo(param2);
                                         
                                         wrappedType.setCheckRegistrationStatusRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.CheckRegistrationStatusRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.OperationResultType getCheckRegistrationStatusResponseOperationResult(
                                com.bridge.simreg.wstypes.CheckRegistrationStatusResponse wrappedType){
                                
                                        return wrappedType.getCheckRegistrationStatusResponse().getOperationResult();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.CheckRegistrationStatusResponseType getcheckRegistrationStatus(
                                com.bridge.simreg.wstypes.CheckRegistrationStatusResponse wrappedType){
                                    return wrappedType.getCheckRegistrationStatusResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.bridge.simreg.wstypes.VerificationDataType param1,
                                    javax.activation.DataHandler param2,
                                    com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest wrappedType = new com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest();

                                 com.bridge.simreg.wstypes.UpdateFormImageOnlyRequestType wrappedComplexType = new com.bridge.simreg.wstypes.UpdateFormImageOnlyRequestType();
                                          
                                              wrappedComplexType.setVerificationData(param1);
                                         
                                              wrappedComplexType.setRegistrationFormCopy(param2);
                                         
                                         wrappedType.setUpdateFormImageOnlyRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.OperationResultType getUpdateFormImageOnlyResponseOperationResult(
                                com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse wrappedType){
                                
                                        return wrappedType.getUpdateFormImageOnlyResponse().getOperationResult();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.UpdateFormImageOnlyResponseType getupdateFormImageOnly(
                                com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse wrappedType){
                                    return wrappedType.getUpdateFormImageOnlyResponse();
                                }

                                
                                
                            

                                private com.bridge.simreg.wstypes.RetrieveVerificationDataResponseType getretrieveVerificationDataByDocumentNo(
                                com.bridge.simreg.wstypes.RetrieveVerificationDataResponse wrappedType){
                                    return wrappedType.getRetrieveVerificationDataResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.bridge.simreg.wstypes.VerificationDataType param1,
                                    javax.activation.DataHandler param2,
                                    com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest wrappedType = new com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest();

                                 com.bridge.simreg.wstypes.UpdateIDImageOnlyRequestType wrappedComplexType = new com.bridge.simreg.wstypes.UpdateIDImageOnlyRequestType();
                                          
                                              wrappedComplexType.setVerificationData(param1);
                                         
                                              wrappedComplexType.setIdentityDocumentImage(param2);
                                         
                                         wrappedType.setUpdateIDImageOnlyRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.OperationResultType getUpdateIDImageOnlyResponseOperationResult(
                                com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse wrappedType){
                                
                                        return wrappedType.getUpdateIDImageOnlyResponse().getOperationResult();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.UpdateIDImageOnlyResponseType getupdateIDImageOnly(
                                com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse wrappedType){
                                    return wrappedType.getUpdateIDImageOnlyResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.math.BigInteger param1,
                                    java.util.Calendar param2,
                                    co.mcel.mz.types.common.MsisdnType param3,
                                    java.math.BigInteger param4,
                                    com.bridge.simreg.wstypes.AuthenticationEntityType param5,
                                    com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest wrappedType = new com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest();

                                 com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequestType wrappedComplexType = new com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequestType();
                                          
                                              wrappedComplexType.setRequestId(param1);
                                         
                                              wrappedComplexType.setRequestTimestamp(param2);
                                         
                                              wrappedComplexType.setCellNumber(param3);
                                         
                                              wrappedComplexType.setSubscriberInfoId(param4);
                                         
                                              wrappedComplexType.setAuthInfo(param5);
                                         
                                         wrappedType.setAddCellToExistingSubscriberRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.OperationResultType getAddCellToExistingSubscriberResponseOperationResult(
                                com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse wrappedType){
                                
                                        return wrappedType.getAddCellToExistingSubscriberResponse().getOperationResult();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponseType getaddCellToExistingSubscriber(
                                com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse wrappedType){
                                    return wrappedType.getAddCellToExistingSubscriberResponse();
                                }

                                
                                
                            
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.bridge.simreg.wstypes.FastActivationInfoType param1,
                                    com.bridge.simreg.wstypes.FastActivationRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.simreg.wstypes.FastActivationRequest wrappedType = new com.bridge.simreg.wstypes.FastActivationRequest();

                                 com.bridge.simreg.wstypes.FastActivationRequestType wrappedComplexType = new com.bridge.simreg.wstypes.FastActivationRequestType();
                                          
                                              wrappedComplexType.setFastActivationInfo(param1);
                                         
                                         wrappedType.setFastActivationRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.simreg.wstypes.FastActivationRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
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
                            

                                
                                private com.bridge.simreg.wstypes.OperationResultType getFastActivationResponseOperationResult(
                                com.bridge.simreg.wstypes.FastActivationResponse wrappedType){
                                
                                        return wrappedType.getFastActivationResponse().getOperationResult();
                                    
                                }
                             

                                private com.bridge.simreg.wstypes.FastActivationResponseType getfastActivation(
                                com.bridge.simreg.wstypes.FastActivationResponse wrappedType){
                                    return wrappedType.getFastActivationResponse();
                                }

                                
                                
                            


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.CreateNewPersonalRegistrationRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.CreateNewPersonalRegistrationWithImagesRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.CreateNewPersonalRegistrationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.CheckRegistrationStatusRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.CheckRegistrationStatusRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.CheckRegistrationStatusResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.CheckRegistrationStatusResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.UpdateFormImageOnlyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.UpdateFormImageOnlyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.RetrieveVerificationDataRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.RetrieveVerificationDataResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.UpdateIDImageOnlyRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.UpdateIDImageOnlyResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.AddCellToExistingSubscriberRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.AddCellToExistingSubscriberResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.FastActivationRequest.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.FastActivationRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.simreg.wstypes.FastActivationResponse.class.equals(type)){
                
                           return com.bridge.simreg.wstypes.FastActivationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   