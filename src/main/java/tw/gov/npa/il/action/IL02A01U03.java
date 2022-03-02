package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import npalog.NPALog4J;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;
import tw.gov.npa.il.util.CVUtil;
import tw.gov.npa.il.util.Constant;

public class IL02A01U03 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL02A01U03.class);

	MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();

	MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();

	Iltb15CountryCodeDAO iltb15CountryCodeDAO = new Iltb15CountryCodeDAO();

	MyE0dtNpaunitDAO e0dtNpaunitDAO = new MyE0dtNpaunitDAO();

	private Iltb01Main iltb01Main = new Iltb01Main();

	private int ilArcid;

	private String ilNTNM;

	private String ilOpnm;

	private String e0UnitSNm;

	private String ilNTNMFnt;

	private String ilFnddNm;

	private Date nowDate = new Date();

	private String result;

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

	public String getResult() {
		return this.result;
	}

	public String getIlFnddNm() {
		return this.ilFnddNm;
	}

	public void setIlFnddNm(String ilFnddNm) {
		this.ilFnddNm = ilFnddNm;
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

	public String getIlNTNMFnt() {
		return this.ilNTNMFnt;
	}

	public void setIlNTNMFnt(String ilNTNMFnt) {
		this.ilNTNMFnt = ilNTNMFnt;
	}

	public String getE0UnitSNm() {
		return this.e0UnitSNm;
	}

	public void setE0UnitSNm(String e0UnitSNm) {
		this.e0UnitSNm = e0UnitSNm;
	}

	public String getIlOpnm() {
		return this.ilOpnm;
	}

	public void setIlOpnm(String ilOpnm) {
		this.ilOpnm = ilOpnm;
	}

	public String getIlNTNM() {
		return this.ilNTNM;
	}

	public void setIlNTNM(String ilNTNM) {
		this.ilNTNM = ilNTNM;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Iltb01Main getIltb01Main() {
		return this.iltb01Main;
	}

	public void setIltb01Main(Iltb01Main iltb01Main) {
		this.iltb01Main = iltb01Main;
	}

	public int getIlArcid() {
		return this.ilArcid;
	}

	public void setIlArcid(int ilArcid) {
		this.ilArcid = ilArcid;
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
		try {
			this.iltb01Main = this.myIltb01MainDAO.findById(Integer.valueOf(this.ilArcid));
			if (this.iltb01Main != null) {
				String ilNtcd = this.iltb01Main.getIlNtcd();
				Iltb15CountryCode iltb15CountryCode = this.iltb15CountryCodeDAO.findById(ilNtcd);
				if (iltb15CountryCode != null)
					this.ilNTNM = iltb15CountryCode.getIlNtnm();
				String ilJbcd = this.iltb01Main.getIlJbcd();
				Iltb16JobCode iltb16JobCode = this.myIltb16JobCodeDAO.findById(ilJbcd);
				if (iltb16JobCode != null)
					this.ilOpnm = iltb16JobCode.getIlOpnm();
				String ilPst = this.iltb01Main.getIlPst();
				if (!"".equals(ilPst) && ilPst != null)
					this.e0UnitSNm = (String) this.constant.getIlPstAreaMap().get(ilPst.substring(0, 1));
				Iltb15CountryCode iltb15CountryCodeFnt = null;
				String ilFntcd = this.iltb01Main.getIlFntcd();
				if (!"".equals(ilFntcd) && ilFntcd != null)
					iltb15CountryCodeFnt = this.iltb15CountryCodeDAO.findById(ilFntcd);
				if (iltb15CountryCodeFnt != null)
					this.ilNTNMFnt = iltb15CountryCodeFnt.getIlNtnm();
				String ilFnddid = this.iltb01Main.getIlFnddid();
				if (!"".equals(ilFnddid) && ilFnddid != null)
					this.ilFnddNm = (String) this.constant.getIlPstAreaMap().get(ilFnddid.substring(0, 1));
				HttpSession session = ServletActionContext.getRequest().getSession();
				String LOGCN = (session.getAttribute("LOGCN") == null) ? "" : session.getAttribute("LOGCN").toString();
				String LOGDID = (session.getAttribute("LOGDID") == null) ? ""
						: session.getAttribute("LOGDID").toString();
				String LOGTUP = (session.getAttribute("LOGTUP") == null) ? ""
						: session.getAttribute("LOGTUP").toString();
				String LOGUIP = (session.getAttribute("LOGUIP") == null) ? ""
						: session.getAttribute("LOGUIP").toString();
				String LOGUID = (session.getAttribute("LOGUID") == null) ? ""
						: session.getAttribute("LOGUID").toString();
				String LOGTDT = (session.getAttribute("LOGTDT") == null) ? ""
						: session.getAttribute("LOGTDT").toString();
				String name = "";
				String idno = "";
				ResourceBundle rb = ResourceBundle.getBundle("config");
				String changeMode = rb.getString("changeMode").toString();
				if (this.main.equals("600"))
					this.detail = this.other;
				logger.info("用途=" + this.main + "-" + this.detail);
				if ("1".equals(changeMode))
					doQueryLog("IL03A01Q03", LOGCN, LOGDID, LOGUID, LOGUIP, LOGTUP, LOGTDT, this.logcn, this.logpstname,
							this.main + this.detail, name, idno, this.iltb01Main);
			}
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		this.myIltb01MainDAO.tryToCloseSession();
		return "success";
	}

	public void doQueryLog(String url, String LOGCN, String LOGDID, String LOGUID, String LOGUIP, String LOGTUP,
			String LOGTDT, String queryName, String queryUnit, String queryGoal, String name, String idno,
			Iltb01Main bean) {
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
		if (bean == null) {
			String listIdno = "";
			String listName = "";
			String str1 = "";
			/*
			int j = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID, LOGUIP,
					LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U03", OprType.Query.toString(),
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
					"查察記事明細內容畫面-IL02A01U03", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
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
		String listBirth = "";
		String[] strs = new String[2];
		strs[0] = "英文姓名&中文姓名&性別&國籍&出生日期&護照號碼&護照期限&教育程度&抵台日期&離台日期&職業&居留事由&居留狀況&縮影編號&居留事由&電話&職位&工作地址&電話&居留地址&電話&仲介公司&電話&備註&機關&許可日期&文號&許可效期&申請日期&收據號碼&外來人口統一證號&居留效期&管轄分局&限期離境&稱謂&姓名&國籍&身分(居留)證號&申請日期&類別&原許可證號(6位)&核准期限&備考&新許可證號(10位)&撤(註)銷居留/出國報備&原因&日期&文號&處理情形&逃逸日期&報案日期&報案方式&查獲單位&查獲日期";
		int i = 1;
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(CVUtil.trim(bean.getIlEnm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlCnm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlSex()) + "&");
		strBuffer.append(CVUtil.trim(getIlNtnm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlBthdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlPspt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlPsdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlEdu()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlIndt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlExdt()) + "&");
		strBuffer.append(CVUtil.trim(getIlOpnm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArcrsn()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArcst()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlMicro()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArcrsn()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlOfnm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlOftel()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbpsn()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbaddr()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbtel()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlAraddr()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArtel()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlAgnco()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlAgntel()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlRemrk()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbpmcd()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbpmdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbpmdc()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlJbpmfm()) + "~" + CVUtil.trim(bean.getIlJbpmto()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlApydt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArcrcp()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArcno()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlArcfm()) + "&");
		strBuffer.append(CVUtil.trim(getE0UnitSNm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFrcexit()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFrshp()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFnm()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFpid()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlReapydt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlRetp()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlRepmdc()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlRepmdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlRrnote()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlRepmdcNic()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlMrkcs()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFbdrsn()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlMrkdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlMrkdc()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlSrchst()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlMissdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlSbmtdt()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlSbmttp()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFnddid()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlFnddt()) + "&");
		strs[i] = strBuffer.toString();
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
				LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U03", OprType.Query.toString(),
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
				"查察記事明細內容畫面-IL02A01U03", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
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
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL02A01U03.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */