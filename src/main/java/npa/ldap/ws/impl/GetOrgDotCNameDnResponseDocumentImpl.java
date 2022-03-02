/*
 * An XML document type.
 * Localname: getOrgDotCNameDnResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgDotCNameDnResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgDotCNameDnResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgDotCNameDnResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgDotCNameDnResponseDocument
{
    
    public GetOrgDotCNameDnResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGDOTCNAMEDNRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgDotCNameDnResponse");
    
    
    /**
     * Gets the "getOrgDotCNameDnResponse" element
     */
    public npa.ldap.ws.GetOrgDotCNameDnResponse getGetOrgDotCNameDnResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotCNameDnResponse target = null;
            target = (npa.ldap.ws.GetOrgDotCNameDnResponse)get_store().find_element_user(GETORGDOTCNAMEDNRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgDotCNameDnResponse" element
     */
    public void setGetOrgDotCNameDnResponse(npa.ldap.ws.GetOrgDotCNameDnResponse getOrgDotCNameDnResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotCNameDnResponse target = null;
            target = (npa.ldap.ws.GetOrgDotCNameDnResponse)get_store().find_element_user(GETORGDOTCNAMEDNRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgDotCNameDnResponse)get_store().add_element_user(GETORGDOTCNAMEDNRESPONSE$0);
            }
            target.set(getOrgDotCNameDnResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgDotCNameDnResponse" element
     */
    public npa.ldap.ws.GetOrgDotCNameDnResponse addNewGetOrgDotCNameDnResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotCNameDnResponse target = null;
            target = (npa.ldap.ws.GetOrgDotCNameDnResponse)get_store().add_element_user(GETORGDOTCNAMEDNRESPONSE$0);
            return target;
        }
    }
}
