/*
 * An XML document type.
 * Localname: getOrgAttribute
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgAttributeDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgAttribute(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgAttributeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgAttributeDocument
{
    
    public GetOrgAttributeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGATTRIBUTE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgAttribute");
    
    
    /**
     * Gets the "getOrgAttribute" element
     */
    public npa.ldap.ws.GetOrgAttribute getGetOrgAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttribute target = null;
            target = (npa.ldap.ws.GetOrgAttribute)get_store().find_element_user(GETORGATTRIBUTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgAttribute" element
     */
    public void setGetOrgAttribute(npa.ldap.ws.GetOrgAttribute getOrgAttribute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttribute target = null;
            target = (npa.ldap.ws.GetOrgAttribute)get_store().find_element_user(GETORGATTRIBUTE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgAttribute)get_store().add_element_user(GETORGATTRIBUTE$0);
            }
            target.set(getOrgAttribute);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgAttribute" element
     */
    public npa.ldap.ws.GetOrgAttribute addNewGetOrgAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttribute target = null;
            target = (npa.ldap.ws.GetOrgAttribute)get_store().add_element_user(GETORGATTRIBUTE$0);
            return target;
        }
    }
}
