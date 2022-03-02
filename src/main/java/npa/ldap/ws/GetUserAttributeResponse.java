/*
 * XML Type:  getUserAttributeResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributeResponse
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws;


/**
 * An XML getUserAttributeResponse(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public interface GetUserAttributeResponse extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(GetUserAttributeResponse.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s45929A0F16157BF17C16833E0465E11D").resolveHandle("getuserattributeresponse6cfctype");
    
    /**
     * Gets the "return" element
     */
    npa.ldap.ws.Attr getReturn();
    
    /**
     * True if has "return" element
     */
    boolean isSetReturn();
    
    /**
     * Sets the "return" element
     */
    void setReturn(npa.ldap.ws.Attr xreturn);
    
    /**
     * Appends and returns a new empty "return" element
     */
    npa.ldap.ws.Attr addNewReturn();
    
    /**
     * Unsets the "return" element
     */
    void unsetReturn();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static npa.ldap.ws.GetUserAttributeResponse newInstance() {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static npa.ldap.ws.GetUserAttributeResponse parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.GetUserAttributeResponse parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.GetUserAttributeResponse parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.GetUserAttributeResponse) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
