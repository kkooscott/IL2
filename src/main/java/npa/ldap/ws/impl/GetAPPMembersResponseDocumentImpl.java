/*
 * An XML document type.
 * Localname: getAPPMembersResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetAPPMembersResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getAPPMembersResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetAPPMembersResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetAPPMembersResponseDocument
{
    
    public GetAPPMembersResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETAPPMEMBERSRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getAPPMembersResponse");
    
    
    /**
     * Gets the "getAPPMembersResponse" element
     */
    public npa.ldap.ws.GetAPPMembersResponse getGetAPPMembersResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetAPPMembersResponse target = null;
            target = (npa.ldap.ws.GetAPPMembersResponse)get_store().find_element_user(GETAPPMEMBERSRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAPPMembersResponse" element
     */
    public void setGetAPPMembersResponse(npa.ldap.ws.GetAPPMembersResponse getAPPMembersResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetAPPMembersResponse target = null;
            target = (npa.ldap.ws.GetAPPMembersResponse)get_store().find_element_user(GETAPPMEMBERSRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetAPPMembersResponse)get_store().add_element_user(GETAPPMEMBERSRESPONSE$0);
            }
            target.set(getAPPMembersResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getAPPMembersResponse" element
     */
    public npa.ldap.ws.GetAPPMembersResponse addNewGetAPPMembersResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetAPPMembersResponse target = null;
            target = (npa.ldap.ws.GetAPPMembersResponse)get_store().add_element_user(GETAPPMEMBERSRESPONSE$0);
            return target;
        }
    }
}
