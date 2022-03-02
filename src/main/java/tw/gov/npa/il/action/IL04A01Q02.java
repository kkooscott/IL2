package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb20OnlineReport;

public class IL04A01Q02 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL04A01Q02.class);
  
  private List<Iltb20OnlineReport> iltb20IdList;
  
  private Date nowDate = new Date();
  
  private String chooseDay;
  
  private int RPT;
  
  public String getChooseDay() {
    return this.chooseDay;
  }
  
  public void setChooseDay(String chooseDay) {
    this.chooseDay = chooseDay;
  }
  
  public int getRPT() {
    return this.RPT;
  }
  
  public void setRPT(int rPT) {
    this.RPT = rPT;
  }
  
  public List<Iltb20OnlineReport> getIltb20IdList() {
    return this.iltb20IdList;
  }
  
  public void setIltb20IdList(List<Iltb20OnlineReport> iltb20IdList) {
    this.iltb20IdList = iltb20IdList;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04A01Q02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */