/*
 * An XML document type.
 * Localname: menuGenerator3Response
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.MenuGenerator3ResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one menuGenerator3Response(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class MenuGenerator3ResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.MenuGenerator3ResponseDocument
{
    
    public MenuGenerator3ResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MENUGENERATOR3RESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "menuGenerator3Response");
    
    
    /**
     * Gets the "menuGenerator3Response" element
     */
    public npa.ldap.ws.MenuGenerator3Response getMenuGenerator3Response()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator3Response target = null;
            target = (npa.ldap.ws.MenuGenerator3Response)get_store().find_element_user(MENUGENERATOR3RESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "menuGenerator3Response" element
     */
    public void setMenuGenerator3Response(npa.ldap.ws.MenuGenerator3Response menuGenerator3Response)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator3Response target = null;
            target = (npa.ldap.ws.MenuGenerator3Response)get_store().find_element_user(MENUGENERATOR3RESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.MenuGenerator3Response)get_store().add_element_user(MENUGENERATOR3RESPONSE$0);
            }
            target.set(menuGenerator3Response);
        }
    }
    
    /**
     * Appends and returns a new empty "menuGenerator3Response" element
     */
    public npa.ldap.ws.MenuGenerator3Response addNewMenuGenerator3Response()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator3Response target = null;
            target = (npa.ldap.ws.MenuGenerator3Response)get_store().add_element_user(MENUGENERATOR3RESPONSE$0);
            return target;
        }
    }
}
