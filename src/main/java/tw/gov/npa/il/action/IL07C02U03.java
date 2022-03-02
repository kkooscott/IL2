package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;

public class IL07C02U03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07C02U03.class);
  
  private Date nowDate = new Date();
  
  private String txtUVCD;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getTxtUVCD() {
    return this.txtUVCD;
  }
  
  public void setTxtUVCD(String txtUVCD) {
    this.txtUVCD = txtUVCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07C02U03.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */