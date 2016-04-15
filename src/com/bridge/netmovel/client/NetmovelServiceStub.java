
/**
 * NetmovelServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package com.bridge.netmovel.client;

        

        /*
        *  NetmovelServiceStub java implementation
        */

        
        public class NetmovelServiceStub extends org.apache.axis2.client.Stub
        implements NetmovelService{
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
     _service = new org.apache.axis2.description.AxisService("NetmovelService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[8];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "startBundle"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "startVoiceAddOnBundle"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "deactivateNTDuo"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "stopBundle"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "balanceEnquiry"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "extendBundle"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "refillVoucher"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://www.bridge.com/netmovel", "activateNTDuo"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[7]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.client.NetmovelSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://www.bridge.com/netmovel","netmovelSystemError"),"com.bridge.netmovel.NetmovelSystemError");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public NetmovelServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public NetmovelServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public NetmovelServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://192.168.7.170:8080/Netmovel/services/NetmovelService" );
                
    }

    /**
     * Default Constructor
     */
    public NetmovelServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("http://192.168.7.170:8080/Netmovel/services/NetmovelService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public NetmovelServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see com.bridge.netmovel.client.NetmovelService#startBundle
                     * @param startBundleRequest23
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  int startBundle(

                            co.mcel.mz.types.common.MsisdnType msisdn24,java.lang.String bundleId25)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/startBundle");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.StartBundleRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn24,
                                                    bundleId25,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "startBundle")));
                                                
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
                                             com.bridge.netmovel.BundleResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getBundleResponseResultCode((com.bridge.netmovel.BundleResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#startVoiceAddOnBundle
                     * @param startVoiceAddOnBundleRequest28
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  int startVoiceAddOnBundle(

                            co.mcel.mz.types.common.MsisdnType msisdn29,java.lang.String bundleId30)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/startVoiceAddOnBundle");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.StartVoiceAddOnBundleRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn29,
                                                    bundleId30,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "startVoiceAddOnBundle")));
                                                
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
                                             com.bridge.netmovel.BundleResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getBundleResponseResultCode((com.bridge.netmovel.BundleResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#deactivateNTDuo
                     * @param bundleRequest33
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  int deactivateNTDuo(

                            co.mcel.mz.types.common.MsisdnType msisdn34)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/deactivateNTDuo");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.BundleRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn34,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "deactivateNTDuo")));
                                                
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
                                             com.bridge.netmovel.BundleResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getBundleResponseResultCode((com.bridge.netmovel.BundleResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#stopBundle
                     * @param bundleRequest37
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  int stopBundle(

                            co.mcel.mz.types.common.MsisdnType msisdn38)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/stopBundle");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.BundleRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn38,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "stopBundle")));
                                                
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
                                             com.bridge.netmovel.BundleResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getBundleResponseResultCode((com.bridge.netmovel.BundleResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#balanceEnquiry
                     * @param balanceEnquiryRequest41
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  com.bridge.netmovel.BalanceEnquiryResponse balanceEnquiry(

                            co.mcel.mz.types.common.MsisdnType msisdn42)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/balanceEnquiry");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.BalanceEnquiryRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn42,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "balanceEnquiry")));
                                                
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
                                             com.bridge.netmovel.BalanceEnquiryResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.bridge.netmovel.BalanceEnquiryResponse)object;
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#extendBundle
                     * @param bundleRequest50
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  int extendBundle(

                            co.mcel.mz.types.common.MsisdnType msisdn51)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/extendBundle");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.BundleRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn51,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "extendBundle")));
                                                
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
                                             com.bridge.netmovel.BundleResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getBundleResponseResultCode((com.bridge.netmovel.BundleResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#refillVoucher
                     * @param voucherTopUpRequest54
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  com.bridge.netmovel.VoucherTopUpResponse refillVoucher(

                            co.mcel.mz.types.common.MsisdnType msisdn55,java.lang.String activationCode56)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/refillVoucher");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.VoucherTopUpRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn55,
                                                    activationCode56,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "refillVoucher")));
                                                
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
                                             com.bridge.netmovel.VoucherTopUpResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (com.bridge.netmovel.VoucherTopUpResponse)object;
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
                     * @see com.bridge.netmovel.client.NetmovelService#activateNTDuo
                     * @param activateDuoRequest61
                    
                     * @throws com.bridge.netmovel.client.NetmovelSystemError : 
                     */

                    

                            public  int activateNTDuo(

                            co.mcel.mz.types.common.MsisdnType msisdn62,int contractValue63)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,com.bridge.netmovel.client.NetmovelSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("http://www.bridge.com/netmovel/activateNTDuo");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    com.bridge.netmovel.ActivateDuoRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn62,
                                                    contractValue63,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://www.bridge.com/netmovel",
                                                    "activateNTDuo")));
                                                
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
                                             com.bridge.netmovel.BundleResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getBundleResponseResultCode((com.bridge.netmovel.BundleResponse)object);
                                   
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
                        
                        if (ex instanceof com.bridge.netmovel.client.NetmovelSystemError){
                          throw (com.bridge.netmovel.client.NetmovelSystemError)ex;
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
     //http://192.168.7.170:8080/Netmovel/services/NetmovelService
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.StartBundleRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.StartBundleRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.BundleResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.BundleResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.NetmovelSystemError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.NetmovelSystemError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.StartVoiceAddOnBundleRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.StartVoiceAddOnBundleRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.BundleRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.BundleRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.BalanceEnquiryRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.BalanceEnquiryRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.BalanceEnquiryResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.BalanceEnquiryResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.VoucherTopUpRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.VoucherTopUpRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.VoucherTopUpResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.VoucherTopUpResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(com.bridge.netmovel.ActivateDuoRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(com.bridge.netmovel.ActivateDuoRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    com.bridge.netmovel.StartBundleRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.netmovel.StartBundleRequest wrappedType = new com.bridge.netmovel.StartBundleRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setBundleId(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.netmovel.StartBundleRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private int getBundleResponseResultCode(
                                com.bridge.netmovel.BundleResponse wrappedType){
                                
                                        return wrappedType.getResultCode();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    com.bridge.netmovel.StartVoiceAddOnBundleRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.netmovel.StartVoiceAddOnBundleRequest wrappedType = new com.bridge.netmovel.StartVoiceAddOnBundleRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setBundleId(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.netmovel.StartVoiceAddOnBundleRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    com.bridge.netmovel.BundleRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.netmovel.BundleRequest wrappedType = new com.bridge.netmovel.BundleRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.netmovel.BundleRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    com.bridge.netmovel.BalanceEnquiryRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.netmovel.BalanceEnquiryRequest wrappedType = new com.bridge.netmovel.BalanceEnquiryRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.netmovel.BalanceEnquiryRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private java.util.Date getBalanceEnquiryResponseAccountExpiryDate(
                                com.bridge.netmovel.BalanceEnquiryResponse wrappedType){
                                
                                        return wrappedType.getAccountExpiryDate();
                                    
                                }
                             

                                
                                private float getBalanceEnquiryResponseBalance(
                                com.bridge.netmovel.BalanceEnquiryResponse wrappedType){
                                
                                        return wrappedType.getBalance();
                                    
                                }
                             

                                
                                private float getBalanceEnquiryResponseRemainingVolume(
                                com.bridge.netmovel.BalanceEnquiryResponse wrappedType){
                                
                                        return wrappedType.getRemainingVolume();
                                    
                                }
                             

                                
                                private java.lang.String getBalanceEnquiryResponseCurrentActiveBundle(
                                com.bridge.netmovel.BalanceEnquiryResponse wrappedType){
                                
                                        return wrappedType.getCurrentActiveBundle();
                                    
                                }
                             

                                
                                private java.util.Date getBalanceEnquiryResponseBundleEndDate(
                                com.bridge.netmovel.BalanceEnquiryResponse wrappedType){
                                
                                        return wrappedType.getBundleEndDate();
                                    
                                }
                             

                                
                                private int getBalanceEnquiryResponseResultCode(
                                com.bridge.netmovel.BalanceEnquiryResponse wrappedType){
                                
                                        return wrappedType.getResultCode();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    com.bridge.netmovel.VoucherTopUpRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.netmovel.VoucherTopUpRequest wrappedType = new com.bridge.netmovel.VoucherTopUpRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setActivationCode(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.netmovel.VoucherTopUpRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private int getVoucherTopUpResponseResultCode(
                                com.bridge.netmovel.VoucherTopUpResponse wrappedType){
                                
                                        return wrappedType.getResultCode();
                                    
                                }
                             

                                
                                private java.math.BigDecimal getVoucherTopUpResponseAmount(
                                com.bridge.netmovel.VoucherTopUpResponse wrappedType){
                                
                                        return wrappedType.getAmount();
                                    
                                }
                             

                                
                                private java.math.BigDecimal getVoucherTopUpResponseRemainingVolume(
                                com.bridge.netmovel.VoucherTopUpResponse wrappedType){
                                
                                        return wrappedType.getRemainingVolume();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    int param2,
                                    com.bridge.netmovel.ActivateDuoRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                com.bridge.netmovel.ActivateDuoRequest wrappedType = new com.bridge.netmovel.ActivateDuoRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setContractValue(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(com.bridge.netmovel.ActivateDuoRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             


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
        
                if (com.bridge.netmovel.StartBundleRequest.class.equals(type)){
                
                           return com.bridge.netmovel.StartBundleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BundleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.StartVoiceAddOnBundleRequest.class.equals(type)){
                
                           return com.bridge.netmovel.StartVoiceAddOnBundleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BundleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleRequest.class.equals(type)){
                
                           return com.bridge.netmovel.BundleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BundleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleRequest.class.equals(type)){
                
                           return com.bridge.netmovel.BundleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BundleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BalanceEnquiryRequest.class.equals(type)){
                
                           return com.bridge.netmovel.BalanceEnquiryRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BalanceEnquiryResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BalanceEnquiryResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleRequest.class.equals(type)){
                
                           return com.bridge.netmovel.BundleRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BundleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.VoucherTopUpRequest.class.equals(type)){
                
                           return com.bridge.netmovel.VoucherTopUpRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.VoucherTopUpResponse.class.equals(type)){
                
                           return com.bridge.netmovel.VoucherTopUpResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.ActivateDuoRequest.class.equals(type)){
                
                           return com.bridge.netmovel.ActivateDuoRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.BundleResponse.class.equals(type)){
                
                           return com.bridge.netmovel.BundleResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (com.bridge.netmovel.NetmovelSystemError.class.equals(type)){
                
                           return com.bridge.netmovel.NetmovelSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   