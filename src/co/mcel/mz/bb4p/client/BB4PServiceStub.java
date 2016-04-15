
/**
 * BB4PServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package co.mcel.mz.bb4p.client;

        

        /*
        *  BB4PServiceStub java implementation
        */

        
        public class BB4PServiceStub extends org.apache.axis2.client.Stub
        implements BB4PService{
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
     _service = new org.apache.axis2.description.AxisService("BB4PService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[9];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "registerAPN"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "debitAmount"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "unregisterAPN"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "cancelReservation"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "getImsi"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "getServiceClass"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "reserveAmount"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[6]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "checkStatus"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[7]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p", "refund"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[8]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.client.EMAError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.client.EMAError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.EmaError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.client.InvalidReservationStatus");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.client.InvalidReservationStatus");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.InvalidReservationStatus");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.TransactionNotFound");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.client.EMAError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.client.EMAError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.EmaError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.client.InvalidReservationStatus");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.client.InvalidReservationStatus");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.InvalidReservationStatus");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.TransactionNotFound");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.client.EMAError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.client.EMAError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","emaError"),"co.mcel.mz.bb4p.EmaError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.TransactionNotFound");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csvSystemError"),"co.mcel.mz.bb4p.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.client.InvalidReservationStatus");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.client.InvalidReservationStatus");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","invalidReservationStatus"),"co.mcel.mz.bb4p.InvalidReservationStatus");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","csError"),"co.mcel.mz.bb4p.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/bb4p","transactionNotFound"),"co.mcel.mz.bb4p.TransactionNotFound");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public BB4PServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public BB4PServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public BB4PServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://localhost:9090/CSV/services/BB4PService" );
                
    }

    /**
     * Default Constructor
     */
    public BB4PServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("http://localhost:9090/CSV/services/BB4PService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public BB4PServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see co.mcel.mz.bb4p.client.BB4PService#registerAPN
                     * @param registerAPNRequest18
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.EMAError : 
                     */

                    

                            public  boolean registerAPN(

                            co.mcel.mz.types.common.MsisdnType msisdn19,int apnId20)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.EMAError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/registerAPN");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.RegisterAPNRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn19,
                                                    apnId20,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "registerAPN")));
                                                
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
                                             co.mcel.mz.bb4p.RegisterAPNResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getRegisterAPNResponseRegisterAPNResponse((co.mcel.mz.bb4p.RegisterAPNResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.EMAError){
                          throw (co.mcel.mz.bb4p.client.EMAError)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#debitAmount
                     * @param debitAmountRequest23
                    
                     * @throws co.mcel.mz.bb4p.client.InvalidReservationStatus : 
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
                     */

                    

                            public  boolean debitAmount(

                            java.lang.String debitAmountRequest24)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.InvalidReservationStatus
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.TransactionNotFound{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/debitAmount");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.DebitAmountRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    debitAmountRequest24,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "debitAmount")));
                                                
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
                                             co.mcel.mz.bb4p.DebitAmountResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getDebitAmountResponseDebitAmountResponse((co.mcel.mz.bb4p.DebitAmountResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.InvalidReservationStatus){
                          throw (co.mcel.mz.bb4p.client.InvalidReservationStatus)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.TransactionNotFound){
                          throw (co.mcel.mz.bb4p.client.TransactionNotFound)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#unregisterAPN
                     * @param unregisterAPNRequest27
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.EMAError : 
                     */

                    

                            public  boolean unregisterAPN(

                            co.mcel.mz.types.common.MsisdnType msisdn28,int apnId29)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.EMAError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/unregisterAPN");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.UnregisterAPNRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn28,
                                                    apnId29,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "unregisterAPN")));
                                                
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
                                             co.mcel.mz.bb4p.UnregisterAPNResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getUnregisterAPNResponseUnregisterAPNResponse((co.mcel.mz.bb4p.UnregisterAPNResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.EMAError){
                          throw (co.mcel.mz.bb4p.client.EMAError)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#cancelReservation
                     * @param cancelReservationRequest32
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.InvalidReservationStatus : 
                     * @throws co.mcel.mz.bb4p.client.CSError : 
                     * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
                     */

                    

                            public  boolean cancelReservation(

                            java.lang.String cancelReservationRequest33)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.InvalidReservationStatus
                        ,co.mcel.mz.bb4p.client.CSError
                        ,co.mcel.mz.bb4p.client.TransactionNotFound{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/cancelReservation");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.CancelReservationRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    cancelReservationRequest33,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "cancelReservation")));
                                                
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
                                             co.mcel.mz.bb4p.CancelReservationResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getCancelReservationResponseCancelReservationResponse((co.mcel.mz.bb4p.CancelReservationResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.InvalidReservationStatus){
                          throw (co.mcel.mz.bb4p.client.InvalidReservationStatus)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSError){
                          throw (co.mcel.mz.bb4p.client.CSError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.TransactionNotFound){
                          throw (co.mcel.mz.bb4p.client.TransactionNotFound)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#getImsi
                     * @param getImsiRequest36
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.EMAError : 
                     */

                    

                            public  java.lang.String getImsi(

                            java.lang.String internationalPrefix37,java.lang.String number38)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.EMAError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/getImsi");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.GetImsiRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    internationalPrefix37,
                                                    number38,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "getImsi")));
                                                
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
                                             co.mcel.mz.bb4p.GetImsiResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getGetImsiResponseGetImsiResponse((co.mcel.mz.bb4p.GetImsiResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.EMAError){
                          throw (co.mcel.mz.bb4p.client.EMAError)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#getServiceClass
                     * @param getServiceClassRequest41
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.CSError : 
                     */

                    

                            public  int getServiceClass(

                            java.lang.String internationalPrefix42,java.lang.String number43)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.CSError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/getServiceClass");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.GetServiceClassRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    internationalPrefix42,
                                                    number43,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "getServiceClass")));
                                                
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
                                             co.mcel.mz.bb4p.GetServiceClassResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getGetServiceClassResponseGetServiceClassResponse((co.mcel.mz.bb4p.GetServiceClassResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSError){
                          throw (co.mcel.mz.bb4p.client.CSError)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#reserveAmount
                     * @param reserveAmountRequest46
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.CSError : 
                     */

                    

                            public  boolean reserveAmount(

                            co.mcel.mz.types.common.MsisdnType msisdn47,java.lang.String transactionId48,float amount49)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.CSError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/reserveAmount");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.ReserveAmountRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn47,
                                                    transactionId48,
                                                    amount49,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "reserveAmount")));
                                                
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
                                             co.mcel.mz.bb4p.ReserveAmountResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getReserveAmountResponseReserveAmountResponse((co.mcel.mz.bb4p.ReserveAmountResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSError){
                          throw (co.mcel.mz.bb4p.client.CSError)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#checkStatus
                     * @param checkStatusRequest52
                    
                     * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     */

                    

                            public  co.mcel.mz.bb4p.CheckStatusResponse_type0 checkStatus(

                            java.lang.String checkStatusRequest53)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.TransactionNotFound
                        ,co.mcel.mz.bb4p.client.CSVSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[7].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/checkStatus");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.CheckStatusRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    checkStatusRequest53,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "checkStatus")));
                                                
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
                                             co.mcel.mz.bb4p.CheckStatusResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getCheckStatusResponseCheckStatusResponse((co.mcel.mz.bb4p.CheckStatusResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.TransactionNotFound){
                          throw (co.mcel.mz.bb4p.client.TransactionNotFound)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
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
                     * @see co.mcel.mz.bb4p.client.BB4PService#refund
                     * @param refundRequest56
                    
                     * @throws co.mcel.mz.bb4p.client.CSVSystemError : 
                     * @throws co.mcel.mz.bb4p.client.InvalidReservationStatus : 
                     * @throws co.mcel.mz.bb4p.client.CSError : 
                     * @throws co.mcel.mz.bb4p.client.TransactionNotFound : 
                     */

                    

                            public  boolean refund(

                            java.lang.String refundRequest57)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.bb4p.client.CSVSystemError
                        ,co.mcel.mz.bb4p.client.InvalidReservationStatus
                        ,co.mcel.mz.bb4p.client.CSError
                        ,co.mcel.mz.bb4p.client.TransactionNotFound{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[8].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/bb4p/refund");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.bb4p.RefundRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    refundRequest57,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/bb4p",
                                                    "refund")));
                                                
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
                                             co.mcel.mz.bb4p.RefundResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getRefundResponseRefundResponse((co.mcel.mz.bb4p.RefundResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSVSystemError){
                          throw (co.mcel.mz.bb4p.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.InvalidReservationStatus){
                          throw (co.mcel.mz.bb4p.client.InvalidReservationStatus)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.CSError){
                          throw (co.mcel.mz.bb4p.client.CSError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.bb4p.client.TransactionNotFound){
                          throw (co.mcel.mz.bb4p.client.TransactionNotFound)ex;
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
     //http://localhost:9090/CSV/services/BB4PService
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.RegisterAPNRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.RegisterAPNRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.RegisterAPNResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.RegisterAPNResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.CsvSystemError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.CsvSystemError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.EmaError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.EmaError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.DebitAmountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.DebitAmountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.DebitAmountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.DebitAmountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.InvalidReservationStatus param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.InvalidReservationStatus.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.TransactionNotFound param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.TransactionNotFound.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.UnregisterAPNRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.UnregisterAPNRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.UnregisterAPNResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.UnregisterAPNResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.CancelReservationRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.CancelReservationRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.CancelReservationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.CancelReservationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.CsError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.CsError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.GetImsiRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.GetImsiRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.GetImsiResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.GetImsiResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.GetServiceClassRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.GetServiceClassRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.GetServiceClassResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.GetServiceClassResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.ReserveAmountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.ReserveAmountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.ReserveAmountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.ReserveAmountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.CheckStatusRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.CheckStatusRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.CheckStatusResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.CheckStatusResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.RefundRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.RefundRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.bb4p.RefundResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.bb4p.RefundResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    int param2,
                                    co.mcel.mz.bb4p.RegisterAPNRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.RegisterAPNRequest wrappedType = new co.mcel.mz.bb4p.RegisterAPNRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setApnId(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.RegisterAPNRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getRegisterAPNResponseRegisterAPNResponse(
                                co.mcel.mz.bb4p.RegisterAPNResponse wrappedType){
                                
                                        return wrappedType.getRegisterAPNResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    co.mcel.mz.bb4p.DebitAmountRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.DebitAmountRequest wrappedType = new co.mcel.mz.bb4p.DebitAmountRequest();

                                 
                                              wrappedType.setDebitAmountRequest(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.DebitAmountRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getDebitAmountResponseDebitAmountResponse(
                                co.mcel.mz.bb4p.DebitAmountResponse wrappedType){
                                
                                        return wrappedType.getDebitAmountResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    int param2,
                                    co.mcel.mz.bb4p.UnregisterAPNRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.UnregisterAPNRequest wrappedType = new co.mcel.mz.bb4p.UnregisterAPNRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setApnId(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.UnregisterAPNRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getUnregisterAPNResponseUnregisterAPNResponse(
                                co.mcel.mz.bb4p.UnregisterAPNResponse wrappedType){
                                
                                        return wrappedType.getUnregisterAPNResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    co.mcel.mz.bb4p.CancelReservationRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.CancelReservationRequest wrappedType = new co.mcel.mz.bb4p.CancelReservationRequest();

                                 
                                              wrappedType.setCancelReservationRequest(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.CancelReservationRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getCancelReservationResponseCancelReservationResponse(
                                co.mcel.mz.bb4p.CancelReservationResponse wrappedType){
                                
                                        return wrappedType.getCancelReservationResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    java.lang.String param2,
                                    co.mcel.mz.bb4p.GetImsiRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.GetImsiRequest wrappedType = new co.mcel.mz.bb4p.GetImsiRequest();

                                 co.mcel.mz.types.common.MsisdnType wrappedComplexType = new co.mcel.mz.types.common.MsisdnType();
                                          
                                              wrappedComplexType.setInternationalPrefix(param1);
                                         
                                              wrappedComplexType.setNumber(param2);
                                         
                                         wrappedType.setGetImsiRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.GetImsiRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
                                private co.mcel.mz.types.common.MsisdnType getgetImsi(
                                co.mcel.mz.bb4p.GetImsiRequest wrappedType){
                                    return wrappedType.getGetImsiRequest();
                                }

                                private co.mcel.mz.bb4p.GetImsiRequest wrapgetImsi(
                                co.mcel.mz.types.common.MsisdnType innerType){
                                    co.mcel.mz.bb4p.GetImsiRequest wrappedElement = new co.mcel.mz.bb4p.GetImsiRequest();
                                    wrappedElement.setGetImsiRequest(innerType);
                                    return wrappedElement;
                                }
                            

                                
                                private java.lang.String getGetImsiResponseGetImsiResponse(
                                co.mcel.mz.bb4p.GetImsiResponse wrappedType){
                                
                                        return wrappedType.getGetImsiResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    java.lang.String param2,
                                    co.mcel.mz.bb4p.GetServiceClassRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.GetServiceClassRequest wrappedType = new co.mcel.mz.bb4p.GetServiceClassRequest();

                                 co.mcel.mz.types.common.MsisdnType wrappedComplexType = new co.mcel.mz.types.common.MsisdnType();
                                          
                                              wrappedComplexType.setInternationalPrefix(param1);
                                         
                                              wrappedComplexType.setNumber(param2);
                                         
                                         wrappedType.setGetServiceClassRequest(wrappedComplexType);
                                     

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.GetServiceClassRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             
                                private co.mcel.mz.types.common.MsisdnType getgetServiceClass(
                                co.mcel.mz.bb4p.GetServiceClassRequest wrappedType){
                                    return wrappedType.getGetServiceClassRequest();
                                }

                                private co.mcel.mz.bb4p.GetServiceClassRequest wrapgetServiceClass(
                                co.mcel.mz.types.common.MsisdnType innerType){
                                    co.mcel.mz.bb4p.GetServiceClassRequest wrappedElement = new co.mcel.mz.bb4p.GetServiceClassRequest();
                                    wrappedElement.setGetServiceClassRequest(innerType);
                                    return wrappedElement;
                                }
                            

                                
                                private int getGetServiceClassResponseGetServiceClassResponse(
                                co.mcel.mz.bb4p.GetServiceClassResponse wrappedType){
                                
                                        return wrappedType.getGetServiceClassResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    float param3,
                                    co.mcel.mz.bb4p.ReserveAmountRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.ReserveAmountRequest wrappedType = new co.mcel.mz.bb4p.ReserveAmountRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setTransactionId(param2);
                                         
                                              wrappedType.setAmount(param3);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.ReserveAmountRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getReserveAmountResponseReserveAmountResponse(
                                co.mcel.mz.bb4p.ReserveAmountResponse wrappedType){
                                
                                        return wrappedType.getReserveAmountResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    co.mcel.mz.bb4p.CheckStatusRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.CheckStatusRequest wrappedType = new co.mcel.mz.bb4p.CheckStatusRequest();

                                 
                                              wrappedType.setCheckStatusRequest(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.CheckStatusRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private co.mcel.mz.bb4p.CheckStatusResponse_type0 getCheckStatusResponseCheckStatusResponse(
                                co.mcel.mz.bb4p.CheckStatusResponse wrappedType){
                                
                                        return wrappedType.getCheckStatusResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    co.mcel.mz.bb4p.RefundRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.bb4p.RefundRequest wrappedType = new co.mcel.mz.bb4p.RefundRequest();

                                 
                                              wrappedType.setRefundRequest(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.bb4p.RefundRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getRefundResponseRefundResponse(
                                co.mcel.mz.bb4p.RefundResponse wrappedType){
                                
                                        return wrappedType.getRefundResponse();
                                    
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
        
                if (co.mcel.mz.bb4p.RegisterAPNRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.RegisterAPNRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.RegisterAPNResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.RegisterAPNResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.EmaError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.EmaError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.DebitAmountRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.DebitAmountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.DebitAmountResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.DebitAmountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.InvalidReservationStatus.class.equals(type)){
                
                           return co.mcel.mz.bb4p.InvalidReservationStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.bb4p.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.UnregisterAPNRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.UnregisterAPNRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.UnregisterAPNResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.UnregisterAPNResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.EmaError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.EmaError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CancelReservationRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CancelReservationRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CancelReservationResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CancelReservationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.InvalidReservationStatus.class.equals(type)){
                
                           return co.mcel.mz.bb4p.InvalidReservationStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.bb4p.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.GetImsiRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.GetImsiRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.GetImsiResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.GetImsiResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.EmaError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.EmaError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.GetServiceClassRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.GetServiceClassRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.GetServiceClassResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.GetServiceClassResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.ReserveAmountRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.ReserveAmountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.ReserveAmountResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.ReserveAmountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CheckStatusRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CheckStatusRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CheckStatusResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CheckStatusResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.bb4p.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.RefundRequest.class.equals(type)){
                
                           return co.mcel.mz.bb4p.RefundRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.RefundResponse.class.equals(type)){
                
                           return co.mcel.mz.bb4p.RefundResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.InvalidReservationStatus.class.equals(type)){
                
                           return co.mcel.mz.bb4p.InvalidReservationStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.CsError.class.equals(type)){
                
                           return co.mcel.mz.bb4p.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.bb4p.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.bb4p.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   