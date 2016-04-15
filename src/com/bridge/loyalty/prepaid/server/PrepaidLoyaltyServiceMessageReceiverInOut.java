
/**
 * PrepaidLoyaltyServiceMessageReceiverInOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
        package com.bridge.loyalty.prepaid.server;

        /**
        *  PrepaidLoyaltyServiceMessageReceiverInOut message receiver
        */

        public class PrepaidLoyaltyServiceMessageReceiverInOut extends org.apache.axis2.receivers.AbstractInOutMessageReceiver{


        public void invokeBusinessLogic(org.apache.axis2.context.MessageContext msgContext, org.apache.axis2.context.MessageContext newMsgContext)
        throws org.apache.axis2.AxisFault{

        try {

        // get the implementation class for the Web Service
        Object obj = getTheImplementationObject(msgContext);

        PrepaidLoyaltyServiceSkeletonInterface skel = (PrepaidLoyaltyServiceSkeletonInterface)obj;
        //Out Envelop
        org.apache.axiom.soap.SOAPEnvelope envelope = null;
        //Find the axisOperation that has been set by the Dispatch phase.
        org.apache.axis2.description.AxisOperation op = msgContext.getOperationContext().getAxisOperation();
        if (op == null) {
        throw new org.apache.axis2.AxisFault("Operation is not located, if this is doclit style the SOAP-ACTION should specified via the SOAP Action to use the RawXMLProvider");
        }

        java.lang.String methodName;
        if((op.getName() != null) && ((methodName = org.apache.axis2.util.JavaUtils.xmlNameToJavaIdentifier(op.getName().getLocalPart())) != null)){

        

            if("adjustLoyaltyPoints".equals(methodName)){
                
                com.bridge.loyalty.prepaid.AdjustPointsResponse adjustPointsResponse19 = null;
	                        com.bridge.loyalty.prepaid.AdjustPointsRequest wrappedParam =
                                                             (com.bridge.loyalty.prepaid.AdjustPointsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.bridge.loyalty.prepaid.AdjustPointsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               adjustPointsResponse19 =
                                                   
                                                   
                                                        

                                                        
                                                       skel.adjustLoyaltyPoints(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            ,
                                                                getOriginTransId(wrappedParam)
                                                            ,
                                                                getRelativeAmount(wrappedParam)
                                                            ,
                                                                getPointsAdjustmentType(wrappedParam)
                                                            )
                                                    ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), adjustPointsResponse19, false);
                                    } else 

            if("queryLoyaltyPoints".equals(methodName)){
                
                com.bridge.loyalty.prepaid.QueryPointsResponse queryPointsResponse25 = null;
	                        com.bridge.loyalty.prepaid.QueryPointsRequest wrappedParam =
                                                             (com.bridge.loyalty.prepaid.QueryPointsRequest)fromOM(
                                    msgContext.getEnvelope().getBody().getFirstElement(),
                                    com.bridge.loyalty.prepaid.QueryPointsRequest.class,
                                    getEnvelopeNamespaces(msgContext.getEnvelope()));
                                                
                                               queryPointsResponse25 =
                                                   
                                                   
                                                           wrapQueryPointsResponseTotalPoints(
                                                       
                                                        

                                                        
                                                       skel.queryLoyaltyPoints(
                                                            
                                                                getMsisdn(wrappedParam)
                                                            )
                                                    
                                                         )
                                                     ;
                                            
                                        envelope = toEnvelope(getSOAPFactory(msgContext), queryPointsResponse25, false);
                                    
            } else {
              throw new java.lang.RuntimeException("method not found");
            }
        

        newMsgContext.setEnvelope(envelope);
        }
        } catch (LoyaltyServiceFault e) {

            msgContext.setProperty(org.apache.axis2.Constants.FAULT_NAME,"loyaltyServiceError");
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
        
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.bridge.loyalty.prepaid.AdjustPointsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.bridge.loyalty.prepaid.AdjustPointsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        com.bridge.loyalty.prepaid.AdjustPointsRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        private java.lang.String getOriginTransId(
                        com.bridge.loyalty.prepaid.AdjustPointsRequest wrappedType){
                        
                                return wrappedType.getOriginTransId();
                            
                        }
                     

                        private java.math.BigDecimal getRelativeAmount(
                        com.bridge.loyalty.prepaid.AdjustPointsRequest wrappedType){
                        
                                return wrappedType.getRelativeAmount();
                            
                        }
                     

                        private com.bridge.loyalty.prepaid.AdjustmentType getPointsAdjustmentType(
                        com.bridge.loyalty.prepaid.AdjustPointsRequest wrappedType){
                        
                                return wrappedType.getPointsAdjustmentType();
                            
                        }
                     

                        
                        private com.bridge.loyalty.prepaid.AdjustPointsResponse wrapAdjustPointsResponseTransactionId(
                        long param){
                        com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedElement = new com.bridge.loyalty.prepaid.AdjustPointsResponse();
                        
                                wrappedElement.setTransactionId(param);
                            
                            return wrappedElement;
                        }
                     

                        
                        private com.bridge.loyalty.prepaid.AdjustPointsResponse wrapAdjustPointsResponseAdjustedAmount(
                        java.math.BigDecimal param){
                        com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedElement = new com.bridge.loyalty.prepaid.AdjustPointsResponse();
                        
                                wrappedElement.setAdjustedAmount(param);
                            
                            return wrappedElement;
                        }
                     

                        
                        private com.bridge.loyalty.prepaid.AdjustPointsResponse wrapAdjustPointsResponseRemainingPoints(
                        java.math.BigDecimal param){
                        com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedElement = new com.bridge.loyalty.prepaid.AdjustPointsResponse();
                        
                                wrappedElement.setRemainingPoints(param);
                            
                            return wrappedElement;
                        }
                     
                         private com.bridge.loyalty.prepaid.AdjustPointsResponse wrapadjustLoyaltyPoints(){
                                com.bridge.loyalty.prepaid.AdjustPointsResponse wrappedElement = new com.bridge.loyalty.prepaid.AdjustPointsResponse();
                                return wrappedElement;
                         }
                    
                    private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, com.bridge.loyalty.prepaid.QueryPointsResponse param, boolean optimizeContent)
                        throws org.apache.axis2.AxisFault{
                      try{
                          org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                           
                                    emptyEnvelope.getBody().addChild(param.getOMElement(com.bridge.loyalty.prepaid.QueryPointsResponse.MY_QNAME,factory));
                                

                         return emptyEnvelope;
                    } catch(org.apache.axis2.databinding.ADBException e){
                        throw org.apache.axis2.AxisFault.makeFault(e);
                    }
                    }
                    

                        private co.mcel.mz.types.common.MsisdnType getMsisdn(
                        com.bridge.loyalty.prepaid.QueryPointsRequest wrappedType){
                        
                                return wrappedType.getMsisdn();
                            
                        }
                     

                        
                        private com.bridge.loyalty.prepaid.QueryPointsResponse wrapQueryPointsResponseTotalPoints(
                        java.math.BigDecimal param){
                        com.bridge.loyalty.prepaid.QueryPointsResponse wrappedElement = new com.bridge.loyalty.prepaid.QueryPointsResponse();
                        
                                wrappedElement.setTotalPoints(param);
                            
                            return wrappedElement;
                        }
                     
                         private com.bridge.loyalty.prepaid.QueryPointsResponse wrapqueryLoyaltyPoints(){
                                com.bridge.loyalty.prepaid.QueryPointsResponse wrappedElement = new com.bridge.loyalty.prepaid.QueryPointsResponse();
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
    