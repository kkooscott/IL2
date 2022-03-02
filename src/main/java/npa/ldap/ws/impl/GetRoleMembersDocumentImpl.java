/*
 * An XML document type.
 * Localname: getRoleMembers
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetRoleMembersDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getRoleMembers(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetRoleMembersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetRoleMembersDocument
{
    
    public GetRoleMembersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETROLEMEMBERS$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getRoleMembers");
    
    
    /**
     * Gets the "getRoleMembers" element
     */
    public npa.ldap.ws.GetRoleMembers getGetRoleMembers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetRoleMembers target = null;
            target = (npa.ldap.ws.GetRoleMembers)get_store().find_element_user(GETROLEMEMBERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getRoleMembers" element
     */
    public void setGetRoleMembers(npa.ldap.ws.GetRoleMembers getRoleMembers)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetRoleMembers target = null;
            target = (npa.ldap.ws.GetRoleMembers)get_store().find_element_user(GETROLEMEMBERS$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetRoleMembers)get_store().add_element_user(GETROLEMEMBERS$0);
            }
            target.set(getRoleMembers);
        }
    }
    
    /**
     * Appends and returns a new empty "getRoleMembers" element
     */
    public npa.ldap.ws.GetRoleMembers addNewGetRoleMembers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetRoleMembers target = null;
            target = (npa.ldap.ws.GetRoleMembers)get_store().add_element_user(GETROLEMEMBERS$0);
            return target;
        }
    }
}
