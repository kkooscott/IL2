package tw.gov.npa.il.report;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.report.data.IL04A01ReportData;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL04A01Report_old {
  private static final Logger logger = Logger.getLogger(IL04A01Report_old.class);
  
  private NTPCUtil ntpcUtil = new NTPCUtil();
  
  private IL04A01ReportData iL04A01ReportData = new IL04A01ReportData();

  //  ResourceBundle rb = ResourceBundle.getBundle("config");

//  private String contextPath = this.rb.getString("ReportRoot").toString();

  private String contextPath = "D\\:\\IL2\\";
  
  private InputStream excelStream;
  
  private String contentDisposition;
  
  public String IL04A01Q03A_01(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 永久居留外僑統計(按國籍及職業分) Execute");
    String unitName = "永久居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A01P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_02(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 永久居留外僑統計(按國籍及區域分) Execute");
    String unitName = "永久居留外僑統計(按國籍及區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A02P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_07(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 現持有效居留證外僑統計（按國籍及職業分） Execute");
    String unitName = "現持有效居留證外僑統計（按國籍及職業分）";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A07P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_08(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 現持有效居留證外僑統計（按國籍及區域分） Execute");
    String unitName = "現持有效居留證外僑統計（按國籍及區域分）";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A08P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_09(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 現持有效居留證外僑統計(按居留目的及區域分) Execute");
    String unitName = "現持有效居留證外僑統計(按居留目的及區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A09P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_10(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺閩地區居留外僑統計（按國籍及職業分） Execute");
    String unitName = "臺閩地區居留外僑統計（按國籍及職業分）";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A10P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_11(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺灣地區居留外僑統計(按國籍及職業分) Execute");
    String unitName = "臺灣地區居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A11P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_12(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺灣省居留外僑統計(按國籍及職業分) Execute");
    String unitName = "臺灣省居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A12P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_13(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 福建省居留外僑統計(按國籍及職業分) Execute");
    String unitName = "福建省居留外僑統計(按國籍及職業分))";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A13P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_14(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺北市居留外僑統計(按國籍及職業分) Execute");
    String unitName = "臺北市居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_14_2(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 新北市居留外僑統計(按國籍及職業分) Execute");
    String unitName = "新北市居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_2P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_14_3(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺中市居留外僑統計(按國籍及職業分) Execute");
    String unitName = "臺中市居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_3P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_14_4(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺南市居留外僑統計(按國籍及職業分) Execute");
    String unitName = "臺南市居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A14_4P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_15(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 高雄市居留外僑統計(按國籍及職業分) Execute");
    String unitName = "高雄市居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A15P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_16(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺閩各縣市居留外僑統計(按國籍及職業分) Execute");
    String unitName = "臺閩各縣市居留外僑統計(按國籍及職業分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A16P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_17(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 居留外僑統計(按居留目的及區域分) Execute");
    String unitName = "居留外僑統計(按居留目的及區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A17P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_18(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 居留外僑統計(按國籍及居留目的分) Execute");
    String unitName = "居留外僑統計(按國籍及居留目的分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A18P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_19(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 居留外僑統計(按國籍及區域分) Execute");
    String unitName = "居留外僑統計(按國籍及區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A19P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_29(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 居留外僑統計(按職業及區域別分) Execute");
    String unitName = "居留外僑統計(按職業及區域別分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A29P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_22(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺灣省行方不明外勞人數統計 Execute");
    String unitName = "臺灣省行方不明外勞人數統計";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A22P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_23(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺閩地區行方不明外勞人數統計 Execute");
    String unitName = "臺閩地區行方不明外勞人數統計";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A23P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_27(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 現持有效外僑居留證之外籍配偶統計(按國籍與區域分) Execute");
    String unitName = "現持有效外僑居留證之外籍配偶統計(按國籍與區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A27P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_30(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 現持有效外僑居留證之外籍配偶統計(按證件與區域分) Execute");
    String unitName = "現持有效外僑居留證之外籍配偶統計(按證件與區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A30P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_28(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 外籍配偶居留統計(按國籍及區域分) Execute");
    String unitName = "外籍配偶居留統計(按國籍及區域分)";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A29P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_31(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺灣省行方不明外僑人數統計 Execute");
    String unitName = "臺灣省行方不明外僑人數統計";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A31P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  public String IL04A01Q03A_32(String contextPath, String fileName) throws JRException {
    logger.debug("IL04A01Q03A 臺閩地區行方不明外僑人數統計 Execute");
    String unitName = "臺閩地區行方不明外僑人數統計";
    JRBeanCollectionDataSource jRMainTotalDS = IL04A01ReportData.buildDataSourceIL08A32P();
    return IL04A01Q03ACommonPart(contextPath, fileName, unitName, jRMainTotalDS);
  }
  
  private String IL04A01Q03ACommonPart(String contextPath, String fileName, String unitName, JRBeanCollectionDataSource jRMainTotalDS) throws JRException {
    HashMap<String, Object> param = new HashMap<String, Object>();
    GetDateUtil getDateUtil = new GetDateUtil();
    int nowYear = getDateUtil.getNowDate()[0];
    int nowMonth = getDateUtil.getNowDate()[1];
    param.put("STARTDATE", "");
    param.put("ENDDATE", String.valueOf(nowYear) + "年" + nowMonth + "月");
    param.put("UNITNAME", unitName);
    param.put("PRINTUNIT", "警政署資訊室作業設計科");
    param.put("PRINTTIME", NTPCUtil.dateFormat.format(new Date()));
    this.excelStream = NTPCUtil.createExcel(contextPath, fileName, param, jRMainTotalDS);
    this.contentDisposition = "filename=\"" + this.ntpcUtil.appendYearMonthString(fileName) + ".xls\"";
    return this.contentDisposition;
  }
  
  public static void main(String[] args) throws JRException {
    MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    List<Iltb01Main> iltb01MainList = myIltb01MainDAO.getIL08A01P();
    IL04A01Report_old iL04A01Report = new IL04A01Report_old();
    String fileName = "IL04A01Q03A_01";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_01(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_02";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_02(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_07";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_07(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_08";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_08(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_09";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_09(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_10";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_10(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_11";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_11(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_12";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_12(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_13";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_13(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_14";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_14(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_14_2";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_14_2(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_14_3";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_14_3(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_14_4";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_14_4(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_15";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_15(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_16";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_16(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_17";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_17(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_18";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_18(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_19";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_19(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_29";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_29(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_22";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_22(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_23";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_23(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_27";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_27(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_30";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_30(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_28";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_28(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_31";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_31(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
    fileName = "IL04A01Q03A_32";
    try {
      System.out.println(String.valueOf(fileName) + " Start..");
      iL04A01Report.IL04A01Q03A_32(iL04A01Report.contextPath, fileName);
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\IL04A01Report_old.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */