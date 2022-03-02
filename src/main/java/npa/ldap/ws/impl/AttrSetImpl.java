/*
 * XML Type:  attrSet
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.AttrSet
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML attrSet(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class AttrSetImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.AttrSet
{
    
    public AttrSetImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ATTRIBUTES$0 = 
        new javax.xml.namespace.QName("", "attributes");
    private static final javax.xml.namespace.QName DN$2 = 
        new javax.xml.namespace.QName("", "dn");
    
    
    /**
     * Gets array of all "attributes" elements
     */
    public npa.ldap.ws.Attr[] getAttributesArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ATTRIBUTES$0, targetList);
            npa.ldap.ws.Attr[] result = new npa.ldap.ws.Attr[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "attributes" element
     */
    public npa.ldap.ws.Attr getAttributesArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ATTRIBUTES$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "attributes" element
     */
    public boolean isNilAttributesArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ATTRIBUTES$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "attributes" element
     */
    public int sizeOfAttributesArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ATTRIBUTES$0);
        }
    }
    
    /**
     * Sets array of all "attributes" element
     */
    public void setAttributesArray(npa.ldap.ws.Attr[] attributesArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(attributesArray, ATTRIBUTES$0);
        }
    }
    
    /**
     * Sets ith "attributes" element
     */
    public void setAttributesArray(int i, npa.ldap.ws.Attr attributes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ATTRIBUTES$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(attributes);
        }
    }
    
    /**
     * Nils the ith "attributes" element
     */
    public void setNilAttributesArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ATTRIBUTES$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "attributes" element
     */
    public npa.ldap.ws.Attr insertNewAttributes(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().insert_element_user(ATTRIBUTES$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "attributes" element
     */
    public npa.ldap.ws.Attr addNewAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().add_element_user(ATTRIBUTES$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "attributes" element
     */
    public void removeAttributes(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ATTRIBUTES$0, i);
        }
    }
    
    /**
     * Gets the "dn" element
     */
    public java.lang.String getDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DN$2, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "dn" element
     */
    public org.apache.xmlbeans.XmlString xgetDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DN$2, 0);
            return target;
        }
    }
    
    /**
     * True if has "dn" element
     */
    public boolean isSetDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(DN$2) != 0;
        }
    }
    
    /**
     * Sets the "dn" element
     */
    public void setDn(java.lang.String dn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DN$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DN$2);
            }
            target.setStringValue(dn);
        }
    }
    
    /**
     * Sets (as xml) the "dn" element
     */
    public void xsetDn(org.apache.xmlbeans.XmlString dn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DN$2, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DN$2);
            }
            target.set(dn);
        }
    }
    
    /**
     * Unsets the "dn" element
     */
    public void unsetDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(DN$2, 0);
        }
    }
}
