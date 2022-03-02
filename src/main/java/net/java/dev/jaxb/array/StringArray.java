/*
 * XML Type:  stringArray
 * Namespace: http://jaxb.dev.java.net/array
 * Java type: net.java.dev.jaxb.array.StringArray
 *
 * Automatically generated - do not modify.
 */
package net.java.dev.jaxb.array;


/**
 * An XML stringArray(@http://jaxb.dev.java.net/array).
 *
 * This is a complex type.
 */
public interface StringArray extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(StringArray.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s45929A0F16157BF17C16833E0465E11D").resolveHandle("stringarraye590type");
    
    /**
     * Gets array of all "item" elements
     */
    java.lang.String[] getItemArray();
    
    /**
     * Gets ith "item" element
     */
    java.lang.String getItemArray(int i);
    
    /**
     * Gets (as xml) array of all "item" elements
     */
    org.apache.xmlbeans.XmlString[] xgetItemArray();
    
    /**
     * Gets (as xml) ith "item" element
     */
    org.apache.xmlbeans.XmlString xgetItemArray(int i);
    
    /**
     * Tests for nil ith "item" element
     */
    boolean isNilItemArray(int i);
    
    /**
     * Returns number of "item" element
     */
    int sizeOfItemArray();
    
    /**
     * Sets array of all "item" element
     */
    void setItemArray(java.lang.String[] itemArray);
    
    /**
     * Sets ith "item" element
     */
    void setItemArray(int i, java.lang.String item);
    
    /**
     * Sets (as xml) array of all "item" element
     */
    void xsetItemArray(org.apache.xmlbeans.XmlString[] itemArray);
    
    /**
     * Sets (as xml) ith "item" element
     */
    void xsetItemArray(int i, org.apache.xmlbeans.XmlString item);
    
    /**
     * Nils the ith "item" element
     */
    void setNilItemArray(int i);
    
    /**
     * Inserts the value as the ith "item" element
     */
    void insertItem(int i, java.lang.String item);
    
    /**
     * Appends the value as the last "item" element
     */
    void addItem(java.lang.String item);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "item" element
     */
    org.apache.xmlbeans.XmlString insertNewItem(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "item" element
     */
    org.apache.xmlbeans.XmlString addNewItem();
    
    /**
     * Removes the ith "item" element
     */
    void removeItem(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static net.java.dev.jaxb.array.StringArray newInstance() {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static net.java.dev.jaxb.array.StringArray parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static net.java.dev.jaxb.array.StringArray parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static net.java.dev.jaxb.array.StringArray parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.java.dev.jaxb.array.StringArray parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static net.java.dev.jaxb.array.StringArray parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (net.java.dev.jaxb.array.StringArray) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
