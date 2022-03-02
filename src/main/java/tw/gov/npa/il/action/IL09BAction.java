package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.dao.IltbAnnounce;
import tw.gov.npa.il.entity.basic.TbAnnounce;
import tw.gov.npa.il.entity.input.cw09b.Input09B;
import tw.gov.npa.il.myDao.MyIltbAnnounceDAO;
import tw.gov.npa.il.util.DateUtils;
import tw.gov.npa.il.util.EntityUtils;

public class IL09BAction extends ActionSupport {
  private static Logger logger = Logger.getLogger(IL09BAction.class);
  
  MyIltbAnnounceDAO iltbAnnounceDAO = new MyIltbAnnounceDAO();
  
  private IltbAnnounce iltbAnnounce = new IltbAnnounce();
  
  private String no;
  
  private Map<String, String> hours;
  
  private Map<String, String> minutes;
  
  private Input09B input;
  
  private Boolean hasQuery = Boolean.valueOf(false);
  
  private List<IltbAnnounce> result;
  
  private String deleteList;
  
  private String msg = "";
  
  public String toCW09B01Q() {
    logger.info("Enter toCW09B01Q");
    return "success";
  }
  
  public String doQuery09B() {
    logger.info("Enter doQuery09B");
    logger.info("queryEntity: " + this.input.toString());
    TbAnnounce item = EntityUtils.input2Announce(this.input);
    System.out.println("item.getKind()=" + item.getKind());
    System.out.println("item.getBeginDate()=" + item.getBeginDate());
    System.out.println("item.getEndDate()=" + item.getEndDate());
    logger.info("kind:" + item.getKind());
    this.result = this.iltbAnnounceDAO.searchByQueryMethod(item.getKind(), item.getBeginDate(), item.getEndDate());
    this.hasQuery = Boolean.valueOf(true);
    logger.info("result " + this.result.toString());
    System.out.println("result=" + this.result.size());
    return "success";
  }
  
  public String toCW09B02A() {
    logger.info("Enter toCW09B02A");
    this.input.setBeginDate("");
    this.input.setEndDate("");
    this.hours = DateUtils.getTimeMap(0);
    this.minutes = DateUtils.getTimeMap(1);
    return "success";
  }
  
  public String doAdd09B() {
    logger.info("Enter doAdd09B");
    logger.info(this.input.toString());
    HttpSession session = ServletActionContext.getRequest().getSession();
    String userAccount = session.getAttribute("LOGUID").toString();
    String userName = session.getAttribute("LOGCN").toString();
    this.input.setUid(userAccount);
    this.input.setuName(userName);
    this.input.setSettingDate(DateUtils.getNowDate());
    this.input.setSettingTime(DateUtils.getNowTime());
    TbAnnounce item = EntityUtils.input2Announce(this.input);
    logger.info("add: " + item.toString());
    try {
      this.iltbAnnounce.setIlContent(item.getContent());
      this.iltbAnnounce.setIlAnnDt(item.getSettingDate());
      this.iltbAnnounce.setIlAnnTm(item.getSettingTime());
      this.iltbAnnounce.setIlAnnUid(userAccount);
      this.iltbAnnounce.setIlAnnUnm(userName);
      this.iltbAnnounce.setIlBeginDt(item.getBeginDate());
      this.iltbAnnounce.setIlBeginTm(item.getBeginTime());
      this.iltbAnnounce.setIlEndDt(item.getEndDate());
      this.iltbAnnounce.setIlEndTm(item.getEndTime());
      this.iltbAnnounce.setIlKind(item.getKind());
      this.iltbAnnounce.setIlModified(new Timestamp(System.currentTimeMillis()));
      this.iltbAnnounceDAO.update(this.iltbAnnounce);
      this.msg = "公告新增成功";
    } catch (Exception e) {
      logger.error("doAdd09B", e);
      this.msg = "公告新增失敗";
    } 
    this.hours = DateUtils.getTimeMap(0);
    this.minutes = DateUtils.getTimeMap(1);
    return "success";
  }
  
  public String toCW09B03U() {
    logger.info("Enter toCW09B03U");
    logger.info("no: " + this.no);
    HttpSession session = ServletActionContext.getRequest().getSession();
    String userAccount = session.getAttribute("LOGUID").toString();
    String userName = session.getAttribute("LOGCN").toString();
    this.iltbAnnounce = this.iltbAnnounceDAO.findById(Integer.valueOf(Integer.parseInt(this.no)));
    TbAnnounce tbAnnounce = new TbAnnounce();
    tbAnnounce.setNo(this.iltbAnnounce.getIlAnnNo().intValue());
    tbAnnounce.setBeginDate(this.iltbAnnounce.getIlBeginDt());
    tbAnnounce.setBeginTime(this.iltbAnnounce.getIlBeginTm());
    tbAnnounce.setContent(this.iltbAnnounce.getIlContent());
    tbAnnounce.setEndDate(this.iltbAnnounce.getIlEndDt());
    tbAnnounce.setEndTime(this.iltbAnnounce.getIlEndTm());
    tbAnnounce.setKind(this.iltbAnnounce.getIlKind());
    tbAnnounce.setModified(this.iltbAnnounce.getIlModified());
    tbAnnounce.setSettingDate(this.iltbAnnounce.getIlAnnDt());
    tbAnnounce.setSettingTime(this.iltbAnnounce.getIlAnnTm());
    tbAnnounce.setUid(userAccount);
    tbAnnounce.setuName(userName);
    this.input = EntityUtils.announce2Input(tbAnnounce);
    logger.info("update entity: " + this.input.toString());
    this.hours = DateUtils.getTimeMap(0);
    this.minutes = DateUtils.getTimeMap(1);
    return "success";
  }
  
  public String doUpdate09B() {
    logger.info("Enter doUpdate09B");
    this.input.setUid("BM26G63");
    this.input.setuName("陳景源");
    this.input.setSettingDate(DateUtils.getNowDate());
    this.input.setSettingTime(DateUtils.getNowTime());
    TbAnnounce item = EntityUtils.input2Announce(this.input);
    logger.info("update: " + item.toString());
    HttpSession session = ServletActionContext.getRequest().getSession();
    String userAccount = session.getAttribute("LOGUID").toString();
    String userName = session.getAttribute("LOGCN").toString();
    try {
      System.out.println("input.getNo()=" + this.input.getNo());
      this.iltbAnnounce = this.iltbAnnounceDAO.findById(Integer.valueOf(this.input.getNo()));
      this.iltbAnnounce.setIlContent(this.input.getContent());
      this.iltbAnnounce.setIlAnnDt(item.getSettingDate());
      this.iltbAnnounce.setIlAnnTm(item.getSettingTime());
      this.iltbAnnounce.setIlAnnUid(userAccount);
      this.iltbAnnounce.setIlAnnUnm(userName);
      this.iltbAnnounce.setIlBeginDt(item.getBeginDate());
      this.iltbAnnounce.setIlBeginTm(item.getBeginTime());
      this.iltbAnnounce.setIlEndDt(item.getEndDate());
      this.iltbAnnounce.setIlEndTm(item.getEndTime());
      this.iltbAnnounce.setIlKind(item.getKind());
      this.iltbAnnounce.setIlModified(new Timestamp(System.currentTimeMillis()));
      this.iltbAnnounceDAO.update(this.iltbAnnounce);
      this.msg = "公告更新成功";
    } catch (Exception e) {
      logger.error("doUpdate09B", e);
      this.msg = "公告更新失敗";
    } 
    this.hours = DateUtils.getTimeMap(0);
    this.minutes = DateUtils.getTimeMap(1);
    return "success";
  }
  
  public String doDelete09B() {
    logger.info("Enter doDelete09B");
    logger.info("deleteList: " + this.deleteList);
    String[] items = this.deleteList.split(",");
    logger.info("items len: " + items.length);
    try {
      for (int i = 0; i < items.length; i++) {
        logger.info("delete item no: " + items[i]);
        this.iltbAnnounce = this.iltbAnnounceDAO.findById(Integer.valueOf(Integer.parseInt(items[i])));
        this.iltbAnnounceDAO.del(this.iltbAnnounce);
      } 
      this.msg = "刪除公告成功";
    } catch (Exception e) {
      logger.error("doDelete09B", e);
      this.msg = "刪除公告失敗";
    } 
    return "success";
  }
  
  public String getNo() {
    return this.no;
  }
  
  public void setNo(String no) {
    this.no = no;
  }
  
  public Boolean getHasQuery() {
    return this.hasQuery;
  }
  
  public void setHasQuery(Boolean hasQuery) {
    this.hasQuery = hasQuery;
  }
  
  public List<IltbAnnounce> getResult() {
    return this.result;
  }
  
  public void setResult(List<IltbAnnounce> result) {
    this.result = result;
  }
  
  public String getDeleteList() {
    return this.deleteList;
  }
  
  public void setDeleteList(String deleteList) {
    this.deleteList = deleteList;
  }
  
  public Map<String, String> getHours() {
    return this.hours;
  }
  
  public void setHours(Map<String, String> hours) {
    this.hours = hours;
  }
  
  public Map<String, String> getMinutes() {
    return this.minutes;
  }
  
  public void setMinutes(Map<String, String> minutes) {
    this.minutes = minutes;
  }
  
  public String getMsg() {
    return this.msg;
  }
  
  public void setMsg(String msg) {
    this.msg = msg;
  }
  
  public Input09B getInput() {
    return this.input;
  }
  
  public void setInput(Input09B input) {
    this.input = input;
  }
  
  public IltbAnnounce getIltbAnnounce() {
    return this.iltbAnnounce;
  }
  
  public void setIltbAnnounce(IltbAnnounce iltbAnnounce) {
    this.iltbAnnounce = iltbAnnounce;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL09BAction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */