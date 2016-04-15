
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package co.mcel.mz.reservedcharging;
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
                  "http://co.mcel.mz/types/common".equals(namespaceURI) &&
                  "EMAErrorType".equals(typeName)){
                   
                            return  co.mcel.mz.types.common.EMAErrorType.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://co.mcel.mz/types/common".equals(namespaceURI) &&
                  "CSErrorType".equals(typeName)){
                   
                            return  co.mcel.mz.types.common.CSErrorType.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    