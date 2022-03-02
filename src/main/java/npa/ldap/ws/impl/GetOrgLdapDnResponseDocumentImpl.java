/*
 * An XML document type.
 * Localname: getOrgLdapDnResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgLdapDnResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgLdapDnResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgLdapDnResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgLdapDnResponseDocument
{
    
    public GetOrgLdapDnResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGLDAPDNRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgLdapDnResponse");
    
    
    /**
     * Gets the "getOrgLdapDnResponse" element
     */
    public npa.ldap.ws.GetOrgLdapDnResponse getGetOrgLdapDnResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgLdapDnResponse target = null;
            target = (npa.ldap.ws.GetOrgLdapDnResponse)get_store().find_element_user(GETORGLDAPDNRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgLdapDnResponse" element
     */
    public void setGetOrgLdapDnResponse(npa.ldap.ws.GetOrgLdapDnResponse getOrgLdapDnResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgLdapDnResponse target = null;
            target = (npa.ldap.ws.GetOrgLdapDnResponse)get_store().find_element_user(GETORGLDAPDNRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgLdapDnResponse)get_store().add_element_user(GETORGLDAPDNRESPONSE$0);
            }
            target.set(getOrgLdapDnResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgLdapDnResponse" element
     */
    public npa.ldap.ws.GetOrgLdapDnResponse addNewGetOrgLdapDnResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgLdapDnResponse target = null;
            target = (npa.ldap.ws.GetOrgLdapDnResponse)get_store().add_element_user(GETORGLDAPDNRESPONSE$0);
            return target;
        }
    }
}
