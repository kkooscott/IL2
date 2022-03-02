/*
 * An XML document type.
 * Localname: getOrgUsers
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgUsersDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgUsers(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgUsersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgUsersDocument
{
    
    public GetOrgUsersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGUSERS$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgUsers");
    
    
    /**
     * Gets the "getOrgUsers" element
     */
    public npa.ldap.ws.GetOrgUsers getGetOrgUsers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgUsers target = null;
            target = (npa.ldap.ws.GetOrgUsers)get_store().find_element_user(GETORGUSERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgUsers" element
     */
    public void setGetOrgUsers(npa.ldap.ws.GetOrgUsers getOrgUsers)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgUsers target = null;
            target = (npa.ldap.ws.GetOrgUsers)get_store().find_element_user(GETORGUSERS$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgUsers)get_store().add_element_user(GETORGUSERS$0);
            }
            target.set(getOrgUsers);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgUsers" element
     */
    public npa.ldap.ws.GetOrgUsers addNewGetOrgUsers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgUsers target = null;
            target = (npa.ldap.ws.GetOrgUsers)get_store().add_element_user(GETORGUSERS$0);
            return target;
        }
    }
}
