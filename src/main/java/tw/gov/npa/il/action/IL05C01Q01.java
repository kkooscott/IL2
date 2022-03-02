package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;
import tw.gov.npa.il.myDao.IL05B03ADao;
import tw.gov.npa.il.myDao.IL07C01ADao;
import tw.gov.npa.il.myDao.IL07C01BDao;

public class IL05C01Q01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL05C01Q01.class);
  
  private Date nowDate = new Date();
  
  private String FLDTYear;
  
  private String FLDTMonth;
  
  private String FLDTDay;
  
  private String dataType;
  
  private String selectDate;
  
  private IL07C01ADao il07C01ADao;
  
  private IL07C01BDao il07C01BDao;
  
  private IL05B03ADao il05B03ADao;
  
  private Boolean hasQuery;
  
  private List<Iltb18DataProcessResult> queryList = new ArrayList<Iltb18DataProcessResult>();
  
  public Boolean getHasQuery() {
    return this.hasQuery;
  }
  
  public void setHasQuery(Boolean hasQuery) {
    this.hasQuery = hasQuery;
  }
  
  public IL07C01BDao getIl07C01BDao() {
    return this.il07C01BDao;
  }
  
  public IL05B03ADao getIl05B03ADao() {
    return this.il05B03ADao;
  }
  
  public void setIl05B03ADao(IL05B03ADao il05b03aDao) {
    this.il05B03ADao = il05b03aDao;
  }
  
  public void setIl07C01BDao(IL07C01BDao il07c01bDao) {
    this.il07C01BDao = il07c01bDao;
  }
  
  public String getSelectDate() {
    return this.selectDate;
  }
  
  public void setSelectDate(String selectDate) {
    this.selectDate = selectDate;
  }
  
  public IL07C01ADao getIl07C01ADao() {
    return this.il07C01ADao;
  }
  
  public void setIl07C01ADao(IL07C01ADao il07c01aDao) {
    this.il07C01ADao = il07c01aDao;
  }
  
  public List<Iltb18DataProcessResult> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<Iltb18DataProcessResult> queryList) {
    this.queryList = queryList;
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
  
  public String getDataType() {
    return this.dataType;
  }
  
  public void setDataType(String dataType) {
    this.dataType = dataType;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    if (this.selectDate == null || this.dataType == null) {
      logger.info("Null");
    } else if (!this.selectDate.equals("") && !this.dataType.equals("")) {
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
    logger.info("End");
    return "success";
  }
  
  public String toQuery() throws Exception {
    this.queryList.clear();
    this.hasQuery = Boolean.valueOf(true);
    HttpSession session = ServletActionContext.getRequest().getSession();
    String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session
      .getAttribute("LOGUIP").toString().trim();
    String LOGDIDCN = (session.getAttribute("LOGDIDCN") == null) ? "" : 
      session.getAttribute("LOGDIDCN").toString().trim();
    String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session
      .getAttribute("LOGUID").toString().trim();
    if (this.dataType.equals("3")) {
      logger.info(Integer.valueOf(this.queryList.size()));
      this.queryList.addAll(this.il07C01ADao.queryByDate(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, "System"));
      this.queryList.addAll(this.il07C01ADao.queryByDate(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, LOGUID));
      logger.info(Integer.valueOf(this.queryList.size()));
      this.queryList.addAll(this.il07C01BDao.queryByDate(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, "System"));
      this.queryList.addAll(this.il07C01BDao.queryByDate(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, LOGUID));
      logger.info(Integer.valueOf(this.queryList.size()));
    } else if (this.dataType.equals("4")) {
      this.queryList.addAll(this.il05B03ADao.queryByDate(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, "System"));
      this.queryList.addAll(this.il05B03ADao.queryByDate(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay, LOGUID));
    } 
    SimpleDateFormat sdfmt = new SimpleDateFormat("yyyyMMdd");
    this.nowDate = sdfmt.parse(String.valueOf(this.FLDTYear) + this.FLDTMonth + this.FLDTDay);
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL05C01Q01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */