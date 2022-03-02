/*
 * XML Type:  getUserAttributes
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributes
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws;


/**
 * An XML getUserAttributes(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public interface GetUserAttributes extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetUserAttributes.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s45929A0F16157BF17C16833E0465E11D").resolveHandle("getuserattributes7906type");
    
    /**
     * Gets the "arg0" element
     */
    java.lang.String getArg0();
    
    /**
     * Gets (as xml) the "arg0" element
     */
    org.apache.xmlbeans.XmlString xgetArg0();
    
    /**
     * True if has "arg0" element
     */
    boolean isSetArg0();
    
    /**
     * Sets the "arg0" element
     */
    void setArg0(java.lang.String arg0);
    
    /**
     * Sets (as xml) the "arg0" element
     */
    void xsetArg0(org.apache.xmlbeans.XmlString arg0);
    
    /**
     * Unsets the "arg0" element
     */
    void unsetArg0();
    
    /**
     * Gets array of all "arg1" elements
     */
    java.lang.String[] getArg1Array();
    
    /**
     * Gets ith "arg1" element
     */
    java.lang.String getArg1Array(int i);
    
    /**
     * Gets (as xml) array of all "arg1" elements
     */
    org.apache.xmlbeans.XmlString[] xgetArg1Array();
    
    /**
     * Gets (as xml) ith "arg1" element
     */
    org.apache.xmlbeans.XmlString xgetArg1Array(int i);
    
    /**
     * Returns number of "arg1" element
     */
    int sizeOfArg1Array();
    
    /**
     * Sets array of all "arg1" element
     */
    void setArg1Array(java.lang.String[] arg1Array);
    
    /**
     * Sets ith "arg1" element
     */
    void setArg1Array(int i, java.lang.String arg1);
    
    /**
     * Sets (as xml) array of all "arg1" element
     */
    void xsetArg1Array(org.apache.xmlbeans.XmlString[] arg1Array);
    
    /**
     * Sets (as xml) ith "arg1" element
     */
    void xsetArg1Array(int i, org.apache.xmlbeans.XmlString arg1);
    
    /**
     * Inserts the value as the ith "arg1" element
     */
    void insertArg1(int i, java.lang.String arg1);
    
    /**
     * Appends the value as the last "arg1" element
     */
    void addArg1(java.lang.String arg1);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "arg1" element
     */
    org.apache.xmlbeans.XmlString insertNewArg1(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "arg1" element
     */
    org.apache.xmlbeans.XmlString addNewArg1();
    
    /**
     * Removes the ith "arg1" element
     */
    void removeArg1(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static npa.ldap.ws.GetUserAttributes newInstance() {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static npa.ldap.ws.GetUserAttributes parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static npa.ldap.ws.GetUserAttributes parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributes parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.GetUserAttributes parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.GetUserAttributes parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.GetUserAttributes) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
