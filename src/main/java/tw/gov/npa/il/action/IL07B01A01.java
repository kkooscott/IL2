package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.IL07BDao;

public class IL07B01A01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07B01A01.class);
  
  private Date nowDate = new Date();
  
  private IL07BDao il07BDao;
  
  private String txtOPCD;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public void doCheck() throws Exception {
    String content = this.il07BDao.queryData(this.txtOPCD);
    logger.info(content);
    HttpServletResponse response = ServletActionContext.getResponse();
    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    response.setHeader("Charset", "UTF-8");
    try {
      response.getWriter().write(content);
    } catch (IOException e) {
      e.printStackTrace();
    } 
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
  
  public IL07BDao getIl07BDao() {
    return this.il07BDao;
  }
  
  public void setIl07BDao(IL07BDao il07bDao) {
    this.il07BDao = il07bDao;
  }
  
  public String getTxtOPCD() {
    return this.txtOPCD;
  }
  
  public void setTxtOPCD(String txtOPCD) {
    this.txtOPCD = txtOPCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07B01A01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */