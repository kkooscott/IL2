/*
 * XML Type:  getAPPMembersResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetAPPMembersResponse
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws;


/**
 * An XML getAPPMembersResponse(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public interface GetAPPMembersResponse extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetAPPMembersResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s45929A0F16157BF17C16833E0465E11D").resolveHandle("getappmembersresponsead9dtype");
    
    /**
     * Gets array of all "return" elements
     */
    java.lang.String[] getReturnArray();
    
    /**
     * Gets ith "return" element
     */
    java.lang.String getReturnArray(int i);
    
    /**
     * Gets (as xml) array of all "return" elements
     */
    org.apache.xmlbeans.XmlString[] xgetReturnArray();
    
    /**
     * Gets (as xml) ith "return" element
     */
    org.apache.xmlbeans.XmlString xgetReturnArray(int i);
    
    /**
     * Returns number of "return" element
     */
    int sizeOfReturnArray();
    
    /**
     * Sets array of all "return" element
     */
    void setReturnArray(java.lang.String[] xreturnArray);
    
    /**
     * Sets ith "return" element
     */
    void setReturnArray(int i, java.lang.String xreturn);
    
    /**
     * Sets (as xml) array of all "return" element
     */
    void xsetReturnArray(org.apache.xmlbeans.XmlString[] xreturnArray);
    
    /**
     * Sets (as xml) ith "return" element
     */
    void xsetReturnArray(int i, org.apache.xmlbeans.XmlString xreturn);
    
    /**
     * Inserts the value as the ith "return" element
     */
    void insertReturn(int i, java.lang.String xreturn);
    
    /**
     * Appends the value as the last "return" element
     */
    void addReturn(java.lang.String xreturn);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "return" element
     */
    org.apache.xmlbeans.XmlString insertNewReturn(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "return" element
     */
    org.apache.xmlbeans.XmlString addNewReturn();
    
    /**
     * Removes the ith "return" element
     */
    void removeReturn(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static npa.ldap.ws.GetAPPMembersResponse newInstance() {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static npa.ldap.ws.GetAPPMembersResponse parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.GetAPPMembersResponse parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.GetAPPMembersResponse parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.GetAPPMembersResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
