/*
 * An XML document type.
 * Localname: getUserAttributes
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserAttributes(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAttributesDocument
{
    
    public GetUserAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserAttributes");
    
    
    /**
     * Gets the "getUserAttributes" element
     */
    public npa.ldap.ws.GetUserAttributes getGetUserAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributes target = null;
            target = (npa.ldap.ws.GetUserAttributes)get_store().find_element_user(GETUSERATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserAttributes" element
     */
    public void setGetUserAttributes(npa.ldap.ws.GetUserAttributes getUserAttributes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributes target = null;
            target = (npa.ldap.ws.GetUserAttributes)get_store().find_element_user(GETUSERATTRIBUTES$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserAttributes)get_store().add_element_user(GETUSERATTRIBUTES$0);
            }
            target.set(getUserAttributes);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserAttributes" element
     */
    public npa.ldap.ws.GetUserAttributes addNewGetUserAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributes target = null;
            target = (npa.ldap.ws.GetUserAttributes)get_store().add_element_user(GETUSERATTRIBUTES$0);
            return target;
        }
    }
}
