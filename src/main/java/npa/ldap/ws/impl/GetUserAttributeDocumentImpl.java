/*
 * An XML document type.
 * Localname: getUserAttribute
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributeDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserAttribute(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserAttributeDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAttributeDocument
{
    
    public GetUserAttributeDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERATTRIBUTE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserAttribute");
    
    
    /**
     * Gets the "getUserAttribute" element
     */
    public npa.ldap.ws.GetUserAttribute getGetUserAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttribute target = null;
            target = (npa.ldap.ws.GetUserAttribute)get_store().find_element_user(GETUSERATTRIBUTE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserAttribute" element
     */
    public void setGetUserAttribute(npa.ldap.ws.GetUserAttribute getUserAttribute)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttribute target = null;
            target = (npa.ldap.ws.GetUserAttribute)get_store().find_element_user(GETUSERATTRIBUTE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserAttribute)get_store().add_element_user(GETUSERATTRIBUTE$0);
            }
            target.set(getUserAttribute);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserAttribute" element
     */
    public npa.ldap.ws.GetUserAttribute addNewGetUserAttribute()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttribute target = null;
            target = (npa.ldap.ws.GetUserAttribute)get_store().add_element_user(GETUSERATTRIBUTE$0);
            return target;
        }
    }
}
