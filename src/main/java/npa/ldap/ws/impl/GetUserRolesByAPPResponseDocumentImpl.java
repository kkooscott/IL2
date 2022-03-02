/*
 * An XML document type.
 * Localname: getUserRolesByAPPResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserRolesByAPPResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserRolesByAPPResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserRolesByAPPResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserRolesByAPPResponseDocument
{
    
    public GetUserRolesByAPPResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERROLESBYAPPRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserRolesByAPPResponse");
    
    
    /**
     * Gets the "getUserRolesByAPPResponse" element
     */
    public npa.ldap.ws.GetUserRolesByAPPResponse getGetUserRolesByAPPResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesByAPPResponse target = null;
            target = (npa.ldap.ws.GetUserRolesByAPPResponse)get_store().find_element_user(GETUSERROLESBYAPPRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserRolesByAPPResponse" element
     */
    public void setGetUserRolesByAPPResponse(npa.ldap.ws.GetUserRolesByAPPResponse getUserRolesByAPPResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesByAPPResponse target = null;
            target = (npa.ldap.ws.GetUserRolesByAPPResponse)get_store().find_element_user(GETUSERROLESBYAPPRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserRolesByAPPResponse)get_store().add_element_user(GETUSERROLESBYAPPRESPONSE$0);
            }
            target.set(getUserRolesByAPPResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserRolesByAPPResponse" element
     */
    public npa.ldap.ws.GetUserRolesByAPPResponse addNewGetUserRolesByAPPResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserRolesByAPPResponse target = null;
            target = (npa.ldap.ws.GetUserRolesByAPPResponse)get_store().add_element_user(GETUSERROLESBYAPPRESPONSE$0);
            return target;
        }
    }
}
