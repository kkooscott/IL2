package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class IL04A01Q03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL04A01Q03.class);
  
  private Date nowDate = new Date();
  
  private int RPT;
  
  private int RPT2;
  
  public int getRPT() {
    return this.RPT;
  }
  
  public void setRPT(int rPT) {
    this.RPT = rPT;
  }
  
  public int getRPT2() {
    return this.RPT2;
  }
  
  public void setRPT2(int rPT2) {
    this.RPT2 = rPT2;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    HttpServletRequest request = ServletActionContext.getRequest();
    this.RPT = Integer.parseInt(request.getAttribute("RPT").toString());
    this.RPT2 = Integer.parseInt(request.getAttribute("RPT2").toString());
    switch (this.RPT) {
      case 1:
        return "report1";
      case 2:
        return "report2";
      case 3:
        return "report3";
      case 4:
        return "report4";
      case 5:
        return "report5";
      case 6:
        return "report6";
      case 7:
        return "report7";
      case 8:
        return "report8";
      case 9:
        return "report9";
      case 10:
        return "report10";
      case 11:
        return "report11";
      case 12:
        return "report12";
      case 13:
        return "report13";
      case 14:
        return "report14";
      case 15:
        return "report15";
    } 
    return "error";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL04A01Q03.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */