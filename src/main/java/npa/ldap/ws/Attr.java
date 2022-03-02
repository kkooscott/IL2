/*
 * XML Type:  attr
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.Attr
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws;


/**
 * An XML attr(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public interface Attr extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Attr.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s45929A0F16157BF17C16833E0465E11D").resolveHandle("attrcc31type");
    
    /**
     * Gets the "name" element
     */
    java.lang.String getName();
    
    /**
     * Gets (as xml) the "name" element
     */
    org.apache.xmlbeans.XmlString xgetName();
    
    /**
     * True if has "name" element
     */
    boolean isSetName();
    
    /**
     * Sets the "name" element
     */
    void setName(java.lang.String name);
    
    /**
     * Sets (as xml) the "name" element
     */
    void xsetName(org.apache.xmlbeans.XmlString name);
    
    /**
     * Unsets the "name" element
     */
    void unsetName();
    
    /**
     * Gets array of all "values" elements
     */
    java.lang.String[] getValuesArray();
    
    /**
     * Gets ith "values" element
     */
    java.lang.String getValuesArray(int i);
    
    /**
     * Gets (as xml) array of all "values" elements
     */
    org.apache.xmlbeans.XmlString[] xgetValuesArray();
    
    /**
     * Gets (as xml) ith "values" element
     */
    org.apache.xmlbeans.XmlString xgetValuesArray(int i);
    
    /**
     * Tests for nil ith "values" element
     */
    boolean isNilValuesArray(int i);
    
    /**
     * Returns number of "values" element
     */
    int sizeOfValuesArray();
    
    /**
     * Sets array of all "values" element
     */
    void setValuesArray(java.lang.String[] valuesArray);
    
    /**
     * Sets ith "values" element
     */
    void setValuesArray(int i, java.lang.String values);
    
    /**
     * Sets (as xml) array of all "values" element
     */
    void xsetValuesArray(org.apache.xmlbeans.XmlString[] valuesArray);
    
    /**
     * Sets (as xml) ith "values" element
     */
    void xsetValuesArray(int i, org.apache.xmlbeans.XmlString values);
    
    /**
     * Nils the ith "values" element
     */
    void setNilValuesArray(int i);
    
    /**
     * Inserts the value as the ith "values" element
     */
    void insertValues(int i, java.lang.String values);
    
    /**
     * Appends the value as the last "values" element
     */
    void addValues(java.lang.String values);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "values" element
     */
    org.apache.xmlbeans.XmlString insertNewValues(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "values" element
     */
    org.apache.xmlbeans.XmlString addNewValues();
    
    /**
     * Removes the ith "values" element
     */
    void removeValues(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static npa.ldap.ws.Attr newInstance() {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static npa.ldap.ws.Attr newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static npa.ldap.ws.Attr parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static npa.ldap.ws.Attr parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static npa.ldap.ws.Attr parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static npa.ldap.ws.Attr parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static npa.ldap.ws.Attr parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static npa.ldap.ws.Attr parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static npa.ldap.ws.Attr parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static npa.ldap.ws.Attr parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static npa.ldap.ws.Attr parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static npa.ldap.ws.Attr parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static npa.ldap.ws.Attr parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static npa.ldap.ws.Attr parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static npa.ldap.ws.Attr parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static npa.ldap.ws.Attr parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.Attr parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static npa.ldap.ws.Attr parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (npa.ldap.ws.Attr) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
