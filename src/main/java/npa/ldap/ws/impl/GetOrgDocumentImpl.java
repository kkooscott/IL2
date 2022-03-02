/*
 * An XML document type.
 * Localname: getOrg
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrg(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgDocument
{
    
    public GetOrgDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORG$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrg");
    
    
    /**
     * Gets the "getOrg" element
     */
    public npa.ldap.ws.GetOrg getGetOrg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrg target = null;
            target = (npa.ldap.ws.GetOrg)get_store().find_element_user(GETORG$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrg" element
     */
    public void setGetOrg(npa.ldap.ws.GetOrg getOrg)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrg target = null;
            target = (npa.ldap.ws.GetOrg)get_store().find_element_user(GETORG$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrg)get_store().add_element_user(GETORG$0);
            }
            target.set(getOrg);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrg" element
     */
    public npa.ldap.ws.GetOrg addNewGetOrg()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrg target = null;
            target = (npa.ldap.ws.GetOrg)get_store().add_element_user(GETORG$0);
            return target;
        }
    }
}
