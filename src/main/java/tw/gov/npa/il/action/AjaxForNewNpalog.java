package tw.gov.npa.il.action;

import npalog.NPALog4J;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.util.Constant;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

public class AjaxForNewNpalog {
	private static final Logger logger = Logger.getLogger(AjaxForNewNpalog.class);

	private String main;
	private String detail;
	private String logcn;
	private String logpstname;
	private String oprPage;
	private String queryMethodStr;
	private String dataRowsString;
	private String name;
	private String idno;
	private String birth;

	private Constant constant = new Constant();

	public void doLog() {
		NPALog4J npalog4J = new NPALog4J();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String LOGCN = (session.getAttribute("LOGCN") == null) ? "" : session.getAttribute("LOGCN").toString();
		String LOGDID = (session.getAttribute("LOGDID") == null) ? "" : session.getAttribute("LOGDID").toString();
		String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session.getAttribute("LOGUIP").toString();
		String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session.getAttribute("LOGUID").toString();
		String LOGTDT = (session.getAttribute("LOGTDT") == null) ? "" : session.getAttribute("LOGTDT").toString();
		String str = "";
		if(dataRowsString!=null || !dataRowsString.equals("")) {
			String[] QRslt = dataRowsString.split("%===%");
			str = npalog4J.genQueryXML(QRslt);
		}
		
		npalog4J.logging(LOGUID, // 使用者帳號 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGCN, // 使用者中文名 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGDID, // 使用者單位代碼
				LOGUIP, // IP
				LOGTDT, // 使用者登入時間 →原有格式不需調整，會自動轉成108年指定之格式
				Constant.getServername(), // AP伺服器名稱 →空白時，自動抓取該台Server名稱
				new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()), // 使用者作業時間 →空白時，自動抓取當下時間
				oprPage, // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
				OprType.Query.toString(), // 作業種類：N(新增)、D(刪除)、U(更新)、Q(查詢)、T(列印)、W(Web Service)、Z(查詢但不記次數)
				constant.getApName(), // AP系統代碼
				str.equals("") ? "F" : "S", // 查詢結果，S(查有)、F(查無)
				"", // 異動結果，S(異動成功)、F(異動失敗)
				logcn, // 實際查詢人姓名
				logpstname, // 實際查詢人單位
				main, // 實際查詢人用途代碼 →108年新增欄位
				detail, // 實際查詢人用途
				"", // 實際查詢人案號 →108年新增欄位
				queryMethodStr, // 查詢條件參數
				idno == null ? "" : idno, // 查詢條件：身分證號
				name == null ? "" : name, // 查詢條件：姓名
				"", // 查詢條件：生日
				"", // 查詢條件：車牌類
				"", // 查詢條件：車號
				"", // 電話號碼 →108年新增欄位
				"", // 手機序號(IMEI) →108年新增欄位
				"", // 案件號碼 →108年新增欄位
				str == null ? "" : str // 全文內容
		);
	}

	public String getDataRowsString() {
		return this.dataRowsString;
	}

	public void setDataRowsString(String dataRowsString) {
		this.dataRowsString = dataRowsString;
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

	public String getLogpstname() {
		return this.logpstname;
	}

	public void setLogpstname(String logpstname) {
		this.logpstname = logpstname;
	}

	public String getLogcn() {
		return this.logcn;
	}

	public void setLogcn(String logcn) {
		this.logcn = logcn;
	}

	public String getOprPage() {
		return this.oprPage;
	}

	public void setOprPage(String oprPage) {
		this.oprPage = oprPage;
	}

	public String getQueryMethodStr() {
		return this.queryMethodStr;
	}

	public void setQueryMethodStr(String queryMethodStr) {
		this.queryMethodStr = queryMethodStr;
	}

	public String getBirth() {
		return this.birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getIdno() {
		return this.idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Constant getConstant() {
		return this.constant;
	}

	public void setConstant(Constant constant) {
		this.constant = constant;
	}
}
