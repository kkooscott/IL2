package tw.gov.npa.il.report;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import net.sf.jasperreports.engine.JRException;
import org.apache.log4j.Logger;
import tw.gov.npa.il.report.data.IL04C01ReportData;
import tw.gov.npa.il.util.GetDateUtil;
import tw.gov.npa.il.util.NTPCUtil;

public class IL04C01Report {
  private static final Logger logger = Logger.getLogger(IL04C01Report.class);

  //  ResourceBundle rb = ResourceBundle.getBundle("config");

  //  private String contextPath = this.rb.getString("FileRoot").toString();
  private String contextPath = "D:\\IL2\\file";
  
  public String getContextPath() {
    return this.contextPath;
  }
  
  public void setContextPath(String contextPath) {
    this.contextPath = contextPath;
  }
  
  public String IL04C01_01(String whereCondition, String show, String exportfileName) throws JRException, FileNotFoundException {
    String fileName = "IL04C01_01";
    logger.info("IL04C01 自由檢索-無固定欄項(txt) Execute");
    String unitName = "自由檢索-無固定欄項(txt)";
    logger.info("build list...");
    logger.info("whereCondition=" + whereCondition);
    logger.info("show=" + show);
    logger.info("data=" + whereCondition +"----->"+ show+ "----->"+ exportfileName);
    List<String> il04c01Data = IL04C01ReportData.buildDataSourceIL08C01P(whereCondition, show);
    HashMap<String, Object> param = new HashMap<String, Object>();
    NTPCUtil ntpcUtil = new NTPCUtil();
    GetDateUtil getDateUtil = new GetDateUtil();
    int nowYear = getDateUtil.getNowDate()[0];
    int nowMonth = getDateUtil.getNowDate()[1];
    logger.info("put map...");
    param.put("STARTDATE", "");
    param.put("ENDDATE", "");
    param.put("UNITNAME", unitName);
    param.put("PRINTUNIT", "警政署資訊室作業設計科");
    param.put("PRINTTIME", NTPCUtil.dateFormat.format(new Date()));
    logger.info("write file...");
    String contentDisposition = "filename=\"" + exportfileName + ".txt\"";
    PrintWriter pw = new PrintWriter(new File(this.contextPath + File.separator + "report" + File.separator + exportfileName + ".txt"));
    for (String s : il04c01Data)
      pw.println(s); 
    pw.flush();
    pw.close();
    return contentDisposition;
  }
  
  public String IL04C01_01_csv(String whereCondition, String show, String exportfileName) throws JRException, FileNotFoundException {
    String fileName = "IL04C01_01";
    logger.debug("IL04C01 自由檢索-無固定欄項(csv) Execute");
    String unitName = "自由檢索-無固定欄項(csv)";
    List<String> il04c01Data = IL04C01ReportData.buildDataSourceIL08C01P_csv(whereCondition, show);
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
    String contentDisposition = "filename=\"" + exportfileName + ".csv\"";
    PrintWriter pw = new PrintWriter(new File(this.contextPath + File.separator + "report" + File.separator + exportfileName + ".csv"));
    for (String s : il04c01Data)
      pw.println(s); 
    pw.flush();
    pw.close();
    return contentDisposition;
  }
  
  public static void main(String[] args) throws JRException {
    IL04C01Report iL04C01Report = new IL04C01Report();
    String whereCondition = "";
    String show = ",1,6,8,10,12,14,16,18,20,25,30,35,";
    try {
      iL04C01Report.IL04C01_01(whereCondition, show, "20BLM26G63");
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
}


/* Location:              D:\Qian\IL 居留系統\20200529取得最新程式\IL2\WEB-INF\classes\!\tw\gov\npa\il\report\IL04C01Report.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */