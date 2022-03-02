/*
 * An XML document type.
 * Localname: getUserAttributeResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAttributeResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserAttributeResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserAttributeResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAttributeResponseDocument
{
    
    public GetUserAttributeResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERATTRIBUTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserAttributeResponse");
    
    
    /**
     * Gets the "getUserAttributeResponse" element
     */
    public npa.ldap.ws.GetUserAttributeResponse getGetUserAttributeResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributeResponse target = null;
            target = (npa.ldap.ws.GetUserAttributeResponse)get_store().find_element_user(GETUSERATTRIBUTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserAttributeResponse" element
     */
    public void setGetUserAttributeResponse(npa.ldap.ws.GetUserAttributeResponse getUserAttributeResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributeResponse target = null;
            target = (npa.ldap.ws.GetUserAttributeResponse)get_store().find_element_user(GETUSERATTRIBUTERESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserAttributeResponse)get_store().add_element_user(GETUSERATTRIBUTERESPONSE$0);
            }
            target.set(getUserAttributeResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserAttributeResponse" element
     */
    public npa.ldap.ws.GetUserAttributeResponse addNewGetUserAttributeResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAttributeResponse target = null;
            target = (npa.ldap.ws.GetUserAttributeResponse)get_store().add_element_user(GETUSERATTRIBUTERESPONSE$0);
            return target;
        }
    }
}
