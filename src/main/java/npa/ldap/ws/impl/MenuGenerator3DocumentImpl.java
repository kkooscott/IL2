/*
 * An XML document type.
 * Localname: menuGenerator3
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.MenuGenerator3Document
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one menuGenerator3(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class MenuGenerator3DocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.MenuGenerator3Document
{
    
    public MenuGenerator3DocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName MENUGENERATOR3$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "menuGenerator3");
    
    
    /**
     * Gets the "menuGenerator3" element
     */
    public npa.ldap.ws.MenuGenerator3 getMenuGenerator3()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator3 target = null;
            target = (npa.ldap.ws.MenuGenerator3)get_store().find_element_user(MENUGENERATOR3$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "menuGenerator3" element
     */
    public void setMenuGenerator3(npa.ldap.ws.MenuGenerator3 menuGenerator3)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator3 target = null;
            target = (npa.ldap.ws.MenuGenerator3)get_store().find_element_user(MENUGENERATOR3$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.MenuGenerator3)get_store().add_element_user(MENUGENERATOR3$0);
            }
            target.set(menuGenerator3);
        }
    }
    
    /**
     * Appends and returns a new empty "menuGenerator3" element
     */
    public npa.ldap.ws.MenuGenerator3 addNewMenuGenerator3()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.MenuGenerator3 target = null;
            target = (npa.ldap.ws.MenuGenerator3)get_store().add_element_user(MENUGENERATOR3$0);
            return target;
        }
    }
}
