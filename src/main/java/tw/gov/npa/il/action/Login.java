package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.util.WSUtil;

public class Login extends ActionSupport {
  private static final Logger logger = Logger.getLogger(Login.class);
  
  private WSUtil wsUtil;
  
  MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
  
  private E0dtNpaunit e0dtNpaunit = new E0dtNpaunit();
  
  private List<E0dtNpaunit> e0dtNpaunitList = new ArrayList<E0dtNpaunit>();
  //帳號
  private String username;
  //姓名
  private String usercname;
  
  private String userrole;
  //單位
  private String userdid;
  //密碼
  private String password;
  
  private String control = "0";
  
  public String getControl() {
    return this.control;
  }
  
  public void setControl(String control) {
    this.control = control;
  }
  
  public String toLogin() {
    logger.info("Enter toLogin");
    return "success";
  }
  
  public String toSimuLogin() {
    logger.info("Enter toLogin");
    return "success";
  }
  
  public String doAudit() throws Exception {
    logger.info("audit username/password: " + this.username + "/" + this.password);
    try {
      if (this.wsUtil.checkAuth(this.username, this.password)) {
        ActionContext context = ActionContext.getContext();
        String LOGUID = "", LOGUIP = "10.100.7.174", LOGDID = "", LOGDLV = "", LOGDIDCN = "", LOGCN = "", LOGPHQ = "", LOGPHQNAME = "", LOGPST = "", LOGPSTNAME = "", USERROLES = "";
        LOGUID = this.username;
        try {
          logger.info(this.wsUtil.getUserRoles(LOGUID));
          USERROLES = this.wsUtil.getUserRoles(LOGUID);
          logger.info(this.wsUtil.getUserAttribute(LOGUID, "fullName"));
          LOGCN = this.wsUtil.getUserAttribute(LOGUID, "fullName");
          LOGDID = this.wsUtil.getUserAttribute(LOGUID, "ou");
          if (!"".equals(LOGDID) && LOGDID != null) {
            this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);
            context.getSession().put("UNITFLAG", this.e0dtNpaunit.getE0UnitFlag());
            context.getSession().put("LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
          } 
          HttpServletRequest request = ServletActionContext.getRequest();
          String ipAddress = request.getHeader("X-FORWARDED-FOR");
          if (ipAddress == null)
            ipAddress = request.getRemoteAddr(); 
          LOGUIP = ipAddress;
          logger.info("wsUtil.getOrgList(LOGDID)");
          logger.info(this.wsUtil.getOrgList(LOGDID));
          String[] orgList = this.wsUtil.getOrgList(LOGDID).split("\\.", -1);
          LOGPST = orgList[1];
          LOGPHQ = orgList[2];
          logger.info("wsUtil.getOrgCnameList(LOGDID)");
          logger.info(this.wsUtil.getOrgCnameList(LOGDID));
          String[] cnameList = this.wsUtil.getOrgCnameList(LOGDID).split("\\.", -1);
          LOGDIDCN = cnameList[0];
          LOGPSTNAME = cnameList[1];
          LOGPHQNAME = cnameList[2];
        } catch (RemoteException e) {
          logger.error(e, e);
          return "error";
        } 
        context.getSession().put("LOGUID", LOGUID);
        context.getSession().put("LOGUIP", LOGUIP);
        context.getSession().put("LOGDID", LOGDID);
        context.getSession().put("LOGDIDCN", LOGDIDCN);
        context.getSession().put("LOGCN", LOGCN);
        context.getSession().put("LOGPHQ", LOGPHQ);
        context.getSession().put("LOGPHQNAME", LOGPHQNAME);
        context.getSession().put("LOGPST", LOGPST);
        context.getSession().put("LOGPSTNAME", LOGPSTNAME);
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        context.getSession().put("LOGTDT", df.format(new Date()));
        context.getSession().put("USERROLES", USERROLES);
        context.getSession().put("HTTP_LOGUID", (String)context.getSession().get("LOGUID"));
        context.getSession().put("HTTP_LOGCN", (String)context.getSession().get("LOGCN"));
        context.getSession().put("HTTP_LOGDID", (String)context.getSession().get("LOGDID"));
        context.getSession().put("HTTP_LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
        context.getSession().put("usrFlagInfo", this.e0dtNpaunit.getE0UnitFlag());
        logger.info("LOGUID:" + LOGUID + " LOGUIP:" + LOGUIP + " LOGDID:" + LOGDID + " LOGDLV:" + LOGDLV + " LOGDIDCN:" + LOGDIDCN + " LOGCN:" + LOGCN + " LOGPHQ:" + LOGPHQ + " LOGPHQNAME:" + LOGPHQNAME + " LOGPST:" + LOGPST + " LOGPSTNAME:" + LOGPSTNAME + " USERROLES:" + USERROLES);
      } else {
        setControl("N");
        return "fail";
      } 
    } catch (Exception e) {
      setControl("N");
      return "fail";
    } 
    logger.info("auth success!");
    return "success";
  }
  
  public String doSimuAudit() throws Exception {
    logger.info("audit username/password: " + this.username + "/" + this.password);
    logger.info("audit usercname/userdid: " + this.usercname + "/" + userdid);
    try {
      ActionContext context = ActionContext.getContext();
      String LOGUID = "", LOGUIP = "", LOGDID = "", LOGDLV = "", LOGDIDCN = "", LOGCN = "", LOGPHQ = "", LOGPHQNAME = "", LOGPST = "", LOGPSTNAME = "", USERROLES = "";
      LOGUID = "TESTTEST";
      LOGDID = "A1E41";
      try {
        USERROLES = this.userrole;
        LOGCN = "陳測試";
        LOGDID = this.userdid;
        LOGUIP = "127.0.0.1";
        LOGDIDCN = "警政署測試用單位";
      } catch (Exception e) {
        logger.error(e, e);
        return "error";
      } 
      context.getSession().put("LOGUID", LOGUID);
      context.getSession().put("LOGUIP", LOGUIP);
      context.getSession().put("LOGDID", LOGDID);
      if (!"".equals(LOGDID) && LOGDID != null) {
        this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);
        context.getSession().put("UNITFLAG", this.e0dtNpaunit.getE0UnitFlag());
        context.getSession().put("LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
        context.getSession().put("LOGUNITNM", this.e0dtNpaunit.getE0UnitNm());
        context.getSession().put("LOGDEPTCD", this.e0dtNpaunit.getE0DeptCd());
      } 
      context.getSession().put("LOGDIDCN", LOGDIDCN);
      context.getSession().put("LOGCN", LOGCN);
      context.getSession().put("LOGPHQ", LOGPHQ); //單位code
      context.getSession().put("LOGPHQNAME", LOGPHQNAME);
      context.getSession().put("LOGPST", LOGPST);
      context.getSession().put("LOGPSTNAME", LOGPSTNAME);
      DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
      context.getSession().put("LOGTDT", df.format(new Date()));
      context.getSession().put("USERROLES", USERROLES);
      context.getSession().put("HTTP_LOGUID", (String)context.getSession().get("LOGUID"));
      context.getSession().put("HTTP_LOGCN", (String)context.getSession().get("LOGCN"));
      context.getSession().put("HTTP_LOGDID", (String)context.getSession().get("LOGDID"));
      context.getSession().put("HTTP_LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
      context.getSession().put("usrFlagInfo", this.e0dtNpaunit.getE0UnitFlag());
    } catch (Exception e) {
      logger.error(e, e);
      setControl("N");
      return "fail";
    } 
    return "success";
  }
  
  public WSUtil getWsUtil() {
    return this.wsUtil;
  }
  
  public void setWsUtil(WSUtil wsUtil) {
    this.wsUtil = wsUtil;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getUsercname() {
    return this.usercname;
  }
  
  public void setUsercname(String usercname) {
    this.usercname = usercname;
  }
  
  public String getUserdid() {
    return this.userdid;
  }
  
  public void setUserdid(String userdid) {
    this.userdid = userdid;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setPassword(String password) {
    this.password = password;
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
  
  public String getUserrole() {
    return this.userrole;
  }
  
  public void setUserrole(String userrole) {
    this.userrole = userrole;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\Login.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */