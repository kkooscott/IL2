/*
 * An XML document type.
 * Localname: getOrgDotDnResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgDotDnResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgDotDnResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgDotDnResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgDotDnResponseDocument
{
    
    public GetOrgDotDnResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGDOTDNRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgDotDnResponse");
    
    
    /**
     * Gets the "getOrgDotDnResponse" element
     */
    public npa.ldap.ws.GetOrgDotDnResponse getGetOrgDotDnResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotDnResponse target = null;
            target = (npa.ldap.ws.GetOrgDotDnResponse)get_store().find_element_user(GETORGDOTDNRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgDotDnResponse" element
     */
    public void setGetOrgDotDnResponse(npa.ldap.ws.GetOrgDotDnResponse getOrgDotDnResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotDnResponse target = null;
            target = (npa.ldap.ws.GetOrgDotDnResponse)get_store().find_element_user(GETORGDOTDNRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgDotDnResponse)get_store().add_element_user(GETORGDOTDNRESPONSE$0);
            }
            target.set(getOrgDotDnResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgDotDnResponse" element
     */
    public npa.ldap.ws.GetOrgDotDnResponse addNewGetOrgDotDnResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotDnResponse target = null;
            target = (npa.ldap.ws.GetOrgDotDnResponse)get_store().add_element_user(GETORGDOTDNRESPONSE$0);
            return target;
        }
    }
}
