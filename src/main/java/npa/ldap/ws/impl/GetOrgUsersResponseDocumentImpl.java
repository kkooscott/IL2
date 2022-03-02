/*
 * An XML document type.
 * Localname: getOrgUsersResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgUsersResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgUsersResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgUsersResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgUsersResponseDocument
{
    
    public GetOrgUsersResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGUSERSRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgUsersResponse");
    
    
    /**
     * Gets the "getOrgUsersResponse" element
     */
    public npa.ldap.ws.GetOrgUsersResponse getGetOrgUsersResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgUsersResponse target = null;
            target = (npa.ldap.ws.GetOrgUsersResponse)get_store().find_element_user(GETORGUSERSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgUsersResponse" element
     */
    public void setGetOrgUsersResponse(npa.ldap.ws.GetOrgUsersResponse getOrgUsersResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgUsersResponse target = null;
            target = (npa.ldap.ws.GetOrgUsersResponse)get_store().find_element_user(GETORGUSERSRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgUsersResponse)get_store().add_element_user(GETORGUSERSRESPONSE$0);
            }
            target.set(getOrgUsersResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgUsersResponse" element
     */
    public npa.ldap.ws.GetOrgUsersResponse addNewGetOrgUsersResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgUsersResponse target = null;
            target = (npa.ldap.ws.GetOrgUsersResponse)get_store().add_element_user(GETORGUSERSRESPONSE$0);
            return target;
        }
    }
}
