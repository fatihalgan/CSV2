
/**
 * CreateNewPersonalRegistrationRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package com.bridge.simreg.wstypes;
            

            /**
            *  CreateNewPersonalRegistrationRequestType bean class
            */
        
        public  class CreateNewPersonalRegistrationRequestType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = createNewPersonalRegistrationRequestType
                Namespace URI = http://www.bridge.com/simreg
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.bridge.com/simreg")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for RequestId
                        */

                        
                                    protected java.math.BigInteger localRequestId ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigInteger
                           */
                           public  java.math.BigInteger getRequestId(){
                               return localRequestId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RequestId
                               */
                               public void setRequestId(java.math.BigInteger param){
                            
                                            this.localRequestId=param;
                                    

                               }
                            

                        /**
                        * field for RequestTimestamp
                        */

                        
                                    protected java.util.Calendar localRequestTimestamp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Calendar
                           */
                           public  java.util.Calendar getRequestTimestamp(){
                               return localRequestTimestamp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RequestTimestamp
                               */
                               public void setRequestTimestamp(java.util.Calendar param){
                            
                                            this.localRequestTimestamp=param;
                                    

                               }
                            

                        /**
                        * field for CellNumber
                        */

                        
                                    protected co.mcel.mz.types.common.MsisdnType localCellNumber ;
                                

                           /**
                           * Auto generated getter method
                           * @return co.mcel.mz.types.common.MsisdnType
                           */
                           public  co.mcel.mz.types.common.MsisdnType getCellNumber(){
                               return localCellNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CellNumber
                               */
                               public void setCellNumber(co.mcel.mz.types.common.MsisdnType param){
                            
                                            this.localCellNumber=param;
                                    

                               }
                            

                        /**
                        * field for IdentityDocument
                        */

                        
                                    protected com.bridge.simreg.wstypes.IdentityDocType localIdentityDocument ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.simreg.wstypes.IdentityDocType
                           */
                           public  com.bridge.simreg.wstypes.IdentityDocType getIdentityDocument(){
                               return localIdentityDocument;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IdentityDocument
                               */
                               public void setIdentityDocument(com.bridge.simreg.wstypes.IdentityDocType param){
                            
                                            this.localIdentityDocument=param;
                                    

                               }
                            

                        /**
                        * field for PersonInfo
                        */

                        
                                    protected com.bridge.simreg.wstypes.PersonInfoType localPersonInfo ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.simreg.wstypes.PersonInfoType
                           */
                           public  com.bridge.simreg.wstypes.PersonInfoType getPersonInfo(){
                               return localPersonInfo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PersonInfo
                               */
                               public void setPersonInfo(com.bridge.simreg.wstypes.PersonInfoType param){
                            
                                            this.localPersonInfo=param;
                                    

                               }
                            

                        /**
                        * field for Address
                        */

                        
                                    protected com.bridge.simreg.wstypes.AddressType localAddress ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.simreg.wstypes.AddressType
                           */
                           public  com.bridge.simreg.wstypes.AddressType getAddress(){
                               return localAddress;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Address
                               */
                               public void setAddress(com.bridge.simreg.wstypes.AddressType param){
                            
                                            this.localAddress=param;
                                    

                               }
                            

                        /**
                        * field for WorkInfo
                        */

                        
                                    protected com.bridge.simreg.wstypes.WorkInfoType localWorkInfo ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.simreg.wstypes.WorkInfoType
                           */
                           public  com.bridge.simreg.wstypes.WorkInfoType getWorkInfo(){
                               return localWorkInfo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WorkInfo
                               */
                               public void setWorkInfo(com.bridge.simreg.wstypes.WorkInfoType param){
                            
                                            this.localWorkInfo=param;
                                    

                               }
                            

                        /**
                        * field for MKeshQuestion
                        */

                        
                                    protected java.math.BigInteger localMKeshQuestion ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.math.BigInteger
                           */
                           public  java.math.BigInteger getMKeshQuestion(){
                               return localMKeshQuestion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MKeshQuestion
                               */
                               public void setMKeshQuestion(java.math.BigInteger param){
                            
                                            this.localMKeshQuestion=param;
                                    

                               }
                            

                        /**
                        * field for AuthInfo
                        */

                        
                                    protected com.bridge.simreg.wstypes.AuthenticationEntityType localAuthInfo ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.simreg.wstypes.AuthenticationEntityType
                           */
                           public  com.bridge.simreg.wstypes.AuthenticationEntityType getAuthInfo(){
                               return localAuthInfo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AuthInfo
                               */
                               public void setAuthInfo(com.bridge.simreg.wstypes.AuthenticationEntityType param){
                            
                                            this.localAuthInfo=param;
                                    

                               }
                            

                        /**
                        * field for LocationCodes
                        */

                        
                                    protected com.bridge.simreg.wstypes.LocationCodesType localLocationCodes ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.simreg.wstypes.LocationCodesType
                           */
                           public  com.bridge.simreg.wstypes.LocationCodesType getLocationCodes(){
                               return localLocationCodes;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param LocationCodes
                               */
                               public void setLocationCodes(com.bridge.simreg.wstypes.LocationCodesType param){
                            
                                            this.localLocationCodes=param;
                                    

                               }
                            

     /**
     * isReaderMTOMAware
     * @return true if the reader supports MTOM
     */
   public static boolean isReaderMTOMAware(javax.xml.stream.XMLStreamReader reader) {
        boolean isReaderMTOMAware = false;
        
        try{
          isReaderMTOMAware = java.lang.Boolean.TRUE.equals(reader.getProperty(org.apache.axiom.om.OMConstants.IS_DATA_HANDLERS_AWARE));
        }catch(java.lang.IllegalArgumentException e){
          isReaderMTOMAware = false;
        }
        return isReaderMTOMAware;
   }
     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName){

                 public void serialize(org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
                       CreateNewPersonalRegistrationRequestType.this.serialize(parentQName,factory,xmlWriter);
                 }
               };
               return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(
               parentQName,factory,dataSource);
            
       }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       final org.apache.axiom.om.OMFactory factory,
                                       org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,factory,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               final org.apache.axiom.om.OMFactory factory,
                               org.apache.axis2.databinding.utils.writer.MTOMAwareXMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();

                    if ((namespace != null) && (namespace.trim().length() > 0)) {
                        java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
                        if (writerPrefix != null) {
                            xmlWriter.writeStartElement(namespace, parentQName.getLocalPart());
                        } else {
                            if (prefix == null) {
                                prefix = generatePrefix(namespace);
                            }

                            xmlWriter.writeStartElement(prefix, parentQName.getLocalPart(), namespace);
                            xmlWriter.writeNamespace(prefix, namespace);
                            xmlWriter.setPrefix(prefix, namespace);
                        }
                    } else {
                        xmlWriter.writeStartElement(parentQName.getLocalPart());
                    }
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.bridge.com/simreg");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":createNewPersonalRegistrationRequestType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "createNewPersonalRegistrationRequestType",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "http://www.bridge.com/simreg";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"requestId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"requestId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("requestId");
                                    }
                                

                                          if (localRequestId==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("requestId cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRequestId));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.bridge.com/simreg";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"requestTimestamp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"requestTimestamp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("requestTimestamp");
                                    }
                                

                                          if (localRequestTimestamp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("requestTimestamp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRequestTimestamp));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localCellNumber==null){
                                                 throw new org.apache.axis2.databinding.ADBException("cellNumber cannot be null!!");
                                            }
                                           localCellNumber.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","cellNumber"),
                                               factory,xmlWriter);
                                        
                                            if (localIdentityDocument==null){
                                                 throw new org.apache.axis2.databinding.ADBException("identityDocument cannot be null!!");
                                            }
                                           localIdentityDocument.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","identityDocument"),
                                               factory,xmlWriter);
                                        
                                            if (localPersonInfo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("personInfo cannot be null!!");
                                            }
                                           localPersonInfo.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","personInfo"),
                                               factory,xmlWriter);
                                        
                                            if (localAddress==null){
                                                 throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
                                            }
                                           localAddress.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","address"),
                                               factory,xmlWriter);
                                        
                                            if (localWorkInfo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("workInfo cannot be null!!");
                                            }
                                           localWorkInfo.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","workInfo"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://www.bridge.com/simreg";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"mKeshQuestion", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"mKeshQuestion");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("mKeshQuestion");
                                    }
                                

                                          if (localMKeshQuestion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("mKeshQuestion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMKeshQuestion));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localAuthInfo==null){
                                                 throw new org.apache.axis2.databinding.ADBException("authInfo cannot be null!!");
                                            }
                                           localAuthInfo.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","authInfo"),
                                               factory,xmlWriter);
                                        
                                            if (localLocationCodes==null){
                                                 throw new org.apache.axis2.databinding.ADBException("locationCodes cannot be null!!");
                                            }
                                           localLocationCodes.serialize(new javax.xml.namespace.QName("http://www.bridge.com/simreg","locationCodes"),
                                               factory,xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

         /**
          * Util method to write an attribute with the ns prefix
          */
          private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
              if (xmlWriter.getPrefix(namespace) == null) {
                       xmlWriter.writeNamespace(prefix, namespace);
                       xmlWriter.setPrefix(prefix, namespace);

              }

              xmlWriter.writeAttribute(namespace,attName,attValue);

         }

        /**
          * Util method to write an attribute without the ns prefix
          */
          private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                      java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
                if (namespace.equals(""))
              {
                  xmlWriter.writeAttribute(attName,attValue);
              }
              else
              {
                  registerPrefix(xmlWriter, namespace);
                  xmlWriter.writeAttribute(namespace,attName,attValue);
              }
          }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


         /**
         * Register a namespace prefix
         */
         private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
                java.lang.String prefix = xmlWriter.getPrefix(namespace);

                if (prefix == null) {
                    prefix = generatePrefix(namespace);

                    while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
                        prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                    }

                    xmlWriter.writeNamespace(prefix, namespace);
                    xmlWriter.setPrefix(prefix, namespace);
                }

                return prefix;
            }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "requestId"));
                                 
                                        if (localRequestId != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRequestId));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("requestId cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "requestTimestamp"));
                                 
                                        if (localRequestTimestamp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRequestTimestamp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("requestTimestamp cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "cellNumber"));
                            
                            
                                    if (localCellNumber==null){
                                         throw new org.apache.axis2.databinding.ADBException("cellNumber cannot be null!!");
                                    }
                                    elementList.add(localCellNumber);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "identityDocument"));
                            
                            
                                    if (localIdentityDocument==null){
                                         throw new org.apache.axis2.databinding.ADBException("identityDocument cannot be null!!");
                                    }
                                    elementList.add(localIdentityDocument);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "personInfo"));
                            
                            
                                    if (localPersonInfo==null){
                                         throw new org.apache.axis2.databinding.ADBException("personInfo cannot be null!!");
                                    }
                                    elementList.add(localPersonInfo);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "address"));
                            
                            
                                    if (localAddress==null){
                                         throw new org.apache.axis2.databinding.ADBException("address cannot be null!!");
                                    }
                                    elementList.add(localAddress);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "workInfo"));
                            
                            
                                    if (localWorkInfo==null){
                                         throw new org.apache.axis2.databinding.ADBException("workInfo cannot be null!!");
                                    }
                                    elementList.add(localWorkInfo);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "mKeshQuestion"));
                                 
                                        if (localMKeshQuestion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMKeshQuestion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("mKeshQuestion cannot be null!!");
                                        }
                                    
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "authInfo"));
                            
                            
                                    if (localAuthInfo==null){
                                         throw new org.apache.axis2.databinding.ADBException("authInfo cannot be null!!");
                                    }
                                    elementList.add(localAuthInfo);
                                
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/simreg",
                                                                      "locationCodes"));
                            
                            
                                    if (localLocationCodes==null){
                                         throw new org.apache.axis2.databinding.ADBException("locationCodes cannot be null!!");
                                    }
                                    elementList.add(localLocationCodes);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static CreateNewPersonalRegistrationRequestType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            CreateNewPersonalRegistrationRequestType object =
                new CreateNewPersonalRegistrationRequestType();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"createNewPersonalRegistrationRequestType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (CreateNewPersonalRegistrationRequestType)com.bridge.simreg.wstypes.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","requestId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRequestId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","requestTimestamp").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRequestTimestamp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDateTime(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","cellNumber").equals(reader.getName())){
                                
                                                object.setCellNumber(co.mcel.mz.types.common.MsisdnType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","identityDocument").equals(reader.getName())){
                                
                                                object.setIdentityDocument(com.bridge.simreg.wstypes.IdentityDocType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","personInfo").equals(reader.getName())){
                                
                                                object.setPersonInfo(com.bridge.simreg.wstypes.PersonInfoType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","address").equals(reader.getName())){
                                
                                                object.setAddress(com.bridge.simreg.wstypes.AddressType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","workInfo").equals(reader.getName())){
                                
                                                object.setWorkInfo(com.bridge.simreg.wstypes.WorkInfoType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","mKeshQuestion").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMKeshQuestion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInteger(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","authInfo").equals(reader.getName())){
                                
                                                object.setAuthInfo(com.bridge.simreg.wstypes.AuthenticationEntityType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/simreg","locationCodes").equals(reader.getName())){
                                
                                                object.setLocationCodes(com.bridge.simreg.wstypes.LocationCodesType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                              
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
          