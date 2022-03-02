/*
 * An XML document type.
 * Localname: getUserRoles
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserRolesDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserRoles(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserRolesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserRolesDocument
{
    
    public GetUserRolesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERROLES$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserRoles");
    
    
    /**
     * Gets the "getUserRoles" element
     */
    public npa.ldap.ws.GetUserRoles getGetUserRoles()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRoles target = null;
            target = (npa.ldap.ws.GetUserRoles)get_store().find_element_user(GETUSERROLES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserRoles" element
     */
    public void setGetUserRoles(npa.ldap.ws.GetUserRoles getUserRoles)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRoles target = null;
            target = (npa.ldap.ws.GetUserRoles)get_store().find_element_user(GETUSERROLES$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserRoles)get_store().add_element_user(GETUSERROLES$0);
            }
            target.set(getUserRoles);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserRoles" element
     */
    public npa.ldap.ws.GetUserRoles addNewGetUserRoles()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRoles target = null;
            target = (npa.ldap.ws.GetUserRoles)get_store().add_element_user(GETUSERROLES$0);
            return target;
        }
    }
}
