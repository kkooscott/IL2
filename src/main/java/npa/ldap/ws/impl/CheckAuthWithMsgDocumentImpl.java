/*
 * An XML document type.
 * Localname: checkAuthWithMsg
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.CheckAuthWithMsgDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one checkAuthWithMsg(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class CheckAuthWithMsgDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.CheckAuthWithMsgDocument
{
    
    public CheckAuthWithMsgDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHECKAUTHWITHMSG$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "checkAuthWithMsg");
    
    
    /**
     * Gets the "checkAuthWithMsg" element
     */
    public npa.ldap.ws.CheckAuthWithMsg getCheckAuthWithMsg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthWithMsg target = null;
            target = (npa.ldap.ws.CheckAuthWithMsg)get_store().find_element_user(CHECKAUTHWITHMSG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkAuthWithMsg" element
     */
    public void setCheckAuthWithMsg(npa.ldap.ws.CheckAuthWithMsg checkAuthWithMsg)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthWithMsg target = null;
            target = (npa.ldap.ws.CheckAuthWithMsg)get_store().find_element_user(CHECKAUTHWITHMSG$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.CheckAuthWithMsg)get_store().add_element_user(CHECKAUTHWITHMSG$0);
            }
            target.set(checkAuthWithMsg);
        }
    }
    
    /**
     * Appends and returns a new empty "checkAuthWithMsg" element
     */
    public npa.ldap.ws.CheckAuthWithMsg addNewCheckAuthWithMsg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuthWithMsg target = null;
            target = (npa.ldap.ws.CheckAuthWithMsg)get_store().add_element_user(CHECKAUTHWITHMSG$0);
            return target;
        }
    }
}
