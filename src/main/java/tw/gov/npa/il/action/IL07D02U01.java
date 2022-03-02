package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import org.apache.log4j.Logger;

public class IL07D02U01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07D02U01.class);
  
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
}
