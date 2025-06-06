package tw.gov.npa.il.tranceData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.dao.Iltb18DataProcessResult;
import tw.gov.npa.il.e0db.myDao.RelationDAO;
import tw.gov.npa.il.myDao.IL07C01ADao;

public class IL07C01A {
	private StringBuffer IMPFL = new StringBuffer("IL71");

	private int h_nImpTot = 0;

	private int h_nImpOK = 0;

	private int h_nImpErr1 = 0;

	private int h_nImpErr2 = 0;

	private int h_nImpErr3 = 0;

	private int h_nImpErr4 = 0;

	private int h_nImpErr5 = 0;

	private int h_nImpErr6 = 0;

	private int h_nImpErr7 = 0;

	private int h_nImpErr8 = 0;

	private int h_nImpErr9 = 0;

	private int h_nImpErr10 = 0;

	private String user = "testUser";

	private String fileName;

	private Date processDate;

	private ArrayList<String> logList = new ArrayList<String>();

	private ArrayList<String> logList2 = new ArrayList<String>();

	private ArrayList<String> logList3 = new ArrayList<String>();

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private SimpleDateFormat sdf3 = new SimpleDateFormat("MMM dd yyyy hh:mmaa", Locale.ENGLISH);

	private SimpleDateFormat sdf4 = new SimpleDateFormat("hhmmss", Locale.ENGLISH);

	public IL07C01ADao il07C01ADao;

	private static final Logger logger = Logger.getLogger(IL07C01A.class);

	private File file;

//	ResourceBundle rb = ResourceBundle.getBundle("config");

//	private String contextPath = this.rb.getString("FileRoot").toString();
	private String contextPath = "D:\\IL2\\file";

	public RelationDAO relationDAO;

	private List<String> IlSrchstList;
	private List<String> newIlSrchstList;

	public RelationDAO getRelationDAO() {
		return this.relationDAO;
	}

	public void setRelationDAO(RelationDAO relationDAO) {
		this.relationDAO = relationDAO;
	}

	public IL07C01ADao getIl07C01ADao() {
		return this.il07C01ADao;
	}

	public void setIl07C01ADao(IL07C01ADao il07c01aDao) {
		this.il07C01ADao = il07c01aDao;
	}

	private String dateConvert(String convertNumber, String type) {
		int value = Integer.parseInt(convertNumber);
		if (value < 10)
			return Integer.toString(value);
		if (type.equals("year"))
			return convertNumber.substring(2, 4);
		if (type.equals("month")) {
			switch (value) {
			case 10:
				return "A";
			case 11:
				return "B";
			case 12:
				return "C";
			}
			return null;
		}
		if (type.equals("day")) {
			switch (value) {
			case 10:
				return "A";
			case 11:
				return "B";
			case 12:
				return "C";
			case 13:
				return "D";
			case 14:
				return "E";
			case 15:
				return "F";
			case 16:
				return "G";
			case 17:
				return "H";
			case 18:
				return "I";
			case 19:
				return "J";
			case 20:
				return "K";
			case 21:
				return "L";
			case 22:
				return "M";
			case 23:
				return "N";
			case 24:
				return "O";
			case 25:
				return "P";
			case 26:
				return "Q";
			case 27:
				return "R";
			case 28:
				return "S";
			case 29:
				return "T";
			case 30:
				return "U";
			case 31:
				return "V";
			}
			return null;
		}
		return null;
	}

	public void il07C01aMain(int control, String fileName) {
		logger.info("居留主檔轉入 執行開始");
		if (control == 0) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(5, -1);
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			String autoDate = sdf2.format(cal.getTime());
			try {
				if (this.il07C01ADao.queryCountbyKey(autoDate, "3") == 0)
					;
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
		}
		ArrayList<Iltb18DataProcessResult> jobList = searchJob();
		if (jobList.size() > 0)
			for (int i = 0; i < jobList.size(); i++)
				startJob(((Iltb18DataProcessResult) jobList.get(i)).getIlImpuid(),
						((Iltb18DataProcessResult) jobList.get(i)).getId().getIlImptp(),
						((Iltb18DataProcessResult) jobList.get(i)).getId().getIlImpdt(),
						((Iltb18DataProcessResult) jobList.get(i)).getIlImpfl());
		logger.info("居留主檔轉入執行完畢 執行次數:" + jobList.size());
	}

	private void startJob(String user, String type, Timestamp impdt, String filename) {
		this.h_nImpTot = 0;
		this.h_nImpOK = 0;
		this.h_nImpErr1 = 0;
		this.h_nImpErr2 = 0;
		this.h_nImpErr3 = 0;
		this.h_nImpErr4 = 0;
		this.h_nImpErr5 = 0;
		this.h_nImpErr6 = 0;
		this.h_nImpErr7 = 0;
		this.h_nImpErr8 = 0;
		this.h_nImpErr9 = 0;
		this.h_nImpErr10 = 0;
		this.logList.clear();
		this.logList2.clear();
		int sucess = 0;
		this.user = user;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		String date = df.format(impdt);
		this.processDate = impdt;
		try {
			this.il07C01ADao.updateLog(impdt, "2", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, this.h_nImpErr2,
					this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, this.h_nImpErr7);
			this.fileName = filename.trim();
			this.file = new File(this.contextPath + "\\" + this.fileName);
			sucess = readFile();
		} catch (Exception e) {
			this.il07C01ADao.updateLog(impdt, "3", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, this.h_nImpErr2,
					this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, this.h_nImpErr7);
		}
		logger.info("寫檔結果:" + sucess);
		if (sucess == 1) {
			this.il07C01ADao.updateLog(impdt, "1", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, this.h_nImpErr2,
					this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, this.h_nImpErr7);
			writeLog(1);
		} else if (sucess == 0) {
			this.il07C01ADao.updateLog(impdt, "3", this.h_nImpTot, this.h_nImpOK, this.h_nImpErr1, this.h_nImpErr2,
					this.h_nImpErr3, this.h_nImpErr4, this.h_nImpErr5, this.h_nImpErr6, this.h_nImpErr7);
			writeLog(0);
		}
	}

	private ArrayList<Iltb18DataProcessResult> searchJob() {
		return this.il07C01ADao.queryByStatus("0");
	}

