
/**
 * PrepaidLoyaltyServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package com.bridge.loyalty.prepaid.client;

        

        /*
        *  PrepaidLoyaltyServiceStub java implementation
        */

        
        public class PrepaidLoyaltyServiceStub extends org.apache.axis2.client.Stub
        implements PrepaidLoyaltyService{
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
     _service = new org.apache.axis2.description.AxisService("PrepaidLoyaltyService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[2];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/", "adjustLoyaltyPoints"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/", "queryLoyaltyPoints"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/","loyaltyServiceError"),"com.bridge.loyalty.prepaid.client.LoyaltyServiceFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/","loyaltyServiceError"),"com.bridge.loyalty.prepaid.client.LoyaltyServiceFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/","loyaltyServiceError"),"com.bridge.loyalty.prepaid.LoyaltyServiceError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/","loyaltyServiceError"),"com.bridge.loyalty.prepaid.client.LoyaltyServiceFault");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/","loyaltyServiceError"),"com.bridge.loyalty.prepaid.client.LoyaltyServiceFault");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/","loyaltyServiceError"),"com.bridge.loyalty.prepaid.LoyaltyServiceError");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public PrepaidLoyaltyServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public PrepaidLoyaltyServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public PrepaidLoyaltyServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:8080/CSV/services/PrepaidLoyaltyService" );
                
    }

    /**
     * Default Constructor
     */
    public PrepaidLoyaltyServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:8080/CSV/services/PrepaidLoyaltyService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public PrepaidLoyaltyServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.loyalty.prepaid.client.PrepaidLoyaltyService#adjustLoyaltyPoints
                     * @param adjustPointsRequest1
                    
                     * @throws com.bridge.loyalty.prepaid.client.LoyaltyServiceFault : 
                     */

                    

                            public  com.bridge.loyalty.prepaid.AdjustPointsResponse adjustLoyaltyPoints(

                            co.mcel.mz.types.common.MsisdnType msisdn2,java.lang.String originTransId3,java.math.BigDecimal relativeAmount4,com.bridge.loyalty.prepaid.AdjustmentType pointsAdjustmentType5)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.loyalty.prepaid.client.LoyaltyServiceFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/PrepaidLoyaltyService/adjustPoints");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.loyalty.prepaid.AdjustPointsRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn2,
                                                    originTransId3,
                                                    relativeAmount4,
                                                    pointsAdjustmentType5,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/",
                                                    "adjustLoyaltyPoints")));
                                                
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
                                             com.bridge.loyalty.prepaid.AdjustPointsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.bridge.loyalty.prepaid.AdjustPointsResponse)object;
                                   
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
                        
                        if (ex instanceof com.bridge.loyalty.prepaid.client.LoyaltyServiceFault){
                          throw (com.bridge.loyalty.prepaid.client.LoyaltyServiceFault)ex;
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
                     * @see com.bridge.loyalty.prepaid.client.PrepaidLoyaltyService#queryLoyaltyPoints
                     * @param queryPointsRequest10
                    
                     * @throws com.bridge.loyalty.prepaid.client.LoyaltyServiceFault : 
                     */

                    

                            public  java.math.BigDecimal queryLoyaltyPoints(

                            co.mcel.mz.types.common.MsisdnType msisdn11)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.loyalty.prepaid.client.LoyaltyServiceFault{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/PrepaidLoyaltyService/queryPoints");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.loyalty.prepaid.QueryPointsRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn11,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/PrepaidLoyaltyService/",
                                                    "queryLoyaltyPoints")));
                                                
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
                                             com.bridge.loyalty.prepaid.QueryPointsResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getQueryPointsResponseTotalPoints((com.bridge.loyalty.prepaid.QueryPointsResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.loyalty.prepaid.client.LoyaltyServiceFault){
                          throw (com.bridge.loyalty.prepaid.client.LoyaltyServiceFault)ex;
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
     //http://localhost:8080/CSV/services/PrepaidLoyaltyService
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.loyalty.prepaid.AdjustPointsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.loyalty.prepaid.AdjustPointsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.loyalty.prepaid.AdjustPointsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.loyalty.prepaid.AdjustPointsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.loyalty.prepaid.LoyaltyServiceError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.loyalty.prepaid.LoyaltyServiceError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.loyalty.prepaid.QueryPointsRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.loyalty.prepaid.QueryPointsRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.loyalty.prepaid.QueryPointsResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.loyalty.prepaid.QueryPointsResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    java.math.BigDecimal param3,
                                    com.bridge.loyalty.prepaid.AdjustmentType param4,
                                    com.bridge.loyalty.prepaid.AdjustPointsRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.loyalty.prepaid.AdjustPointsRequest wrappedType = new com.bridge.loyalty.prepaid.AdjustPointsRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setOriginTransId(param2);
                                         
                                              wrappedType.setRelativeAmount(param3);
                                         
                                              wrappedType.setPointsAdjustmentType(param4);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.loyalty.prepaid.AdjustPointsRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private long getAdjustPointsResponseTransactionId(
                                com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedType){
                                
                                        return wrappedType.getTransactionId();
                                    
                                }
                             

                                
                                private java.math.BigDecimal getAdjustPointsResponseAdjustedAmount(
                                com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedType){
                                
                                        return wrappedType.getAdjustedAmount();
                                    
                                }
                             

                                
                                private java.math.BigDecimal getAdjustPointsResponseRemainingPoints(
                                com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedType){
                                
                                        return wrappedType.getRemainingPoints();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    com.bridge.loyalty.prepaid.QueryPointsRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.loyalty.prepaid.QueryPointsRequest wrappedType = new com.bridge.loyalty.prepaid.QueryPointsRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.loyalty.prepaid.QueryPointsRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private java.math.BigDecimal getQueryPointsResponseTotalPoints(
                                com.bridge.loyalty.prepaid.QueryPointsResponse wrappedType){
                                
                                        return wrappedType.getTotalPoints();
                                    
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
        
                if (com.bridge.loyalty.prepaid.AdjustPointsRequest.class.equals(type)){
                
                           return com.bridge.loyalty.prepaid.AdjustPointsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.loyalty.prepaid.AdjustPointsResponse.class.equals(type)){
                
                           return com.bridge.loyalty.prepaid.AdjustPointsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.loyalty.prepaid.LoyaltyServiceError.class.equals(type)){
                
                           return com.bridge.loyalty.prepaid.LoyaltyServiceError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.loyalty.prepaid.QueryPointsRequest.class.equals(type)){
                
                           return com.bridge.loyalty.prepaid.QueryPointsRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.loyalty.prepaid.QueryPointsResponse.class.equals(type)){
                
                           return com.bridge.loyalty.prepaid.QueryPointsResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.loyalty.prepaid.LoyaltyServiceError.class.equals(type)){
                
                           return com.bridge.loyalty.prepaid.LoyaltyServiceError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   