package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;

public class IL07B02U03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07B02U03.class);
  
  private Date nowDate = new Date();
  
  private String txtOPCD;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getTxtOPCD() {
    return this.txtOPCD;
  }
  
  public void setTxtOPCD(String txtOPCD) {
    this.txtOPCD = txtOPCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07B02U03.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */