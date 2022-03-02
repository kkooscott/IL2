/*
 * XML Type:  getUserAPPs
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAPPs
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML getUserAPPs(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class GetUserAPPsImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAPPs
{
    
    public GetUserAPPsImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARG0$0 = 
        new javax.xml.namespace.QName("", "arg0");
    
    
    /**
     * Gets the "arg0" element
     */
    public java.lang.String getArg0()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARG0$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "arg0" element
     */
    public org.apache.xmlbeans.XmlString xgetArg0()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARG0$0, 0);
            return target;
        }
    }
    
    /**
     * True if has "arg0" element
     */
    public boolean isSetArg0()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARG0$0) != 0;
        }
    }
    
    /**
     * Sets the "arg0" element
     */
    public void setArg0(java.lang.String arg0)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARG0$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARG0$0);
            }
            target.setStringValue(arg0);
        }
    }
    
    /**
     * Sets (as xml) the "arg0" element
     */
    public void xsetArg0(org.apache.xmlbeans.XmlString arg0)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARG0$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ARG0$0);
            }
            target.set(arg0);
        }
    }
    
    /**
     * Unsets the "arg0" element
     */
    public void unsetArg0()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARG0$0, 0);
        }
    }
}
