
/**
 * ProvisionReplyEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:34 EDT)
 */
            
                package com.rim.blackberry.provision.control.ari.comm.soap;
            

            /**
            *  ProvisionReplyEntity bean class
            */
        
        public  class ProvisionReplyEntity
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ProvisionReplyEntity
                Namespace URI = java:provision.control.ari.comm.soap
                Namespace Prefix = ns1
                */
            

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("java:provision.control.ari.comm.soap")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        

                        /**
                        * field for Name
                        */

                        
                                    protected java.lang.String localName ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getName(){
                               return localName;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Name
                               */
                               public void setName(java.lang.String param){
                            
                                            this.localName=param;
                                    

                               }
                            

                        /**
                        * field for Type
                        */

                        
                                    protected java.lang.String localType ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getType(){
                               return localType;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Type
                               */
                               public void setType(java.lang.String param){
                            
                                            this.localType=param;
                                    

                               }
                            

                        /**
                        * field for OptionalTokens
                        * This was an Array!
                        */

                        
                                    protected com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[] localOptionalTokens ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOptionalTokensTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[]
                           */
                           public  com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[] getOptionalTokens(){
                               return localOptionalTokens;
                           }

                           
                        


                               
                              /**
                               * validate the array for OptionalTokens
                               */
                              protected void validateOptionalTokens(com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param OptionalTokens
                              */
                              public void setOptionalTokens(com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[] param){
                              
                                   validateOptionalTokens(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localOptionalTokensTracker = true;
                                          } else {
                                             localOptionalTokensTracker = true;
                                                 
                                          }
                                      
                                      this.localOptionalTokens=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken
                             */
                             public void addOptionalTokens(com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken param){
                                   if (localOptionalTokens == null){
                                   localOptionalTokens = new com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[]{};
                                   }

                            
                                 //update the setting tracker
                                localOptionalTokensTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localOptionalTokens);
                               list.add(param);
                               this.localOptionalTokens =
                             (com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[])list.toArray(
                            new com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[list.size()]);

                             }
                             

                        /**
                        * field for SubEntities
                        * This was an Array!
                        */

                        
                                    protected com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[] localSubEntities ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSubEntitiesTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[]
                           */
                           public  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[] getSubEntities(){
                               return localSubEntities;
                           }

                           
                        


                               
                              /**
                               * validate the array for SubEntities
                               */
                              protected void validateSubEntities(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param SubEntities
                              */
                              public void setSubEntities(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[] param){
                              
                                   validateSubEntities(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localSubEntitiesTracker = true;
                                          } else {
                                             localSubEntitiesTracker = true;
                                                 
                                          }
                                      
                                      this.localSubEntities=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity
                             */
                             public void addSubEntities(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity param){
                                   if (localSubEntities == null){
                                   localSubEntities = new com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[]{};
                                   }

                            
                                 //update the setting tracker
                                localSubEntitiesTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localSubEntities);
                               list.add(param);
                               this.localSubEntities =
                             (com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[])list.toArray(
                            new com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[list.size()]);

                             }
                             

                        /**
                        * field for ResultCode
                        */

                        
                                    protected com.rim.blackberry.provision.control.ari.comm.soap.TransactionCode localResultCode ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.rim.blackberry.provision.control.ari.comm.soap.TransactionCode
                           */
                           public  com.rim.blackberry.provision.control.ari.comm.soap.TransactionCode getResultCode(){
                               return localResultCode;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ResultCode
                               */
                               public void setResultCode(com.rim.blackberry.provision.control.ari.comm.soap.TransactionCode param){
                            
                                            this.localResultCode=param;
                                    

                               }
                            

                        /**
                        * field for Items
                        * This was an Array!
                        */

                        
                                    protected com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[] localItems ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localItemsTracker = false ;
                           

                           /**
                           * Auto generated getter method
                           * @return com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[]
                           */
                           public  com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[] getItems(){
                               return localItems;
                           }

                           
                        


                               
                              /**
                               * validate the array for Items
                               */
                              protected void validateItems(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Items
                              */
                              public void setItems(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[] param){
                              
                                   validateItems(param);

                               
                                          if (param != null){
                                             //update the setting tracker
                                             localItemsTracker = true;
                                          } else {
                                             localItemsTracker = true;
                                                 
                                          }
                                      
                                      this.localItems=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem
                             */
                             public void addItems(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem param){
                                   if (localItems == null){
                                   localItems = new com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[]{};
                                   }

                            
                                 //update the setting tracker
                                localItemsTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localItems);
                               list.add(param);
                               this.localItems =
                             (com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[])list.toArray(
                            new com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[list.size()]);

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
                       ProvisionReplyEntity.this.serialize(parentQName,factory,xmlWriter);
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
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"java:provision.control.ari.comm.soap");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":ProvisionReplyEntity",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ProvisionReplyEntity",
                           xmlWriter);
                   }

               
                   }
               
                                    namespace = "java:provision.control.ari.comm.soap";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Name", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Name");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Name");
                                    }
                                

                                          if (localName==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localName);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "java:provision.control.ari.comm.soap";
                                    if (! namespace.equals("")) {
                                        prefix = xmlWriter.getPrefix(namespace);

                                        if (prefix == null) {
                                            prefix = generatePrefix(namespace);

                                            xmlWriter.writeStartElement(prefix,"Type", namespace);
                                            xmlWriter.writeNamespace(prefix, namespace);
                                            xmlWriter.setPrefix(prefix, namespace);

                                        } else {
                                            xmlWriter.writeStartElement(namespace,"Type");
                                        }

                                    } else {
                                        xmlWriter.writeStartElement("Type");
                                    }
                                

                                          if (localType==null){
                                              // write the nil attribute
                                              
                                                     writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localType);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localOptionalTokensTracker){
                                       if (localOptionalTokens!=null){
                                            for (int i = 0;i < localOptionalTokens.length;i++){
                                                if (localOptionalTokens[i] != null){
                                                 localOptionalTokens[i].serialize(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","OptionalTokens"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                            // write null attribute
                                                            java.lang.String namespace2 = "java:provision.control.ari.comm.soap";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"OptionalTokens", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"OptionalTokens");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("OptionalTokens");
                                                            }

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                // write null attribute
                                                java.lang.String namespace2 = "java:provision.control.ari.comm.soap";
                                                if (! namespace2.equals("")) {
                                                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                    if (prefix2 == null) {
                                                        prefix2 = generatePrefix(namespace2);

                                                        xmlWriter.writeStartElement(prefix2,"OptionalTokens", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"OptionalTokens");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("OptionalTokens");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 } if (localSubEntitiesTracker){
                                       if (localSubEntities!=null){
                                            for (int i = 0;i < localSubEntities.length;i++){
                                                if (localSubEntities[i] != null){
                                                 localSubEntities[i].serialize(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","SubEntities"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                            // write null attribute
                                                            java.lang.String namespace2 = "java:provision.control.ari.comm.soap";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"SubEntities", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"SubEntities");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("SubEntities");
                                                            }

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                // write null attribute
                                                java.lang.String namespace2 = "java:provision.control.ari.comm.soap";
                                                if (! namespace2.equals("")) {
                                                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                    if (prefix2 == null) {
                                                        prefix2 = generatePrefix(namespace2);

                                                        xmlWriter.writeStartElement(prefix2,"SubEntities", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"SubEntities");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("SubEntities");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 }
                                    if (localResultCode==null){

                                            java.lang.String namespace2 = "java:provision.control.ari.comm.soap";

                                        if (! namespace2.equals("")) {
                                            java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                            if (prefix2 == null) {
                                                prefix2 = generatePrefix(namespace2);

                                                xmlWriter.writeStartElement(prefix2,"ResultCode", namespace2);
                                                xmlWriter.writeNamespace(prefix2, namespace2);
                                                xmlWriter.setPrefix(prefix2, namespace2);

                                            } else {
                                                xmlWriter.writeStartElement(namespace2,"ResultCode");
                                            }

                                        } else {
                                            xmlWriter.writeStartElement("ResultCode");
                                        }


                                       // write the nil attribute
                                      writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                      xmlWriter.writeEndElement();
                                    }else{
                                     localResultCode.serialize(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","ResultCode"),
                                        factory,xmlWriter);
                                    }
                                 if (localItemsTracker){
                                       if (localItems!=null){
                                            for (int i = 0;i < localItems.length;i++){
                                                if (localItems[i] != null){
                                                 localItems[i].serialize(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","Items"),
                                                           factory,xmlWriter);
                                                } else {
                                                   
                                                            // write null attribute
                                                            java.lang.String namespace2 = "java:provision.control.ari.comm.soap";
                                                            if (! namespace2.equals("")) {
                                                                java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                                if (prefix2 == null) {
                                                                    prefix2 = generatePrefix(namespace2);

                                                                    xmlWriter.writeStartElement(prefix2,"Items", namespace2);
                                                                    xmlWriter.writeNamespace(prefix2, namespace2);
                                                                    xmlWriter.setPrefix(prefix2, namespace2);

                                                                } else {
                                                                    xmlWriter.writeStartElement(namespace2,"Items");
                                                                }

                                                            } else {
                                                                xmlWriter.writeStartElement("Items");
                                                            }

                                                           // write the nil attribute
                                                           writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                                           xmlWriter.writeEndElement();
                                                    
                                                }

                                            }
                                     } else {
                                        
                                                // write null attribute
                                                java.lang.String namespace2 = "java:provision.control.ari.comm.soap";
                                                if (! namespace2.equals("")) {
                                                    java.lang.String prefix2 = xmlWriter.getPrefix(namespace2);

                                                    if (prefix2 == null) {
                                                        prefix2 = generatePrefix(namespace2);

                                                        xmlWriter.writeStartElement(prefix2,"Items", namespace2);
                                                        xmlWriter.writeNamespace(prefix2, namespace2);
                                                        xmlWriter.setPrefix(prefix2, namespace2);

                                                    } else {
                                                        xmlWriter.writeStartElement(namespace2,"Items");
                                                    }

                                                } else {
                                                    xmlWriter.writeStartElement("Items");
                                                }

                                               // write the nil attribute
                                               writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","nil","1",xmlWriter);
                                               xmlWriter.writeEndElement();
                                        
                                    }
                                 }
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

                
                                      elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                      "Name"));
                                 
                                         elementList.add(localName==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localName));
                                    
                                      elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                      "Type"));
                                 
                                         elementList.add(localType==null?null:
                                         org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localType));
                                     if (localOptionalTokensTracker){
                             if (localOptionalTokens!=null) {
                                 for (int i = 0;i < localOptionalTokens.length;i++){

                                    if (localOptionalTokens[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "OptionalTokens"));
                                         elementList.add(localOptionalTokens[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "OptionalTokens"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "OptionalTokens"));
                                        elementList.add(localOptionalTokens);
                                    
                             }

                        } if (localSubEntitiesTracker){
                             if (localSubEntities!=null) {
                                 for (int i = 0;i < localSubEntities.length;i++){

                                    if (localSubEntities[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "SubEntities"));
                                         elementList.add(localSubEntities[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "SubEntities"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "SubEntities"));
                                        elementList.add(localSubEntities);
                                    
                             }

                        }
                            elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                      "ResultCode"));
                            
                            
                                    elementList.add(localResultCode==null?null:
                                    localResultCode);
                                 if (localItemsTracker){
                             if (localItems!=null) {
                                 for (int i = 0;i < localItems.length;i++){

                                    if (localItems[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "Items"));
                                         elementList.add(localItems[i]);
                                    } else {
                                        
                                                elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "Items"));
                                                elementList.add(null);
                                            
                                    }

                                 }
                             } else {
                                 
                                        elementList.add(new javax.xml.namespace.QName("java:provision.control.ari.comm.soap",
                                                                          "Items"));
                                        elementList.add(localItems);
                                    
                             }

                        }

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
        public static ProvisionReplyEntity parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ProvisionReplyEntity object =
                new ProvisionReplyEntity();

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
                    
                            if (!"ProvisionReplyEntity".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ProvisionReplyEntity)com.rim.blackberry.provision.control.ari.comm.soap.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                 
                    
                    reader.next();
                
                        java.util.ArrayList list3 = new java.util.ArrayList();
                    
                        java.util.ArrayList list4 = new java.util.ArrayList();
                    
                        java.util.ArrayList list6 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","Name").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setName(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","Type").equals(reader.getName())){
                                
                                       nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                       if (!"true".equals(nillableValue) && !"1".equals(nillableValue)){
                                    
                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setType(
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","OptionalTokens").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list3.add(null);
                                                              reader.next();
                                                          } else {
                                                        list3.add(com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone3 = false;
                                                        while(!loopDone3){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone3 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","OptionalTokens").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list3.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list3.add(com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone3 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setOptionalTokens((com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.rim.blackberry.provision.control.ari.comm.soap.ReservedToken.class,
                                                                list3));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","SubEntities").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list4.add(null);
                                                              reader.next();
                                                          } else {
                                                        list4.add(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone4 = false;
                                                        while(!loopDone4){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone4 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","SubEntities").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list4.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list4.add(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone4 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setSubEntities((com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.rim.blackberry.provision.control.ari.comm.soap.ProvisionReplyEntity.class,
                                                                list4));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","ResultCode").equals(reader.getName())){
                                
                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                          object.setResultCode(null);
                                          reader.next();
                                            
                                            reader.next();
                                          
                                      }else{
                                    
                                                object.setResultCode(com.rim.blackberry.provision.control.ari.comm.soap.TransactionCode.Factory.parse(reader));
                                              
                                        reader.next();
                                    }
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getLocalName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","Items").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    
                                                          nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                          if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                              list6.add(null);
                                                              reader.next();
                                                          } else {
                                                        list6.add(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem.Factory.parse(reader));
                                                                }
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone6 = false;
                                                        while(!loopDone6){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone6 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("java:provision.control.ari.comm.soap","Items").equals(reader.getName())){
                                                                    
                                                                      nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                                                      if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                                                          list6.add(null);
                                                                          reader.next();
                                                                      } else {
                                                                    list6.add(com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem.Factory.parse(reader));
                                                                        }
                                                                }else{
                                                                    loopDone6 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setItems((com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.rim.blackberry.provision.control.ari.comm.soap.ProvisionDataItem.class,
                                                                list6));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
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
           
          