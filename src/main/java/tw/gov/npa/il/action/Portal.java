package tw.gov.npa.il.action;

import com.google.common.base.Strings;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.util.CVUtil;
import tw.gov.npa.il.util.WSUtil;

public class Portal extends ActionSupport {
	private static final Logger logger = Logger.getLogger(Portal.class);

	MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();

	private E0dtNpaunit e0dtNpaunit = new E0dtNpaunit();

	private List<E0dtNpaunit> e0dtNpaunitList = new ArrayList<E0dtNpaunit>();

	private WSUtil wsUtil;
	
	private String notNullString(String str) {
		if ( str == null ) {
			str = "";
		}
		
		return str;
	}

	public String index() throws UnsupportedEncodingException {
		long start = System.currentTimeMillis();
		logger.info("init ");
		HttpServletRequest request = ServletActionContext.getRequest();
//		logger.info("cookie");
//		Cookie[] cookies = request.getCookies();
		String LOGUID = "", LOGUIP = "", LOGDID = "";
		String LOGDLV = "", LOGDIDCN = "", LOGCN = "";
		String LOGPHQ = "", LOGPHQNAME = "";
		String LOGPST = "", LOGPSTNAME = "";
		String USERROLES = "";
		String LOGTDT = "";
		
		// header
		logger.info("header");
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			Object obj = headerNames.nextElement();
			logger.info("HEADER: " + obj.getClass().getName() + "/" + obj.toString());
		}

		LOGUID = notNullString(request.getHeader("loguid"));
		LOGDID = notNullString(request.getHeader("logdid"));
		LOGUIP = notNullString(request.getHeader("loguip"));
		LOGPHQ = notNullString(request.getHeader("logphq"));
		LOGPST = notNullString(request.getHeader("logpst"));
		LOGDLV = notNullString(request.getHeader("logdlv"));
		LOGCN = notNullString(request.getHeader("logcn"));
		LOGTDT = notNullString(request.getHeader("logtdt"));

		if (LOGUID.equals("") || LOGDID.equals("")) {
			logger.info(LOGUID.equals("") + "/" + LOGDID.equals(""));
			logger.info("cookie");
			Cookie[] cookies = request.getCookies();
			Cookie cookie;
			String cookie_name;
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				cookie_name = cookie.getName();
				logger.info(cookie_name + "/" + cookies[i].getValue());
				if ("LOGDID".equals(cookie_name)) {
					LOGDID = cookie.getValue();
				} else if ("LOGUIP".equals(cookie_name)) {
					LOGUIP = cookie.getValue();
				} else if ("LOGUID".equals(cookie_name)) {
					LOGUID = cookie.getValue();
				} else if ("LOGPHQ".equals(cookie_name)) {
					LOGUID = cookie.getValue();
				} else if ("LOGPST".equals(cookie_name)) {
					LOGUID = cookie.getValue();
				} else if ("LOGCN".equals(cookie_name)) {
					String utf8Str = URLDecoder.decode(cookie.getValue(), "utf-8");
					LOGCN = utf8Str;
				} else if ("LOGTDT".equals(cookie_name)) {
					LOGTDT = cookie.getValue();
				} else {
					logger.info("rest :" + cookie_name + "/" + cookies[i].getValue());
				}
			}
		}
		try {
//			logger.info(this.wsUtil.getUserRoles(LOGUID));
//			USERROLES = this.wsUtil.getUserRoles(LOGUID);
//			logger.info(this.wsUtil.getUserAttribute(LOGUID, "fullName"));
//			LOGCN = this.wsUtil.getUserAttribute(LOGUID, "fullName");
//			logger.info(this.wsUtil.getOrgList(LOGDID));
//			String[] orgList = this.wsUtil.getOrgList(LOGDID).split(".", -1);
//			LOGPST = orgList[1];
//			LOGPHQ = orgList[2];
//			logger.info(this.wsUtil.getOrgCnameList(LOGDID));
//			String[] cnameList = this.wsUtil.getOrgCnameList(LOGDID).split(".", -1);
//			LOGDIDCN = cnameList[0];
//			LOGPSTNAME = cnameList[1];
//			LOGPHQNAME = cnameList[2];

			String userRoles = this.wsUtil.getUserRoles(LOGUID);
			logger.info(userRoles);
			USERROLES = userRoles;

			String userFullName = this.wsUtil.getUserAttribute(LOGUID, "fullName");
			logger.info(userFullName);
			LOGCN = userFullName;

			String orgListStr = this.wsUtil.getOrgList(LOGDID);
			logger.info(orgListStr);
			String[] orgList = orgListStr.split("\\.", -1);  // 注意點號需要用 \\ 轉義
			LOGPST = orgList[1];
			LOGPHQ = orgList[2];

			String cnameListStr = this.wsUtil.getOrgCnameList(LOGDID);
			logger.info(cnameListStr);
			String[] cnameList = cnameListStr.split("\\.", -1);
			LOGDIDCN = cnameList[0];
			LOGPSTNAME = cnameList[1];
			LOGPHQNAME = cnameList[2];
		} catch (RemoteException e) {
			logger.error(e, e);
		}
		ActionContext context = ActionContext.getContext();
		context.getSession().put("LOGUID", LOGUID);
		context.getSession().put("LOGUIP", LOGUIP);
		context.getSession().put("LOGDID", LOGDID);
		context.getSession().put("LOGDLV", LOGDLV);
		context.getSession().put("LOGDIDCN", LOGDIDCN);
		context.getSession().put("LOGUNITNM", LOGDIDCN);
		context.getSession().put("LOGCN", LOGCN);
		context.getSession().put("LOGPHQ", LOGPHQ);
		context.getSession().put("LOGPHQNAME", LOGPHQNAME);
		context.getSession().put("LOGPST", LOGPST);
		context.getSession().put("LOGPSTNAME", LOGPSTNAME);
//		if (Strings.isNullOrEmpty(LOGTDT)) {
//			logger.warn("LOGTDT is null");
//			LOGTDT = CVUtil.getCurrentTime();
//		} else {
			LOGTDT = CVUtil.getCurrentTime();
//		}
		context.getSession().put("LOGTDT", LOGTDT);
//		if (!"".equals(LOGDID) && LOGDID != null) {
//			this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);
//			context.getSession().put("UNITFLAG", this.e0dtNpaunit.getE0UnitFlag());
//			context.getSession().put("LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
//			if(this.e0dtNpaunit.getE0UnitNm()!=null) {
//				context.getSession().put("LOGDIDCN", this.e0dtNpaunit.getE0UnitNm());
//				context.getSession().put("LOGUNITNM", this.e0dtNpaunit.getE0UnitNm());
//			}
//	        context.getSession().put("LOGDEPTCD", this.e0dtNpaunit.getE0DeptCd());
//		}
		if (LOGDID != null && !"".equals(LOGDID)) {
			this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);

			// 如果 e0dtNpaunit 非空，則繼續放入 session
			if (this.e0dtNpaunit != null) {
				context.getSession().put("UNITFLAG", this.e0dtNpaunit.getE0UnitFlag());
				context.getSession().put("LOGDLV", this.e0dtNpaunit.getE0UnitLevel());

				String unitNm = this.e0dtNpaunit.getE0UnitNm();
				if (unitNm != null) {
					context.getSession().put("LOGDIDCN", unitNm);
					context.getSession().put("LOGUNITNM", unitNm);
				}

				context.getSession().put("LOGDEPTCD", this.e0dtNpaunit.getE0DeptCd());
			} else {
				logger.warn("No e0dtNpaunit found for LOGDID: " + LOGDID);
			}
		}

		context.getSession().put("USERROLES", USERROLES);
		if ("FGSBYSKM".equals(LOGUID)) {
			context.getSession().put("USERROLES", "ILN00001");
			context.getSession().put("LOGCN", "測試帳號");
		}
		context.getSession().put("HTTP_LOGUID", (String) context.getSession().get("LOGUID"));
		context.getSession().put("HTTP_LOGCN", (String) context.getSession().get("LOGCN"));
		context.getSession().put("HTTP_LOGDID", (String) context.getSession().get("LOGDID"));
		context.getSession().put("HTTP_LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
		context.getSession().put("usrFlagInfo", this.e0dtNpaunit.getE0UnitFlag());
		long end = System.currentTimeMillis();
		logger.info("process time: " + (end - start));
		return "success";
	}

	public String fakeIndex() {
		ActionContext context = ActionContext.getContext();
		context.getSession().put("LOGUID", "BLM26G63");
		context.getSession().put("LOGUIP", "10.10.10.10");
		context.getSession().put("LOGDID", "A1E31");
		context.getSession().put("LOGDLV", "1");
		context.getSession().put("LOGDIDCN", "警政署資訊室資料作業科");
		context.getSession().put("LOGCN", "陳測試");
		context.getSession().put("LOGPHQ", "A1000");
		context.getSession().put("LOGPHQNAME", "警政署");
		context.getSession().put("LOGPST", "A1E01");
		context.getSession().put("LOGPSTNAME", "警政署資訊室");
		String LOGDID = (String) context.getSession().get("LOGDID");
		if (!"".equals(LOGDID) && LOGDID != null) {
			this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);
			context.getSession().put("UNITFLAG", this.e0dtNpaunit.getE0UnitFlag());
			context.getSession().put("LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
		}
		context.getSession().put("USERROLES",
				"0Delegator,CWN00006,CWN00005,CWN00004,CWN00003,CWN00002,CWN00001,CWN00000");
		context.getSession().put("HTTP_LOGUID", (String) context.getSession().get("LOGUID"));
		context.getSession().put("HTTP_LOGCN", (String) context.getSession().get("LOGCN"));
		context.getSession().put("HTTP_LOGDID", (String) context.getSession().get("LOGDID"));
		context.getSession().put("HTTP_LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
		context.getSession().put("usrFlagInfo", this.e0dtNpaunit.getE0UnitFlag());
		context.getSession().put("LOGTDT", CVUtil.getCurrentTime());
		return "success";
	}

	public WSUtil getWsUtil() {
		return this.wsUtil;
	}

	public void setWsUtil(WSUtil wsUtil) {
		this.wsUtil = wsUtil;
	}

	public E0dtNpaunit getE0dtNpaunit() {
		return this.e0dtNpaunit;
	}

	public void setE0dtNpaunit(E0dtNpaunit e0dtNpaunit) {
		this.e0dtNpaunit = e0dtNpaunit;
	}

	public List<E0dtNpaunit> getE0dtNpaunitList() {
		return this.e0dtNpaunitList;
	}

	public void setE0dtNpaunitList(List<E0dtNpaunit> e0dtNpaunitList) {
		this.e0dtNpaunitList = e0dtNpaunitList;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\Portal.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */