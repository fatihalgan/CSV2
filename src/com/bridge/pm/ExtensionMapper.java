
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package com.bridge.pm;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "disconnectInfoType".equals(typeName)){
                   
                            return  com.bridge.pm.types.DisconnectInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://co.mcel.mz/types/common".equals(namespaceURI) &&
                  "msisdnType".equals(typeName)){
                   
                            return  co.mcel.mz.types.common.MsisdnType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "hlrInfoType".equals(typeName)){
                   
                            return  com.bridge.pm.types.HlrInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "cardProfile".equals(typeName)){
                   
                            return  com.bridge.pm.types.CardProfile.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "swapInfoType".equals(typeName)){
                   
                            return  com.bridge.pm.types.SwapInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "accountInfoType".equals(typeName)){
                   
                            return  com.bridge.pm.types.AccountInfoType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "dedicatedAccount".equals(typeName)){
                   
                            return  com.bridge.pm.types.DedicatedAccount.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://www.bridge.com/pm/types".equals(namespaceURI) &&
                  "aucInfoType".equals(typeName)){
                   
                            return  com.bridge.pm.types.AucInfoType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    