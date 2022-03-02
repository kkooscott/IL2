/*
 * XML Type:  getOrgAttribute
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgAttribute
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML getOrgAttribute(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class GetOrgAttributeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgAttribute
{
    
    public GetOrgAttributeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ARG0$0 = 
        new javax.xml.namespace.QName("", "arg0");
    private static final javax.xml.namespace.QName ARG1$2 = 
        new javax.xml.namespace.QName("", "arg1");
    
    
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
    
    /**
     * Gets the "arg1" element
     */
    public java.lang.String getArg1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARG1$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "arg1" element
     */
    public org.apache.xmlbeans.XmlString xgetArg1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARG1$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "arg1" element
     */
    public boolean isSetArg1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARG1$2) != 0;
        }
    }
    
    /**
     * Sets the "arg1" element
     */
    public void setArg1(java.lang.String arg1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARG1$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARG1$2);
            }
            target.setStringValue(arg1);
        }
    }
    
    /**
     * Sets (as xml) the "arg1" element
     */
    public void xsetArg1(org.apache.xmlbeans.XmlString arg1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARG1$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ARG1$2);
            }
            target.set(arg1);
        }
    }
    
    /**
     * Unsets the "arg1" element
     */
    public void unsetArg1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARG1$2, 0);
        }
    }
}
