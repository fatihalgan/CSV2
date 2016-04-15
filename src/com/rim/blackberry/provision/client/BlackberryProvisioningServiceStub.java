
/**
 * BlackberryProvisioningServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package com.rim.blackberry.provision.client;

        

        /*
        *  BlackberryProvisioningServiceStub java implementation
        */

        
        public class BlackberryProvisioningServiceStub extends org.apache.axis2.client.Stub
        implements BlackberryProvisioningService{
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
     _service = new org.apache.axis2.description.AxisService("BlackberryProvisioningService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.blackberry.com/webservices/Provisioning", "submitSync"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.blackberry.com/webservices/Provisioning", "echoTest"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("java:provision.control.ari","ARIProcessingException"),"com.rim.blackberry.provision.client.ARIProcessingException");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("java:provision.control.ari","ARIProcessingException"),"com.rim.blackberry.provision.client.ARIProcessingException");
              faultMessageMap.put( new javax.xml.namespace.QName("java:provision.control.ari","ARIProcessingException"),"com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("java:provision.control.ari","ARIProcessingException"),"com.rim.blackberry.provision.client.ARIProcessingException");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("java:provision.control.ari","ARIProcessingException"),"com.rim.blackberry.provision.client.ARIProcessingException");
              faultMessageMap.put( new javax.xml.namespace.QName("java:provision.control.ari","ARIProcessingException"),"com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public BlackberryProvisioningServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public BlackberryProvisioningServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public BlackberryProvisioningServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://man2101:8001/ws-doc-literal/Provisioning" );
                
    }

    /**
     * Default Constructor
     */
    public BlackberryProvisioningServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("https://mcel.provisioning.blackberry.com/ws-doc-literal/Provisioning" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public BlackberryProvisioningServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.rim.blackberry.provision.client.BlackberryProvisioningService#submitSync
                     * @param submitSync2
                    
                     * @throws com.rim.blackberry.provision.client.ARIProcessingException : 
                     */

                    

                            public  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply submitSync(

                            com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest req3)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.rim.blackberry.provision.client.ARIProcessingException{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://www.blackberry.com/webservices/Provisioning/ProvisioningRequestWSPortType/submitSyncRequest");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.rim.blackberry.provision.SubmitSync dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    req3,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.blackberry.com/webservices/Provisioning",
                                                    "submitSync")));
                                                
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
                                             com.rim.blackberry.provision.SubmitSyncResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getSubmitSyncResponse_return((com.rim.blackberry.provision.SubmitSyncResponse)object);
                                   
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
                        
                        if (ex instanceof com.rim.blackberry.provision.client.ARIProcessingException){
                          throw (com.rim.blackberry.provision.client.ARIProcessingException)ex;
                        }
                        

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
                     * @see com.rim.blackberry.provision.client.BlackberryProvisioningService#echoTest
                     * @param echoTest6
                    
                     * @throws com.rim.blackberry.provision.client.ARIProcessingException : 
                     */

                    

                            public  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply echoTest(

                            com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest req7)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.rim.blackberry.provision.client.ARIProcessingException{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://www.blackberry.com/webservices/Provisioning/ProvisioningRequestWSPortType/echoTestRequest");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.rim.blackberry.provision.EchoTest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    req7,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.blackberry.com/webservices/Provisioning",
                                                    "echoTest")));
                                                
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
                                             com.rim.blackberry.provision.EchoTestResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getEchoTestResponse_return((com.rim.blackberry.provision.EchoTestResponse)object);
                                   
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
                        
                        if (ex instanceof com.rim.blackberry.provision.client.ARIProcessingException){
                          throw (com.rim.blackberry.provision.client.ARIProcessingException)ex;
                        }
                        

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
     //http://man2101:8001/ws-doc-literal/Provisioning
            private  org.apache.axiom.om.OMElement  toOM(com.rim.blackberry.provision.SubmitSync param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.rim.blackberry.provision.SubmitSync.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.rim.blackberry.provision.SubmitSyncResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.rim.blackberry.provision.SubmitSyncResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.rim.blackberry.provision.EchoTest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.rim.blackberry.provision.EchoTest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.rim.blackberry.provision.EchoTestResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.rim.blackberry.provision.EchoTestResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest param1,
                                    com.rim.blackberry.provision.SubmitSync dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.rim.blackberry.provision.SubmitSync wrappedType = new com.rim.blackberry.provision.SubmitSync();

                                 
                                              wrappedType.setReq(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.rim.blackberry.provision.SubmitSync.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply getSubmitSyncResponse_return(
                                com.rim.blackberry.provision.SubmitSyncResponse wrappedType){
                                
                                        return wrappedType.get_return();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest param1,
                                    com.rim.blackberry.provision.EchoTest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.rim.blackberry.provision.EchoTest wrappedType = new com.rim.blackberry.provision.EchoTest();

                                 
                                              wrappedType.setReq(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.rim.blackberry.provision.EchoTest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply getEchoTestResponse_return(
                                com.rim.blackberry.provision.EchoTestResponse wrappedType){
                                
                                        return wrappedType.get_return();
                                    
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
        
                if (com.rim.blackberry.provision.SubmitSync.class.equals(type)){
                
                           return com.rim.blackberry.provision.SubmitSync.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.rim.blackberry.provision.SubmitSyncResponse.class.equals(type)){
                
                           return com.rim.blackberry.provision.SubmitSyncResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE.class.equals(type)){
                
                           return com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.rim.blackberry.provision.EchoTest.class.equals(type)){
                
                           return com.rim.blackberry.provision.EchoTest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.rim.blackberry.provision.EchoTestResponse.class.equals(type)){
                
                           return com.rim.blackberry.provision.EchoTestResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE.class.equals(type)){
                
                           return com.rim.blackberry.provision.control.ari.ARIProcessingExceptionE.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   