/*
 * An XML document type.
 * Localname: checkAuth
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.CheckAuthDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one checkAuth(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class CheckAuthDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.CheckAuthDocument
{
    
    public CheckAuthDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName CHECKAUTH$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "checkAuth");
    
    
    /**
     * Gets the "checkAuth" element
     */
    public npa.ldap.ws.CheckAuth getCheckAuth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuth target = null;
            target = (npa.ldap.ws.CheckAuth)get_store().find_element_user(CHECKAUTH$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "checkAuth" element
     */
    public void setCheckAuth(npa.ldap.ws.CheckAuth checkAuth)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuth target = null;
            target = (npa.ldap.ws.CheckAuth)get_store().find_element_user(CHECKAUTH$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.CheckAuth)get_store().add_element_user(CHECKAUTH$0);
            }
            target.set(checkAuth);
        }
    }
    
    /**
     * Appends and returns a new empty "checkAuth" element
     */
    public npa.ldap.ws.CheckAuth addNewCheckAuth()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.CheckAuth target = null;
            target = (npa.ldap.ws.CheckAuth)get_store().add_element_user(CHECKAUTH$0);
            return target;
        }
    }
}
