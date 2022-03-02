package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.myDao.IL07ADao;

public class IL07A00M extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL07A00M.class);

	private Date nowDate = new Date();

	private IL07ADao il07ADao;

	private String txtNTCD;

	private String txtNTNM;

	private String chkNTLBR;

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

			if (this.chkNTLBR == null) {
				this.chkNTLBR = "0";
			}
			msg = il07ADao.insertData(this.txtNTCD, this.txtNTNM, this.chkNTLBR);
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

			if (this.chkNTLBR == null) {
				this.chkNTLBR = "0";
			}
			msg = il07ADao.updateData(this.txtNTCD, this.txtNTNM, this.chkNTLBR);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doDelete() throws Exception {
		Boolean msg = true;
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Charset", "UTF-8");
			
			msg = il07ADao.deleteData(this.txtNTCD);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IL07ADao getIl07ADao() {
		return this.il07ADao;
	}

	public void setIl07ADao(IL07ADao il07aDao) {
		this.il07ADao = il07aDao;
	}

	public String getTxtNTCD() {
		return this.txtNTCD;
	}

	public void setTxtNTCD(String txtNTCD) {
		this.txtNTCD = txtNTCD;
	}

	public String getTxtNTNM() {
		return this.txtNTNM;
	}

	public void setTxtNTNM(String txtNTNM) {
		this.txtNTNM = txtNTNM;
	}

	public String getChkNTLBR() {
		return this.chkNTLBR;
	}

	public void setChkNTLBR(String chkNTLBR) {
		this.chkNTLBR = chkNTLBR;
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
}
