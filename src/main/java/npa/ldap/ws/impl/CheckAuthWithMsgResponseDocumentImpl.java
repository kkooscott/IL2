/*
 * An XML document type.
 * Localname: checkAuthWithMsgResponse
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.CheckAuthWithMsgResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one checkAuthWithMsgResponse(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class CheckAuthWithMsgResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.CheckAuthWithMsgResponseDocument
{
    
    public CheckAuthWithMsgResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHECKAUTHWITHMSGRESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "checkAuthWithMsgResponse");
    
    
    /**
     * Gets the "checkAuthWithMsgResponse" element
     */
    public npa.ldap.ws.CheckAuthWithMsgResponse getCheckAuthWithMsgResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthWithMsgResponse target = null;
            target = (npa.ldap.ws.CheckAuthWithMsgResponse)get_store().find_element_user(CHECKAUTHWITHMSGRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkAuthWithMsgResponse" element
     */
    public void setCheckAuthWithMsgResponse(npa.ldap.ws.CheckAuthWithMsgResponse checkAuthWithMsgResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthWithMsgResponse target = null;
            target = (npa.ldap.ws.CheckAuthWithMsgResponse)get_store().find_element_user(CHECKAUTHWITHMSGRESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.CheckAuthWithMsgResponse)get_store().add_element_user(CHECKAUTHWITHMSGRESPONSE$0);
            }
            target.set(checkAuthWithMsgResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "checkAuthWithMsgResponse" element
     */
    public npa.ldap.ws.CheckAuthWithMsgResponse addNewCheckAuthWithMsgResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthWithMsgResponse target = null;
            target = (npa.ldap.ws.CheckAuthWithMsgResponse)get_store().add_element_user(CHECKAUTHWITHMSGRESPONSE$0);
            return target;
        }
    }
}
