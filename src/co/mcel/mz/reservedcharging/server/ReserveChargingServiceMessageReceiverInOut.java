
/**
 * ReserveChargingServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package co.mcel.mz.reservedcharging.server;

        /**
        *  ReserveChargingServiceMessageReceiverInOut message receiver
        */

        public class ReserveChargingServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        ReserveChargingServiceSkeletonInterface skel = (ReserveChargingServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("cancelReservation".equals(methodName)){
                
                co.mcel.mz.reservedcharging.CancelReservationResponse cancelReservationResponse64 = null;
	                        co.mcel.mz.reservedcharging.CancelReservationRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.CancelReservationRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.CancelReservationRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               cancelReservationResponse64 =
                                                   
                                                   
                                                           wrapCancelReservationResponseCancelReservationResponse(
                                                       
                                                        

                                                        
                                                       skel.cancelReservation(
                                                            
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getRequesterService(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), cancelReservationResponse64, false);
                                    } else 

            if("directDebit".equals(methodName)){
                
                co.mcel.mz.reservedcharging.DirectDebitResponse directDebitResponse72 = null;
	                        co.mcel.mz.reservedcharging.DirectDebitRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.DirectDebitRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.DirectDebitRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               directDebitResponse72 =
                                                   
                                                   
                                                           wrapDirectDebitResponseDirectDebitResponse(
                                                       
                                                        

                                                        
                                                       skel.directDebit(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            ,
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getRequesterService(wrappedParam)
                                                            ,
                                                                getAmount(wrappedParam)
                                                            ,
                                                                getDescription(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), directDebitResponse72, false);
                                    } else 

            if("refund".equals(methodName)){
                
                co.mcel.mz.reservedcharging.RefundResponse refundResponse77 = null;
	                        co.mcel.mz.reservedcharging.RefundRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.RefundRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.RefundRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               refundResponse77 =
                                                   
                                                   
                                                           wrapRefundResponseRefundResponse(
                                                       
                                                        

                                                        
                                                       skel.refund(
                                                            
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getRequesterService(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), refundResponse77, false);
                                    } else 

            if("reserveAmount".equals(methodName)){
                
                co.mcel.mz.reservedcharging.ReserveAmountResponse reserveAmountResponse85 = null;
	                        co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.ReserveAmountRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.ReserveAmountRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               reserveAmountResponse85 =
                                                   
                                                   
                                                           wrapReserveAmountResponseReserveAmountResponse(
                                                       
                                                        

                                                        
                                                       skel.reserveAmount(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            ,
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getRequesterService(wrappedParam)
                                                            ,
                                                                getAmount(wrappedParam)
                                                            ,
                                                                getDescription(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), reserveAmountResponse85, false);
                                    } else 

            if("getAccountType".equals(methodName)){
                
                co.mcel.mz.reservedcharging.GetAccountTypeResponse getAccountTypeResponse89 = null;
	                        co.mcel.mz.reservedcharging.GetAccountTypeRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.GetAccountTypeRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.GetAccountTypeRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               getAccountTypeResponse89 =
                                                   
                                                   
                                                           wrapGetAccountTypeResponseGetAccountTypeResponse(
                                                       
                                                        

                                                        
                                                       skel.getAccountType(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), getAccountTypeResponse89, false);
                                    } else 

            if("checkStatus".equals(methodName)){
                
                co.mcel.mz.reservedcharging.CheckStatusResponse checkStatusResponse94 = null;
	                        co.mcel.mz.reservedcharging.CheckStatusRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.CheckStatusRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.CheckStatusRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               checkStatusResponse94 =
                                                   
                                                   
                                                           wrapCheckStatusResponseCheckStatusResponse(
                                                       
                                                        

                                                        
                                                       skel.checkStatus(
                                                            
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getRequesterService(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), checkStatusResponse94, false);
                                    } else 

            if("debitAmount".equals(methodName)){
                
                co.mcel.mz.reservedcharging.DebitAmountResponse debitAmountResponse99 = null;
	                        co.mcel.mz.reservedcharging.DebitAmountRequest wrappedParam =
                                                             (co.mcel.mz.reservedcharging.DebitAmountRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    co.mcel.mz.reservedcharging.DebitAmountRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               debitAmountResponse99 =
                                                   
                                                   
                                                           wrapDebitAmountResponseDebitAmountResponse(
                                                       
                                                        

                                                        
                                                       skel.debitAmount(
                                                            
                                                                getTransactionId(wrappedParam)
                                                            ,
                                                                getRequesterService(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), debitAmountResponse99, false);
                                    
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
        
        catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
        }
        
        //
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
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.CancelReservationResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.CancelReservationResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getTransactionId(
                        co.mcel.mz.reservedcharging.CancelReservationRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private java.lang.String getRequesterService(
                        co.mcel.mz.reservedcharging.CancelReservationRequest wrappedType){
                        
                                return wrappedType.getRequesterService();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.CancelReservationResponse wrapCancelReservationResponseCancelReservationResponse(
                        boolean param){
                        co.mcel.mz.reservedcharging.CancelReservationResponse wrappedElement = new co.mcel.mz.reservedcharging.CancelReservationResponse();
                        
                                wrappedElement.setCancelReservationResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.CancelReservationResponse wrapcancelReservation(){
                                co.mcel.mz.reservedcharging.CancelReservationResponse wrappedElement = new co.mcel.mz.reservedcharging.CancelReservationResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.DirectDebitResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.DirectDebitResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        co.mcel.mz.reservedcharging.DirectDebitRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        private java.lang.String getTransactionId(
                        co.mcel.mz.reservedcharging.DirectDebitRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private java.lang.String getRequesterService(
                        co.mcel.mz.reservedcharging.DirectDebitRequest wrappedType){
                        
                                return wrappedType.getRequesterService();
                            
                        }
                     

                        private float getAmount(
                        co.mcel.mz.reservedcharging.DirectDebitRequest wrappedType){
                        
                                return wrappedType.getAmount();
                            
                        }
                     

                        private java.lang.String getDescription(
                        co.mcel.mz.reservedcharging.DirectDebitRequest wrappedType){
                        
                                return wrappedType.getDescription();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.DirectDebitResponse wrapDirectDebitResponseDirectDebitResponse(
                        boolean param){
                        co.mcel.mz.reservedcharging.DirectDebitResponse wrappedElement = new co.mcel.mz.reservedcharging.DirectDebitResponse();
                        
                                wrappedElement.setDirectDebitResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.DirectDebitResponse wrapdirectDebit(){
                                co.mcel.mz.reservedcharging.DirectDebitResponse wrappedElement = new co.mcel.mz.reservedcharging.DirectDebitResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.RefundResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.RefundResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getTransactionId(
                        co.mcel.mz.reservedcharging.RefundRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private java.lang.String getRequesterService(
                        co.mcel.mz.reservedcharging.RefundRequest wrappedType){
                        
                                return wrappedType.getRequesterService();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.RefundResponse wrapRefundResponseRefundResponse(
                        boolean param){
                        co.mcel.mz.reservedcharging.RefundResponse wrappedElement = new co.mcel.mz.reservedcharging.RefundResponse();
                        
                                wrappedElement.setRefundResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.RefundResponse wraprefund(){
                                co.mcel.mz.reservedcharging.RefundResponse wrappedElement = new co.mcel.mz.reservedcharging.RefundResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.ReserveAmountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.ReserveAmountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        private java.lang.String getTransactionId(
                        co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private java.lang.String getRequesterService(
                        co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getRequesterService();
                            
                        }
                     

                        private float getAmount(
                        co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getAmount();
                            
                        }
                     

                        private java.lang.String getDescription(
                        co.mcel.mz.reservedcharging.ReserveAmountRequest wrappedType){
                        
                                return wrappedType.getDescription();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.ReserveAmountResponse wrapReserveAmountResponseReserveAmountResponse(
                        boolean param){
                        co.mcel.mz.reservedcharging.ReserveAmountResponse wrappedElement = new co.mcel.mz.reservedcharging.ReserveAmountResponse();
                        
                                wrappedElement.setReserveAmountResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.ReserveAmountResponse wrapreserveAmount(){
                                co.mcel.mz.reservedcharging.ReserveAmountResponse wrappedElement = new co.mcel.mz.reservedcharging.ReserveAmountResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.GetAccountTypeResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.GetAccountTypeResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        co.mcel.mz.reservedcharging.GetAccountTypeRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.GetAccountTypeResponse wrapGetAccountTypeResponseGetAccountTypeResponse(
                        co.mcel.mz.reservedcharging.GetAccountTypeResponse_type0 param){
                        co.mcel.mz.reservedcharging.GetAccountTypeResponse wrappedElement = new co.mcel.mz.reservedcharging.GetAccountTypeResponse();
                        
                                wrappedElement.setGetAccountTypeResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.GetAccountTypeResponse wrapgetAccountType(){
                                co.mcel.mz.reservedcharging.GetAccountTypeResponse wrappedElement = new co.mcel.mz.reservedcharging.GetAccountTypeResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.CheckStatusResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.CheckStatusResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getTransactionId(
                        co.mcel.mz.reservedcharging.CheckStatusRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private java.lang.String getRequesterService(
                        co.mcel.mz.reservedcharging.CheckStatusRequest wrappedType){
                        
                                return wrappedType.getRequesterService();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.CheckStatusResponse wrapCheckStatusResponseCheckStatusResponse(
                        co.mcel.mz.reservedcharging.CheckStatusResponse_type0 param){
                        co.mcel.mz.reservedcharging.CheckStatusResponse wrappedElement = new co.mcel.mz.reservedcharging.CheckStatusResponse();
                        
                                wrappedElement.setCheckStatusResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.CheckStatusResponse wrapcheckStatus(){
                                co.mcel.mz.reservedcharging.CheckStatusResponse wrappedElement = new co.mcel.mz.reservedcharging.CheckStatusResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, co.mcel.mz.reservedcharging.DebitAmountResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(co.mcel.mz.reservedcharging.DebitAmountResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private java.lang.String getTransactionId(
                        co.mcel.mz.reservedcharging.DebitAmountRequest wrappedType){
                        
                                return wrappedType.getTransactionId();
                            
                        }
                     

                        private java.lang.String getRequesterService(
                        co.mcel.mz.reservedcharging.DebitAmountRequest wrappedType){
                        
                                return wrappedType.getRequesterService();
                            
                        }
                     

                        
                        private co.mcel.mz.reservedcharging.DebitAmountResponse wrapDebitAmountResponseDebitAmountResponse(
                        boolean param){
                        co.mcel.mz.reservedcharging.DebitAmountResponse wrappedElement = new co.mcel.mz.reservedcharging.DebitAmountResponse();
                        
                                wrappedElement.setDebitAmountResponse(param);
                            
                            return wrappedElement;
                        }
                     
                         private co.mcel.mz.reservedcharging.DebitAmountResponse wrapdebitAmount(){
                                co.mcel.mz.reservedcharging.DebitAmountResponse wrappedElement = new co.mcel.mz.reservedcharging.DebitAmountResponse();
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
    