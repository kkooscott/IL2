package tw.gov.npa.il.report;

import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.report.data.IL04A01ReportData;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL04A01Report {
	private static final Logger logger = Logger.getLogger(IL04A01Report.class);

	//  ResourceBundle rb = ResourceBundle.getBundle("config");

	//  private String contextPath = this.rb.getString("FileRoot").toString();
	private String contextPath = "D:\\IL2\\file";

	public String getContextPath() {
		return this.contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public String IL04A01Q03A_01() throws JRException {
		String fileName = "IL04A01Q03A_01";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 永久居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺閩地區永久居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A01P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_02() throws JRException {
		String fileName = "IL04A01Q03A_02";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 永久居留外僑統計(按國籍及區域分) Execute");
		String unitName = "永久居留外僑統計(按國籍及區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A02P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07() throws JRException {
		String fileName = "IL04A01Q03A_07";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計（按國籍及職業分） Execute");
		String unitName = "現持有效居留證外僑統計（按國籍及職業分）";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_01() throws JRException {
		String fileName = "IL04A01Q03A_07_01";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計（按國籍及職業分） Execute");
		String unitName = "現持有效居留證外僑統計（按國籍及職業分）";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_01();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_02() throws JRException {
		String fileName = "IL04A01Q03A_07_02";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "臺灣地區現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_02();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_03() throws JRException {
		String fileName = "IL04A01Q03A_07_03";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "臺灣省現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_03();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_04() throws JRException {
		String fileName = "IL04A01Q03A_07_04";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "福建省現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_04();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_05() throws JRException {
		String fileName = "IL04A01Q03A_07_05";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "臺北市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_05();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_06() throws JRException {
		String fileName = "IL04A01Q03A_07_06";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "新北市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_06();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_07() throws JRException {
		String fileName = "IL04A01Q03A_07_07";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "台中市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_07();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_08() throws JRException {
		String fileName = "IL04A01Q03A_07_08";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "台南市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_08();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_09() throws JRException {
		String fileName = "IL04A01Q03A_07_09";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "桃園市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_09();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_10() throws JRException {
		String fileName = "IL04A01Q03A_07_10";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "新竹市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_10();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_11() throws JRException {
		String fileName = "IL04A01Q03A_07_11";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "新竹縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_11();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_12() throws JRException {
		String fileName = "IL04A01Q03A_07_12";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "苗栗縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_12();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_13() throws JRException {
		String fileName = "IL04A01Q03A_07_13";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "彰化縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_13();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_14() throws JRException {
		String fileName = "IL04A01Q03A_07_14";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "南投縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_14();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_15() throws JRException {
		String fileName = "IL04A01Q03A_07_15";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "雲林縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_15();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_16() throws JRException {
		String fileName = "IL04A01Q03A_07_16";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "嘉義市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_16();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_17() throws JRException {
		String fileName = "IL04A01Q03A_07_17";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "嘉義縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_17();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_18() throws JRException {
		String fileName = "IL04A01Q03A_07_18";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "屏東縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_18();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_19() throws JRException {
		String fileName = "IL04A01Q03A_07_19";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "台東縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_19();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_20() throws JRException {
		String fileName = "IL04A01Q03A_07_20";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "花蓮縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_20();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_21() throws JRException {
		String fileName = "IL04A01Q03A_07_21";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "宜蘭縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_21();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_22() throws JRException {
		String fileName = "IL04A01Q03A_07_22";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "澎湖縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_22();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_23() throws JRException {
		String fileName = "IL04A01Q03A_07_23";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "金門縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_23();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_24() throws JRException {
		String fileName = "IL04A01Q03A_07_24";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "連江縣現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_24();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_25() throws JRException {
		String fileName = "IL04A01Q03A_07_25";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "基隆市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_25();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_26() throws JRException {
		String fileName = "IL04A01Q03A_07_26";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "高雄市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_26();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_07_27() throws JRException {
		String fileName = "IL04A01Q03A_07_27";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按國籍及職業分) Execute");
		String unitName = "臺閩各縣市現持有效居留證外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P_27();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_08() throws JRException {
		String fileName = "IL04A01Q03A_08";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計（按國籍及區域分） Execute");
		String unitName = "現持有效居留證外僑統計（按國籍及區域分）";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A08P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_09() throws JRException {
		String fileName = "IL04A01Q03A_09";
		String jasperFileName = "IL04_r1c4";
		logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按居留目的及區域分) Execute");
		String unitName = "現持有效居留證外僑統計(按居留目的及區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A09P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_10() throws JRException {
		String fileName = "IL04A01Q03A_10";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺閩地區居留外僑統計（按國籍及職業分） Execute");
		String unitName = "臺閩地區居留外僑統計（按國籍及職業分）";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A10P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_11() throws JRException {
		String fileName = "IL04A01Q03A_11";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺灣地區居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺灣地區居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A11P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_12() throws JRException {
		String fileName = "IL04A01Q03A_12";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺灣省居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺灣省居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A12P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_13() throws JRException {
		String fileName = "IL04A01Q03A_13";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 福建省居留外僑統計(按國籍及職業分) Execute");
		String unitName = "福建省居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A13P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14() throws JRException {
		String fileName = "IL04A01Q03A_14";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺北市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺北市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_2() throws JRException {
		String fileName = "IL04A01Q03A_14_2";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 新北市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "新北市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_2P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_3() throws JRException {
		String fileName = "IL04A01Q03A_14_3";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺中市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺中市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_3P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_4() throws JRException {
		String fileName = "IL04A01Q03A_14_4";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺南市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_4P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_5() throws JRException {
		String fileName = "IL04A01Q03A_14_5";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "桃園市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_5P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_6() throws JRException {
		String fileName = "IL04A01Q03A_14_6";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "新竹市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_6P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_7() throws JRException {
		String fileName = "IL04A01Q03A_14_7";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "新竹縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_7P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_8() throws JRException {
		String fileName = "IL04A01Q03A_14_8";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "苗栗縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_8P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_9() throws JRException {
		String fileName = "IL04A01Q03A_14_9";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "彰化縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_9P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_10() throws JRException {
		String fileName = "IL04A01Q03A_14_10";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "南投縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_10P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_11() throws JRException {
		String fileName = "IL04A01Q03A_14_11";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "雲林縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_11P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_12() throws JRException {
		String fileName = "IL04A01Q03A_14_12";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "嘉義市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_12P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_13() throws JRException {
		String fileName = "IL04A01Q03A_14_13";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "嘉義縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_13P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_14() throws JRException {
		String fileName = "IL04A01Q03A_14_14";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "屏東縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_14P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_15() throws JRException {
		String fileName = "IL04A01Q03A_14_15";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "台東縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_15P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_16() throws JRException {
		String fileName = "IL04A01Q03A_14_16";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "花蓮縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_16P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_17() throws JRException {
		String fileName = "IL04A01Q03A_14_17";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "宜蘭縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_17P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_18() throws JRException {
		String fileName = "IL04A01Q03A_14_18";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "澎湖縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_18P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_19() throws JRException {
		String fileName = "IL04A01Q03A_14_19";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "金門縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_19P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_20() throws JRException {
		String fileName = "IL04A01Q03A_14_20";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "連江縣居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_20P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_14_21() throws JRException {
		String fileName = "IL04A01Q03A_14_21";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "基隆市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_21P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_15() throws JRException {
		String fileName = "IL04A01Q03A_15";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 高雄市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "高雄市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A15P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_16() throws JRException {
		String fileName = "IL04A01Q03A_16";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 臺閩各縣市居留外僑統計(按國籍及職業分) Execute");
		String unitName = "臺閩各縣市居留外僑統計(按國籍及職業分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A16P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_17() throws JRException {
		String fileName = "IL04A01Q03A_17";
		String jasperFileName = "IL04_r1c4";
		logger.debug("IL04A01Q03A 居留外僑統計(按居留目的及區域分) Execute");
		String unitName = "居留外僑統計(按居留目的及區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A17P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_18() throws JRException {
		String fileName = "IL04A01Q03A_18";
		String jasperFileName = "IL04_r3c2";
		logger.debug("IL04A01Q03A 居留外僑統計(按國籍及居留目的分) Execute");
		String unitName = "居留外僑統計(按國籍及居留目的分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A18P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_19() throws JRException {
		String fileName = "IL04A01Q03A_19";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 居留外僑統計(按國籍及區域分) Execute");
		String unitName = "居留外僑統計(按國籍及區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A19P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_29() throws JRException {
		String fileName = "IL04A01Q03A_29";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 居留外僑統計(按職業及區域別分) Execute");
		String unitName = "居留外僑統計(按職業及區域別分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A29P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_22() throws JRException {
		String fileName = "IL04A01Q03A_22";
		String jasperFileName = "IL04_r2c1";
		logger.debug("IL04A01Q03A 臺灣省行方不明外勞人數統計 Execute");
		String unitName = "臺灣省行方不明外勞人數統計";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A22P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_23() throws JRException {
		String fileName = "IL04A01Q03A_23";
		String jasperFileName = "IL04_r2c1";
		logger.debug("IL04A01Q03A 臺閩地區行方不明外勞人數統計 Execute");
		String unitName = "臺閩地區行方不明外勞人數統計";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A23P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_27() throws JRException {
		String fileName = "IL04A01Q03A_27";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效外僑居留證之外籍配偶統計(按國籍與區域分) Execute");
		String unitName = "現持有效外僑居留證之外籍配偶統計(按國籍與區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A27P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_30() throws JRException {
		String fileName = "IL04A01Q03A_30";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 現持有效外僑居留證之外籍配偶統計(按證件與區域分) Execute");
		String unitName = "現持有效外僑居留證之外籍配偶統計(按證件與區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A30P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_28() throws JRException {
		String fileName = "IL04A01Q03A_28";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 外籍配偶居留統計(按國籍及區域分) Execute");
		String unitName = "外籍配偶居留統計(按國籍及區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A28P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_33() throws JRException {
		String fileName = "IL04A01Q03A_33";
		String jasperFileName = "IL04_r1c2";
		logger.debug("IL04A01Q03A 外籍配偶居留統計(按證件與區域分) Execute");
		String unitName = "外籍配偶統計(按證件與區域分)";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A33P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_31() throws JRException {
		String fileName = "IL04A01Q03A_31";
		String jasperFileName = "IL04_r2c1";
		logger.debug("IL04A01Q03A 臺灣省行方不明外僑人數統計 Execute");
		String unitName = "臺灣省行方不明外僑人數統計";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A31P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	public String IL04A01Q03A_32() throws JRException {
		String fileName = "IL04A01Q03A_32";
		String jasperFileName = "IL04_r2c1";
		logger.debug("IL04A01Q03A 臺閩地區行方不明外僑人數統計 Execute");
		String unitName = "臺閩地區行方不明外僑人數統計";
		JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A32P();
		return IL04A01Q03ACommonPart(this.contextPath, fileName, jasperFileName, unitName, jRMainTotalDS);
	}

	private String IL04A01Q03ACommonPart(String contextPath, String fileName, String jasperFileName, String unitName,
			JRBeanCollectionDataSource jRMainTotalDS) throws JRException {
		HashMap<String, Object> param = new HashMap<String, Object>();
		NTPCUtil ntpcUtil = new NTPCUtil();
		GetDateUtil getDateUtil = new GetDateUtil();
		int nowYear = getDateUtil.getNowDate()[0];
		int nowMonth = getDateUtil.getNowDate()[1];
		param.put("STARTDATE", "");
		param.put("ENDDATE", nowYear + "年" + nowMonth + "月止");
		param.put("UNITNAME", unitName);
		param.put("PRINTUNIT", "警政署資訊室作業設計科");
		param.put("PRINTTIME", NTPCUtil.dateFormat.format(new Date()));
		NTPCUtil.createExcel(contextPath, fileName, jasperFileName, param, jRMainTotalDS);
		String contentDisposition = "filename=\"" + ntpcUtil.appendYearMonthString(fileName) + ".xls\"";
		return contentDisposition;
	}

	public static void main(String[] args) throws JRException {
	
		//202505 jasper problem
	if ("true".equalsIgnoreCase(System.getProperty("skipJasperStartup"))) {
        System.out.println("⚠️ [JASPER] IL04A01Report.main() skipped due to -DskipJasperStartup=true");
        return;
    }
		//202505 jasper problem
//		IL04A01Report iL04A01Report = new IL04A01Report();
//		try {
//			iL04A01Report.IL04A01Q03A_01();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_02();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_01();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_02();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_03();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_04();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_05();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_06();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_07();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_08();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_09();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_10();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_11();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_12();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_13();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_14();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_15();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_16();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_17();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_18();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_19();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_20();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_21();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_22();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_23();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_24();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_25();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_07_26();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_08();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_09();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_10();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_11();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_12();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_13();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_2();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_3();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_4();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_5();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_6();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_7();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_8();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_9();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_10();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_11();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_12();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_13();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_14();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_15();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_16();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_17();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_18();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_19();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_20();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_14_21();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_15();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_16();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_17();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_18();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_19();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_29();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_22();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_23();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_27();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_30();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_28();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_33();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_31();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			iL04A01Report.IL04A01Q03A_32();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}

/*
 * Location: D:\Qian\IL
 * 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\IL04A01Report.
 * class Java compiler version: 5 (49.0) JD-Core Version: 1.1.3
 */