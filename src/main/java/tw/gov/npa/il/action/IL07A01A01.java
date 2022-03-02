package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.IL07ADao;

public class IL07A01A01 extends ActionSupport {

	private static final Logger logger = Logger.getLogger(IL07A01A01.class);

	private Date nowDate = new Date();

	private String txtNTCD;

	private IL07ADao il07ADao;

	public String toMain() throws Exception {
		return "success";
	}

	public void doCheck() throws Exception {
		String content = this.il07ADao.queryData(this.txtNTCD);
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

	public String getTxtNTCD() {
		return this.txtNTCD;
	}

	public void setTxtNTCD(String txtNTCD) {
		this.txtNTCD = txtNTCD;
	}

	public IL07ADao getIl07ADao() {
		return this.il07ADao;
	}

	public void setIl07ADao(IL07ADao il07aDao) {
		this.il07ADao = il07aDao;
	}
}
