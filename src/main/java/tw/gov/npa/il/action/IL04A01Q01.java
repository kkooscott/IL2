package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;
import tw.gov.npa.il.util.GetDateUtil;

public class IL04A01Q01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL04A01Q01.class);
  
  GetDateUtil getDateUtil = new GetDateUtil();
  
  private Date nowDate = new Date();
  
  private int nowYear;
  
  private int nowMonth;
  
  private int nowDay;
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public GetDateUtil getGetDateUtil() {
    return this.getDateUtil;
  }
  
  public void setGetDateUtil(GetDateUtil getDateUtil) {
    this.getDateUtil = getDateUtil;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public int getNowYear() {
    return this.nowYear;
  }
  
  public void setNowYear(int nowYear) {
    this.nowYear = nowYear;
  }
  
  public int getNowMonth() {
    return this.nowMonth;
  }
  
  public void setNowMonth(int nowMonth) {
    this.nowMonth = nowMonth;
  }
  
  public String toMain() throws Exception {
    this.nowYear = this.getDateUtil.getNowDate()[0];
    this.nowMonth = this.getDateUtil.getNowDate()[1];
    this.nowDay = this.nowDate.getDay();
    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04A01Q01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */