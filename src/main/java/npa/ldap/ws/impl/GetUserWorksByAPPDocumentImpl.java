/*
 * An XML document type.
 * Localname: getUserWorksByAPP
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetUserWorksByAPPDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getUserWorksByAPP(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetUserWorksByAPPDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetUserWorksByAPPDocument
{
    
    public GetUserWorksByAPPDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETUSERWORKSBYAPP$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getUserWorksByAPP");
    
    
    /**
     * Gets the "getUserWorksByAPP" element
     */
    public npa.ldap.ws.GetUserWorksByAPP getGetUserWorksByAPP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserWorksByAPP target = null;
            target = (npa.ldap.ws.GetUserWorksByAPP)get_store().find_element_user(GETUSERWORKSBYAPP$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getUserWorksByAPP" element
     */
    public void setGetUserWorksByAPP(npa.ldap.ws.GetUserWorksByAPP getUserWorksByAPP)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserWorksByAPP target = null;
            target = (npa.ldap.ws.GetUserWorksByAPP)get_store().find_element_user(GETUSERWORKSBYAPP$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetUserWorksByAPP)get_store().add_element_user(GETUSERWORKSBYAPP$0);
            }
            target.set(getUserWorksByAPP);
        }
    }
    
    /**
     * Appends and returns a new empty "getUserWorksByAPP" element
     */
    public npa.ldap.ws.GetUserWorksByAPP addNewGetUserWorksByAPP()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetUserWorksByAPP target = null;
            target = (npa.ldap.ws.GetUserWorksByAPP)get_store().add_element_user(GETUSERWORKSBYAPP$0);
            return target;
        }
    }
}
