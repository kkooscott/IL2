package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.myDao.IL07DDao;

public class IL07D00M extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL07D00M.class);

	private Date nowDate = new Date();

	private IL07DDao il07DDao;

	private String txtSRCHST;

	private String txtSRCHSTNM;

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

			msg = il07DDao.insertData(this.txtSRCHST, this.txtSRCHSTNM);
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

			msg = il07DDao.updateData(this.txtSRCHST, this.txtSRCHSTNM);
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

			msg = il07DDao.deleteData(this.txtSRCHST);
			response.getWriter().write(String.valueOf(msg));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IL07DDao getIl07CDao() {
		return this.il07DDao;
	}

	public void setIl07DDao(IL07DDao il07dDao) {
		this.il07DDao = il07dDao;
	}

	public String getTxtSRCHST() {
		return this.txtSRCHST;
	}

	public void setTxtSRCHST(String txtSRCHST) {
		this.txtSRCHST = txtSRCHST;
	}

	public String getTxtSRCHSTNM() {
		return this.txtSRCHSTNM;
	}

	public void setTxtSRCHSTNM(String txtSRCHSTNM) {
		this.txtSRCHSTNM = txtSRCHSTNM;
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}
}
