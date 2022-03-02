package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import npalog.NPALog4J;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.action.bean.IL02A01U02Bean;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.util.CVUtil;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.GetDateUtil;

public class IL02A01U02 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL02A01U02.class);

	MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();

	private Date nowDate = new Date();

	GetDateUtil getDateUtil = new GetDateUtil();

	private List<IL02A01U02Bean> il02A01U02BeanList = new ArrayList<IL02A01U02Bean>();

	private String ilNtnm;

	private String ilNtcd;

	private String ilPspt;

	private String ilEnm;

	private String txtBEGIN_DT;

	private String ilArcno;

	private Constant constant = new Constant();

	private String logcn;

	private String logpstname;

	private String main;

	private String detail;

	private String other;

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

	public Constant getConstant() {
		return this.constant;
	}

	public void setConstant(Constant constant) {
		this.constant = constant;
	}

	public List<IL02A01U02Bean> getIl02A01U02BeanList() {
		return this.il02A01U02BeanList;
	}

	public void setIl02A01U02BeanList(List<IL02A01U02Bean> il02a01u02BeanList) {
		this.il02A01U02BeanList = il02a01u02BeanList;
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public String getIlNtnm() {
		return this.ilNtnm;
	}

	public void setIlNtnm(String ilNtnm) {
		this.ilNtnm = ilNtnm;
	}

	public String getIlNtcd() {
		return this.ilNtcd;
	}

	public void setIlNtcd(String ilNtcd) {
		this.ilNtcd = ilNtcd;
	}

	public String getIlPspt() {
		return this.ilPspt;
	}

	public void setIlPspt(String ilPspt) {
		this.ilPspt = ilPspt;
	}

	public String getIlEnm() {
		return this.ilEnm;
	}

	public void setIlEnm(String ilEnm) {
		this.ilEnm = ilEnm;
	}

	public String getTxtBEGIN_DT() {
		return this.txtBEGIN_DT;
	}

	public void setTxtBEGIN_DT(String txtBEGIN_DT) {
		this.txtBEGIN_DT = txtBEGIN_DT;
	}

	public String getIlArcno() {
		return this.ilArcno;
	}

	public void setIlArcno(String ilArcno) {
		this.ilArcno = ilArcno;
	}

	public String toMain() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		int usrFlagInfo = Integer.parseInt(
				(session.getAttribute("usrFlagInfo") == null) ? "0" : session.getAttribute("usrFlagInfo").toString());
		System.out.println("usrFlagInfo=" + usrFlagInfo);
		try {
			doRealQuery(usrFlagInfo);
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	private void doRealQuery(int usrFlagInfo) {
		this.txtBEGIN_DT = this.getDateUtil.getNoSpiltDate(this.txtBEGIN_DT);
		this.il02A01U02BeanList = this.myIltb01MainDAO.getIL02A01U02Q(usrFlagInfo, this.ilNtcd.trim(),
				this.ilPspt.trim(), this.ilEnm.trim(), this.txtBEGIN_DT, this.ilArcno.trim());
		HttpSession session = ServletActionContext.getRequest().getSession();
		String LOGCN = (session.getAttribute("LOGCN") == null) ? "" : session.getAttribute("LOGCN").toString();
		String LOGDID = (session.getAttribute("LOGDID") == null) ? "" : session.getAttribute("LOGDID").toString();
		String LOGTUP = (session.getAttribute("LOGTUP") == null) ? "" : session.getAttribute("LOGTUP").toString();
		String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session.getAttribute("LOGUIP").toString();
		String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session.getAttribute("LOGUID").toString();
		String LOGTDT = (session.getAttribute("LOGTDT") == null) ? "" : session.getAttribute("LOGTDT").toString();
		String name = "";
		String idno = "";
		ResourceBundle rb = ResourceBundle.getBundle("config");
		String changeMode = rb.getString("changeMode").toString();
		if (this.main.equals("600"))
			this.detail = this.other;
		logger.info("用途=" + this.main + "-" + this.detail);
		if ("1".equals(changeMode))
			doQueryLog("IL03A01Q02", LOGCN, LOGDID, LOGUID, LOGUIP, LOGTUP, LOGTDT, this.logcn, this.logpstname,
					this.main + this.detail, name, idno, this.il02A01U02BeanList);
	}

	public void doQueryLog(String url, String LOGCN, String LOGDID, String LOGUID, String LOGUIP, String LOGTUP,
			String LOGTDT, String queryName, String queryUnit, String queryGoal, String name, String idno,
			List<IL02A01U02Bean> queryList) {
		logger.info("do Query Log");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String systemDateTime = df.format(new Date());
		NPALog4J npaLog4J = new NPALog4J();
		StringBuffer queryMethodBuffer = new StringBuffer();
		queryMethodBuffer.append("外來人口統一證號=" + this.ilArcno + "&");
		queryMethodBuffer.append("護照號碼=" + this.ilPspt + "&");
		queryMethodBuffer.append("英文姓名=" + this.ilEnm + "&");
		queryMethodBuffer.append("國籍代碼=" + this.ilNtcd + "&");
		String queryMethodStr = queryMethodBuffer.toString();
		logger.info("查詢條件內容" + queryMethodStr);
		if (queryList == null || queryList.size() == 0) {
			String listIdno = "";
			String listName = "";
			String str1 = this.txtBEGIN_DT;
			/*
			int j = npaLog4J.logging(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID, LOGUIP,
					LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U02", OprType.Query.toString(),
					this.constant.getApName(), "F", "", queryName, queryUnit, queryGoal, queryMethodStr, idno, name,
					str1, "", "", "");
					*/

			String j = npaLog4J.logging(LOGUID, // 使用者帳號 →原為「使用者帳號-中文名」，現拆為2個欄位
					LOGCN, // 使用者中文名 →原為「使用者帳號-中文名」，現拆為2個欄位
					LOGDID, // 使用者單位代碼
					LOGUIP, // IP
					LOGTDT, // 使用者登入時間 →原有格式不需調整，會自動轉成108年指定之格式
					Constant.getServername(), // AP伺服器名稱 →空白時，自動抓取該台Server名稱
					systemDateTime, // 使用者作業時間 →空白時，自動抓取當下時間
					"查察記事資料選取畫面-IL02A01U02", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
					OprType.Insert.toString(), // 作業種類：N(新增)、D(刪除)、U(更新)、Q(查詢)、T(列印)、W(Web Service)、Z(查詢但不記次數)
					constant.getApName(), // AP系統代碼
					"F", // 查詢結果，S(查有)、F(查無)
					"", // 異動結果，S(異動成功)、F(異動失敗)
					queryName, // 實際查詢人姓名
					queryUnit, // 實際查詢人單位
					queryGoal.substring(0, 3), // 實際查詢人用途代碼 →108年新增欄位
					queryGoal.substring(3), // 實際查詢人用途
					"", // 實際查詢人案號 →108年新增欄位
					queryMethodStr, // 查詢條件參數
					idno, // 查詢條件：身分證號
					name, // 查詢條件：姓名
					str1, // 查詢條件：生日
					"", // 查詢條件：車牌類
					"", // 查詢條件：車號
					"", // 電話號碼 →108年新增欄位
					"", // 手機序號(IMEI) →108年新增欄位
					"", // 案件號碼 →108年新增欄位
					"" // 全文內容
			);

			logger.info("查無日誌結果" + j);
			return;
		}
		String listBirth = this.txtBEGIN_DT;
		String[] strs = new String[queryList.size() + 1];
		strs[0] = "居留資料關聯ID&護照號碼&英文姓名&國籍代碼&出生日期&國籍名稱";
		int i = 1;
		for (IL02A01U02Bean bean : queryList) {
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append(CVUtil.trim(Integer.valueOf(bean.getIlArcid())) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlPspt().toUpperCase()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlEnm().toUpperCase()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlNtcd().toUpperCase()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlBthdt().toUpperCase()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlNTNM().toUpperCase()) + "&");
			strs[i] = strBuffer.toString();
			i++;
			if(i > 10) {
				break;
			}
		}
		String str = npaLog4J.genQueryXML(strs);
		logger.info("查詢結果內容" + str);
		System.out.println("constant.getLogMethod()=" + this.constant.getLogMethod());
		System.out.println("LOGCN=" + LOGCN);
		System.out.println("LOGDID=" + LOGDID);
		System.out.println("LOGUIP=" + LOGUIP);
		System.out.println("LOGTDT=" + LOGTDT);
		System.out.println("constant.getServername()=" + Constant.getServername());
		System.out.println("systemDateTime=" + systemDateTime);
		System.out.println("OprType.Query.toString()=" + OprType.Query.toString());
		System.out.println("constant.getApName()=" + this.constant.getApName());
		
		/*
		int result = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID, LOGUIP,
				LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U02", OprType.Query.toString(),
				this.constant.getApName(), "S", "", queryName, queryUnit, queryGoal, queryMethodStr, idno, name,
				listBirth, "", "", str);
				*/
		
		String result = npaLog4J.logging(LOGUID, // 使用者帳號 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGCN, // 使用者中文名 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGDID, // 使用者單位代碼
				LOGUIP, // IP
				LOGTDT, // 使用者登入時間 →原有格式不需調整，會自動轉成108年指定之格式
				Constant.getServername(), // AP伺服器名稱 →空白時，自動抓取該台Server名稱
				systemDateTime, // 使用者作業時間 →空白時，自動抓取當下時間
				"查察記事資料選取畫面-IL02A01U02", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
				OprType.Insert.toString(), // 作業種類：N(新增)、D(刪除)、U(更新)、Q(查詢)、T(列印)、W(Web Service)、Z(查詢但不記次數)
				constant.getApName(), // AP系統代碼
				"S", // 查詢結果，S(查有)、F(查無)
				"", // 異動結果，S(異動成功)、F(異動失敗)
				queryName, // 實際查詢人姓名
				queryUnit, // 實際查詢人單位
				"", // 實際查詢人用途代碼 →108年新增欄位
				queryGoal, // 實際查詢人用途
				"", // 實際查詢人案號 →108年新增欄位
				queryMethodStr, // 查詢條件參數
				idno, // 查詢條件：身分證號
				name, // 查詢條件：姓名
				listBirth, // 查詢條件：生日
				"", // 查詢條件：車牌類
				"", // 查詢條件：車號
				"", // 電話號碼 →108年新增欄位
				"", // 手機序號(IMEI) →108年新增欄位
				"", // 案件號碼 →108年新增欄位
				str // 全文內容
		);
		
		logger.info("查有日誌結果" + result);
	}

	public String toQuery() throws Exception {
		return "success";
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL02A01U02.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */