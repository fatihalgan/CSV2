
/**
 * HlrInfoType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package com.bridge.pm.types;
            

            /**
            *  HlrInfoType bean class
            */
        
        public  class HlrInfoType
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = hlrInfoType
                Namespace URI = http://www.bridge.com/pm/types
                Namespace Prefix = ns2
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://www.bridge.com/pm/types")){
                return "ns2";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Msisdn
                        */

                        
                                    protected co.mcel.mz.types.common.MsisdnType localMsisdn ;
                                

                           /**
                           * Auto generated getter method
                           * @return co.mcel.mz.types.common.MsisdnType
                           */
                           public  co.mcel.mz.types.common.MsisdnType getMsisdn(){
                               return localMsisdn;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Msisdn
                               */
                               public void setMsisdn(co.mcel.mz.types.common.MsisdnType param){
                            
                                            this.localMsisdn=param;
                                    

                               }
                            

                        /**
                        * field for Imsi
                        */

                        
                                    protected java.lang.String localImsi ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImsi(){
                               return localImsi;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Imsi
                               */
                               public void setImsi(java.lang.String param){
                            
                                            this.localImsi=param;
                                    

                               }
                            

                        /**
                        * field for Sim
                        */

                        
                                    protected java.lang.String localSim ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSim(){
                               return localSim;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sim
                               */
                               public void setSim(java.lang.String param){
                            
                                            this.localSim=param;
                                    

                               }
                            

                        /**
                        * field for BusinessPlan
                        */

                        
                                    protected int localBusinessPlan ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getBusinessPlan(){
                               return localBusinessPlan;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BusinessPlan
                               */
                               public void setBusinessPlan(int param){
                            
                                            this.localBusinessPlan=param;
                                    

                               }
                            

                        /**
                        * field for Sdp
                        */

                        
                                    protected java.lang.String localSdp ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSdp(){
                               return localSdp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sdp
                               */
                               public void setSdp(java.lang.String param){
                            
                                            this.localSdp=param;
                                    

                               }
                            

                        /**
                        * field for MasterSubscriberNumber
                        */

                        
                                    protected co.mcel.mz.types.common.MsisdnType localMasterSubscriberNumber ;
                                

                           /**
                           * Auto generated getter method
                           * @return co.mcel.mz.types.common.MsisdnType
                           */
                           public  co.mcel.mz.types.common.MsisdnType getMasterSubscriberNumber(){
                               return localMasterSubscriberNumber;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param MasterSubscriberNumber
                               */
                               public void setMasterSubscriberNumber(co.mcel.mz.types.common.MsisdnType param){
                            
                                            this.localMasterSubscriberNumber=param;
                                    

                               }
                            

                        /**
                        * field for TempBlockingStatus
                        */

                        
                                    protected java.lang.String localTempBlockingStatus ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTempBlockingStatus(){
                               return localTempBlockingStatus;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TempBlockingStatus
                               */
                               public void setTempBlockingStatus(java.lang.String param){
                            
                                            this.localTempBlockingStatus=param;
                                    

                               }
                            

                        /**
                        * field for OrganizationId
                        */

                        
                                    protected int localOrganizationId ;
                                

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getOrganizationId(){
                               return localOrganizationId;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param OrganizationId
                               */
                               public void setOrganizationId(int param){
                            
                                            this.localOrganizationId=param;
                                    

                               }
                            

                        /**
                        * field for CardProfile
                        */

                        
                                    protected com.bridge.pm.types.CardProfile localCardProfile ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.bridge.pm.types.CardProfile
                           */
                           public  com.bridge.pm.types.CardProfile getCardProfile(){
                               return localCardProfile;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CardProfile
                               */
                               public void setCardProfile(com.bridge.pm.types.CardProfile param){
                            
                                            this.localCardProfile=param;
                                    

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
                       HlrInfoType.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://www.bridge.com/pm/types");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":hlrInfoType",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "hlrInfoType",
                           xmlWriter);
                   }

               
                   }
               
                                            if (localMsisdn==null){
                                                 throw new org.apache.axis2.databinding.ADBException("msisdn cannot be null!!");
                                            }
                                           localMsisdn.serialize(new javax.xml.namespace.QName("http://www.bridge.com/pm/types","msisdn"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://www.bridge.com/pm/types";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"imsi", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"imsi");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("imsi");
                                    }
                                

                                          if (localImsi==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("imsi cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImsi);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.bridge.com/pm/types";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sim", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sim");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sim");
                                    }
                                

                                          if (localSim==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sim cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSim);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.bridge.com/pm/types";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"businessPlan", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"businessPlan");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("businessPlan");
                                    }
                                
                                               if (localBusinessPlan==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("businessPlan cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBusinessPlan));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.bridge.com/pm/types";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"sdp", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"sdp");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("sdp");
                                    }
                                

                                          if (localSdp==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSdp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localMasterSubscriberNumber==null){
                                                 throw new org.apache.axis2.databinding.ADBException("masterSubscriberNumber cannot be null!!");
                                            }
                                           localMasterSubscriberNumber.serialize(new javax.xml.namespace.QName("http://www.bridge.com/pm/types","masterSubscriberNumber"),
                                               factory,xmlWriter);
                                        
                                    namespace = "http://www.bridge.com/pm/types";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"tempBlockingStatus", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"tempBlockingStatus");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("tempBlockingStatus");
                                    }
                                

                                          if (localTempBlockingStatus==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("tempBlockingStatus cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTempBlockingStatus);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "http://www.bridge.com/pm/types";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"organizationId", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"organizationId");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("organizationId");
                                    }
                                
                                               if (localOrganizationId==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("organizationId cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOrganizationId));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             
                                            if (localCardProfile==null){
                                                 throw new org.apache.axis2.databinding.ADBException("cardProfile cannot be null!!");
                                            }
                                           localCardProfile.serialize(new javax.xml.namespace.QName("http://www.bridge.com/pm/types","cardProfile"),
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

                
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "msisdn"));
                            
                            
                                    if (localMsisdn==null){
                                         throw new org.apache.axis2.databinding.ADBException("msisdn cannot be null!!");
                                    }
                                    elementList.add(localMsisdn);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "imsi"));
                                 
                                        if (localImsi != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImsi));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("imsi cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "sim"));
                                 
                                        if (localSim != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSim));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sim cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "businessPlan"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localBusinessPlan));
                            
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "sdp"));
                                 
                                         elementList.add(localSdp==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSdp));
                                    
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "masterSubscriberNumber"));
                            
                            
                                    if (localMasterSubscriberNumber==null){
                                         throw new org.apache.axis2.databinding.ADBException("masterSubscriberNumber cannot be null!!");
                                    }
                                    elementList.add(localMasterSubscriberNumber);
                                
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "tempBlockingStatus"));
                                 
                                        if (localTempBlockingStatus != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTempBlockingStatus));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("tempBlockingStatus cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "organizationId"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOrganizationId));
                            
                            elementList.add(new javax.xml.namespace.QName("http://www.bridge.com/pm/types",
                                                                      "cardProfile"));
                            
                            
                                    if (localCardProfile==null){
                                         throw new org.apache.axis2.databinding.ADBException("cardProfile cannot be null!!");
                                    }
                                    elementList.add(localCardProfile);
                                

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
        public static HlrInfoType parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            HlrInfoType object =
                new HlrInfoType();

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
                    
                            if (!"hlrInfoType".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (HlrInfoType)com.bridge.pm.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","msisdn").equals(reader.getName())){
                                
                                                object.setMsisdn(co.mcel.mz.types.common.MsisdnType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","imsi").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImsi(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","sim").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSim(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","businessPlan").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setBusinessPlan(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","sdp").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSdp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                            
                                       } else {
                                           
                                           
                                           reader.getElementText(); // throw away text nodes if any.
                                       }
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","masterSubscriberNumber").equals(reader.getName())){
                                
                                                object.setMasterSubscriberNumber(co.mcel.mz.types.common.MsisdnType.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","tempBlockingStatus").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTempBlockingStatus(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","organizationId").equals(reader.getName())){
                                
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOrganizationId(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://www.bridge.com/pm/types","cardProfile").equals(reader.getName())){
                                
                                                object.setCardProfile(com.bridge.pm.types.CardProfile.Factory.parse(reader));
                                              
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
           
          