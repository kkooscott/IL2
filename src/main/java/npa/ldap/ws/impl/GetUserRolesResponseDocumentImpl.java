/*
 * An XML document type.
 * Localname: getUserRolesResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserRolesResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserRolesResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserRolesResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserRolesResponseDocument
{
    
    public GetUserRolesResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERROLESRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserRolesResponse");
    
    
    /**
     * Gets the "getUserRolesResponse" element
     */
    public npa.ldap.ws.GetUserRolesResponse getGetUserRolesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesResponse target = null;
            target = (npa.ldap.ws.GetUserRolesResponse)get_store().find_element_user(GETUSERROLESRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserRolesResponse" element
     */
    public void setGetUserRolesResponse(npa.ldap.ws.GetUserRolesResponse getUserRolesResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesResponse target = null;
            target = (npa.ldap.ws.GetUserRolesResponse)get_store().find_element_user(GETUSERROLESRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserRolesResponse)get_store().add_element_user(GETUSERROLESRESPONSE$0);
            }
            target.set(getUserRolesResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserRolesResponse" element
     */
    public npa.ldap.ws.GetUserRolesResponse addNewGetUserRolesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesResponse target = null;
            target = (npa.ldap.ws.GetUserRolesResponse)get_store().add_element_user(GETUSERROLESRESPONSE$0);
            return target;
        }
    }
}
