/*
 * An XML document type.
 * Localname: menuGenerator2
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.MenuGenerator2Document
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one menuGenerator2(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class MenuGenerator2DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.MenuGenerator2Document
{
    
    public MenuGenerator2DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MENUGENERATOR2$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "menuGenerator2");
    
    
    /**
     * Gets the "menuGenerator2" element
     */
    public npa.ldap.ws.MenuGenerator2 getMenuGenerator2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator2 target = null;
            target = (npa.ldap.ws.MenuGenerator2)get_store().find_element_user(MENUGENERATOR2$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "menuGenerator2" element
     */
    public void setMenuGenerator2(npa.ldap.ws.MenuGenerator2 menuGenerator2)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator2 target = null;
            target = (npa.ldap.ws.MenuGenerator2)get_store().find_element_user(MENUGENERATOR2$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.MenuGenerator2)get_store().add_element_user(MENUGENERATOR2$0);
            }
            target.set(menuGenerator2);
        }
    }
    
    /**
     * Appends and returns a new empty "menuGenerator2" element
     */
    public npa.ldap.ws.MenuGenerator2 addNewMenuGenerator2()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator2 target = null;
            target = (npa.ldap.ws.MenuGenerator2)get_store().add_element_user(MENUGENERATOR2$0);
            return target;
        }
    }
}
