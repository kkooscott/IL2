package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class IL03D01P02 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03D01P02.class);
  
  private Date nowDate = new Date();
  
  private int RPT;
  
  public int getRPT() {
    return this.RPT;
  }
  
  public void setRPT(int rPT) {
    this.RPT = rPT;
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
    System.out.println("Which one is=" + this.RPT);
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
    } 
    return "error";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03D01P02.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */