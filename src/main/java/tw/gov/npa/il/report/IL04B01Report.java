package tw.gov.npa.il.report;

import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.report.data.IL04B01ReportData;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL04B01Report {
	private static final Logger logger = Logger.getLogger(IL04B01Report.class);

	//  ResourceBundle rb = ResourceBundle.getBundle("config");

	//  private String contextPath = this.rb.getString("FileRoot").toString();
	private String contextPath = "D:\\IL2\\file";

	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String IL04B01_01(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		logger.info("IL04B01 按國籍及職業分 Execute");
		String fileName = "IL04B01_01";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04B01 按國籍及職業分 Execute");
		String unitName = "按國籍及職業分";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B01P(whereCondition);
		logger.info("IL04B01 SSASASASAS");
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	public String IL04B01_02(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		String fileName = "IL04B01_02";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04B01 按國籍及區域分 Execute");
		String unitName = "按國籍及區域分";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B02P(whereCondition);
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	public String IL04B01_03(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		String fileName = "IL04B01_03";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04B01 按職業及區域分 Execute");
		String unitName = "按職業及區域分";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B03P(whereCondition);
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	public String IL04B01_04(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		String fileName = "IL04B01_04";
		String jasperFileName = "IL04_r1c4";
		logger.debug("IL04B01 按居留目的及職業分 Execute");
		String unitName = "按居留目的及職業分";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B04P(whereCondition);
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	public String IL04B01_05(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		String fileName = "IL04B01_05";
		String jasperFileName = "IL04_r1c4";
		logger.debug("IL04B01 按居留目的及區域分 Execute");
		String unitName = "按居留目的及區域分";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B05P(whereCondition);
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	public String IL04B01_06(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		String fileName = "IL04B01_06";
		String jasperFileName = "IL04_r3c2";
		logger.debug("IL04B01 按國籍及居留目的分 Execute");
		String unitName = "按國籍及居留目的分";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B06P(whereCondition);
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	public String IL04B01_07(String whereCondition, String exportfileName, String LOGCN, String LOGDIDNM) throws JRException {
		String fileName = "IL04B01_07";
		String jasperFileName = "IL04_r4c2";
		logger.debug("IL04B01 臺閩地區外僑持續居留年限統計報表及名冊 Execute");
		String unitName = "臺閩地區外僑持續居留年限統計報表及名冊";
		JRBeanCollectionDataSource jRMainTotalDS = IL04B01ReportData.buildDataSourceIL08B07P(whereCondition);
		return IL04B01CommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
	}

	private String IL04B01CommonPart(String contextPath, String fileName, String jasperFileName, String unitName,
			JRBeanCollectionDataSource jRMainTotalDS, String exportfileName, String LOGCN, String LOGDIDNM)
			throws JRException {
		logger.info("DKDK");
		HashMap<String, Object> param = new HashMap<String, Object>();
		NTPCUtil ntpcUtil = new NTPCUtil();
		GetDateUtil getDateUtil = new GetDateUtil();
		int nowYear = getDateUtil.getNowDate()[0];
		int nowMonth = getDateUtil.getNowDate()[1];
		param.put("STARTDATE", "");
		param.put("ENDDATE", "");
		param.put("UNITNAME", unitName);
		param.put("PRINTUNIT", "警政署資訊室作業設計科");
		param.put("PRINTTIME", NTPCUtil.dateFormat.format(new Date()));
		logger.info("DSIODHSPI");
		NTPCUtil.createExcelOtherFileName(contextPath, fileName, jasperFileName, param, jRMainTotalDS, exportfileName, LOGCN, LOGDIDNM);
		String contentDisposition = "filename=\"" + fileName + ".xls\"";
		logger.info("DRDR");
		return contentDisposition;
	}

	public static void main(String[] args) throws JRException {
		/*
		IL04B01Report iL04B01Report = new IL04B01Report();
		String whereCondition = "";
		String fileName = "testReport";
		try {
			iL04B01Report.IL04B01_01(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			iL04B01Report.IL04B01_02(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			iL04B01Report.IL04B01_03(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			iL04B01Report.IL04B01_04(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			iL04B01Report.IL04B01_05(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			iL04B01Report.IL04B01_06(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			iL04B01Report.IL04B01_07(whereCondition, fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\IL04B01Report.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */