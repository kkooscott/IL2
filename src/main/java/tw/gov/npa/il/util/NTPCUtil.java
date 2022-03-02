package tw.gov.npa.il.util;

import com.aspose.cells.Color;
import com.aspose.cells.MsoFillFormat;
import com.aspose.cells.MsoLineFormat;
import com.aspose.cells.MsoPresetTextEffect;
import com.aspose.cells.WorkbookDesigner;
import com.aspose.cells.Worksheet;
import com.csvreader.CsvReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import tw.gov.npa.il.action.bean.NpaZipCodeBean;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;

public class NTPCUtil {
	private static final Logger logger = Logger.getLogger(NTPCUtil.class);

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static SimpleDateFormat dateSlashFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");

	public static SimpleDateFormat dateSecondSlashFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static final Pattern dateTimePattern = Pattern.compile(
			"^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");

	public String appendDateString(String s) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		String sd = s + "_" + dateFormat.format(new Date());
		return sd;
	}

	public String appendYearMonthString(String s) {
		GetDateUtil getDateUtil = new GetDateUtil();
		int[] date = getDateUtil.getNowDate();
		String sd = s + "_" + date[0] + date[1];
		return sd;
	}

	public static String checkDate(String fromDate, String fromTime, String toDate, String toTime) {
		if (fromTime == null || fromTime.isEmpty())
			fromTime = "00:00";
		if (toTime == null || toTime.isEmpty())
			toTime = "23:59";
		String ft = fromDate + " " + fromTime + ":00";
		String tt = toDate + " " + toTime + ":59";
		if (!isValidDate(ft))
			return "起始日期格式不正確";
		if (!isValidDate(tt))
			return "迄止日期格式不正確";
		if (tt.compareTo(ft) <= 0)
			return "起始日期必須小於迄止日期";
		return null;
	}

	public static boolean isValidDate(String date) {
		return dateTimePattern.matcher(date).matches();
	}

	public static BufferedInputStream createExcel(String contextPath, String fileName, String jasperFileName,
			HashMap<String, Object> param, JRBeanCollectionDataSource jRMainTotalDS) throws JRException {
		JasperPrint jasperPrint;
		NTPCUtil ntpcUtil = new NTPCUtil();
		String baseDir = "report";
		String jasperFile = jasperFileName + ".jasper";
		String auditJasperFileName = "jrxml" + File.separator + jasperFile;
		String auditJrprintFileName = "jrxml" + File.separator + jasperFile;
		String auditJrprintFile = contextPath + File.separator + auditJrprintFileName;
		String auditJasperFile = contextPath + File.separator + auditJasperFileName;
		String excelFile = contextPath + File.separator + baseDir + File.separator
				+ ntpcUtil.appendYearMonthString(fileName) + ".xls";
		logger.debug("excelFile location:" + excelFile);
		logger.debug("jasperFile location:" + auditJasperFile);
		logger.debug("jrprintFile location:" + auditJrprintFile);
		File folder = new File(contextPath + File.separator + baseDir);
		if (!folder.exists())
			folder.mkdirs();
		if (jRMainTotalDS != null) {
			jasperPrint = JasperFillManager.fillReport(auditJasperFile, param, (JRDataSource) jRMainTotalDS);
		} else {
			jasperPrint = JasperFillManager.fillReport(auditJasperFile, param);
		}
		JExcelApiExporter exporterXLS = new JExcelApiExporter();
		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporterXLS.setParameter((JRExporterParameter) JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporterXLS.setParameter((JRExporterParameter) JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, excelFile);
		exporterXLS.exportReport();
		try {
//			String watermark = LOGDIDNM.trim() + "-" + LOGCN.trim() + "-" + time;
//			com.aspose.cells.License license = new com.aspose.cells.License();
//			license.setLicense("Aspose.Total.Java.lic");
//			com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(excelFile);
//			Worksheet st = wb.getWorksheets().get(0);
//			int maxRow = st.getCells().getMaxDataRow();
//			int maxCol = st.getCells().getMaxDataColumn();
//			//浮水印
//			for (int i = 0; i < maxCol; i++) {
//				for (int k = 0; k < maxRow; k++) {
//					InsertWaterMarkToXLS(wb, st, watermark, 0, 0, 0, 0, 30, 600);
//			k++;k++;k++;k++;k++;
//				}
//				i++;i++;
//			}
//			WorkbookDesigner designer = new WorkbookDesigner();
//			designer.setWorkbook(wb);
//			wb.save(excelFile, wb.getFileFormat());
			FileInputStream fis = new FileInputStream(excelFile);
			BufferedInputStream excelStream = new BufferedInputStream(fis);
			return excelStream;
		} catch (IOException e) {
			logger.error(e, e);
			return null;
		}
	}

	public static BufferedInputStream createExcel(String contextPath, String fileName, HashMap<String, Object> param,
			JRBeanCollectionDataSource jRMainTotalDS) throws JRException {
		return createExcel(contextPath, fileName, fileName, param, jRMainTotalDS);
	}

	public static BufferedInputStream createExcelOtherFileName(String contextPath, String fileName,
			String jasperFileName, HashMap<String, Object> param, JRBeanCollectionDataSource jRMainTotalDS,
			String exportFile, String LOGCN, String LOGDIDNM) throws JRException {
		JasperPrint jasperPrint;
		NTPCUtil ntpcUtil = new NTPCUtil();
		String baseDir = "report";
		String jasperFile = jasperFileName + ".jasper";
		String auditJasperFileName = "jrxml" + File.separator + jasperFile;
		String auditJrprintFileName = "jrxml" + File.separator + jasperFile;
		String auditJrprintFile = contextPath + File.separator + auditJrprintFileName;
		String auditJasperFile = contextPath + File.separator + auditJasperFileName;
		String excelFile = contextPath + File.separator + baseDir + File.separator + exportFile + ".xls";
		String time = (String)param.get("PRINTTIME");
		logger.debug("excelFile location:" + excelFile);
		logger.debug("jasperFile location:" + auditJasperFile);
		logger.debug("jrprintFile location:" + auditJrprintFile);
		File folder = new File(contextPath + File.separator + baseDir);
		if (!folder.exists())
			folder.mkdirs();
		if (jRMainTotalDS != null) {
			jasperPrint = JasperFillManager.fillReport(auditJasperFile, param, (JRDataSource) jRMainTotalDS);
		} else {
			jasperPrint = JasperFillManager.fillReport(auditJasperFile, param);
		}
		JExcelApiExporter exporterXLS = new JExcelApiExporter();
		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporterXLS.setParameter((JRExporterParameter) JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporterXLS.setParameter((JRExporterParameter) JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, excelFile);
		exporterXLS.exportReport();
		try {
			
			String watermark = LOGDIDNM.trim() + "-" + LOGCN.trim() + "-" + time;
			com.aspose.cells.License license = new com.aspose.cells.License();
			license.setLicense("Aspose.Total.Java.lic");
			com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook(excelFile);
			Worksheet st = wb.getWorksheets().get(0);
			int maxRow = st.getCells().getMaxDataRow();
			int maxCol = st.getCells().getMaxDataColumn();
			//浮水印
//			for (int i = 0; i < maxCol; i++) {
				for (int k = 0; k < maxRow; k++) {
					InsertWaterMarkToXLS(wb, st, watermark, k, k, 0, 0, 30, 600);
			k++;k++;k++;k++;k++;
				}
//				i++;i++;
//			}
			WorkbookDesigner designer = new WorkbookDesigner();
			designer.setWorkbook(wb);
			wb.save(excelFile, wb.getFileFormat());
			FileInputStream fis = new FileInputStream(excelFile);
			BufferedInputStream excelStream = new BufferedInputStream(fis);
			return excelStream;
		} catch (Exception e) {
			logger.error(e, e);
			return null;
		}
	}
	
	public static BufferedInputStream createExcelBy03Use(String contextPath, String fileName,
			HashMap<String, Object> param, JRBeanCollectionDataSource jRMainTotalDS, String LOGUID, String recordId)
			throws JRException {
		JasperPrint jasperPrint;
		NTPCUtil ntpcUtil = new NTPCUtil();
		String baseDir = "report/IL03";
		String jasperFile = fileName + ".jasper";
		String auditJasperFileName = "jrxml" + File.separator + jasperFile;
		String auditJrprintFileName = "jrxml" + File.separator + jasperFile;
		String auditJrprintFile = contextPath + File.separator + auditJrprintFileName;
		String auditJasperFile = contextPath + File.separator + auditJasperFileName;
		String excelFile = contextPath + File.separator + baseDir + File.separator + recordId + LOGUID + ".xls";
		logger.debug("excelFile location:" + excelFile);
		logger.debug("jasperFile location:" + auditJasperFile);
		logger.debug("jrprintFile location:" + auditJrprintFile);
		File folder = new File(contextPath + File.separator + baseDir);
		if (!folder.exists())
			folder.mkdirs();
		if (jRMainTotalDS != null) {
			jasperPrint = JasperFillManager.fillReport(auditJasperFile, param, (JRDataSource) jRMainTotalDS);
		} else {
			jasperPrint = JasperFillManager.fillReport(auditJasperFile, param);
		}
		JExcelApiExporter exporterXLS = new JExcelApiExporter();
		exporterXLS.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
		exporterXLS.setParameter((JRExporterParameter) JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exporterXLS.setParameter((JRExporterParameter) JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exporterXLS.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, excelFile);
		exporterXLS.exportReport();
		try {
			FileInputStream fis = new FileInputStream(excelFile);
			BufferedInputStream excelStream = new BufferedInputStream(fis);
			return excelStream;
		} catch (IOException e) {
			logger.error(e, e);
			return null;
		}
	}

	public String getE0UnitFlag(String rstUsrInfo) {
		String e0UnitFlag = null;
		try {
			MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
			E0dtNpaunit e0dtNpaunit = myE0dtNpaunitDAO.findById(rstUsrInfo);
			e0UnitFlag = e0dtNpaunit.getE0UnitFlag();
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
		}
		return e0UnitFlag;
	}

	public List<NpaZipCodeBean> getNpaZipCodeBeanList(String contextPath) {
		List<NpaZipCodeBean> npaZipCodeBeanList = new ArrayList<NpaZipCodeBean>();
		try {
			File csv = new File(contextPath + "il" + File.separator + "util" + File.separator + "NPA_ZipCode.csv");
			CsvReader products = new CsvReader(new InputStreamReader(new FileInputStream(csv), "UTF-8"));
			products.readHeaders();
			while (products.readRecord()) {
				String KT_PZONE = products.get("KT_PZONE");
				String KT_CNTY = products.get("KT_CNTY");
				String KT_TOWN = products.get("KT_TOWN");
				String KT_DID = products.get("KT_DID");
				NpaZipCodeBean npaZipCodeBean = new NpaZipCodeBean();
				npaZipCodeBean.setKT_CNTY(KT_CNTY);
				npaZipCodeBean.setKT_DID(KT_DID);
				npaZipCodeBean.setKT_PZONE(KT_PZONE);
				npaZipCodeBean.setKT_TOWN(KT_TOWN);
				npaZipCodeBeanList.add(npaZipCodeBean);
			}
			products.close();
		} catch (FileNotFoundException e) {
			logger.error(e, e);
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e, e);
			e.printStackTrace();
		} catch (Exception e) {
			logger.error(e, e);
			e.printStackTrace();
		}
		return npaZipCodeBeanList;
	}

	public String[] getOlderE0UnitCdByNewE0UnitCd(String e0UnitCd) {
		if (e0UnitCd.startsWith("AE"))
			e0UnitCd = "BE" + e0UnitCd.substring(2);
		String[] names = null;
		MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
		E0dtNpaunit e0dtNpaunit = myE0dtNpaunitDAO.findById(e0UnitCd);
		if (e0dtNpaunit != null) {
			String e0OldUnit = e0dtNpaunit.getE0OldUnit();
			names = e0OldUnit.split("＊");
		}
		return names;
	}

	public String[] getSplitZipCode(String ilZipCode) {
		String[] ilZipCodeArr = ilZipCode.split(",");
		return ilZipCodeArr;
	}
	
	public static void InsertWaterMarkToXLS(com.aspose.cells.Workbook workbook, Worksheet sheet, String watermarkText,
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
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\i\\util\NTPCUtil.class
 * Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */