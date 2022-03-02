/*
 * XML Type:  getOrgDotDnResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgDotDnResponse
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML getOrgDotDnResponse(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class GetOrgDotDnResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgDotDnResponse
{
    
    public GetOrgDotDnResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RETURN$0 = 
        new javax.xml.namespace.QName("", "return");
    
    
    /**
     * Gets the "return" element
     */
    public java.lang.String getReturn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "return" element
     */
    public org.apache.xmlbeans.XmlString xgetReturn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RETURN$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "return" element
     */
    public boolean isSetReturn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RETURN$0) != 0;
        }
    }
    
    /**
     * Sets the "return" element
     */
    public void setReturn(java.lang.String xreturn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(RETURN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(RETURN$0);
            }
            target.setStringValue(xreturn);
        }
    }
    
    /**
     * Sets (as xml) the "return" element
     */
    public void xsetReturn(org.apache.xmlbeans.XmlString xreturn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(RETURN$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(RETURN$0);
            }
            target.set(xreturn);
        }
    }
    
    /**
     * Unsets the "return" element
     */
    public void unsetReturn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RETURN$0, 0);
        }
    }
}