	private int readFile() {
		if (this.file.exists()) {
			try {
				BufferedReader in = new BufferedReader(
						new InputStreamReader(new FileInputStream(this.file.getPath()), "ISO-8859-1"));
				int count = 0;

				newIlSrchstList = new ArrayList<String>();
				while (in.ready()) {
					Iltb01Main iltb01Main = new Iltb01Main();
					String str = in.readLine();
					String processCol = "";
					long newId = 0L;
					if (!str.equals("")) {
						count++;
						String str1 = new String(str.getBytes("Big5"), "UTF-8");
						String str2 = new String(str.getBytes("ISO-8859-1"), "Big5");
						String str3 = new String(str.getBytes("Big5"), "ISO-8859-1");
						String str4 = new String(str.getBytes("UTF-8"), "Big5");
						if (str.length() == 2997) {
							logger.info(count + " : 新格式轉入");
							try {
								if (!convertValue(str, 2985, 2997).equals(""))
									newId = Long.parseLong(convertValue(str, 2985, 2997));
								processCol = "外來人口統一證號";
								iltb01Main.setIlArcno(convertValue(str, 633, 643).trim());
								processCol = "英文姓名";
								iltb01Main.setIlEnm(convertValue(str, 9, 59).trim());
								processCol = "出生日期";
								iltb01Main.setIlBthdt(convertValue(str, 72, 80).trim());
								processCol = "國籍代碼";
								iltb01Main.setIlNtcd(convertValue(str, 80, 83).trim());
								processCol = "護照號碼";
								iltb01Main.setIlPspt(convertValue(str, 83, 98).trim());
								processCol = "居留性質";
								Integer.parseInt(convertValue(str, 7, 8).trim());
								iltb01Main.setIlArctp(convertValue(str, 7, 8).trim());
								processCol = "外僑識別";
								iltb01Main.setIlArccs(convertValue(str, 8, 9).trim());
								processCol = "中文姓名";
								iltb01Main.setIlCnm(convertValue(str, 59, 71).trim());
								processCol = "性別";
								iltb01Main.setIlSex(convertValue(str, 71, 72).trim());
								processCol = "護照期限";
								iltb01Main.setIlPsdt(Timestamp
										.valueOf(this.sdf.format(this.sdf3.parse(convertValue(str, 98, 117).trim()))));
								processCol = "婚姻狀況";
								iltb01Main.setIlMst(convertValue(str, 117, 118).trim());
								processCol = "教育程度";
								iltb01Main.setIlEdu(convertValue(str, 118, 120).trim());
								processCol = "抵台日期";
								if (!convertValue(str, 120, 139).trim().equals(""))
									iltb01Main.setIlIndt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 120, 139).trim()))));
								processCol = "離台日期";
								if (!convertValue(str, 139, 158).trim().equals(""))
									iltb01Main.setIlExdt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 139, 158).trim()))));
								processCol = "居留事由";
								iltb01Main.setIlArcrsn(convertValue(str, 158, 159).trim());
								processCol = "居留狀況";
								iltb01Main.setIlArcst(convertValue(str, 159, 160).trim());
								processCol = "職業代碼";
								iltb01Main.setIlJbcd(convertValue(str, 160, 162).trim());
								processCol = "職位(職稱)";
								iltb01Main.setIlJbpsn(convertValue(str, 162, 172).trim());
								processCol = "服務處所代碼";
								iltb01Main.setIlOfcd(convertValue(str, 172, 176).trim());
								processCol = "服務處所名稱";
								iltb01Main.setIlOfnm(convertValue(str, 176, 224).trim());
								processCol = "服務處所電話";
								iltb01Main.setIlOftel(convertValue(str, 224, 239).trim());
								processCol = "服務處所簡稱";
								iltb01Main.setIlOfnmbf(convertValue(str, 239, 249).trim());
								processCol = "工作地址郵遞區號";
								iltb01Main.setIlJbpzone(convertValue(str, 249, 252).trim());
								processCol = "工作地址";
								iltb01Main.setIlJbaddr(convertValue(str, 252, 344).trim());
								processCol = "工作地址電話";
								iltb01Main.setIlJbtel(convertValue(str, 344, 359).trim());
								processCol = "居留地址郵遞區號";
								iltb01Main.setIlArpzone(convertValue(str, 359, 362).trim());
								processCol = "居留地址";
								iltb01Main.setIlAraddr(convertValue(str, 362, 454).trim());
								processCol = "居留電話";
								iltb01Main.setIlArtel(convertValue(str, 454, 469).trim());
								processCol = "仲介公司名稱";
								iltb01Main.setIlAgnco(convertValue(str, 469, 513).trim());
								processCol = "仲介公司電話";
								iltb01Main.setIlAgntel(convertValue(str, 513, 528).trim());
								processCol = "工作許可機關";
								iltb01Main.setIlJbpmcd(convertValue(str, 528, 529).trim());
								processCol = "工作許可文號";
								iltb01Main.setIlJbpmdc(convertValue(str, 529, 539).trim());
								processCol = "工作許可日期";
								if (!convertValue(str, 539, 558).trim().equals(""))
									iltb01Main.setIlJbpmdt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 539, 558).trim()))));
								processCol = "工作許可效期起日";
								if (!convertValue(str, 558, 577).trim().equals(""))
									iltb01Main.setIlJbpmfm(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 558, 577).trim()))));
								processCol = "工作許可效期迄日";
								if (!convertValue(str, 577, 596).trim().equals(""))
									iltb01Main.setIlJbpmto(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 577, 596).trim()))));
								processCol = "縮影號碼";
								iltb01Main.setIlMicro(convertValue(str, 596, 606).trim());
								processCol = "申請日期";
								iltb01Main.setIlApydt(Timestamp
										.valueOf(this.sdf.format(this.sdf3.parse(convertValue(str, 606, 625).trim()))));
								processCol = "收據號碼";
								iltb01Main.setIlArcrcp(convertValue(str, 625, 633).trim());
								processCol = "居留效期起日";
								iltb01Main.setIlArcfm(Timestamp
										.valueOf(this.sdf.format(this.sdf3.parse(convertValue(str, 643, 662).trim()))));
								processCol = "居留效期迄日";
								if (!convertValue(str, 662, 681).trim().equals(""))
									iltb01Main.setIlArcto(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 662, 681).trim()))));
								processCol = "管轄分局";
								iltb01Main.setIlPst(convertValue(str, 681, 685).trim());
								processCol = "管轄警局";
								iltb01Main.setIlPhq(convertValue(str, 685, 689).trim());
								processCol = "外責區註記";
								iltb01Main.setIlPstext(convertValue(str, 689, 691).trim());
								processCol = "備註";
								iltb01Main.setIlRemrk(convertValue(str, 691, 2691).trim());
								processCol = "發證類別";
								iltb01Main.setIlArcisu(convertValue(str, 2691, 2692).trim());
								processCol = "親屬稱謂代碼";
								iltb01Main.setIlFrshp(convertValue(str, 2692, 2694).trim());
								processCol = "親屬姓名";
								iltb01Main.setIlFnm(convertValue(str, 2694, 2738).trim());
								processCol = "親屬身份(居留)證號";
								iltb01Main.setIlFpid(convertValue(str, 2738, 2748).trim());
								processCol = "親屬國籍代碼";
								iltb01Main.setIlFntcd(convertValue(str, 2748, 2751).trim());
								processCol = "限期離境原因代碼";
								iltb01Main.setIlFrcexit(convertValue(str, 2751, 2753).trim());
								processCol = "重入國申請日期";
								if (!convertValue(str, 2753, 2772).trim().equals(""))
									iltb01Main.setIlReapydt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2753, 2772).trim()))));
								processCol = "重入國申請項別";
								iltb01Main.setIlRetp(convertValue(str, 2772, 2773).trim());
								processCol = "重入國許可證號";
								iltb01Main.setIlRepmdc(convertValue(str, 2773, 2779).trim());
								processCol = "重入國有效期限";
								if (!convertValue(str, 2779, 2798).trim().equals(""))
									iltb01Main.setIlRepmdt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2779, 2798).trim()))));
								processCol = "重入國備考";
								iltb01Main.setIlRrnote(convertValue(str, 2798, 2818).trim());
								processCol = "出國報備/撤銷居留";
								iltb01Main.setIlMrkcs(convertValue(str, 2818, 2819).trim());
								processCol = "撤(註)銷居留原因";
								iltb01Main.setIlFbdrsn(convertValue(str, 2819, 2820).trim());
								processCol = "報備/撤(註)銷日期";
								if (!convertValue(str, 2820, 2839).trim().equals(""))
									iltb01Main.setIlMrkdt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2820, 2839).trim()))));
								processCol = "報備/撤(註)銷文號";
								iltb01Main.setIlMrkdc(convertValue(str, 2839, 2859).trim());
								processCol = "報案方式";
								iltb01Main.setIlSbmttp(convertValue(str, 2859, 2860).trim());
								processCol = "逃逸日期";
								if (!convertValue(str, 2860, 2879).trim().equals(""))
									iltb01Main.setIlMissdt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2860, 2879).trim()))));
								processCol = "報案日期";
								if (!convertValue(str, 2879, 2898).trim().equals(""))
									iltb01Main.setIlSbmtdt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2879, 2898).trim()))));
								processCol = "協尋處理情形";
								iltb01Main.setIlSrchst(convertValue(str, 2898, 2900).trim());
								processCol = "查獲單位";
								iltb01Main.setIlFnddid(convertValue(str, 2900, 2904).trim());
								processCol = "查獲日期";
								if (!convertValue(str, 2904, 2923).trim().equals(""))
									iltb01Main.setIlFnddt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2904, 2923).trim()))));
								processCol = "原居留證號";
								iltb01Main.setIlOldarc(convertValue(str, 2923, 2933).trim());
								processCol = "體檢結果";
								iltb01Main.setIlHcst(convertValue(str, 2933, 2934).trim());
								processCol = "體檢次數";
								if (!convertValue(str, 2934, 2935).trim().equals("")) {
									iltb01Main.setIlHcctr(
											Short.valueOf(Short.parseShort(convertValue(str, 2934, 2935).trim())));
								} else {
									iltb01Main.setIlHcctr(Short.valueOf((short) 0));
								}
								processCol = "最後更新日期時間";
								iltb01Main.setIlLmd(Timestamp.valueOf(
										this.sdf.format(this.sdf3.parse(convertValue(str, 2935, 2954).trim()))));
								processCol = "初次申請日期";
								try {
									iltb01Main.setIlFstapydt(Timestamp.valueOf(
											this.sdf.format(this.sdf3.parse(convertValue(str, 2954, 2973).trim()))));
								} catch (Exception e) {
									iltb01Main.setIlFstapydt(
											Timestamp.valueOf(this.sdf.format(this.sdf3.parse("Jan 01 1911 00:00AM"))));
								}
								processCol = "外籍配偶註記";
								iltb01Main.setIlForfere(convertValue(str, 2973, 2974).trim());
								String h_tTRNTP = convertValue(str, 2974, 2975).trim();
								processCol = "重入國許可證號-移民署";
								iltb01Main.setIlRepmdcNic(convertValue(str, 2975, 2985).trim());
								if (!convertValue(str, 0, 7).equals("")) {
									iltb01Main.setIlArcid(Integer.valueOf(Integer.parseInt(convertValue(str, 0, 7))));
								} else {
									int arcId = this.relationDAO.getSeq();
									iltb01Main.setIlArcid(Integer.valueOf(arcId));
								}
								checkIlSrchst(iltb01Main);
								processCol = "";
								if (h_tTRNTP.equals("A") || h_tTRNTP.equals("a")) {
									if (this.il07C01ADao.queryDataBynewId(newId) == true) {
										this.h_nImpErr1++;
										logger.info(convertValue(str, 0, 7).trim() + ":資料已存在 無法新增");
										this.logList3.add(padRight("(12碼ID已存在，無法新增)", 40));
										this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
												+ padRight(iltb01Main.getIlEnm(), 50) + " / " + iltb01Main.getIlBthdt()
												+ " / " + iltb01Main.getIlNtcd() + " / " + iltb01Main.getIlPspt() + "");
										this.logList2.add(fillSpace(Integer.toString(count), 5) + "1");
									} else {
										try {
											this.il07C01ADao.insertData(iltb01Main, newId);
											logger.info("新增成功");
											this.h_nImpOK++;
										} catch (Exception e) {
											e.printStackTrace();
											String errmsg = "";
											if (e.getMessage().contains("with unique index")) {
												errmsg = "(已有相同Key值資料，無法新增)";
											} else if (e.getMessage().contains("conversion of BIGDATETIME")) {
												errmsg = "(日期超出許可範圍，無法新增)";
											} else {
												errmsg = "(新增失敗)";
											}
											logger.info("新增失敗");
											this.h_nImpErr2++;
											this.logList3.add(padRight(errmsg, 40));
											this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
													+ padRight(iltb01Main.getIlEnm(), 50) + " / "
													+ iltb01Main.getIlBthdt() + " / " + iltb01Main.getIlNtcd() + " / "
													+ iltb01Main.getIlPspt() + "");
											this.logList2.add(fillSpace(Integer.toString(count), 5) + "2");
										}
									}
								} else if (h_tTRNTP.equals("U") || h_tTRNTP.equals("u")) {
									if (!this.il07C01ADao.queryData(iltb01Main.getIlArcid().toString())
											&& !this.il07C01ADao.queryDataBynewId(newId)) {
										logger.info("查無此資料 直接新增");
										try {
											this.il07C01ADao.insertData(iltb01Main, newId);
											logger.info("新增成功");
											this.h_nImpOK++;
										} catch (Exception e) {
											e.printStackTrace();
											logger.info(e.getMessage());
											String errmsg = "";
											if (e.getMessage().contains("with unique index")) {
												errmsg = "(已有相同Key值資料，無法新增)";
											} else if (e.getMessage().contains("conversion of BIGDATETIME")) {
												errmsg = "(日期超出許可範圍，無法新增)";
											} else {
												errmsg = "(新增失敗)";
											}
											logger.info("新增失敗");
											this.h_nImpErr2++;
											this.logList3.add(padRight(errmsg, 40));
											this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
													+ padRight(iltb01Main.getIlEnm(), 50) + " / "
													+ iltb01Main.getIlBthdt() + " / " + iltb01Main.getIlNtcd() + " / "
													+ iltb01Main.getIlPspt() + "");
											this.logList2.add(fillSpace(Integer.toString(count), 5) + "2");
										}
									} else {
										try {
											if (this.il07C01ADao.queryDataBynewId(newId) == true) {
												logger.info("查得新key");
												this.il07C01ADao.updateData(iltb01Main, newId, 1);
											} else {
												logger.info("使用舊key");
												this.il07C01ADao.updateData(iltb01Main, newId, 0);
											}
											logger.info("更新成功");
											this.h_nImpOK++;
										} catch (Exception e) {
											this.h_nImpErr4++;
											logger.info("更新失敗:" + e.getMessage());
											e.printStackTrace();
											this.logList3.add(padRight("(更新失敗)", 40));
											this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
													+ padRight(iltb01Main.getIlEnm(), 50) + " / "
													+ iltb01Main.getIlBthdt() + " / " + iltb01Main.getIlNtcd() + " / "
													+ iltb01Main.getIlPspt() + "");
											this.logList2.add(fillSpace(Integer.toString(count), 5) + "4");
										}
									}
								} else if (h_tTRNTP.equals("D") || h_tTRNTP.equals("d")) {
									if (this.il07C01ADao.queryData(iltb01Main.getIlArcid().toString()) == true) {
										try {
											this.il07C01ADao.delete(iltb01Main);
											this.h_nImpOK++;
										} catch (Exception e) {
											this.h_nImpErr6++;
											e.printStackTrace();
											logger.info("刪除失敗");
											this.logList3.add(padRight("(刪除失敗)", 40));
											this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
													+ padRight(iltb01Main.getIlEnm(), 50) + " / "
													+ iltb01Main.getIlBthdt() + " / " + iltb01Main.getIlNtcd() + " / "
													+ iltb01Main.getIlPspt() + "");
											this.logList2.add(fillSpace(Integer.toString(count), 5) + "6");
										}
									} else {
										this.h_nImpErr5++;
										logger.info("無相關資料可刪除");
										this.logList3.add(padRight("(無資料可刪除)", 40));
										this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
												+ padRight(iltb01Main.getIlEnm(), 50) + " / " + iltb01Main.getIlBthdt()
												+ " / " + iltb01Main.getIlNtcd() + " / " + iltb01Main.getIlPspt() + "");
										this.logList2.add(fillSpace(Integer.toString(count), 5) + "5");
									}
								}
							} catch (Exception e) {
								this.h_nImpErr7++;
								e.printStackTrace();
								logger.info(iltb01Main.getIlArcid() + "轉入資料異常。\n" + str2 + "\n" + e.getMessage());
								if (processCol.equals("")) {
									this.logList3.add(padRight("(其他錯誤)", 40));
									this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
											+ padRight(iltb01Main.getIlEnm(), 50) + " / " + iltb01Main.getIlBthdt()
											+ " / " + iltb01Main.getIlNtcd() + " / " + iltb01Main.getIlPspt() + "");
								} else {
									this.logList3.add(padRight("(讀取\"" + processCol + "\"時錯誤)", 40));
									this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
											+ padRight(iltb01Main.getIlEnm(), 50) + " / " + iltb01Main.getIlBthdt()
											+ " / " + iltb01Main.getIlNtcd() + " / " + iltb01Main.getIlPspt() + "");
								}
								this.logList2.add(fillSpace(Integer.toString(count), 5) + "7");
							}
						} else {
							this.h_nImpErr7++;
							logger.info(convertValue(str, 0, 7) + "長度不符!");
							this.logList3.add(padRight("(資料長度錯誤)", 40));
							this.logList.add(newId + " / " + iltb01Main.getIlArcno() + " / "
									+ padRight(iltb01Main.getIlEnm(), 50) + " / " + iltb01Main.getIlBthdt() + " / "
									+ iltb01Main.getIlNtcd() + " / " + iltb01Main.getIlPspt() + "");
							this.logList2.add(fillSpace(Integer.toString(count), 5) + "7");
						}
						this.h_nImpTot++;
					}
				}
				newIlSrchst();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			return 0;
		}
		return 1;
	}

	private void writeLog(int sucess) {
		String headerValue = "NO. ERRTP ARCID    ARCTP ARCCS ENM                                     CNM         sex BTHDT    NTCD PSPT       PSDT                MST EDU INDT                EXDT                ARCRSN ARCST JBCD JBPSN      OFCD OFNM                                         OFTEL           OFNMBF     JBPZONE JBADDR                                                         JBTEL           ARPZONE ARADDR                                                         ARTEL           AGNCO                                        AGNTEL          JBPMCD JBPMDC      JBPMDT              JBPMFM              JBPMTO              MICRO      APYDT               ARCRCP   ARCNO      ARCFM               ARCTO               PST  PHQ  PSTEXT REMRK                                    ARCISU FRSHP FNM                                          FPID       FNTCD FRCEXIT REAPYDT             RETP REPMDC REPMDT              RRNOTE               MRKCS FBDRSN MRKDT               MRKDC                SBMTTP MISSDT              SBMTDT              SRCHST FNDDID FNDDT              OLDARC      HCST HCCTR LMD                 FSTAPYDT            FORFERE TRNTP\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
		String computValue = "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\nERRTP1:  "
				+ this.h_nImpErr1 + "\n" + "ERRTP2:  " + this.h_nImpErr2 + "\n" + "ERRTP3:  " + this.h_nImpErr3 + "\n"
				+ "ERRTP4:  " + this.h_nImpErr4 + "\n" + "ERRTP5:  " + this.h_nImpErr5 + "\n" + "ERRTP6:  "
				+ this.h_nImpErr6 + "\n" + "ERRTP7:  " + this.h_nImpErr7 + "\n" + "ImpOK :  " + this.h_nImpOK + "\n"
				+ "ImpTot:  " + this.h_nImpTot + "\n";
		String tailValue = "------------------------------------------------------------------------------------------------\n|                            移民署居留異動資料匯入程式錯誤類別定義表                          |\n------------------------------------------------------------------------------------------------\nERRTP1: 新增居留主檔紀錄時，發現“居留資料主檔”已存在相同居留資料關聯ID之紀錄\nERRTP2: 新增“居留資料主檔”紀錄失敗\nERRTP3: 修改居留主檔紀錄時，發現“居留資料主檔”無任何相符的紀錄可修改\nERRTP4: 修改“居留資料主檔”紀錄失敗\nERRTP5: 刪除居留主檔紀錄時，發現“居留資料主檔”與“居留資料歷史檔”與“查察記事紀錄檔”與“移民署查察記事紀錄檔”無任何相符的紀錄可刪除\nERRTP6: 刪除“居留資料主檔”或“居留資料歷史檔”或“查察記事紀錄檔”或“移民署查察記事紀錄檔”紀錄失敗\nERRTP7: 其他";
		File pathFile = new File(this.contextPath);
		if (!pathFile.exists())
			pathFile.mkdirs();
		try {
			BufferedWriter bw = new BufferedWriter(
					new FileWriter(this.contextPath + "\\" + this.fileName.trim().replace(".txt", "") + "_"
							+ this.sdf4.format(this.processDate) + "_" + this.user.trim() + ".rbk"));
			logger.info(this.contextPath + "\\" + this.fileName + "_" + this.sdf4.format(this.processDate) + "_"
					+ this.user.trim() + ".rbk");
			if (bw != null) {
				bw.write(headerValue);
				for (int i = 0; i < this.logList.size(); i++) {
					if (((String) this.logList.get(i)).length() != 2985
							&& ((String) this.logList.get(i)).length() != 2997) {
						bw.write(fillSpace(
								convertValue(this.logList2.get(i), 0, ((String) this.logList2.get(i)).length() - 1)
										.trim(),
								4));
						try {
							bw.write(fillSpace(
									convertValue(this.logList2.get(i), ((String) this.logList2.get(i)).length() - 1,
											((String) this.logList2.get(i)).length()).trim(),
									4));
						} catch (Exception ex) {
							logger.info(ex.toString());
						}
						bw.write(this.logList.get(i));
					} else {
						bw.write(fillSpace(
								convertValue(this.logList2.get(i), 0, ((String) this.logList2.get(i)).length() - 1)
										.trim(),
								4));
						bw.write(fillSpace(
								convertValue(this.logList2.get(i), ((String) this.logList2.get(i)).length() - 1,
										((String) this.logList2.get(i)).length()).trim(),
								4));
						bw.write(fillSpace(convertValue(this.logList.get(i), 0, 7), 10));
						bw.write(fillSpace(convertValue(this.logList.get(i), 7, 8).trim(), 5));
						bw.write(fillSpace(convertValue(this.logList.get(i), 8, 9).trim(), 3));
						bw.write(fillSpace(convertValue(this.logList.get(i), 9, 59).trim(), 39));
						bw.write(fillSpace(convertValue(this.logList.get(i), 59, 71).trim(), 9));
						bw.write(fillSpace(convertValue(this.logList.get(i), 71, 72).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 72, 80).trim(), 8));
						bw.write(fillSpace(convertValue(this.logList.get(i), 80, 83).trim(), 4));
						bw.write(fillSpace(convertValue(this.logList.get(i), 83, 98).trim(), 10));
						bw.write(fillSpace(convertValue(this.logList.get(i), 98, 117).trim(), 20));
						bw.write(fillSpace(convertValue(this.logList.get(i), 117, 118).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 118, 120).trim(), 3));
						bw.write(fillSpace(convertValue(this.logList.get(i), 120, 139).trim(), 20));
						if (!convertValue(this.logList.get(i), 139, 158).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 139, 158).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 158, 159).trim(), 6));
						bw.write(fillSpace(convertValue(this.logList.get(i), 159, 160).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 160, 162).trim(), 3));
						bw.write(fillSpace(convertValue(this.logList.get(i), 162, 172).trim(), 11));
						bw.write(fillSpace(convertValue(this.logList.get(i), 172, 176).trim(), 5));
						bw.write(fillSpace(convertValue(this.logList.get(i), 176, 224).trim(), 40));
						bw.write(fillSpace(convertValue(this.logList.get(i), 224, 239).trim(), 16));
						bw.write(fillSpace(convertValue(this.logList.get(i), 239, 249).trim(), 11));
						bw.write(fillSpace(convertValue(this.logList.get(i), 249, 252).trim(), 4));
						bw.write(fillSpace(convertValue(this.logList.get(i), 252, 344).trim(), 93));
						bw.write(fillSpace(convertValue(this.logList.get(i), 344, 359).trim(), 16));
						bw.write(fillSpace(convertValue(this.logList.get(i), 359, 362).trim(), 4));
						bw.write(fillSpace(convertValue(this.logList.get(i), 362, 454).trim(), 93));
						bw.write(fillSpace(convertValue(this.logList.get(i), 454, 469).trim(), 15));
						bw.write(fillSpace(convertValue(this.logList.get(i), 469, 513).trim(), 45));
						bw.write(fillSpace(convertValue(this.logList.get(i), 513, 528).trim(), 16));
						bw.write(fillSpace(convertValue(this.logList.get(i), 528, 529).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 529, 539).trim(), 11));
						if (!convertValue(this.logList.get(i), 539, 558).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 539, 558).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						if (!convertValue(this.logList.get(i), 558, 577).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 558, 577).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						if (!convertValue(this.logList.get(i), 577, 596).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 577, 596).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 596, 606).trim(), 11));
						bw.write(fillSpace(convertValue(this.logList.get(i), 606, 625).trim(), 20));
						bw.write(fillSpace(convertValue(this.logList.get(i), 625, 633).trim(), 9));
						bw.write(fillSpace(convertValue(this.logList.get(i), 633, 643).trim(), 11));
						bw.write(fillSpace(convertValue(this.logList.get(i), 643, 662).trim(), 20));
						if (!convertValue(this.logList.get(i), 662, 681).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 662, 681).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 681, 685).trim(), 5));
						bw.write(fillSpace(convertValue(this.logList.get(i), 685, 689).trim(), 5));
						bw.write(fillSpace(convertValue(this.logList.get(i), 689, 691).trim(), 3));
						bw.write(fillSpace(convertValue(this.logList.get(i), 691, 2691).trim(), 2001));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2691, 2692).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2692, 2694).trim(), 3));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2694, 2738).trim(), 45));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2738, 2748).trim(), 11));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2748, 2751).trim(), 4));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2751, 2753).trim(), 3));
						if (!convertValue(this.logList.get(i), 2753, 2772).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2753, 2772).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 2772, 2773).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2773, 2779).trim(), 7));
						if (!convertValue(this.logList.get(i), 2779, 2798).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2779, 2798).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 2798, 2818).trim(), 21));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2818, 2819).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2819, 2829).trim(), 2));
						if (!convertValue(this.logList.get(i), 2820, 2839).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2820, 2839).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 2839, 2859).trim(), 21));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2859, 2860).trim(), 2));
						if (!convertValue(this.logList.get(i), 2860, 2879).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2860, 2879).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						if (!convertValue(this.logList.get(i), 2879, 2898).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2879, 2898).trim(), 20));
						} else {
							bw.write(fillSpace("null", 20));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 2898, 2900).trim(), 3));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2900, 2904).trim(), 5));
						if (!convertValue(this.logList.get(i), 2904, 2923).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2904, 2923).trim(), 20));
						} else {
							bw.write(fillSpace("null", 21));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 2923, 2933).trim(), 11));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2933, 2934).trim(), 2));
						if (!convertValue(this.logList.get(i), 2934, 2935).trim().equals("")) {
							bw.write(fillSpace(convertValue(this.logList.get(i), 2934, 2935).trim(), 2));
						} else {
							bw.write(fillSpace("null", 2));
						}
						bw.write(fillSpace(convertValue(this.logList.get(i), 2935, 2954).trim(), 20));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2954, 2973).trim(), 20));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2973, 2974).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2974, 2975).trim(), 2));
						bw.write(fillSpace(convertValue(this.logList.get(i), 2975, 2985).trim(), 11));
					}
					bw.newLine();
				}
				bw.write(computValue);
				bw.write(tailValue);
				if (sucess == 0)
					bw.write("\n 檔案不存在!");
				logger.info("BW CLOSE");
			}
			bw.close();
			File logFile = new File(this.contextPath + "\\" + this.fileName.trim().replace(".txt", "") + "_"
					+ this.sdf4.format(this.processDate) + "_" + this.user.trim() + ".txt");
			BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile), "big5"));
			logger.info(this.contextPath + "\\" + this.fileName + "_" + this.sdf4.format(this.processDate) + "_"
					+ this.user.trim() + ".txt");
			if (bw2 != null) {
				logger.info("寫BW2");
				bw2.write(
						"                                         12ARCID      / 居留證號   / 英文姓名                                            / 出生日期 / 國籍/ 護照號碼\n");
				for (int i = 0; i < this.logList.size(); i++) {
					bw2.write((String) this.logList3.get(i)
							+ new String(((String) this.logList.get(i)).getBytes("ISO-8859-1"), "Big5"));
					bw2.newLine();
				}
				if (sucess == 0)
					bw2.write("\n 檔案不存在!");
			}
			bw2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String fillSpace(String value, int length) {
		for (int i = value.length(); i <= length; i++)
			value = value + " ";
		return value;
	}

	public String padRight(String value, int length) {
		for (int i = (value.getBytes()).length; i <= length; i++)
			value = value + " ";
		return value;
	}

	private void checkIlSrchst(Iltb01Main iltb01Main) {
		if (iltb01Main != null && iltb01Main.getIlSrchst() != null && iltb01Main.getIlSrchst() != "") {
			if (!IlSrchstList.contains(iltb01Main.getIlSrchst())) {
				logger.warn("特殊身份代碼" + iltb01Main.getIlSrchst() + "未定義");
				newIlSrchstList.add(iltb01Main.getIlSrchst());
			}
		}
	}

	private void newIlSrchst() {
		if (newIlSrchstList.size() != 0) {
			
		}
	}

	private String convertValue(String data, int start, int end) {
		try {
			String convertValue = new String(data.substring(start, end).getBytes("ISO-8859-1"), "Big5");
			return convertValue.trim();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\tranceData\IL07C01A.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */