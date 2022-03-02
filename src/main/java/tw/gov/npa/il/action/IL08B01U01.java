package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.IlScheduleMngId;
import tw.gov.npa.il.entity.IL08A02;
import tw.gov.npa.il.myDao.MyIlScheduleDAO;
import tw.gov.npa.il.schedule.AsycReportExecutor;

public class IL08B01U01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL08B01U01.class);
  
  private Date nowDate = new Date();
  
  private String startDate;
  
  private String endDate;
  
  private String ddlKIND;
  
  private String sid;
  
  private List<IlScheduleMngId> queryList = new ArrayList<IlScheduleMngId>();
  
  private Boolean hasQuery;
  
  private MyIlScheduleDAO myIlScheduleDAO;
  
  private AsycReportExecutor asycReportExecutor;
  
  public String getSid() {
    return this.sid;
  }
  
  public void setSid(String sid) {
    this.sid = sid;
  }
  
  public String toMain() throws Exception {
    if (this.startDate != null && this.endDate != null)
      doRealQuery(); 
    return "success";
  }
  
  public MyIlScheduleDAO getMyIlScheduleDAO() {
    return this.myIlScheduleDAO;
  }
  
  public void setMyIlScheduleDAO(MyIlScheduleDAO myIlScheduleDAO) {
    this.myIlScheduleDAO = myIlScheduleDAO;
  }
  
  public String doQuery() throws Exception {
    logger.info("doQuery");
    logger.info(this.startDate);
    logger.info(this.endDate);
    this.queryList = this.myIlScheduleDAO.queryByDate(this.startDate.replace("/", ""), this.endDate.replace("/", ""), this.ddlKIND);
    doRealQuery();
    return "success";
  }
  
  public String doRestart() throws Exception {
    logger.info("do restart");
    logger.info(this.startDate);
    logger.info(this.endDate);
    logger.info(this.ddlKIND);
    if (!this.sid.equals("") && this.sid != null) {
      this.myIlScheduleDAO.updateStatus(Integer.parseInt(this.sid.trim()), "0");
      doRealQuery();
      logger.info("finished restart");
    } 
    return "success";
  }
  
  public String doStop() {
    this.myIlScheduleDAO.updateStatus(Integer.parseInt(this.sid), "6");
    return "success";
  }
  
  public String doDetail() throws Exception {
    return "success";
  }
  
  private void doRealQuery() {
    this.hasQuery = Boolean.valueOf(true);
    IL08A02 cv08A02 = new IL08A02();
    this.queryList = this.myIlScheduleDAO.queryByDate(this.startDate, this.endDate);
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getStartDate() {
    return this.startDate;
  }
  
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  
  public String getEndDate() {
    return this.endDate;
  }
  
  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }
  
  public String getddlKIND() {
    return this.ddlKIND;
  }
  
  public void setddlKIND(String ddlKIND) {
    this.ddlKIND = ddlKIND;
  }
  
  public List<IlScheduleMngId> getQueryList() {
    return this.queryList;
  }
  
  public void setQueryList(List<IlScheduleMngId> queryList) {
    this.queryList = queryList;
  }
  
  public Boolean getHasQuery() {
    return this.hasQuery;
  }
  
  public void setHasQuery(Boolean hasQuery) {
    this.hasQuery = hasQuery;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL08B01U01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */