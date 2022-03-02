/*
 * An XML document type.
 * Localname: getUserAttributesResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributesResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserAttributesResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserAttributesResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAttributesResponseDocument
{
    
    public GetUserAttributesResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERATTRIBUTESRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserAttributesResponse");
    
    
    /**
     * Gets the "getUserAttributesResponse" element
     */
    public npa.ldap.ws.GetUserAttributesResponse getGetUserAttributesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributesResponse target = null;
            target = (npa.ldap.ws.GetUserAttributesResponse)get_store().find_element_user(GETUSERATTRIBUTESRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserAttributesResponse" element
     */
    public void setGetUserAttributesResponse(npa.ldap.ws.GetUserAttributesResponse getUserAttributesResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributesResponse target = null;
            target = (npa.ldap.ws.GetUserAttributesResponse)get_store().find_element_user(GETUSERATTRIBUTESRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserAttributesResponse)get_store().add_element_user(GETUSERATTRIBUTESRESPONSE$0);
            }
            target.set(getUserAttributesResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserAttributesResponse" element
     */
    public npa.ldap.ws.GetUserAttributesResponse addNewGetUserAttributesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributesResponse target = null;
            target = (npa.ldap.ws.GetUserAttributesResponse)get_store().add_element_user(GETUSERATTRIBUTESRESPONSE$0);
            return target;
        }
    }
}
