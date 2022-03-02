package tw.gov.npa.il.util;

import com.google.common.base.Joiner;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import npa.ldap.ws.Attr;
import npa.ldap.ws.AttrSet;
import npa.ldap.ws.CheckAuth;
import npa.ldap.ws.CheckAuthDocument;
import npa.ldap.ws.CheckAuthResponseDocument;
import npa.ldap.ws.GetOrgAttribute;
import npa.ldap.ws.GetOrgAttributeDocument;
import npa.ldap.ws.GetOrgAttributeResponseDocument;
import npa.ldap.ws.GetOrgDotCNameDn;
import npa.ldap.ws.GetOrgDotCNameDnDocument;
import npa.ldap.ws.GetOrgDotCNameDnResponseDocument;
import npa.ldap.ws.GetOrgDotDn;
import npa.ldap.ws.GetOrgDotDnDocument;
import npa.ldap.ws.GetOrgDotDnResponseDocument;
import npa.ldap.ws.GetUserAttribute;
import npa.ldap.ws.GetUserAttributeDocument;
import npa.ldap.ws.GetUserAttributeResponseDocument;
import npa.ldap.ws.GetUserRoles;
import npa.ldap.ws.GetUserRolesDocument;
import npa.ldap.ws.GetUserRolesResponseDocument;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.log4j.Logger;
import tw.gov.npa.il.ws.LdapWebServicesStub;
import tw.gov.npa.il.ws.OEWebServiceStub;

public class WSUtil {
	private static final Logger logger = Logger.getLogger(WSUtil.class);

	ResourceBundle rb = ResourceBundle.getBundle("config");
	
	String url = rb.getString("ldapURL").toString();

	String _USERNAME = rb.getString("ldapUSER").toString();

	String _PASSWORD = rb.getString("ldapPASS").toString();

	String OE_USERNAME = rb.getString("ldapOEUSER").toString();

	String OE_PASSWORD = rb.getString("ldapOEPASS").toString();

