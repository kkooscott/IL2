/*
 * XML Type:  getUserAttributes
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributes
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML getUserAttributes(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class GetUserAttributesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAttributes
{
    
    public GetUserAttributesImpl(org.apache.xmlbeans.SchemaType sType)
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
     * Gets array of all "arg1" elements
     */
    public java.lang.String[] getArg1Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ARG1$2, targetList);
            java.lang.String[] result = new java.lang.String[targetList.size()];
            for (int i = 0, len = targetList.size() ; i < len ; i++)
                result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
            return result;
        }
    }
    
    /**
     * Gets ith "arg1" element
     */
    public java.lang.String getArg1Array(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARG1$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) array of all "arg1" elements
     */
    public org.apache.xmlbeans.XmlString[] xgetArg1Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ARG1$2, targetList);
            org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets (as xml) ith "arg1" element
     */
    public org.apache.xmlbeans.XmlString xgetArg1Array(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARG1$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return (org.apache.xmlbeans.XmlString)target;
        }
    }
    
    /**
     * Returns number of "arg1" element
     */
    public int sizeOfArg1Array()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ARG1$2);
        }
    }
    
    /**
     * Sets array of all "arg1" element
     */
    public void setArg1Array(java.lang.String[] arg1Array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(arg1Array, ARG1$2);
        }
    }
    
    /**
     * Sets ith "arg1" element
     */
    public void setArg1Array(int i, java.lang.String arg1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(ARG1$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setStringValue(arg1);
        }
    }
    
    /**
     * Sets (as xml) array of all "arg1" element
     */
    public void xsetArg1Array(org.apache.xmlbeans.XmlString[]arg1Array)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(arg1Array, ARG1$2);
        }
    }
    
    /**
     * Sets (as xml) ith "arg1" element
     */
    public void xsetArg1Array(int i, org.apache.xmlbeans.XmlString arg1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(ARG1$2, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(arg1);
        }
    }
    
    /**
     * Inserts the value as the ith "arg1" element
     */
    public void insertArg1(int i, java.lang.String arg1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = 
                (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(ARG1$2, i);
            target.setStringValue(arg1);
        }
    }
    
    /**
     * Appends the value as the last "arg1" element
     */
    public void addArg1(java.lang.String arg1)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(ARG1$2);
            target.setStringValue(arg1);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "arg1" element
     */
    public org.apache.xmlbeans.XmlString insertNewArg1(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(ARG1$2, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "arg1" element
     */
    public org.apache.xmlbeans.XmlString addNewArg1()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(ARG1$2);
            return target;
        }
    }
    
    /**
     * Removes the ith "arg1" element
     */
    public void removeArg1(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ARG1$2, i);
        }
    }
}
