package tw.gov.npa.il.action;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;

import com.aspose.words.MailMergeCleanupOptions;
import com.aspose.words.SectionStart;
import com.aspose.words.DataRelation;
import com.aspose.words.DataRow;
import com.aspose.words.DataSet;
import com.aspose.words.DataTable;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.aspose.cells.Color;
import com.aspose.cells.MsoFillFormat;
import com.aspose.cells.MsoLineFormat;
import com.aspose.cells.MsoPresetTextEffect;
import com.aspose.cells.PdfCompliance;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.Workbook;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.MailMerge;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
//import jxl.Workbook;
//import jxl.format.Alignment;
//import jxl.write.Label;
//import jxl.write.WritableCellFormat;
//import jxl.write.WritableFont;
//import jxl.write.WritableSheet;
//import jxl.write.WritableWorkbook;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb03MainRecord;
import tw.gov.npa.il.dao.Iltb15CountryCode;
import tw.gov.npa.il.dao.Iltb15CountryCodeDAO;
import tw.gov.npa.il.dao.Iltb16JobCode;
import tw.gov.npa.il.dao.Iltb17SchoolCode;
import tw.gov.npa.il.dao.Iltb23ImgIdxDAO;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.entity.IL07D;
import tw.gov.npa.il.entity.NpaLogEntity;
import tw.gov.npa.il.myDao.IL07DDao;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.myDao.MyIltb03MainRecordDAO;
import tw.gov.npa.il.myDao.MyIltb16JobCodeDAO;
import tw.gov.npa.il.myDao.OthersDAO;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.NpaLogUtil;

public class IL03A01Q04 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL03A01Q04.class);

	HttpServletRequest request;

	ResourceBundle rb = ResourceBundle.getBundle("config");

	private String contextPath = this.rb.getString("templatePath").toString();

	MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();

	MyIltb03MainRecordDAO iltb03MainRecordDAO = new MyIltb03MainRecordDAO();

	Iltb03MainRecord iltb03MainRecord = new Iltb03MainRecord();

	MyIltb16JobCodeDAO myIltb16JobCodeDAO = new MyIltb16JobCodeDAO();

	Iltb15CountryCodeDAO iltb15CountryCodeDAO = new Iltb15CountryCodeDAO();

	Iltb23ImgIdxDAO iltb23ImgIdxDAO = new Iltb23ImgIdxDAO();

	MyE0dtNpaunitDAO e0dtNpaunitDAO = new MyE0dtNpaunitDAO();

	private Iltb01Main iltb01Main = new Iltb01Main();

	private IL07DDao il07DDao;

	OthersDAO othersDAO = new OthersDAO();

	public OthersDAO getOthersDAO() {
		return othersDAO;
	}

	public void setOthersDAO(OthersDAO othersDAO) {
		this.othersDAO = othersDAO;
	}

	private int ilArcid;

	private String ilNtcd;
	// 國籍
	private String ilNTNM;
	// 職業
	private String ilOpnm;
	// 護照期限
	private String ilPsdt;
	// 抵台日期
	private String ilIndt;
	// 離台日期
	private String ilExdt;
	// 許可日期
	private String ilJbpmdt;
	// 許可效期起
	private String ilJbpmfm;
	// 許可效期迄
	private String ilJbpmto;
	// 申請日期
	private String ilApydt;
	// 居留效期起
	private String ilArcfm;
	// 居留效期迄
	private String ilArcto;
	// 重入國申請日期
	private String ilReapydt;
	// 重入國核准日期
	private String ilRepmdt;
	// 協尋行方不明日期
	private String ilMissdt;
	// 協尋報案日期
	private String ilSbmtdt;
	// 協尋尋獲日期
	private String ilFnddt;
	// 撤(註)銷居留/出國報備日期
	private String ilMrkdt;

	private String e0UnitSNm;
	// 在華親屬國籍
	private String ilNTNMFnt;

	private String result;

	private List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
	// 居留證號
	private String ilArcno;
	// 護照號碼
	private String ilPspt;
	// 英文姓名
	private String ilEnm;
	// 中文姓名
	private String ilCnm;
	// 服務處所
	private String ilOfnm;
	// 警局代號
	private String ilPhq;
	// 工作許可日期
