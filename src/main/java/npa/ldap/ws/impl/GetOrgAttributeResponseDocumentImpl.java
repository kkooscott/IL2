/*
 * An XML document type.
 * Localname: getOrgAttributeResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgAttributeResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgAttributeResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgAttributeResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgAttributeResponseDocument
{
    
    public GetOrgAttributeResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGATTRIBUTERESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgAttributeResponse");
    
    
    /**
     * Gets the "getOrgAttributeResponse" element
     */
    public npa.ldap.ws.GetOrgAttributeResponse getGetOrgAttributeResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributeResponse target = null;
            target = (npa.ldap.ws.GetOrgAttributeResponse)get_store().find_element_user(GETORGATTRIBUTERESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgAttributeResponse" element
     */
    public void setGetOrgAttributeResponse(npa.ldap.ws.GetOrgAttributeResponse getOrgAttributeResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributeResponse target = null;
            target = (npa.ldap.ws.GetOrgAttributeResponse)get_store().find_element_user(GETORGATTRIBUTERESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgAttributeResponse)get_store().add_element_user(GETORGATTRIBUTERESPONSE$0);
            }
            target.set(getOrgAttributeResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgAttributeResponse" element
     */
    public npa.ldap.ws.GetOrgAttributeResponse addNewGetOrgAttributeResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributeResponse target = null;
            target = (npa.ldap.ws.GetOrgAttributeResponse)get_store().add_element_user(GETORGATTRIBUTERESPONSE$0);
            return target;
        }
    }
}
