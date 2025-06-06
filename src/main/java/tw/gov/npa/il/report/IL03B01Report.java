package tw.gov.npa.il.report;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.log4j.Logger;
import tw.gov.npa.il.dao.Iltb01Main;
import tw.gov.npa.il.e0db.dao.E0dtNpaunit;
import tw.gov.npa.il.e0db.myDao.MyE0dtNpaunitDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO;
import tw.gov.npa.il.myDao.MyIltb01MainDAO2;
import tw.gov.npa.il.report.data.IL03B01ReportData;
import tw.gov.npa.il.util.Constant;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL03B01Report {
  private static final Logger logger = Logger.getLogger(IL03B01Report.class);
  
  private NTPCUtil ntpcUtil = new NTPCUtil();
  
  private Constant constant = new Constant();
  
  MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
  
  MyIltb01MainDAO2 myIltb01MainDAO2 = new MyIltb01MainDAO2();
  
//  ResourceBundle rb = ResourceBundle.getBundle("config");
  
//  private String contextPath = this.rb.getString("ReportRoot").toString();

  private String contextPath = "D\\:\\IL2\\";
  
  private InputStream excelStream;
  
  private String contentDisposition;
  
  public String IL03B01P01_1P(String whereCondition, String LOGUID, String unitName, String printUnit) throws JRException {
    logger.debug("IL03B01P01_1P 轄區狀況統計資料-自由檢索報表  Execute");
    String fileName = "IL03B01Q01_1P";
    List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
    iltb01MainList = this.myIltb01MainDAO.getIL08B01P(whereCondition);
    System.out.println("01.iltb01MainList=" + iltb01MainList.size());
    JRBeanCollectionDataSource jRMainTotalDS = IL03B01ReportData.buildDataSourceIL03B01_3P(iltb01MainList);
    return IL03B01CommonPart(this.contextPath, fileName, unitName, LOGUID, jRMainTotalDS, printUnit, "01", iltb01MainList);
  }
  
  public String IL03B01P01_2P(String whereCondition, String LOGUID, String unitName, String printUnit) throws JRException {
    logger.debug("IL03B01P01_2P 轄區狀況統計資料-居留外僑統計表(按國籍及職業分) Execute");
    String fileName = "IL03B01Q01_2P";
    List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
    iltb01MainList = this.myIltb01MainDAO2.getIL03ByDBQueryA(whereCondition);
    System.out.println("02.iltb01MainList=" + iltb01MainList.size());
    JRBeanCollectionDataSource jRMainTotalDS = IL03B01ReportData.buildDataSourceIL03B01_2P(iltb01MainList);
    return IL03B01CommonPart(this.contextPath, fileName, unitName, LOGUID, jRMainTotalDS, printUnit, "02", iltb01MainList);
  }
  
  public String IL03B01P01_3P(String whereCondition, String LOGUID, String unitName, String printUnit) throws JRException {
    logger.debug("IL03B01P01_3P 轄區狀況統計資料-外籍男性幫傭名冊  Execute");
    String fileName = "IL03B01Q01_3P";
    List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
    iltb01MainList = this.myIltb01MainDAO2.getIL03ByDBQueryB(whereCondition);
    System.out.println("03.iltb01MainList=" + iltb01MainList.size());
    JRBeanCollectionDataSource jRMainTotalDS = IL03B01ReportData.buildDataSourceIL03B01_3P(iltb01MainList);
    return IL03B01CommonPart(this.contextPath, fileName, unitName, LOGUID, jRMainTotalDS, printUnit, "03", iltb01MainList);
  }
  
  public String IL03B01P01_4P(String whereCondition, String LOGUID, String unitName, String printUnit) throws JRException {
    logger.debug("IL03B01P01_4P 轄區狀況統計資料-東南亞女子與國人結婚名冊  Execute");
    String fileName = "IL03B01Q01_4P";
    List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
    iltb01MainList = this.myIltb01MainDAO2.getIL03ByDBQueryB(whereCondition);
    System.out.println("04.iltb01MainList=" + iltb01MainList.size());
    JRBeanCollectionDataSource jRMainTotalDS = IL03B01ReportData.buildDataSourceIL03B01_3P(iltb01MainList);
    return IL03B01CommonPart(this.contextPath, fileName, unitName, LOGUID, jRMainTotalDS, printUnit, "04", iltb01MainList);
  }
  
  public String IL03B01P01_5P(String whereCondition, String LOGUID, String unitName, String printUnit) throws JRException {
    logger.debug("IL03B01P01_5P 轄區狀況統計資料-行方不明外勞協尋名冊  Execute");
    String fileName = "IL03B01Q01_5P";
    List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
    iltb01MainList = this.myIltb01MainDAO2.getIL03ByDBQueryB(whereCondition);
    System.out.println("05.iltb01MainList=" + iltb01MainList.size());
    JRBeanCollectionDataSource jRMainTotalDS = IL03B01ReportData.buildDataSourceIL03B01_3P(iltb01MainList);
    return IL03B01CommonPart(this.contextPath, fileName, unitName, LOGUID, jRMainTotalDS, printUnit, "05", iltb01MainList);
  }
  
  public String IL03B01P01_6P(String whereCondition, String LOGUID, String unitName, String printUnit) throws JRException {
    logger.debug("IL03B01P01_6P 轄區狀況統計資料-逾期居留外僑名冊  Execute");
    String fileName = "IL03B01Q01_6P";
    List<Iltb01Main> iltb01MainList = new ArrayList<Iltb01Main>();
    iltb01MainList = this.myIltb01MainDAO2.getIL03ByDBQueryB(whereCondition);
    System.out.println("06.iltb01MainList=" + iltb01MainList.size());
    JRBeanCollectionDataSource jRMainTotalDS = IL03B01ReportData.buildDataSourceIL03B01_3P(iltb01MainList);
    return IL03B01CommonPart(String.valueOf(this.contextPath) + "/", fileName, unitName, LOGUID, jRMainTotalDS, printUnit, "06", iltb01MainList);
  }
  
  private String IL03B01CommonPart(String contextPath, String fileName, String unitName, String LOGUID, JRBeanCollectionDataSource jRMainTotalDS, String printUnit, String recordId, List<Iltb01Main> iltb01MainList) throws JRException {
    HashMap<String, Object> param = new HashMap<String, Object>();
    GetDateUtil getDateUtil = new GetDateUtil();
    int nowYear = getDateUtil.getNowDate()[0];
    int nowMonth = getDateUtil.getNowDate()[1];
    param.put("STARTDATE", "");
    param.put("ENDDATE", String.valueOf(nowYear) + "年" + nowMonth + "月");
    param.put("UNITNAME", unitName);
    param.put("PRINTUNIT", printUnit);
    param.put("STARTDATE", NTPCUtil.dateFormat.format(new Date()));
    param.put("PRINTTIME", NTPCUtil.dateFormat.format(new Date()));
    param.put("ALLSIZE", (new StringBuilder(String.valueOf(iltb01MainList.size()))).toString());
    this.excelStream = NTPCUtil.createExcelBy03Use(contextPath, fileName, param, jRMainTotalDS, LOGUID, recordId);
    this.contentDisposition = "filename=\"" + recordId + LOGUID + ".xls\"";
    return this.contentDisposition;
  }
  
  public static void main(String[] args) throws JRException {
    MyE0dtNpaunitDAO myE0dtNpaunitDAO = new MyE0dtNpaunitDAO();
    E0dtNpaunit e0dtNpaunit = new E0dtNpaunit();
    NTPCUtil ntpcUtil = new NTPCUtil();
    MyIltb01MainDAO myIltb01MainDAO = new MyIltb01MainDAO();
    MyIltb01MainDAO2 myIltb01MainDAO2 = new MyIltb01MainDAO2();
    IL03B01Report il03B01Report = new IL03B01Report();
    try {
      String ilPst = "AB000";
      String ilZipCode = "439";
      String LOGUID = "BLM26G63";
      String ilPstext = null;
      String ilPstextName = "";
      if (!"".equals(ilPstext));
      ilPstextName = "全部";
      e0dtNpaunit = myE0dtNpaunitDAO.findById(ilPst);
      String ilPstName = myE0dtNpaunitDAO.findById(ilPst).getE0FullSNm();
      String[] ilPstArr = ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(ilPst.trim());
      String[] ilZipCodeArr = ntpcUtil.getSplitZipCode(ilZipCode);
      String unitName = String.valueOf(myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm()) + "(郵遞區號:" + ilZipCode + ")" + ilPstextName;
      String printUnit = myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm();
      String whereCondition = "IL_PHQ='W000' AND IL_ARPZONE='106' AND IL_PSTEXT = '' AND IL_SEX = '1' and IL_ARCTO >= '2008-10-01 00:00:00' and IL_ARCTO <= '2013-10-22 00:00:00' and IL_APYDT >= '2008-10-02 00:00:00' and IL_APYDT <= '2013-10-23 00:00:00'";
      List<Iltb01Main> iltb01MainList = myIltb01MainDAO.getIL08B01P(whereCondition);
      System.out.println("1P Start..");
      System.out.println("list=" + iltb01MainList.size());
    } catch (Exception e) {
      e.printStackTrace();
    } 
    try {
      String ilPst = "AB000";
      String ilZipCode = "439";
      String LOGUID = "BLM26G63";
      String ilPstext = null;
      String ilPstextName = "";
      if (!"".equals(ilPstext));
      ilPstextName = "全部";
      e0dtNpaunit = myE0dtNpaunitDAO.findById(ilPst);
      String ilPstName = myE0dtNpaunitDAO.findById(ilPst).getE0FullSNm();
      String[] ilPstArr = ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(ilPst.trim());
      String[] ilZipCodeArr = ntpcUtil.getSplitZipCode(ilZipCode);
      String unitName = String.valueOf(myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm()) + "(郵遞區號:" + ilZipCode + ")" + ilPstextName;
      String printUnit = myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm();
      List<Iltb01Main> iltb01MainList = myIltb01MainDAO2.getIL03B01P01_2P(ilPstArr, ilZipCodeArr, ilPstext);
      System.out.println("2P Start..");
      System.out.println("list=" + iltb01MainList.size());
    } catch (Exception e) {
      e.printStackTrace();
    } 
    try {
      String ilPst = "AB000";
      String ilZipCode = "439";
      String LOGUID = "BLM26G63";
      String ilPstext = null;
      String ilPstextName = "";
      if (!"".equals(ilPstext));
      ilPstextName = "全部";
      e0dtNpaunit = myE0dtNpaunitDAO.findById(ilPst);
      String ilPstName = myE0dtNpaunitDAO.findById(ilPst).getE0FullSNm();
      String[] ilPstArr = ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(ilPst.trim());
      String[] ilZipCodeArr = ntpcUtil.getSplitZipCode(ilZipCode);
      String unitName = String.valueOf(myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm()) + "(郵遞區號:" + ilZipCode + ")" + ilPstextName;
      String printUnit = myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm();
      List<Iltb01Main> iltb01MainList = myIltb01MainDAO2.getIL03B01P01_3P(ilPstArr, ilZipCodeArr, ilPstext);
      System.out.println("3P Start..");
      System.out.println("list=" + iltb01MainList.size());
    } catch (Exception e) {
      e.printStackTrace();
    } 
    try {
      String ilPst = "AD000";
      String ilZipCode = "242";
      String LOGUID = "BLM26G63";
      String ilPstext = null;
      String ilPstextName = "";
      if (!"".equals(ilPstext));
      ilPstextName = "全部";
      e0dtNpaunit = myE0dtNpaunitDAO.findById(ilPst);
      String ilPstName = myE0dtNpaunitDAO.findById(ilPst).getE0FullSNm();
      String[] ilPstArr = ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(ilPst.trim());
      String[] ilZipCodeArr = ntpcUtil.getSplitZipCode(ilZipCode);
      String unitName = String.valueOf(myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm()) + "(郵遞區號:" + ilZipCode + ")" + ilPstextName;
      String printUnit = myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm();
      List<Iltb01Main> iltb01MainList = myIltb01MainDAO2.getIL03B01P01_4P(ilPstArr, ilZipCodeArr, ilPstext);
      System.out.println("4P Start..");
      System.out.println("list=" + iltb01MainList.size());
    } catch (Exception e) {
      e.printStackTrace();
    } 
    try {
      String ilPst = "AD000";
      String ilZipCode = "242";
      String LOGUID = "BLM26G63";
      String ilPstext = null;
      String ilPstextName = "";
      if (!"".equals(ilPstext));
      ilPstextName = "全部";
      e0dtNpaunit = myE0dtNpaunitDAO.findById(ilPst);
      String ilPstName = myE0dtNpaunitDAO.findById(ilPst).getE0FullSNm();
      String[] ilPstArr = ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(ilPst.trim());
      String[] ilZipCodeArr = ntpcUtil.getSplitZipCode(ilZipCode);
      String unitName = String.valueOf(myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm()) + "(郵遞區號:" + ilZipCode + ")" + ilPstextName;
      String printUnit = myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm();
      List<Iltb01Main> iltb01MainList = myIltb01MainDAO2.getIL03B01P01_5P(ilPstArr, ilZipCodeArr, ilPstext);
      System.out.println("5P Start..");
      System.out.println("list=" + iltb01MainList.size());
    } catch (Exception e) {
      e.printStackTrace();
    } 
    try {
      String ilPst = "AW000";
      String ilZipCode = "106";
      String LOGUID = "BLM26G63";
      String ilPstext = null;
      String ilPstextName = "";
      if (!"".equals(ilPstext));
      ilPstextName = "全部";
      e0dtNpaunit = myE0dtNpaunitDAO.findById(ilPst);
      String ilPstName = myE0dtNpaunitDAO.findById(ilPst).getE0FullSNm();
      String[] ilPstArr = ntpcUtil.getOlderE0UnitCdByNewE0UnitCd(ilPst.trim());
      String[] ilZipCodeArr = ntpcUtil.getSplitZipCode(ilZipCode);
      String unitName = String.valueOf(myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm()) + "(郵遞區號:" + ilZipCode + ")" + ilPstextName;
      String printUnit = myE0dtNpaunitDAO.findById(ilPstArr[0]).getE0FullSNm();
      List<Iltb01Main> iltb01MainList = myIltb01MainDAO2.getIL03B01P01_6P(ilPstArr, ilZipCodeArr, ilPstext);
      System.out.println("6P Start..");
      System.out.println("list=" + iltb01MainList.size());
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\IL03B01Report.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */