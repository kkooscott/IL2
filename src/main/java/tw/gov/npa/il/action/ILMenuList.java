package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import tw.gov.npa.il.action.bean.Menu;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.util.CVUtil;
import tw.gov.npa.il.util.MiscMain;

public class ILMenuList extends ActionSupport {
  private static final Logger logger = Logger.getLogger(ILMenuList.class);
  
  private MiscMain miscMain = new MiscMain();
  
  private List<Menu> getMenuList = new ArrayList<Menu>();
  
  private List<String> sByTitleId = new ArrayList<String>();
  
  MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
  
  private E0dtNpaunit e0dtNpaunit = new E0dtNpaunit();
  
  private List<E0dtNpaunit> e0dtNpaunitList = new ArrayList<E0dtNpaunit>();
  
//  ResourceBundle rb = ResourceBundle.getBundle("config");
//
//  String changeMode = this.rb.getString("changeMode").toString();

  String changeMode = "1";
  
  public List<Menu> getGetMenuList() {
    return this.getMenuList;
  }
  
  public String getChangeMode() {
    return this.changeMode;
  }
  
  public void setChangeMode(String changeMode) {
    this.changeMode = changeMode;
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
  
  public void setGetMenuList(List<Menu> getMenuList) {
    this.getMenuList = getMenuList;
  }
  
  public List<String> getsByTitleId() {
    return this.sByTitleId;
  }
  
  public void setsByTitleId(List<String> sByTitleId) {
    this.sByTitleId = sByTitleId;
  }
  
  public String toILMenuList() throws Exception {
    return "success";
  }
  
  public String toMain() throws Exception {
    logger.info("menulist toMain() start");
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    ActionContext context = ActionContext.getContext();
    if (!"1".equals(this.changeMode)) {
      logger.info("資策會測試session");
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
      context.getSession().put("LOGTDT", CVUtil.getCurrentTime());
      String LOGDID = (String)context.getSession().get("LOGDID");
      this.e0dtNpaunit = this.myE0dtNpaunitDAO.findById(LOGDID);
      context.getSession().put("UNITFLAG", this.e0dtNpaunit.getE0UnitFlag());
      context.getSession().put("LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
      context.getSession().put("USERROLES", "0Delegator,ILN00001,ILN00002,ILN00004");
      context.getSession().put("HTTP_LOGUID", (String)context.getSession().get("LOGUID"));
      context.getSession().put("HTTP_LOGCN", (String)context.getSession().get("LOGCN"));
      context.getSession().put("HTTP_LOGDID", (String)context.getSession().get("LOGDID"));
      context.getSession().put("HTTP_LOGDLV", this.e0dtNpaunit.getE0UnitLevel());
      context.getSession().put("usrFlagInfo", this.e0dtNpaunit.getE0UnitFlag());
    } 
    String tmpRoles = (String)context.getSession().get("USERROLES");
    logger.info("tmpRoles: " + tmpRoles);

//    if (null != tmpRoles) {
//      logger.info("----tmpRoles is not null----");
//      String[] tmp = tmpRoles.split(",");
//      if (null != tmp) {
//        for (int i = 0; i < tmp.length; i++)
//          this.sByTitleId.add(tmp[i]);
//      } else {
//        this.sByTitleId.add("ILN00004");
//      }
//    } else {
//      this.sByTitleId.add("ILN00004");
//    }
    if (null != tmpRoles) {
      logger.info("----tmpRoles is not null----");
      String[] tmp = tmpRoles.split(",");
      if (null != tmp) {
        for (int i = 0; i < tmp.length; i++)
          this.sByTitleId.add(tmp[i]);
      } else {
        this.sByTitleId.add("ILN00001");
      }
    } else {
      this.sByTitleId.add("ILN00001");
    }
    try {
      this.getMenuList = MiscMain.getMenuList(true, this.sByTitleId);
    } catch (Exception e) {
      logger.error(e, e);
      e.printStackTrace();
      return "error";
    } 
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\ILMenuList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */