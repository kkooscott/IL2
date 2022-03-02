package tw.gov.npa.il.action;

import com.aspose.cells.Color;
import com.aspose.cells.CountryCode;
import com.aspose.cells.LoadOptions;
import com.aspose.cells.MsoFillFormat;
import com.aspose.cells.MsoLineFormat;
import com.aspose.cells.MsoPresetTextEffect;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.SaveFormat;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.cells.Worksheet;
import com.aspose.pdf.FontRepository;
import com.aspose.pdf.FontStyles;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.PageNumberStamp;
import com.aspose.pdf.VerticalAlignment;
import com.aspose.words.PaperSize;
import com.opensymphony.xwork2.ActionSupport;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import npalog.NPALog4J;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import tw.gov.npa.il.action.bean.IL03A01Q02Bean;
import tw.gov.npa.il.action.bean.IL03A01Query02Bean;
import tw.gov.npa.il.action.bean.OprType;
import tw.gov.npa.il.dao.Iltb20OnlineReport;
import tw.gov.npa.il.entity.IL07D;
import tw.gov.npa.il.myDao.IL07DDao;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO2;
import tw.gov.npa.il.util.CVUtil;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL03A01Q02 extends ActionSupport {
	private static final Logger logger = Logger.getLogger(IL03A01Q02.class);

	private IL07DDao il07DDao;

	List<IL07D> srchstCodes = new ArrayList<IL07D>();

	ResourceBundle rb = ResourceBundle.getBundle("config");

	private String contextPath = this.rb.getString("templatePath").toString();

	private String flag;

	private String pageType;

	MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();

	MyIltb01MainDAO2 myIltb01MainDAO2 = new MyIltb01MainDAO2();

	private List<IL03A01Q02Bean> queryList;

	private List<String> dataList;

	private String ilArcno;

	private String ilPspt;

	private String ilEnm;

	private String ilCnm;

	private String ilOfnm;

	private String ilPhq;

	private String ilJbpmdt;

	private String ilJbpmdc;

	private String QueryFrom;

	private Constant constant = new Constant();

	private String logcn;

	private String logpstname;

	private String main;

	private String detail;

	private String other;

	private GetDateUtil getDateUtil = new GetDateUtil();

	private NTPCUtil ntpcUtil = new NTPCUtil();

//	private String PHQPST;

	private String PSTEXT;
	
	private String txtBTHD;

	private String txtBTHD_FROM;

	private String txtBTHD_TO;

	private String SEX;

	private String ARCST;

	private String ARCST_LIST;

	private String OP;

	private String OP_LIST;

	private String NT;

	private String NT_LIST;

	private String UV;

	private String txtARC_FROM;

	private String txtARC_TO;

	private String EDU;

	private String EDU_LIST;

	private String MST;

	private String FRCEXIT;

	private String txtAPY_FROM;

	private String txtAPY_TO;

	private String FBDRSN;

	private String txtREAPY_FROM;

	private String txtREAPY_TO;

	private String SRCHST;

	private String txtMISS_FROM;

	private String txtMISS_TO;

	private String txtSBMT_FROM;

	private String txtSBMT_TO;

	private String FNDDID;

	private String txtFIND_FROM;

	private String txtFIND_TO;

	private String txtIN_FROM;

	private String txtIN_TO;

	private String txtEXIT_FROM;

	private String txtEXIT_TO;

	private String MANTYPE;

	private String ilMicro;

	private String ilRepmdc;

	private String ilRepmdcNic;

	private List<Iltb20OnlineReport> iltb20IdList;

	private Date nowDate;

	private String chkARCNO;

	private String chkPSPT;

	private String chkENM;

	private String chkNTCD;

	private String chkBTHDT;

	private String chkCNM;

	private String chkARCFM;

	private String chkARCTO;

	private String chkSEX;

	private String chkJBCD;

	private String chkARCST;

	private String chkARCRSN;

	private String chkEDU;

	private String chkOFCD;

	private String chkOFNM;

	private String chkOFTEL;

	private String chkJBADDR;

	private String chkJBTEL;

	private String chkARPZONE;

	private String chkARADDR;

	private String chkARTEL;

	private String chkPHQ;

	private String chkPSTEXT;

	private String chkFRSHP;

	private String chkFNTCD;

	private String chkMISSDT;

	private String chkSBMTDT;

	private String chkFNDDT;

	private String chkSRCHST;

	private String chkINDT;

	private String chkEXDT;

	private String chkFPID;

	private String chkFNM;

	private String chkAPYDT;

	private String chkARCRCP;

	private String chkMICRO;

	private String chkOLDARCNO;

	private String chkMANTYPE;

	private String chkilNTNM;
	
	private String queryStr;

//	private String UV;

	public String getQueryStr() {
		return queryStr;
	}

	public void setQueryStr(String queryStr) {
		this.queryStr = queryStr;
	}

	public String toMain() throws Exception {
		try {
			doRealQuery();
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
			return "error";
		}
		return "success";
	}

	@SuppressWarnings("unchecked")
	private void doRealQuery() {
		logger.info("doRealQuery");
		HttpSession session = ServletActionContext.getRequest().getSession();
		this.flag = (session.getAttribute("flag") == "") ? "" : session.getAttribute("flag").toString();
		if (session.getAttribute("ilCnm") != null && !session.getAttribute("ilCnm").toString().equals(""))
			this.ilCnm = session.getAttribute("ilCnm").toString();
		if (session.getAttribute("ilOfnm") != null && !session.getAttribute("ilOfnm").toString().equals(""))
			this.ilOfnm = session.getAttribute("ilOfnm").toString();
		session.setAttribute("ilArcno", this.ilArcno.toUpperCase()); // 外來人口統一證號
		session.setAttribute("ilPspt", this.ilPspt.toUpperCase()); // 護照號碼
		session.setAttribute("ilEnm", this.ilEnm.toUpperCase()); // 英文姓名
		session.setAttribute("ilCnm", this.ilCnm.toUpperCase()); // 中文姓名
		session.setAttribute("ilOfnm", this.ilOfnm.toUpperCase()); // 服務處所
		session.setAttribute("ilPhq", this.ilPhq.toUpperCase()); // 警分局代碼
		session.setAttribute("ilJbpmdt", this.ilJbpmdt.toUpperCase()); // 工作許可日期
		session.setAttribute("ilJbpmdc", this.ilJbpmdc.toUpperCase()); // 文號
		IL03A01Query02Bean bean = new IL03A01Query02Bean();

		GetDateUtil getDateUtil = new GetDateUtil();
		String ilJbpmdtStr = getDateUtil.getNoSpiltDate(this.ilJbpmdt);
		bean = setValToBean(this.ilArcno.trim().toUpperCase(), this.ilPspt.trim().toUpperCase(),
				this.ilEnm.trim().toUpperCase(), this.ilCnm.trim().toUpperCase(), this.ilOfnm.trim().toUpperCase(),
				this.ilPhq.trim(), ilJbpmdtStr.trim().toUpperCase(), this.ilJbpmdc.trim().toUpperCase(),
				this.txtBTHD.trim(),this.txtBTHD_FROM.trim(), this.txtBTHD_TO.trim(), this.ilRepmdc.trim(), this.ilRepmdcNic.trim(),
				this.ilMicro.trim(), this.SRCHST.trim(), this.PSTEXT.trim(), this.SEX.trim(), this.UV.trim(),
				this.OP_LIST.trim(), this.NT_LIST.trim(), this.ARCST_LIST.trim(), this.EDU_LIST.trim(), this.MST.trim(),
				this.FBDRSN.trim(), this.txtAPY_FROM.trim(), this.txtAPY_TO.trim(), this.FRCEXIT.trim(),
				this.txtARC_FROM.trim(), this.txtARC_TO.trim(), this.txtREAPY_FROM.trim(), this.txtREAPY_TO.trim(),
				this.txtMISS_FROM.trim(), this.txtMISS_TO.trim(), txtSBMT_FROM.trim(), this.txtSBMT_TO.trim(),
				this.FNDDID.trim(), this.txtFIND_FROM.trim(), this.txtFIND_TO.trim(), this.txtIN_FROM.trim(),
				this.txtIN_TO.trim(), this.MANTYPE.trim(), this.txtEXIT_FROM.trim(), this.txtEXIT_TO.trim(),
				this.chkARCNO, this.chkPSPT, this.chkENM, this.chkNTCD, this.chkBTHDT, this.chkCNM, this.chkARCFM,
				this.chkARCTO, this.chkSEX, this.chkJBCD, this.chkARCST, this.chkARCRSN, this.chkEDU, this.chkOFCD,
				this.chkOFNM, this.chkOFTEL, this.chkJBADDR, this.chkJBTEL, this.chkARPZONE, this.chkARADDR,
				this.chkARTEL, this.chkPHQ, this.chkPSTEXT, this.chkFRSHP, this.chkFNTCD, this.chkMISSDT,
				this.chkSBMTDT, this.chkFNDDT, this.chkSRCHST, this.chkINDT, this.chkEXDT, this.chkFPID, this.chkFNM,
				this.chkAPYDT, this.chkARCRCP, this.chkMICRO, this.chkOLDARCNO, this.chkilNTNM, this.chkMANTYPE);
		if (bean.getIlPhq().equals("AE000")) {
			bean.setIlPhq("BE000");
		}
		String[] ilPhqArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(bean.getIlPhq());
		this.srchstCodes = il07DDao.findAll();

		this.queryList = this.myIltb01MainDAO2.getIL03A01Q02ToSQL(bean, ilPhqArr, srchstCodes);
		System.out.println("註記:" + "R".equals(this.flag));
		if (null != queryList) {
			session.setAttribute("queryBean", bean);
		}
		if ("R".equals(this.flag)) {
			System.out.println("實際查詢人:" + this.logcn);
			System.out.println("實際查詢人單位:" + this.logpstname);
			String LOGCN = (session.getAttribute("LOGCN") == null) ? "" : session.getAttribute("LOGCN").toString();
			String LOGDID = (session.getAttribute("LOGDID") == null) ? "" : session.getAttribute("LOGDID").toString();
			String LOGTUP = (session.getAttribute("LOGTUP") == null) ? "" : session.getAttribute("LOGTUP").toString();
			String LOGUIP = (session.getAttribute("LOGUIP") == null) ? "" : session.getAttribute("LOGUIP").toString();
			String LOGUID = (session.getAttribute("LOGUID") == null) ? "" : session.getAttribute("LOGUID").toString();
			String LOGTDT = (session.getAttribute("LOGTDT") == null) ? "" : session.getAttribute("LOGTDT").toString();
			String name = this.ilCnm;
			String idno = "";
			ResourceBundle rb = ResourceBundle.getBundle("config");
			String changeMode = rb.getString("changeMode").toString();
			if (this.main.equals("600")) {
				this.detail = this.other;
			}
			transQueryStr(bean);
			/*
			if ("1".equals(changeMode))
				doQueryLog("IL03A01Q02", LOGCN, LOGDID, LOGUID, LOGUIP, LOGTUP, LOGTDT, this.logcn, this.logpstname,
						usage, name, idno, this.queryList);*/
		}
		session.setAttribute("flag", "N");
	}
/*
	public void doQueryLog(String url, String LOGCN, String LOGDID, String LOGUID, String LOGUIP, String LOGTUP,
			String LOGTDT, String queryName, String queryUnit, String queryGoal, String name, String idno,
			List<IL03A01Q02Bean> queryList) {
		logger.info("do Query Log");
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String systemDateTime = df.format(new Date());
		NPALog4J npaLog4J = NPALog4J.getNPAlogger();
		StringBuffer queryMethodBuffer = new StringBuffer();
		queryMethodBuffer.append("居留證號=" + this.ilArcno + "&");
		queryMethodBuffer.append("護照號碼=" + this.ilPspt + "&");
		queryMethodBuffer.append("英文姓名=" + this.ilEnm + "&");
		queryMethodBuffer.append("中文姓名=" + this.ilCnm + "&");
		queryMethodBuffer.append("服務處所=" + this.ilOfnm + "&");
		queryMethodBuffer.append("警分局代碼=" + this.ilPhq + "&");
		queryMethodBuffer.append("工作許可日期=" + this.ilJbpmdt + "&");
		queryMethodBuffer.append("文號=" + this.ilJbpmdc);
		String queryMethodStr = queryMethodBuffer.toString();
		logger.info("查詢條件內容" + queryMethodStr);
		if (queryList == null || queryList.size() == 0) {
			String listIdno = "";
			String listName = "";
			String listBirth = "";
			int j = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID, LOGUIP,
					LOGTDT, Constant.getServername(), systemDateTime, "IL03A01Q02", OprType.Query.toString(),
					this.constant.getApName(), "F", "", queryName, queryUnit, queryGoal, queryMethodStr, idno, name, "",
					"", "", "");
			logger.info("查無日誌結果" + j);
			return;
		}
		String[] strs = new String[queryList.size() + 1];
		strs[0] = "國籍&護照號碼&英文姓名&出生日期";
		int i = 1;
		for (IL03A01Q02Bean bean : queryList) {
			StringBuffer strBuffer = new StringBuffer();
			strBuffer.append(CVUtil.trim(bean.getIlNTNM()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlPspt()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlEnm()) + "&");
			strBuffer.append(CVUtil.trim(bean.getIlBthdt()) + "&");
			strs[i] = strBuffer.toString();
			i++;
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
		int result = npaLog4J.logging2(this.constant.getLogMethod().intValue(), 1, LOGUID + "-" + LOGCN, LOGDID, LOGUIP,
				LOGTDT, Constant.getServername(), systemDateTime, "IL03A01Q02", OprType.Query.toString(),
				this.constant.getApName(), "S", "", queryName, queryUnit, queryGoal, queryMethodStr, idno, name, "", "",
				"", str);
		logger.info("查有日誌結果" + result);
	}
*/
	public void downloadExcel() {

		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			IL03A01Query02Bean bean = (IL03A01Query02Bean) (session.getAttribute("queryBean"));
			this.srchstCodes = il07DDao.findAll();
			if (bean.getIlPhq().equals("AE000")) {
				bean.setIlPhq("BE000");
			}
			String[] ilPhqArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(bean.getIlPhq());

			this.queryList = this.myIltb01MainDAO2.getIL03A01Q02ToSQL(bean, ilPhqArr, srchstCodes);

			WritableWorkbook workbook;
			WritableSheet sheet;

			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setVerticalAlignment(jxl.write.VerticalAlignment.CENTRE);
			WritableCellFormat format1 = new WritableCellFormat();
			format1.setVerticalAlignment(jxl.write.VerticalAlignment.CENTRE);
			format1.setWrap(true);

			String filename = String.valueOf(System.currentTimeMillis());
			workbook = Workbook.createWorkbook(new File(contextPath + filename + ".xls"));
			sheet = workbook.createSheet("Sheet1", 0); // 第2個參數是 0-base sheet index

			sheet.mergeCells(0, 0, 4, 0);
			sheet.mergeCells(0, 1, 4, 1);

			sheet.setColumnView(0, 15);
			sheet.setColumnView(1, 20);
			sheet.setColumnView(2, 25);
			sheet.setColumnView(3, 20);
			sheet.setColumnView(4, 20);
			sheet.setColumnView(5, 15);
			sheet.setColumnView(6, 25);
			sheet.setColumnView(7, 30);
			sheet.setColumnView(8, 20);

			sheet.mergeCells(0, 2, 1, 2);
			sheet.mergeCells(2, 2, 3, 2);
			sheet.mergeCells(0, 3, 1, 3);
			sheet.mergeCells(2, 3, 3, 3);
			sheet.mergeCells(0, 4, 1, 4);
			sheet.mergeCells(2, 4, 3, 4);

			Label title = new Label(0, 0, "外僑居留資料查詢-清單列印");
			WritableCellFormat titleFormat = new WritableCellFormat();
			titleFormat.setAlignment(Alignment.CENTRE);
			titleFormat.setFont(new WritableFont(WritableFont.TAHOMA, 16));
			title.setCellFormat(titleFormat);
			sheet.addCell(title);

			Label header = new Label(0, 2, "列印單位：" + session.getAttribute("LOGUNITNM"));
			sheet.addCell(header);
			header = new Label(2, 2, "列印人：" + session.getAttribute("LOGCN"));
			sheet.addCell(header);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			header = new Label(0, 3, "列印日期：" + sdf.format(new Date()));
			sheet.addCell(header);

			int j = 0;
			header = new Label(j, 6, "筆次");
			sheet.addCell(header);
			if ("1".equals(bean.getChkARCNO())) {
				header = new Label(j + 1, 6, "外來人口統一證號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkPSPT())) {
				header = new Label(j + 1, 6, "護照號碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkENM())) {
				header = new Label(j + 1, 6, "英文姓名：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkNTCD())) {
				header = new Label(j + 1, 6, "國籍代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkBTHDT())) {
				header = new Label(j + 1, 6, "出生日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkCNM())) {
				header = new Label(j + 1, 6, "中文姓名：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCFM())) {
				header = new Label(j + 1, 6, "居留期限(起)：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCTO())) {
				header = new Label(j + 1, 6, "居留期限(迄)：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkSEX())) {
				header = new Label(j + 1, 6, "性別：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkJBCD())) {
				header = new Label(j + 1, 6, "職業：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCST())) {
				header = new Label(j + 1, 6, "居留狀況：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCRSN())) {
				header = new Label(j + 1, 6, "居留事由(居留目的)：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkEDU())) {
				header = new Label(j + 1, 6, "教育程度：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOFCD())) {
				header = new Label(j + 1, 6, "服務處所(大專院校)代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOFNM())) {
				header = new Label(j + 1, 6, "服務處所名稱：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOFTEL())) {
				header = new Label(j + 1, 6, "服務處所電話：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkJBADDR())) {
				header = new Label(j + 1, 6, "工作地址：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkJBTEL())) {
				header = new Label(j + 1, 6, "工作電話：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARPZONE())) {
				header = new Label(j + 1, 6, "居留地址郵遞區號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARADDR())) {
				header = new Label(j + 1, 6, "居留地址：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARTEL())) {
				header = new Label(j + 1, 6, "居留電話：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkPHQ())) {
				header = new Label(j + 1, 6, "分局代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkPSTEXT())) {
				header = new Label(j + 1, 6, "外責區代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFRSHP())) {
				header = new Label(j + 1, 6, "在華親屬稱謂代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFNTCD())) {
				header = new Label(j + 1, 6, "在華親屬國籍代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkMISSDT())) {
				header = new Label(j + 1, 6, "逃逸日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkSBMTDT())) {
				header = new Label(j + 1, 6, "報案日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFNDDT())) {
				header = new Label(j + 1, 6, "查獲日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkSRCHST())) {
				header = new Label(j + 1, 6, "協尋處理情形：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkINDT())) {
				header = new Label(j + 1, 6, "抵台日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkEXDT())) {
				header = new Label(j + 1, 6, "離台日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFPID())) {
				header = new Label(j + 1, 6, "親屬身分(居留)證號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFNM())) {
				header = new Label(j + 1, 6, "親屬姓名：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkAPYDT())) {
				header = new Label(j + 1, 6, "申請日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCRCP())) {
				header = new Label(j + 1, 6, "收據號碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkMICRO())) {
				header = new Label(j + 1, 6, "縮影編號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOLDARCNO())) {
				header = new Label(j + 1, 6, "舊式居留證號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkilNTNM())) {
				header = new Label(j + 1, 6, "國籍：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkMANTYPE())) {
				header = new Label(j + 1, 6, "人口分類：");
				sheet.addCell(header);
				j++;
			}
			int l = 7;
			int m = 1;
			for (int k = 0; k < queryList.size(); k++) {
				int i = 0;
				header = new Label(0, l, String.valueOf(m));
				sheet.addCell(header);
				m++;
				if ("1".equals(bean.getChkARCNO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcno());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkPSPT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlPspt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkENM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlEnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkNTCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlNtcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkBTHDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlBthdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkCNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlCnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCFM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcfm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCTO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcto());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkSEX())) {
					header = new Label(i + 1, l, queryList.get(k).getIlSex());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkJBCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlJbcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCST())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcst());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCRSN())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcrsn());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkEDU())) {
					header = new Label(i + 1, l, queryList.get(k).getIlEdu());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOFCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOfcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOFNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOfnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOFTEL())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOftel());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkJBADDR())) {
					header = new Label(i + 1, l, queryList.get(k).getIlJbaddr());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkJBTEL())) {
					header = new Label(i + 1, l, queryList.get(k).getIlJbtel());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARPZONE())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArpzone());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARADDR())) {
					header = new Label(i + 1, l, queryList.get(k).getIlAraddr());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARTEL())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArtel());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkPHQ())) {
					header = new Label(i + 1, l, queryList.get(k).getIlPhq());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkPSTEXT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlPstext());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFRSHP())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFrshp());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFNTCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFntcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkMISSDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlMissdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkSBMTDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlSbmtdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFNDDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFnddt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkSRCHST())) {
					header = new Label(i + 1, l, queryList.get(k).getIlSrchst());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkINDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlIndt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkEXDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlExdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFPID())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFpid());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkAPYDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlApydt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCRCP())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcrcp());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkMICRO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlMicro());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOLDARCNO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOldarc());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkilNTNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlNTNM());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkMANTYPE())) {
					header = new Label(i + 1, l, queryList.get(k).getIlMANTYPE());
					sheet.addCell(header);
					i++;
				}

				l++;
			}

			workbook.write();
			workbook.close();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Content-Disposition", "attachment; filename=\"list.xls\"");

			Label data;
			Properties prop = new Properties();

			ResourceBundle dbConfig = ResourceBundle.getBundle("db");

			String connstr = dbConfig.getString("connstr");
			String dbuser = dbConfig.getString("user");
			String dbpwd = dbConfig.getString("pwd");

			String time = (String) session.getAttribute("LOGTDT");
			String watermark = (String) session.getAttribute("LOGUNITNM") + "-" + (String) session.getAttribute("LOGCN") + "-" + time;
			com.aspose.cells.License license = new com.aspose.cells.License();
			license.setLicense("Aspose.Total.Java.lic");
			com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(contextPath + filename + ".xls");
			Worksheet st = wb.getWorksheets().get(0);
			int maxRow = st.getCells().getMaxDataRow();
			int maxCol = st.getCells().getMaxDataColumn();

			for (int i = 0; i < maxCol; i++) {
				for (int k = 0; k < maxRow; k++) {
					InsertWaterMarkToXLS(wb, st, watermark, k, k, i, i, 30, 600);
					k++;k++;k++;k++;
				}
				i++;
			}
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);
			response.setContentType("application/vnd.ms-excel");
			wb.save(response.getOutputStream(), wb.getFileFormat());
			response.flushBuffer();
			new File(contextPath + filename + ".xls").delete();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error!");
		}
	}

	public void downloadPdf() {

		try {
			HttpSession session = ServletActionContext.getRequest().getSession();
			IL03A01Query02Bean bean = (IL03A01Query02Bean) (session.getAttribute("queryBean"));

			if (bean.getIlPhq().equals("AE000")) {
				bean.setIlPhq("BE000");
			}
			String[] ilPhqArr = this.ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(bean.getIlPhq());
			this.srchstCodes = il07DDao.findAll();
			this.queryList = this.myIltb01MainDAO2.getIL03A01Q02ToSQL(bean, ilPhqArr, srchstCodes);

			WritableWorkbook workbook;
			WritableSheet sheet;
			

			WritableCellFormat cellFormat = new WritableCellFormat();
			cellFormat.setVerticalAlignment(jxl.write.VerticalAlignment.CENTRE);
			WritableCellFormat format1 = new WritableCellFormat();
			format1.setVerticalAlignment(jxl.write.VerticalAlignment.CENTRE);
			format1.setWrap(true);

			String filename = String.valueOf(System.currentTimeMillis());
			workbook = Workbook.createWorkbook(new File(contextPath + filename + ".xls"));
			sheet = workbook.createSheet("Sheet1", 0); // 第2個參數是 0-base sheet index
			sheet.getSettings().setPaperSize(jxl.format.PaperSize.A4);
			sheet.getSettings().setFitHeight(297);//Printing area height
            sheet.getSettings().setFitWidth(210) ;//Print area width

			sheet.mergeCells(0, 0, 4, 0);
			sheet.mergeCells(0, 1, 4, 1);

			sheet.setColumnView(0, 10);
			sheet.setColumnView(1, 20);
			sheet.setColumnView(2, 25);
			sheet.setColumnView(3, 15);
			sheet.setColumnView(4, 15);
			sheet.setColumnView(5, 10);
			sheet.setColumnView(6, 20);
			sheet.setColumnView(7, 25);
			sheet.setColumnView(8, 15);

			sheet.mergeCells(0, 2, 1, 2);
			sheet.mergeCells(2, 2, 3, 2);
			sheet.mergeCells(0, 3, 1, 3);
			sheet.mergeCells(2, 3, 3, 3);
			sheet.mergeCells(0, 4, 1, 4);
			sheet.mergeCells(2, 4, 3, 4);

			Label title = new Label(0, 0, "外僑居留資料查詢-清單列印");
			WritableCellFormat titleFormat = new WritableCellFormat();
			titleFormat.setAlignment(Alignment.CENTRE);
			titleFormat.setFont(new WritableFont(WritableFont.TAHOMA, 10));
			title.setCellFormat(titleFormat);
			sheet.addCell(title);

			Label header = new Label(0, 2, "列印單位：" + session.getAttribute("LOGUNITNM"));
			sheet.addCell(header);
			header = new Label(2, 2, "列印人：" + session.getAttribute("LOGCN"));
			sheet.addCell(header);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			header = new Label(0, 3, "列印日期：" + sdf.format(new Date()));
			sheet.addCell(header);

			int j = 0;
			header = new Label(j, 6, "筆次");
			sheet.addCell(header);
			if ("1".equals(bean.getChkARCNO())) {
				header = new Label(j + 1, 6, "外來人口統一證號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkPSPT())) {
				header = new Label(j + 1, 6, "護照號碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkENM())) {
				header = new Label(j + 1, 6, "英文姓名：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkNTCD())) {
				header = new Label(j + 1, 6, "國籍代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkBTHDT())) {
				header = new Label(j + 1, 6, "出生日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkCNM())) {
				header = new Label(j + 1, 6, "中文姓名：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCFM())) {
				header = new Label(j + 1, 6, "居留期限(起)：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCTO())) {
				header = new Label(j + 1, 6, "居留期限(迄)：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkSEX())) {
				header = new Label(j + 1, 6, "性別：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkJBCD())) {
				header = new Label(j + 1, 6, "職業：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCST())) {
				header = new Label(j + 1, 6, "居留狀況：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCRSN())) {
				header = new Label(j + 1, 6, "居留事由(居留目的)：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkEDU())) {
				header = new Label(j + 1, 6, "教育程度：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOFCD())) {
				header = new Label(j + 1, 6, "服務處所(大專院校)代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOFNM())) {
				header = new Label(j + 1, 6, "服務處所名稱：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOFTEL())) {
				header = new Label(j + 1, 6, "服務處所電話：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkJBADDR())) {
				header = new Label(j + 1, 6, "工作地址：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkJBTEL())) {
				header = new Label(j + 1, 6, "工作電話：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARPZONE())) {
				header = new Label(j + 1, 6, "居留地址郵遞區號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARADDR())) {
				header = new Label(j + 1, 6, "居留地址：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARTEL())) {
				header = new Label(j + 1, 6, "居留電話：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkPHQ())) {
				header = new Label(j + 1, 6, "分局代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkPSTEXT())) {
				header = new Label(j + 1, 6, "外責區代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFRSHP())) {
				header = new Label(j + 1, 6, "在華親屬稱謂代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFNTCD())) {
				header = new Label(j + 1, 6, "在華親屬國籍代碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkMISSDT())) {
				header = new Label(j + 1, 6, "逃逸日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkSBMTDT())) {
				header = new Label(j + 1, 6, "報案日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFNDDT())) {
				header = new Label(j + 1, 6, "查獲日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkSRCHST())) {
				header = new Label(j + 1, 6, "協尋處理情形：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkINDT())) {
				header = new Label(j + 1, 6, "抵台日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkEXDT())) {
				header = new Label(j + 1, 6, "離台日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFPID())) {
				header = new Label(j + 1, 6, "親屬身分(居留)證號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkFNM())) {
				header = new Label(j + 1, 6, "親屬姓名：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkAPYDT())) {
				header = new Label(j + 1, 6, "申請日期：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkARCRCP())) {
				header = new Label(j + 1, 6, "收據號碼：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkMICRO())) {
				header = new Label(j + 1, 6, "縮影編號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkOLDARCNO())) {
				header = new Label(j + 1, 6, "舊式居留證號：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkilNTNM())) {
				header = new Label(j + 1, 6, "國籍：");
				sheet.addCell(header);
				j++;
			}
			if ("1".equals(bean.getChkMANTYPE())) {
				header = new Label(j + 1, 6, "人口分類：");
				sheet.addCell(header);
				j++;
			}
			int l = 7;
			int m = 1;
			for (int k = 0; k < queryList.size(); k++) {
				int i = 0;
				header = new Label(0, l, String.valueOf(m));
				sheet.addCell(header);
				m++;
				if ("1".equals(bean.getChkARCNO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcno());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkPSPT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlPspt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkENM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlEnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkNTCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlNtcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkBTHDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlBthdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkCNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlCnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCFM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcfm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCTO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcto());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkSEX())) {
					header = new Label(i + 1, l, queryList.get(k).getIlSex());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkJBCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlJbcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCST())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcst());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCRSN())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcrsn());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkEDU())) {
					header = new Label(i + 1, l, queryList.get(k).getIlEdu());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOFCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOfcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOFNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOfnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOFTEL())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOftel());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkJBADDR())) {
					header = new Label(i + 1, l, queryList.get(k).getIlJbaddr());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkJBTEL())) {
					header = new Label(i + 1, l, queryList.get(k).getIlJbtel());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARPZONE())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArpzone());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARADDR())) {
					header = new Label(i + 1, l, queryList.get(k).getIlAraddr());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARTEL())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArtel());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkPHQ())) {
					header = new Label(i + 1, l, queryList.get(k).getIlPhq());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkPSTEXT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlPstext());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFRSHP())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFrshp());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFNTCD())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFntcd());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkMISSDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlMissdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkSBMTDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlSbmtdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFNDDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFnddt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkSRCHST())) {
					header = new Label(i + 1, l, queryList.get(k).getIlSrchst());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkINDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlIndt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkEXDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlExdt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFPID())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFpid());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkFNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlFnm());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkAPYDT())) {
					header = new Label(i + 1, l, queryList.get(k).getIlApydt());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkARCRCP())) {
					header = new Label(i + 1, l, queryList.get(k).getIlArcrcp());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkMICRO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlMicro());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkOLDARCNO())) {
					header = new Label(i + 1, l, queryList.get(k).getIlOldarc());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkilNTNM())) {
					header = new Label(i + 1, l, queryList.get(k).getIlNTNM());
					sheet.addCell(header);
					i++;
				}
				if ("1".equals(bean.getChkMANTYPE())) {
					header = new Label(i + 1, l, queryList.get(k).getIlMANTYPE());
					sheet.addCell(header);
					i++;
				}
				l++;
			}

			workbook.write();
			workbook.close();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("Content-Disposition", "attachment; filename=\"list.pdf\"");

			Label data;
			Properties prop = new Properties();
			ResourceBundle dbConfig = ResourceBundle.getBundle("db");

			String connstr = dbConfig.getString("connstr");
			String dbuser = dbConfig.getString("user");
			String dbpwd = dbConfig.getString("pwd");

			String time = (String) session.getAttribute("LOGTDT");
			String watermark = (String) session.getAttribute("LOGUNITNM") + "-" + (String) session.getAttribute("LOGCN") + "-" + time;
			com.aspose.cells.License license = new com.aspose.cells.License();
			license.setLicense("Aspose.Total.Java.lic");
			LoadOptions loadOptions = new LoadOptions();
			loadOptions.setRegion(CountryCode.USA);
			com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(contextPath + filename + ".xls");
			Worksheet st = wb.getWorksheets().get(0);
			st.getPageSetup().setPaperSize(PaperSize.A4);
			int maxRow = st.getCells().getMaxDataRow();
			int maxCol = st.getCells().getMaxDataColumn();

			for (int i = 0; i < maxCol; i++) {
				for (int k = 0; k < maxRow; k++) {
					InsertWaterMarkToXLS(wb, st, watermark, k, k, i, i, 30, 800);
					k++;k++;k++;k++;k++;k++;k++;k++;k++;k++;k++;
				}
				i++;i++;i++;
			}
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);
			PdfSaveOptions options = new PdfSaveOptions(SaveFormat.PDF);
			options.setOnePagePerSheet(true);
			PageNumberStamp pageNumberStamp = new PageNumberStamp();
			pageNumberStamp.setBackground(false);
			pageNumberStamp.setFormat(" # ");
			pageNumberStamp.setBottomMargin(10);
			pageNumberStamp.setRightMargin(10);
			pageNumberStamp.setHorizontalAlignment(HorizontalAlignment.Right);
			pageNumberStamp.setVerticalAlignment(VerticalAlignment.Top);
			pageNumberStamp.getTextState().setFont(FontRepository.findFont("Arial"));
			pageNumberStamp.getTextState().setFontSize(20.0F);
			pageNumberStamp.getTextState().setFontStyle(FontStyles.Bold);
			pageNumberStamp.getTextState().setFontStyle(FontStyles.Italic);
			pageNumberStamp.getTextState().setForegroundColor(com.aspose.pdf.Color.getBlack());
			wb.getWorksheets().get(0).getCells().deleteBlankRows();
			response.setContentType("application/pdf");
			wb.save(response.getOutputStream(), options);
			response.flushBuffer();
			new File(contextPath + filename + ".xls").delete();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error!");
		}
	}
	
	private void transQueryStr(IL03A01Query02Bean bean) {
		StringBuffer sb = new StringBuffer("");
		if(null != bean.getIlArcno() && !"".equals(bean.getIlArcno())) {
			sb.append("&外來人口統一證號=").append(bean.getIlArcno().replaceAll(",", ";"));
		}
		if(null != bean.getIlPspt() && !"".equals(bean.getIlPspt())) {
			sb.append("&護照號碼=").append(bean.getIlPspt().replaceAll(",", ";"));
		}
		if(null != bean.getIlOfnm() && !"".equals(bean.getIlOfnm())) {
			sb.append("&服務處所=").append(bean.getIlOfnm());
		}
		if(null != bean.getIlEnm() && !"".equals(bean.getIlEnm())) {
			sb.append("&英文姓名=").append(bean.getIlEnm());
		}
		if(null != bean.getIlRepmdc() && !"".equals(bean.getIlRepmdc())) {
			sb.append("&重入國許可證號(6位)=").append(bean.getIlRepmdc());
		}
		if(null != bean.getIlRepmdcNic() && !"".equals(bean.getIlRepmdcNic())) {
			sb.append("&重入國許可證號(10位)=").append(bean.getIlRepmdcNic());
		}
		if(null != bean.getIlMicro() && !"".equals(bean.getIlMicro())) {
			sb.append("&縮影編號=").append(bean.getIlMicro());
		}
		if(null != bean.getIlPhq() && !"".equals(bean.getIlPhq())) {
			sb.append("&警局代碼=").append(bean.getIlPhq());
		}
		if(null != bean.getIlSrchst() && !"".equals(bean.getIlSrchst())) {
			sb.append("&特殊身份=").append(bean.getIlSrchst());
		}
		if(null != bean.getIlJbpmdt() && !"".equals(bean.getIlJbpmdt())) {
			sb.append("&工作許可日期=").append(bean.getIlJbpmdt());
		}
		if(null != bean.getIlJbpmdc() && !"".equals(bean.getIlJbpmdc())) {
			sb.append("&文號=").append(bean.getIlJbpmdc());
		}
		if(null != bean.getIlPstext() && !"".equals(bean.getIlPstext())) {
			sb.append("&外責區=").append(bean.getIlPstext());
		}
		if(null != bean.getIlSex() && !"".equals(bean.getIlSex())) {
			sb.append("&性別=").append(bean.getIlSex());
		}
		if(null != bean.getIlOfcd() && !"".equals(bean.getIlOfcd())) {
			sb.append("&就讀學校=").append(bean.getIlOfcd());
		}
		if(null != bean.getIlJbcd() && !"".equals(bean.getIlJbcd())) {
			sb.append("&職業=").append(bean.getIlJbcd().replaceAll(",", ";"));
		}
		if(null != bean.getIlNtcd() && !"".equals(bean.getIlNtcd())) {
			sb.append("&國籍=").append(bean.getIlNtcd().replaceAll(",", ";"));
		}
		if(null != bean.getIlArcst() && !"".equals(bean.getIlArcst())) {
			sb.append("&居留狀況=").append(bean.getIlArcst().replaceAll(",", ";"));
		}
		if(null != bean.getIlEdu() && !"".equals(bean.getIlEdu())) {
			sb.append("&教育程度=").append(bean.getIlEdu().replaceAll(",", ";"));
		}
		if(null != bean.getIlMst() && !"".equals(bean.getIlMst())) {
			sb.append("&婚姻狀況=").append(bean.getIlMst());
		}
		if(null != bean.getIlBthdtFrom() && !"".equals(bean.getIlBthdtFrom())) {
			sb.append("&生日>=").append(bean.getIlBthdtFrom());
		}
		if(null != bean.getIlBthdtTo() && !"".equals(bean.getIlBthdtTo())) {
			sb.append("&生日<=").append(bean.getIlBthdtTo());
		}
		if(null != bean.getIlApydtFrom() && !"".equals(bean.getIlApydtFrom())) {
			sb.append("&申請日期>=").append(bean.getIlApydtFrom());
		}
		if(null != bean.getIlApydtTo() && !"".equals(bean.getIlApydtTo())) {
			sb.append("&申請日期<=").append(bean.getIlApydtTo());
		}
		if(null != bean.getIlFrcexit() && !"".equals(bean.getIlFrcexit())) {
			sb.append("&限期離境=").append(bean.getIlFrcexit());
		}
		if(null != bean.getIlArcfm() && !"".equals(bean.getIlArcfm())) {
			sb.append("&居留期限>=").append(bean.getIlArcfm());
		}
		if(null != bean.getIlArcto() && !"".equals(bean.getIlArcto())) {
			sb.append("&居留期限<=").append(bean.getIlArcto());
		}
		if(null != bean.getIlReapydtFrom() && !"".equals(bean.getIlReapydtFrom())) {
			sb.append("&重入國申請日期>=").append(bean.getIlReapydtFrom());
		}
		if(null != bean.getIlReapydtTo() && !"".equals(bean.getIlReapydtTo())) {
			sb.append("&重入國申請日期<=").append(bean.getIlReapydtTo());
		}
		if(null != bean.getIlMANTYPE() && !"".equals(bean.getIlMANTYPE()) && !"0".equals(bean.getIlMANTYPE())) {
			sb.append("&人口分類=").append(bean.getIlMANTYPE());
		}
		if(null != bean.getIlMissdtFrom() && !"".equals(bean.getIlMissdtFrom())) {
			sb.append("&逃逸日期>=").append(bean.getIlMissdtFrom());
		}
		if(null != bean.getIlMissdtTo() && !"".equals(bean.getIlMissdtTo())) {
			sb.append("&逃逸日期<=").append(bean.getIlMissdtTo());
		}
		if(null != bean.getIlSbmtdtFrom() && !"".equals(bean.getIlSbmtdtFrom())) {
			sb.append("&報案日期>=").append(bean.getIlSbmtdtFrom());
		}
		if(null != bean.getIlSbmtdtTo() && !"".equals(bean.getIlSbmtdtTo())) {
			sb.append("&報案日期<=").append(bean.getIlSbmtdtTo());
		}
		if(null != bean.getIlFnddid() && !"".equals(bean.getIlFnddid())) {
			sb.append("&查獲單位=").append(bean.getIlFnddid());
		}
		if(null != bean.getIlFinddtFrom() && !"".equals(bean.getIlFinddtFrom())) {
			sb.append("&查獲日期>=").append(bean.getIlFinddtFrom());
		}
		if(null != bean.getIlFinddtTo() && !"".equals(bean.getIlFinddtTo())) {
			sb.append("&查獲日期<=").append(bean.getIlFinddtTo());
		}
		if(null != bean.getIlIndtFrom() && !"".equals(bean.getIlIndtFrom())) {
			sb.append("&抵台日期>=").append(bean.getIlIndtFrom());
		}
		if(null != bean.getIlIndtTo() && !"".equals(bean.getIlIndtTo())) {
			sb.append("&抵台日期<=").append(bean.getIlIndtTo());
		}
		if(null != bean.getIlExdtFrom() && !"".equals(bean.getIlExdtFrom())) {
			sb.append("&離台日期>=").append(bean.getIlExdtFrom());
		}
		if(null != bean.getIlExdtTo() && !"".equals(bean.getIlExdtTo())) {
			sb.append("&離台日期<=").append(bean.getIlExdtTo());
		}
		if(null != bean.getIlFbdrsn() && !"".equals(bean.getIlFbdrsn())) {
			sb.append("&撤銷居留原因=").append(bean.getIlFbdrsn());
		}
		
		setQueryStr(sb.toString().substring(1));
	}

	IL03A01Query02Bean setValToBean(String ilArcno, String ilPspt, String ilEnm, String ilCnm, String ilOfnm,
			String ilPhq, String ilJbpmdt, String ilJbpmdc, String txtBthd, String txtBthdFrom, String txtBthdTo, String ilRepmdc,
			String ilRepmdcNic, String ilMicro, String SRCHST, String PSTEXT, String SEX, String UV, String OP_LIST,
			String NT_LIST, String ARCST_LIST, String EDU_LIST, String MST, String FBDRSN, String txtAPY_FROM,
			String txtAPY_TO, String FRCEXIT, String txtARC_FROM, String txtARC_TO, String txtREAPY_FROM,
			String txtREAPY_TO, String txtMISS_FROM, String txtMISS_TO, String txtSBMT_FROM, String txtSBMT_TO,
			String FNDDID, String txtFIND_FROM, String txtFIND_TO, String txtIN_FROM, String txtIN_TO, String MANTYPE,
			String txtEXIT_FROM, String txtEXIT_TO, String chkARCNO, String chkPSPT, String chkENM, String chkNTCD,
			String chkBTHDT, String chkCNM, String chkARCFM, String chkARCTO, String chkSEX, String chkJBCD,
			String chkARCST, String chkARCRSN, String chkEDU, String chkOFCD, String chkOFNM, String chkOFTEL,
			String chkJBADDR, String chkJBTEL, String chkARPZONE, String chkARADDR, String chkARTEL, String chkPHQ,
			String chkPSTEXT, String chkFRSHP, String chkFNTCD, String chkMISSDT, String chkSBMTDT, String chkFNDDT,
			String chkSRCHST, String chkINDT, String chkEXDT, String chkFPID, String chkFNM, String chkAPYDT,
			String chkARCRCP, String chkMICRO, String chkOLDARCNO, String chkilNTNM, String chkMANTYPE) {

		IL03A01Query02Bean bean = new IL03A01Query02Bean();

//		bean.setId(id);
		bean.setIlArcno(ilArcno);
		bean.setIlPspt(ilPspt);
		bean.setIlEnm(ilEnm);
		bean.setIlCnm(ilCnm);
		bean.setIlOfnm(ilOfnm);
		bean.setIlPhq(ilPhq);
		bean.setIlJbpmdt(ilJbpmdt);
		bean.setIlJbpmdc(ilJbpmdc);
		bean.setIlBthdt(txtBthd);
		bean.setIlBthdtFrom(txtBthdFrom);
		bean.setIlBthdtTo(txtBthdTo);
		bean.setIlRepmdc(ilRepmdc);
		bean.setIlRepmdcNic(ilRepmdcNic);
		bean.setIlMicro(ilMicro);
		bean.setIlSrchst(SRCHST);
		bean.setIlPstext(PSTEXT);
		bean.setIlSex(SEX);
		bean.setIlOfcd(UV);
		bean.setIlJbcd(OP_LIST);
		bean.setIlNtcd(NT_LIST);
		bean.setIlArcst(ARCST_LIST);
		bean.setIlEdu(EDU_LIST);
		bean.setIlMst(MST);
		bean.setIlFbdrsn(FBDRSN);
		bean.setIlApydtFrom(txtAPY_FROM);
		bean.setIlApydtTo(txtAPY_TO);
		bean.setIlFrcexit(FRCEXIT);
		bean.setIlArcfm(txtARC_FROM);
		bean.setIlArcto(txtARC_TO);
		bean.setIlReapydtFrom(txtREAPY_FROM);
		bean.setIlReapydtTo(txtREAPY_TO);
		bean.setIlMissdtFrom(txtMISS_FROM);
		bean.setIlMissdtTo(txtMISS_TO);
		bean.setIlSbmtdtFrom(txtSBMT_FROM);
		bean.setIlSbmtdtTo(txtSBMT_TO);
		bean.setIlFnddid(FNDDID);
		bean.setIlFinddtFrom(txtFIND_FROM);
		bean.setIlFinddtTo(txtFIND_TO);
		bean.setIlIndtFrom(txtIN_FROM);
		bean.setIlIndtTo(txtIN_TO);
		bean.setIlMANTYPE(MANTYPE);
		bean.setIlExdtFrom(txtEXIT_FROM);
		bean.setIlExdtTo(txtEXIT_TO);
		bean.setChkARCNO(chkARCNO);
		bean.setChkPSPT(chkPSPT);
		bean.setChkENM(chkENM);
		bean.setChkNTCD(chkNTCD);
		bean.setChkBTHDT(chkBTHDT);
		bean.setChkCNM(chkCNM);
		bean.setChkARCFM(chkARCFM);
		bean.setChkARCTO(chkARCTO);
		bean.setChkSEX(chkSEX);
		bean.setChkJBCD(chkJBCD);
		bean.setChkARCST(chkARCST);
		bean.setChkARCRSN(chkARCRSN);
		bean.setChkEDU(chkEDU);
		bean.setChkOFCD(chkOFCD);
		bean.setChkOFNM(chkOFNM);
		bean.setChkOFTEL(chkOFTEL);
		bean.setChkJBADDR(chkJBADDR);
		bean.setChkJBTEL(chkJBTEL);
		bean.setChkARPZONE(chkARPZONE);
		bean.setChkARADDR(chkARADDR);
		bean.setChkARTEL(chkARTEL);
		bean.setChkPHQ(chkPHQ);
		bean.setChkPSTEXT(chkPSTEXT);
		bean.setChkFRSHP(chkFRSHP);
		bean.setChkFNTCD(chkFNTCD);
		bean.setChkMISSDT(chkMISSDT);
		bean.setChkSBMTDT(chkSBMTDT);
		bean.setChkFNDDT(chkFNDDT);
		bean.setChkSRCHST(chkSRCHST);
		bean.setChkINDT(chkINDT);
		bean.setChkEXDT(chkEXDT);
		bean.setChkFPID(chkFPID);
		bean.setChkFNM(chkFNM);
		bean.setChkAPYDT(chkAPYDT);
		bean.setChkARCRCP(chkARCRCP);
		bean.setChkMICRO(chkMICRO);
		bean.setChkOLDARCNO(chkOLDARCNO);
		bean.setChkilNTNM(chkilNTNM);
		bean.setChkMANTYPE(chkMANTYPE);
		return bean;

	}

	protected void InsertWaterMarkToXLS(com.aspose.cells.Workbook workbook, Worksheet sheet, String watermarkText,
			int upperLeftRow, int top, int upperLeftColumn, int left, int height, int width) {
		// 添加浮水印
		com.aspose.cells.Shape wordart = sheet.getShapes().addTextEffect(MsoPresetTextEffect.TEXT_EFFECT_1, watermarkText, "標楷體 標準", 8, false, true, upperLeftRow, top, upperLeftColumn, left, height, width);
		wordart.setRotationAngle(-30);
		// 用藝術字體填充
		MsoFillFormat wordArtFormat = wordart.getFillFormat();
		// 設置顏色
		wordArtFormat.setForeColor(Color.getGray());
		// 設置透明度
		wordArtFormat.setTransparency(0.5);
		// 設置線條不可見
		MsoLineFormat lineFormat = wordart.getLineFormat();
		lineFormat.setVisible(false);
		lineFormat.setForeColor(Color.getWhite());
		lineFormat.setTransparency(0.5);
	}

	public String toQuery() throws Exception {
		return "success";
	}

	public List<IL03A01Q02Bean> getQueryList() {
		return this.queryList;
	}

	public void setQueryList(List<IL03A01Q02Bean> queryList) {
		this.queryList = queryList;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public MyIltb01MainDAO getMyIltb01MainDAO() {
		return myIltb01MainDAO;
	}

	public void setMyIltb01MainDAO(MyIltb01MainDAO myIltb01MainDAO) {
		this.myIltb01MainDAO = myIltb01MainDAO;
	}

	public MyIltb01MainDAO2 getMyIltb01MainDAO2() {
		return myIltb01MainDAO2;
	}

	public void setMyIltb01MainDAO2(MyIltb01MainDAO2 myIltb01MainDAO2) {
		this.myIltb01MainDAO2 = myIltb01MainDAO2;
	}

	public List<String> getDataList() {
		return dataList;
	}

	public void setDataList(List<String> dataList) {
		this.dataList = dataList;
	}

	public String getIlArcno() {
		return ilArcno;
	}

	public void setIlArcno(String ilArcno) {
		this.ilArcno = ilArcno;
	}

	public String getIlPspt() {
		return ilPspt;
	}

	public void setIlPspt(String ilPspt) {
		this.ilPspt = ilPspt;
	}

	public String getIlEnm() {
		return ilEnm;
	}

	public void setIlEnm(String ilEnm) {
		this.ilEnm = ilEnm;
	}

	public String getIlCnm() {
		return ilCnm;
	}

	public void setIlCnm(String ilCnm) {
		this.ilCnm = ilCnm;
	}

	public String getIlOfnm() {
		return ilOfnm;
	}

	public void setIlOfnm(String ilOfnm) {
		this.ilOfnm = ilOfnm;
	}

	public String getIlPhq() {
		return ilPhq;
	}

	public void setIlPhq(String ilPhq) {
		this.ilPhq = ilPhq;
	}

	public String getIlJbpmdt() {
		return ilJbpmdt;
	}

	public void setIlJbpmdt(String ilJbpmdt) {
		this.ilJbpmdt = ilJbpmdt;
	}

	public String getIlJbpmdc() {
		return ilJbpmdc;
	}

	public void setIlJbpmdc(String ilJbpmdc) {
		this.ilJbpmdc = ilJbpmdc;
	}

	public String getQueryFrom() {
		return QueryFrom;
	}

	public void setQueryFrom(String queryFrom) {
		QueryFrom = queryFrom;
	}

	public Constant getConstant() {
		return constant;
	}

	public void setConstant(Constant constant) {
		this.constant = constant;
	}

	public String getLogcn() {
		return logcn;
	}

	public void setLogcn(String logcn) {
		this.logcn = logcn;
	}

	public String getLogpstname() {
		return logpstname;
	}

	public void setLogpstname(String logpstname) {
		this.logpstname = logpstname;
	}

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public GetDateUtil getGetDateUtil() {
		return getDateUtil;
	}

	public void setGetDateUtil(GetDateUtil getDateUtil) {
		this.getDateUtil = getDateUtil;
	}

	public NTPCUtil getNtpcUtil() {
		return ntpcUtil;
	}

	public void setNtpcUtil(NTPCUtil ntpcUtil) {
		this.ntpcUtil = ntpcUtil;
	}

	public String getPSTEXT() {
		return PSTEXT;
	}

	public void setPSTEXT(String pSTEXT) {
		PSTEXT = pSTEXT;
	}

	public String getTxtBTHD_FROM() {
		return txtBTHD_FROM;
	}

	public void setTxtBTHD_FROM(String txtBTHD_FROM) {
		this.txtBTHD_FROM = txtBTHD_FROM;
	}

	public String getTxtBTHD_TO() {
		return txtBTHD_TO;
	}

	public void setTxtBTHD_TO(String txtBTHD_TO) {
		this.txtBTHD_TO = txtBTHD_TO;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getARCST() {
		return ARCST;
	}

	public void setARCST(String aRCST) {
		ARCST = aRCST;
	}

	public String getARCST_LIST() {
		return ARCST_LIST;
	}

	public void setARCST_LIST(String aRCST_LIST) {
		ARCST_LIST = aRCST_LIST;
	}

	public String getOP() {
		return OP;
	}

	public void setOP(String oP) {
		OP = oP;
	}

	public String getOP_LIST() {
		return OP_LIST;
	}

	public void setOP_LIST(String oP_LIST) {
		OP_LIST = oP_LIST;
	}

	public String getNT() {
		return NT;
	}

	public void setNT(String nT) {
		NT = nT;
	}

	public String getNT_LIST() {
		return NT_LIST;
	}

	public void setNT_LIST(String nT_LIST) {
		NT_LIST = nT_LIST;
	}

	public String getUV() {
		return UV;
	}

	public void setUV(String uV) {
		UV = uV;
	}

	public String getTxtARC_FROM() {
		return txtARC_FROM;
	}

	public void setTxtARC_FROM(String txtARC_FROM) {
		this.txtARC_FROM = txtARC_FROM;
	}

	public String getTxtARC_TO() {
		return txtARC_TO;
	}

	public void setTxtARC_TO(String txtARC_TO) {
		this.txtARC_TO = txtARC_TO;
	}

	public String getEDU() {
		return EDU;
	}

	public void setEDU(String eDU) {
		EDU = eDU;
	}

	public String getEDU_LIST() {
		return EDU_LIST;
	}

	public void setEDU_LIST(String eDU_LIST) {
		EDU_LIST = eDU_LIST;
	}

	public String getMST() {
		return MST;
	}

	public void setMST(String mST) {
		MST = mST;
	}

	public String getFRCEXIT() {
		return FRCEXIT;
	}

	public void setFRCEXIT(String fRCEXIT) {
		FRCEXIT = fRCEXIT;
	}

	public String getTxtAPY_FROM() {
		return txtAPY_FROM;
	}

	public void setTxtAPY_FROM(String txtAPY_FROM) {
		this.txtAPY_FROM = txtAPY_FROM;
	}

	public String getTxtAPY_TO() {
		return txtAPY_TO;
	}

	public void setTxtAPY_TO(String txtAPY_TO) {
		this.txtAPY_TO = txtAPY_TO;
	}

	public String getFBDRSN() {
		return FBDRSN;
	}

	public void setFBDRSN(String fBDRSN) {
		FBDRSN = fBDRSN;
	}

	public String getTxtREAPY_FROM() {
		return txtREAPY_FROM;
	}

	public void setTxtREAPY_FROM(String txtREAPY_FROM) {
		this.txtREAPY_FROM = txtREAPY_FROM;
	}

	public String getTxtREAPY_TO() {
		return txtREAPY_TO;
	}

	public void setTxtREAPY_TO(String txtREAPY_TO) {
		this.txtREAPY_TO = txtREAPY_TO;
	}

	public String getSRCHST() {
		return SRCHST;
	}

	public void setSRCHST(String sRCHST) {
		SRCHST = sRCHST;
	}

	public String getTxtMISS_FROM() {
		return txtMISS_FROM;
	}

	public void setTxtMISS_FROM(String txtMISS_FROM) {
		this.txtMISS_FROM = txtMISS_FROM;
	}

	public String getTxtMISS_TO() {
		return txtMISS_TO;
	}

	public void setTxtMISS_TO(String txtMISS_TO) {
		this.txtMISS_TO = txtMISS_TO;
	}

	public String getTxtSBMT_FROM() {
		return txtSBMT_FROM;
	}

	public void setTxtSBMT_FROM(String txtSBMT_FROM) {
		this.txtSBMT_FROM = txtSBMT_FROM;
	}

	public String getTxtSBMT_TO() {
		return txtSBMT_TO;
	}

	public void setTxtSBMT_TO(String txtSBMT_TO) {
		this.txtSBMT_TO = txtSBMT_TO;
	}

	public String getFNDDID() {
		return FNDDID;
	}

	public void setFNDDID(String fNDDID) {
		FNDDID = fNDDID;
	}

	public String getTxtFIND_FROM() {
		return txtFIND_FROM;
	}

	public void setTxtFIND_FROM(String txtFIND_FROM) {
		this.txtFIND_FROM = txtFIND_FROM;
	}

	public String getTxtFIND_TO() {
		return txtFIND_TO;
	}

	public void setTxtFIND_TO(String txtFIND_TO) {
		this.txtFIND_TO = txtFIND_TO;
	}

	public String getTxtIN_FROM() {
		return txtIN_FROM;
	}

	public void setTxtIN_FROM(String txtIN_FROM) {
		this.txtIN_FROM = txtIN_FROM;
	}

	public String getTxtIN_TO() {
		return txtIN_TO;
	}

	public void setTxtIN_TO(String txtIN_TO) {
		this.txtIN_TO = txtIN_TO;
	}

	public String getTxtEXIT_FROM() {
		return txtEXIT_FROM;
	}

	public void setTxtEXIT_FROM(String txtEXIT_FROM) {
		this.txtEXIT_FROM = txtEXIT_FROM;
	}

	public String getTxtEXIT_TO() {
		return txtEXIT_TO;
	}

	public void setTxtEXIT_TO(String txtEXIT_TO) {
		this.txtEXIT_TO = txtEXIT_TO;
	}

	public String getMANTYPE() {
		return MANTYPE;
	}

	public void setMANTYPE(String mANTYPE) {
		MANTYPE = mANTYPE;
	}

	public String getIlMicro() {
		return ilMicro;
	}

	public void setIlMicro(String ilMicro) {
		this.ilMicro = ilMicro;
	}

	public String getIlRepmdc() {
		return ilRepmdc;
	}

	public void setIlRepmdc(String ilRepmdc) {
		this.ilRepmdc = ilRepmdc;
	}

	public String getIlRepmdcNic() {
		return ilRepmdcNic;
	}

	public void setIlRepmdcNic(String ilRepmdcNic) {
		this.ilRepmdcNic = ilRepmdcNic;
	}

	public List<Iltb20OnlineReport> getIltb20IdList() {
		return iltb20IdList;
	}

	public void setIltb20IdList(List<Iltb20OnlineReport> iltb20IdList) {
		this.iltb20IdList = iltb20IdList;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public String getChkARCNO() {
		return chkARCNO;
	}

	public void setChkARCNO(String chkARCNO) {
		this.chkARCNO = chkARCNO;
	}

	public String getChkPSPT() {
		return chkPSPT;
	}

	public void setChkPSPT(String chkPSPT) {
		this.chkPSPT = chkPSPT;
	}

	public String getChkENM() {
		return chkENM;
	}

	public void setChkENM(String chkENM) {
		this.chkENM = chkENM;
	}

	public String getChkNTCD() {
		return chkNTCD;
	}

	public void setChkNTCD(String chkNTCD) {
		this.chkNTCD = chkNTCD;
	}

	public String getChkBTHDT() {
		return chkBTHDT;
	}

	public void setChkBTHDT(String chkBTHDT) {
		this.chkBTHDT = chkBTHDT;
	}

	public String getChkCNM() {
		return chkCNM;
	}

	public void setChkCNM(String chkCNM) {
		this.chkCNM = chkCNM;
	}

	public String getChkARCFM() {
		return chkARCFM;
	}

	public void setChkARCFM(String chkARCFM) {
		this.chkARCFM = chkARCFM;
	}

	public String getChkARCTO() {
		return chkARCTO;
	}

	public void setChkARCTO(String chkARCTO) {
		this.chkARCTO = chkARCTO;
	}

	public String getChkSEX() {
		return chkSEX;
	}

	public void setChkSEX(String chkSEX) {
		this.chkSEX = chkSEX;
	}

	public String getChkJBCD() {
		return chkJBCD;
	}

	public void setChkJBCD(String chkJBCD) {
		this.chkJBCD = chkJBCD;
	}

	public String getChkARCST() {
		return chkARCST;
	}

	public void setChkARCST(String chkARCST) {
		this.chkARCST = chkARCST;
	}

	public String getChkARCRSN() {
		return chkARCRSN;
	}

	public void setChkARCRSN(String chkARCRSN) {
		this.chkARCRSN = chkARCRSN;
	}

	public String getChkEDU() {
		return chkEDU;
	}

	public void setChkEDU(String chkEDU) {
		this.chkEDU = chkEDU;
	}

	public String getChkOFCD() {
		return chkOFCD;
	}

	public void setChkOFCD(String chkOFCD) {
		this.chkOFCD = chkOFCD;
	}

	public String getChkOFNM() {
		return chkOFNM;
	}

	public void setChkOFNM(String chkOFNM) {
		this.chkOFNM = chkOFNM;
	}

	public String getChkOFTEL() {
		return chkOFTEL;
	}

	public void setChkOFTEL(String chkOFTEL) {
		this.chkOFTEL = chkOFTEL;
	}

	public String getChkJBADDR() {
		return chkJBADDR;
	}

	public void setChkJBADDR(String chkJBADDR) {
		this.chkJBADDR = chkJBADDR;
	}

	public String getChkJBTEL() {
		return chkJBTEL;
	}

	public void setChkJBTEL(String chkJBTEL) {
		this.chkJBTEL = chkJBTEL;
	}

	public String getChkARPZONE() {
		return chkARPZONE;
	}

	public void setChkARPZONE(String chkARPZONE) {
		this.chkARPZONE = chkARPZONE;
	}

	public String getChkARADDR() {
		return chkARADDR;
	}

	public void setChkARADDR(String chkARADDR) {
		this.chkARADDR = chkARADDR;
	}

	public String getChkARTEL() {
		return chkARTEL;
	}

	public void setChkARTEL(String chkARTEL) {
		this.chkARTEL = chkARTEL;
	}

	public String getChkPHQ() {
		return chkPHQ;
	}

	public void setChkPHQ(String chkPHQ) {
		this.chkPHQ = chkPHQ;
	}

	public String getChkPSTEXT() {
		return chkPSTEXT;
	}

	public void setChkPSTEXT(String chkPSTEXT) {
		this.chkPSTEXT = chkPSTEXT;
	}

	public String getChkFRSHP() {
		return chkFRSHP;
	}

	public void setChkFRSHP(String chkFRSHP) {
		this.chkFRSHP = chkFRSHP;
	}

	public String getChkFNTCD() {
		return chkFNTCD;
	}

	public void setChkFNTCD(String chkFNTCD) {
		this.chkFNTCD = chkFNTCD;
	}

	public String getChkMISSDT() {
		return chkMISSDT;
	}

	public void setChkMISSDT(String chkMISSDT) {
		this.chkMISSDT = chkMISSDT;
	}

	public String getChkSBMTDT() {
		return chkSBMTDT;
	}

	public void setChkSBMTDT(String chkSBMTDT) {
		this.chkSBMTDT = chkSBMTDT;
	}

	public String getChkFNDDT() {
		return chkFNDDT;
	}

	public void setChkFNDDT(String chkFNDDT) {
		this.chkFNDDT = chkFNDDT;
	}

	public String getChkSRCHST() {
		return chkSRCHST;
	}

	public void setChkSRCHST(String chkSRCHST) {
		this.chkSRCHST = chkSRCHST;
	}

	public String getChkINDT() {
		return chkINDT;
	}

	public void setChkINDT(String chkINDT) {
		this.chkINDT = chkINDT;
	}

	public String getChkEXDT() {
		return chkEXDT;
	}

	public void setChkEXDT(String chkEXDT) {
		this.chkEXDT = chkEXDT;
	}

	public String getChkFPID() {
		return chkFPID;
	}

	public void setChkFPID(String chkFPID) {
		this.chkFPID = chkFPID;
	}

	public String getChkFNM() {
		return chkFNM;
	}

	public void setChkFNM(String chkFNM) {
		this.chkFNM = chkFNM;
	}

	public String getChkAPYDT() {
		return chkAPYDT;
	}

	public void setChkAPYDT(String chkAPYDT) {
		this.chkAPYDT = chkAPYDT;
	}

	public String getChkARCRCP() {
		return chkARCRCP;
	}

	public void setChkARCRCP(String chkARCRCP) {
		this.chkARCRCP = chkARCRCP;
	}

	public String getChkMICRO() {
		return chkMICRO;
	}

	public void setChkMICRO(String chkMICRO) {
		this.chkMICRO = chkMICRO;
	}

	public String getChkOLDARCNO() {
		return chkOLDARCNO;
	}

	public void setChkOLDARCNO(String chkOLDARCNO) {
		this.chkOLDARCNO = chkOLDARCNO;
	}

	public String getChkMANTYPE() {
		return chkMANTYPE;
	}

	public void setChkMANTYPE(String chkMANTYPE) {
		this.chkMANTYPE = chkMANTYPE;
	}

	public static Logger getLogger() {
		return logger;
	}

	public String getChkilNTNM() {
		return chkilNTNM;
	}

	public void setChkilNTNM(String chkilNTNM) {
		this.chkilNTNM = chkilNTNM;
	}

	public String getPageType() {
		return pageType;
	}

	public void setPageType(String pageType) {
		this.pageType = pageType;
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

	public String getTxtBTHD() {
		return txtBTHD;
	}

	public void setTxtBTHD(String txtBTHD) {
		this.txtBTHD = txtBTHD;
	}
	
	

}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\action\IL03A01Q02.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */