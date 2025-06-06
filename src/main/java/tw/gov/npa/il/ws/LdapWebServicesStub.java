package tw.gov.npa.il.ws;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.xml.namespace.QName;
import javax.xml.transform.sax.SAXSource;
import npa.ldap.ws.CheckAuthDocument;
import npa.ldap.ws.CheckAuthResponseDocument;
import npa.ldap.ws.CheckAuthWithMsgDocument;
import npa.ldap.ws.CheckAuthWithMsgResponseDocument;
import npa.ldap.ws.GetAPPMembersDocument;
import npa.ldap.ws.GetAPPMembersResponseDocument;
import npa.ldap.ws.GetOrgAttributeDocument;
import npa.ldap.ws.GetOrgAttributeResponseDocument;
import npa.ldap.ws.GetOrgAttributesDocument;
import npa.ldap.ws.GetOrgAttributesResponseDocument;
import npa.ldap.ws.GetOrgDocument;
import npa.ldap.ws.GetOrgDotCNameDnDocument;
import npa.ldap.ws.GetOrgDotCNameDnResponseDocument;
import npa.ldap.ws.GetOrgDotDnDocument;
import npa.ldap.ws.GetOrgDotDnResponseDocument;
import npa.ldap.ws.GetOrgLdapDnDocument;
import npa.ldap.ws.GetOrgLdapDnResponseDocument;
import npa.ldap.ws.GetOrgResponseDocument;
import npa.ldap.ws.GetOrgUsersDocument;
import npa.ldap.ws.GetOrgUsersResponseDocument;
import npa.ldap.ws.GetRoleMembersDocument;
import npa.ldap.ws.GetRoleMembersResponseDocument;
import npa.ldap.ws.GetUserAPPsDocument;
import npa.ldap.ws.GetUserAPPsResponseDocument;
import npa.ldap.ws.GetUserAttributeDocument;
import npa.ldap.ws.GetUserAttributeResponseDocument;
import npa.ldap.ws.GetUserAttributesDocument;
import npa.ldap.ws.GetUserAttributesResponseDocument;
import npa.ldap.ws.GetUserRolesByAPPDocument;
import npa.ldap.ws.GetUserRolesByAPPResponseDocument;
import npa.ldap.ws.GetUserRolesDocument;
import npa.ldap.ws.GetUserRolesResponseDocument;
import npa.ldap.ws.GetUserWorksByAPPDocument;
import npa.ldap.ws.GetUserWorksByAPPResponseDocument;
import npa.ldap.ws.MenuGenerator2Document;
import npa.ldap.ws.MenuGenerator2ResponseDocument;
import npa.ldap.ws.MenuGenerator3Document;
import npa.ldap.ws.MenuGenerator3ResponseDocument;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.OMXMLBuilderFactory;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.FaultMapKey;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.axis2.xmlbeans.XmlBeansXMLReader;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class LdapWebServicesStub extends Stub {
	protected AxisOperation[] _operations;

	private HashMap faultExceptionNameMap = new HashMap<Object, Object>();

	private HashMap faultExceptionClassNameMap = new HashMap<Object, Object>();

	private HashMap faultMessageMap = new HashMap<Object, Object>();

	private static int counter = 0;

//	private static ResourceBundle rb = ResourceBundle.getBundle("config");

//	private static String url = rb.getString("ldapURL").toString();

	private static String url = "http://10.100.125.61:8085/NPALdapws/services/LdapWebServices";

//	private static String url = "";
//
//	private static String url = "";

	private QName[] opNameArray;

	private static synchronized String getUniqueSuffix() {
		if (counter > 99999)
			counter = 0;
		counter++;
		return Long.toString(System.currentTimeMillis()) + "_" + counter;
	}

	private void populateAxisService() throws AxisFault {
		this._service = new AxisService("LdapWebServices" + getUniqueSuffix());
		addAnonymousOperations();
		this._operations = new AxisOperation[19];
		OutInAxisOperation outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getAPPMembers"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[0] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrgLdapDn"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[1] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "checkAuthWithMsg"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[2] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getUserRoles"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[3] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrgUsers"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[4] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrgAttributes"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[5] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getRoleMembers"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[6] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "menuGenerator2"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[7] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getUserWorksByAPP"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[8] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "checkAuth"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[9] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getUserRolesByAPP"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[10] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrgAttribute"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[11] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getUserAttributes"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[12] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getUserAttribute"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[13] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrg"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[14] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrgDotCNameDn"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[15] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getUserAPPs"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[16] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "menuGenerator3"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[17] = (AxisOperation) outInAxisOperation;
		outInAxisOperation = new OutInAxisOperation();
		outInAxisOperation.setName(new QName("http://ws.ldap.npa/", "getOrgDotDn"));
		this._service.addOperation((AxisOperation) outInAxisOperation);
		this._operations[18] = (AxisOperation) outInAxisOperation;
	}

	private void populateFaults() {
	}

	public LdapWebServicesStub(ConfigurationContext configurationContext, String targetEndpoint) throws AxisFault {
		this(configurationContext, targetEndpoint, false);
	}

	public LdapWebServicesStub(ConfigurationContext configurationContext) throws AxisFault {
		this(configurationContext, url);
	}

	public LdapWebServicesStub() throws AxisFault {
		this(url);
	}

	public LdapWebServicesStub(String targetEndpoint) throws AxisFault {
		this((ConfigurationContext) null, targetEndpoint);
	}

	public GetAPPMembersResponseDocument getAPPMembers(GetAPPMembersDocument getAPPMembers) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getAPPMembers");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getAPPMembers,
					optimizeContent(new QName("http://ws.ldap.npa/", "getAPPMembers")),
					new QName("http://ws.ldap.npa/", "getAPPMembers"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetAPPMembersResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetAPPMembersResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getAPPMembers")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getAPPMembers"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getAPPMembers"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgLdapDnResponseDocument getOrgLdapDn(GetOrgLdapDnDocument getOrgLdapDn) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[1].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrgLdapDn");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrgLdapDn,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrgLdapDn")),
					new QName("http://ws.ldap.npa/", "getOrgLdapDn"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgLdapDnResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgLdapDnResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrgLdapDn")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgLdapDn"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgLdapDn"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public CheckAuthWithMsgResponseDocument checkAuthWithMsg(CheckAuthWithMsgDocument checkAuthWithMsg)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[2].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/checkAuthWithMsg");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), checkAuthWithMsg,
					optimizeContent(new QName("http://ws.ldap.npa/", "checkAuthWithMsg")),
					new QName("http://ws.ldap.npa/", "checkAuthWithMsg"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), CheckAuthWithMsgResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (CheckAuthWithMsgResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "checkAuthWithMsg")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "checkAuthWithMsg"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "checkAuthWithMsg"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetUserRolesResponseDocument getUserRoles(GetUserRolesDocument getUserRoles) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[3].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getUserRoles");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getUserRoles,
					optimizeContent(new QName("http://ws.ldap.npa/", "getUserRoles")),
					new QName("http://ws.ldap.npa/", "getUserRoles"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetUserRolesResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetUserRolesResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getUserRoles")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserRoles"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserRoles"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgUsersResponseDocument getOrgUsers(GetOrgUsersDocument getOrgUsers) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[4].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrgUsers");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrgUsers,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrgUsers")),
					new QName("http://ws.ldap.npa/", "getOrgUsers"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgUsersResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgUsersResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrgUsers")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgUsers"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgUsers"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgAttributesResponseDocument getOrgAttributes(GetOrgAttributesDocument getOrgAttributes)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[5].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrgAttributes");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrgAttributes,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrgAttributes")),
					new QName("http://ws.ldap.npa/", "getOrgAttributes"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgAttributesResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgAttributesResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrgAttributes")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgAttributes"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgAttributes"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetRoleMembersResponseDocument getRoleMembers(GetRoleMembersDocument getRoleMembers) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[6].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getRoleMembers");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getRoleMembers,
					optimizeContent(new QName("http://ws.ldap.npa/", "getRoleMembers")),
					new QName("http://ws.ldap.npa/", "getRoleMembers"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetRoleMembersResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetRoleMembersResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getRoleMembers")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getRoleMembers"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getRoleMembers"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public MenuGenerator2ResponseDocument menuGenerator2(MenuGenerator2Document menuGenerator2) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[7].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/menuGenerator2");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), menuGenerator2,
					optimizeContent(new QName("http://ws.ldap.npa/", "menuGenerator2")),
					new QName("http://ws.ldap.npa/", "menuGenerator2"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), MenuGenerator2ResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (MenuGenerator2ResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "menuGenerator2")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "menuGenerator2"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "menuGenerator2"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetUserWorksByAPPResponseDocument getUserWorksByAPP(GetUserWorksByAPPDocument getUserWorksByAPP)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[8].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getUserWorksByAPP");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getUserWorksByAPP,
					optimizeContent(new QName("http://ws.ldap.npa/", "getUserWorksByAPP")),
					new QName("http://ws.ldap.npa/", "getUserWorksByAPP"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetUserWorksByAPPResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetUserWorksByAPPResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getUserWorksByAPP")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserWorksByAPP"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserWorksByAPP"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public CheckAuthResponseDocument checkAuth(CheckAuthDocument checkAuth) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[9].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/checkAuth");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), checkAuth,
					optimizeContent(new QName("http://ws.ldap.npa/", "checkAuth")),
					new QName("http://ws.ldap.npa/", "checkAuth"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), CheckAuthResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (CheckAuthResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "checkAuth")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "checkAuth"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "checkAuth"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetUserRolesByAPPResponseDocument getUserRolesByAPP(GetUserRolesByAPPDocument getUserRolesByAPP)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[10].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getUserRolesByAPP");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getUserRolesByAPP,
					optimizeContent(new QName("http://ws.ldap.npa/", "getUserRolesByAPP")),
					new QName("http://ws.ldap.npa/", "getUserRolesByAPP"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetUserRolesByAPPResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetUserRolesByAPPResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getUserRolesByAPP")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserRolesByAPP"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserRolesByAPP"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgAttributeResponseDocument getOrgAttribute(GetOrgAttributeDocument getOrgAttribute)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[11].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrgAttribute");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrgAttribute,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrgAttribute")),
					new QName("http://ws.ldap.npa/", "getOrgAttribute"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgAttributeResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgAttributeResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrgAttribute")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgAttribute"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgAttribute"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetUserAttributesResponseDocument getUserAttributes(GetUserAttributesDocument getUserAttributes)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[12].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getUserAttributes");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getUserAttributes,
					optimizeContent(new QName("http://ws.ldap.npa/", "getUserAttributes")),
					new QName("http://ws.ldap.npa/", "getUserAttributes"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetUserAttributesResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetUserAttributesResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getUserAttributes")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserAttributes"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserAttributes"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetUserAttributeResponseDocument getUserAttribute(GetUserAttributeDocument getUserAttribute)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[13].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getUserAttribute");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getUserAttribute,
					optimizeContent(new QName("http://ws.ldap.npa/", "getUserAttribute")),
					new QName("http://ws.ldap.npa/", "getUserAttribute"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetUserAttributeResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetUserAttributeResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getUserAttribute")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserAttribute"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserAttribute"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgResponseDocument getOrg(GetOrgDocument getOrg) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[14].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrg");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrg,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrg")),
					new QName("http://ws.ldap.npa/", "getOrg"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrg")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrg"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrg"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgDotCNameDnResponseDocument getOrgDotCNameDn(GetOrgDotCNameDnDocument getOrgDotCNameDn)
			throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[15].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrgDotCNameDn");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrgDotCNameDn,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrgDotCNameDn")),
					new QName("http://ws.ldap.npa/", "getOrgDotCNameDn"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgDotCNameDnResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgDotCNameDnResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrgDotCNameDn")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgDotCNameDn"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgDotCNameDn"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetUserAPPsResponseDocument getUserAPPs(GetUserAPPsDocument getUserAPPs) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[16].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getUserAPPs");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getUserAPPs,
					optimizeContent(new QName("http://ws.ldap.npa/", "getUserAPPs")),
					new QName("http://ws.ldap.npa/", "getUserAPPs"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetUserAPPsResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetUserAPPsResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getUserAPPs")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserAPPs"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getUserAPPs"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public MenuGenerator3ResponseDocument menuGenerator3(MenuGenerator3Document menuGenerator3) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[17].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/menuGenerator3");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), menuGenerator3,
					optimizeContent(new QName("http://ws.ldap.npa/", "menuGenerator3")),
					new QName("http://ws.ldap.npa/", "menuGenerator3"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), MenuGenerator3ResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (MenuGenerator3ResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "menuGenerator3")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "menuGenerator3"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "menuGenerator3"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	public GetOrgDotDnResponseDocument getOrgDotDn(GetOrgDotDnDocument getOrgDotDn) throws RemoteException {
		MessageContext _messageContext = null;
		try {
			OperationClient _operationClient = this._serviceClient.createClient(this._operations[18].getName());
			_operationClient.getOptions().setAction("http://ws.ldap.npa/LdapWebServices/getOrgDotDn");
			_operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
			addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");
			_messageContext = new MessageContext();
			SOAPEnvelope env = null;
			env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), getOrgDotDn,
					optimizeContent(new QName("http://ws.ldap.npa/", "getOrgDotDn")),
					new QName("http://ws.ldap.npa/", "getOrgDotDn"));
			this._serviceClient.addHeadersToEnvelope(env);
			_messageContext.setEnvelope(env);
			_operationClient.addMessageContext(_messageContext);
			_operationClient.execute(true);
			MessageContext _returnMessageContext = _operationClient.getMessageContext("In");
			SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
			Object object = fromOM(_returnEnv.getBody().getFirstElement(), GetOrgDotDnResponseDocument.class,
					getEnvelopeNamespaces(_returnEnv));
			return (GetOrgDotDnResponseDocument) object;
		} catch (AxisFault f) {
			OMElement faultElt = f.getDetail();
			if (faultElt != null) {
				if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "getOrgDotDn")))
					try {
						String exceptionClassName = (String) this.faultExceptionClassNameMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgDotDn"));
						Class<?> exceptionClass = Class.forName(exceptionClassName);
						Constructor<?> constructor = exceptionClass.getConstructor(new Class[] { String.class });
						Exception ex = (Exception) constructor.newInstance(new Object[] { f.getMessage() });
						String messageClassName = (String) this.faultMessageMap
								.get(new FaultMapKey(faultElt.getQName(), "getOrgDotDn"));
						Class<?> messageClass = Class.forName(messageClassName);
						Object messageObject = fromOM(faultElt, messageClass, (Map) null);
						Method m = exceptionClass.getMethod("setFaultMessage", new Class[] { messageClass });
						m.invoke(ex, new Object[] { messageObject });
						throw new RemoteException(ex.getMessage(), ex);
					} catch (ClassCastException e) {
						throw f;
					} catch (ClassNotFoundException e) {
						throw f;
					} catch (NoSuchMethodException e) {
						throw f;
					} catch (InvocationTargetException e) {
						throw f;
					} catch (IllegalAccessException e) {
						throw f;
					} catch (InstantiationException e) {
						throw f;
					}
				throw f;
			}
			throw f;
		} finally {
			if (_messageContext.getTransportOut() != null)
				_messageContext.getTransportOut().getSender().cleanup(_messageContext);
		}
	}

	private Map getEnvelopeNamespaces(SOAPEnvelope env) {
		Map<Object, Object> returnMap = new HashMap<Object, Object>();
		Iterator<OMNamespace> namespaceIterator = env.getAllDeclaredNamespaces();
		while (namespaceIterator.hasNext()) {
			OMNamespace ns = namespaceIterator.next();
			returnMap.put(ns.getPrefix(), ns.getNamespaceURI());
		}
		return returnMap;
	}

	public LdapWebServicesStub(ConfigurationContext configurationContext, String targetEndpoint,
			boolean useSeparateListener) throws AxisFault {
		this.opNameArray = null;
		populateAxisService();
		populateFaults();
		this._serviceClient = new ServiceClient(configurationContext, this._service);
		this._serviceClient.getOptions().setTo(new EndpointReference(targetEndpoint));
		this._serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
	}

	private boolean optimizeContent(QName opName) {
		if (this.opNameArray == null)
			return false;
		for (int i = 0; i < this.opNameArray.length; i++) {
			if (opName.equals(this.opNameArray[i]))
				return true;
		}
		return false;
	}

	private OMElement toOM(GetAPPMembersDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetAPPMembersDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetAPPMembersResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetAPPMembersResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgLdapDnDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgLdapDnDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgLdapDnResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgLdapDnResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(CheckAuthWithMsgDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(CheckAuthWithMsgDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(CheckAuthWithMsgResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(CheckAuthWithMsgResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserRolesDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserRolesDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserRolesResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserRolesResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgUsersDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgUsersDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgUsersResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgUsersResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgAttributesDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgAttributesDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgAttributesResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgAttributesResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetRoleMembersDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetRoleMembersDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetRoleMembersResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetRoleMembersResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(MenuGenerator2Document param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(MenuGenerator2Document param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(MenuGenerator2ResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(MenuGenerator2ResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserWorksByAPPDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserWorksByAPPDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserWorksByAPPResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserWorksByAPPResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(CheckAuthDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(CheckAuthDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(CheckAuthResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(CheckAuthResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserRolesByAPPDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserRolesByAPPDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserRolesByAPPResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserRolesByAPPResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgAttributeDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgAttributeDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgAttributeResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgAttributeResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserAttributesDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserAttributesDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserAttributesResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserAttributesResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserAttributeDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserAttributeDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserAttributeResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserAttributeResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgDotCNameDnDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgDotCNameDnDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgDotCNameDnResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgDotCNameDnResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserAPPsDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserAPPsDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetUserAPPsResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetUserAPPsResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(MenuGenerator3Document param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(MenuGenerator3Document param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(MenuGenerator3ResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(MenuGenerator3ResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgDotDnDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgDotDnDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private OMElement toOM(GetOrgDotDnResponseDocument param, boolean optimizeContent) throws AxisFault {
		return toOM(param);
	}

	private OMElement toOM(GetOrgDotDnResponseDocument param) throws AxisFault {
		XmlOptions xmlOptions = new XmlOptions();
		xmlOptions.setSaveNoXmlDecl();
		xmlOptions.setSaveAggressiveNamespaces();
		xmlOptions.setSaveNamespacesFirst();
		OMXMLParserWrapper builder = OMXMLBuilderFactory.createOMBuilder(
				new SAXSource((XMLReader) new XmlBeansXMLReader((XmlObject) param, xmlOptions), new InputSource()));
		try {
			return builder.getDocumentElement(true);
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgDotDnDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgAttributeDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetUserAPPsDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetUserAttributesDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, CheckAuthWithMsgDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgAttributesDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgUsersDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgLdapDnDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetUserAttributeDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetUserRolesDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetOrgDotCNameDnDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetUserWorksByAPPDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, CheckAuthDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetUserRolesByAPPDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, MenuGenerator2Document param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, MenuGenerator3Document param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetRoleMembersDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory, GetAPPMembersDocument param, boolean optimizeContent,
			QName methodQName) throws AxisFault {
		SOAPEnvelope envelope = factory.getDefaultEnvelope();
		if (param != null)
			envelope.getBody().addChild((OMNode) toOM(param, optimizeContent));
		return envelope;
	}

	private SOAPEnvelope toEnvelope(SOAPFactory factory) {
		return factory.getDefaultEnvelope();
	}

	public XmlObject fromOM(OMElement param, Class type, Map extraNamespaces) throws AxisFault {
		try {
			if (GetAPPMembersDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetAPPMembersDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetAPPMembersDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetAPPMembersResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetAPPMembersResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetAPPMembersResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgLdapDnDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgLdapDnDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgLdapDnDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgLdapDnResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgLdapDnResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgLdapDnResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (CheckAuthWithMsgDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) CheckAuthWithMsgDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) CheckAuthWithMsgDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (CheckAuthWithMsgResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) CheckAuthWithMsgResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) CheckAuthWithMsgResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserRolesDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserRolesDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserRolesDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserRolesResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserRolesResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserRolesResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgUsersDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgUsersDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgUsersDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgUsersResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgUsersResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgUsersResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgAttributesDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgAttributesDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgAttributesDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgAttributesResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgAttributesResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgAttributesResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetRoleMembersDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetRoleMembersDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetRoleMembersDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetRoleMembersResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetRoleMembersResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetRoleMembersResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (MenuGenerator2Document.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) MenuGenerator2Document.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) MenuGenerator2Document.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (MenuGenerator2ResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) MenuGenerator2ResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) MenuGenerator2ResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserWorksByAPPDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserWorksByAPPDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserWorksByAPPDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserWorksByAPPResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserWorksByAPPResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserWorksByAPPResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (CheckAuthDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) CheckAuthDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) CheckAuthDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (CheckAuthResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) CheckAuthResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) CheckAuthResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserRolesByAPPDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserRolesByAPPDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserRolesByAPPDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserRolesByAPPResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserRolesByAPPResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserRolesByAPPResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgAttributeDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgAttributeDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgAttributeDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgAttributeResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgAttributeResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgAttributeResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserAttributesDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserAttributesDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserAttributesDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserAttributesResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserAttributesResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserAttributesResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserAttributeDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserAttributeDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserAttributeDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserAttributeResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserAttributeResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserAttributeResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgDotCNameDnDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgDotCNameDnDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgDotCNameDnDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgDotCNameDnResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgDotCNameDnResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgDotCNameDnResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserAPPsDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserAPPsDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserAPPsDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetUserAPPsResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetUserAPPsResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetUserAPPsResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (MenuGenerator3Document.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) MenuGenerator3Document.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) MenuGenerator3Document.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (MenuGenerator3ResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) MenuGenerator3ResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) MenuGenerator3ResponseDocument.Factory
						.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgDotDnDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgDotDnDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgDotDnDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
			if (GetOrgDotDnResponseDocument.class.equals(type)) {
				if (extraNamespaces != null)
					return (XmlObject) GetOrgDotDnResponseDocument.Factory.parse(
							param.getXMLStreamReaderWithoutCaching(),
							(new XmlOptions()).setLoadAdditionalNamespaces(extraNamespaces));
				return (XmlObject) GetOrgDotDnResponseDocument.Factory.parse(param.getXMLStreamReaderWithoutCaching());
			}
		} catch (Exception e) {
			throw AxisFault.makeFault(e);
		}
		return null;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\ws\
 * LdapWebServicesStub.class Java compiler version: 5 (49.0) JD-Core Version:
 * 1.1.3
 */