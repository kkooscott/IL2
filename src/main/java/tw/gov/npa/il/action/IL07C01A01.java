package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.IL07CDao;

public class IL07C01A01 extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07C01A01.class);
  
  private Date nowDate = new Date();
  
  private IL07CDao il07CDao;
  
  private String txtUVCD;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public void doCheck() throws Exception {
    String content = this.il07CDao.queryData(this.txtUVCD);
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
  
  public IL07CDao getIl07CDao() {
    return this.il07CDao;
  }
  
  public void setIl07CDao(IL07CDao il07cDao) {
    this.il07CDao = il07cDao;
  }
  
  public String getTxtUVCD() {
    return this.txtUVCD;
  }
  
  public void setTxtUVCD(String txtUVCD) {
    this.txtUVCD = txtUVCD;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07C01A01.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */