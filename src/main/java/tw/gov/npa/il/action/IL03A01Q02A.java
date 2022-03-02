package tw.gov.npa.il.action;

import com.google.common.base.Joiner;
import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.action.bean.IL03A01Q02Bean;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.entity.NpaLogEntity;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO2;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.NTPCUtil;
import tw.gov.npa.il.util.NpaLogUtil;

public class IL03A01Q02A extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL03A01Q02A.class);

	private Date nowDate = new Date();

	private String flag;

	MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();

	MyIltb01MainDAO2 myIltb01MainDAO2 = new MyIltb01MainDAO2();

	NTPCUtil ntpcUtil = new NTPCUtil();

	private List<IL03A01Q02Bean> queryList = new ArrayList<IL03A01Q02Bean>();

	private String ilArcno;

	private String ilMicro;

	private String ilRepmdc;

	private String ilRepmdcNic;

	private String QueryFrom;

	private Constant constant = new Constant();

	private String logcn;

	private String logpstname;

	private String main;

	private String detail;

	private String other;

	public Date getNowDate() {
		return this.nowDate;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public NTPCUtil getNtpcUtil() {
		return this.ntpcUtil;
	}

	public void setNtpcUtil(NTPCUtil ntpcUtil) {
		this.ntpcUtil = ntpcUtil;
	}

	public List<IL03A01Q02Bean> getQueryList() {
		return this.queryList;
	}

	public void setQueryList(List<IL03A01Q02Bean> queryList) {
		this.queryList = queryList;
	}

	public String getIlArcno() {
		return this.ilArcno;
	}

	public void setIlArcno(String ilArcno) {
		this.ilArcno = ilArcno;
	}

	public String getIlMicro() {
		return this.ilMicro;
	}

	public void setIlMicro(String ilMicro) {
		this.ilMicro = ilMicro;
	}

	public String getIlRepmdc() {
		return this.ilRepmdc;
	}

	public void setIlRepmdc(String ilRepmdc) {
		this.ilRepmdc = ilRepmdc;
	}

	public String getIlRepmdcNic() {
		return this.ilRepmdcNic;
	}

	public void setIlRepmdcNic(String ilRepmdcNic) {
		this.ilRepmdcNic = ilRepmdcNic;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Constant getConstant() {
		return this.constant;
	}

	public void setConstant(Constant constant) {
		this.constant = constant;
	}

	public String getLogcn() {
		return this.logcn;
	}

	public void setLogcn(String logcn) {
		this.logcn = logcn;
	}

	public String getLogpstname() {
		return this.logpstname;
	}

	public void setLogpstname(String logpstname) {
		this.logpstname = logpstname;
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

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getQueryFrom() {
		return this.QueryFrom;
	}

	public void setQueryFrom(String QueryFrom) {
		this.QueryFrom = QueryFrom;
	}

	public String toMain() throws Exception {
		try {
			toQuery();
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String toQuery() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		this.flag = (session.getAttribute("flag") == "") ? "" : session.getAttribute("flag").toString();
		session.setAttribute("ilArcno", "");
		session.setAttribute("ilMicro", this.ilMicro.toUpperCase());
		session.setAttribute("ilRepmdc", this.ilRepmdc.toUpperCase());
		session.setAttribute("ilRepmdcNic", this.ilRepmdcNic.toUpperCase());
		this.queryList = this.myIltb01MainDAO2.getIL03A01Q02A(this.ilMicro.trim().toUpperCase(),
				this.ilRepmdc.trim().toUpperCase(), this.ilRepmdcNic.trim().toUpperCase());
		System.out.println("註記:" + "R".equals(this.flag));
		if ("R".equals(this.flag)) {
			NpaLogEntity logEntity = new NpaLogEntity();
			logEntity.setLogUID((String) session.getAttribute("LOGUID"));
			logEntity.setLogCN((String) session.getAttribute("LOGCN"));
			logEntity.setLogDID((String) session.getAttribute("LOGDID"));
			logEntity.setLogGUIP((String) session.getAttribute("LOGUIP"));
			logEntity.setLogTDT((String) session.getAttribute("LOGTDT"));
			logEntity.setServerName(Constant.getServername());
			logEntity.setApName(this.constant.getApName());
			logEntity.setOprName(this.logcn);
			logEntity.setOprUnit(this.logpstname);
			logEntity.setOprGoal(this.main + this.detail);
			if (this.main.equals("600"))
				logEntity.setOprGoal(this.main + " " + this.other);
			System.out.println(logEntity.getOprGoal());
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String systemDateTime = df.format(new Date());
			logEntity.setSystemDateTime(systemDateTime);
			logEntity.setPageName("外僑居留資料查詢清單-IL03A01Q02A");
			logEntity.setOprClass(OprType.Query.toString());
			StringBuffer sb = new StringBuffer();
			if (this.ilMicro != null && !"".equals(this.ilMicro.trim()))
				sb.append("縮影號碼=").append(this.ilMicro.trim());
			if (this.ilRepmdc != null && !"".equals(this.ilRepmdc.trim())) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("重入國許可證號=").append(this.ilRepmdc.trim());
			}
			if (this.ilRepmdcNic != null && !"".equals(this.ilRepmdcNic.trim())) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("重入國許可證號-移民署=").append(this.ilRepmdcNic.trim());
			}
			logEntity.setOtherQeryStr(sb.toString());
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String changeMode = rb.getString("changeMode").toString();
			if ("1".equals(changeMode))
				if (this.queryList != null && this.queryList.size() > 0) {
					logEntity.setQueryRes("S");
					List<String> tmpContent = new ArrayList<String>();
					tmpContent.add("國籍&護照號碼&英文姓名&出生日期");
					int i = 1;
					for (IL03A01Q02Bean bean : this.queryList) {
						List<String> sublist = new ArrayList<String>();
						sublist.add(bean.getIlNTNM());
						sublist.add(bean.getIlPspt());
						sublist.add(bean.getIlEnm());
						sublist.add(bean.getIlBthdt());
						String ssb = Joiner.on("&").join(sublist);
						tmpContent.add(ssb);
						i++;
						if (i > 10) {
							break;
						}
					}
					logEntity.setContent(NpaLogUtil.getOtherContent(tmpContent.<String>toArray(new String[0])));
					NpaLogUtil.doLogging(logEntity);
				} else {
					logEntity.setQueryRes("F");
					NpaLogUtil.doLogging(logEntity);
				}
		}
		session.setAttribute("flag", "N");
		return "success";
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q02A.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */