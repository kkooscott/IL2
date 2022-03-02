/*
 * XML Type:  getOrgAttributesResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgAttributesResponse
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * An XML getOrgAttributesResponse(@http://ws.ldap.npa/).
 *
 * This is a complex type.
 */
public class GetOrgAttributesResponseImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgAttributesResponse
{
    
    public GetOrgAttributesResponseImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName RETURN$0 = 
        new javax.xml.namespace.QName("", "return");
    
    
    /**
     * Gets the "return" element
     */
    public npa.ldap.ws.AttrSet getReturn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.AttrSet target = null;
            target = (npa.ldap.ws.AttrSet)get_store().find_element_user(RETURN$0, 0);
            if (target == null)
            {
                return null;
            }
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
    public void setReturn(npa.ldap.ws.AttrSet xreturn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.AttrSet target = null;
            target = (npa.ldap.ws.AttrSet)get_store().find_element_user(RETURN$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.AttrSet)get_store().add_element_user(RETURN$0);
            }
            target.set(xreturn);
        }
    }
    
    /**
     * Appends and returns a new empty "return" element
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
