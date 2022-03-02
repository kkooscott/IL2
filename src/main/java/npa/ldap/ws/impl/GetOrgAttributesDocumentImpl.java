/*
 * An XML document type.
 * Localname: getOrgAttributes
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetOrgAttributesDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getOrgAttributes(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetOrgAttributesDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetOrgAttributesDocument
{
    
    public GetOrgAttributesDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETORGATTRIBUTES$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getOrgAttributes");
    
    
    /**
     * Gets the "getOrgAttributes" element
     */
    public npa.ldap.ws.GetOrgAttributes getGetOrgAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributes target = null;
            target = (npa.ldap.ws.GetOrgAttributes)get_store().find_element_user(GETORGATTRIBUTES$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getOrgAttributes" element
     */
    public void setGetOrgAttributes(npa.ldap.ws.GetOrgAttributes getOrgAttributes)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributes target = null;
            target = (npa.ldap.ws.GetOrgAttributes)get_store().find_element_user(GETORGATTRIBUTES$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetOrgAttributes)get_store().add_element_user(GETORGATTRIBUTES$0);
            }
            target.set(getOrgAttributes);
        }
    }
    
    /**
     * Appends and returns a new empty "getOrgAttributes" element
     */
    public npa.ldap.ws.GetOrgAttributes addNewGetOrgAttributes()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetOrgAttributes target = null;
            target = (npa.ldap.ws.GetOrgAttributes)get_store().add_element_user(GETORGATTRIBUTES$0);
            return target;
        }
    }
}
