package tw.gov.npa.il.schedule;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.HibernateSessionFactory;
import tw.gov.npa.il.myDao.MyIlScheduleDAO;
import tw.gov.npa.il.report.IL04A01Report;
import tw.gov.npa.il.tranceData.IL05B03A;
import tw.gov.npa.il.tranceData.IL07C01A;
import tw.gov.npa.il.tranceData.IL07C01B;
import tw.gov.npa.il.tranceData.IL08A01;
import tw.gov.npa.il.util.FtpGetFile;
import tw.gov.npa.il.util.WSUtil;

public class ILReportSchedule {
	ResourceBundle rb = ResourceBundle.getBundle("config");

	private String savePath = this.rb.getString("FileRoot").toString();

	private String ftpIp = this.rb.getString("ftpIp").toString();

	private String ftpUser = this.rb.getString("ftpUser").toString();

	private String ftpPassword = this.rb.getString("ftpPassword").toString();

	private String ftpPath = this.rb.getString("ftpPath").toString();

	private static final Logger logger = Logger.getLogger(ILReportSchedule.class);

	private IL05B03A il05B03A;

	public IL07C01A iL07C01A;

	public IL07C01B iL07C01B;

	public IL08A01 iL08A01;
	
	private WSUtil wsUtil;

	public MyIlScheduleDAO myIlScheduleDAO;

	public WSUtil getWsUtil() {
		return wsUtil;
	}

	public void setWsUtil(WSUtil wsUtil) {
		this.wsUtil = wsUtil;
	}

	public IL05B03A getIl05B03A() {
		return this.il05B03A;
	}

	public void setIl05B03A(IL05B03A il05b03a) {
		this.il05B03A = il05b03a;
	}

	public IL07C01A getiL07C01A() {
		return this.iL07C01A;
	}

	public void setiL07C01A(IL07C01A iL07C01A) {
		this.iL07C01A = iL07C01A;
	}

	public IL07C01B getiL07C01B() {
		return this.iL07C01B;
	}

	public void setiL07C01B(IL07C01B iL07C01B) {
		this.iL07C01B = iL07C01B;
	}

	public IL08A01 getiL08A01() {
		return this.iL08A01;
	}

	public void setiL08A01(IL08A01 iL08A01) {
		this.iL08A01 = iL08A01;
	}

	public MyIlScheduleDAO getMyIlScheduleDAO() {
		return this.myIlScheduleDAO;
	}

	public void setMyIlScheduleDAO(MyIlScheduleDAO myIlScheduleDAO) {
		this.myIlScheduleDAO = myIlScheduleDAO;
	}

