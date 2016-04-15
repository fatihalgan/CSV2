
/**
 * BB4PServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package co.mcel.mz.bb4p.server;

        /**
        *  BB4PServiceMessageReceiverInOut message receiver
        */

        public class BB4PServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        BB4PServiceSkeletonInterface skel = (BB4PServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("registerAPN".equals(methodName)){
                
                co.mcel.mz.bb4p.RegisterAPNResponse registerAPNResponse63 = null;
	                        co.mcel.mz.bb4p.RegisterAPNRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.RegisterAPNRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.RegisterAPNRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               registerAPNResponse63 =
                                                   
                                                   
                                                           wrapRegisterAPNResponseRegisterAPNResponse(
                                                       
                                                        

                                                        
                                                       skel.registerAPN(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            ,
                                                                getApnId(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), registerAPNResponse63, false);
                                    } else 

            if("debitAmount".equals(methodName)){
                
                co.mcel.mz.bb4p.DebitAmountResponse debitAmountResponse67 = null;
	                        co.mcel.mz.bb4p.DebitAmountRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.DebitAmountRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.DebitAmountRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               debitAmountResponse67 =
                                                   
                                                   
                                                           wrapDebitAmountResponseDebitAmountResponse(
                                                       
                                                        

                                                        
                                                       skel.debitAmount(
                                                            
                                                                getDebitAmountRequest(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), debitAmountResponse67, false);
                                    } else 

            if("unregisterAPN".equals(methodName)){
                
                co.mcel.mz.bb4p.UnregisterAPNResponse unregisterAPNResponse72 = null;
	                        co.mcel.mz.bb4p.UnregisterAPNRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.UnregisterAPNRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.UnregisterAPNRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               unregisterAPNResponse72 =
                                                   
                                                   
                                                           wrapUnregisterAPNResponseUnregisterAPNResponse(
                                                       
                                                        

                                                        
                                                       skel.unregisterAPN(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            ,
                                                                getApnId(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), unregisterAPNResponse72, false);
                                    } else 

            if("cancelReservation".equals(methodName)){
                
                co.mcel.mz.bb4p.CancelReservationResponse cancelReservationResponse76 = null;
	                        co.mcel.mz.bb4p.CancelReservationRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.CancelReservationRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.CancelReservationRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelReservationResponse76 =
                                                   
                                                   
                                                           wrapCancelReservationResponseCancelReservationResponse(
                                                       
                                                        

                                                        
                                                       skel.cancelReservation(
                                                            
                                                                getCancelReservationRequest(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelReservationResponse76, false);
                                    } else 

            if("getImsi".equals(methodName)){
                
                co.mcel.mz.bb4p.GetImsiResponse getImsiResponse81 = null;
	                        co.mcel.mz.bb4p.GetImsiRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.GetImsiRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.GetImsiRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getImsiResponse81 =
                                                   
                                                   
                                                           wrapGetImsiResponseGetImsiResponse(
                                                       
                                                        

                                                        
                                                       skel.getImsi(
                                                            
                                                                getInternationalPrefix(wrappedParam)
                                                            ,
                                                                getNumber(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getImsiResponse81, false);
                                    } else 

            if("getServiceClass".equals(methodName)){
                
                co.mcel.mz.bb4p.GetServiceClassResponse getServiceClassResponse86 = null;
	                        co.mcel.mz.bb4p.GetServiceClassRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.GetServiceClassRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.GetServiceClassRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getServiceClassResponse86 =
                                                   
                                                   
                                                           wrapGetServiceClassResponseGetServiceClassResponse(
                                                       
                                                        

                                                        
                                                       skel.getServiceClass(
                                                            
                                                                getInternationalPrefix(wrappedParam)
                                                            ,
                                                                getNumber(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getServiceClassResponse86, false);
                                    } else 

            if("reserveAmount".equals(methodName)){
                
                co.mcel.mz.bb4p.ReserveAmountResponse reserveAmountResponse92 = null;
	                        co.mcel.mz.bb4p.ReserveAmountRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.ReserveAmountRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.ReserveAmountRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               reserveAmountResponse92 =
                                                   
                                                   
                                                           wrapReserveAmountResponseReserveAmountResponse(
                                                       
                                                        

                                                        
                                                       skel.reserveAmount(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            ,
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getAmount(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), reserveAmountResponse92, false);
                                    } else 

            if("checkStatus".equals(methodName)){
                
                co.mcel.mz.bb4p.CheckStatusResponse checkStatusResponse96 = null;
	                        co.mcel.mz.bb4p.CheckStatusRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.CheckStatusRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.CheckStatusRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               checkStatusResponse96 =
                                                   
                                                   
                                                           wrapCheckStatusResponseCheckStatusResponse(
                                                       
                                                        

                                                        
                                                       skel.checkStatus(
                                                            
                                                                getCheckStatusRequest(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), checkStatusResponse96, false);
                                    } else 

            if("refund".equals(methodName)){
                
                co.mcel.mz.bb4p.RefundResponse refundResponse100 = null;
	                        co.mcel.mz.bb4p.RefundRequest wrappedParam =
                                                             (co.mcel.mz.bb4p.RefundRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.bb4p.RefundRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               refundResponse100 =
                                                   
                                                   
                                                           wrapRefundResponseRefundResponse(
                                                       
                                                        

                                                        
                                                       skel.refund(
                                                            
                                                                getRefundRequest(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), refundResponse100, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        } catch (CSVSystemError e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"csvSystemError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (InvalidReservationStatus e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"invalidReservationStatus");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (CSError e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"csError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (TransactionNotFound e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"transactionNotFound");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
         catch (EMAError e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"emaError");
            org.apache.axis2.AxisFault f = createAxisFault(e);
            if (e.getFaultMessage() != null){
                f.setDetail(toOM(e.getFaultMessage(),false));
            }
            throw f;
            }
        
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
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
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.RegisterAPNResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.RegisterAPNResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        co.mcel.mz.bb4p.RegisterAPNRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        private int getApnId(
                        co.mcel.mz.bb4p.RegisterAPNRequest wrappedType){
                        
                                return wrappedType.getApnId();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.RegisterAPNResponse wrapRegisterAPNResponseRegisterAPNResponse(
                        boolean param){
                        co.mcel.mz.bb4p.RegisterAPNResponse wrappedElement = new co.mcel.mz.bb4p.RegisterAPNResponse();
                        
                                wrappedElement.setRegisterAPNResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.RegisterAPNResponse wrapregisterAPN(){
                                co.mcel.mz.bb4p.RegisterAPNResponse wrappedElement = new co.mcel.mz.bb4p.RegisterAPNResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.DebitAmountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.DebitAmountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getDebitAmountRequest(
                        co.mcel.mz.bb4p.DebitAmountRequest wrappedType){
                        
                                return wrappedType.getDebitAmountRequest();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.DebitAmountResponse wrapDebitAmountResponseDebitAmountResponse(
                        boolean param){
                        co.mcel.mz.bb4p.DebitAmountResponse wrappedElement = new co.mcel.mz.bb4p.DebitAmountResponse();
                        
                                wrappedElement.setDebitAmountResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.DebitAmountResponse wrapdebitAmount(){
                                co.mcel.mz.bb4p.DebitAmountResponse wrappedElement = new co.mcel.mz.bb4p.DebitAmountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.UnregisterAPNResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.UnregisterAPNResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        co.mcel.mz.bb4p.UnregisterAPNRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        private int getApnId(
                        co.mcel.mz.bb4p.UnregisterAPNRequest wrappedType){
                        
                                return wrappedType.getApnId();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.UnregisterAPNResponse wrapUnregisterAPNResponseUnregisterAPNResponse(
                        boolean param){
                        co.mcel.mz.bb4p.UnregisterAPNResponse wrappedElement = new co.mcel.mz.bb4p.UnregisterAPNResponse();
                        
                                wrappedElement.setUnregisterAPNResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.UnregisterAPNResponse wrapunregisterAPN(){
                                co.mcel.mz.bb4p.UnregisterAPNResponse wrappedElement = new co.mcel.mz.bb4p.UnregisterAPNResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.CancelReservationResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.CancelReservationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getCancelReservationRequest(
                        co.mcel.mz.bb4p.CancelReservationRequest wrappedType){
                        
                                return wrappedType.getCancelReservationRequest();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.CancelReservationResponse wrapCancelReservationResponseCancelReservationResponse(
                        boolean param){
                        co.mcel.mz.bb4p.CancelReservationResponse wrappedElement = new co.mcel.mz.bb4p.CancelReservationResponse();
                        
                                wrappedElement.setCancelReservationResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.CancelReservationResponse wrapcancelReservation(){
                                co.mcel.mz.bb4p.CancelReservationResponse wrappedElement = new co.mcel.mz.bb4p.CancelReservationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.GetImsiResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.GetImsiResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getInternationalPrefix(
                        co.mcel.mz.bb4p.GetImsiRequest wrappedType){
                        
                                return wrappedType.getGetImsiRequest().getInternationalPrefix();
                            
                        }
                     

                        private java.lang.String getNumber(
                        co.mcel.mz.bb4p.GetImsiRequest wrappedType){
                        
                                return wrappedType.getGetImsiRequest().getNumber();
                            
                        }
                     
                        private co.mcel.mz.types.common.MsisdnType getgetImsi(
                        co.mcel.mz.bb4p.GetImsiRequest wrappedType){
                            return wrappedType.getGetImsiRequest();
                        }
                        
                        
                    

                        
                        private co.mcel.mz.bb4p.GetImsiResponse wrapGetImsiResponseGetImsiResponse(
                        java.lang.String param){
                        co.mcel.mz.bb4p.GetImsiResponse wrappedElement = new co.mcel.mz.bb4p.GetImsiResponse();
                        
                                wrappedElement.setGetImsiResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.GetImsiResponse wrapgetImsi(){
                                co.mcel.mz.bb4p.GetImsiResponse wrappedElement = new co.mcel.mz.bb4p.GetImsiResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.GetServiceClassResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.GetServiceClassResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getInternationalPrefix(
                        co.mcel.mz.bb4p.GetServiceClassRequest wrappedType){
                        
                                return wrappedType.getGetServiceClassRequest().getInternationalPrefix();
                            
                        }
                     

                        private java.lang.String getNumber(
                        co.mcel.mz.bb4p.GetServiceClassRequest wrappedType){
                        
                                return wrappedType.getGetServiceClassRequest().getNumber();
                            
                        }
                     
                        private co.mcel.mz.types.common.MsisdnType getgetServiceClass(
                        co.mcel.mz.bb4p.GetServiceClassRequest wrappedType){
                            return wrappedType.getGetServiceClassRequest();
                        }
                        
                        
                    

                        
                        private co.mcel.mz.bb4p.GetServiceClassResponse wrapGetServiceClassResponseGetServiceClassResponse(
                        int param){
                        co.mcel.mz.bb4p.GetServiceClassResponse wrappedElement = new co.mcel.mz.bb4p.GetServiceClassResponse();
                        
                                wrappedElement.setGetServiceClassResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.GetServiceClassResponse wrapgetServiceClass(){
                                co.mcel.mz.bb4p.GetServiceClassResponse wrappedElement = new co.mcel.mz.bb4p.GetServiceClassResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.ReserveAmountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.ReserveAmountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        co.mcel.mz.bb4p.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        private java.lang.String getTransactionId(
                        co.mcel.mz.bb4p.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private float getAmount(
                        co.mcel.mz.bb4p.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getAmount();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.ReserveAmountResponse wrapReserveAmountResponseReserveAmountResponse(
                        boolean param){
                        co.mcel.mz.bb4p.ReserveAmountResponse wrappedElement = new co.mcel.mz.bb4p.ReserveAmountResponse();
                        
                                wrappedElement.setReserveAmountResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.ReserveAmountResponse wrapreserveAmount(){
                                co.mcel.mz.bb4p.ReserveAmountResponse wrappedElement = new co.mcel.mz.bb4p.ReserveAmountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.CheckStatusResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.CheckStatusResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getCheckStatusRequest(
                        co.mcel.mz.bb4p.CheckStatusRequest wrappedType){
                        
                                return wrappedType.getCheckStatusRequest();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.CheckStatusResponse wrapCheckStatusResponseCheckStatusResponse(
                        co.mcel.mz.bb4p.CheckStatusResponse_type0 param){
                        co.mcel.mz.bb4p.CheckStatusResponse wrappedElement = new co.mcel.mz.bb4p.CheckStatusResponse();
                        
                                wrappedElement.setCheckStatusResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.CheckStatusResponse wrapcheckStatus(){
                                co.mcel.mz.bb4p.CheckStatusResponse wrappedElement = new co.mcel.mz.bb4p.CheckStatusResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.bb4p.RefundResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.bb4p.RefundResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getRefundRequest(
                        co.mcel.mz.bb4p.RefundRequest wrappedType){
                        
                                return wrappedType.getRefundRequest();
                            
                        }
                     

                        
                        private co.mcel.mz.bb4p.RefundResponse wrapRefundResponseRefundResponse(
                        boolean param){
                        co.mcel.mz.bb4p.RefundResponse wrappedElement = new co.mcel.mz.bb4p.RefundResponse();
                        
                                wrappedElement.setRefundResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.bb4p.RefundResponse wraprefund(){
                                co.mcel.mz.bb4p.RefundResponse wrappedElement = new co.mcel.mz.bb4p.RefundResponse();
                                return wrappedElement;
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

        private org.apache.axis2.AxisFault createAxisFault(java.lang.Exception e) {
        org.apache.axis2.AxisFault f;
        Throwable cause = e.getCause();
        if (cause != null) {
            f = new org.apache.axis2.AxisFault(e.getMessage(), cause);
        } else {
            f = new org.apache.axis2.AxisFault(e.getMessage());
        }

        return f;
    }

        }//end of class
    