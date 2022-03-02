package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;

public class IL07D02U03 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07D02U03.class);
  
  private Date nowDate = new Date();
  
  private String txtSRCHST;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public String getTxtSRCHST() {
    return this.txtSRCHST;
  }
  
  public void setTxtSRCHST(String txtSRCHST) {
    this.txtSRCHST = txtSRCHST;
  }
}
