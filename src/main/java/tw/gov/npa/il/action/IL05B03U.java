package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.IL05B03ADao;

public class IL05B03U extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL05B03U.class);
  
  private Date nowDate = new Date();
  
  private String FLDTYear;
  
  private String FLDTMonth;
  
  private String FLDTDay;
  
  private IL05B03ADao il05B03ADao;
  
  private String selectDate;
  
  public String getSelectDate() {
    return this.selectDate;
  }
  
  public void setSelectDate(String selectDate) {
    this.selectDate = selectDate;
  }
  
  public IL05B03ADao getIl05B03ADao() {
    return this.il05B03ADao;
  }
  
  public void setIl05B03ADao(IL05B03ADao il05b03aDao) {
    this.il05B03ADao = il05b03aDao;
  }
  
  public String getFLDTYear() {
    return this.FLDTYear;
  }
  
  public void setFLDTYear(String fLDTYear) {
    this.FLDTYear = fLDTYear;
  }
  
  public String getFLDTMonth() {
    return this.FLDTMonth;
  }
  
  public void setFLDTMonth(String fLDTMonth) {
    this.FLDTMonth = fLDTMonth;
  }
  
  public String getFLDTDay() {
    return this.FLDTDay;
  }
  
  public void setFLDTDay(String fLDTDay) {
    this.FLDTDay = fLDTDay;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    if (this.selectDate == null) {
      logger.info("Null");
    } else if (!this.selectDate.equals("")) {
      logger.info("DATE!!!!!" + this.selectDate);
      this.FLDTYear = this.selectDate.substring(0, 4);
      this.FLDTMonth = this.selectDate.substring(5, 7);
      this.FLDTDay = this.selectDate.substring(8, 10);
      int Month = Integer.parseInt(this.FLDTMonth);
      int Day = Integer.parseInt(this.FLDTDay);
      if (Month < 10)
        this.FLDTMonth = "0" + Month; 
      if (Day < 10)
        this.FLDTDay = "0" + Day; 
      logger.info("new record");
      toQuery();
    } 
    return "success";
  }
  
  public String toQuery() throws Exception {
    HttpSession session = ServletActionContext.getRequest().getSession();
    String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session
      .getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session.getAttribute("LOGDIDCN") == null) ? "" : 
      session.getAttribute("LOGDIDCN").toString().trim();
    String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session
      .getAttribute("LOGUID").toString().trim();
    if (this.il05B03ADao.queryCountbyKey(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, "T") > 0) {
      this.il05B03ADao.updateStatusBykey(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, "T", LOGUID);
    } else {
      logger.info(LOGUID);
      logger.info(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay);
      this.il05B03ADao.insertLog(LOGUID, String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay);
    } 
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL05B03U.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */