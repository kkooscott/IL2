/*
 * An XML document type.
 * Localname: getUserRolesByAPP
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserRolesByAPPDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserRolesByAPP(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserRolesByAPPDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserRolesByAPPDocument
{
    
    public GetUserRolesByAPPDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERROLESBYAPP$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserRolesByAPP");
    
    
    /**
     * Gets the "getUserRolesByAPP" element
     */
    public npa.ldap.ws.GetUserRolesByAPP getGetUserRolesByAPP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesByAPP target = null;
            target = (npa.ldap.ws.GetUserRolesByAPP)get_store().find_element_user(GETUSERROLESBYAPP$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserRolesByAPP" element
     */
    public void setGetUserRolesByAPP(npa.ldap.ws.GetUserRolesByAPP getUserRolesByAPP)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesByAPP target = null;
            target = (npa.ldap.ws.GetUserRolesByAPP)get_store().find_element_user(GETUSERROLESBYAPP$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserRolesByAPP)get_store().add_element_user(GETUSERROLESBYAPP$0);
            }
            target.set(getUserRolesByAPP);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserRolesByAPP" element
     */
    public npa.ldap.ws.GetUserRolesByAPP addNewGetUserRolesByAPP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesByAPP target = null;
            target = (npa.ldap.ws.GetUserRolesByAPP)get_store().add_element_user(GETUSERROLESBYAPP$0);
            return target;
        }
    }
}
