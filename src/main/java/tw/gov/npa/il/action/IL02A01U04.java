package tw.gov.npa.il.action;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.servlet.http.HttpSession;
import npalog.NPALog4J;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.dao.Iltb04InRecord;
import tw.gov.npa.il.dao.Iltb04InRecordId;
import tw.gov.npa.il.myDao.MyIltb04InRecordDAO;
import tw.gov.npa.il.util.CVUtil;
import tw.gov.npa.il.util.Constant;

public class IL02A01U04 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL02A01U04.class);

	private String result;

	private String isFlag;

	MyIltb04InRecordDAO myIltb04InRecordDAO = new MyIltb04InRecordDAO();

	private List<Iltb04InRecord> iltb04InRecordList = new ArrayList<Iltb04InRecord>();

	private Iltb04InRecordId iltb04InRecordId = new Iltb04InRecordId();

	private Iltb04InRecord iltb04InRecord = new Iltb04InRecord();

	private int ilArcid;

	private String ilEnm;

	private String ilArcno;

	private String ilPtrldt;

	private String ilPtrldtOri;

	private String ilPtrlst;

	private String ilPtrlmrk;

	private String ilUid;

	private String ilUnm;

	private String ilMantype;

	private Date nowDate = new Date();

	private Constant constant = new Constant();

	private String logcn;

	private String logpstname;

	private String main;

	private String detail;

	public Date getNowDate() {
		return this.nowDate;
	}

	public String getIlPtrldtOri() {
		return this.ilPtrldtOri;
	}

	public void setIlPtrldtOri(String ilPtrldtOri) {
		this.ilPtrldtOri = ilPtrldtOri;
	}

	public Iltb04InRecordId getIltb04InRecordId() {
		return this.iltb04InRecordId;
	}

	public void setIltb04InRecordId(Iltb04InRecordId iltb04InRecordId) {
		this.iltb04InRecordId = iltb04InRecordId;
	}

	public Iltb04InRecord getIltb04InRecord() {
		return this.iltb04InRecord;
	}

	public void setIltb04InRecord(Iltb04InRecord iltb04InRecord) {
		this.iltb04InRecord = iltb04InRecord;
	}

	public String getIlPtrldt() {
		return this.ilPtrldt;
	}

	public void setIlPtrldt(String ilPtrldt) {
		this.ilPtrldt = ilPtrldt;
	}

	public String getIlPtrlst() {
		return this.ilPtrlst;
	}

	public void setIlPtrlst(String ilPtrlst) {
		this.ilPtrlst = ilPtrlst;
	}

	public String getIlPtrlmrk() {
		return this.ilPtrlmrk;
	}

	public void setIlPtrlmrk(String ilPtrlmrk) {
		this.ilPtrlmrk = ilPtrlmrk;
	}

	public String getIlUid() {
		return this.ilUid;
	}

	public void setIlUid(String ilUid) {
		this.ilUid = ilUid;
	}

	public String getIlUnm() {
		return this.ilUnm;
	}

	public void setIlUnm(String ilUnm) {
		this.ilUnm = ilUnm;
	}

	public String getIlMantype() {
		return this.ilMantype;
	}

	public void setIlMantype(String ilMantype) {
		this.ilMantype = ilMantype;
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

	public List<Iltb04InRecord> getIltb04InRecordList() {
		return this.iltb04InRecordList;
	}

	public void setIltb04InRecordList(List<Iltb04InRecord> iltb04InRecordList) {
		this.iltb04InRecordList = iltb04InRecordList;
	}

	public int getIlArcid() {
		return this.ilArcid;
	}

	public void setIlArcid(int ilArcid) {
		this.ilArcid = ilArcid;
	}

	public String getIlEnm() {
		return this.ilEnm;
	}

	public void setIlEnm(String ilEnm) {
		this.ilEnm = ilEnm;
	}

	public String getIlArcno() {
		return this.ilArcno;
	}

	public void setIlArcno(String ilArcno) {
		this.ilArcno = ilArcno;
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

	public String toMain() throws Exception {
		try {
			this.iltb04InRecordList = this.myIltb04InRecordDAO.getDataByIlArcid(this.ilArcid);
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		this.myIltb04InRecordDAO.tryToCloseSession();
		return "success";
	}

	public String toNew() throws Exception {
		try {
			if ("N".equals(this.isFlag)) {
				Timestamp ts = Timestamp.valueOf(this.ilPtrldt + " 00:00:00");
				this.iltb04InRecordId.setIlArcid(Integer.valueOf(this.ilArcid));
				this.iltb04InRecordId.setIlPtrldt(ts);
				this.iltb04InRecord.setId(this.iltb04InRecordId);
				this.iltb04InRecord.setIlPtrlst(this.ilPtrlst.trim());
				this.iltb04InRecord.setIlLmd(new Timestamp(System.currentTimeMillis()));
				this.iltb04InRecord.setIlMantype(this.ilMantype.trim());
				this.iltb04InRecord.setIlPtrlmrk(this.ilPtrlmrk.trim());
				this.iltb04InRecord.setIlUid(this.ilUid.trim());
				this.iltb04InRecord.setIlUnm(this.ilUnm.trim());
				boolean resultBoo = this.myIltb04InRecordDAO.updateData(this.iltb04InRecord);
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
				if ("1".equals(changeMode))
					doInsertLog("IL03A01Q02", LOGCN, LOGDID, LOGUID, LOGUIP, LOGTUP, LOGTDT, this.logcn,
							this.logpstname, this.main + this.detail, name, idno, Boolean.valueOf(resultBoo),
							this.iltb04InRecord);
				this.result = resultBoo + "";
				if (!resultBoo)
					this.isFlag = "F";
			}
			this.iltb04InRecordList = this.myIltb04InRecordDAO.getDataByIlArcid(this.ilArcid);
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		} finally {
			this.myIltb04InRecordDAO.tryToCloseSession();
		}
		return "success";
	}

	public String toUpdate() throws Exception {
		try {
			Timestamp ts = Timestamp.valueOf(this.ilPtrldt + " 00:00:00");
			Timestamp tsOri = Timestamp.valueOf(this.ilPtrldtOri + " 00:00:00");
			Iltb04InRecord iltb04InRecordbf = new Iltb04InRecord();
			boolean resultBoo = false;
			if (this.ilPtrldtOri.equals(this.ilPtrldt)) {
				this.iltb04InRecordId.setIlArcid(Integer.valueOf(this.ilArcid));
				this.iltb04InRecordId.setIlPtrldt(ts);
				iltb04InRecordbf = this.myIltb04InRecordDAO.findById(this.iltb04InRecordId);
				this.iltb04InRecord = iltb04InRecordbf;
				this.iltb04InRecord.setIlPtrlst(this.ilPtrlst.trim());
				this.iltb04InRecord.setIlLmd(new Timestamp(System.currentTimeMillis()));
				this.iltb04InRecord.setIlMantype(this.ilMantype.trim());
				this.iltb04InRecord.setIlPtrlmrk(this.ilPtrlmrk.trim());
				this.iltb04InRecord.setIlUid(this.ilUid.trim());
				this.iltb04InRecord.setIlUnm(this.ilUnm.trim());
				resultBoo = this.myIltb04InRecordDAO.updateData(this.iltb04InRecord);
			}
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
			if ("1".equals(changeMode))
				doUpdateLog("IL03A01Q02", LOGCN, LOGDID, LOGUID, LOGUIP, LOGTUP, LOGTDT, this.logcn, this.logpstname,
						this.main + this.detail, name, idno, Boolean.valueOf(resultBoo), iltb04InRecordbf,
						this.iltb04InRecord);
			this.result = resultBoo + "";
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		this.myIltb04InRecordDAO.tryToCloseSession();
		return "success";
	}

	public void doInsertLog(String url, String LOGCN, String LOGDID, String LOGUID, String LOGUIP, String LOGTUP,
			String LOGTDT, String queryName, String queryUnit, String queryGoal, String name, String idno,
			Boolean resultBoo, Iltb04InRecord bean) {
		logger.info("do Insert Log");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String systemDateTime = df.format(new Date());
		NPALog4J npaLog4J = new NPALog4J();
		StringBuffer queryMethodBuffer = new StringBuffer();
		queryMethodBuffer.append("");
		String queryMethodStr = queryMethodBuffer.toString();
		logger.info("新增條件內容" + queryMethodStr);
		if (!resultBoo.booleanValue()) {
			String listIdno = "";
			String listName = "";
			String str1 = "";
			/*
			int j = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID, LOGUIP,
					LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U04", OprType.Insert.toString(),
					this.constant.getApName(), "", "F", queryName, queryUnit, queryGoal, queryMethodStr, idno, name,
					str1, "", "", "");
			*/
			String j = npaLog4J.logging(LOGUID, // 使用者帳號 →原為「使用者帳號-中文名」，現拆為2個欄位
					LOGCN, // 使用者中文名 →原為「使用者帳號-中文名」，現拆為2個欄位
					LOGDID, // 使用者單位代碼
					LOGUIP, // IP
					LOGTDT, // 使用者登入時間 →原有格式不需調整，會自動轉成108年指定之格式
					Constant.getServername(), // AP伺服器名稱 →空白時，自動抓取該台Server名稱
					systemDateTime, // 使用者作業時間 →空白時，自動抓取當下時間
					"查察記事資料輸入畫面-IL02A01U04", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
					OprType.Insert.toString(), // 作業種類：N(新增)、D(刪除)、U(更新)、Q(查詢)、T(列印)、W(Web Service)、Z(查詢但不記次數)
					constant.getApName(), // AP系統代碼
					"", // 查詢結果，S(查有)、F(查無)
					"F", // 異動結果，S(異動成功)、F(異動失敗)
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
			
			logger.info("無異動日誌結果" + j);
			return;
		}
		String listBirth = "";
		String[] strs = new String[2];
		strs[0] = "居留資料關聯ID&查察結果&最後更新日期時間&人口分類&查察記事&註記者代碼&註記者姓名";
		int i = 1;
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append(bean.getId() + "&");
		strBuffer.append(CVUtil.trim(bean.getIlPtrlst()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlLmd()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlMantype()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlPtrlmrk()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlUid()) + "&");
		strBuffer.append(CVUtil.trim(bean.getIlUnm()) + "&");
		strs[i] = strBuffer.toString();
		i++;
		String str = npaLog4J.genQueryXML(strs);
		logger.info("新增結果內容" + str);
		/*
		int results = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID,
				LOGUIP, LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U04", OprType.Insert.toString(),
				this.constant.getApName(), "", "S", queryName, queryUnit, queryGoal, queryMethodStr, idno, name,
				listBirth, "", "", str);
		*/
		
		String results = npaLog4J.logging(LOGUID, // 使用者帳號 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGCN, // 使用者中文名 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGDID, // 使用者單位代碼
				LOGUIP, // IP
				LOGTDT, // 使用者登入時間 →原有格式不需調整，會自動轉成108年指定之格式
				Constant.getServername(), // AP伺服器名稱 →空白時，自動抓取該台Server名稱
				systemDateTime, // 使用者作業時間 →空白時，自動抓取當下時間
				"查察記事資料輸入畫面-IL02A01U04", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
				OprType.Insert.toString(), // 作業種類：N(新增)、D(刪除)、U(更新)、Q(查詢)、T(列印)、W(Web Service)、Z(查詢但不記次數)
				constant.getApName(), // AP系統代碼
				"", // 查詢結果，S(查有)、F(查無)
				"S", // 異動結果，S(異動成功)、F(異動失敗)
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
		
		logger.info("有異動日誌結果" + results);
	}

	public void doUpdateLog(String url, String LOGCN, String LOGDID, String LOGUID, String LOGUIP, String LOGTUP,
			String LOGTDT, String queryName, String queryUnit, String queryGoal, String name, String idno,
			Boolean resultBoo, Iltb04InRecord bean, Iltb04InRecord afbean) {
		logger.info("do UpDate Log");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String systemDateTime = df.format(new Date());
		NPALog4J npaLog4J = new NPALog4J();
		StringBuffer queryMethodBuffer = new StringBuffer();
		queryMethodBuffer.append("居留資料關聯ID=" + bean.getId());
		String queryMethodStr = queryMethodBuffer.toString();
		logger.info("更新條件內容" + queryMethodStr);
		String listBirth = "";
		String[] strs = new String[2];
		strs = generateModifyString(bean, afbean);
		String str = npaLog4J.genUpdateXML(strs[0], strs[1]);
		logger.info("更新結果內容" + str);
		/*
		int results = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID,
				LOGUIP, LOGTDT, Constant.getServername(), systemDateTime, "IL02A01U04", OprType.Update.toString(),
				this.constant.getApName(), "", !resultBoo.booleanValue() ? "F" : "S", queryName, queryUnit, queryGoal,
				queryMethodStr, idno, name, listBirth, "", "", str);
		*/
		
		String results = npaLog4J.logging(LOGUID, // 使用者帳號 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGCN, // 使用者中文名 →原為「使用者帳號-中文名」，現拆為2個欄位
				LOGDID, // 使用者單位代碼
				LOGUIP, // IP
				LOGTDT, // 使用者登入時間 →原有格式不需調整，會自動轉成108年指定之格式
				Constant.getServername(), // AP伺服器名稱 →空白時，自動抓取該台Server名稱
				systemDateTime, // 使用者作業時間 →空白時，自動抓取當下時間
				"查察記事資料輸入畫面-IL02A01U04", // 內容頁檔名 →需加入中文網頁名稱，英文網頁檔名若含有_(底線)，會自動拿掉
				OprType.Update.toString(), // 作業種類：N(新增)、D(刪除)、U(更新)、Q(查詢)、T(列印)、W(Web Service)、Z(查詢但不記次數)
				constant.getApName(), // AP系統代碼
				"", // 查詢結果，S(查有)、F(查無)
				!resultBoo.booleanValue() ? "F" : "S", // 異動結果，S(異動成功)、F(異動失敗)
				queryName, // 實際查詢人姓名
				queryUnit, // 實際查詢人單位
				queryGoal.substring(0, 3), // 實際查詢人用途代碼 →108年新增欄位
				queryGoal.substring(3), // 實際查詢人用途
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
		
		logger.info("有異動日誌結果" + results);
	}

	public String[] generateModifyString(Iltb04InRecord bf, Iltb04InRecord af) {
		List<String> beforeAry = new ArrayList<String>();
		List<String> afterAry = new ArrayList<String>();
		if (!CVUtil.equals(af.getIlPtrlst(), bf.getIlPtrlst())) {
			beforeAry.add("查察結果=" + bf.getIlPtrlst());
			afterAry.add("查察結果=" + af.getIlPtrlst());
		}
		if (!CVUtil.equals(af.getIlLmd(), bf.getIlLmd())) {
			beforeAry.add("最後更新日期時間=" + bf.getIlLmd());
			afterAry.add("最後更新日期時間=" + af.getIlLmd());
		}
		if (!CVUtil.equals(af.getIlMantype(), bf.getIlMantype())) {
			beforeAry.add("人口分類=" + bf.getIlMantype());
			afterAry.add("人口分類=" + af.getIlMantype());
		}
		if (!CVUtil.equals(af.getIlPtrlmrk(), bf.getIlPtrlmrk())) {
			beforeAry.add("查察記事=" + bf.getIlPtrlmrk());
			afterAry.add("查察記事=" + af.getIlPtrlmrk());
		}
		if (!CVUtil.equals(af.getIlUid(), bf.getIlUid())) {
			beforeAry.add("註記者代碼=" + bf.getIlUid());
			afterAry.add("註記者代碼=" + af.getIlUid());
		}
		if (!CVUtil.equals(af.getIlUnm(), bf.getIlUnm())) {
			beforeAry.add("註記者姓名=" + bf.getIlUnm());
			afterAry.add("註記者姓名=" + af.getIlUnm());
		}
		String[] rets = new String[2];
		rets[0] = StringUtils.join(beforeAry.toArray(), "&");
		rets[1] = StringUtils.join(afterAry.toArray(), "&");
		return rets;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL02A01U04.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */