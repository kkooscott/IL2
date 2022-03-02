/*
 * An XML document type.
 * Localname: menuGenerator2Response
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.MenuGenerator2ResponseDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one menuGenerator2Response(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class MenuGenerator2ResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.MenuGenerator2ResponseDocument
{
    
    public MenuGenerator2ResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MENUGENERATOR2RESPONSE$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "menuGenerator2Response");
    
    
    /**
     * Gets the "menuGenerator2Response" element
     */
    public npa.ldap.ws.MenuGenerator2Response getMenuGenerator2Response()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator2Response target = null;
            target = (npa.ldap.ws.MenuGenerator2Response)get_store().find_element_user(MENUGENERATOR2RESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "menuGenerator2Response" element
     */
    public void setMenuGenerator2Response(npa.ldap.ws.MenuGenerator2Response menuGenerator2Response)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator2Response target = null;
            target = (npa.ldap.ws.MenuGenerator2Response)get_store().find_element_user(MENUGENERATOR2RESPONSE$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.MenuGenerator2Response)get_store().add_element_user(MENUGENERATOR2RESPONSE$0);
            }
            target.set(menuGenerator2Response);
        }
    }
    
    /**
     * Appends and returns a new empty "menuGenerator2Response" element
     */
    public npa.ldap.ws.MenuGenerator2Response addNewMenuGenerator2Response()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator2Response target = null;
            target = (npa.ldap.ws.MenuGenerator2Response)get_store().add_element_user(MENUGENERATOR2RESPONSE$0);
            return target;
        }
    }
}
