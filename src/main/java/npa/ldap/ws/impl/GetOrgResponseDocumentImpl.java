/*
 * An XML document type.
 * Localname: getOrgResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgResponseDocument
{
    
    public GetOrgResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgResponse");
    
    
    /**
     * Gets the "getOrgResponse" element
     */
    public npa.ldap.ws.GetOrgResponse getGetOrgResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgResponse target = null;
            target = (npa.ldap.ws.GetOrgResponse)get_store().find_element_user(GETORGRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgResponse" element
     */
    public void setGetOrgResponse(npa.ldap.ws.GetOrgResponse getOrgResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgResponse target = null;
            target = (npa.ldap.ws.GetOrgResponse)get_store().find_element_user(GETORGRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgResponse)get_store().add_element_user(GETORGRESPONSE$0);
            }
            target.set(getOrgResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgResponse" element
     */
    public npa.ldap.ws.GetOrgResponse addNewGetOrgResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgResponse target = null;
            target = (npa.ldap.ws.GetOrgResponse)get_store().add_element_user(GETORGRESPONSE$0);
            return target;
        }
    }
}
