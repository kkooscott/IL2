/*
 * An XML document type.
 * Localname: getAPPMembers
 * Namespace: http://ws.ldap.npa/
 * Java type: npa.ldap.ws.GetAPPMembersDocument
 *
 * Automatically generated - do not modify.
 */
package npa.ldap.ws.impl;
/**
 * A document containing one getAPPMembers(@http://ws.ldap.npa/) element.
 *
 * This is a complex type.
 */
public class GetAPPMembersDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements npa.ldap.ws.GetAPPMembersDocument
{
    
    public GetAPPMembersDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETAPPMEMBERS$0 = 
        new javax.xml.namespace.QName("http://ws.ldap.npa/", "getAPPMembers");
    
    
    /**
     * Gets the "getAPPMembers" element
     */
    public npa.ldap.ws.GetAPPMembers getGetAPPMembers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetAPPMembers target = null;
            target = (npa.ldap.ws.GetAPPMembers)get_store().find_element_user(GETAPPMEMBERS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getAPPMembers" element
     */
    public void setGetAPPMembers(npa.ldap.ws.GetAPPMembers getAPPMembers)
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetAPPMembers target = null;
            target = (npa.ldap.ws.GetAPPMembers)get_store().find_element_user(GETAPPMEMBERS$0, 0);
            if (target == null)
            {
                target = (npa.ldap.ws.GetAPPMembers)get_store().add_element_user(GETAPPMEMBERS$0);
            }
            target.set(getAPPMembers);
        }
    }
    
    /**
     * Appends and returns a new empty "getAPPMembers" element
     */
    public npa.ldap.ws.GetAPPMembers addNewGetAPPMembers()
    {
        synchronized (monitor())
        {
            check_orphaned();
            npa.ldap.ws.GetAPPMembers target = null;
            target = (npa.ldap.ws.GetAPPMembers)get_store().add_element_user(GETAPPMEMBERS$0);
            return target;
        }
    }
}
