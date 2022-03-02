package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.myDao.AppUseDAO;

public class Searcher extends ActionSupport {
	private static final Logger logger = Logger.getLogger(Searcher.class);

	private String main;

	private String detail;

	private String logcn;

	private String logpstname;

	private Map<String, String> mainMap;

	private Map<String, String> detailMap;

	private AppUseDAO appUseDAO;

	public String execute() {
		logger.info("touch searcher");
		this.mainMap = this.appUseDAO.findMainUse();
		this.detailMap = new LinkedHashMap<String, String>();
		ActionContext context = ActionContext.getContext();
		this.logcn = (String) context.getSession().get("LOGCN");
		this.logpstname = (String) context.getSession().get("LOGPSTNAME");
		return "success";
	}

	public void getDetails() {
		logger.info("get details");
		logger.info(this.main);
		try {
			Map<String, String> detailMap = this.appUseDAO.findDetailUse(this.main);
			JSONObject detailObj = new JSONObject();
			detailObj.put("details", detailMap);
			sendMsg(detailObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e, e);
		}
	}

	public void sendMsg(String content) {
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

	public String getMain() {
		return this.main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Map<String, String> getMainMap() {
		return this.mainMap;
	}

	public void setMainMap(Map<String, String> mainMap) {
		this.mainMap = mainMap;
	}

	public Map<String, String> getDetailMap() {
		return this.detailMap;
	}

	public void setDetailMap(Map<String, String> detailMap) {
		this.detailMap = detailMap;
	}

	public AppUseDAO getAppUseDAO() {
		return this.appUseDAO;
	}

	public void setAppUseDAO(AppUseDAO appUseDAO) {
		this.appUseDAO = appUseDAO;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\Searcher.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */