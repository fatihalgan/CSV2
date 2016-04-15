
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */

            package com.rim.blackberry.provision.control.ari.comm.soap;
            /**
            *  ExtensionMapper class
            */
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionReqEntity".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReqEntity.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionRequest".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionRequest.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionReply".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReply.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionReqHeader".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReqHeader.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionSender".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionSender.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari".equals(namespaceURI) &&
                  "ARIProcessingException".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.ARIProcessingException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "TransactionCode".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.TransactionCode.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionReplyHeader".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyHeader.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionReplyEntity".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ProvisionDataItem".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem.Factory.parse(reader);
                        

                  }

              
                  if (
                  "java:provision.control.ari.comm.soap".equals(namespaceURI) &&
                  "ReservedToken".equals(typeName)){
                   
                            return  com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    