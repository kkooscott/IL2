/*
 * An XML document type.
 * Localname: getOrgAttributesResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgAttributesResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgAttributesResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgAttributesResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgAttributesResponseDocument
{
    
    public GetOrgAttributesResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGATTRIBUTESRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgAttributesResponse");
    
    
    /**
     * Gets the "getOrgAttributesResponse" element
     */
    public npa.ldap.ws.GetOrgAttributesResponse getGetOrgAttributesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributesResponse target = null;
            target = (npa.ldap.ws.GetOrgAttributesResponse)get_store().find_element_user(GETORGATTRIBUTESRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgAttributesResponse" element
     */
    public void setGetOrgAttributesResponse(npa.ldap.ws.GetOrgAttributesResponse getOrgAttributesResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributesResponse target = null;
            target = (npa.ldap.ws.GetOrgAttributesResponse)get_store().find_element_user(GETORGATTRIBUTESRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgAttributesResponse)get_store().add_element_user(GETORGATTRIBUTESRESPONSE$0);
            }
            target.set(getOrgAttributesResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgAttributesResponse" element
     */
    public npa.ldap.ws.GetOrgAttributesResponse addNewGetOrgAttributesResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributesResponse target = null;
            target = (npa.ldap.ws.GetOrgAttributesResponse)get_store().add_element_user(GETORGATTRIBUTESRESPONSE$0);
            return target;
        }
    }
}