	public void runIL03Report() {
		logger.info("轄區狀況統計資料排程開始:" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			(new ReportScheduler()).scheduleIL03B01();
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 轄區狀況統計資料排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("轄區狀況統計資料排程失敗：" + e.getMessage());
		} finally {
			try {
				HibernateSessionFactory.getSession().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void runMonthReport() {
		logger.info("月統計報表排程開始：" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			new IL04A01Report();
			IL04A01Report.main(null);
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 月統計報表排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("月統計報表排程失敗：" + e.getMessage());
		} finally {
			try {
				HibernateSessionFactory.getSession().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void runReportFixColumn() {
		logger.info("自由檢索報表排程開始：" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			(new ReportScheduler()).scheduleIL04B01(wsUtil);
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 自由檢索報表排程結束 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("自由檢索報表排程失敗：" + e.getMessage());
			logger.error(e.getMessage(),e);
		} finally {
			try {
				HibernateSessionFactory.getSession().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void runIL05A() {
		logger.info("轉出入排程開始：" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			int control = 1;
			getFtpFile();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(5, -1);
			String autoDate = sdf2.format(cal.getTime());
			String fileName = "IL71" + dateConvert(autoDate, "year") + dateConvert(autoDate.substring(4, 6), "month")
					+ dateConvert(autoDate.substring(6, 8), "day") + ".txt";
			this.iL07C01A.il07C01aMain(0, fileName);
			fileName = "IL72" + dateConvert(autoDate, "year") + dateConvert(autoDate.substring(4, 6), "month")
					+ dateConvert(autoDate.substring(6, 8), "day") + ".txt";
			this.iL07C01B.il07C01bMain(0, fileName);
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 轉出入排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("轉出入排程失敗：" + e.getMessage());
		} finally {
		}
	}

	public void runIL05A_IL07C01A() {
		logger.info("轉出入排程開始1：" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			String[] datesToParse = getFtpFile_IL07C01A();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(5, -11);
			for (int i = 0; i < 10; i++) {
				if (!datesToParse[i].equals("")) {
					logger.info("i=" + i + " " + datesToParse[i]);
				} else {
					logger.info("i=" + i + " 無檔案");
				}
			}
			this.iL07C01A.il07C01aMain(0, "");
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 轉出入排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("轉出入排程失敗：" + e.getMessage());
		} finally {
		}
	}

	public void runIL05A_IL07C01B() {
		logger.info("轉出入排程開始：" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			int control = 1;
			String[] datesToParse = getFtpFile_IL07C01B();
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.add(5, -11);
			for (int i = 0; i < 10; i++) {
				if (!datesToParse[i].equals("")) {
					logger.info("i=" + i + " " + datesToParse[i]);
				} else {
					logger.info("i=" + i + " 無檔案");
				}
			}
			this.iL07C01B.il07C01bMain(0, "");
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 轉出入排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("轉出入排程失敗：" + e.getMessage());
		} finally {
		}
	}

	public void runIL05B() {
		logger.info("轉出入排程開始：" + new Date());
		int control = 1;
		try {
			long startTime = System.currentTimeMillis();
			this.il05B03A.IL05B03AMain();
			this.iL07C01A.il07C01aMain(1, null);
			this.iL07C01B.il07C01bMain(1, null);
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 轉出入排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("轉出入排程失敗：" + e.getMessage());
		} finally {
		}
	}

	public void runIL08() {
		logger.info("錄檔排程開始:總TimerTask Start... TimerTask任務時間：" + new Date());
		try {
			long startTime = System.currentTimeMillis();
			this.iL08A01.il08a01Main("", "", 0);
			DecimalFormat myformat = new DecimalFormat("0.00");
			long endTime = System.currentTimeMillis();
			long costLong = (endTime - startTime) / 1000L;
			String cost = myformat.format(costLong);
			logger.info(new Date() + ": 錄檔排程結束, 執行時間=" + cost + "秒");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("錄檔排程失敗：" + e.getMessage());
		} finally {
		}
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

	private String dateConvert_reverse(String converted, String type) {
		if (type.equals("year"))
			return "20" + converted;
		if (type.equals("month")) {
			if (converted.equals("A"))
				return "10";
			if (converted.equals("B"))
				return "11";
			if (converted.equals("C"))
				return "12";
			return converted;
		}
		if (type.equals("day")) {
			if (converted.equals("A"))
				return "10";
			if (converted.equals("B"))
				return "11";
			if (converted.equals("C"))
				return "12";
			if (converted.equals("D"))
				return "13";
			if (converted.equals("E"))
				return "14";
			if (converted.equals("F"))
				return "15";
			if (converted.equals("G"))
				return "16";
			if (converted.equals("H"))
				return "17";
			if (converted.equals("I"))
				return "18";
			if (converted.equals("J"))
				return "19";
			if (converted.equals("K"))
				return "20";
			if (converted.equals("L"))
				return "21";
			if (converted.equals("M"))
				return "22";
			if (converted.equals("N"))
				return "23";
			if (converted.equals("O"))
				return "24";
			if (converted.equals("P"))
				return "25";
			if (converted.equals("Q"))
				return "26";
			if (converted.equals("R"))
				return "27";
			if (converted.equals("S"))
				return "28";
			if (converted.equals("T"))
				return "29";
			if (converted.equals("U"))
				return "30";
			if (converted.equals("V"))
				return "31";
			return converted;
		}
		return null;
	}

	public void getFtpFile() {
		FtpGetFile fgf = new FtpGetFile();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(5, -1);
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
		String autoDate = sdf2.format(cal.getTime());
		String fileName = "IL71" + dateConvert(autoDate, "year") + dateConvert(autoDate.substring(4, 6), "month")
				+ dateConvert(autoDate.substring(6, 8), "day") + ".txt";
		System.out.println("主檔檔名:" + fileName);
		fgf.getFile(this.ftpIp, this.ftpUser, this.ftpPassword, fileName, this.ftpPath, this.savePath);
		fileName = "IL72" + dateConvert(autoDate, "year") + dateConvert(autoDate.substring(4, 6), "month")
				+ dateConvert(autoDate.substring(6, 8), "day") + ".txt";
		System.out.println("查察紀事檔名:" + fileName);
		fgf = new FtpGetFile();
		fgf.getFile(this.ftpIp, this.ftpUser, this.ftpPassword, fileName, this.ftpPath, this.savePath);
	}

	public String[] getFtpFile_IL07C01A() {
		FtpGetFile fgf = new FtpGetFile();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(5, -11);
		String[] val = new String[10];
		for (int i = 0; i < 10; i++) {
			val[i] = "";
			cal.add(5, 1);
			try {
				JdbcDataSourceImpl datasrc = new JdbcDataSourceImpl();
				Connection conn = datasrc.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select top 1 * from ILTB_18_DATA_PROCESS_RESULT where IL_IMPFL like 'IL5T%' order by IL_IMPFL desc");
				if (rs.next()) {
					String lastFile = rs.getString("IL_IMPFL");
					String lastFileYear = "20" + lastFile.substring(4, 6);
					String lastFileMonth = dateConvert_reverse(lastFile.substring(6, 7), "month");
					String lastFileDay = dateConvert_reverse(lastFile.substring(7, 8), "day");
					logger.info("最近檔案日期:" + lastFileYear + "/" + lastFileMonth + "/" + lastFileDay);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date lastDate = sdf.parse(lastFileYear + "/" + lastFileMonth + "/" + lastFileDay);
					Calendar lastCal = Calendar.getInstance();
					lastCal.setTime(lastDate);
					lastCal.add(5, 1);
					if (!sdf.format(cal.getTime()).equals(sdf.format(lastCal.getTime()))) {
						logger.info("檔案日期" + sdf.format(cal.getTime()) + "不需檢查");
						conn.close();
						continue;
					}
				}
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			String autoDate = sdf2.format(cal.getTime());
			String fileName = "IL5T" + dateConvert(autoDate, "year") + dateConvert(autoDate.substring(4, 6), "month")
					+ dateConvert(autoDate.substring(6, 8), "day") + "_2.txt";
			logger.info("主檔檔名:" + fileName);
			if (fgf.getFile(this.ftpIp, this.ftpUser, this.ftpPassword, fileName, this.ftpPath, this.savePath))
				try {
					this.iL07C01A.il07C01ADao.insertLog("System", fileName);
					val[i] = fileName;
				} catch (Exception ex) {
					logger.info(ex.getMessage());
				}
			continue;
		}
		return val;
	}

	public String[] getFtpFile_IL07C01B() {
		FtpGetFile fgf = new FtpGetFile();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(5, -11);
		String[] val = new String[10];
		for (int i = 0; i < 10; i++) {
			val[i] = "";
			cal.add(5, 1);
			try {
				JdbcDataSourceImpl datasrc = new JdbcDataSourceImpl();
				Connection conn = datasrc.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select top 1 * from ILTB_18_DATA_PROCESS_RESULT where IL_IMPFL like 'IL5U%' order by IL_IMPFL desc");
				if (rs.next()) {
					String lastFile = rs.getString("IL_IMPFL");
					String lastFileYear = "20" + lastFile.substring(4, 6);
					String lastFileMonth = dateConvert_reverse(lastFile.substring(6, 7), "month");
					String lastFileDay = dateConvert_reverse(lastFile.substring(7, 8), "day");
					logger.info("最近檔案日期:" + lastFileYear + "/" + lastFileMonth + "/" + lastFileDay);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date lastDate = sdf.parse(lastFileYear + "/" + lastFileMonth + "/" + lastFileDay);
					Calendar lastCal = Calendar.getInstance();
					lastCal.setTime(lastDate);
					lastCal.add(5, 1);
					if (!sdf.format(cal.getTime()).equals(sdf.format(lastCal.getTime()))) {
						logger.info("檔案日期" + sdf.format(cal.getTime()) + "不需檢查");
						conn.close();
						continue;
					}
				}
				conn.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd");
			String autoDate = sdf2.format(cal.getTime());
			String fileName = "IL5U" + dateConvert(autoDate, "year") + dateConvert(autoDate.substring(4, 6), "month")
					+ dateConvert(autoDate.substring(6, 8), "day") + "_2.txt";
			logger.info("查察紀事檔名:" + fileName);
			fgf = new FtpGetFile();
			if (fgf.getFile(this.ftpIp, this.ftpUser, this.ftpPassword, fileName, this.ftpPath, this.savePath))
				try {
					this.iL07C01B.il07C01BDao.insertLog("System", fileName);
					val[i] = fileName;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			continue;
		}
		return val;
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\schedule\
 * ILReportSchedule.class Java compiler version: 6 (50.0) JD-Core Version: 1.1.3
 */