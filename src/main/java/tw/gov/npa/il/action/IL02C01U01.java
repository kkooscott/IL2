package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.action.bean.NpaZipCodeBean;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.util.NTPCUtil;

public class IL02C01U01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL02C01U01.class);
  
  NTPCUtil ntpcUtil = new NTPCUtil();
  
  MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
  
  private List<E0dtNpaunit> e0dtNpaunitList = new ArrayList<E0dtNpaunit>();
  
  List<NpaZipCodeBean> npaZipCodeBeanList = new ArrayList<NpaZipCodeBean>();
  
  private Date nowDate = new Date();
  
  private String e0UnitCd;
  
  private String flag;
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public String getFlag() {
    return this.flag;
  }
  
  public void setFlag(String flag) {
    this.flag = flag;
  }
  
  public String getE0UnitCd() {
    return this.e0UnitCd;
  }
  
  public void setE0UnitCd(String e0UnitCd) {
    this.e0UnitCd = e0UnitCd;
  }
  
  public List<NpaZipCodeBean> getNpaZipCodeBeanList() {
    return this.npaZipCodeBeanList;
  }
  
  public void setNpaZipCodeBeanList(List<NpaZipCodeBean> npaZipCodeBeanList) {
    this.npaZipCodeBeanList = npaZipCodeBeanList;
  }
  
  public List<E0dtNpaunit> getE0dtNpaunitList() {
    return this.e0dtNpaunitList;
  }
  
  public void setE0dtNpaunitList(List<E0dtNpaunit> e0dtNpaunitList) {
    this.e0dtNpaunitList = e0dtNpaunitList;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    HttpSession session = ServletActionContext.getRequest().getSession();
    String usrFlagInfo = (session.getAttribute("usrFlagInfo") == null) ? "0" : session.getAttribute("usrFlagInfo").toString().trim();
    String httpLogDid = (session.getAttribute("HTTP_LOGDID") == null) ? "0" : session.getAttribute("HTTP_LOGDID").toString().trim();
    logger.info("httpLogDid=" + httpLogDid);
    try {
      if (usrFlagInfo.equals("90") || usrFlagInfo.equals("91") || usrFlagInfo.equals("92")) {
        this.e0dtNpaunitList = this.myE0dtNpaunitDAO.getDataByE0UnitFlag("10", "");
      } else if (usrFlagInfo.equals("10") || usrFlagInfo.equals("21") || usrFlagInfo.equals("22") || usrFlagInfo.equals("31")) {
        this.e0dtNpaunitList = this.myE0dtNpaunitDAO.getDataByE0UnitFlag("10", "");
      } 
      logger.info("e0dtNpaunitList.size()=" + this.e0dtNpaunitList.size());
      if (this.e0dtNpaunitList.size() > 0)
        this.e0UnitCd = ((E0dtNpaunit)this.e0dtNpaunitList.get(0)).getE0UnitCd(); 
    } catch (Exception e) {
      logger.error(e, e);
      e.printStackTrace();
      return "error";
    } 
    return "success";
  }
  
  public String toGetZipCode() throws Exception {
    System.out.println("警局=" + this.e0UnitCd);
    try {
      String[] names = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(this.e0UnitCd);
      ActionContext context = ActionContext.getContext();
      HttpServletRequest request = (HttpServletRequest)context.get("com.opensymphony.xwork2.dispatcher.HttpServletRequest");
      String contextPath = request.getSession().getServletContext().getRealPath("/");
      List<NpaZipCodeBean> npaZipCodeBeanAllList = this.ntpcUtil.getNpaZipCodeBeanList(contextPath);
      if (names != null)
        for (String name : names) {
          for (NpaZipCodeBean e : npaZipCodeBeanAllList) {
            if (name.equals(e.getKT_DID()))
              this.npaZipCodeBeanList.add(e); 
          } 
        }  
    } catch (Exception e) {
      logger.error(e, e);
      e.printStackTrace();
      return "error";
    } 
    if ("IL02C01U01".equals(this.flag))
      return "IL02C01U01"; 
    if ("IL03B01P00".equals(this.flag))
      return "IL03B01P00"; 
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL02C01U01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */