package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;

public class IL07A02U03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07A02U03.class);
  
  private String txtNTCD;
  
  private Date nowDate = new Date();
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getTxtNTCD() {
    return this.txtNTCD;
  }
  
  public void setTxtNTCD(String txtNTCD) {
    this.txtNTCD = txtNTCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07A02U03.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */