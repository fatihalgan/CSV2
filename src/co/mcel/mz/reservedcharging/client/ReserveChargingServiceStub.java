
/**
 * ReserveChargingServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package co.mcel.mz.reservedcharging.client;

        

        /*
        *  ReserveChargingServiceStub java implementation
        */

        
        public class ReserveChargingServiceStub extends org.apache.axis2.client.Stub
        implements ReserveChargingService{
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
     _service = new org.apache.axis2.description.AxisService("ReserveChargingService" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[7];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "cancelReservation"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[0]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "directDebit"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[1]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "refund"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[2]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "reserveAmount"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[3]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "getAccountType"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[4]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "checkStatus"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[5]=__operation;
            
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging", "debitAmount"));
	    _service.addOperation(__operation);
	    

	    
	    
            _operations[6]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.client.InvalidReservationStatus");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.client.InvalidReservationStatus");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.InvalidReservationStatus");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.TransactionNotFound");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.client.InvalidReservationStatus");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.client.InvalidReservationStatus");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.InvalidReservationStatus");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.TransactionNotFound");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.client.CSError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csError"),"co.mcel.mz.reservedcharging.CsError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.TransactionNotFound");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.client.InvalidReservationStatus");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.client.InvalidReservationStatus");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","invalidReservationStatus"),"co.mcel.mz.reservedcharging.InvalidReservationStatus");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.client.CSVSystemError");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","csvSystemError"),"co.mcel.mz.reservedcharging.CsvSystemError");
           
              faultExceptionNameMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultExceptionClassNameMap.put(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.client.TransactionNotFound");
              faultMessageMap.put( new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging","transactionNotFound"),"co.mcel.mz.reservedcharging.TransactionNotFound");
           


    }

    /**
      *Constructor that takes in a configContext
      */

    public ReserveChargingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public ReserveChargingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext,
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
    public ReserveChargingServiceStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://192.168.1.82:9090/CSV/services/ReservedChargingService" );
                
    }

    /**
     * Default Constructor
     */
    public ReserveChargingServiceStub() throws org.apache.axis2.AxisFault {
        
                    this("http://192.168.1.82:9090/CSV/services/ReservedChargingService" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public ReserveChargingServiceStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#cancelReservation
                     * @param cancelReservationRequest21
                    
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     * @throws co.mcel.mz.reservedcharging.client.InvalidReservationStatus : 
                     * @throws co.mcel.mz.reservedcharging.client.CSError : 
                     * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
                     */

                    

                            public  boolean cancelReservation(

                            java.lang.String transactionId22,java.lang.String requesterService23)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError
                        ,co.mcel.mz.reservedcharging.client.InvalidReservationStatus
                        ,co.mcel.mz.reservedcharging.client.CSError
                        ,co.mcel.mz.reservedcharging.client.TransactionNotFound{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/cancelReservation");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.CancelReservationRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    transactionId22,
                                                    requesterService23,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
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
                                             co.mcel.mz.reservedcharging.CancelReservationResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getCancelReservationResponseCancelReservationResponse((co.mcel.mz.reservedcharging.CancelReservationResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.InvalidReservationStatus){
                          throw (co.mcel.mz.reservedcharging.client.InvalidReservationStatus)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSError){
                          throw (co.mcel.mz.reservedcharging.client.CSError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.TransactionNotFound){
                          throw (co.mcel.mz.reservedcharging.client.TransactionNotFound)ex;
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
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#directDebit
                     * @param directDebitRequest26
                    
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     */

                    

                            public  boolean directDebit(

                            co.mcel.mz.types.common.MsisdnType msisdn27,java.lang.String transactionId28,java.lang.String requesterService29,float amount30,java.lang.String description31)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[1].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/directDebit");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.DirectDebitRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn27,
                                                    transactionId28,
                                                    requesterService29,
                                                    amount30,
                                                    description31,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
                                                    "directDebit")));
                                                
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
                                             co.mcel.mz.reservedcharging.DirectDebitResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getDirectDebitResponseDirectDebitResponse((co.mcel.mz.reservedcharging.DirectDebitResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
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
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#refund
                     * @param refundRequest34
                    
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     * @throws co.mcel.mz.reservedcharging.client.InvalidReservationStatus : 
                     * @throws co.mcel.mz.reservedcharging.client.CSError : 
                     * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
                     */

                    

                            public  boolean refund(

                            java.lang.String transactionId35,java.lang.String requesterService36)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError
                        ,co.mcel.mz.reservedcharging.client.InvalidReservationStatus
                        ,co.mcel.mz.reservedcharging.client.CSError
                        ,co.mcel.mz.reservedcharging.client.TransactionNotFound{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[2].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/refund");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.RefundRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    transactionId35,
                                                    requesterService36,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
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
                                             co.mcel.mz.reservedcharging.RefundResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getRefundResponseRefundResponse((co.mcel.mz.reservedcharging.RefundResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.InvalidReservationStatus){
                          throw (co.mcel.mz.reservedcharging.client.InvalidReservationStatus)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSError){
                          throw (co.mcel.mz.reservedcharging.client.CSError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.TransactionNotFound){
                          throw (co.mcel.mz.reservedcharging.client.TransactionNotFound)ex;
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
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#reserveAmount
                     * @param reserveAmountRequest39
                    
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     * @throws co.mcel.mz.reservedcharging.client.CSError : 
                     */

                    

                            public  boolean reserveAmount(

                            co.mcel.mz.types.common.MsisdnType msisdn40,java.lang.String transactionId41,java.lang.String requesterService42,float amount43,java.lang.String description44)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError
                        ,co.mcel.mz.reservedcharging.client.CSError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[3].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/reserveAmount");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.ReserveAmountRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn40,
                                                    transactionId41,
                                                    requesterService42,
                                                    amount43,
                                                    description44,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
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
                                             co.mcel.mz.reservedcharging.ReserveAmountResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getReserveAmountResponseReserveAmountResponse((co.mcel.mz.reservedcharging.ReserveAmountResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSError){
                          throw (co.mcel.mz.reservedcharging.client.CSError)ex;
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
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#getAccountType
                     * @param getAccountTypeRequest47
                    
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     * @throws co.mcel.mz.reservedcharging.client.CSError : 
                     */

                    

                            public  co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0 getAccountType(

                            co.mcel.mz.types.common.MsisdnType msisdn48)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError
                        ,co.mcel.mz.reservedcharging.client.CSError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[4].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/getAccountType");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.GetAccountTypeRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    msisdn48,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
                                                    "getAccountType")));
                                                
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
                                             co.mcel.mz.reservedcharging.GetAccountTypeResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getGetAccountTypeResponseGetAccountTypeResponse((co.mcel.mz.reservedcharging.GetAccountTypeResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSError){
                          throw (co.mcel.mz.reservedcharging.client.CSError)ex;
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
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#checkStatus
                     * @param checkStatusRequest51
                    
                     * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     */

                    

                            public  co.mcel.mz.reservedcharging.CheckStatusResponse_type0 checkStatus(

                            java.lang.String transactionId52,java.lang.String requesterService53)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.TransactionNotFound
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[5].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/checkStatus");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.CheckStatusRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    transactionId52,
                                                    requesterService53,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
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
                                             co.mcel.mz.reservedcharging.CheckStatusResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getCheckStatusResponseCheckStatusResponse((co.mcel.mz.reservedcharging.CheckStatusResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.TransactionNotFound){
                          throw (co.mcel.mz.reservedcharging.client.TransactionNotFound)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
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
                     * @see co.mcel.mz.reservedcharging.client.ReserveChargingService#debitAmount
                     * @param debitAmountRequest56
                    
                     * @throws co.mcel.mz.reservedcharging.client.InvalidReservationStatus : 
                     * @throws co.mcel.mz.reservedcharging.client.CSVSystemError : 
                     * @throws co.mcel.mz.reservedcharging.client.TransactionNotFound : 
                     */

                    

                            public  boolean debitAmount(

                            java.lang.String transactionId57,java.lang.String requesterService58)
                        

                    throws java.rmi.RemoteException
                    
                    
                        ,co.mcel.mz.reservedcharging.client.InvalidReservationStatus
                        ,co.mcel.mz.reservedcharging.client.CSVSystemError
                        ,co.mcel.mz.reservedcharging.client.TransactionNotFound{
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[6].getName());
              _operationClient.getOptions().setAction("http://co.mcel.mz/reserveCharging/debitAmount");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    co.mcel.mz.reservedcharging.DebitAmountRequest dummyWrappedType = null;
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    transactionId57,
                                                    requesterService58,
                                                    dummyWrappedType,
                                                    optimizeContent(new javax.xml.namespace.QName("http://co.mcel.mz/reserveCharging",
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
                                             co.mcel.mz.reservedcharging.DebitAmountResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return getDebitAmountResponseDebitAmountResponse((co.mcel.mz.reservedcharging.DebitAmountResponse)object);
                                   
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
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.InvalidReservationStatus){
                          throw (co.mcel.mz.reservedcharging.client.InvalidReservationStatus)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.CSVSystemError){
                          throw (co.mcel.mz.reservedcharging.client.CSVSystemError)ex;
                        }
                        
                        if (ex instanceof co.mcel.mz.reservedcharging.client.TransactionNotFound){
                          throw (co.mcel.mz.reservedcharging.client.TransactionNotFound)ex;
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
     //http://192.168.1.82:9090/CSV/services/ReservedChargingService
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.CancelReservationRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.CancelReservationRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.CancelReservationResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.CancelReservationResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.CsvSystemError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.CsvSystemError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.InvalidReservationStatus param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.InvalidReservationStatus.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.CsError param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.CsError.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.TransactionNotFound param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.TransactionNotFound.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.DirectDebitRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.DirectDebitRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.DirectDebitResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.DirectDebitResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.RefundRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.RefundRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.RefundResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.RefundResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.ReserveAmountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.ReserveAmountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.ReserveAmountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.ReserveAmountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.GetAccountTypeRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.GetAccountTypeRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.GetAccountTypeResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.GetAccountTypeResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.CheckStatusRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.CheckStatusRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.CheckStatusResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.CheckStatusResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.DebitAmountRequest param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.DebitAmountRequest.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(co.mcel.mz.reservedcharging.DebitAmountResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(co.mcel.mz.reservedcharging.DebitAmountResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    java.lang.String param2,
                                    co.mcel.mz.reservedcharging.CancelReservationRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.CancelReservationRequest wrappedType = new co.mcel.mz.reservedcharging.CancelReservationRequest();

                                 
                                              wrappedType.setTransactionId(param1);
                                         
                                              wrappedType.setRequesterService(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.CancelReservationRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getCancelReservationResponseCancelReservationResponse(
                                co.mcel.mz.reservedcharging.CancelReservationResponse wrappedType){
                                
                                        return wrappedType.getCancelReservationResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    java.lang.String param3,
                                    float param4,
                                    java.lang.String param5,
                                    co.mcel.mz.reservedcharging.DirectDebitRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.DirectDebitRequest wrappedType = new co.mcel.mz.reservedcharging.DirectDebitRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setTransactionId(param2);
                                         
                                              wrappedType.setRequesterService(param3);
                                         
                                              wrappedType.setAmount(param4);
                                         
                                              wrappedType.setDescription(param5);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.DirectDebitRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getDirectDebitResponseDirectDebitResponse(
                                co.mcel.mz.reservedcharging.DirectDebitResponse wrappedType){
                                
                                        return wrappedType.getDirectDebitResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    java.lang.String param2,
                                    co.mcel.mz.reservedcharging.RefundRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.RefundRequest wrappedType = new co.mcel.mz.reservedcharging.RefundRequest();

                                 
                                              wrappedType.setTransactionId(param1);
                                         
                                              wrappedType.setRequesterService(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.RefundRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getRefundResponseRefundResponse(
                                co.mcel.mz.reservedcharging.RefundResponse wrappedType){
                                
                                        return wrappedType.getRefundResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    java.lang.String param2,
                                    java.lang.String param3,
                                    float param4,
                                    java.lang.String param5,
                                    co.mcel.mz.reservedcharging.ReserveAmountRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedType = new co.mcel.mz.reservedcharging.ReserveAmountRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         
                                              wrappedType.setTransactionId(param2);
                                         
                                              wrappedType.setRequesterService(param3);
                                         
                                              wrappedType.setAmount(param4);
                                         
                                              wrappedType.setDescription(param5);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.ReserveAmountRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getReserveAmountResponseReserveAmountResponse(
                                co.mcel.mz.reservedcharging.ReserveAmountResponse wrappedType){
                                
                                        return wrappedType.getReserveAmountResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    co.mcel.mz.types.common.MsisdnType param1,
                                    co.mcel.mz.reservedcharging.GetAccountTypeRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.GetAccountTypeRequest wrappedType = new co.mcel.mz.reservedcharging.GetAccountTypeRequest();

                                 
                                              wrappedType.setMsisdn(param1);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.GetAccountTypeRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0 getGetAccountTypeResponseGetAccountTypeResponse(
                                co.mcel.mz.reservedcharging.GetAccountTypeResponse wrappedType){
                                
                                        return wrappedType.getGetAccountTypeResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    java.lang.String param2,
                                    co.mcel.mz.reservedcharging.CheckStatusRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.CheckStatusRequest wrappedType = new co.mcel.mz.reservedcharging.CheckStatusRequest();

                                 
                                              wrappedType.setTransactionId(param1);
                                         
                                              wrappedType.setRequesterService(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.CheckStatusRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private co.mcel.mz.reservedcharging.CheckStatusResponse_type0 getCheckStatusResponseCheckStatusResponse(
                                co.mcel.mz.reservedcharging.CheckStatusResponse wrappedType){
                                
                                        return wrappedType.getCheckStatusResponse();
                                    
                                }
                             
                                    
                                private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory,
                                    java.lang.String param1,
                                    java.lang.String param2,
                                    co.mcel.mz.reservedcharging.DebitAmountRequest dummyWrappedType,
                                 boolean optimizeContent) throws org.apache.axis2.AxisFault{

                                try{
                                co.mcel.mz.reservedcharging.DebitAmountRequest wrappedType = new co.mcel.mz.reservedcharging.DebitAmountRequest();

                                 
                                              wrappedType.setTransactionId(param1);
                                         
                                              wrappedType.setRequesterService(param2);
                                         

                               org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                  
                                        emptyEnvelope.getBody().addChild(wrappedType.getOMElement(co.mcel.mz.reservedcharging.DebitAmountRequest.MY_QNAME,factory));
                                    

                                return emptyEnvelope;
                               } catch(org.apache.axis2.databinding.ADBException e){
                                    throw org.apache.axis2.AxisFault.makeFault(e);
                               }
                               }



                                
                             
                             /* methods to provide back word compatibility */

                             

                                
                                private boolean getDebitAmountResponseDebitAmountResponse(
                                co.mcel.mz.reservedcharging.DebitAmountResponse wrappedType){
                                
                                        return wrappedType.getDebitAmountResponse();
                                    
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
        
                if (co.mcel.mz.reservedcharging.CancelReservationRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CancelReservationRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CancelReservationResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CancelReservationResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.InvalidReservationStatus.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.InvalidReservationStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.DirectDebitRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.DirectDebitRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.DirectDebitResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.DirectDebitResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.RefundRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.RefundRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.RefundResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.RefundResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.InvalidReservationStatus.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.InvalidReservationStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.ReserveAmountRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.ReserveAmountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.ReserveAmountResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.ReserveAmountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.GetAccountTypeRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.GetAccountTypeRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.GetAccountTypeResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.GetAccountTypeResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CheckStatusRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CheckStatusRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CheckStatusResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CheckStatusResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.DebitAmountRequest.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.DebitAmountRequest.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.DebitAmountResponse.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.DebitAmountResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.InvalidReservationStatus.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.InvalidReservationStatus.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.CsvSystemError.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.CsvSystemError.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (co.mcel.mz.reservedcharging.TransactionNotFound.class.equals(type)){
                
                           return co.mcel.mz.reservedcharging.TransactionNotFound.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   