//  private String ilJbpmdt;
	// 工作 許可文號
	private String ilJbpmdc;

	private Date nowDate = new Date();

	private String oriUrlFlag;
	// 原名
	private String ilOriEnm;
	// 照片位置
	private String arcnoPath;
	// 尋獲單位
	private String ilFnddNm;
	// 備註
	private String ilRemrk;

	private Constant constant = new Constant();
	// 製表姓名
	private String logcn;

	private String logpstname;

	private String main;

	private String detail;

	private List<String> arcnoHistoryList;
	
	private String ilIlId;

	List<IL07D> srchstCodes = new ArrayList<IL07D>();

	public String getIlIlId() {
		return ilIlId;
	}

	public void setIlIlId(String ilIlId) {
		this.ilIlId = ilIlId;
	}

	public List<String> getArcnoHistoryList() {
		return arcnoHistoryList;
	}

	public void setArcnoHistoryList(List<String> arcnoHistoryList) {
		this.arcnoHistoryList = arcnoHistoryList;
	}

	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public HttpServletRequest getRequest() {
		return this.request;
	}

	public String getIlFnddNm() {
		return this.ilFnddNm;
	}

	public void setIlFnddNm(String ilFnddNm) {
		this.ilFnddNm = ilFnddNm;
	}

	public String getIlRemrk() {
		return this.ilRemrk;
	}

	public void setIlRemrk(String ilRemrk) {
		this.ilRemrk = ilRemrk;
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

	public Constant getConstant() {
		return this.constant;
	}

	public void setConstant(Constant constant) {
		this.constant = constant;
	}

	public String getArcnoPath() {
		return this.arcnoPath;
	}

	public void setArcnoPath(String arcnoPath) {
		this.arcnoPath = arcnoPath;
	}

	public Iltb03MainRecord getIltb03MainRecord() {
		return this.iltb03MainRecord;
	}

	public void setIltb03MainRecord(Iltb03MainRecord iltb03MainRecord) {
		this.iltb03MainRecord = iltb03MainRecord;
	}

	public String getIlOriEnm() {
		return this.ilOriEnm;
	}

	public void setIlOriEnm(String ilOriEnm) {
		this.ilOriEnm = ilOriEnm;
	}

	public int getIlArcid() {
		return this.ilArcid;
	}

	public void setIlArcid(int ilArcid) {
		this.ilArcid = ilArcid;
	}

	public String getIlNTNM() {
		return this.ilNTNM;
	}

	public void setIlNTNM(String ilNTNM) {
		this.ilNTNM = ilNTNM;
	}

	public String getIlOpnm() {
		return this.ilOpnm;
	}

	public void setIlOpnm(String ilOpnm) {
		this.ilOpnm = ilOpnm;
	}

	public String getE0UnitSNm() {
		return this.e0UnitSNm;
	}

	public void setE0UnitSNm(String e0UnitSNm) {
		this.e0UnitSNm = e0UnitSNm;
	}

	public String getIlNTNMFnt() {
		return this.ilNTNMFnt;
	}

	public void setIlNTNMFnt(String ilNTNMFnt) {
		this.ilNTNMFnt = ilNTNMFnt;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Iltb01Main> getIltb01MainList() {
		return this.iltb01MainList;
	}

	public void setIltb01MainList(List<Iltb01Main> iltb01MainList) {
		this.iltb01MainList = iltb01MainList;
	}

	public Iltb01Main getIltb01Main() {
		return this.iltb01Main;
	}

	public void setIltb01Main(Iltb01Main iltb01Main) {
		this.iltb01Main = iltb01Main;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getIlArcno() {
		return this.ilArcno;
	}

	public void setIlArcno(String ilArcno) {
		this.ilArcno = ilArcno;
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

	public String getIlCnm() {
		return this.ilCnm;
	}

	public void setIlCnm(String ilCnm) {
		this.ilCnm = ilCnm;
	}

	public String getIlOfnm() {
		return this.ilOfnm;
	}

	public void setIlOfnm(String ilOfnm) {
		this.ilOfnm = ilOfnm;
	}

	public String getIlPhq() {
		return this.ilPhq;
	}

	public void setIlPhq(String ilPhq) {
		this.ilPhq = ilPhq;
	}

	public String getIlJbpmdt() {
		return this.ilJbpmdt;
	}

	public void setIlJbpmdt(String ilJbpmdt) {
		this.ilJbpmdt = ilJbpmdt;
	}

	public String getIlJbpmdc() {
		return this.ilJbpmdc;
	}

	public void setIlJbpmdc(String ilJbpmdc) {
		this.ilJbpmdc = ilJbpmdc;
	}

	public Date getNowDate() {
		return this.nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public String getOriUrlFlag() {
		return this.oriUrlFlag;
	}

	public void setOriUrlFlag(String oriUrlFlag) {
		this.oriUrlFlag = oriUrlFlag;
	}

	public String getIlNtcd() {
		return this.ilNtcd;
	}

	public void setIlNtcd(String ilNtcd) {
		this.ilNtcd = ilNtcd;
	}

	public String getIlPsdt() {
		return ilPsdt;
	}

	public void setIlPsdt(String ilPsdt) {
		this.ilPsdt = ilPsdt;
	}

	public String getIlIndt() {
		return ilIndt;
	}

	public void setIlIndt(String ilIndt) {
		this.ilIndt = ilIndt;
	}

	public String getIlExdt() {
		return ilExdt;
	}

	public void setIlExdt(String ilExdt) {
		this.ilExdt = ilExdt;
	}

	public String getIlJbpmfm() {
		return ilJbpmfm;
	}

	public void setIlJbpmfm(String ilJbpmfm) {
		this.ilJbpmfm = ilJbpmfm;
	}

	public String getIlJbpmto() {
		return ilJbpmto;
	}

	public void setIlJbpmto(String ilJbpmto) {
		this.ilJbpmto = ilJbpmto;
	}

	public String getIlApydt() {
		return ilApydt;
	}

	public void setIlApydt(String ilApydt) {
		this.ilApydt = ilApydt;
	}

	public String getIlArcfm() {
		return ilArcfm;
	}

	public void setIlArcfm(String ilArcfm) {
		this.ilArcfm = ilArcfm;
	}

	public String getIlArcto() {
		return ilArcto;
	}

	public void setIlArcto(String ilArcto) {
		this.ilArcto = ilArcto;
	}

	public String getIlReapydt() {
		return ilReapydt;
	}

	public void setIlReapydt(String ilReapydt) {
		this.ilReapydt = ilReapydt;
	}

	public String getIlRepmdt() {
		return ilRepmdt;
	}

	public void setIlRepmdt(String ilRepmdt) {
		this.ilRepmdt = ilRepmdt;
	}

	public String getIlMissdt() {
		return ilMissdt;
	}

	public void setIlMissdt(String ilMissdt) {
		this.ilMissdt = ilMissdt;
	}

	public String getIlSbmtdt() {
		return ilSbmtdt;
	}

	public void setIlSbmtdt(String ilSbmtdt) {
		this.ilSbmtdt = ilSbmtdt;
	}

	public String getIlFnddt() {
		return ilFnddt;
	}

	public void setIlFnddt(String ilFnddt) {
		this.ilFnddt = ilFnddt;
	}

	public String getIlMrkdt() {
		return ilMrkdt;
	}

	public void setIlMrkdt(String ilMrkdt) {
		this.ilMrkdt = ilMrkdt;
	}

	public IL07DDao getIl07DDao() {
		return il07DDao;
	}

	public void setIl07DDao(IL07DDao il07dDao) {
		il07DDao = il07dDao;
	}

	public List<IL07D> getSrchstCodes() {
		return srchstCodes;
	}

	public void setSrchstCodes(List<IL07D> srchstCodes) {
		this.srchstCodes = srchstCodes;
	}

	public String toMain() throws Exception {
		try {
			HttpSession httpSession = ServletActionContext.getRequest().getSession();
			String flag = (httpSession.getAttribute("flag") == "") ? "" : httpSession.getAttribute("flag").toString();
			this.iltb01Main = this.myIltb01MainDAO.findById(Integer.valueOf(this.ilArcid));
			this.srchstCodes = il07DDao.findAll();
			String aaa = this.iltb01Main.getIlRemrk();
			logger.info("iltb01Main.getIlRemrk():" + aaa);
			logger.info("iltb01Main:" + this.iltb01Main);
			if (this.iltb01Main != null) {
				this.ilNtcd = this.iltb01Main.getIlNtcd();
				Iltb15CountryCode iltb15CountryCode = this.iltb15CountryCodeDAO.findById(this.ilNtcd);
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
				if (!"".equals(Integer.valueOf(this.ilArcid)) && this.ilArcid != 0) {
					List<Iltb03MainRecord> iltb03MainRecordList = this.iltb03MainRecordDAO
							.getDataByIlArcidAndIlEnmIsNotNull(this.ilArcid);
					if (iltb03MainRecordList != null && iltb03MainRecordList.size() > 0)
						this.iltb03MainRecord = iltb03MainRecordList.get(0);
				}
				if (this.iltb03MainRecord != null)
					this.ilOriEnm = this.iltb03MainRecord.getIlEnm();

				if (iltb01Main.getIlSrchst() != null && !iltb01Main.getIlSrchst().equals("")
						&& !"00".equals(iltb01Main.getIlSrchst())) {
					String srchstnm = this.iltb01Main.getIlSrchst();
					for (int j = 0; j < srchstCodes.size(); j++) {
						if (srchstnm.equals(srchstCodes.get(j).getSRCHST())) {
							iltb01Main.setIlSrchst(srchstCodes.get(j).getSRCHSTNM());
						}
					}
				} else {
					iltb01Main.setIlSrchst("");
				}/*
				if (iltb01Main.getIlIlId() != null && !iltb01Main.getIlIlId().equals("")) {
					arcnoHistoryList = this.myIltb01MainDAO.getIlidListByIlIlId(iltb01Main.getIlIlId());
				} else {
					arcnoHistoryList = new ArrayList<Iltb01Main>();
					arcnoHistoryList.add(iltb01Main);
				}*/
				String ilFnddid = this.iltb01Main.getIlFnddid();

				this.ilFnddNm = othersDAO.queryCodeDetail(ilFnddid);
				this.ilRemrk = othersDAO.queryIlRemrk(ilArcid);

//				Class.forName("com.sybase.jdbc3.jdbc.SybDriver").newInstance();
//				String url = "jdbc:sybase:Tds:200.200.68.70:4100/IL2DB";
//				Properties sysProps = System.getProperties();
//				sysProps.put("user", "ILU001");
//				sysProps.put("password", "#il-ps01");
//				Connection conn = DriverManager.getConnection(url, sysProps);
//				Statement stmt = conn.createStatement(1005, 1008);
//				this.ilFnddNm = ilFnddid;
//				ResultSet FnddNm1 = stmt.executeQuery(
//						"select * from ILTB_CODEDETAIL where IL_CKIND = 'QP' and IL_CID = '" + ilFnddid + "'");
//				while (FnddNm1.next()) {
//					String ilFnddNm2 = FnddNm1.getString(2);
//					String ilFnddNm3 = FnddNm1.getString(3);
//					if (ilFnddNm2.equals(ilFnddid))
//						this.ilFnddNm = ilFnddid + ilFnddNm3;
//				}
//				ResultSet Remrk = stmt.executeQuery("select * from ILTB_01_MAIN WHERE IL_ARCID = " + this.ilArcid);
//				while (Remrk.next()) {
//					String Remrk1 = Remrk.getString("IL_REMRK");
//					this.ilRemrk = Remrk1;
//				}
				String arcno = this.iltb01Main.getIlArcno();
				String movePath = "./PICTURES/Fr/" + arcno.substring(0, 1) + "/" + arcno.substring(1, 2) + "/"
						+ arcno.substring(2, 5) + "/" + arcno.substring(5, 8) + "/";
				this.arcnoPath = movePath + arcno;
			}
			httpSession.setAttribute("flag", "");
			NpaLogEntity logEntity = new NpaLogEntity();
			logEntity.setLogUID((String) httpSession.getAttribute("LOGUID"));
			logEntity.setLogCN((String) httpSession.getAttribute("LOGCN"));
			logEntity.setLogDID((String) httpSession.getAttribute("LOGDID"));
			logEntity.setLogGUIP((String) httpSession.getAttribute("LOGUIP"));
			logEntity.setLogTDT((String) httpSession.getAttribute("LOGTDT"));
			logEntity.setServerName(Constant.getServername());
			logEntity.setApName(this.constant.getApName());
			logEntity.setOprName(this.logcn);
			logEntity.setOprUnit(this.logpstname);
			logEntity.setOprGoal(this.main + this.detail);
			DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String systemDateTime = df.format(new Date());
			logEntity.setSystemDateTime(systemDateTime);
			logEntity.setPageName("居留外僑資料查詢明細-IL03A01Q04");
			logEntity.setOprClass(OprType.Query.toString());
			StringBuffer queryMethodBuffer = new StringBuffer();
			queryMethodBuffer.append("外來人口統一證號=" + this.iltb01Main.getIlArcno() + "&");
			queryMethodBuffer.append("護照號碼=" + this.iltb01Main.getIlPspt() + "&");
			queryMethodBuffer.append("英文姓名=" + this.iltb01Main.getIlEnm() + "&");
			queryMethodBuffer.append("國籍名稱=" + this.ilNTNM);
			String queryMethodStr = queryMethodBuffer.toString();
			logEntity.setOtherQeryStr(queryMethodStr);
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String changeMode = rb.getString("changeMode").toString();
			if ("1".equals(changeMode))
				if (this.iltb01Main != null) {
					logEntity.setQueryRes("S");
					List<String> tmpContent = new ArrayList<String>();
					tmpContent.add(
							"英文姓名&原名&中文姓名&性別&國籍&出生日期&護照號碼&護照期限&教育程度&抵台日期&離台日期&職業&居留事由&居留狀況&縮影編號&服務處所&職位&工作地址&電話&居留地址&電話&備註&機關&許可日期&文號&許可效期&申請日期&收據號碼&外來人口統一證號&居留效期&管轄分局&外責區&稱謂&姓名&國籍&身分(居留)證號&申請日期&類別&原許可證號(6位)&核准期限&備考&新許可證號(10位)&處理情形&行方不明日期&報案日期&報案方式&尋獲單位&尋獲日期&原因&日期&文號&");
					StringBuffer sb = new StringBuffer();
					sb.append(this.iltb01Main.getIlEnm()).append("&");
					sb.append(getIlOriEnm()).append("&");
					sb.append(this.iltb01Main.getIlCnm()).append("&");
					sb.append(this.iltb01Main.getIlSex()).append("&");
					sb.append(getIlNTNM()).append("&");
					sb.append(this.iltb01Main.getIlBthdt()).append("&");
					sb.append(this.iltb01Main.getIlPspt()).append("&");
					sb.append(this.iltb01Main.getIlPsdt()).append("&");
					sb.append(this.iltb01Main.getIlEdu()).append("&");
					sb.append(this.iltb01Main.getIlIndt()).append("&");
					sb.append(this.iltb01Main.getIlExdt()).append("&");
					sb.append(getIlOpnm()).append("&");
					sb.append(this.iltb01Main.getIlArcrsn()).append("&");
					sb.append(this.iltb01Main.getIlArcst()).append("&");
					sb.append(this.iltb01Main.getIlMicro()).append("&");
					sb.append(this.iltb01Main.getIlOfnm()).append("&");
					sb.append(this.iltb01Main.getIlJbpsn()).append("&");
					sb.append(this.iltb01Main.getIlJbaddr()).append("&");
					sb.append(this.iltb01Main.getIlJbtel()).append("&");
					sb.append(this.iltb01Main.getIlAraddr()).append("&");
					sb.append(this.iltb01Main.getIlArtel()).append("&");
					sb.append(getIlRemrk()).append("&");
					sb.append(this.iltb01Main.getIlJbpmcd()).append("&");
					sb.append(this.iltb01Main.getIlJbpmdt()).append("&");
					sb.append(this.iltb01Main.getIlJbpmdc()).append("&");
					sb.append(this.iltb01Main.getIlJbpmfm()).append("~").append(this.iltb01Main.getIlJbpmto())
							.append("&");
					sb.append(this.iltb01Main.getIlApydt()).append("&");
					sb.append(this.iltb01Main.getIlArcrcp()).append("&");
					sb.append(this.iltb01Main.getIlArcno()).append("&");
					sb.append(this.iltb01Main.getIlArcfm()).append("~").append(this.iltb01Main.getIlArcto())
							.append("&");
					sb.append(getE0UnitSNm()).append("&");
					sb.append(this.iltb01Main.getIlPstext()).append("&");
					sb.append(this.iltb01Main.getIlFrshp()).append("&");
					sb.append(this.iltb01Main.getIlFnm()).append("&");
					sb.append(getIlNTNMFnt()).append("&");
					sb.append(this.iltb01Main.getIlFpid()).append("&");
					sb.append(this.iltb01Main.getIlReapydt()).append("&");
					sb.append(this.iltb01Main.getIlRetp()).append("&");
					sb.append(this.iltb01Main.getIlRepmdc()).append("&");
					sb.append(this.iltb01Main.getIlRepmdt()).append("&");
					sb.append(this.iltb01Main.getIlRrnote()).append("&");
					sb.append(this.iltb01Main.getIlRepmdcNic()).append("&");
					sb.append(this.iltb01Main.getIlSrchst()).append("&");
					sb.append(this.iltb01Main.getIlMissdt()).append("&");
					sb.append(this.iltb01Main.getIlSbmtdt()).append("&");
					sb.append(this.iltb01Main.getIlSbmttp()).append("&");
					sb.append(this.iltb01Main.getIlFnddid()).append("&");
					sb.append(this.iltb01Main.getIlFnddt()).append("&");
					sb.append(this.iltb01Main.getIlFbdrsn()).append("&");
					sb.append(this.iltb01Main.getIlMrkdt()).append("&");
					sb.append(this.iltb01Main.getIlMrkdc());
					String ssb = sb.toString();
					tmpContent.add(ssb);
					logEntity.setContent(NpaLogUtil.getOtherContent(tmpContent.<String>toArray(new String[0])));
					NpaLogUtil.doLogging(logEntity);
				} else {
					logEntity.setQueryRes("F");
					NpaLogUtil.doLogging(logEntity);
				}
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
		}
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (!"".equals(this.oriUrlFlag) && this.oriUrlFlag != null)
			session.setAttribute("oriUrlFlag", this.oriUrlFlag);
		return "success";
	}

	protected void InsertWaterMarkToXLS(com.aspose.cells.Workbook workbook, Worksheet sheet, String watermarkText,
			int upperLeftRow, int top, int upperLeftColumn, int left, int height, int width) {
		// 添加浮水印
		com.aspose.cells.Shape wordart = sheet.getShapes().addTextEffect(MsoPresetTextEffect.TEXT_EFFECT_1,
				watermarkText, "標楷體 標準", 20, false, true, upperLeftRow, top, upperLeftColumn, left, height, width);
		wordart.setRotationAngle(-30);
		// 用藝術字體填充
		MsoFillFormat wordArtFormat = wordart.getFillFormat();
		// 設置顏色
		wordArtFormat.setForeColor(Color.getGray());
		// 設置透明度
		wordArtFormat.setTransparency(0.5);
		// 設置線條不可見
		MsoLineFormat lineFormat = wordart.getLineFormat();
		lineFormat.setForeColor(Color.getWhite());
		lineFormat.setTransparency(0.5);
	}

	/**
	 * 匯出"外僑居留資料查詢-外僑明細內容顯示畫面"Excel
	 */
	public void downloadExcel() {

		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String time = (String) session.getAttribute("LOGTDT");
			String watermark = (String) session.getAttribute("LOGUNITNM") + "-" + (String) session.getAttribute("LOGCN")
					+ "-" + time;
			com.aspose.cells.License license = new com.aspose.cells.License();
			license.setLicense("Aspose.Total.Java.lic");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Content-Disposition", "attachment; filename=\"IL03A01Q04Excel.xls\"");
			Workbook wb = new Workbook(contextPath + "IL03A01Q04Excel.xls");
			Worksheet sheet = wb.getWorksheets().get(0);
			int maxRow = sheet.getCells().getMaxDataRow();
			int maxCol = sheet.getCells().getMaxDataColumn();
			for (int i = 0; i < maxCol; i++) {
				for (int k = 0; k < maxRow; k++) {
					InsertWaterMarkToXLS(wb, sheet, watermark, k, k, i, i, 30, 800);
					k++;
					k++;
					k++;
					k++;
					k++;
				}
				i++;
				i++;
				i++;
				i++;
			}
//			WorksheetCollection Wsheetc = wb.getWorksheets();

//			com.aspose.cells.Shape wordart = sheet.getShapes().addTextEffect(MsoPresetTextEffect.TEXT_EFFECT_1, watermark, "標楷體 標準", 60, false, true , 18, 8, 1, 1, 130,  1200);
//			MsoFillFormat wordArtFormat = wordart.getFillFormat();
//
//			wordArtFormat.setForeColor(Color.getGray());
//
//			wordArtFormat.setTransparency(0.9);
//
//			MsoLineFormat lineFormat = wordart.getLineFormat();
//
//			lineFormat.setVisible(false);
//			putWatermarkOnExcel(sheet, watermark);
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			designer.setDataSource("LOGUNITNM", session.getAttribute("LOGUNITNM")); // 列印單位
			designer.setDataSource("LOGCN", session.getAttribute("LOGCN")); // 列印人
			designer.setDataSource("LOGDT", sdf.format(new Date())); // 列印日期

			designer.setDataSource("ILENM", iltb01Main.getIlEnm()); // 英文姓名
			designer.setDataSource("ILORIENM", getIlOriEnm()); // 原名
			designer.setDataSource("ILCNM", iltb01Main.getIlCnm()); // 中文姓名
			designer.setDataSource("ILSEX", "1".equals(iltb01Main.getIlSex()) ? "男" : "女"); // 性別
			designer.setDataSource("ILNTNM", getIlNTNM()); // 國籍
			designer.setDataSource("ILBTHDT", iltb01Main.getIlBthdt().substring(0, 4) + "年"
					+ iltb01Main.getIlBthdt().substring(4, 6) + "年" + iltb01Main.getIlBthdt().substring(6, 8) + "日"); // 出生日期
			designer.setDataSource("ILPSPT", iltb01Main.getIlPspt()); // 護照號碼
			designer.setDataSource("ILPSDT", getIlPsdt()); // 護照期限
			switch (iltb01Main.getIlEdu()) {
			case "00":
				iltb01Main.setIlEdu("");
				break;
			case "01":
				iltb01Main.setIlEdu("博士");
				break;
			case "02":
				iltb01Main.setIlEdu("碩士");
				break;
			case "03":
				iltb01Main.setIlEdu("大學畢業");
				break;
			case "04":
				iltb01Main.setIlEdu("大學肄業");
				break;
			case "05":
				iltb01Main.setIlEdu("專科畢業");
				break;
			case "06":
				iltb01Main.setIlEdu("專科肄業");
				break;
			case "07":
				iltb01Main.setIlEdu("高中畢業");
				break;
			case "08":
				iltb01Main.setIlEdu("高中肄業");
				break;
			case "09":
				iltb01Main.setIlEdu("初中畢業");
				break;
			case "10":
				iltb01Main.setIlEdu("初中肄業");
				break;
			case "11":
				iltb01Main.setIlEdu("小學畢業");
				break;
			case "12":
				iltb01Main.setIlEdu("小學肄業");
				break;
			case "13":
				iltb01Main.setIlEdu("識字");
				break;
			case "14":
				iltb01Main.setIlEdu("不識字");
				break;
			case "15":
				iltb01Main.setIlEdu("不明");
				break;
			}
			designer.setDataSource("ILEDU", iltb01Main.getIlEdu()); // 教育程度
			designer.setDataSource("ILINDT", getIlIndt()); // 抵台日期
			designer.setDataSource("ILOPNM", getIlOpnm()); // 職業
			designer.setDataSource("ILEXDT", getIlExdt()); // 離台日期
			switch (iltb01Main.getIlArcrsn()) {
			case "0":
				iltb01Main.setIlArcrsn("");
				break;
			case "1":
				iltb01Main.setIlArcrsn("依親");
				break;
			case "2":
				iltb01Main.setIlArcrsn("就學");
				break;
			case "3":
				iltb01Main.setIlArcrsn("應聘");
				break;
			case "4":
				iltb01Main.setIlArcrsn("投資");
				break;
			case "5":
				iltb01Main.setIlArcrsn("傳教");
				break;
			case "6":
				iltb01Main.setIlArcrsn("其他");
				break;
			case "7":
				iltb01Main.setIlArcrsn("外勞");
				break;
			case "8":
				iltb01Main.setIlArcrsn("永居(連續居留七年)");
				break;
			case "9":
				iltb01Main.setIlArcrsn("永居(依親五年配偶)");
				break;
			case "A":
				iltb01Main.setIlArcrsn("永居(依親五年子女)");
				break;
			case "B":
				iltb01Main.setIlArcrsn("永居(依親居住十五年)");
				break;
			case "C":
				iltb01Main.setIlArcrsn("永居(依親居住十年)");
				break;
			case "D":
				iltb01Main.setIlArcrsn("永居(居住二十年者)");
				break;
			case "E":
				iltb01Main.setIlArcrsn("永居(高科技人士)");
				break;
			case "F":
				iltb01Main.setIlArcrsn("永居(特殊貢獻者)");
				break;
			case "G":
				iltb01Main.setIlArcrsn("永居(其他)");
				break;
			}
			designer.setDataSource("ILARCRSN", iltb01Main.getIlArcrsn()); // 居留事由
			switch (iltb01Main.getIlArcst()) {
			case "1":
				iltb01Main.setIlArcst("改變國籍(原具我國籍者)");
				break;
			case "2":
				iltb01Main.setIlArcst("在台");
				break;
			case "3":
				iltb01Main.setIlArcst("離台");
				break;
			case "4":
				iltb01Main.setIlArcst("死亡");
				break;
			case "5":
				iltb01Main.setIlArcst("註銷居留證");
				break;
			case "6":
				iltb01Main.setIlArcst("棄原國籍取我國籍");
				break;
			}
			designer.setDataSource("ILARCST", iltb01Main.getIlArcst()); // 居留狀況
			designer.setDataSource("ILMICRO", iltb01Main.getIlMicro()); // 縮影編號
			designer.setDataSource("ILOFNM", iltb01Main.getIlOfnm()); // 服務處所
			designer.setDataSource("ILOFTEL", iltb01Main.getIlOftel()); // 服務處所電話
			designer.setDataSource("ILJBPZONE", iltb01Main.getIlJbpzone() + " " + iltb01Main.getIlJbaddr()); // 工作地址
			designer.setDataSource("ILJBTEL", iltb01Main.getIlJbtel()); // 工作地電話
			designer.setDataSource("ILARPZONE", iltb01Main.getIlArpzone() + " " + iltb01Main.getIlAraddr()); // 居留地址
			designer.setDataSource("ILARTEL", iltb01Main.getIlArtel()); // 居留地電話
			designer.setDataSource("ILAGNCO", iltb01Main.getIlAgnco()); // 仲介
			designer.setDataSource("ILAGNTEL", iltb01Main.getIlAgntel()); // 仲介電話
			designer.setDataSource("ILREMRK", getIlRemrk()); // 備註
			designer.setDataSource("ILJBPSN", iltb01Main.getIlJbpsn()); // 職位
			switch (iltb01Main.getIlJbpmcd()) {
			case "0":
				iltb01Main.setIlJbpmcd("");
				break;
			case "1":
				iltb01Main.setIlJbpmcd("勞動部");
				break;
			case "2":
				iltb01Main.setIlJbpmcd("內政部");
				break;
			case "3":
				iltb01Main.setIlJbpmcd("經濟部");
				break;
			case "4":
				iltb01Main.setIlJbpmcd("經濟部投審會");
				break;
			case "5":
				iltb01Main.setIlJbpmcd("科學園區管理局");
				break;
			case "6":
				iltb01Main.setIlJbpmcd("教育部");
				break;
			case "7":
				iltb01Main.setIlJbpmcd("交通部");
				break;
			case "8":
				iltb01Main.setIlJbpmcd("國防部");
				break;
			case "9":
				iltb01Main.setIlJbpmcd("新聞局");
				break;
			case "-":
				iltb01Main.setIlJbpmcd("衛生署");
				break;
			case "A":
				iltb01Main.setIlJbpmcd("台北市政府");
				break;
			case "B":
				iltb01Main.setIlJbpmcd("台中市政府");
				break;
			case "C":
				iltb01Main.setIlJbpmcd("基隆市政府");
				break;
			case "D":
				iltb01Main.setIlJbpmcd("台南市政府");
				break;
			case "E":
				iltb01Main.setIlJbpmcd("高雄市政府");
				break;
			case "F":
				iltb01Main.setIlJbpmcd("台北縣政府");
				break;
			case "G":
				iltb01Main.setIlJbpmcd("宜蘭縣政府");
				break;
			case "H":
				iltb01Main.setIlJbpmcd("桃園縣政府");
				break;
			case "I":
				iltb01Main.setIlJbpmcd("嘉義市政府");
				break;
			case "J":
				iltb01Main.setIlJbpmcd("新竹縣政府");
				break;
			case "K":
				iltb01Main.setIlJbpmcd("苗栗縣政府");
				break;
			case "L":
				iltb01Main.setIlJbpmcd("台中縣政府");
				break;
			case "M":
				iltb01Main.setIlJbpmcd("南投縣政府");
				break;
			case "N":
				iltb01Main.setIlJbpmcd("彰化縣政府");
				break;
			case "O":
				iltb01Main.setIlJbpmcd("新竹市政府");
				break;
			case "P":
				iltb01Main.setIlJbpmcd("雲林縣政府");
				break;
			case "Q":
				iltb01Main.setIlJbpmcd("嘉義縣政府");
				break;
			case "R":
				iltb01Main.setIlJbpmcd("台南縣政府");
				break;
			case "S":
				iltb01Main.setIlJbpmcd("高雄縣政府");
				break;
			case "T":
				iltb01Main.setIlJbpmcd("屏東縣政府");
				break;
			case "U":
				iltb01Main.setIlJbpmcd("花蓮縣政府");
				break;
			case "V":
				iltb01Main.setIlJbpmcd("台東縣政府");
				break;
			case "W":
				iltb01Main.setIlJbpmcd("金門縣政府");
				break;
			case "X":
				iltb01Main.setIlJbpmcd("澎湖縣政府");
				break;
			case "Y":
				iltb01Main.setIlJbpmcd("連江縣政府");
				break;
			case "Z":
				iltb01Main.setIlJbpmcd("其他");
				break;
			}
			designer.setDataSource("ILJBPMCD", iltb01Main.getIlJbpmcd()); // 機關
			designer.setDataSource("ILJBPMDT", getIlJbpmdt()); // 許可日期
			designer.setDataSource("ILJBPMDC", iltb01Main.getIlJbpmdc()); // 文號
			designer.setDataSource("ILJBPMFMTO", getIlJbpmfm() + " ~ " + getIlJbpmto()); // 許可效期
			designer.setDataSource("ILAPYDT", getIlApydt()); // 申請日期
			designer.setDataSource("ILARCRCP", iltb01Main.getIlArcrcp()); // 收據號碼
			designer.setDataSource("ILARCNO", iltb01Main.getIlArcno()); // 居留證號
			designer.setDataSource("ILARCFMTO", getIlArcfm() + " ~ " + getIlArcto()); // 居留效期
			designer.setDataSource("ILE0UNITSNM", getE0UnitSNm()); // 管轄分局
			designer.setDataSource("ILPSTEXT", iltb01Main.getIlPstext()); // 外責區
			switch (iltb01Main.getIlFrshp()) {
			case "00":
				iltb01Main.setIlFrshp("");
				break;
			case "01":
				iltb01Main.setIlFrshp("夫");
				break;
			case "02":
				iltb01Main.setIlFrshp("妻");
				break;
			case "03":
				iltb01Main.setIlFrshp("父");
				break;
			case "04":
				iltb01Main.setIlFrshp("母");
				break;
			case "05":
				iltb01Main.setIlFrshp("子");
				break;
			case "06":
				iltb01Main.setIlFrshp("女");
				break;
			case "07":
				iltb01Main.setIlFrshp("祖父");
				break;
			case "08":
				iltb01Main.setIlFrshp("祖母");
				break;
			case "09":
				iltb01Main.setIlFrshp("兄");
				break;
			case "10":
				iltb01Main.setIlFrshp("弟");
				break;
			case "11":
				iltb01Main.setIlFrshp("姊");
				break;
			case "12":
				iltb01Main.setIlFrshp("妹");
				break;
			case "13":
				iltb01Main.setIlFrshp("其他");
				break;
			}
			designer.setDataSource("ILFRSHP", iltb01Main.getIlFrshp()); // 稱謂
			designer.setDataSource("ILFNM", iltb01Main.getIlFnm()); // 姓名
			designer.setDataSource("IlNTNMFNT", getIlNTNMFnt()); // 國籍
			designer.setDataSource("ILFPID", iltb01Main.getIlFpid()); // 身分(居留)證號

			designer.setDataSource("ILREAPYDT", getIlReapydt()); // 申請日期
			String ilRetp = "";
			if ("1".equals(iltb01Main.getIlRetp())) {
				ilRetp = "單次";
			} else if ("2".equals(iltb01Main.getIlRetp())) {
				ilRetp = "多次";
			}
			designer.setDataSource("ILRETP", ilRetp); // 類別
			designer.setDataSource("ILREPMDT", getIlRepmdt()); // 核准期限
			designer.setDataSource("ILRRNOTE", iltb01Main.getIlRrnote()); // 備考
			designer.setDataSource("ILREPMDC", iltb01Main.getIlRepmdc()); // 原許可證號(6位)
			designer.setDataSource("ILREPMDCNIC", iltb01Main.getIlRepmdcNic()); // 新許可證號(10位)
			switch (iltb01Main.getIlSrchst()) {
			case "00":
				iltb01Main.setIlSrchst("");
				break;
			case "31":
				iltb01Main.setIlSrchst("行方不明");
				break;
			case "32":
				iltb01Main.setIlSrchst("取消協尋通報");
				break;
			case "33":
				iltb01Main.setIlSrchst("查獲或收容");
				break;
			case "34":
				iltb01Main.setIlSrchst("取消收容通報");
				break;
			case "35":
				iltb01Main.setIlSrchst("收容費預墊");
				break;
			case "36":
				iltb01Main.setIlSrchst("取消預墊通報");
				break;
			}
			designer.setDataSource("ILSRCHST", iltb01Main.getIlSrchst()); // 處理情形
			designer.setDataSource("ILMISSDT", getIlMissdt()); // 行方不明日期
			designer.setDataSource("ILSBMTDT", getIlSbmtdt()); // 報案日期
			switch (iltb01Main.getIlSbmttp()) {
			case "0":
				iltb01Main.setIlSbmttp("");
				break;
			case "1":
				iltb01Main.setIlSbmttp("關係人報案");
				break;
			case "2":
				iltb01Main.setIlSbmttp("警局主動註記");
				break;
			case "3":
				iltb01Main.setIlSbmttp("雇主書面通知");
				break;
			}
			designer.setDataSource("ILSBMTTP", iltb01Main.getIlSbmttp()); // 報案方式
			designer.setDataSource("ILFNDDNM", getIlFnddNm()); // 尋獲單位
			designer.setDataSource("ILFNDDT", getIlFnddt()); // 尋獲日期

			switch (iltb01Main.getIlFbdrsn()) {
			case "0":
				iltb01Main.setIlFbdrsn("");
				break;
			case "1":
				iltb01Main.setIlFbdrsn("申請資料係偽(變)造者");
				break;
			case "2":
				iltb01Main.setIlFbdrsn("經判處一年以上刑期者");
				break;
			case "3":
				iltb01Main.setIlFbdrsn("每年居住未達183天者");
				break;
			case "4":
				iltb01Main.setIlFbdrsn("回復或取得我國國籍者");
				break;
			case "5":
				iltb01Main.setIlFbdrsn("已取得外僑永久居留證者");
				break;
			case "6":
				iltb01Main.setIlFbdrsn("經撤銷聘僱許可並限令出國者");
				break;
			case "7":
				iltb01Main.setIlFbdrsn("其他");
				break;
			case "8":
				iltb01Main.setIlFbdrsn("休學");
				break;
			case "9":
				iltb01Main.setIlFbdrsn("退學");
				break;
			case "A":
				iltb01Main.setIlFbdrsn("畢業");
				break;
			case "B":
				iltb01Main.setIlFbdrsn("申請資料虛偽或不實");
				break;
			case "C":
				iltb01Main.setIlFbdrsn("持用不法取得、偽造或變造之證件");
				break;
			case "D":
				iltb01Main.setIlFbdrsn("回復我國籍");
				break;
			case "E":
				iltb01Main.setIlFbdrsn("取得我國籍");
				break;
			case "F":
				iltb01Main.setIlFbdrsn("兼具我國籍，以國民身分入出國、居留或定居");
				break;
			case "G":
				iltb01Main.setIlFbdrsn("受驅逐出國");
				break;
			case "H":
				iltb01Main.setIlFbdrsn("經許可定居");
				break;
			case "I":
				iltb01Main.setIlFbdrsn("離婚");
				break;
			case "J":
				iltb01Main.setIlFbdrsn("離婚配偶喪失子女扶養權");
				break;
			case "K":
				iltb01Main.setIlFbdrsn("依親對象居留事由消失者");
				break;
			case "L":
				iltb01Main.setIlFbdrsn("當事人主動撤銷");
				break;
			case "M":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-中途解約");
				break;
			case "N":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-連續三日曠職");
				break;
			case "O":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-非法工作");
				break;
			case "P":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-健檢不合格");
				break;
			case "Q":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-轉換雇主不成功");
				break;
			case "R":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-投資");
				break;
			case "S":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-傳教");
				break;
			case "T":
				iltb01Main.setIlFbdrsn("死亡");
				break;
			}
			designer.setDataSource("ILFBDRSN", iltb01Main.getIlFbdrsn()); // 原因
			designer.setDataSource("ILMRKDT", getIlMrkdt()); // 日期
			designer.setDataSource("ILMRKDC", iltb01Main.getIlMrkdc()); // 文號
			designer.process(true);
			response.setContentType("application/vnd.ms-excel");
			wb.save(response.getOutputStream(), wb.getFileFormat());

			response.flushBuffer();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error!");
		}

	}

	/**
	 * 匯出"外僑居留資料查詢-外僑明細內容顯示畫面"Excel
	 */
	public void downloadPdf() {
		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			String time = (String) session.getAttribute("LOGTDT");
			String watermark = (String) session.getAttribute("LOGUNITNM") + "-" + (String) session.getAttribute("LOGCN")
					+ "-" + time.substring(0, 10);
			com.aspose.cells.License license = new com.aspose.cells.License();
			license.setLicense("Aspose.Total.Java.lic");
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Content-Disposition", "attachment; filename=\"IL03A01Q04Excel.pdf\"");
			Workbook wb = new Workbook(contextPath + "IL03A01Q04Excel.xlsx");
			Worksheet sheet = wb.getWorksheets().get(0);
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);
			int maxRow = sheet.getCells().getMaxDataRow();
			int maxCol = sheet.getCells().getMaxDataColumn();
			
				for (int k = 0; k < maxRow; k++) {
					InsertWaterMarkToXLS(wb, sheet, watermark, k, k, 0, 0, 50, 1300);
					k++;
					k++;
					k++;
					k++;
					k++;
					k++;
					k++;
					k++;
				}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

			designer.setDataSource("LOGUNITNM", session.getAttribute("LOGUNITNM")); // 列印單位
			designer.setDataSource("LOGCN", session.getAttribute("LOGCN")); // 列印人
			designer.setDataSource("LOGDT", sdf.format(new Date())); // 列印日期
			designer.setDataSource("ILENM", iltb01Main.getIlEnm()); // 英文姓名
			designer.setDataSource("ILORIENM", getIlOriEnm()); // 原名
			designer.setDataSource("ILCNM", iltb01Main.getIlCnm()); // 中文姓名
			designer.setDataSource("ILSEX", "1".equals(iltb01Main.getIlSex()) ? "男" : "女"); // 性別
			designer.setDataSource("ILNTNM", getIlNTNM()); // 國籍
			designer.setDataSource("ILBTHDT", iltb01Main.getIlBthdt().substring(0, 4) + "年"
					+ iltb01Main.getIlBthdt().substring(4, 6) + "年" + iltb01Main.getIlBthdt().substring(6, 8) + "日"); // 出生日期
			designer.setDataSource("ILPSPT", iltb01Main.getIlPspt()); // 護照號碼
			designer.setDataSource("ILPSDT", getIlPsdt()); // 護照期限
			switch (iltb01Main.getIlEdu()) {
			case "00":
				iltb01Main.setIlEdu("");
				break;
			case "01":
				iltb01Main.setIlEdu("博士");
				break;
			case "02":
				iltb01Main.setIlEdu("碩士");
				break;
			case "03":
				iltb01Main.setIlEdu("大學畢業");
				break;
			case "04":
				iltb01Main.setIlEdu("大學肄業");
				break;
			case "05":
				iltb01Main.setIlEdu("專科畢業");
				break;
			case "06":
				iltb01Main.setIlEdu("專科肄業");
				break;
			case "07":
				iltb01Main.setIlEdu("高中畢業");
				break;
			case "08":
				iltb01Main.setIlEdu("高中肄業");
				break;
			case "09":
				iltb01Main.setIlEdu("初中畢業");
				break;
			case "10":
				iltb01Main.setIlEdu("初中肄業");
				break;
			case "11":
				iltb01Main.setIlEdu("小學畢業");
				break;
			case "12":
				iltb01Main.setIlEdu("小學肄業");
				break;
			case "13":
				iltb01Main.setIlEdu("識字");
				break;
			case "14":
				iltb01Main.setIlEdu("不識字");
				break;
			case "15":
				iltb01Main.setIlEdu("不明");
				break;
			}
			designer.setDataSource("ILEDU", iltb01Main.getIlEdu()); // 教育程度
			designer.setDataSource("ILINDT", getIlIndt()); // 抵台日期
			designer.setDataSource("ILOPNM", getIlOpnm()); // 職業
			designer.setDataSource("ILEXDT", getIlExdt()); // 離台日期
			switch (iltb01Main.getIlArcrsn()) {
			case "0":
				iltb01Main.setIlArcrsn("");
				break;
			case "1":
				iltb01Main.setIlArcrsn("依親");
				break;
			case "2":
				iltb01Main.setIlArcrsn("就學");
				break;
			case "3":
				iltb01Main.setIlArcrsn("應聘");
				break;
			case "4":
				iltb01Main.setIlArcrsn("投資");
				break;
			case "5":
				iltb01Main.setIlArcrsn("傳教");
				break;
			case "6":
				iltb01Main.setIlArcrsn("其他");
				break;
			case "7":
				iltb01Main.setIlArcrsn("外勞");
				break;
			case "8":
				iltb01Main.setIlArcrsn("永居(連續居留七年)");
				break;
			case "9":
				iltb01Main.setIlArcrsn("永居(依親五年配偶)");
				break;
			case "A":
				iltb01Main.setIlArcrsn("永居(依親五年子女)");
				break;
			case "B":
				iltb01Main.setIlArcrsn("永居(依親居住十五年)");
				break;
			case "C":
				iltb01Main.setIlArcrsn("永居(依親居住十年)");
				break;
			case "D":
				iltb01Main.setIlArcrsn("永居(居住二十年者)");
				break;
			case "E":
				iltb01Main.setIlArcrsn("永居(高科技人士)");
				break;
			case "F":
				iltb01Main.setIlArcrsn("永居(特殊貢獻者)");
				break;
			case "G":
				iltb01Main.setIlArcrsn("永居(其他)");
				break;
			}
			designer.setDataSource("ILARCRSN", iltb01Main.getIlArcrsn()); // 居留事由
			switch (iltb01Main.getIlArcst()) {
			case "1":
				iltb01Main.setIlArcst("改變國籍(原具我國籍者)");
				break;
			case "2":
				iltb01Main.setIlArcst("在台");
				break;
			case "3":
				iltb01Main.setIlArcst("離台");
				break;
			case "4":
				iltb01Main.setIlArcst("死亡");
				break;
			case "5":
				iltb01Main.setIlArcst("註銷居留證");
				break;
			case "6":
				iltb01Main.setIlArcst("棄原國籍取我國籍");
				break;
			}
			designer.setDataSource("ILARCST", iltb01Main.getIlArcst()); // 居留狀況
			designer.setDataSource("ILMICRO", iltb01Main.getIlMicro()); // 縮影編號
			designer.setDataSource("ILOFNM", iltb01Main.getIlOfnm()); // 服務處所
			designer.setDataSource("ILOFTEL", iltb01Main.getIlOftel()); // 服務處所電話
			designer.setDataSource("ILJBPZONE", iltb01Main.getIlJbpzone() + " " + iltb01Main.getIlJbaddr()); // 工作地址
			designer.setDataSource("ILJBTEL", iltb01Main.getIlJbtel()); // 工作地電話
			designer.setDataSource("ILARPZONE", iltb01Main.getIlArpzone() + " " + iltb01Main.getIlAraddr()); // 居留地址
			designer.setDataSource("ILARTEL", iltb01Main.getIlArtel()); // 居留地電話
			designer.setDataSource("ILAGNCO", iltb01Main.getIlAgnco()); // 仲介
			designer.setDataSource("ILAGNTEL", iltb01Main.getIlAgntel()); // 仲介電話
			designer.setDataSource("ILREMRK", getIlRemrk()); // 備註
			designer.setDataSource("ILJBPSN", iltb01Main.getIlJbpsn()); // 職位
			switch (iltb01Main.getIlJbpmcd()) {
			case "0":
				iltb01Main.setIlJbpmcd("");
				break;
			case "1":
				iltb01Main.setIlJbpmcd("勞動部");
				break;
			case "2":
				iltb01Main.setIlJbpmcd("內政部");
				break;
			case "3":
				iltb01Main.setIlJbpmcd("經濟部");
				break;
			case "4":
				iltb01Main.setIlJbpmcd("經濟部投審會");
				break;
			case "5":
				iltb01Main.setIlJbpmcd("科學園區管理局");
				break;
			case "6":
				iltb01Main.setIlJbpmcd("教育部");
				break;
			case "7":
				iltb01Main.setIlJbpmcd("交通部");
				break;
			case "8":
				iltb01Main.setIlJbpmcd("國防部");
				break;
			case "9":
				iltb01Main.setIlJbpmcd("新聞局");
				break;
			case "-":
				iltb01Main.setIlJbpmcd("衛生署");
				break;
			case "A":
				iltb01Main.setIlJbpmcd("台北市政府");
				break;
			case "B":
				iltb01Main.setIlJbpmcd("台中市政府");
				break;
			case "C":
				iltb01Main.setIlJbpmcd("基隆市政府");
				break;
			case "D":
				iltb01Main.setIlJbpmcd("台南市政府");
				break;
			case "E":
				iltb01Main.setIlJbpmcd("高雄市政府");
				break;
			case "F":
				iltb01Main.setIlJbpmcd("台北縣政府");
				break;
			case "G":
				iltb01Main.setIlJbpmcd("宜蘭縣政府");
				break;
			case "H":
				iltb01Main.setIlJbpmcd("桃園縣政府");
				break;
			case "I":
				iltb01Main.setIlJbpmcd("嘉義市政府");
				break;
			case "J":
				iltb01Main.setIlJbpmcd("新竹縣政府");
				break;
			case "K":
				iltb01Main.setIlJbpmcd("苗栗縣政府");
				break;
			case "L":
				iltb01Main.setIlJbpmcd("台中縣政府");
				break;
			case "M":
				iltb01Main.setIlJbpmcd("南投縣政府");
				break;
			case "N":
				iltb01Main.setIlJbpmcd("彰化縣政府");
				break;
			case "O":
				iltb01Main.setIlJbpmcd("新竹市政府");
				break;
			case "P":
				iltb01Main.setIlJbpmcd("雲林縣政府");
				break;
			case "Q":
				iltb01Main.setIlJbpmcd("嘉義縣政府");
				break;
			case "R":
				iltb01Main.setIlJbpmcd("台南縣政府");
				break;
			case "S":
				iltb01Main.setIlJbpmcd("高雄縣政府");
				break;
			case "T":
				iltb01Main.setIlJbpmcd("屏東縣政府");
				break;
			case "U":
				iltb01Main.setIlJbpmcd("花蓮縣政府");
				break;
			case "V":
				iltb01Main.setIlJbpmcd("台東縣政府");
				break;
			case "W":
				iltb01Main.setIlJbpmcd("金門縣政府");
				break;
			case "X":
				iltb01Main.setIlJbpmcd("澎湖縣政府");
				break;
			case "Y":
				iltb01Main.setIlJbpmcd("連江縣政府");
				break;
			case "Z":
				iltb01Main.setIlJbpmcd("其他");
				break;
			}
			designer.setDataSource("ILJBPMCD", iltb01Main.getIlJbpmcd()); // 機關
			designer.setDataSource("ILJBPMDT", getIlJbpmdt()); // 許可日期
			designer.setDataSource("ILJBPMDC", iltb01Main.getIlJbpmdc()); // 文號
			designer.setDataSource("ILJBPMFMTO", getIlJbpmfm() + " ~ " + getIlJbpmto()); // 許可效期
			designer.setDataSource("ILAPYDT", getIlApydt()); // 申請日期
			designer.setDataSource("ILARCRCP", iltb01Main.getIlArcrcp()); // 收據號碼
			designer.setDataSource("ILARCNO", iltb01Main.getIlArcno()); // 居留證號
			designer.setDataSource("ILARCFMTO", getIlArcfm() + " ~ " + getIlArcto()); // 居留效期
			designer.setDataSource("ILE0UNITSNM", getE0UnitSNm()); // 管轄分局
			designer.setDataSource("ILPSTEXT", iltb01Main.getIlPstext()); // 外責區
			switch (iltb01Main.getIlFrshp()) {
			case "00":
				iltb01Main.setIlFrshp("");
				break;
			case "01":
				iltb01Main.setIlFrshp("夫");
				break;
			case "02":
				iltb01Main.setIlFrshp("妻");
				break;
			case "03":
				iltb01Main.setIlFrshp("父");
				break;
			case "04":
				iltb01Main.setIlFrshp("母");
				break;
			case "05":
				iltb01Main.setIlFrshp("子");
				break;
			case "06":
				iltb01Main.setIlFrshp("女");
				break;
			case "07":
				iltb01Main.setIlFrshp("祖父");
				break;
			case "08":
				iltb01Main.setIlFrshp("祖母");
				break;
			case "09":
				iltb01Main.setIlFrshp("兄");
				break;
			case "10":
				iltb01Main.setIlFrshp("弟");
				break;
			case "11":
				iltb01Main.setIlFrshp("姊");
				break;
			case "12":
				iltb01Main.setIlFrshp("妹");
				break;
			case "13":
				iltb01Main.setIlFrshp("其他");
				break;
			}
			designer.setDataSource("ILFRSHP", iltb01Main.getIlFrshp()); // 稱謂
			designer.setDataSource("ILFNM", iltb01Main.getIlFnm()); // 姓名
			designer.setDataSource("IlNTNMFNT", getIlNTNMFnt()); // 國籍
			designer.setDataSource("ILFPID", iltb01Main.getIlFpid()); // 身分(居留)證號
			designer.setDataSource("ILREAPYDT", getIlReapydt()); // 申請日期
			String ilRetp = "";
			if ("1".equals(iltb01Main.getIlRetp())) {
				ilRetp = "單次";
			} else if ("2".equals(iltb01Main.getIlRetp())) {
				ilRetp = "多次";
			}
			designer.setDataSource("ILRETP", ilRetp); // 類別
			designer.setDataSource("ILREPMDT", getIlRepmdt()); // 核准期限
			designer.setDataSource("ILRRNOTE", iltb01Main.getIlRrnote()); // 備考
			designer.setDataSource("ILREPMDC", iltb01Main.getIlRepmdc()); // 原許可證號(6位)
			designer.setDataSource("ILREPMDCNIC", iltb01Main.getIlRepmdcNic()); // 新許可證號(10位)
			switch (iltb01Main.getIlSrchst()) {
			case "00":
				iltb01Main.setIlSrchst("");
				break;
			case "31":
				iltb01Main.setIlSrchst("行方不明");
				break;
			case "32":
				iltb01Main.setIlSrchst("取消協尋通報");
				break;
			case "33":
				iltb01Main.setIlSrchst("查獲或收容");
				break;
			case "34":
				iltb01Main.setIlSrchst("取消收容通報");
				break;
			case "35":
				iltb01Main.setIlSrchst("收容費預墊");
				break;
			case "36":
				iltb01Main.setIlSrchst("取消預墊通報");
				break;
			}
			designer.setDataSource("ILSRCHST", iltb01Main.getIlSrchst()); // 處理情形
			designer.setDataSource("ILMISSDT", getIlMissdt()); // 行方不明日期
			designer.setDataSource("ILSBMTDT", getIlSbmtdt()); // 報案日期
			switch (iltb01Main.getIlSbmttp()) {
			case "0":
				iltb01Main.setIlSbmttp("");
				break;
			case "1":
				iltb01Main.setIlSbmttp("關係人報案");
				break;
			case "2":
				iltb01Main.setIlSbmttp("警局主動註記");
				break;
			case "3":
				iltb01Main.setIlSbmttp("雇主書面通知");
				break;
			}
			designer.setDataSource("ILSBMTTP", iltb01Main.getIlSbmttp()); // 報案方式
			designer.setDataSource("ILFNDDNM", getIlFnddNm()); // 尋獲單位
			designer.setDataSource("ILFNDDT", getIlFnddt()); // 尋獲日期

			switch (iltb01Main.getIlFbdrsn()) {
			case "0":
				iltb01Main.setIlFbdrsn("");
				break;
			case "1":
				iltb01Main.setIlFbdrsn("申請資料係偽(變)造者");
				break;
			case "2":
				iltb01Main.setIlFbdrsn("經判處一年以上刑期者");
				break;
			case "3":
				iltb01Main.setIlFbdrsn("每年居住未達183天者");
				break;
			case "4":
				iltb01Main.setIlFbdrsn("回復或取得我國國籍者");
				break;
			case "5":
				iltb01Main.setIlFbdrsn("已取得外僑永久居留證者");
				break;
			case "6":
				iltb01Main.setIlFbdrsn("經撤銷聘僱許可並限令出國者");
				break;
			case "7":
				iltb01Main.setIlFbdrsn("其他");
				break;
			case "8":
				iltb01Main.setIlFbdrsn("休學");
				break;
			case "9":
				iltb01Main.setIlFbdrsn("退學");
				break;
			case "A":
				iltb01Main.setIlFbdrsn("畢業");
				break;
			case "B":
				iltb01Main.setIlFbdrsn("申請資料虛偽或不實");
				break;
			case "C":
				iltb01Main.setIlFbdrsn("持用不法取得、偽造或變造之證件");
				break;
			case "D":
				iltb01Main.setIlFbdrsn("回復我國籍");
				break;
			case "E":
				iltb01Main.setIlFbdrsn("取得我國籍");
				break;
			case "F":
				iltb01Main.setIlFbdrsn("兼具我國籍，以國民身分入出國、居留或定居");
				break;
			case "G":
				iltb01Main.setIlFbdrsn("受驅逐出國");
				break;
			case "H":
				iltb01Main.setIlFbdrsn("經許可定居");
				break;
			case "I":
				iltb01Main.setIlFbdrsn("離婚");
				break;
			case "J":
				iltb01Main.setIlFbdrsn("離婚配偶喪失子女扶養權");
				break;
			case "K":
				iltb01Main.setIlFbdrsn("依親對象居留事由消失者");
				break;
			case "L":
				iltb01Main.setIlFbdrsn("當事人主動撤銷");
				break;
			case "M":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-中途解約");
				break;
			case "N":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-連續三日曠職");
				break;
			case "O":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-非法工作");
				break;
			case "P":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-健檢不合格");
				break;
			case "Q":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-轉換雇主不成功");
				break;
			case "R":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-投資");
				break;
			case "S":
				iltb01Main.setIlFbdrsn("經撤銷、廢止居留許可(居留原因消失)-傳教");
				break;
			case "T":
				iltb01Main.setIlFbdrsn("死亡");
				break;
			}

			designer.setDataSource("ILFBDRSN", iltb01Main.getIlFbdrsn()); // 原因
			designer.setDataSource("ILMRKDT", getIlMrkdt()); // 日期
			designer.setDataSource("ILMRKDC", iltb01Main.getIlMrkdc()); // 文號
			designer.process(true);
			PdfSaveOptions options = new PdfSaveOptions(SaveFormat.PDF);
			options.setOnePagePerSheet(true);

			response.setContentType("application/pdf");
			wb.save(response.getOutputStream(), options);
			response.flushBuffer();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error!");
		}
	}

	public String toQuery() throws Exception {
		return "success";
	}
	public void arcnoHistoryAjax(){
		Map<String, String> arcnoHistoryMap = new LinkedHashMap<String, String>();
		JSONObject arcnoHistoryObj = new JSONObject();
		Set<String> filter = new HashSet<String>();
		int size;
		
		logger.info(ilIlId + "/" + ilArcid);

		if(ilIlId != null & !ilIlId.equals("")) {
			List<Iltb01Main> iltb01MainList = this.myIltb01MainDAO.getIlidListByIlIlId(ilIlId);
			for(Iltb01Main iltb01Main:iltb01MainList) {
				logger.info(iltb01Main.getIl12ArcId());
				if(iltb01Main.getIlArcno() != null &&
						!iltb01Main.getIlArcno().equals("") &&
						iltb01Main.getIlApydt() != null &&
						!iltb01Main.getIlApydt().toString().equals("")) {
					size = filter.size();
					filter.add(iltb01Main.getIlArcno() + iltb01Main.getIlApydt().toString());
					if(filter.size()!=size) {
						arcnoHistoryMap.put(iltb01Main.getIlApydt().toString(), iltb01Main.getIlArcno());
					}
				}
				if(iltb01Main.getIlOldarcno() != null &&
						!iltb01Main.getIlOldarcno().equals("") &&
						iltb01Main.getIlOldApydt() != null &&
						!iltb01Main.getIlOldApydt().toString().equals("")) {
					size = filter.size();
					filter.add(iltb01Main.getIlOldarcno() + iltb01Main.getIlOldApydt().toString());
					if(filter.size()!=size) {
						arcnoHistoryMap.put(iltb01Main.getIlOldApydt().toString(), iltb01Main.getIlOldarcno());
					}
				}
			}
		} else {
			Iltb01Main iltb01Main = this.myIltb01MainDAO.findById(this.ilArcid);
			if(iltb01Main.getIlArcno() != null &&
					!iltb01Main.getIlArcno().equals("") &&
					iltb01Main.getIlApydt() != null &&
					!iltb01Main.getIlApydt().toString().equals("")) {
				size = filter.size();
				filter.add(iltb01Main.getIlArcno() + iltb01Main.getIlApydt().toString());
				if(filter.size()!=size) {
					arcnoHistoryMap.put(iltb01Main.getIlApydt().toString(), iltb01Main.getIlArcno());
				}
			}
			if(iltb01Main.getIlOldarcno() != null &&
					!iltb01Main.getIlOldarcno().equals("") &&
					iltb01Main.getIlOldApydt() != null &&
					!iltb01Main.getIlOldApydt().toString().equals("")) {
				size = filter.size();
				filter.add(iltb01Main.getIlOldarcno() + iltb01Main.getIlOldApydt().toString());
				if(filter.size()!=size) {
					arcnoHistoryMap.put(iltb01Main.getIlOldApydt().toString(), iltb01Main.getIlOldarcno());
				}
			}
		}
		arcnoHistoryObj.put("arcnoHistory", arcnoHistoryMap);
		sendMsg(arcnoHistoryObj.toString());
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
}
