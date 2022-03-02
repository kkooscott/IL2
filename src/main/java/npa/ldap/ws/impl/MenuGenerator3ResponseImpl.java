/*
 * XML Type:  menuGenerator3Response
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.MenuGenerator3Response
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML menuGenerator3Response(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class MenuGenerator3ResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.MenuGenerator3Response
{
    
    public MenuGenerator3ResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RETURN$0 = 
        new javax.xml.namespace.QName("", "return");
    
    
    /**
     * Gets array of all "return" elements
     */
    public npa.ldap.ws.AttrSet[] getReturnArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(RETURN$0, targetList);
            npa.ldap.ws.AttrSet[] result = new npa.ldap.ws.AttrSet[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "return" element
     */
    public npa.ldap.ws.AttrSet getReturnArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.AttrSet target = null;
            target = (npa.ldap.ws.AttrSet)get_store().find_element_user(RETURN$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "return" element
     */
    public int sizeOfReturnArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(RETURN$0);
        }
    }
    
    /**
     * Sets array of all "return" element
     */
    public void setReturnArray(npa.ldap.ws.AttrSet[] xreturnArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(xreturnArray, RETURN$0);
        }
    }
    
    /**
     * Sets ith "return" element
     */
    public void setReturnArray(int i, npa.ldap.ws.AttrSet xreturn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.AttrSet target = null;
            target = (npa.ldap.ws.AttrSet)get_store().find_element_user(RETURN$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(xreturn);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "return" element
     */
    public npa.ldap.ws.AttrSet insertNewReturn(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.AttrSet target = null;
            target = (npa.ldap.ws.AttrSet)get_store().insert_element_user(RETURN$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "return" element
     */
    public npa.ldap.ws.AttrSet addNewReturn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.AttrSet target = null;
            target = (npa.ldap.ws.AttrSet)get_store().add_element_user(RETURN$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "return" element
     */
    public void removeReturn(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(RETURN$0, i);
        }
    }
}
