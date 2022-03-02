/*
 * An XML document type.
 * Localname: getUserAPPs
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserAPPsDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserAPPs(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserAPPsDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserAPPsDocument
{
    
    public GetUserAPPsDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERAPPS$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserAPPs");
    
    
    /**
     * Gets the "getUserAPPs" element
     */
    public npa.ldap.ws.GetUserAPPs getGetUserAPPs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAPPs target = null;
            target = (npa.ldap.ws.GetUserAPPs)get_store().find_element_user(GETUSERAPPS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserAPPs" element
     */
    public void setGetUserAPPs(npa.ldap.ws.GetUserAPPs getUserAPPs)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAPPs target = null;
            target = (npa.ldap.ws.GetUserAPPs)get_store().find_element_user(GETUSERAPPS$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserAPPs)get_store().add_element_user(GETUSERAPPS$0);
            }
            target.set(getUserAPPs);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserAPPs" element
     */
    public npa.ldap.ws.GetUserAPPs addNewGetUserAPPs()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserAPPs target = null;
            target = (npa.ldap.ws.GetUserAPPs)get_store().add_element_user(GETUSERAPPS$0);
            return target;
        }
    }
}
