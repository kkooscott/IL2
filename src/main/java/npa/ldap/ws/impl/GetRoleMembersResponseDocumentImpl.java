/*
 * An XML document type.
 * Localname: getRoleMembersResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetRoleMembersResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getRoleMembersResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetRoleMembersResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetRoleMembersResponseDocument
{
    
    public GetRoleMembersResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETROLEMEMBERSRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getRoleMembersResponse");
    
    
    /**
     * Gets the "getRoleMembersResponse" element
     */
    public npa.ldap.ws.GetRoleMembersResponse getGetRoleMembersResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetRoleMembersResponse target = null;
            target = (npa.ldap.ws.GetRoleMembersResponse)get_store().find_element_user(GETROLEMEMBERSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getRoleMembersResponse" element
     */
    public void setGetRoleMembersResponse(npa.ldap.ws.GetRoleMembersResponse getRoleMembersResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetRoleMembersResponse target = null;
            target = (npa.ldap.ws.GetRoleMembersResponse)get_store().find_element_user(GETROLEMEMBERSRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetRoleMembersResponse)get_store().add_element_user(GETROLEMEMBERSRESPONSE$0);
            }
            target.set(getRoleMembersResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getRoleMembersResponse" element
     */
    public npa.ldap.ws.GetRoleMembersResponse addNewGetRoleMembersResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetRoleMembersResponse target = null;
            target = (npa.ldap.ws.GetRoleMembersResponse)get_store().add_element_user(GETROLEMEMBERSRESPONSE$0);
            return target;
        }
    }
}
