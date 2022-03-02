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
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.entity.NpaLogEntity;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;
import tw.gov.npa.il.util.NpaLogUtil;

public class IL02C01U02 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL02C01U02.class);

	NTPCUtil ntpcUtil = new NTPCUtil();

	GetDateUtil getDateUtil = new GetDateUtil();

	MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();

	private String result;

	private String isFlag;

	private List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();

	private Date nowDate = new Date();

	private int ilArcid;

	private String ilPst;

	private String ilZipCode;

	private String txtBEGIN_DT;

	private String txtBEGIN_DF;

	private String ilPstext;

	private String ilArccs;

	private Date beginDate;

	private Date endDate;

	private Constant constant = new Constant();

	private String logcn;

	private String logpstname;

	private String main;

	private String detail;

	private String other;

	public Date getNowDate() {
		return this.nowDate;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getIsFlag() {
		return this.isFlag;
	}

	public void setIsFlag(String isFlag) {
		this.isFlag = isFlag;
	}

	public int getIlArcid() {
		return this.ilArcid;
	}

	public void setIlArcid(int ilArcid) {
		this.ilArcid = ilArcid;
	}

	public List<Iltb01Main> getIltb01MainList() {
		return this.iltb01MainList;
	}

	public void setIltb01MainList(List<Iltb01Main> iltb01MainList) {
		this.iltb01MainList = iltb01MainList;
	}

	public String getIlPst() {
		return this.ilPst;
	}

	public void setIlPst(String ilPst) {
		this.ilPst = ilPst;
	}

	public String getIlZipCode() {
		return this.ilZipCode;
	}

	public void setIlZipCode(String ilZipCode) {
		this.ilZipCode = ilZipCode;
	}

	public String getTxtBEGIN_DT() {
		return this.txtBEGIN_DT;
	}

	public void setTxtBEGIN_DT(String txtBEGIN_DT) {
		this.txtBEGIN_DT = txtBEGIN_DT;
	}

	public String getTxtBEGIN_DF() {
		return this.txtBEGIN_DF;
	}

	public void setTxtBEGIN_DF(String txtBEGIN_DF) {
		this.txtBEGIN_DF = txtBEGIN_DF;
	}

	public String getIlPstext() {
		return this.ilPstext;
	}

	public void setIlPstext(String ilPstext) {
		this.ilPstext = ilPstext;
	}

	public String getIlArccs() {
		return this.ilArccs;
	}

	public void setIlArccs(String ilArccs) {
		this.ilArccs = ilArccs;
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

	public String toMain() throws Exception {
		System.out.println("ilPst=" + this.ilPst);
		System.out.println("ilZipCode=" + this.ilZipCode);
		System.out.println("txtBEGIN_DT=" + this.txtBEGIN_DT);
		System.out.println("txtBEGIN_DF=" + this.txtBEGIN_DF);
		System.out.println("ilPstext=" + this.ilPstext);
		System.out.println("ilArccs=" + this.ilArccs);
		try {
			String[] ilPstArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(this.ilPst);
			this.txtBEGIN_DT = this.getDateUtil.getSepSpiltDateStart(this.txtBEGIN_DT);
			this.txtBEGIN_DF = this.getDateUtil.getSepSpiltDateEnd(this.txtBEGIN_DF);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.beginDate = df.parse(this.txtBEGIN_DT);
			this.endDate = df.parse(this.txtBEGIN_DF);
			String[] ilArccsArr = null;
			if (!"".equals(this.ilArccs) && this.ilArccs != null)
				ilArccsArr = this.ilArccs.split(", ");
			this.iltb01MainList = this.myIltb01MainDAO.getIL02C01U02Q(ilPstArr, this.ilZipCode, this.txtBEGIN_DT,
					this.txtBEGIN_DF, this.ilPstext, ilArccsArr);
			System.out.println("iltb01MainList=" + this.iltb01MainList.size());
			HttpSession session = ServletActionContext.getRequest().getSession();
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
			if (this.main.equals("600"))
				this.detail = this.other;
			logger.info("用途=" + this.main + "-" + this.detail);
			logEntity.setOprGoal(this.main + this.detail);
			DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String systemDateTime = df2.format(new Date());
			logEntity.setSystemDateTime(systemDateTime);
			logEntity.setPageName("外責區資料顯示及登錄-IL02C01U02");
			logEntity.setOprClass(OprType.Query.toString());
			StringBuffer sb = new StringBuffer();
			if (this.ilZipCode != null && !"".equals(this.ilZipCode.trim()))
				sb.append("居留地址郵遞區號=").append(this.ilZipCode);
			if (this.ilPst != null && !"".equals(this.ilPst)) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("管轄警局=").append(this.ilPst);
			}
			if (this.txtBEGIN_DT != null && !"".equals(this.txtBEGIN_DT)) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("申請日期(起)=").append(this.txtBEGIN_DT);
			}
			if (this.txtBEGIN_DF != null && !"".equals(this.txtBEGIN_DF)) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("申請日期(至)=").append(this.txtBEGIN_DF);
			}
			if (this.ilPstext != null && !"".equals(this.ilPstext)) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("外責區註記=").append(this.ilPstext);
			}
			if (this.ilArccs != null && !"".equals(this.ilArccs)) {
				if (sb.length() > 0)
					sb.append("&");
				sb.append("外僑識別=").append(this.ilArccs);
			}
			logEntity.setOtherQeryStr(sb.toString());
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String changeMode = rb.getString("changeMode").toString();
			if ("1".equals(changeMode))
				if (this.iltb01MainList != null && this.iltb01MainList.size() > 0) {
					logEntity.setQueryRes("S");
					List<String> tmpContent = new ArrayList<String>();
					tmpContent.add("外來人口統一證號&識別&郵遞區號&居留地址&外責區註記");
					int i = 1;
					for (Iltb01Main bean : this.iltb01MainList) {
						List<String> sublist = new ArrayList<String>();
						sublist.add(bean.getIlArcno());
						sublist.add(bean.getIlArccs());
						sublist.add(bean.getIlArpzone());
						sublist.add(bean.getIlAraddr());
						sublist.add(bean.getIlPstext());
						String ssb = bean.getIlArcno() + "&" + bean.getIlArccs() + "&" + bean.getIlArpzone() + "&"
								+ bean.getIlAraddr() + "&" + bean.getIlPstext();
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
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	public String toUpdate() throws Exception {
		try {
			Iltb01Main iltb01Main = new Iltb01Main();
			iltb01Main = this.myIltb01MainDAO.findById(Integer.valueOf(this.ilArcid));
			String iLPstextb = iltb01Main.getIlPstext();
			iltb01Main.setIlPstext(this.ilPstext);
			boolean resultBoo = this.myIltb01MainDAO.updateData(iltb01Main);
			this.result = resultBoo + "";
			HttpSession session = ServletActionContext.getRequest().getSession();
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
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String systemDateTime = df.format(new Date());
			logEntity.setSystemDateTime(systemDateTime);
			logEntity.setPageName("外責區資料顯示及登錄-IL02C01U02Update");
			logEntity.setOprClass(OprType.Update.toString());
			logEntity.setOtherQeryStr("居留資料關聯ID=" + this.ilArcid);
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String changeMode = rb.getString("changeMode").toString();
			if ("1".equals(changeMode))
				if (resultBoo) {
					logEntity.setUpdateRes("S");
					List<String> sb = new ArrayList<String>();
					List<String> sa = new ArrayList<String>();
					if (!iLPstextb.equals(this.ilPstext)) {
						sb.add("外責區註記=" + iLPstextb);
						sa.add("外責區註記=" + this.ilPstext);
					}
					String strBefore = Joiner.on("&").join(sb);
					String strAfter = Joiner.on("&").join(sa);
					logEntity.setContent(NpaLogUtil.getUpdateContent(strBefore, strAfter));
					NpaLogUtil.doLogging(logEntity);
				} else {
					logEntity.setUpdateRes("F");
					NpaLogUtil.doLogging(logEntity);
				}
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		this.myIltb01MainDAO.tryToCloseSession();
		return "success";
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL02C01U02.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */