package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.IL07DDao;

public class IL07D01A01 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL07D01A01.class);

	private Date nowDate = new Date();

	private IL07DDao il07DDao;

	private String txtSRCHST;

	private String txtSRCHSTNM;

	public String toMain() throws Exception {
		return "success";
	}

	public void doCheck() throws Exception {
		String content = this.il07DDao.queryData(this.txtSRCHST);
		
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

	public IL07DDao getIl07DDao() {
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
}
