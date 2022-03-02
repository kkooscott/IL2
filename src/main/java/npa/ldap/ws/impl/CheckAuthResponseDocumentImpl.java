/*
 * An XML document type.
 * Localname: checkAuthResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.CheckAuthResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one checkAuthResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class CheckAuthResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.CheckAuthResponseDocument
{
    
    public CheckAuthResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHECKAUTHRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "checkAuthResponse");
    
    
    /**
     * Gets the "checkAuthResponse" element
     */
    public npa.ldap.ws.CheckAuthResponse getCheckAuthResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthResponse target = null;
            target = (npa.ldap.ws.CheckAuthResponse)get_store().find_element_user(CHECKAUTHRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkAuthResponse" element
     */
    public void setCheckAuthResponse(npa.ldap.ws.CheckAuthResponse checkAuthResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthResponse target = null;
            target = (npa.ldap.ws.CheckAuthResponse)get_store().find_element_user(CHECKAUTHRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.CheckAuthResponse)get_store().add_element_user(CHECKAUTHRESPONSE$0);
            }
            target.set(checkAuthResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "checkAuthResponse" element
     */
    public npa.ldap.ws.CheckAuthResponse addNewCheckAuthResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthResponse target = null;
            target = (npa.ldap.ws.CheckAuthResponse)get_store().add_element_user(CHECKAUTHRESPONSE$0);
            return target;
        }
    }
}