	public boolean checkAuth(String username, String password) throws RemoteException {
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this._USERNAME);
		basicAuth.setPassword(this._PASSWORD);
		basicAuth.setPreemptiveAuthentication(true);
		LdapWebServicesStub stub = new LdapWebServicesStub();
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		CheckAuthDocument reqDoc = CheckAuthDocument.Factory.newInstance();
		CheckAuth req = reqDoc.addNewCheckAuth();
		req.setArg0(username);
		req.setArg1(password);
		CheckAuthResponseDocument doc = stub.checkAuth(reqDoc);
		return doc.getCheckAuthResponse().getReturn();
	}

	public String getOrgList(String org) throws RemoteException {
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this._USERNAME);
		basicAuth.setPassword(this._PASSWORD);
		basicAuth.setPreemptiveAuthentication(true);
		LdapWebServicesStub stub = new LdapWebServicesStub();
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		GetOrgDotDnDocument reqDoc = GetOrgDotDnDocument.Factory.newInstance();
		GetOrgDotDn req = reqDoc.addNewGetOrgDotDn();
		req.setArg0(org);
		GetOrgDotDnResponseDocument doc = stub.getOrgDotDn(reqDoc);
		String str = doc.getGetOrgDotDnResponse().getReturn();
		return str;
	}

	public String getOrgCnameList(String org) throws RemoteException {
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this._USERNAME);
		basicAuth.setPassword(this._PASSWORD);
		basicAuth.setPreemptiveAuthentication(true);
		LdapWebServicesStub stub = new LdapWebServicesStub();
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		GetOrgDotCNameDnDocument reqDoc = GetOrgDotCNameDnDocument.Factory.newInstance();
		GetOrgDotCNameDn req = reqDoc.addNewGetOrgDotCNameDn();
		req.setArg0(org);
		GetOrgDotCNameDnResponseDocument doc = stub.getOrgDotCNameDn(reqDoc);
		String str = doc.getGetOrgDotCNameDnResponse().getReturn();
		return str;
	}

	public String getOrgAttribute(String org, String attr) throws RemoteException {
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this._USERNAME);
		basicAuth.setPassword(this._PASSWORD);
		basicAuth.setPreemptiveAuthentication(true);
		LdapWebServicesStub stub = new LdapWebServicesStub();
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		GetOrgAttributeDocument reqDoc = GetOrgAttributeDocument.Factory.newInstance();
		GetOrgAttribute req = reqDoc.addNewGetOrgAttribute();
		req.setArg0(org);
		req.setArg1(attr);
		GetOrgAttributeResponseDocument doc = stub.getOrgAttribute(reqDoc);
		Attr att = doc.getGetOrgAttributeResponse().getReturn();
		String[] str = att.getValuesArray();
		Joiner joiner = Joiner.on(",");
		logger.info(joiner.join((Object[]) str));
		return str[0];
	}

	public String getUserAttribute(String account, String attr) throws RemoteException {
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this._USERNAME);
		basicAuth.setPassword(this._PASSWORD);
		basicAuth.setPreemptiveAuthentication(true);
		LdapWebServicesStub stub = new LdapWebServicesStub();
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		GetUserAttributeDocument reqDoc = GetUserAttributeDocument.Factory.newInstance();
		GetUserAttribute req = reqDoc.addNewGetUserAttribute();
		req.setArg0(account);
		req.setArg1(attr);
		GetUserAttributeResponseDocument doc = stub.getUserAttribute(reqDoc);
		Attr att = doc.getGetUserAttributeResponse().getReturn();
		String[] str = att.getValuesArray();
		Joiner joiner = Joiner.on(",");
		logger.info(joiner.join((Object[]) str));
		return str[0];
	}

	public String getUserRoles(String account) throws RemoteException {
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this._USERNAME);
		basicAuth.setPassword(this._PASSWORD);
		basicAuth.setPreemptiveAuthentication(true);
		LdapWebServicesStub stub = new LdapWebServicesStub();
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		GetUserRolesDocument reqDoc = GetUserRolesDocument.Factory.newInstance();
		GetUserRoles req = reqDoc.addNewGetUserRoles();
		req.setArg0(account);
		GetUserRolesResponseDocument doc = stub.getUserRoles(reqDoc);
		AttrSet[] attrSets = doc.getGetUserRolesResponse().getReturnArray();
		AttrSet attrSet = null;
		String name = "";
		List<String> strs = new ArrayList<String>();
		for (int i = 0; i < attrSets.length; i++) {
			attrSet = attrSets[i];
			Attr[] attrs = attrSet.getAttributesArray();
			for (int j = 0; j < attrs.length; j++) {
				Attr attr = attrs[j];
				name = attr.getName();
				if ("cn".equals(name))
					strs.add(attr.getValuesArray(0));
			}
		}
		Joiner joiner = Joiner.on(",").skipNulls();
		return joiner.join(strs);
	}

	public String getCUnitInfo1(String usr, String unit, String cityNm, String townNm, String lin, String village)
			throws RemoteException {
		logger.info("usr: " + usr + ", unit: " + unit + ", cityNm: " + cityNm + ", townNm" + ", lin: " + lin
				+ ", village: " + village);
		String url = "http://10.100.163.25:7001/Webservice/OE/OEInfo";
		String rv = "";
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this.OE_USERNAME);
		basicAuth.setPassword(this.OE_PASSWORD);
		basicAuth.setPreemptiveAuthentication(false);
		OEWebServiceStub stub = new OEWebServiceStub(url);
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		OEWebServiceStub.OEServiceDaMain req = new OEWebServiceStub.OEServiceDaMain();
		req.setSystemID("CW");
		req.setSystemPWD("CW");
		req.setSSOunitID(usr);
		req.setSSOuserID(unit);
		req.setCityNm(cityNm);
		req.setLin(townNm);
		req.setTownNm(lin);
		req.setVillage(village);
		OEWebServiceStub.OEServiceDaMainResponse response = stub.oEServiceDaMain(req);
		logger.info(response.get_return());
		rv = response.get_return();
		return rv;
	}

	public String getCUnitInfo2(String usr, String unit, String cityNm, String townNm) throws RemoteException {
		String url = "http://10.100.163.25:7001/Webservice/OE/OEInfo";
		logger.info("usr: " + usr + ", unit: " + unit + ", cityNm: " + cityNm + ", townNm");
		String rv = "";
		HttpTransportProperties.Authenticator basicAuth = new HttpTransportProperties.Authenticator();
		basicAuth.setUsername(this.OE_USERNAME);
		basicAuth.setPassword(this.OE_PASSWORD);
		basicAuth.setPreemptiveAuthentication(false);
		OEWebServiceStub stub = new OEWebServiceStub(url);
		Options clientOptions = stub._getServiceClient().getOptions();
		clientOptions.setProperty("_NTLM_DIGEST_BASIC_AUTHENTICATION_", basicAuth);
		OEWebServiceStub.OEServiceDaMain2 req = new OEWebServiceStub.OEServiceDaMain2();
		req.setSystemID("CW");
		req.setSystemPWD("CW");
		req.setSSOunitID(usr);
		req.setSSOuserID(unit);
		req.setCityNm(cityNm);
		req.setTownNm(townNm);
		OEWebServiceStub.OEServiceDaMain2Response response = stub.oEServiceDaMain2(req);
		logger.info(response.get_return());
		rv = response.get_return();
		return rv;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\WSUtil.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */