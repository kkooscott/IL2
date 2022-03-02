package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.myDao.IL07BDao;

public class IL07B00M extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07B00M.class);
  
  private Date nowDate = new Date();
  
  private IL07BDao il07BDao;
  
  private String txtOPCD;
  
  private String txtOPNM;
  
  private String txtOPPRSQ;
  
  private String txtOPCS;
  
  public String toMain() throws Exception {
    return "success";
  }
  
  public void doInsert() {
	  Boolean msg = true;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Charset", "UTF-8");

			msg = il07BDao.insertData(this.txtOPCD, this.txtOPNM, this.txtOPPRSQ, this.txtOPCS);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  public void doUpdate() {
	  Boolean msg = true;
	  try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Charset", "UTF-8");

			msg = il07BDao.updateData(this.txtOPCD, this.txtOPNM, this.txtOPPRSQ, this.txtOPCS);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
  
  public void doDelete() {
	  Boolean msg = true;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Charset", "UTF-8");

			msg = il07BDao.deleteData(this.txtOPCD);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
  
  public String getTxtOPNM() {
    return this.txtOPNM;
  }
  
  public void setTxtOPNM(String txtOPNM) {
    this.txtOPNM = txtOPNM;
  }
  
  public String getTxtOPPRSQ() {
    return this.txtOPPRSQ;
  }
  
  public void setTxtOPPRSQ(String txtOPPRSQ) {
    this.txtOPPRSQ = txtOPPRSQ;
  }
  
  public String getTxtOPCS() {
    return this.txtOPCS;
  }
  
  public void setTxtOPCS(String txtOPCS) {
    this.txtOPCS = txtOPCS;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07B00M.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */