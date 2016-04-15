
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package com.bridge.loyalty.prepaid;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://co.mcel.mz/types/common".equals(namespaceURI) &&
                  "msisdnType".equals(typeName)){
                   
                            return  co.mcel.mz.types.common.MsisdnType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/PrepaidLoyaltyService/".equals(namespaceURI) &&
                  "LoyaltyServiceErrorType".equals(typeName)){
                   
                            return  com.bridge.loyalty.prepaid.LoyaltyServiceErrorType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/PrepaidLoyaltyService/".equals(namespaceURI) &&
                  "adjustmentType".equals(typeName)){
                   
                            return  com.bridge.loyalty.prepaid.AdjustmentType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    