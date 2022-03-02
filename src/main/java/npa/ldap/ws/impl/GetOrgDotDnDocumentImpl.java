/*
 * An XML document type.
 * Localname: getOrgDotDn
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgDotDnDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgDotDn(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgDotDnDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgDotDnDocument
{
    
    public GetOrgDotDnDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGDOTDN$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgDotDn");
    
    
    /**
     * Gets the "getOrgDotDn" element
     */
    public npa.ldap.ws.GetOrgDotDn getGetOrgDotDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotDn target = null;
            target = (npa.ldap.ws.GetOrgDotDn)get_store().find_element_user(GETORGDOTDN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgDotDn" element
     */
    public void setGetOrgDotDn(npa.ldap.ws.GetOrgDotDn getOrgDotDn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotDn target = null;
            target = (npa.ldap.ws.GetOrgDotDn)get_store().find_element_user(GETORGDOTDN$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgDotDn)get_store().add_element_user(GETORGDOTDN$0);
            }
            target.set(getOrgDotDn);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgDotDn" element
     */
    public npa.ldap.ws.GetOrgDotDn addNewGetOrgDotDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotDn target = null;
            target = (npa.ldap.ws.GetOrgDotDn)get_store().add_element_user(GETORGDOTDN$0);
            return target;
        }
    }
}
