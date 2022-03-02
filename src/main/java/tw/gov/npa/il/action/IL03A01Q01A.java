package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class IL03A01Q01A extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL03A01Q01A.class);
  
  private Date nowDate = new Date();
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String toMain() throws Exception {
    HttpSession session = ServletActionContext.getRequest().getSession();
    session.setAttribute("flag", "R");
    session.setAttribute("ilArcno", "");
    session.setAttribute("ilMicro", "");
    session.setAttribute("ilRepmdc", "");
    session.setAttribute("ilRepmdcNic", "");
    return "success";
  }
  
  public String toQuery() throws Exception {
    return "success";
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q01A.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */