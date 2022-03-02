/*
 * An XML document type.
 * Localname: getOrgDotCNameDn
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgDotCNameDnDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgDotCNameDn(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgDotCNameDnDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgDotCNameDnDocument
{
    
    public GetOrgDotCNameDnDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGDOTCNAMEDN$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgDotCNameDn");
    
    
    /**
     * Gets the "getOrgDotCNameDn" element
     */
    public npa.ldap.ws.GetOrgDotCNameDn getGetOrgDotCNameDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotCNameDn target = null;
            target = (npa.ldap.ws.GetOrgDotCNameDn)get_store().find_element_user(GETORGDOTCNAMEDN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgDotCNameDn" element
     */
    public void setGetOrgDotCNameDn(npa.ldap.ws.GetOrgDotCNameDn getOrgDotCNameDn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotCNameDn target = null;
            target = (npa.ldap.ws.GetOrgDotCNameDn)get_store().find_element_user(GETORGDOTCNAMEDN$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgDotCNameDn)get_store().add_element_user(GETORGDOTCNAMEDN$0);
            }
            target.set(getOrgDotCNameDn);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgDotCNameDn" element
     */
    public npa.ldap.ws.GetOrgDotCNameDn addNewGetOrgDotCNameDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgDotCNameDn target = null;
            target = (npa.ldap.ws.GetOrgDotCNameDn)get_store().add_element_user(GETORGDOTCNAMEDN$0);
            return target;
        }
    }
}
