/*
 * An XML document type.
 * Localname: getUserWorksByAPPResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserWorksByAPPResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserWorksByAPPResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserWorksByAPPResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserWorksByAPPResponseDocument
{
    
    public GetUserWorksByAPPResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERWORKSBYAPPRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserWorksByAPPResponse");
    
    
    /**
     * Gets the "getUserWorksByAPPResponse" element
     */
    public npa.ldap.ws.GetUserWorksByAPPResponse getGetUserWorksByAPPResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserWorksByAPPResponse target = null;
            target = (npa.ldap.ws.GetUserWorksByAPPResponse)get_store().find_element_user(GETUSERWORKSBYAPPRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserWorksByAPPResponse" element
     */
    public void setGetUserWorksByAPPResponse(npa.ldap.ws.GetUserWorksByAPPResponse getUserWorksByAPPResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserWorksByAPPResponse target = null;
            target = (npa.ldap.ws.GetUserWorksByAPPResponse)get_store().find_element_user(GETUSERWORKSBYAPPRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserWorksByAPPResponse)get_store().add_element_user(GETUSERWORKSBYAPPRESPONSE$0);
            }
            target.set(getUserWorksByAPPResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserWorksByAPPResponse" element
     */
    public npa.ldap.ws.GetUserWorksByAPPResponse addNewGetUserWorksByAPPResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserWorksByAPPResponse target = null;
            target = (npa.ldap.ws.GetUserWorksByAPPResponse)get_store().add_element_user(GETUSERWORKSBYAPPRESPONSE$0);
            return target;
        }
    }
}
