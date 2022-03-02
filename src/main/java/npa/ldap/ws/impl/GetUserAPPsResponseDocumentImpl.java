/*
 * An XML document type.
 * Localname: getUserAPPsResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAPPsResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserAPPsResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserAPPsResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAPPsResponseDocument
{
    
    public GetUserAPPsResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERAPPSRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserAPPsResponse");
    
    
    /**
     * Gets the "getUserAPPsResponse" element
     */
    public npa.ldap.ws.GetUserAPPsResponse getGetUserAPPsResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAPPsResponse target = null;
            target = (npa.ldap.ws.GetUserAPPsResponse)get_store().find_element_user(GETUSERAPPSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserAPPsResponse" element
     */
    public void setGetUserAPPsResponse(npa.ldap.ws.GetUserAPPsResponse getUserAPPsResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAPPsResponse target = null;
            target = (npa.ldap.ws.GetUserAPPsResponse)get_store().find_element_user(GETUSERAPPSRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserAPPsResponse)get_store().add_element_user(GETUSERAPPSRESPONSE$0);
            }
            target.set(getUserAPPsResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserAPPsResponse" element
     */
    public npa.ldap.ws.GetUserAPPsResponse addNewGetUserAPPsResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAPPsResponse target = null;
            target = (npa.ldap.ws.GetUserAPPsResponse)get_store().add_element_user(GETUSERAPPSRESPONSE$0);
            return target;
        }
    }
}
