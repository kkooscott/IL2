package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.util.Date;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.IlScheduleMngId;
import tw.gov.npa.il.myDao.MyIlScheduleDAO;

public class IL08A01U01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL08A01U01.class);
  
  private String dataFileYear;
  
  private String dataFileMonth;
  
  private String dataFileDay;
  
  private Date nowDate = new Date();
  
  private MyIlScheduleDAO myIlScheduleDAO;
  
  private String dataFilePassword;
  
  private String importstatus;
  
  public MyIlScheduleDAO getMyIlScheduleDAO() {
    return this.myIlScheduleDAO;
  }
  
  public void setMyIlScheduleDAO(MyIlScheduleDAO myIlScheduleDAO) {
    this.myIlScheduleDAO = myIlScheduleDAO;
  }
  
  public String getImportstatus() {
    return this.importstatus;
  }
  
  public void setImportstatus(String importstatus) {
    this.importstatus = importstatus;
  }
  
  public String getDataFilePassword() {
    return this.dataFilePassword;
  }
  
  public void setDataFilePassword(String dataFilePassword) {
    this.dataFilePassword = dataFilePassword;
  }
  
  public String getDataFileYear() {
    return this.dataFileYear;
  }
  
  public void setDataFileYear(String dataFileYear) {
    this.dataFileYear = dataFileYear;
  }
  
  public String getDataFileMonth() {
    return this.dataFileMonth;
  }
  
  public void setDataFileMonth(String dataFileMonth) {
    this.dataFileMonth = dataFileMonth;
  }
  
  public String getDataFileDay() {
    return this.dataFileDay;
  }
  
  public void setDataFileDay(String dataFileDay) {
    this.dataFileDay = dataFileDay;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    if (this.dataFileYear == null || this.dataFileMonth == null || this.dataFilePassword == null) {
      logger.info("Null");
    } else if (!this.dataFileYear.equals("") && !this.dataFileMonth.equals("") && !this.dataFilePassword.equals("")) {
      toQuery();
    } 
    return "success";
  }
  
  public String toQuery() throws Exception {
    int month = Integer.parseInt(this.dataFileMonth);
    if (month < 10)
      this.dataFileMonth = "0" + month; 
    IlScheduleMngId ilScheduleMngId = new IlScheduleMngId();
    ilScheduleMngId.setSgroup("im");
    ilScheduleMngId.setMuserName(String.valueOf(this.dataFileYear) + this.dataFileMonth + 
        this.dataFilePassword);
    ilScheduleMngId.setStime(new Timestamp((new Date()).getTime()));
    ilScheduleMngId.setSgroup("01");
    ilScheduleMngId.setType("1");
    ilScheduleMngId.setStatus("0");
    this.myIlScheduleDAO.insert(ilScheduleMngId);
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL08A01U01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */