/*
 * XML Type:  attrArray
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.AttrArray
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML attrArray(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class AttrArrayImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.AttrArray
{
    
    public AttrArrayImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ITEM$0 = 
        new javax.xml.namespace.QName("", "item");
    
    
    /**
     * Gets array of all "item" elements
     */
    public npa.ldap.ws.Attr[] getItemArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(ITEM$0, targetList);
            npa.ldap.ws.Attr[] result = new npa.ldap.ws.Attr[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "item" element
     */
    public npa.ldap.ws.Attr getItemArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ITEM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Tests for nil ith "item" element
     */
    public boolean isNilItemArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ITEM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target.isNil();
        }
    }
    
    /**
     * Returns number of "item" element
     */
    public int sizeOfItemArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(ITEM$0);
        }
    }
    
    /**
     * Sets array of all "item" element
     */
    public void setItemArray(npa.ldap.ws.Attr[] itemArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(itemArray, ITEM$0);
        }
    }
    
    /**
     * Sets ith "item" element
     */
    public void setItemArray(int i, npa.ldap.ws.Attr item)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ITEM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(item);
        }
    }
    
    /**
     * Nils the ith "item" element
     */
    public void setNilItemArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().find_element_user(ITEM$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.setNil();
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "item" element
     */
    public npa.ldap.ws.Attr insertNewItem(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().insert_element_user(ITEM$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "item" element
     */
    public npa.ldap.ws.Attr addNewItem()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.Attr target = null;
            target = (npa.ldap.ws.Attr)get_store().add_element_user(ITEM$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "item" element
     */
    public void removeItem(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(ITEM$0, i);
        }
    }
}
