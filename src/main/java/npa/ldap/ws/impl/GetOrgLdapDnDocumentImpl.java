/*
 * An XML document type.
 * Localname: getOrgLdapDn
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgLdapDnDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgLdapDn(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgLdapDnDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgLdapDnDocument
{
    
    public GetOrgLdapDnDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGLDAPDN$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgLdapDn");
    
    
    /**
     * Gets the "getOrgLdapDn" element
     */
    public npa.ldap.ws.GetOrgLdapDn getGetOrgLdapDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgLdapDn target = null;
            target = (npa.ldap.ws.GetOrgLdapDn)get_store().find_element_user(GETORGLDAPDN$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgLdapDn" element
     */
    public void setGetOrgLdapDn(npa.ldap.ws.GetOrgLdapDn getOrgLdapDn)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgLdapDn target = null;
            target = (npa.ldap.ws.GetOrgLdapDn)get_store().find_element_user(GETORGLDAPDN$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgLdapDn)get_store().add_element_user(GETORGLDAPDN$0);
            }
            target.set(getOrgLdapDn);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgLdapDn" element
     */
    public npa.ldap.ws.GetOrgLdapDn addNewGetOrgLdapDn()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgLdapDn target = null;
            target = (npa.ldap.ws.GetOrgLdapDn)get_store().add_element_user(GETORGLDAPDN$0);
            return target;
        }
    }
}
