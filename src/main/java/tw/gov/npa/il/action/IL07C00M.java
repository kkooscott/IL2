package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.myDao.IL07CDao;

public class IL07C00M extends ActionSupport {
  private static final Logger logger = Logger.getLogger(IL07C00M.class);
  
  private Date nowDate = new Date();
  
  private IL07CDao il07CDao;
  
  private String txtUVCD;
  
  private String txtUVCNM;
  
  private String txtUVCPNM;
  
  private String txtUVPZONE;
  
  private String txtUVADDR;
  
  private String txtUVTEL;
  
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

			msg = il07CDao.insertData(this.txtUVCD, this.txtUVCNM, this.txtUVCPNM, this.txtUVPZONE, this.txtUVADDR, this.txtUVTEL);
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

			msg = il07CDao.updateData(this.txtUVCD, this.txtUVCNM, this.txtUVCPNM, this.txtUVPZONE, this.txtUVADDR, this.txtUVTEL);
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

			msg = il07CDao.deleteData(this.txtUVCD);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
  
  public String getTxtUVCNM() {
    return this.txtUVCNM;
  }
  
  public void setTxtUVCNM(String txtUVCNM) {
    this.txtUVCNM = txtUVCNM;
  }
  
  public String getTxtUVCPNM() {
    return this.txtUVCPNM;
  }
  
  public void setTxtUVCPNM(String txtUVCPNM) {
    this.txtUVCPNM = txtUVCPNM;
  }
  
  public String getTxtUVPZONE() {
    return this.txtUVPZONE;
  }
  
  public void setTxtUVPZONE(String txtUVPZONE) {
    this.txtUVPZONE = txtUVPZONE;
  }
  
  public String getTxtUVADDR() {
    return this.txtUVADDR;
  }
  
  public void setTxtUVADDR(String txtUVADDR) {
    this.txtUVADDR = txtUVADDR;
  }
  
  public String getTxtUVTEL() {
    return this.txtUVTEL;
  }
  
  public void setTxtUVTEL(String txtUVTEL) {
    this.txtUVTEL = txtUVTEL;
  }
  
  public Date getNowDate() {
    return this.nowDate;
  }
  
  public void setNowDate(Date nowDate) {
    this.nowDate = nowDate;
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL07C00M.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */